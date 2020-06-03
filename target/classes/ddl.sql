-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 13-05-2020 a las 16:32:18
-- Versión del servidor: 5.7.30-0ubuntu0.18.04.1
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_ags`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `administrador_pk` bigint(20) NOT NULL,
  `alias` varchar(50) NOT NULL,
  `contrasena` varchar(250) NOT NULL,
  `usuario_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aliado`
--

CREATE TABLE `aliado` (
  `aliado_pk` bigint(20) NOT NULL,
  `documento` varchar(20) DEFAULT NULL,
  `tipo_doc_fk` bigint(20) DEFAULT NULL,
  `usuario_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `cargo_pk` bigint(20) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `ciudad_pk` bigint(20) NOT NULL,
  `nombre` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `empleado_pk` bigint(20) NOT NULL,
  `alias` varchar(50) NOT NULL,
  `contrasena` varchar(25) NOT NULL,
  `cargo_fk` bigint(20) DEFAULT NULL,
  `usuario_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `funcion_pk` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE `obra` (
  `obra_pk` bigint(20) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE `paquete` (
  `paquete_pk` bigint(20) NOT NULL,
  `cantidad_inicial` bigint(20) NOT NULL,
  `medida` varchar(80) DEFAULT NULL,
  `producto_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_cliente`
--

CREATE TABLE `paquete_cliente` (
  `paquete_cliente_pk` bigint(20) NOT NULL,
  `paquete_fk` bigint(20) DEFAULT NULL,
  `pedido_cliente_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_cliente_serial`
--

CREATE TABLE `paquete_cliente_serial` (
  `paquete_cliente_serial_pk` bigint(20) NOT NULL,
  `paquete_cliente_fk` bigint(20) DEFAULT NULL,
  `serial_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_proveedor`
--

CREATE TABLE `paquete_proveedor` (
  `paquete_proveedor_pk` bigint(20) NOT NULL,
  `paquete_fk` bigint(20) DEFAULT NULL,
  `pedido_proveedor_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_proveedor_serial`
--

CREATE TABLE `paquete_proveedor_serial` (
  `paquete_proveedor_serial_pk` bigint(20) NOT NULL,
  `paquete_proveedor_fk` bigint(20) DEFAULT NULL,
  `serial_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `pedido_pk` bigint(20) NOT NULL,
  `codigo` varchar(30) DEFAULT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_entrega` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_cliente`
--

