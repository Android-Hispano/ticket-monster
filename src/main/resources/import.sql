-- ElementoMultimedia 0
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/65660684/640px-Weir%2C_Bob_(2007)_2.jpg')
-- ElementoMultimedia 1
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/65660684/640px-Carnival_Puppets.jpg')
-- ElementoMultimedia 2
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/65660684/640px-Opera_House_with_Sydney.jpg')
-- ElementoMultimedia 3
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/65660684/640px-Roy_Thomson_Hall_Toronto.jpg')
-- ElementoMultimedia 4
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/65660684/640px-West-stand-bmo-field.jpg')
-- ElementoMultimedia 5
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/65660684/640px-Brazil_national_football_team_training_at_Dobsonville_Stadium_2010-06-03_13.jpg')
-- ElementoMultimedia 6
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/AllStateFootballChampionship.png')
-- ElementoMultimedia 7
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/ARhythmia.png')
-- ElementoMultimedia 8
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/BattleoftheBrassBands.png')
-- ElementoMultimedia 9
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/CarnivalComestoTown.png')
-- ElementoMultimedia 10
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/ChrisLewisQuarterfinals.png')
-- ElementoMultimedia 11
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/CrewYou.png')
-- ElementoMultimedia 12
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/ExtremeSnowboardingFinals.png')
-- ElementoMultimedia 13
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/FlamencoFinale.png')
-- ElementoMultimedia 14
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/JesseLewisUnplugged.png')
-- ElementoMultimedia 15
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/MadameButterfly.png')
-- ElementoMultimedia 16
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/MimeMania.png')
-- ElementoMultimedia 17
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/MorrisonCover.png')
-- ElementoMultimedia 18
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/TutuTchai.png')
-- ElementoMultimedia 19
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/SlapShot.png')
-- ElementoMultimedia 20
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/Giantsofthegame.png')
-- ElementoMultimedia 21
insert into ElementoMultimedia ( tipoMultimedia, url) values ( 'IMAGE', 'http://dl.dropbox.com/u/8625587/ticketmonster/Punch%26Judy.png')

-- Lugar 1
insert into Lugar ( nombre, ciudad, pais, calle, descripcion, id_elementomultimedia, aforo) values ( 'Roy Thomson Hall', 'Toronto', 'Canada', '60 Simcoe calle','Roy Thomson Hall is the home of the Toronto Symphony Orchestra and the Toronto Mendelssohn Choir.',4, 11000);

-- Seccion 1
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'A', 'Premier platinum reserve',20, 100, 1);
-- Seccion 2
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'B', 'Premier gold reserve', 20, 100, 1);
-- Seccion 3
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'C', 'Premier silver reserve', 30, 100, 1);
-- Seccion 4
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'D', 'General', 40, 100, 1);

-- Lugar 2
insert into Lugar ( nombre, ciudad, pais, calle, descripcion, id_elementomultimedia, aforo) values ( 'Sydney Opera House', 'Sydney', 'Australia', 'Bennelong point', 'The Sydney Opera House is a multi-Lugar performing arts centre in Sydney, New South Wales, Australia' ,3, 15030);

-- Seccion 5
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'S1', 'Front left', 50, 50, 2);
-- Seccion 6
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'S2', 'Front centre', 50, 50, 2);
-- Seccion 7
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'S3', 'Front right',50, 50, 2);
-- Seccion 8
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'S4', 'Rear left', 50, 50, 2);
-- Seccion 9
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'S5', 'Rear centre', 50, 50, 2);
-- Seccion 10
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'S6', 'Rear right', 50, 50, 2);
-- Seccion 11
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'S7', 'Balcony', 1, 30, 2);

-- Lugar 3
insert into Lugar ( nombre, ciudad, pais, calle, descripcion, id_elementomultimedia, aforo) values ( 'BMO Field', 'Toronto', 'Canada', '170 Princes Boulevard','BMO Field is a Canadian soccer stadium located in Exhibition Place in the ciudad of Toronto.',5, 30000);

