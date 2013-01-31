package android.hispano.ejemplos.ticketmonster.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * Representa el estado de una asignación de entrada en una sección, para una actuación en específico.
 * 
 * El bloqueo Optimista asegura que dos tickets no se vendan en la misma fila. Añadiendo un anotación
 * @Version habilitamos el bloqueo optimista.
 * 
 * La actuación y la sección forman el ID natural de esta entidad, y debe ser único. JPA nos obliga a 
 * utilizar la limitación de nivel de clase @Table.
 * 
 * @author Marius Bogoevici
 * @author Pete Muir
 * @translate Javier Hdez
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "id_actuacion", "id_seccion" }))
public class AsignacionSeccion {

    /* Declaración de campos */

    /**
     * El ID sintético del objeto.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    /**
     * La versión utilizada para el bloqueo optimista de esta entidad.
     * 
     * Añadiendo este campo habilitamos el bloqueo optimista. Como no accedemos a este campo en la aplicación,
     * necesitaremos eliminar la advertencia que el compilador Java nos da al no utilizar este campo!
     * warnings the java compiler gives us about not using the field!
     */
    @SuppressWarnings("unused")
    @Version
    private long version;

    /**
     * El espectáculo al cual está relacionado esta asignación. El mapeo JPA @ManyToOne establece esta relación.
     * 
     * El espectáculo debe ser especificado, así que añadiremos la limitación Bean Validation @NotNull
     */
    @ManyToOne
    @NotNull
    private Actuacion actuacion;

    /**
     * La sección a la cual está relacionada esta asignación. El mapeo JPA @ManyToOne establece esta relación.
     * 
     * La sección debe ser especificada, así que añadiremos la limitación Bean Validation @NotNull
     */
    @ManyToOne
    @NotNull
    private Seccion seccion;

    /**
     * Una matriz de dos dimensiones de asientos asignados en una sección, representado por un array bi-dimensional.
     * 
     * Un array bi-dimensional no tiene una asignación de RDBMS natural, así que simplemente almacenaremos 
     * este objeto binario en la base de datos, un enfoque el cual no requiere lógica de mapeo adicional. Cualquier
     * análisis de que asientos con una sección asignada se hace en la lógica de negocio, a continuación,
     * no por el RDBMS.
     * 
     * @Lob instruye a JPA a mapear a este gran objeto en la base de datos.
     */
    @Lob
    private boolean asignado[][];

    /**
     *     El número de asientos ocuapdos en esta sección. Se actualiza cada vez que las entradas se venden
     *     o se cancelan.
     *
     *     Este campo contiene un resumen de la información encontrada el campo asignado, y esto está destinado
     *     a ser utilizado solamente con fines analíticos.
     */
    private int numeroOcupados = 0;

    /**
     * Constructor para la persistencia
     */
    public AsignacionSeccion() {
    }

    public AsignacionSeccion(Actuacion actuacion, Seccion seccion) {
        this.actuacion = actuacion;
        this.seccion = seccion;
        this.asignado = new boolean[seccion.getNumeroDeFilas()][seccion.getAforoFila()];
    }

    /**
     * Método de devolución de llamada @PostLoad que inicializa la tabla de asignación si
     * no se llena la entidad.
     */
    @PostLoad
    void initialize() {
    	if (this.asignado == null) {
    		this.asignado = new boolean[this.seccion.getNumeroDeFilas()][this.seccion.getAforoFila()];
    	}
    }

    /**
     * Comprueba si un asiento en particular está asignado en esta sección para esta actuación.
     * 
     * @return true si el asiento está asignado, de lo contrario false.
     */
    public boolean isAsignado(Asiento a) {
        // Examina la matrix de la asignación, utilizando el número de fila y asiento como índice.
        return asignado[a.getnumeroFila() - 1][a.getNumero() - 1];
    }

