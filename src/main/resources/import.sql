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

