-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: bsywdgqnpld6spmfxb9w-mysql.services.clever-cloud.com:3306
-- Generation Time: Jun 25, 2023 at 09:16 PM
-- Server version: 8.0.22-13
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bsywdgqnpld6spmfxb9w`
--
CREATE DATABASE IF NOT EXISTS `bsywdgqnpld6spmfxb9w` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bsywdgqnpld6spmfxb9w`;

-- --------------------------------------------------------

--
-- Table structure for table `educacion`
--

CREATE TABLE `educacion` (
  `id` int NOT NULL,
  `descripcion_ed` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre_ed` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `titulo_ed` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `imagen_ed` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `educacion`
--

INSERT INTO `educacion` (`id`, `descripcion_ed`, `nombre_ed`, `titulo_ed`, `imagen_ed`) VALUES
(13, 'especialidad en Derecho Público Administrativo, egresado en 2013. PROMEDIO 7,80.', '(UBA) Universidad de Buenos Aires', 'Título de Abogado', 'https://firebasestorage.googleapis.com/v0/b/imagenfrontend.appspot.com/o/imagen%2Feducacion%2Fuba-derecho.jpg?alt=media&token=f53b3281-282a-41f7-b0ef-f8af53c6e185'),
(14, 'Expedido en 2008', 'Universidad de Buenos Aires', 'Título intermedio de Bachiller Jurídico', 'https://firebasestorage.googleapis.com/v0/b/imagenfrontend.appspot.com/o/imagen%2Feducacion%2Fuba-derecho.jpg?alt=media&token=bd356f94-00e6-4bcb-9571-d9905c040b69'),
(15, 'ingreso en el 2003. Materias aprobadas del CBC: Semiología (8), Filosofía (8), Pensamiento científico (8), Sociología (8), Economía (4), Sociedad y Estado (5), Ciencia política (9), y Derecho (6). ', 'Universidad de Buenos Aires FILO', 'Licenciatura en Filosofía (interrumpida)', 'https://firebasestorage.googleapis.com/v0/b/imagenfrontend.appspot.com/o/imagen%2Feducacion%2Ffilo.jpg?alt=media&token=ba113b57-48d2-4ec5-9c17-3e104bf2f715');

-- --------------------------------------------------------

--
-- Table structure for table `experiencia`
--

CREATE TABLE `experiencia` (
  `id` int NOT NULL,
  `descripcion_ex` text COLLATE utf8mb4_spanish_ci,
  `titulo_ex` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `experiencia`
--

INSERT INTO `experiencia` (`id`, `descripcion_ex`, `titulo_ex`) VALUES
(5, 'Empleado administrativo (2009 a la actualidad). Con\nexperiencia en impresión, resolución de problemas, fichero, atención al ciudadano en toma de trámites e informes, confección de informes para la contestación de oficios judiciales mediante sistema GDE, asistencia a Registro Civiles en materias de competencia del organismo, entre otras tareas.', 'Registro Nacional de las Personas'),
(6, ' (sucesiones, alimentos, contratos, etc.).', 'Ejercicio privado de la profesión'),
(7, 'Tareas administrativas y de asesoría. (2008 y 2009).', 'Legislatura de la Ciudad de Bs. As'),
(8, 'Lavalle 1290, Of. 111 1er piso. 4382-0984 (2006-\n2007). ', 'Cadete jurídico, en Estudio Jurídico'),
(9, 'Belgrano 831 1º Cap. Fed. (2003-2004)', 'Cadete en Alternativa para la Empresa');

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id` int NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `imagen` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `proyecto`
--

CREATE TABLE `proyecto` (
  `id` int NOT NULL,
  `imagen_project` text COLLATE utf8mb4_spanish_ci,
  `titulo` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `url` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `proyecto`
--

INSERT INTO `proyecto` (`id`, `imagen_project`, `titulo`, `url`, `descripcion`) VALUES
(3, 'https://firebasestorage.googleapis.com/v0/b/imagenfrontend.appspot.com/o/imagen%2Fproyecto%2Fproyecto-frontend.jpg?alt=media&token=63491424-82f2-4cd1-9f91-be4d87ae2fe4', 'Proyecto-Frontend', 'https://github.com/Porfirio7/frontendPortfolio', 'Realizo mi portafolio web consumiendo de la api de spring boot, actualizo mis datos, modifico mi contenido siendo una web dinámica'),
(4, 'https://firebasestorage.googleapis.com/v0/b/imagenfrontend.appspot.com/o/imagen%2Fproyecto%2Fproyecto-Backend.png?alt=media&token=e9bb08d9-7423-4461-876a-2d85a45c5e65', 'Proyecto-Backend', 'https://github.com/Porfirio7/backendPortfolioAle', 'Es la parte del backend donde gestiono mis datos, contenido e imagenes, información vital para mi web, donde proporciono todo mis actividades, responsabilidades y habilidades en el tema');

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `id` int NOT NULL,
  `rol_perfil` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`id`, `rol_perfil`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `skills`
--

CREATE TABLE `skills` (
  `id` int NOT NULL,
  `nombre_sk` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `porcentaje` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `skills`
--

INSERT INTO `skills` (`id`, `nombre_sk`, `porcentaje`) VALUES
(1, 'PHP', 78),
(2, 'HTML', 100),
(3, 'Javascript', 50);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `descripcion` text COLLATE utf8mb4_spanish_ci,
  `email` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `imagen` text COLLATE utf8mb4_spanish_ci,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre_usuario` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `profesion` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `apellido`, `descripcion`, `email`, `imagen`, `nombre`, `nombre_usuario`, `password`, `profesion`) VALUES
(1, 'Locane', 'Soy una persona muy reflexiva, con amplia capacidad de análisis en cuestiones teóricas y\nsu resolución en cuanto a la aplicación práctica, ello me ha llevado a estudiar filosofía durante unos\naños pero que luego por diversos motivos cambié y me aboqué al estudio del derecho, lo cual me\nllevó a recibirme de Abogado con especialidad en Derecho Público Administrativo', 'test@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/imagenfrontend.appspot.com/o/imagen%2Fperfil_1?alt=media&token=9e844da8-97b7-4c09-bba8-eb2a9304be87', 'Alejandro', 'aleja', '$2a$10$Uw9kSxGzjsWsq1xd5gEGbuezaxG/mUsagAlMG3cuEvNqvxwHxXMSe', 'Abogado-Programador'),
(2, 'cliente', 'lorem ipsum...', 'user@gmail.com', 'yo.jpg', 'usuario', 'user', '$2a$10$.EZHGam4PDSsyYvsYlLbBuDsARB8ypyciPbGVJ2A4qloG.6GDqmpy', 'profesor');

-- --------------------------------------------------------

--
-- Table structure for table `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario_id` int NOT NULL,
  `rol_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `usuario_rol`
--

INSERT INTO `usuario_rol` (`usuario_id`, `rol_id`) VALUES
(1, 2),
(2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `educacion`
--
ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skills`
--
ALTER TABLE `skills`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_puhr3k3l7bj71hb7hk7ktpxn0` (`nombre_usuario`);

--
-- Indexes for table `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario_id`,`rol_id`),
  ADD KEY `FK610kvhkwcqk2pxeewur4l7bd1` (`rol_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `educacion`
--
ALTER TABLE `educacion`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `skills`
--
ALTER TABLE `skills`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK610kvhkwcqk2pxeewur4l7bd1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  ADD CONSTRAINT `FKbyfgloj439r9wr9smrms9u33r` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
