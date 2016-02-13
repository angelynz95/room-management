-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2016 at 08:27 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `room_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `pemeliharaan`
--

CREATE TABLE IF NOT EXISTS `pemeliharaan` (
  `id_pemeliharaan` int(4) NOT NULL AUTO_INCREMENT,
  `id_ruangan` int(3) NOT NULL,
  `deskripsi` text NOT NULL,
  `waktu_mulai` datetime NOT NULL,
  `waktu_selesai` datetime NOT NULL,
  PRIMARY KEY (`id_pemeliharaan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `pemeliharaan`
--

INSERT INTO `pemeliharaan` (`id_pemeliharaan`, `id_ruangan`, `deskripsi`, `waktu_mulai`, `waktu_selesai`) VALUES
(1, 2, 'Pintu rusak', '2016-03-07 15:00:00', '2016-03-10 09:00:00'),
(2, 5, 'Pintu rusak', '2016-03-08 11:00:00', '2016-03-08 19:00:00'),
(3, 1, 'Bocor', '2016-03-08 11:00:00', '2016-03-09 19:00:00'),
(4, 8, 'Pintu rusak', '2016-03-08 11:00:00', '2016-03-08 19:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `id_peminjaman` int(4) NOT NULL AUTO_INCREMENT,
  `id_ruangan` int(3) NOT NULL,
  `id_peminjam` int(18) NOT NULL,
  `nama_peminjam` varchar(256) NOT NULL,
  `status_peminjam` varchar(9) NOT NULL,
  `alamat_peminjam` text NOT NULL,
  `nomor_telepon_peminjam` varchar(15) NOT NULL,
  `nama_lembaga` varchar(256) NOT NULL DEFAULT 'Informatika ITB',
  `nama_kegiatan` varchar(256) NOT NULL DEFAULT 'Kuliah',
  `jumlah_peserta` int(3) NOT NULL DEFAULT '0',
  `waktu_izin` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `waktu_mulai` datetime NOT NULL,
  `waktu_selesai` datetime NOT NULL,
  PRIMARY KEY (`id_peminjaman`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `id_ruangan`, `id_peminjam`, `nama_peminjam`, `status_peminjam`, `alamat_peminjam`, `nomor_telepon_peminjam`, `nama_lembaga`, `nama_kegiatan`, `jumlah_peserta`, `waktu_izin`, `waktu_mulai`, `waktu_selesai`) VALUES
(1, 1, 13513026, 'William', 'Mahasiswa', 'Jalan Cisitu Indah', '081234123412', 'HMIF IT', 'Training anggota', 30, '2016-02-13 14:03:37', '2016-02-15 18:00:00', '2016-02-15 20:00:00'),
(2, 1, 111111, 'Doni', 'Dosen', 'JL Soedirman no : 13', '082313322434', 'Dosen ITB', 'Training Dosen', 30, '2016-02-13 14:07:21', '2016-02-27 10:00:00', '2016-02-27 13:00:00'),
(4, 2, 13513002, 'Irene', 'Mahasiswa', 'JL Tamansari', '082313939034', 'KMB', 'Rapat anggota', 50, '2016-02-13 14:20:25', '2016-02-24 17:00:00', '2016-02-24 21:00:00'),
(5, 5, 13513032, 'Angela', 'Mahasiswa', 'JL Soedirman no : 13', '0823133224134', 'Mahasiswa', 'Rapat', 20, '2016-02-13 14:20:25', '2016-02-23 18:00:00', '2016-02-23 21:00:00'),
(6, 5, 13513032, 'Angela', 'Mahasiswa', 'JL Soedirman no : 13', '0823133224134', 'HMIF ITB', 'Rapat', 20, '2016-02-13 14:20:25', '2016-02-27 18:00:00', '2016-02-27 21:00:00'),
(7, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-22 07:00:00', '2016-02-22 09:00:00'),
(8, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-22 09:00:00', '2016-02-22 11:00:00'),
(9, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-22 13:00:00', '2016-02-22 15:00:00'),
(10, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-22 15:00:00', '2016-02-22 17:00:00'),
(11, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 07:00:00', '2016-02-23 09:00:00'),
(12, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 09:00:00', '2016-02-23 11:00:00'),
(13, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 13:00:00', '2016-02-23 15:00:00'),
(14, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 15:00:00', '2016-02-23 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE IF NOT EXISTS `pengguna` (
  `password` varchar(30) NOT NULL DEFAULT 'administrator'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`password`) VALUES
('admin');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE IF NOT EXISTS `ruangan` (
  `id_ruangan` int(3) NOT NULL AUTO_INCREMENT,
  `nama` varchar(256) NOT NULL,
  `kapasitas` int(3) NOT NULL DEFAULT '0',
  `status` varchar(5) NOT NULL DEFAULT 'OK',
  PRIMARY KEY (`id_ruangan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama`, `kapasitas`, `status`) VALUES
(1, 'R 7602', 150, 'OK'),
(2, 'R 7606', 75, 'OK'),
(3, 'R 7609', 50, 'OK'),
(4, 'R 7603', 50, 'OK'),
(5, 'Laboratorium Dasar I', 50, 'OK'),
(6, 'Laboratorium Dasar IV', 50, 'OK'),
(7, 'Laboratorium Dasar II', 30, 'OK'),
(8, 'R Multimedia', 75, 'OK'),
(9, 'R 7610', 50, 'OK'),
(10, 'R 7602', 50, 'OK');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
