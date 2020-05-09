--ciudad
INSERT INTO `ciudad` (`nombre`) VALUES ('Cucuta');
INSERT INTO `ciudad` (`nombre`) VALUES ('Bucaramanga');
INSERT INTO `ciudad` (`nombre`) VALUES ('Bogota');
--ubicacion
INSERT INTO `ubicacion` (`direccion`, `ciudad_fk`) VALUES ('Patios', '1');
INSERT INTO `ubicacion` (`direccion`, `ciudad_fk`) VALUES ('Trigal', '1');
INSERT INTO `ubicacion` (`direccion`, `ciudad_fk`) VALUES ('Atalaya', '1');
INSERT INTO `ubicacion` (`direccion`, `ciudad_fk`) VALUES ('Cuadra', '2');
INSERT INTO `ubicacion` (`direccion`, `ciudad_fk`) VALUES ('Cabecera', '2');
INSERT INTO `ubicacion` (`direccion`, `ciudad_fk`) VALUES ('Suba', '3');
--usuario
INSERT INTO `usuario` (`correo`, `nombre`, `telefono`, `ubicacion_fk`) VALUES ('sebastian@gmail.com', 'Sebastian Vega', '3108796756', '2');
INSERT INTO `usuario` (`correo`, `nombre`, `telefono`, `ubicacion_fk`) VALUES ('angel@hotmail.com', 'Angel Mondragon', '3209807689', '1');
INSERT INTO `usuario` (`correo`, `nombre`, `telefono`, `ubicacion_fk`) VALUES ('julian@navarro.com', 'Julian Navarro', '1253625454', '3');
INSERT INTO `usuario` (`correo`, `nombre`, `telefono`, `ubicacion_fk`) VALUES ('lina@outlook.com', 'Lina perez', '3102563636', '5');
INSERT INTO `usuario` (`correo`, `nombre`, `telefono`, `ubicacion_fk`) VALUES ('karen@ufps.edu.co', 'Karen Beltran', '2530214578', '1');
--tipoDoc
INSERT INTO `tipo_doc` (`nombre`) VALUES ('Cedula');
INSERT INTO `tipo_doc` (`nombre`) VALUES ('RUT');
INSERT INTO `tipo_doc` (`nombre`) VALUES ('NIT');
--aliado
INSERT INTO `aliado` (`documento`, `tipo_doc_fk`, `usuario`) VALUES ('10235421346', '1', '1');
INSERT INTO `aliado` (`documento`, `tipo_doc_fk`, `usuario`) VALUES ('10235421346', '2', '2');
INSERT INTO `aliado` (`documento`, `tipo_doc_fk`, `usuario`) VALUES ('10235421346', '1', '3');
INSERT INTO `aliado` (`documento`, `tipo_doc_fk`, `usuario`) VALUES ('10235421346', '3', '4');
--producto
INSERT INTO `producto` (`cantidad_minima`,`marca`,`modelo`,`nombre`,`ubicacion`) VALUES ('10', 'Apple', 'TG4', 'UDP', 'estanteria3');
INSERT INTO `producto` (`cantidad_minima`,`marca`,`modelo`,`nombre`,`ubicacion`) VALUES ('20', 'Microsoft', 'TG4', 'Cable TX', 'estanteria2');
INSERT INTO `producto` (`cantidad_minima`,`marca`,`modelo`,`nombre`,`ubicacion`) VALUES ('15', 'Ford', 'TG4', 'Router', 'estanteria1');
--funcion
INSERT INTO `funcion` (`nombre`) VALUES ('Herramienta');
INSERT INTO `funcion` (`nombre`) VALUES ('Cable');
INSERT INTO `funcion` (`nombre`) VALUES ('Maquina');
--cargo
INSERT INTO `cargo`(`nombre`) VALUES ('tecnico')
INSERT INTO `cargo`(`nombre`) VALUES ('secretaria')
INSERT INTO `cargo`(`nombre`) VALUES ('portero')
--empleado
INSERT INTO `empleado`(`alias`,`contrasena`,`cargo_fk`,`usuario_fk`) VALUES ('veg8','vega','1','1');
INSERT INTO `empleado`(`alias`,`contrasena`,`cargo_fk`,`usuario_fk`) VALUES ('amondrag','dis','1','2');
--pedido
INSERT INTO `pedido` (`codigo`, `fecha_creacion`) VALUES ('1', '2020-05-07');
INSERT INTO `pedido` (`codigo`, `fecha_creacion`) VALUES ('2', '2020-05-10');
INSERT INTO `pedido` (`codigo`, `fecha_creacion`) VALUES ('3', '2020-05-25');
INSERT INTO `pedido` (`codigo`, `fecha_creacion`) VALUES ('4', '2020-05-2');


