-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-06-2022 a las 18:42:48
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kristell_dent_bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaenfermedades`
--

CREATE TABLE `categoriaenfermedades` (
  `idCategoria` int(11) NOT NULL,
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriameicamento`
--

CREATE TABLE `categoriameicamento` (
  `idCategoria` int(11) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `descripcion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `idCita` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL DEFAULT '00:00:00',
  `tarifa` decimal(12,0) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idEspecialista` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE `comprobante` (
  `numero` char(4) NOT NULL,
  `serieComprobante` char(6) NOT NULL,
  `fecha` date NOT NULL,
  `subTotal` double NOT NULL,
  `descuento` double NOT NULL,
  `total` double NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idEspecialista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `idConsulta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL DEFAULT '00:00:00',
  `motivoConsulta` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `codigoTarifa` char(6) CHARACTER SET utf8mb4 NOT NULL,
  `idEspecialista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosempresa`
--

CREATE TABLE `datosempresa` (
  `idEmpresa` int(11) NOT NULL,
  `razonSocial` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `numDocumento` char(11) COLLATE utf8mb4_spanish_ci NOT NULL,
  `telefono` char(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `facebook` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `codDistrito` char(8) CHARACTER SET utf8mb4 NOT NULL,
  `idTipoDoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL,
  `departamento` varchar(100) NOT NULL,
  `avPais` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`idDepartamento`, `departamento`, `avPais`) VALUES
(1, 'AMAZONAS', 'PE'),
(2, 'ÁNCASH', 'PE'),
(3, 'APURÍMAC', 'PE'),
(4, 'AREQUIPA', 'PE'),
(5, 'AYACUCHO', 'PE'),
(6, 'CAJAMARCA', 'PE'),
(7, 'CALLAO', 'PE'),
(8, 'CUSCO', 'PE'),
(9, 'HUANCAVELICA', 'PE'),
(10, 'HUÁNUCO', 'PE'),
(11, 'ICA', 'PE'),
(12, 'JUNÍN', 'PE'),
(13, 'LA LIBERTAD', 'PE'),
(14, 'LAMBAYEQUE', 'PE'),
(15, 'LIMA', 'PE'),
(16, 'LORETO', 'PE'),
(17, 'MADRE DE DIOS', 'PE'),
(18, 'MOQUEGUA', 'PE'),
(19, 'PASCO', 'PE'),
(20, 'PIURA', 'PE'),
(21, 'PUNO', 'PE'),
(22, 'SAN MARTIN', 'PE'),
(23, 'TACNA', 'PE'),
(24, 'TUMBES', 'PE'),
(25, 'UCAYALI', 'PE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecomprobante`
--

CREATE TABLE `detallecomprobante` (
  `cantidad` int(11) NOT NULL,
  `precioUnitario` double NOT NULL,
  `valorDeVenta` double NOT NULL,
  `serieComprobante` char(6) NOT NULL,
  `codigoTarifa` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallereceta`
--

CREATE TABLE `detallereceta` (
  `prescripcion` varchar(200) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `serieReceta` char(8) NOT NULL,
  `idMedicamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

CREATE TABLE `distrito` (
  `codigoPostal` char(8) NOT NULL,
  `distrito` varchar(100) NOT NULL,
  `idProvincia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`codigoPostal`, `distrito`, `idProvincia`) VALUES
('10101', 'CHACHAPOYAS', 1),
('10102', 'ASUNCÍON', 1),
('10103', 'BALSAS', 1),
('10104', 'CHETO', 1),
('10105', 'CHILIQUÍN', 1),
('10106', 'CHUQUIBAMBA', 1),
('10107', 'GRANADA', 1),
('10108', 'HUANCAS', 1),
('10109', 'JALCA', 1),
('10110', 'LEIMEBAMBA', 1),
('10111', 'LEVANTO', 1),
('10112', 'MAGDALENA', 1),
('10113', 'MARISCAL CASTILLA', 1),
('10114', 'MOLINOPAMPA', 1),
('10115', 'MONTEVIDEO', 1),
('10116', 'OLLORES', 1),
('10117', 'QUINJALCA', 1),
('10118', 'SANFRANCISCO DE DAGUAS', 1),
('10119', 'SAN ISIDRO DE MAINO', 1),
('10120', 'SOLOCO', 1),
('10121', 'SONCHE', 1),
('10201', 'BAGUA', 2),
('10202', 'ARAMANGO', 2),
('10203', 'COPALLÍN', 2),
('10204', 'EL PARCO', 2),
('10205', 'IMAZA', 2),
('10206', 'LA PECA', 2),
('10301', 'JUMBILLA', 3),
('10302', 'CHISQUILLA', 3),
('10303', 'CHURUJA', 3),
('10304', 'COROSHA', 3),
('10305', 'CUISPES', 3),
('10306', 'FLORIDA', 3),
('10307', 'JAZÁN', 3),
('10308', 'RECTA', 3),
('10309', 'SAN CARLOS', 3),
('10310', 'SHIPASBAMBA', 3),
('10311', 'VALERA', 3),
('10312', 'YAMBRASBAMBA', 3),
('10401', 'NIEVA', 4),
('10402', 'EL CENEPA', 4),
('10501', 'LÁMUD', 5),
('10502', 'CAMPORREDONDO', 5),
('10503', 'COCABAMBA', 5),
('10504', 'COLCAMAR', 5),
('10505', 'CONILA', 5),
('10704', 'EL MILAGRO', 7),
('20101', 'HUARAZ', 8),
('30101', 'ABANCAY', 28);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfermedades`
--

CREATE TABLE `enfermedades` (
  `codigoEnf` char(4) NOT NULL,
  `nomEnfermedad` varchar(200) NOT NULL,
  `idCatEnfermedad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

CREATE TABLE `especialidades` (
  `idEspecialidad` int(11) NOT NULL,
  `nomEspecialidad` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialistas`
--

CREATE TABLE `especialistas` (
  `idEspecialista` int(11) NOT NULL,
  `nombres` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `aPaterno` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `aMaterno` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `numDocumento` char(11) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `telefono` char(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `idTipoDoc` int(11) NOT NULL,
  `idEspecialidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examenes`
--

CREATE TABLE `examenes` (
  `idExamenen` int(11) NOT NULL,
  `tipoExamen` varchar(100) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `codigoTarifa` char(6) NOT NULL,
  `fecha` date NOT NULL,
  `serieRadiografia` char(6) NOT NULL,
  `idTratamiento` int(11) NOT NULL,
  `codigoEnfermedad` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialclinico`
--

CREATE TABLE `historialclinico` (
  `serie` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idConsulta` int(11) NOT NULL,
  `idTratamiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `idMedicamentos` int(11) NOT NULL,
  `nomMedicamento` varchar(100) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `idCategoriaMedicamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `aPaterno` varchar(50) NOT NULL,
  `aMaterno` varchar(50) NOT NULL,
  `numDocumento` varchar(10) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `codigoDistrito` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombres`, `aPaterno`, `aMaterno`, `numDocumento`, `fechaNacimiento`, `telefono`, `email`, `direccion`, `idTipoDocumento`, `codigoDistrito`) VALUES
(1, 'JORGE LUIS', 'CASTREJON', 'TARRILLO', '87456123', '2002-09-06', '9999999999', 'admin@gmail.com', 'JR', 1, '10201'),
(2, 'ERICK FABRICIO', 'AYMA', 'MORENO', '72080871', '2002-09-06', '975934929', 'erick@gmail.com', 'JR. CH', 1, '10704');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL,
  `fechaPago` date NOT NULL,
  `monto` double NOT NULL,
  `totalPagar` double NOT NULL,
  `vuelto` int(11) NOT NULL,
  `idTipoPago` int(11) NOT NULL,
  `serieComprobante` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `avPais` char(2) NOT NULL,
  `pais` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`avPais`, `pais`) VALUES
('PE', 'PERÚ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `idProvincia` int(11) NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `idDepartamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`idProvincia`, `provincia`, `idDepartamento`) VALUES
(1, 'CHACHAPOYAS', 1),
(2, 'BAGUA', 1),
(3, 'BONGARÁ', 1),
(4, 'CONDORCANQUI', 1),
(5, 'LUYA', 1),
(6, 'RODRÍGUEZ DE MENDOZA', 1),
(7, 'UTCUBAMBA', 1),
(8, 'HUARAZ', 2),
(9, 'AIJA', 2),
(10, 'ANTONIO RAIMONDI', 2),
(11, 'ASUNCIÓN', 2),
(12, 'BOLOGNESI', 2),
(13, 'CARHUAZ', 2),
(14, 'CARLOS FERMÍN FITZACARRALD', 2),
(15, 'CASMA', 2),
(16, 'CORONGO', 2),
(17, 'HUARI', 2),
(18, 'HUARMEY', 2),
(19, 'HUAYLAS', 2),
(20, 'MARISCAL LUZURIAGA', 2),
(21, 'OCROS', 2),
(22, 'PALLASCA', 2),
(23, 'POMABAMBA', 2),
(24, 'RECUAY', 2),
(25, 'SANTA', 2),
(26, 'SIHUAS', 2),
(27, 'YUNGAY', 2),
(28, 'ABANCAY', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `radiografia`
--

CREATE TABLE `radiografia` (
  `serieRadiografia` char(6) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `idTipoRadiografia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `serieRecetaMedica` char(6) NOT NULL,
  `fecha` date NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idEspecialista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `idServicio` int(11) NOT NULL,
  `nomServicio` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idTarifa` int(11) NOT NULL,
  `idEspecialista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `codTarifa` char(6) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodato`
--

CREATE TABLE `tipodato` (
  `idTipoDato` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idTipoDocumento` int(11) NOT NULL,
  `documento` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idTipoDocumento`, `documento`) VALUES
(1, 'DNI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiporadiografia`
--

CREATE TABLE `tiporadiografia` (
  `idTipoRadiografia` int(11) NOT NULL,
  `tipoRadioigrafia` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL,
  `rol` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`idTipoUsuario`, `rol`) VALUES
(1, 'ADMINISTRADOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `idTratamiento` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `codigoTarifa` char(6) NOT NULL,
  `idServicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `aPaterno` varchar(50) NOT NULL,
  `aMaternos` varchar(50) NOT NULL,
  `numDocumento` varchar(10) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(32) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `codigoDistrito` char(8) NOT NULL,
  `idTipoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombres`, `aPaterno`, `aMaternos`, `numDocumento`, `usuario`, `contraseña`, `fechaNacimiento`, `telefono`, `direccion`, `idTipoDocumento`, `codigoDistrito`, `idTipoUsuario`) VALUES
(1, 'ERICK FABRICIO', 'AYMA', 'MORENO', '72080871', 'erick', 'fd3cab18116ddcc12f595736eb7662e0', '2002-09-06', '975934929', 'JR. CHULUCANAS N°186', 1, '10201', 1),
(2, 'GABRIEL OMAR', 'IZQUIERDO', 'VILLALOBOS', '87654321', 'GABI', '81dc9bdb52d04dc20036dbd8313ed055', '2022-05-23', '9999999999', 'JR', 1, '10201', 1),
(3, 'ENMA', 'BARTUREN', 'GUEVARA', '87615432', 'ENMA', 'd93591bdf7860e1e4ee2fca799911215', '2022-05-09', '9999999999', 'jr.', 1, '10201', 1),
(4, 'JUANA MAGDALENA', 'GIL', 'PEREZ', '87615432', 'JUANA', '81dc9bdb52d04dc20036dbd8313ed055', '2022-05-23', '9999999999', 'JR', 1, '10201', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoriaenfermedades`
--
ALTER TABLE `categoriaenfermedades`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `categoriameicamento`
--
ALTER TABLE `categoriameicamento`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `idEspecialista` (`idEspecialista`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`serieComprobante`),
  ADD UNIQUE KEY `serieComprobante` (`serieComprobante`),
  ADD KEY `idEspecialista` (`idEspecialista`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `idTipoDocumento` (`idTipoDocumento`);

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`idConsulta`),
  ADD KEY `idEspecialista` (`idEspecialista`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `codigoTarifa` (`codigoTarifa`);

--
-- Indices de la tabla `datosempresa`
--
ALTER TABLE `datosempresa`
  ADD PRIMARY KEY (`idEmpresa`),
  ADD KEY `codDistrito` (`codDistrito`),
  ADD KEY `idTipoDoc` (`idTipoDoc`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`idDepartamento`),
  ADD KEY `avPais` (`avPais`);

--
-- Indices de la tabla `detallecomprobante`
--
ALTER TABLE `detallecomprobante`
  ADD KEY `serieComprobante` (`serieComprobante`),
  ADD KEY `codigoTarifa` (`codigoTarifa`);

--
-- Indices de la tabla `detallereceta`
--
ALTER TABLE `detallereceta`
  ADD KEY `serieReceta` (`serieReceta`),
  ADD KEY `idMedicamento` (`idMedicamento`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`codigoPostal`),
  ADD KEY `idProvincia` (`idProvincia`);

--
-- Indices de la tabla `enfermedades`
--
ALTER TABLE `enfermedades`
  ADD PRIMARY KEY (`codigoEnf`),
  ADD UNIQUE KEY `codigoEnf` (`codigoEnf`),
  ADD KEY `idCatEnfermedad` (`idCatEnfermedad`);

--
-- Indices de la tabla `especialidades`
--
ALTER TABLE `especialidades`
  ADD PRIMARY KEY (`idEspecialidad`);

--
-- Indices de la tabla `especialistas`
--
ALTER TABLE `especialistas`
  ADD PRIMARY KEY (`idEspecialista`),
  ADD KEY `idEspecialidad` (`idEspecialidad`),
  ADD KEY `idTipoDoc` (`idTipoDoc`);

--
-- Indices de la tabla `examenes`
--
ALTER TABLE `examenes`
  ADD PRIMARY KEY (`idExamenen`),
  ADD KEY `serieRadiografia` (`serieRadiografia`),
  ADD KEY `idTratamiento` (`idTratamiento`),
  ADD KEY `codigoEnfermedad` (`codigoEnfermedad`),
  ADD KEY `codigoTarifa` (`codigoTarifa`);

--
-- Indices de la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  ADD PRIMARY KEY (`serie`),
  ADD KEY `idConsulta` (`idConsulta`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `idTratamiento` (`idTratamiento`);

--
-- Indices de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`idMedicamentos`),
  ADD KEY `idCategoriaMedicamento` (`idCategoriaMedicamento`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD KEY `codigoDistrito` (`codigoDistrito`),
  ADD KEY `idTipoDocumento` (`idTipoDocumento`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`idPago`),
  ADD KEY `idTipoPago` (`idTipoPago`),
  ADD KEY `serieComprobante` (`serieComprobante`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`avPais`),
  ADD UNIQUE KEY `avPais` (`avPais`);

--
-- Indices de la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD PRIMARY KEY (`idProvincia`),
  ADD KEY `idDepartamento` (`idDepartamento`);

--
-- Indices de la tabla `radiografia`
--
ALTER TABLE `radiografia`
  ADD PRIMARY KEY (`serieRadiografia`),
  ADD KEY `idTipoRadiografia` (`idTipoRadiografia`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`serieRecetaMedica`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `idEspecialista` (`idEspecialista`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`idServicio`),
  ADD KEY `idEspecialista` (`idEspecialista`),
  ADD KEY `idTarifa` (`idTarifa`);

--
-- Indices de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`codTarifa`);

--
-- Indices de la tabla `tipodato`
--
ALTER TABLE `tipodato`
  ADD PRIMARY KEY (`idTipoDato`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idTipoDocumento`);

--
-- Indices de la tabla `tiporadiografia`
--
ALTER TABLE `tiporadiografia`
  ADD PRIMARY KEY (`idTipoRadiografia`);

--
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`idTratamiento`),
  ADD KEY `idServicio` (`idServicio`),
  ADD KEY `codigoTarifa` (`codigoTarifa`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `codigoDistrito` (`codigoDistrito`),
  ADD KEY `idTipoDocumento` (`idTipoDocumento`),
  ADD KEY `idTipoUsuario` (`idTipoUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoriaenfermedades`
--
ALTER TABLE `categoriaenfermedades`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `idCita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `idDepartamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `provincia`
--
ALTER TABLE `provincia`
  MODIFY `idProvincia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`idEspecialista`) REFERENCES `especialistas` (`idEspecialista`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD CONSTRAINT `comprobante_ibfk_1` FOREIGN KEY (`idEspecialista`) REFERENCES `especialistas` (`idEspecialista`),
  ADD CONSTRAINT `comprobante_ibfk_2` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `comprobante_ibfk_3` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`);

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`idEspecialista`) REFERENCES `especialistas` (`idEspecialista`),
  ADD CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `consulta_ibfk_3` FOREIGN KEY (`codigoTarifa`) REFERENCES `tarifa` (`codTarifa`);

--
-- Filtros para la tabla `datosempresa`
--
ALTER TABLE `datosempresa`
  ADD CONSTRAINT `datosempresa_ibfk_1` FOREIGN KEY (`codDistrito`) REFERENCES `distrito` (`codigoPostal`),
  ADD CONSTRAINT `datosempresa_ibfk_2` FOREIGN KEY (`idTipoDoc`) REFERENCES `tipodocumento` (`idTipoDocumento`);

--
-- Filtros para la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD CONSTRAINT `departamento_ibfk_1` FOREIGN KEY (`avPais`) REFERENCES `pais` (`avPais`);

--
-- Filtros para la tabla `detallecomprobante`
--
ALTER TABLE `detallecomprobante`
  ADD CONSTRAINT `detallecomprobante_ibfk_1` FOREIGN KEY (`serieComprobante`) REFERENCES `comprobante` (`serieComprobante`),
  ADD CONSTRAINT `detallecomprobante_ibfk_2` FOREIGN KEY (`codigoTarifa`) REFERENCES `tarifa` (`codTarifa`);

--
-- Filtros para la tabla `detallereceta`
--
ALTER TABLE `detallereceta`
  ADD CONSTRAINT `detallereceta_ibfk_1` FOREIGN KEY (`serieReceta`) REFERENCES `receta` (`serieRecetaMedica`),
  ADD CONSTRAINT `detallereceta_ibfk_2` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamentos` (`idMedicamentos`);

--
-- Filtros para la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD CONSTRAINT `distrito_ibfk_1` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idProvincia`);

--
-- Filtros para la tabla `enfermedades`
--
ALTER TABLE `enfermedades`
  ADD CONSTRAINT `enfermedades_ibfk_1` FOREIGN KEY (`idCatEnfermedad`) REFERENCES `categoriaenfermedades` (`idCategoria`);

--
-- Filtros para la tabla `especialistas`
--
ALTER TABLE `especialistas`
  ADD CONSTRAINT `especialistas_ibfk_1` FOREIGN KEY (`idEspecialidad`) REFERENCES `especialidades` (`idEspecialidad`),
  ADD CONSTRAINT `especialistas_ibfk_2` FOREIGN KEY (`idTipoDoc`) REFERENCES `tipodocumento` (`idTipoDocumento`);

--
-- Filtros para la tabla `examenes`
--
ALTER TABLE `examenes`
  ADD CONSTRAINT `examenes_ibfk_1` FOREIGN KEY (`serieRadiografia`) REFERENCES `radiografia` (`serieRadiografia`),
  ADD CONSTRAINT `examenes_ibfk_2` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`idTratamiento`),
  ADD CONSTRAINT `examenes_ibfk_3` FOREIGN KEY (`codigoEnfermedad`) REFERENCES `enfermedades` (`codigoEnf`),
  ADD CONSTRAINT `examenes_ibfk_4` FOREIGN KEY (`codigoTarifa`) REFERENCES `tarifa` (`codTarifa`);

--
-- Filtros para la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  ADD CONSTRAINT `historialclinico_ibfk_1` FOREIGN KEY (`idConsulta`) REFERENCES `consulta` (`idConsulta`),
  ADD CONSTRAINT `historialclinico_ibfk_2` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `historialclinico_ibfk_3` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`idTratamiento`);

--
-- Filtros para la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD CONSTRAINT `medicamentos_ibfk_1` FOREIGN KEY (`idCategoriaMedicamento`) REFERENCES `categoriameicamento` (`idCategoria`);

--
-- Filtros para la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`codigoDistrito`) REFERENCES `distrito` (`codigoPostal`),
  ADD CONSTRAINT `paciente_ibfk_2` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`idTipoPago`) REFERENCES `pago` (`idPago`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`serieComprobante`) REFERENCES `comprobante` (`serieComprobante`);

--
-- Filtros para la tabla `provincia`
--
ALTER TABLE `provincia`
  ADD CONSTRAINT `provincia_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`);

--
-- Filtros para la tabla `radiografia`
--
ALTER TABLE `radiografia`
  ADD CONSTRAINT `radiografia_ibfk_1` FOREIGN KEY (`idTipoRadiografia`) REFERENCES `tiporadiografia` (`idTipoRadiografia`);

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `receta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`),
  ADD CONSTRAINT `receta_ibfk_2` FOREIGN KEY (`idEspecialista`) REFERENCES `especialistas` (`idEspecialista`);

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_ibfk_1` FOREIGN KEY (`idEspecialista`) REFERENCES `especialistas` (`idEspecialista`);

--
-- Filtros para la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD CONSTRAINT `tratamiento_ibfk_1` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicio`),
  ADD CONSTRAINT `tratamiento_ibfk_2` FOREIGN KEY (`codigoTarifa`) REFERENCES `tarifa` (`codTarifa`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`codigoDistrito`) REFERENCES `distrito` (`codigoPostal`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`),
  ADD CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`idTipoUsuario`) REFERENCES `tipousuario` (`idTipoUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
