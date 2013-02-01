package android.hispano.ejemplos.ticketmonster.service;

import static android.hispano.ejemplos.ticketmonster.model.TipoMultimedia.IMAGE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import android.hispano.ejemplos.ticketmonster.model.ElementoMultimedia;
import android.hispano.ejemplos.ticketmonster.model.TipoMultimedia;
import android.hispano.ejemplos.ticketmonster.util.Base64;
import android.hispano.ejemplos.ticketmonster.util.Reflections;

/**
 * El gestor multimedia es el responsable de tomar un elemento multimedia, y devuelve la URL de la versión en caché (si
 * la aplicación no puede cargar un elemento desde la URL), o la URL original.
 * 
 * El gestor multimedia también almacena en caché los elementos multimedia de forma transparente en la primera carga.
 * 
 * Las URL calculadas son almacendas en caché durante la duración de la solicitud. Esto proporciona un buen equilibrio
 * entre el espacio consumido en memoria, y el tiempo de cómputo.
 * 
 * @author Pete Muir
 * @translate Javier Hdez 
 */
@Named
@RequestScoped
public class GestorMultimedia {

    /**
     * Localiza el directorio temporal para la máquina
     */
    private static final File tmpDir;

    static {
        tmpDir = new File(System.getProperty("java.io.tmpdir"), "android.hispano.ejemplos.ticketmonster");
        if (tmpDir.exists()) {
            if (tmpDir.isFile())
                throw new IllegalStateException(tmpDir.getAbsolutePath() + " ya existe, y es un archivo. Elimínalo.");
        } else {
            tmpDir.mkdir();
        }
    }

    /**
     * Una petición de elementos multimedia almacenada en caché.
     */
    private final Map<ElementoMultimedia, PathMultimedia> cache;

    public GestorMultimedia() {

        this.cache = new HashMap<ElementoMultimedia, PathMultimedia>();
    }

    /**
     * Carga un archivo en caché por nombre
     * 
     * @param nombreArchivo
     * @return
     */
    public File getCachedFile(String nombreArchivo) {
        return new File(tmpDir, nombreArchivo);
    }

    /**
     * Obtiene la URL del elemento multimedia. Si la URL ya ha sido calculada en esta petición, se buscará en la
     * caché de petición, de lo contrario se computará, y se colocará en la caché de petición.
     */
    public PathMultimedia getPath(ElementoMultimedia elemenentoMultimedia) {
        if (cache.containsKey(elemenentoMultimedia)) {
            return cache.get(elemenentoMultimedia);
        } else {
            PathMultimedia pathMultimedia = createPath(elemenentoMultimedia);
            cache.put(elemenentoMultimedia, pathMultimedia);
            return pathMultimedia;
        }
    }

    /**
     * Calcula la URL del elemento multimedia. Si el elemento multimedia no es cacheable, entonces, siempre que 
     * el recurso pueda ser cargado, se devuelve la URL original. Si el recurso no está disponible, entonces se 
     * sustituye la imagen por un marcador. Si el elemento multimedia es cacheable, primero se almacena en caché en 
     */
    private PathMultimedia createPath(ElementoMultimedia elementoMultimedia) {
        if (!elementoMultimedia.getTipoMultimedia().isCacheable()) {
            if (compruebaDisponibilidadRecurso(elementoMultimedia)) {
                return new PathMultimedia(elementoMultimedia.getUrl(), false, elementoMultimedia.getTipoMultimedia());
            } else {
                return creaCacheMultimedia(Reflections.getResource("no_disponible.jpg").toExternalForm(), IMAGE);
            }
        } else {
            return createCachedMedia(elementoMultimedia);
        }
    }

    /**
     * Comprueba si un elemento multimedia puede ser cargado desde la URL,
     * utilizando las clases del JDK URLConnection.
     */
    private boolean compruebaDisponibilidadRecurso(ElementoMultimedia elementoMultimedia) {
        URL url = null;
        try {
            url = new URL(elementoMultimedia.getUrl());
        } catch (MalformedURLException e) {
        }

        if (url != null) {
            try {
                URLConnection conexion = url.openConnection();
                if (conexion instanceof HttpURLConnection) {
                    return ((HttpURLConnection) conexion).getResponseCode() == HttpURLConnection.HTTP_OK;
                } else {
                    return conexion.getContentLength() > 0;
                }
            } catch (IOException e) {
            }
        }
        return false;
    }

    /**
     * El nombre del archivo en caché es una version codificada en base64 de la URL. Esto significa que no 
     * necesitamos mantener una base de datos de caché de archivos.
     */
    private String getCachedFileName(String url) {
        return Base64.encodeToString(url.getBytes(), false);
    }

    /**
     * Comprueba si el archivo ya está en caché.
     */
    private boolean cachePreparada(String cachedFileName) {
        File cache = getCachedFile(cachedFileName);
        if (cache.exists()) {
            if (cache.isDirectory()) {
                throw new IllegalStateException(cache.getAbsolutePath() + " already exists, and is a directory. Remove it.");
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Para almacenar en caché un elemento multimedia primero lo cargamos desde la red, luego lo escribimos a disco.
     */
    private PathMultimedia creaCacheMultimedia(String url, TipoMultimedia tipoMultimedia) {
        String cachedFileName = getCachedFileName(url);
        if (!cachePreparada(cachedFileName)) {
            URL _url = null;
            try {
                _url = new URL(url);
            } catch (MalformedURLException e) {
                throw new IllegalStateException("Error cargando URL " + url);
            }

            try {
                InputStream is = null;
                OutputStream os = null;
                try {
                    is = new BufferedInputStream(_url.openStream());
                    os = new BufferedOutputStream(getCachedOutputStream(cachedFileName));
                    while (true) {
                        int data = is.read();
                        if (data == -1)
                            break;
                        os.write(data);
                    }
                } finally {
                    if (is != null)
                        is.close();
                    if (os != null)
                        os.close();
                }
            } catch (IOException e) {
                throw new IllegalStateException("Error almacenando en caché " + tipoMultimedia.getDescripcion(), e);
            }
        }
        return new PathMultimedia(cachedFileName, true, tipoMultimedia);
    }

    private PathMultimedia createCachedMedia(ElementoMultimedia elementoMultimedia) {
        return creaCacheMultimedia(elementoMultimedia.getUrl(), elementoMultimedia.getTipoMultimedia());
    }

    private OutputStream getCachedOutputStream(String nombreArchivo) {
        try {
            return new FileOutputStream(getCachedFile(nombreArchivo));
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Error creando archivo caché ", e);
        }
    }

}
