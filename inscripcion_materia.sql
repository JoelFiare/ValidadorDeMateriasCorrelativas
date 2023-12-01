-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2023 a las 02:16:16
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inscripcion_materia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `nombre`, `apellido`) VALUES
(1, 'Juan', 'Pérez'),
(2, 'María', 'Gómez'),
(3, 'Luis', 'Martínez'),
(4, 'Ana', 'Rodríguez'),
(5, 'Carlos', 'Sánchez'),
(6, 'Sofía', 'López'),
(7, 'Pedro', 'García'),
(8, 'Laura', 'Fernández'),
(9, 'Diego', 'Díaz'),
(10, 'Elena', 'Ruiz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correlatividad`
--

CREATE TABLE `correlatividad` (
  `id` int(11) NOT NULL,
  `materia_id` int(11) DEFAULT NULL,
  `correlativa_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `correlatividad`
--

INSERT INTO `correlatividad` (`id`, `materia_id`, `correlativa_id`) VALUES
(1, 10, 1),
(2, 10, 2),
(3, 11, 1),
(4, 11, 7),
(5, 12, 4),
(6, 12, 5),
(7, 13, 3),
(8, 13, 5),
(9, 14, 3),
(10, 14, 5),
(11, 15, 3),
(12, 15, 5),
(13, 15, 6),
(14, 17, 1),
(15, 17, 2),
(16, 18, 12),
(17, 18, 14),
(18, 19, 6),
(19, 19, 10),
(20, 19, 11),
(21, 20, 10),
(22, 21, 12),
(23, 21, 13),
(24, 21, 14),
(25, 23, 12),
(26, 25, 15),
(27, 25, 19),
(28, 26, 15),
(29, 26, 18),
(30, 26, 23),
(31, 27, 17),
(32, 27, 20),
(33, 28, 17),
(34, 28, 20),
(35, 29, 17),
(36, 29, 18),
(37, 29, 21),
(38, 30, 9),
(39, 30, 20),
(40, 31, 12),
(41, 31, 22),
(42, 32, 1),
(43, 32, 2),
(44, 32, 3),
(45, 32, 4),
(46, 32, 5),
(47, 32, 6),
(48, 32, 7),
(49, 32, 8),
(50, 32, 9),
(51, 32, 10),
(52, 32, 11),
(53, 32, 12),
(54, 32, 13),
(55, 32, 14),
(56, 32, 15),
(57, 32, 16),
(58, 32, 17),
(59, 32, 18),
(60, 32, 19),
(61, 32, 20),
(62, 32, 21),
(63, 32, 22),
(64, 32, 23),
(65, 32, 24),
(66, 32, 25),
(67, 32, 26),
(68, 32, 27),
(69, 32, 28),
(70, 32, 29),
(71, 32, 30),
(72, 32, 31),
(73, 32, 32),
(74, 32, 33),
(75, 32, 34),
(76, 32, 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `id` int(11) NOT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  `materia_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`id`, `alumno_id`, `materia_id`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id`, `nombre`) VALUES
(1, 'Análisis Matemático I'),
(2, 'Algebra y G. Analítica'),
(3, 'Matemática Discreta'),
(4, 'Sistemas y Organizaciones (Int.)'),
(5, 'Algoritmos y Est. de Datos'),
(6, 'Arquitectura de Computadoras'),
(7, 'Física I'),
(8, 'Inglés I'),
(9, 'Química'),
(10, 'Análisis Matemático'),
(11, 'Física II'),
(12, 'Análisis de Sistemas (Int.)'),
(13, 'Sintaxis y Semántica de los Lenguajes'),
(14, 'Paradigmas de Programación'),
(15, 'Sistemas Operativos'),
(16, 'Sistemas de Representación'),
(17, 'Probabilidades y Estadísticas'),
(18, 'Diseño de Sistemas (Int.)'),
(19, 'Comunicaciones'),
(20, 'Matemática Superior'),
(21, 'Gestión de Datos'),
(22, 'Ingeniería y Sociedad'),
(23, 'Economía'),
(24, 'Inglés II'),
(25, 'Redes de Información'),
(26, 'Administración de Recursos (Int.)'),
(27, 'Investigación Operativa'),
(28, 'Simulación'),
(29, 'Ingeniería de software'),
(30, 'Teoría de Control'),
(31, 'Legislación'),
(32, 'Proyecto Final (Int.)'),
(33, 'Inteligencia Artificial'),
(34, 'Administración Gerencial'),
(35, 'Sistemas de Gestión'),
(36, 'Materia 1'),
(37, 'Materia 2');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `correlatividad`
--
ALTER TABLE `correlatividad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `materia_id` (`materia_id`),
  ADD KEY `correlativa_id` (`correlativa_id`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `alumno_id` (`alumno_id`),
  ADD KEY `materia_id` (`materia_id`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `correlatividad`
--
ALTER TABLE `correlatividad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `correlatividad`
--
ALTER TABLE `correlatividad`
  ADD CONSTRAINT `correlatividad_ibfk_1` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`),
  ADD CONSTRAINT `correlatividad_ibfk_2` FOREIGN KEY (`correlativa_id`) REFERENCES `materia` (`id`);

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