    /**
     * Asigna el númeor de asientos especificados con esta sección para esta actaución. Opcionalmente
     * asignados en un bloque contiguo.
     * 
     * @param numeroAsiento el número de asientos para asignar
     * @param contiguo si los asientos deben ser asignados en un bloque contiguo o no
     * @return los asientos asignados
     */
    public List<Asiento> repartoAsientos(int numeroAsiento, boolean contiguo) {
        // La lista de asientos asignados
        List<Asiento> asientos = new ArrayList<Asiento>();

        // El algoritmo de asignación del asiento comienza iterando a través de las filas de esta sección
        for (int numeroFila = 0; numeroFila < seccion.getNumeroDeFilas(); numeroFila++) {

            if (contiguo) {
                // Identifica el primer bloque de asientos libres del tamaño de la solicitud
                int asientoInicio = findFreeGapStart(numeroFila, 0, numeroAsiento);
                // Si un bloque lo suficientemente grande de asientos está disponible
                if (asientoInicio >= 0) {
                    // Crea la lista de asientos asignados a devolver
                    for (int i = 1; i <= numeroAsiento; i++) {
                        asientos.add(new Asiento(seccion, numeroFila + 1, asientoInicio + i));
                    }
                    // Los asientos se reparten ahora, así que no podemos parar de comprobar filas
                    break;
                }
            } else {
                // Como no estamos asignando contiguamente, asignamos cada asiento necesario, de uno en uno.
                int asientoInicio = findFreeGapStart(numeroFila, 0, 1);
                // Si es encontrado un asiento
                if (asientoInicio >= 0) {
                    do {
                        // Crea el asiento a devolver al usuario
                        asientos.add(new Asiento(seccion, numeroFila + 1, asientoInicio + 1));
                        // Encuentra el siguiente asiento libre en la fila
                        asientoInicio = findFreeGapStart(numeroFila, asientoInicio, 1);
                    } while (asientoInicio >= 0 && asientos.size() < numeroAsiento);
                    if (asientos.size() == numeroAsiento) {
                        break;
                    }
                }
            }
        }
        // Comprobación sencilla para asegurar que en realidad podemos asignar el número de asientos necesarios
        if (asientos.size() == numeroAsiento) {
            return asientos;
        } else {
            return Collections.emptyList();
        }
    }

    public void marcaOcupado(List<Asiento> asientos) {
        for (Asiento asiento : asientos) {
            asignado(asiento.getnumeroFila()-1, asiento.getNumero()-1, 1);
        }
    }

    /**
     * Método Helper que puede localizar bloques de asientos
     * 
     * @param fila El número de fila a comprobar
     * @param asientoInicio El asiento para iniciar la fila
     * @param size El tamaño de el bloque a localizar
     */
    private int findFreeGapStart(int fila, int asientoInicio, int size) {

        // Un array de los asientos ocupados en la fila
        boolean[] ocupado = asignado[fila];
        int inicioCandidato = -1;

        // Itera sobre los asientos, y localiza el primer bloque de asientos
        for (int i = asientoInicio; i < ocupado.length; i++) {
            // si el asiento no está asignado
            if (!ocupado[i]) {
                // entonces establece este como un posible inicio
                if (inicioCandidato == -1) {
                    inicioCandidato = i;
                }
                // Si hemos contados los suficientes asientos desde el posible inicio, entonces
                // hemos terminado.
                if ((size == (i - inicioCandidato + 1))) {
                    return inicioCandidato;
                }
            } else {
                inicioCandidato = -1;
            }
        }
        return -1;
    }

    /**
     * Método Helper para asignar un bloque específico de asientos
     * 
     * @param fila, la fila en la que el asiento debería ser asignado
     * @param inicio el número de asiento desde donde se inicia la asignación
     * @param size el tamaño del bloque a asignar
     * @throws ExceptionAsignacionAsiento si es inferior a 1 asiento se asignará
     * @throws ExceptionAsignacionAsiento si el primer asiento a asignar es mayor que el número de asientos en la fila
     * @throws ExceptionAsignacionAsiento si el último asiento a asignar es mayor que el número de asientos en la fila
     * @throws ExceptionAsignacionAsiento si los asientoas ya están ocupados
     */
    private void asignado(int fila, int inicio, int size) throws ExceptionAsignacionAsiento {
        boolean[] ocupado = asignado[fila];
        if (size <= 0) {
            throw new ExceptionAsignacionAsiento("El número de asientos debe ser mayor que cero");
        }
        if (inicio < 0 || inicio >= ocupado.length) {
            throw new ExceptionAsignacionAsiento("El número de Asiento deber entre 1 y " + ocupado.length);
        }
        if ((inicio + size) > ocupado.length) {
            throw new ExceptionAsignacionAsiento("No puedo asignar asientos por encima de la capacidad de la fila");
        }
        // Comprueba que los asientos no estén ya ocupados
        for (int i = inicio; i < (inicio + size); i++) {
            if (ocupado[i]) {
                throw new ExceptionAsignacionAsiento("Se han encontrados asientos ocupados en el bloque solicitado");
            }
        }

        // Ahora que sabemos que podemos asignar los asientos, los ponemos ocupado en la matriz de asignacion
        for (int i = inicio; i < (inicio + size); i++) {
            ocupado[i] = true;
            numeroOcupados++;
        }

    }

    /**
     * Desasigna un asiento en esta sección para este espectáculo
     *
     * @param asiento los asientos que necesitan ser desasignados
     */
    public void desasignar(Asiento asiento) {
        if (!isAsignado(asiento)) {
            throw new ExceptionAsignacionAsiento("Tratando de cancelar el reparto de un asiento asignado!");
        }
        this.asignado[asiento.getNumero()-1][asiento.getNumero()-1] = false;
        numeroOcupados --;
    }

    /* Boilerplate getters y setters */

    public int getNumeroOcupados() {
        return numeroOcupados;
    }

    public Actuacion getActuacion() {
        return actuacion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public Long getId() {
        return id;
    }

}