-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 18, 2020 at 05:11 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_warungkopi`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_pesanan`
--

CREATE TABLE `detail_pesanan` (
  `id_pesanan` int(11) NOT NULL,
  `id_pemesanan` varchar(22) COLLATE utf8mb4_unicode_ci NOT NULL,
  `no_kursi` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal_pemesanan` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `total` int(11) NOT NULL,
  `status` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `detail_pesanan`
--

INSERT INTO `detail_pesanan` (`id_pesanan`, `id_pemesanan`, `no_kursi`, `tanggal_pemesanan`, `total`, `status`) VALUES
(1, 'PMSN-037', '004', '2020-05-17 05:15:55', 150000, 'TELAH DIBAYAR'),
(2, 'PMSN-038', '003', '2020-05-17 11:17:29', 24000, 'TELAH DIBAYAR'),
(3, 'PMSN-039', '002', '2020-05-17 11:26:27', 24000, 'TELAH DIBAYAR'),
(4, 'PMSN-040', '002', '2020-05-17 11:28:11', 24000, 'TELAH DIBAYAR'),
(5, 'PMSN-041', '002', '2020-05-17 14:04:45', 54000, 'TELAH DIBAYAR'),
(6, 'PMSN-042', '002', '2020-05-17 14:07:43', 54000, 'TELAH DIBAYAR'),
(7, 'PMSN-044', '006', '2020-05-18 15:30:07', 93000, 'TELAH DIBAYAR'),
(8, 'PMSN-047', '003', '2020-05-18 15:39:41', 27000, 'TELAH DIBAYAR'),
(9, 'PMSN-048', '002', '2020-05-18 15:47:59', 36000, 'TELAH DIBAYAR'),
(10, 'PMSN-048', '005', '2020-05-18 15:49:15', 12000, 'TELAH DIBAYAR'),
(11, 'PMSN-048', '004', '2020-05-18 15:50:12', 12000, 'TELAH DIBAYAR'),
(12, 'PMSN-048', '006', '2020-05-18 17:08:45', 54000, 'TELAH DIBAYAR'),
(13, 'PMSN-048', '003', '2020-05-18 17:10:09', 54000, 'TELAH DIBAYAR'),
(14, 'PMSN-048', '005', '2020-05-18 17:10:22', 66000, 'TELAH DIBAYAR');

-- --------------------------------------------------------

--
-- Table structure for table `dompet`
--

CREATE TABLE `dompet` (
  `id_dompet` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dompet`
--

INSERT INTO `dompet` (`id_dompet`, `id_user`, `jumlah`) VALUES
(1, 1, 644000),
(2, 2, 313000);

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pemesanan` varchar(22) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_kopi` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`id_pemesanan`, `id_user`, `id_kopi`, `jumlah`) VALUES
('PMSN-001', 1, 2, 12),
('PMSN-001', 1, 2, 6),
('PMSN-002', 2, 3, 2),
('PMSN-002', 2, 4, 4),
('PMSN-004', 1, 1, 5),
('PMSN-004', 1, 3, 6),
('PMSN-005', 1, 1, 1),
('PMSN-006', 1, 2, 2),
('PMSN-006', 1, 1, 2),
('PMSN-007', 1, 1, 2),
('PMSN-008', 1, 2, 4),
('PMSN-008', 1, 1, 7),
('PMSN-009', 1, 1, 2),
('PMSN-009', 1, 1, 4),
('PMSN-010', 1, 1, 2),
('PMSN-011', 1, 2, 1),
('PMSN-011', 1, 2, 12),
('PMSN-012', 1, 1, 1),
('PMSN-012', 1, 2, 2),
('PMSN-013', 1, 2, 2),
('PMSN-013', 1, 3, 3),
('PMSN-014', 1, 1, 2),
('PMSN-014', 1, 2, 2),
('PMSN-015', 1, 1, 2),
('PMSN-015', 1, 2, 3),
('PMSN-016', 1, 1, 2),
('PMSN-016', 1, 3, 30),
('PMSN-017', 1, 1, 6),
('PMSN-017', 1, 1, 4),
('PMSN-018', 1, 1, 4),
('PMSN-018', 1, 2, 5),
('PMSN-019', 1, 1, 4),
('PMSN-019', 1, 3, 3),
('PMSN-020', 1, 1, 5),
('PMSN-021', 1, 1, 6),
('PMSN-021', 1, 3, 8),
('PMSN-022', 1, 1, 7),
('PMSN-022', 1, 3, 4),
('PMSN-023', 1, 1, 6),
('PMSN-023', 1, 2, 2),
('PMSN-024', 1, 1, 5),
('PMSN-024', 1, 1, 3),
('PMSN-025', 1, 1, 4),
('PMSN-025', 1, 1, 4),
('PMSN-026', 1, 1, 4),
('PMSN-026', 1, 1, 4),
('PMSN-027', 1, 1, 3),
('PMSN-027', 1, 1, 3),
('PMSN-028', 1, 1, 4),
('PMSN-028', 1, 1, 4),
('PMSN-029', 1, 1, 4),
('PMSN-029', 1, 1, 4),
('PMSN-030', 1, 1, 5),
('PMSN-030', 1, 1, 5),
('PMSN-031', 1, 1, 5),
('PMSN-031', 1, 1, 5),
('PMSN-032', 1, 1, 5),
('PMSN-032', 1, 1, 5),
('PMSN-033', 1, 1, 5),
('PMSN-033', 1, 1, 5),
('PMSN-034', 1, 1, 4),
('PMSN-034', 1, 1, 6),
('PMSN-035', 1, 1, 4),
('PMSN-035', 1, 1, 2),
('PMSN-036', 1, 1, 12),
('PMSN-036', 1, 1, 13),
('PMSN-037', 1, 1, 12),
('PMSN-037', 1, 1, 13),
('PMSN-038', 1, 1, 4),
('PMSN-039', 1, 1, 4),
('PMSN-040', 1, 1, 4),
('PMSN-041', 1, 2, 3),
('PMSN-041', 1, 3, 4),
('PMSN-042', 1, 1, 3),
('PMSN-042', 1, 3, 4),
('PMSN-043', 1, 2, 3),
('PMSN-044', 1, 2, 3),
('PMSN-044', 1, 3, 5),
('PMSN-044', 1, 4, 2),
('PMSN-045', 2, 4, 1000),
('PMSN-046', 1, 3, 3),
('PMSN-047', 2, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id_kopi` int(11) NOT NULL,
  `nama_kopi` varchar(150) NOT NULL,
  `harga` int(255) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id_kopi`, `nama_kopi`, `harga`, `stok`) VALUES
