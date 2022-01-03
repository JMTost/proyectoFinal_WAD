INSERT INTO instructor(correo, contraseña, nombre, appat, apmat, calle, numext, codpost, delegacion, telefono) 
VALUES ('alguien@gmail.com', 'qwerty', 'pepe', 'aguilar', 'santana', 'Canoas', 17, 56333, 'Azcapotzalco', '5511223344' );

INSERT INTO instructor(correo, contraseña, nombre, appat, apmat, calle, numext, codpost, delegacion, telefono) 
VALUES ('profesor@yahoo.com', 'MiCumple', 'Lucia', 'Jimenez', 'Rodriguez', 'Dalia', 31, 29814, 'Guerrero', '5614899050' );

INSERT INTO instructor(correo, contraseña, nombre, appat, apmat, calle, numext, codpost, delegacion, telefono) 
VALUES ('instructor@hotmail.com', 'ensalada', 'Carlota', 'Contreras', 'De la Costa', 'Palomas', 2, 78103, 'San Pedro', '5516852122' );

INSERT INTO instructor(correo, contraseña, nombre, appat, apmat, calle, numext, codpost, delegacion, telefono) 
VALUES ('maestro@outlook.com', 'pastizal', 'Juan', 'Martiez', 'Hernandez', 'Calle 25', 301, 53200, 'Santo Domingo', '5112242198' );

INSERT INTO instructor(correo, contraseña, nombre, appat, apmat, calle, numext, codpost, delegacion, telefono) 
VALUES ('docente@gmail.com', 'camarones', 'Camila', 'Velasquez', 'Ramirez', 'Durazno',25, 11234, 'Juarez', '0681121387' );

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('aaaa', 'Como hacer palomitas', 'Aprendiendo a cocinar palomitas, desde la plantacion del maiz', 9);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('aaab', 'Curso de programación en java', 'Programación en java desde 0 hasta Junior', 9);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('aaba', 'Cursos de dibujo de rostros', 'Como dibujar rostros realez a lapiz', 10);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('aabb', 'Curso de dibujo anime', 'Como dibujar rostros anime digitalmente', 10);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('abaa', 'Curso de jardineria', 'Como cuidar las plantas de tu jardin', 11);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('abab', 'Curso de circuitos electricos', 'Como armar circuitos para tus sistemas', 11);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('abba', 'Curso de robotica', 'Como armar tu propio robot', 12);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('abbb', 'Curso de reposteria', 'Como cocinar tus propios antojos azucarados', 12);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('baaa', 'Curso de bordado', 'Como tejer tu propia prenda', 13);

INSERT INTO curso(idCurso, nombreCurso, descripcion, idProfesor)
VALUES('baab', 'Curso de papiroflexia', 'Crea tu propio arte con papel', 13);

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('aaaa', 9, 'Zoom', 'http://www.zoom.com', 'capa');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('aaab', 9, 'Zoom', 'http://www.zoom.com', 'roles');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('aaba', 10, 'Teams', 'http://www.teams.com', 'aquiNo');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('aabb', 10, 'Teams', 'http://www.teams.com', 'tampoco');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('abaa', 11, 'Google meet', 'http://www.meet.com', 'Password');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('abab', 11, 'Google meet', 'http://www.meet.com', 'Pto');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('abba', 12, 'Hangouts', 'http://www.hangouts.com', 'NadieUsa');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('abbb', 12, 'Hangouts', 'http://www.hangouts.com', 'YaCasi');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('baaa', 13, 'discord', 'http://www.discord.com', 'Mamador');

INSERT INTO direccioncurso(idcurso, idprofesor, nombreplat, linkllamada, passllamada)
VALUES('baab', 13, 'Discord', 'http://www.discord.com', 'Detergente');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('aaaa', 9, '12:10', true, 'Zoom');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('aaab', 9, '11:00', true, 'Zoom');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('aaba', 10, '14:00', false, 'Teams');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('aabb', 10, '10:30', true, 'Teams');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('abaa', 11, '13:30', true, 'Meet');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('abab', 11, '20:10', false, 'Meet');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('abba', 12, '12:10', true, 'Hangouts');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('abbb', 12, '18:15', true, 'Hangouts');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('baaa', 13, '15:45', false, 'Discord');

INSERT INTO horarios(idCurso, idProfesor, hora, disponible, nombreplataforma)
VALUES('baab', 13, '14:50', false, 'Discord');

INSERT INTO estudiante(nombre, appate, apmate, telefono, correo, passestudiante, fechanacimiento)
VALUES('Pablo', 'Ceballos', 'Buenaventura', '5417852965', 'alumno1@hotmail.com', 'cacahuate', '20/10/2000');

INSERT INTO estudiante(nombre, appate, apmate, telefono, correo, passestudiante, fechanacimiento)
VALUES('Cintia', 'Figueroa', 'Cano', '0148752369', 'cinti@gmail.com', 'flores', '15/08/1997');

INSERT INTO estudiante(nombre, appate, apmate, telefono, correo, passestudiante, fechanacimiento)
VALUES('Alma', 'Marcela', 'Rico', '0178452169', 'albureando@outlook.com', 'benito', '23/07/2003');

INSERT INTO estudiante(nombre, appate, apmate, telefono, correo, passestudiante, fechanacimiento)
VALUES('Pedro', 'Bello', 'Nieto', '0781548777', 'IHateMyName@hotmail.com', 'paninche', '4/04/2004');

INSERT INTO estudiante(nombre, appate, apmate, telefono, correo, passestudiante, fechanacimiento)
VALUES('Andres', 'Garcia', 'Gonzales', '0685410256', 'andregg@yahoo.com', 'pepelito', '31/01/2007');

INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaaa',2);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaaa',8);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaaa',5);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaaa',3);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaab',1);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaab',2);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaba',7);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aaba', 5);

INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('aabb',6);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abaa',3);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abaa',4);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abab',2);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abba',4);

INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abba',8);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abba',7);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abbb',3);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('abbb',5);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('baaa',6);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('baaa',2);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('baab',6);


INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('baab',7);

INSERT INTO InscripcionCurso(idCurso, idEstudiante)
VALUES('baab',3);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(2,'aaaa', 9);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(8,'aaaa', 10);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(5,'aaaa', 1);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(3,'aaaa', 5);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(2,'aaab', 6);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(7,'aaab', 3);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(7,'aaba', 6);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(6,'aabb', 3);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(3,'abaa', 8);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(4,'abaa', 7);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(2,'abab', 4);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(4,'abba', 0);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(8,'abba', 1);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(7,'abba', 9);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(3,'abbb', 6);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(5,'abbb', 5);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(6,'baaa', 7);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(2,'baaa', 10);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(6,'baab', 4);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(7,'baab', 9);

INSERT INTO calificacionesfinales(idEstudiante, idCurso, calf)
VALUES(3,'baab', 3);

INSERT INTO administrador(idAdmin, passadmin)
VALUES('Yaron','Yaron');

INSERT INTO administrador(idAdmin, passadmin)
VALUES('Jesus','Jesus');

INSERT INTO administrador(idAdmin, passadmin)
VALUES('Eduardo','Eduardo');

INSERT INTO calificacionesparciales(descripcion)
VALUES('excelente');

INSERT INTO calificacionesparciales(descripcion)
VALUES('suficiente');

INSERT INTO calificacionesparciales(descripcion)
VALUES('deficiente');

INSERT INTO calificacionesparciales(descripcion)
VALUES('necesita apoyo');