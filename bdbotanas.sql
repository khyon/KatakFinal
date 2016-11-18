-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2016 a las 11:01:34
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdbotanas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `IDCliente` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `ApPaterno` varchar(20) NOT NULL,
  `ApMaterno` varchar(20) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`IDCliente`, `Nombre`, `ApPaterno`, `ApMaterno`, `Direccion`, `Telefono`) VALUES
(1, 'Francisco Segundo', 'Ascencio', 'Vera', 'San Pedro (Manzan f lote 1)', 9267803),
(2, 'Susana Angela', 'Mora', 'Soutullo', 'Los Copihues', 5807029),
(3, 'Sonia Inés', 'Leal', 'Leal', 'Psje. Jerusalén', 8306420),
(4, 'Juan', 'Carrasco', 'Vega', 'Psje. Galilea', 9812901),
(5, 'Rosa Elena', 'Romero', 'Benavente', 'Caupolicán', 7920371),
(6, 'Heraldo', 'Cuevas', 'Orellana', 'California', 8982020),
(7, 'Alejandra del Carmen', 'Contreras', 'Rodriguez', 'Pasaje Fresia', 2147483647),
(8, 'Roguers Alberto', 'Morales', 'Navarrete', 'Pablo Neruda', 2147483647),
(9, 'Estela Mercedes', 'Zapata', 'Arriagada', 'Los Acacios', 2147483647),
(10, 'Luis Ricardo', 'Faundez', 'Retamal', 'Los Sauces Poniente', 2147483647),
(11, 'José Luis', 'Flores', 'Terán', 'Pasaje 1 Casa', 9823020),
(12, 'Ricardo', 'Pech', 'Basto', 'San José Tecoh', 2147483647),
(13, 'José Carlos', 'Broca', 'Sanchéz', 'Col. Roma', 3487291),
(14, 'Javier Alberto', 'Ortiz', 'Medina', 'Col. Obrera', 2147483647),
(15, 'Vicente', 'Yah', 'Dzul', 'Gonzalo Guerrero', 2147483647),
(16, 'Felipe', 'Chan', 'Palomo', 'Lindavista', 3873832),
(17, 'Gema', 'Ferrera', 'Euán', 'Chuburna', 2147483647),
(18, 'Daniel', 'Gleber', 'Sellers', 'Montes de Amé', 8729031),
(19, 'Alvaro Omar', 'Teyer', 'Saldivar', 'Vergel II', 2147483647),
(20, 'Pedro Pablo', 'Cetina', 'Pacheco', 'Mulsay', 2147483647);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `IDProducto` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `CantidadKg` int(11) NOT NULL,
  `PrecioKg` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`IDProducto`, `Nombre`, `CantidadKg`, `PrecioKg`) VALUES
(1, 'Charritos', 1, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `IDPedido` int(10) NOT NULL,
  `NombreCliente` varchar(20) NOT NULL,
  `TelefonoCliente` varchar(11) NOT NULL,
  `DireccionCliente` varchar(50) NOT NULL,
  `FechaDeCreacion` varchar(10) NOT NULL,
  `FechaDePedido` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`IDPedido`, `NombreCliente`, `TelefonoCliente`, `DireccionCliente`, `FechaDeCreacion`, `FechaDePedido`) VALUES
(1, 'Mario', '9991431751', 'Francisco de Montejo', '17/11/2016', '18/11/2016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IDVenta` int(10) NOT NULL,
  `FechaDeVenta` varchar(20) NOT NULL,
  `NombreCliente` varchar(20) NOT NULL,
  `DireccionCliente` varchar(50) NOT NULL,
  `PrecioVenta` double NOT NULL,
  `DetallesVenta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IDVenta`, `FechaDeVenta`, `NombreCliente`, `DireccionCliente`, `PrecioVenta`, `DetallesVenta`) VALUES
(1, '17/11/2016', 'Mario', 'Francisco de Montejo', 110, 'La venta se retraso mas de lo esperado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`IDCliente`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`IDProducto`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`IDPedido`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IDVenta`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