CREATE TABLE `pedido_cliente` (
  `pedido_cliente_pk` bigint(20) NOT NULL,
  `aliado_fk` bigint(20) DEFAULT NULL,
  `pedido_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_proveedor`
--

CREATE TABLE `pedido_proveedor` (
  `pedido_proveedor_pk` bigint(20) NOT NULL,
  `aliado_fk` bigint(20) DEFAULT NULL,
  `pedido_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `prestamo_pk` bigint(20) NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date NOT NULL,
  `motivo` varchar(200) NOT NULL,
  `observacion_fin` varchar(200) DEFAULT NULL,
  `observacion_inicio` varchar(200) DEFAULT NULL,
  `empleado_fk` bigint(20) DEFAULT NULL,
  `serial_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `producto_pk` bigint(20) NOT NULL,
  `cantidad_minima` bigint(20) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `ubicacion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_funcion`
--

CREATE TABLE `producto_funcion` (
  `producto_pfk` bigint(20) NOT NULL,
  `funcion_pfk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE `salida` (
  `salida_pk` bigint(20) NOT NULL,
  `fecha_salida` date NOT NULL,
  `motivo_salida` varchar(50) DEFAULT NULL,
  `serial_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serial`
--

CREATE TABLE `serial` (
  `serial_pk` bigint(20) NOT NULL,
  `control_calidad` bit(1) DEFAULT NULL,
  `fecha_entrada` date NOT NULL,
  `metodo_entrada` varchar(255) NOT NULL,
  `serial` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_doc`
--

CREATE TABLE `tipo_doc` (
  `tipo_doc_pk` bigint(20) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabaja`
--

CREATE TABLE `trabaja` (
  `trabaja_pk` bigint(20) NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date NOT NULL,
  `empleado_fk` bigint(20) DEFAULT NULL,
  `obra_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `ubicacion_pk` bigint(20) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `ciudad_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario_pk` bigint(20) NOT NULL,
  `correo` varchar(120) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `ubicacion_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`administrador_pk`),
  ADD UNIQUE KEY `UK_sw4naqp7hvrooa50c7i3jcj58` (`alias`),
  ADD UNIQUE KEY `UK_m1x3qunv7rdoc03mt0hw0bguj` (`usuario_fk`);

--
-- Indices de la tabla `aliado`
--
ALTER TABLE `aliado`
  ADD PRIMARY KEY (`aliado_pk`),
  ADD UNIQUE KEY `UK_o614wmrthfmffxw328hrfy1fq` (`usuario_fk`),
  ADD KEY `FK2fpop2m9bfyyb0cyeuw2tj37` (`tipo_doc_fk`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`cargo_pk`),
  ADD UNIQUE KEY `UK_ajdj1q254skhgc8efatac20tx` (`nombre`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`ciudad_pk`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`empleado_pk`),
  ADD UNIQUE KEY `UK_pobop336mxk61ghipxhiu1gkg` (`alias`),
  ADD UNIQUE KEY `UK_n1t5e48jnjn4nvcv8jg009iin` (`usuario_fk`),
  ADD KEY `FKf6jbp58hff11w3j7lwk8lf7il` (`cargo_fk`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`funcion_pk`);

--
-- Indices de la tabla `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`obra_pk`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`paquete_pk`),
  ADD KEY `FKahm437mpq9itflfdbb3gtqtmn` (`producto_fk`);

--
-- Indices de la tabla `paquete_cliente`
--
ALTER TABLE `paquete_cliente`
  ADD PRIMARY KEY (`paquete_cliente_pk`),
  ADD UNIQUE KEY `UK_4ysxne8dyub1vpebpw5keqtsi` (`paquete_fk`),
  ADD KEY `FKay0m1mtn62vfi1wjb4wjqo7v9` (`pedido_cliente_fk`);

--
-- Indices de la tabla `paquete_cliente_serial`
--
ALTER TABLE `paquete_cliente_serial`
  ADD PRIMARY KEY (`paquete_cliente_serial_pk`),
  ADD UNIQUE KEY `UK_8ak7opl62idiv0nahl3orqyb7` (`serial_fk`),
  ADD KEY `FKog49l0ydat2ecyr46pae5f73x` (`paquete_cliente_fk`);

--
-- Indices de la tabla `paquete_proveedor`
--
ALTER TABLE `paquete_proveedor`
  ADD PRIMARY KEY (`paquete_proveedor_pk`),
  ADD UNIQUE KEY `UK_axa86feiggy1boq1hmya9mpxa` (`paquete_fk`),
  ADD KEY `FKth0oy6vt0hsnn8vnlnuhmvilb` (`pedido_proveedor_fk`);

--
-- Indices de la tabla `paquete_proveedor_serial`
--
ALTER TABLE `paquete_proveedor_serial`
  ADD PRIMARY KEY (`paquete_proveedor_serial_pk`),
  ADD UNIQUE KEY `UK_oegrjlvhwvslnp3jaldnbieqf` (`serial_fk`),
  ADD KEY `FKg2va05ishp0vl9lm87okupldt` (`paquete_proveedor_fk`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`pedido_pk`);

--
-- Indices de la tabla `pedido_cliente`
--
ALTER TABLE `pedido_cliente`
  ADD PRIMARY KEY (`pedido_cliente_pk`),
  ADD UNIQUE KEY `UK_80ox4v3y0jhfpjytnmbqh0qf7` (`pedido_fk`),
  ADD KEY `FKpu748gx64h2rxj5lkym5wi2gb` (`aliado_fk`);

--
-- Indices de la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  ADD PRIMARY KEY (`pedido_proveedor_pk`),
  ADD UNIQUE KEY `UK_jd7lbcg3521m3607wcl5mf6hu` (`pedido_fk`),
  ADD KEY `FKpwr08mo137plugfft4tf8pfuk` (`aliado_fk`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`prestamo_pk`),
  ADD KEY `FKo9d931i439p8cjiomkv9acn1t` (`empleado_fk`),
  ADD KEY `FKra4rmu0q1c4hm0jxstsuw2kt3` (`serial_fk`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`producto_pk`);

--
-- Indices de la tabla `producto_funcion`
--
ALTER TABLE `producto_funcion`
  ADD PRIMARY KEY (`producto_pfk`,`funcion_pfk`),
  ADD KEY `FKl8glrrosdruab93c7e3t1trua` (`funcion_pfk`);

--
-- Indices de la tabla `salida`
--
ALTER TABLE `salida`
  ADD PRIMARY KEY (`salida_pk`),
  ADD UNIQUE KEY `UK_csyortoc03d0xk8hyi3ljoyfv` (`serial_fk`);

--
-- Indices de la tabla `serial`
--
ALTER TABLE `serial`
  ADD PRIMARY KEY (`serial_pk`),
  ADD UNIQUE KEY `UK_ktrqt0lu3quyvbr9ju0tni0ox` (`serial`);

--
-- Indices de la tabla `tipo_doc`
--
ALTER TABLE `tipo_doc`
  ADD PRIMARY KEY (`tipo_doc_pk`),
  ADD UNIQUE KEY `UK_19v9y7wkc7rfbkf3s0og6hxel` (`nombre`);

--
-- Indices de la tabla `trabaja`
--
ALTER TABLE `trabaja`
  ADD PRIMARY KEY (`trabaja_pk`),
  ADD KEY `FKbx5mgxb6o8eqnr5b14khfx60u` (`empleado_fk`),
  ADD KEY `FK7ybt3y0l8kdtkjyvb6trk45pt` (`obra_fk`);

--
-- Indices de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD PRIMARY KEY (`ubicacion_pk`),
  ADD KEY `FKkusg1yx1hp9ywc9fq2ru6edwc` (`ciudad_fk`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario_pk`),
  ADD UNIQUE KEY `UK_2mlfr087gb1ce55f2j87o74t` (`correo`),
  ADD KEY `FKd7r7l4opr7hau9hk7k1186b7p` (`ubicacion_fk`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `administrador_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `aliado`
--
ALTER TABLE `aliado`
  MODIFY `aliado_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `cargo_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `ciudad_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `empleado_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `funcion_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `obra`
--
ALTER TABLE `obra`
  MODIFY `obra_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `paquete`
--
ALTER TABLE `paquete`
  MODIFY `paquete_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `paquete_cliente`
--
ALTER TABLE `paquete_cliente`
  MODIFY `paquete_cliente_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `paquete_cliente_serial`
--
ALTER TABLE `paquete_cliente_serial`
  MODIFY `paquete_cliente_serial_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `paquete_proveedor`
--
ALTER TABLE `paquete_proveedor`
  MODIFY `paquete_proveedor_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `paquete_proveedor_serial`
--
ALTER TABLE `paquete_proveedor_serial`
  MODIFY `paquete_proveedor_serial_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `pedido_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pedido_cliente`
--
ALTER TABLE `pedido_cliente`
  MODIFY `pedido_cliente_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  MODIFY `pedido_proveedor_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `prestamo_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `producto_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `salida`
--
ALTER TABLE `salida`
  MODIFY `salida_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `serial`
--
ALTER TABLE `serial`
  MODIFY `serial_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `tipo_doc`
--
ALTER TABLE `tipo_doc`
  MODIFY `tipo_doc_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `trabaja`
--
ALTER TABLE `trabaja`
  MODIFY `trabaja_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  MODIFY `ubicacion_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuario_pk` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `FKgxl2wwr2kkrvyl10jyb06vcig` FOREIGN KEY (`usuario_fk`) REFERENCES `usuario` (`usuario_pk`);

--
-- Filtros para la tabla `aliado`
--
ALTER TABLE `aliado`
  ADD CONSTRAINT `FK2fpop2m9bfyyb0cyeuw2tj37` FOREIGN KEY (`tipo_doc_fk`) REFERENCES `tipo_doc` (`tipo_doc_pk`),
  ADD CONSTRAINT `FK9cdjbav0iq734tgelrhowvlox` FOREIGN KEY (`usuario_fk`) REFERENCES `usuario` (`usuario_pk`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FKdxsa6ln9t6t3q7b6gafdynln0` FOREIGN KEY (`usuario_fk`) REFERENCES `usuario` (`usuario_pk`),
  ADD CONSTRAINT `FKf6jbp58hff11w3j7lwk8lf7il` FOREIGN KEY (`cargo_fk`) REFERENCES `cargo` (`cargo_pk`);

--
-- Filtros para la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD CONSTRAINT `FKahm437mpq9itflfdbb3gtqtmn` FOREIGN KEY (`producto_fk`) REFERENCES `producto` (`producto_pk`);

--
-- Filtros para la tabla `paquete_cliente`
--
ALTER TABLE `paquete_cliente`
  ADD CONSTRAINT `FKay0m1mtn62vfi1wjb4wjqo7v9` FOREIGN KEY (`pedido_cliente_fk`) REFERENCES `pedido_cliente` (`pedido_cliente_pk`),
  ADD CONSTRAINT `FKox3hpaqfpj63wra2ssaa95y2b` FOREIGN KEY (`paquete_fk`) REFERENCES `paquete` (`paquete_pk`);

--
-- Filtros para la tabla `paquete_cliente_serial`
--
ALTER TABLE `paquete_cliente_serial`
  ADD CONSTRAINT `FKllppvurdgop3vw7eq4umcnl64` FOREIGN KEY (`serial_fk`) REFERENCES `serial` (`serial_pk`),
  ADD CONSTRAINT `FKog49l0ydat2ecyr46pae5f73x` FOREIGN KEY (`paquete_cliente_fk`) REFERENCES `paquete_cliente` (`paquete_cliente_pk`);

--
-- Filtros para la tabla `paquete_proveedor`
--
ALTER TABLE `paquete_proveedor`
  ADD CONSTRAINT `FKdp8jtyfwkmf2b5xkjgkpwmi1x` FOREIGN KEY (`paquete_fk`) REFERENCES `paquete` (`paquete_pk`),
  ADD CONSTRAINT `FKth0oy6vt0hsnn8vnlnuhmvilb` FOREIGN KEY (`pedido_proveedor_fk`) REFERENCES `pedido_proveedor` (`pedido_proveedor_pk`);

--
-- Filtros para la tabla `paquete_proveedor_serial`
--
ALTER TABLE `paquete_proveedor_serial`
  ADD CONSTRAINT `FK2xs7fi5cbgo5rb7ki135h9m6e` FOREIGN KEY (`serial_fk`) REFERENCES `serial` (`serial_pk`),
  ADD CONSTRAINT `FKg2va05ishp0vl9lm87okupldt` FOREIGN KEY (`paquete_proveedor_fk`) REFERENCES `paquete_proveedor` (`paquete_proveedor_pk`);

--
-- Filtros para la tabla `pedido_cliente`
--
ALTER TABLE `pedido_cliente`
  ADD CONSTRAINT `FKhv9nkb972upip1vgirfq9jy6m` FOREIGN KEY (`pedido_fk`) REFERENCES `pedido` (`pedido_pk`),
  ADD CONSTRAINT `FKpu748gx64h2rxj5lkym5wi2gb` FOREIGN KEY (`aliado_fk`) REFERENCES `aliado` (`aliado_pk`);

--
-- Filtros para la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  ADD CONSTRAINT `FKad41d0n2w9927bahqf3nxhbml` FOREIGN KEY (`pedido_fk`) REFERENCES `pedido` (`pedido_pk`),
  ADD CONSTRAINT `FKpwr08mo137plugfft4tf8pfuk` FOREIGN KEY (`aliado_fk`) REFERENCES `aliado` (`aliado_pk`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `FKo9d931i439p8cjiomkv9acn1t` FOREIGN KEY (`empleado_fk`) REFERENCES `empleado` (`empleado_pk`),
  ADD CONSTRAINT `FKra4rmu0q1c4hm0jxstsuw2kt3` FOREIGN KEY (`serial_fk`) REFERENCES `serial` (`serial_pk`);

--
-- Filtros para la tabla `producto_funcion`
--
ALTER TABLE `producto_funcion`
  ADD CONSTRAINT `FKkmem47vyv3pqjawqclin2fg00` FOREIGN KEY (`producto_pfk`) REFERENCES `producto` (`producto_pk`),
  ADD CONSTRAINT `FKl8glrrosdruab93c7e3t1trua` FOREIGN KEY (`funcion_pfk`) REFERENCES `funcion` (`funcion_pk`);

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `FKsk80vqas7wm8bslxk9kuwr4nr` FOREIGN KEY (`serial_fk`) REFERENCES `serial` (`serial_pk`);

--
-- Filtros para la tabla `trabaja`
--
ALTER TABLE `trabaja`
  ADD CONSTRAINT `FK7ybt3y0l8kdtkjyvb6trk45pt` FOREIGN KEY (`obra_fk`) REFERENCES `obra` (`obra_pk`),
  ADD CONSTRAINT `FKbx5mgxb6o8eqnr5b14khfx60u` FOREIGN KEY (`empleado_fk`) REFERENCES `empleado` (`empleado_pk`);

--
-- Filtros para la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD CONSTRAINT `FKkusg1yx1hp9ywc9fq2ru6edwc` FOREIGN KEY (`ciudad_fk`) REFERENCES `ciudad` (`ciudad_pk`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FKd7r7l4opr7hau9hk7k1186b7p` FOREIGN KEY (`ubicacion_fk`) REFERENCES `ubicacion` (`ubicacion_pk`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