-- Seccion 12
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'A', 'Premier platinum reserve',40, 100, 3);
-- Seccion 13
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'B', 'Premier gold reserve', 40, 100, 3);
-- Seccion 14
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'C', 'Premier silver reserve', 30, 200, 3);
-- Seccion 15
insert into Seccion ( nombre, descripcion, numerofilas, aforofila, id_lugar) values ( 'D', 'General', 80, 200, 3);

-- CategoriaEvento 1
insert into CategoriaEvento ( descripcion) values ( 'Concert');
-- CategoriaEvento 2
insert into CategoriaEvento ( descripcion) values ( 'Theatre');
-- CategoriaEvento 3
insert into CategoriaEvento ( descripcion) values ( 'Musical');
-- CategoriaEvento 4
insert into CategoriaEvento ( descripcion) values ( 'Sporting');
-- CategoriaEvento 5
insert into CategoriaEvento ( descripcion) values ( 'Comedy');

-- CategoriaEntrada 1
insert into CategoriaEntrada ( descripcion) values ( 'Adult');
-- CategoriaEntrada 2
insert into CategoriaEntrada ( descripcion) values ( 'Child 0-14yrs');

-- Evento 1
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Rock concert of the decade', 'Get ready to rock your night away with this megaconcert extravaganza from 10 of the biggest rock stars of the 80''s', 1, 1);
-- Evento 2
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Shane''s Sock Puppets', 'This critically acclaimed masterpiece will take you on an emotional rollercoaster the likes of which you''ve never experienced.', 2, 2);
-- Evento 3
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Brazil vs. Italy', 'A friendly replay of the famous World Cup final.', 6, 4);
-- Evento 4
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'All State Football Championship', 'Espectaculo your colors in Friday Night Lights! Come see the Red Hot Scorpions put the sting on the winners of Sunday''s Coastal Quarterfinals for all state bragging rights. Fans entering the stadium in team color face paint will receive a $5 voucher redeemable with any on-site vendor. Body paint in lieu of clothing will not be permitted for this family friendly Evento.', 7, 4);
-- Evento 5
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Chris Lewis Quarterfinals', 'Every tennis enthusiast will want to see Wimbledon legend Chris Lewis as he meets archrival Deuce Wild in the quarterfinals of one of the top U.S. tournaments. Finals are already sold out, so do not miss your chance to see the real action in play on the eve of the big day!', 11, 4);
-- Evento 6
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Crew You', 'Join your fellow crew junkies and snarky, self-important collegiate know-it-alls from the nations snobbiest schools to see which team is in fact the fastest Espectaculo on oars. (Or, if you like, just purchase a ticket and sport a t-shirt from your local community college just to tick them off -- this Evento promises to be SO much fun!)', 12, 4);
-- Evento 7
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Extreme Snowboarding Finals', 'What else is there to say? There''s snow and sun and the bravest (or craziest) guys ever to strap two feet to a board and fly off a four-story ramp of ice and snow. Who would not want to see how aerial acrobatics are being redefined by the world''s top adrenaline junkies?', 13, 4);
-- Evento 8
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Arrhythmia: Graffiti', 'Hear the sounds that have the critics abuzz. Be one of the first American audiences to experience Portuguese phenomenon Arrhythmia play all the tracks from their recently-released ''Graffiti'' -- the Espectaculo includes a cameo with world-famous activist and graffiti artist Bansky.', 8, 1);
-- Evento 9
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Battle of the Brass Bands', 'That''s right -- they''ve blown into town! Join the annual tri-state Battle of the Brass Bands and watch them ''gild'' the winning band''s Most Valuable Blower (MVB) -- don''t worry (and don''t inhale!); it''s only spray paint!  Vote for your best band and revel in a day of high-energy rhythms!',  9, 1);
-- Evento 10
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Carnival Comes to Town', 'Sit center stage as Harlequin Ayes gives another groundbreaking theater Actuacion in the critically acclaimed Carnival Comes to Town, a monologue re-enactment of one-woman''s despair at not being chosen to join the carnival she''s spent her entire life preparing for.', 10, 2);
-- Evento 11
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Flamenco Finale','Get in touch with the stunning staccato and your inner Andalusian -- and put on your dancing shoes even if you''re just in the audience! It''s down to this one night of competition for the eight mesmerizing couples from around the globe that made it this far. Purchase VIP tickets to experience the competition and revel in the after-hours cabaret party with the world''s most alluring dancers!', 14, 2);
-- Evento 12
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Jesse Lewis Unplugged', 'It''s one night only for this once-in-a-lifetime concert-in-the-round with Grammy winning folk and blues legend Jesse Lewis. Entirely stripped of elaborate recording production, Lewis'' music stands entirely on its own and has audiences raving it''s his best work ever. With limited seating this final concert, don''t dare to miss this classic you can tell your grandkids about when they develop some real taste in music.', 15, 1);
-- Evento 13
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Madame Butterfly', 'Make way for Puccini''s opera in three acts and wear waterproof mascara for the dramatic tearjerker of the season. Let the voice of renowned soprano Rosino Storchio and tenor Giovanni Zenatello envelop you under the stars while you sob quietly into your handkerchief! Wine and hard liquor will be available during intermission and after the Espectaculo for those seeking to drown their sorrows.', 16, 2);
-- Evento 14
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Mime Mania!', 'Join in the region''s largest and most revered demonstration of one of the most mocked arts forms of all time. Stand in stunned silence while the masters of Mime Mania thrill with dramatic gestures that far surpass the now passé "Woman in a Glass Box." See the famous, "I have 10 fingers, don''t make me give you one!" and other favorites and be sure to enjoy the post-Espectaculo silent auction.', 17, 2);
-- Evento 15
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Almost (Mostly) Morrison', 'This Espectaculo is for all those who traded in Hemingway for the poetry of the Doors, but really can''t remember why.  Come see a dead ringer for Jim Morrison and let the despair envelop your soul as he quotes from his tragic mentor, "I believe in a prolonged derangement of the senses in order to obtain the unknown." But be advised: Leave your ganja at home, or leave with the Po-Po', 18, 1);
-- Evento 16
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Tutu Tchai', 'Join your fellow ballet enthusiasts for the National Ballet Company''s presentation of Tutu Tchai, a tribute to Pyotr Tchaikovsky''s and the expressive intensity revealed in his three most famous ballets: The Nutcracker, Swan Lake, and The Sleeping Beauty.', 19, 2);
-- Evento 17
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Slap Shot', 'They''re out to prove it''s not all about the fights! Join your favorite members of the Canadian Women''s Hockey League as they compete for the title "Queen of the Slap Shot." Commonly believed to be hockey''s toughest shot to execute, the speed and accuracy of slap shots will be measured on the ice. Fan participation and response will determine any ties. Proceeds will benefit local area domestic violence shelters.', 20, 4);
-- Evento 18
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Giants of the Game', 'Your votes are in and the teams are assembled and coming to a stadium near you! Join Brendan ''Biceps'' Owen and the rest of the NBA''s leading players for this blockbuster East versus West all-star game. Who will join the rarefied air with past MVP greats like Shaquille O''Neal, LeBron James, and Kobe Bryant? Don''t wait to see the highlights when you can experience it live!', 21, 4);
-- Evento 19
insert into Evento ( nombre, descripcion, id_elementomultimedia, id_categoria) values ( 'Punch and Judy (with a Twist)', 'You may not be at a British seaside but you heard right! Bring your family to witness a new twist on this traditional classic dating back to the 1600s ... only this time, Mr. Punch (and his stick) have met "The 1%." Cheer (or jeer) from the crowd when you think Punch should use his stick on Mr. 1%. Fans agree, "It''s the best way to release your outrage at the wealthiest 1% without  being arrested!".', 22, 2);

