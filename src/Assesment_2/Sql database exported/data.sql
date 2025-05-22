-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 20, 2025 at 04:39 PM
-- Server version: 9.1.0
-- PHP Version: 8.3.14

-- Create MySQL use 'hungman' with password '1234'
CREATE USER IF NOT EXISTS 'hungman'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON hungman.* TO 'hungman'@'localhost'
FLUSH PRIVILEGES

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hungman`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
CREATE TABLE IF NOT EXISTS `data` (
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `MatchPlayed` int NOT NULL,
  `MatchWon` int NOT NULL,
  UNIQUE KEY `Username` (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`Username`, `Password`, `MatchPlayed`, `MatchWon`) VALUES
('Griseld', '12345678', 15, 5),
('test1', '12', 1, 0),
('test2', '1234', 3, 1),
('test3', '5678', 2, 0),
('test4', '1234', 1, 0),
('test5', '12345', 7, 2),
('test6', '123456789', 10, 4),
('test7', '123456', 5, 2),
('testtest', '1234', 1, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