(1, 'Kopasus ', 6000, 30),
(2, 'Sukop', 6000, 30),
(3, 'Maduretno', 9000, 17),
(4, 'Mocacinno', 15000, 20);

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_saldo`
--

CREATE TABLE `riwayat_saldo` (
  `idRiwayatSaldo` int(11) NOT NULL,
  `id_dompet` int(11) NOT NULL,
  `riwayat_saldo` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal_transaksi` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `keterangan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `riwayat_saldo`
--

INSERT INTO `riwayat_saldo` (`idRiwayatSaldo`, `id_dompet`, `riwayat_saldo`, `tanggal_transaksi`, `keterangan`) VALUES
(1, 1, '476000', '2020-05-17 11:31:42', 'PEMBAYARAN'),
(2, 1, '368000', '2020-05-17 14:07:43', 'PEMBELIAN'),
(3, 2, '- 27000', '2020-05-18 15:39:41', 'PEMBELIAN'),
(4, 2, '- 36000', '2020-05-18 15:47:59', 'PEMBELIAN'),
(5, 2, '- 12000', '2020-05-18 15:49:15', 'PEMBELIAN'),
(6, 2, '- 12000', '2020-05-18 15:50:12', 'PEMBELIAN'),
(7, 1, '+ 718000', '2020-05-18 17:00:42', 'PENGISIAN SALDO'),
(8, 1, '+ 100000', '2020-05-18 17:01:35', 'PENGISIAN SALDO'),
(9, 1, '- 54000', '2020-05-18 17:08:45', 'PEMBELIAN'),
(10, 1, '- 54000', '2020-05-18 17:10:09', 'PEMBELIAN'),
(11, 1, '- 66000', '2020-05-18 17:10:22', 'PEMBELIAN');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `nama_role` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id_role`, `nama_role`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sandi` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` int(11) NOT NULL,
  `dibuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `diubah` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `email`, `sandi`, `role`, `dibuat`, `diubah`) VALUES
(1, 'Maulana Kurnia', 'maulanaakurniaa@yahoo.com', '1d72310edc006dadf2190caad5802983', 1, '2020-05-16 13:36:10', '2020-05-16 13:35:50'),
(2, 'Hanif Rizqi', 'hanif@gmail.com', '1d72310edc006dadf2190caad5802983', 2, '2020-05-16 13:40:58', '2020-05-16 13:40:58'),
(5, 'asdasd', 'asdasd', 'a8f5f167f44f4964e6c998dee827110c', 2, '2020-05-17 17:54:55', '2020-05-17 17:54:49');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_pesanan`
--
ALTER TABLE `detail_pesanan`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indexes for table `dompet`
--
ALTER TABLE `dompet`
  ADD PRIMARY KEY (`id_dompet`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD KEY `id_user` (`id_user`,`id_kopi`),
  ADD KEY `id_kopi` (`id_kopi`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_kopi`);

--
-- Indexes for table `riwayat_saldo`
--
ALTER TABLE `riwayat_saldo`
  ADD PRIMARY KEY (`idRiwayatSaldo`),
  ADD KEY `id_user` (`id_dompet`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `role` (`role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_pesanan`
--
ALTER TABLE `detail_pesanan`
  MODIFY `id_pesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `dompet`
--
ALTER TABLE `dompet`
  MODIFY `id_dompet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id_kopi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `riwayat_saldo`
--
ALTER TABLE `riwayat_saldo`
  MODIFY `idRiwayatSaldo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dompet`
--
ALTER TABLE `dompet`
  ADD CONSTRAINT `dompet_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `pemesanan_ibfk_1` FOREIGN KEY (`id_kopi`) REFERENCES `produk` (`id_kopi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pemesanan_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `riwayat_saldo`
--
ALTER TABLE `riwayat_saldo`
  ADD CONSTRAINT `riwayat_saldo_ibfk_1` FOREIGN KEY (`id_dompet`) REFERENCES `dompet` (`id_dompet`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