-- Espectaculo 1
insert into Espectaculo ( id_evento, id_lugar) values ( 1, 1);

-- Actuacion 1
insert into Actuacion ( id_espectaculo, date) values ( 1, '2013-04-01 19:00:00');

-- SeccionAsignada 1
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (1, 1, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (1, 2, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (1, 3, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (1, 4, null, 0, 1);

-- Actuacion 2
insert into Actuacion ( id_espectaculo, date) values ( 1, '2013-04-02 19:00:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (2, 1, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (2, 2, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (2, 3, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (2, 4, null, 0, 1);

-- Espectaculo 2
insert into Espectaculo ( id_evento, id_lugar) values ( 1, 2);

-- Actuacion 3
insert into Actuacion ( id_espectaculo, date) values ( 2, '2013-04-03 19:30:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (3, 5, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (3, 6, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (3, 7, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (3, 8, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (3, 9, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (3, 10, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (3, 11, null, 0, 1);

-- Actuacion #4
insert into Actuacion ( id_espectaculo, date) values ( 2, '2013-04-04 19:30:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (4, 5, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (4, 6, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (4, 7, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (4, 8, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (4, 9, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (4, 10, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (4, 11, null, 0, 1);

-- Espectaculo 3
insert into Espectaculo ( id_evento, id_lugar) values ( 2, 1);

-- Actuacion 5
insert into Actuacion ( id_espectaculo, date) values ( 3, '2013-04-05 17:00:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (5, 1, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (5, 2, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (5, 3, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (5, 4, null, 0, 1);

-- Actuacion 6
insert into Actuacion ( id_espectaculo, date) values ( 3, '2013-04-05 19:30:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (6, 1, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (6, 2, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (6, 3, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (6, 4, null, 0, 1);

-- Espectaculo 4
insert into Espectaculo ( id_evento, id_lugar) values ( 2, 2);

-- Actuacion 7
insert into Actuacion ( id_espectaculo, date) values ( 4, '2013-04-07 17:00:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (7, 5, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (7, 6, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (7, 7, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (7, 8, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (7, 9, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (7, 10, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (7, 11, null, 0, 1);

-- Actuacion 8
insert into Actuacion ( id_espectaculo, date) values ( 4, '2013-04-07 19:30:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (8, 5, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (8, 6, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (8, 7, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (8, 8, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (8, 9, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (8, 10, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (8, 11, null, 0, 1);

--Espectaculo 5
insert into Espectaculo ( id_evento, id_lugar) values ( 3, 3);

-- Actuacion 9
insert into Actuacion ( id_espectaculo, date) values ( 5, '2013-05-11 21:00:00');
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (9, 12, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (9, 13, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (9, 14, null, 0, 1);
insert into SeccionAsignada(Actuacion_id, id_seccion, asignado, ocupados, version) values (9, 15, null, 0, 1);

insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (1, 1, 1, 219.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (1, 2, 1, 199.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (1, 3, 1, 179.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (1, 4, 1, 149.50);

insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 5, 1, 167.75);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 6, 1, 197.75);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 7, 1, 167.75);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 8, 1, 155.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 9, 1, 155.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 10, 1, 155.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 11, 1, 122.5);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 5, 2, 157.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 6, 2, 187.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 7, 2, 157.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 8, 2, 145.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 9, 2, 145.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 10, 2, 145.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (2, 11, 2, 112.5);


insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (3, 1, 1, 219.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (3, 2, 1, 199.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (3, 3, 1, 179.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (3, 4, 1, 149.50);

insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (4, 5, 1, 167.75);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (4, 6, 1, 197.75);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (4, 7, 1, 167.75);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (4, 8, 1, 155.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (4, 9, 1, 155.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (4, 10, 1, 155.0);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (4, 11, 1, 122.5);

insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (5, 12, 1, 219.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (5, 13, 1, 199.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (5, 14, 1, 179.50);
insert into PrecioEntrada ( id_espectaculo, id_seccion, CategoriaEntrada_id, precio) values (5, 15, 1, 149.50);
