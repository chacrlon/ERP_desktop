-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2019 a las 00:49:13
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `usuario` varchar(99) NOT NULL,
  `descripcion` varchar(99) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `id_bitacora` int(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`usuario`, `descripcion`, `fecha`, `hora`, `id_bitacora`) VALUES
('thor', 'Modifico los parametros adicionales', '2019-04-12', '14:41:06', 1),
('thor', 'El usuario inicio sesion', '2019-04-12', '17:36:16', 2),
('thor', 'Elimino una compra', '2019-04-12', '17:36:16', 3),
('thor', 'Realizo una venta', '2019-04-12', '17:36:16', 4),
('thor', 'Realizo una venta', '2019-04-12', '17:36:16', 5),
('thor', 'Realizo una venta', '2019-04-12', '17:36:16', 6),
('thor', 'El usuario inicio sesion', '2019-04-12', '17:40:15', 7),
('thor', 'Realizo una venta', '2019-04-12', '17:40:15', 8),
('thor', 'El usuario inicio sesion', '2019-04-12', '17:43:29', 9),
('thor', 'Realizo una venta', '2019-04-12', '17:43:29', 10),
('thor', 'El usuario inicio sesion', '2019-04-13', '17:50:20', 11),
('thor', 'El usuario inicio sesion', '2019-04-13', '17:52:47', 12),
('thor', 'El usuario inicio sesion', '2019-04-13', '17:54:16', 13),
('thor', 'El usuario inicio sesion', '2019-04-13', '17:58:11', 14),
('thor', 'Realizo una venta', '2019-04-13', '17:58:11', 15),
('thor', 'Realizo una venta', '2019-04-13', '17:58:11', 16),
('thor', 'El usuario inicio sesion', '2019-04-13', '18:14:43', 17),
('thor', 'Registro una compra', '2019-04-13', '18:14:43', 18),
('thor', 'Registro una compra', '2019-04-13', '18:14:43', 19),
('thor', 'Elimino una compra', '2019-04-13', '18:14:43', 20),
('thor', 'El usuario inicio sesion', '2019-04-14', '20:22:31', 21),
('thor', 'El usuario inicio sesion', '2019-04-14', '20:29:16', 22),
('thor', 'El usuario inicio sesion', '2019-04-14', '20:33:44', 23),
('thor', 'El usuario inicio sesion', '2019-04-14', '20:42:03', 24),
('thor', 'El usuario inicio sesion', '2019-04-14', '20:46:32', 25),
('thor', 'El usuario inicio sesion', '2019-04-15', '16:02:16', 26),
('thor', 'El usuario inicio sesion', '2019-04-15', '16:06:39', 27),
('thor', 'El usuario inicio sesion', '2019-04-15', '16:08:37', 28),
('thor', 'El usuario inicio sesion', '2019-04-15', '16:11:24', 29),
('thor', 'Elimino un registro de venta', '2019-04-15', '16:11:40', 30),
('thor', 'El usuario inicio sesion', '2019-05-21', '21:47:07', 31),
('thor', 'El usuario inicio sesion', '2019-05-21', '22:21:02', 32),
('thor', 'El usuario inicio sesion', '2019-05-21', '23:05:53', 33),
('thor', 'Exporto la tabla Clientes a Excel', '2019-05-21', '23:05:51', 34),
('thor', 'El usuario inicio sesion', '2019-07-24', '17:51:46', 35),
('thor', 'El usuario inicio sesion', '2019-10-17', '14:12:24', 36),
('thor', 'Exporto la tabla Clientes a Excel', '2019-10-17', '14:12:22', 37),
('thor', 'El usuario inicio sesion', '2019-10-17', '14:43:26', 38),
('thor', 'Registro un cliente', '2019-10-17', '14:43:25', 39),
('thor', 'Registro una compra', '2019-10-17', '14:43:25', 40),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:15:32', 41),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:22:18', 42),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:25:32', 43),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:27:53', 44),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:32:09', 45),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:34:54', 46),
('thor', 'Modifico los valores de una compra', '2019-10-17', '15:34:53', 47),
('thor', 'Modifico los valores de una compra', '2019-10-17', '15:34:53', 48),
('thor', 'Modifico los valores de una compra', '2019-10-17', '15:34:53', 49),
('thor', 'Modifico los valores de una compra', '2019-10-17', '15:34:53', 50),
('thor', 'Modifico los valores de una compra', '2019-10-17', '15:34:53', 51),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:38:15', 52),
('thor', 'El usuario inicio sesion', '2019-10-17', '15:44:16', 53),
('thor', 'Modifico los datos de un proveedor', '2019-10-17', '15:44:14', 54),
('thor', 'Registro un nuevo material', '2019-10-17', '15:44:14', 55),
('thor', 'Modifico los datos de un material', '2019-10-17', '15:44:14', 56),
('thor', 'El usuario inicio sesion', '2019-10-17', '16:17:00', 57),
('thor', 'El usuario inicio sesion', '2019-10-17', '16:23:55', 58),
('thor', 'El usuario inicio sesion', '2019-10-17', '16:50:41', 59),
('thor', 'Elimino un registro de la bitacora', '2019-10-17', '16:50:40', 60),
('thor', 'El usuario inicio sesion', '2019-10-17', '17:16:33', 61),
('thor', 'Elimino un registro de la bitacora', '2019-10-17', '17:16:32', 62),
('thor', 'Elimino un registro de la bitacora', '2019-10-17', '17:16:32', 63),
('thor', 'Elimino un registro de la bitacora', '2019-10-17', '17:16:32', 64),
('thor', 'Elimino un registro de la bitacora', '2019-10-17', '17:16:32', 65),
('thor', 'Elimino un registro de la bitacora', '2019-10-17', '17:16:32', 66),
('thor', 'El usuario inicio sesion', '2019-10-17', '17:42:01', 68),
('thor', 'El usuario inicio sesion', '2019-10-17', '17:43:08', 69),
('thor', 'El usuario inicio sesion', '2019-10-17', '17:51:52', 70),
('Judithh', 'El usuario inicio sesion', '2019-10-17', '17:53:28', 71),
('Judithh', 'El usuario inicio sesion', '2019-10-17', '17:54:40', 72),
('juana', 'El usuario inicio sesion', '2019-10-17', '17:55:14', 73),
('thor', 'El usuario inicio sesion', '2019-10-17', '17:55:59', 74),
('thor', 'El usuario inicio sesion', '2019-10-17', '18:06:03', 75),
('thor', 'El usuario inicio sesion', '2019-10-17', '18:07:00', 76),
('thor', 'El usuario inicio sesion', '2019-10-17', '18:17:08', 78),
('thor', 'El usuario inicio sesion', '2019-10-17', '18:43:28', 79),
('thor', 'El usuario inicio sesion', '2019-10-17', '18:58:06', 80),
('thor', 'El usuario inicio sesion', '2019-10-17', '19:33:29', 81),
('thor', 'Elimino a un proveedor', '2019-10-17', '19:15:26', 83),
('thor', 'Elimino a un proveedor', '2019-10-17', '19:15:26', 84),
('thor', 'Elimino a un proveedor', '2019-10-17', '19:15:26', 85),
('thor', 'Elimino a un proveedor', '2019-10-17', '19:15:26', 86),
('thor', 'Elimino a un proveedor', '2019-10-17', '19:15:26', 87),
('thor', 'Modifico los datos de un material', '2019-10-17', '19:15:26', 88),
('thor', 'Elimino a un usuario', '2019-10-17', '19:15:26', 89),
('thor', 'Elimino a un usuario', '2019-10-17', '19:15:26', 90),
('thor', 'Elimino a un usuario', '2019-10-17', '19:15:26', 91),
('thor', 'Elimino un registro de venta', '2019-10-17', '19:18:37', 92),
('thor', 'El usuario inicio sesion', '2019-10-17', '19:21:21', 93),
('thor', 'Elimino a un usuario', '2019-10-17', '19:21:20', 94),
('thor', 'Elimino a un usuario', '2019-10-17', '19:21:20', 95),
('thor', 'Elimino a un usuario', '2019-10-17', '19:21:20', 96),
('thor', 'Elimino a un usuario', '2019-10-17', '19:21:20', 97),
('thor', 'Elimino a un usuario', '2019-10-17', '19:21:20', 98),
('thor', 'El usuario inicio sesion', '2019-10-17', '19:23:03', 99),
('thor', 'Elimino a un usuario', '2019-10-17', '19:23:02', 100),
('thor', 'Elimino a un usuario', '2019-10-17', '19:23:02', 101),
('thor', 'Modifico los datos de un usuario', '2019-10-17', '19:23:02', 102),
('thor', 'Modifico los datos de un usuario', '2019-10-17', '19:23:02', 103),
('thor', 'El usuario inicio sesion', '2019-11-23', '15:08:05', 104),
('thor', 'El usuario inicio sesion', '2019-11-23', '17:39:03', 105),
('thor', 'El usuario inicio sesion', '2019-11-23', '17:41:57', 106),
('thor', 'El usuario inicio sesion', '2019-11-23', '17:43:45', 107),
('thor', 'El usuario inicio sesion', '2019-11-23', '17:46:53', 108),
('thor', 'El usuario inicio sesion', '2019-11-23', '17:50:10', 109),
('thor', 'El usuario inicio sesion', '2019-11-23', '17:52:09', 110),
('thor', 'El usuario inicio sesion', '2019-11-23', '17:53:39', 111),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:19:51', 112),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:22:17', 113),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:23:51', 114),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:24:56', 115),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:27:47', 116),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:33:28', 117),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:34:32', 118),
('thor', 'Modifico los datos de un material', '2019-11-23', '18:34:31', 119),
('thor', 'Modifico los datos de un material', '2019-11-23', '18:34:31', 120),
('thor', 'Modifico los datos de un material', '2019-11-23', '18:34:31', 121),
('thor', 'Registro un nuevo material', '2019-11-23', '18:34:31', 122),
('thor', 'Registro un nuevo material', '2019-11-23', '18:34:31', 123),
('thor', 'Modifico los datos de un material', '2019-11-23', '18:34:31', 124),
('thor', 'Registro un nuevo material', '2019-11-23', '18:34:31', 125),
('thor', 'Elimino un material', '2019-11-23', '18:34:31', 126),
('thor', 'Elimino un material', '2019-11-23', '18:34:31', 127),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:43:11', 128),
('thor', 'Registro un nuevo material', '2019-11-23', '18:43:11', 129),
('thor', 'Registro un nuevo material', '2019-11-23', '18:43:11', 130),
('thor', 'Registro un nuevo material', '2019-11-23', '18:43:11', 131),
('thor', 'Registro un nuevo material', '2019-11-23', '18:43:11', 132),
('thor', 'Registro un nuevo material', '2019-11-23', '18:43:11', 133),
('thor', 'Registro un nuevo material', '2019-11-23', '18:43:11', 134),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:50:40', 135),
('thor', 'Registro un nuevo material', '2019-11-23', '18:50:39', 136),
('thor', 'El usuario inicio sesion', '2019-11-23', '18:52:01', 137),
('thor', 'Registro un nuevo material', '2019-11-23', '18:52:00', 138),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:06:32', 139),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:12:20', 140),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:25:33', 141),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:27:01', 142),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:28:09', 143),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:30:26', 144),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:48:30', 145),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:50:39', 146),
('thor', 'Registro un nuevo material', '2019-11-23', '19:50:39', 147),
('thor', 'Registro un nuevo material', '2019-11-23', '19:50:39', 148),
('thor', 'Registro un nuevo material', '2019-11-23', '19:50:39', 149),
('thor', 'Modifico los datos de un material', '2019-11-23', '19:50:39', 150),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:54:59', 151),
('thor', 'Registro un nuevo material', '2019-11-23', '19:54:58', 152),
('thor', 'Registro un nuevo material', '2019-11-23', '19:54:58', 153),
('thor', 'Modifico los datos de un material', '2019-11-23', '19:54:58', 154),
('thor', 'El usuario inicio sesion', '2019-11-23', '19:56:51', 155),
('thor', 'Modifico los datos de un material', '2019-11-23', '19:56:50', 156),
('thor', 'El usuario inicio sesion', '2019-11-23', '23:31:23', 157),
('thor', 'Registro un nuevo material', '2019-11-23', '23:31:21', 158),
('thor', 'Registro un nuevo material', '2019-11-23', '23:31:21', 159),
('thor', 'El usuario inicio sesion', '2019-11-23', '23:35:26', 160),
('thor', 'Registro un nuevo material', '2019-11-23', '23:35:25', 161),
('thor', 'Registro un nuevo material', '2019-11-23', '23:35:25', 162),
('thor', 'Elimino un material', '2019-11-23', '23:35:25', 163),
('thor', 'Modifico los datos de un material', '2019-11-23', '23:35:25', 164),
('thor', 'El usuario inicio sesion', '2019-11-23', '23:39:34', 165),
('thor', 'Registro un nuevo material', '2019-11-23', '23:39:32', 166),
('thor', 'Registro un nuevo material', '2019-11-23', '23:39:32', 167),
('thor', 'El usuario inicio sesion', '2019-11-23', '23:43:04', 168),
('thor', 'Registro un nuevo material', '2019-11-23', '23:43:04', 169),
('thor', 'El usuario inicio sesion', '2019-11-23', '23:45:24', 170),
('thor', 'Registro un nuevo material', '2019-11-23', '23:45:23', 171),
('thor', 'Registro un nuevo material', '2019-11-23', '23:45:23', 172),
('thor', 'El usuario inicio sesion', '2019-11-23', '23:55:34', 173),
('thor', 'El usuario inicio sesion', '2019-11-23', '23:59:57', 174),
('thor', 'El usuario inicio sesion', '2019-11-24', '00:06:34', 175),
('thor', 'El usuario inicio sesion', '2019-11-24', '00:07:47', 176),
('thor', 'El usuario inicio sesion', '2019-11-24', '00:08:51', 177),
('thor', 'El usuario inicio sesion', '2019-11-24', '00:18:16', 178),
('thor', 'Modifico los parametros adicionales', '2019-11-24', '00:18:14', 179),
('thor', 'Modifico los parametros adicionales', '2019-11-24', '00:18:14', 180),
('thor', 'El usuario inicio sesion', '2019-11-24', '00:45:21', 181),
('thor', 'Modifico los datos de un material', '2019-11-24', '00:45:20', 182),
('thor', 'El usuario inicio sesion', '2019-11-24', '00:48:12', 183),
('thor', 'El usuario inicio sesion', '2019-11-24', '00:57:22', 184),
('thor', 'Registro un nuevo material', '2019-11-24', '00:57:21', 185),
('thor', 'El usuario inicio sesion', '2019-11-24', '01:00:11', 186),
('thor', 'Registro un nuevo material', '2019-11-24', '01:00:10', 187),
('thor', 'El usuario inicio sesion', '2019-11-24', '01:03:09', 188),
('thor', 'Registro un nuevo material', '2019-11-24', '01:03:08', 189),
('thor', 'El usuario inicio sesion', '2019-11-24', '01:05:00', 190),
('thor', 'Registro un nuevo material', '2019-11-24', '01:04:58', 191),
('thor', 'El usuario inicio sesion', '2019-11-24', '01:09:57', 192),
('thor', 'Registro un nuevo material', '2019-11-24', '01:09:56', 193),
('thor', 'Registro un nuevo material', '2019-11-24', '01:09:56', 194),
('thor', 'El usuario inicio sesion', '2019-11-24', '01:12:41', 195),
('thor', 'Registro un nuevo material', '2019-11-24', '01:12:39', 196),
('thor', 'El usuario inicio sesion', '2019-11-24', '16:37:03', 197),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 198),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 199),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 200),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 201),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 202),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 203),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 204),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 205),
('thor', 'Registro un nuevo material', '2019-11-24', '16:37:01', 206),
('thor', 'El usuario inicio sesion', '2019-11-24', '16:53:38', 207),
('thor', 'El usuario inicio sesion', '2019-11-24', '17:09:31', 208),
('thor', 'El usuario inicio sesion', '2019-11-24', '17:19:03', 209),
('thor', 'Registro un nuevo material', '2019-11-24', '17:19:02', 210),
('thor', 'Registro un nuevo material', '2019-11-24', '17:19:02', 211),
('thor', 'Registro un nuevo material', '2019-11-24', '17:19:02', 212),
('thor', 'El usuario inicio sesion', '2019-11-24', '17:21:12', 213),
('thor', 'El usuario inicio sesion', '2019-11-24', '17:23:50', 214),
('thor', 'Registro un nuevo material', '2019-11-24', '17:23:50', 215),
('thor', 'Registro un nuevo material', '2019-11-24', '17:23:50', 216),
('thor', 'Registro un nuevo material', '2019-11-24', '17:23:50', 217),
('thor', 'Registro un nuevo material', '2019-11-24', '17:23:50', 218),
('thor', 'Modifico los datos de un material', '2019-11-24', '17:23:50', 219),
('thor', 'Elimino un material', '2019-11-24', '17:23:50', 220),
('thor', 'Elimino un material', '2019-11-24', '17:23:50', 221),
('thor', 'Elimino un material', '2019-11-24', '17:23:50', 222),
('thor', 'Elimino un material', '2019-11-24', '17:23:50', 223),
('thor', 'El usuario inicio sesion', '2019-11-24', '17:41:05', 224),
('thor', 'Registro un nuevo material', '2019-11-24', '17:41:02', 225),
('thor', 'Registro un nuevo material', '2019-11-24', '17:41:02', 226),
('thor', 'Registro un nuevo material', '2019-11-24', '17:41:02', 227),
('thor', 'Registro un nuevo material', '2019-11-24', '17:41:02', 228),
('thor', 'El usuario inicio sesion', '2019-11-24', '17:44:15', 229),
('thor', 'Elimino un material', '2019-11-24', '17:44:13', 230),
('thor', 'Elimino un material', '2019-11-24', '17:44:13', 231),
('thor', 'Elimino un material', '2019-11-24', '17:44:13', 232),
('thor', 'Elimino un material', '2019-11-24', '17:44:13', 233),
('thor', 'Registro un nuevo material', '2019-11-24', '17:44:13', 234),
('thor', 'Registro un nuevo material', '2019-11-24', '17:44:13', 235),
('thor', 'Registro un nuevo material', '2019-11-24', '17:44:13', 236),
('thor', 'Registro un nuevo material', '2019-11-24', '17:44:13', 237),
('thor', 'Registro un nuevo material', '2019-11-24', '17:44:13', 238),
('thor', 'El usuario inicio sesion', '2019-11-24', '17:59:36', 239),
('thor', 'Modifico los datos de un material', '2019-11-24', '17:59:35', 240),
('thor', 'El usuario inicio sesion', '2019-11-24', '18:01:06', 241),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:01:04', 242),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:01:04', 243),
('thor', 'El usuario inicio sesion', '2019-11-24', '18:04:36', 244),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:04:34', 245),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:04:34', 246),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:04:34', 247),
('thor', 'El usuario inicio sesion', '2019-11-24', '18:06:42', 248),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:06:38', 249),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:06:38', 250),
('thor', 'El usuario inicio sesion', '2019-11-24', '18:21:33', 251),
('thor', 'Elimino un material', '2019-11-24', '18:21:32', 252),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:21:32', 253),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:21:32', 254),
('thor', 'Modifico los datos de un material', '2019-11-24', '18:21:32', 255),
('thor', 'El usuario inicio sesion', '2019-11-24', '18:28:53', 256),
('thor', 'El usuario inicio sesion', '2019-11-24', '18:31:55', 257),
('thor', 'El usuario inicio sesion', '2019-11-24', '19:17:39', 258),
('thor', 'Registro un nuevo material', '2019-11-24', '19:17:38', 259),
('thor', 'Modifico los datos de un usuario', '2019-11-24', '19:17:38', 260),
('thor', 'Modifico los datos de un usuario', '2019-11-24', '19:17:38', 261);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(99) NOT NULL,
  `nombre1_cliente` varchar(20) NOT NULL,
  `nombre2_cliente` varchar(20) DEFAULT NULL,
  `apellido1_cliente` varchar(20) NOT NULL,
  `apellido2_cliente` varchar(20) DEFAULT NULL,
  `cedula_cliente` varchar(20) NOT NULL,
  `telefono_cliente` varchar(20) NOT NULL,
  `correo_cliente` varchar(50) NOT NULL,
  `direccion_cliente` varchar(100) NOT NULL,
  `status_cliente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre1_cliente`, `nombre2_cliente`, `apellido1_cliente`, `apellido2_cliente`, `cedula_cliente`, `telefono_cliente`, `correo_cliente`, `direccion_cliente`, `status_cliente`) VALUES
