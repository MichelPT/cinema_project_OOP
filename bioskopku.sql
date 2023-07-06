-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2023 at 04:53 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskopku`
--

-- --------------------------------------------------------

--
-- Table structure for table `inputan`
--

CREATE TABLE `inputan` (
  `id` int(11) NOT NULL,
  `studioId` int(5) NOT NULL,
  `username` varchar(15) NOT NULL,
  `kodekursi` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inputan`
--

INSERT INTO `inputan` (`id`, `studioId`, `username`, `kodekursi`) VALUES
(144, 1, 'paiduser', 'B4'),
(145, 2, 'paiduser', 'B3'),
(146, 2, 'paiduser', 'C3'),
(147, 1, 'paiduser', 'B3'),
(148, 1, 'paiduser', 'E5'),
(149, 2, 'paiduser', 'C2'),
(150, 2, 'paiduser', 'D2'),
(151, 2, 'user', 'E2');

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE `studio` (
  `studioId` int(5) NOT NULL,
  `movieName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`studioId`, `movieName`) VALUES
(1, 'Titanika'),
(2, 'thanos'),
(3, 'Kimi');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` enum('admin','customer') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `role`) VALUES
('admin', 'admin123', 'admin'),
('Atha', '1233', 'customer'),
('dimas', '2244', 'customer'),
('michel', 'luvdew', 'customer'),
('paidAtha', 'paid1233', 'customer'),
('paiddimas', 'paid2244', 'customer'),
('paidmichel', 'luvdew', 'customer'),
('paidtahya', 'paidsiregar', 'customer'),
('paidtriputri', '3putri', 'customer'),
('paiduser', 'paiduser1', 'customer'),
('tahya', 'siregar', 'customer'),
('triputri', '3putri', 'customer'),
('user', 'user1', 'customer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inputan`
--
ALTER TABLE `inputan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_studio` (`studioId`),
  ADD KEY `fk_user` (`username`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`studioId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inputan`
--
ALTER TABLE `inputan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inputan`
--
ALTER TABLE `inputan`
  ADD CONSTRAINT `fk_studio` FOREIGN KEY (`studioId`) REFERENCES `studio` (`studioId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