(2, 'pablo', 'asas', 'perez', 'asas', '232323', '45454', 'asasa@gmail.com', '2323asasa', 'Activo'),
(3, 'pablorr', 'asasddd', 'perezzz', 'asasass', '23232399', '4545499', 'asasa@gmail.com', '2323asasa', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras2`
--

CREATE TABLE `compras2` (
  `codigo` varchar(99) NOT NULL,
  `id_proveedor` int(99) NOT NULL,
  `id_material` int(99) NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int(99) NOT NULL,
  `subtotal` double NOT NULL,
  `iva` double NOT NULL,
  `descuento` double NOT NULL,
  `total` double NOT NULL,
  `fecha` date NOT NULL,
  `id_compras` int(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compras2`
--

INSERT INTO `compras2` (`codigo`, `id_proveedor`, `id_material`, `precio`, `cantidad`, `subtotal`, `iva`, `descuento`, `total`, `fecha`, `id_compras`) VALUES
('0001', 1, 1, 100, 20, 2000, 0, 0, 2000, '2019-04-13', 1),
('00012', 2, 1, 100, 20, 2000, 0, 0, 2000, '2019-04-13', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `id_material` int(11) NOT NULL,
  `codigo_material` varchar(99) NOT NULL,
  `nombre_material` varchar(20) NOT NULL,
  `descripcion_material` varchar(99) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `precio_material` double NOT NULL,
  `dolar_material` double NOT NULL,
  `nomimagen` varchar(200) DEFAULT NULL,
  `imagen` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`id_material`, `codigo_material`, `nombre_material`, `descripcion_material`, `stock`, `precio_material`, `dolar_material`, `nomimagen`, `imagen`) VALUES
(20, '0001', 'Alambre', 'Alambre de metro', 50, 45000, 1.5, '', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametros_adicionales`
--

CREATE TABLE `parametros_adicionales` (
  `id_parametros_adicionales` int(11) NOT NULL,
  `nombre_empresa` varchar(40) DEFAULT NULL,
  `rif_empresa` varchar(20) DEFAULT NULL,
  `porcentaje_iva_v` int(11) DEFAULT NULL,
  `porcentaje_descuento` int(11) DEFAULT NULL,
  `dolar` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `parametros_adicionales`
--

INSERT INTO `parametros_adicionales` (`id_parametros_adicionales`, `nombre_empresa`, `rif_empresa`, `porcentaje_iva_v`, `porcentaje_descuento`, `dolar`) VALUES
(1, 'Materiales Hierro Macarao', '', 30, 30, 30000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `codigo_proveedor` varchar(8) NOT NULL,
  `nombre_proveedor` varchar(40) NOT NULL,
  `rif_proveedor` varchar(20) NOT NULL,
  `telefono_proveedor` varchar(20) NOT NULL,
  `correo_proveedor` varchar(50) NOT NULL,
  `direccion_proveedor` varchar(50) NOT NULL,
  `status_proveedor` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `codigo_proveedor`, `nombre_proveedor`, `rif_proveedor`, `telefono_proveedor`, `correo_proveedor`, `direccion_proveedor`, `status_proveedor`) VALUES
(1, '0001', 'Macrox', '123', '04241567889', 'macro@gmail.com', 'caracas', 'Activo'),
(7, '0008', 'Macroxxxxxx', '123', '04241567889', 'macro@gmail.com', 'caracasss', 'Activo'),
(8, '0009', 'Macroxxxxxxx', '123', '04241567889', 'macro@gmail.com', 'caracas', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre1_usuario` varchar(20) NOT NULL,
  `apellido1_usuario` varchar(20) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `tipo_usuario` varchar(20) NOT NULL,
  `pregunta_seguridad` varchar(100) NOT NULL,
  `respuesta_seguridad` varchar(100) NOT NULL,
  `status_usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre1_usuario`, `apellido1_usuario`, `correo`, `clave`, `tipo_usuario`, `pregunta_seguridad`, `respuesta_seguridad`, `status_usuario`) VALUES
(2, 'maikel', 'Marquez', 'tsmaikel@gmail.com', '123', 'Administrador', '¿Eres adinerado?', 'ufff si', 'Activo'),
(5, 'Judith', 'Tarazona', 'judith', '12345', 'Encargado(a)', 'codigox', 'codigo1234', 'Activo'),
(6, 'juana', 'arco', 'juanadearco@gmail.com', '1234', 'Vendedor(a)', 'sin pregunta', 'sin respuesta', 'Activo'),
(9, 'thor', 'describan', 'thor@gmail', '1234', 'SuperUsuario', '14', '14', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas2`
--

CREATE TABLE `ventas2` (
  `codigo` varchar(99) NOT NULL,
  `vendedor` varchar(99) NOT NULL,
  `id_cliente` int(99) NOT NULL,
  `id_material` int(99) NOT NULL,
  `precio` varchar(99) NOT NULL,
  `cantidad` varchar(99) NOT NULL,
  `subtotal` varchar(99) NOT NULL,
  `iva` varchar(99) NOT NULL,
  `descuento` varchar(99) NOT NULL,
  `total` varchar(99) NOT NULL,
  `fecha` date NOT NULL,
  `id_venta` int(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`id_bitacora`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `compras2`
--
ALTER TABLE `compras2`
  ADD PRIMARY KEY (`id_compras`);

--
-- Indices de la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD PRIMARY KEY (`id_material`),
  ADD UNIQUE KEY `UQ_Materiales_codigo_material` (`codigo_material`);

--
-- Indices de la tabla `parametros_adicionales`
--
ALTER TABLE `parametros_adicionales`
  ADD PRIMARY KEY (`id_parametros_adicionales`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`),
  ADD UNIQUE KEY `UQ_Proveedor_codigo_proveedor` (`codigo_proveedor`),
  ADD KEY `nombre_proveedor` (`nombre_proveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `UQ_Usuario_correo` (`correo`);

--
-- Indices de la tabla `ventas2`
--
ALTER TABLE `ventas2`
  ADD PRIMARY KEY (`id_venta`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_material` (`id_material`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  MODIFY `id_bitacora` int(99) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=262;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(99) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `compras2`
--
ALTER TABLE `compras2`
  MODIFY `id_compras` int(99) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `materiales`
--
ALTER TABLE `materiales`
  MODIFY `id_material` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `parametros_adicionales`
--
ALTER TABLE `parametros_adicionales`
  MODIFY `id_parametros_adicionales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `ventas2`
--
ALTER TABLE `ventas2`
  MODIFY `id_venta` int(99) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ventas2`
--
ALTER TABLE `ventas2`
  ADD CONSTRAINT `ventas2_ibfk_5` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ventas2_ibfk_6` FOREIGN KEY (`id_material`) REFERENCES `materiales` (`id_material`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
