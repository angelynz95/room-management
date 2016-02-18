-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2016 at 05:41 AM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `pemeliharaan`
--

INSERT INTO `pemeliharaan` (`id_pemeliharaan`, `id_ruangan`, `deskripsi`, `waktu_mulai`, `waktu_selesai`) VALUES
(1, 2, 'Pintu rusak', '2016-02-22 19:00:00', '2016-02-23 21:00:00'),
(2, 5, 'Pintu rusak', '2016-03-08 11:00:00', '2016-03-08 19:00:00'),
(3, 1, 'Bocor', '2016-03-08 11:00:00', '2016-03-08 19:00:00'),
(4, 8, 'Pintu rusak', '2016-03-08 11:00:00', '2016-03-08 19:00:00'),
(5, 6, 'Service AC', '2016-02-16 20:00:00', '2016-02-16 21:00:00'),
(7, 6, 'Service AC', '2016-02-18 10:00:00', '2016-02-18 17:00:00');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

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
(9, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-08 13:00:00', '2016-02-08 15:00:00'),
(10, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-08 15:00:00', '2016-02-08 17:00:00'),
(11, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 07:00:00', '2016-02-23 09:00:00'),
(12, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 09:00:00', '2016-02-23 11:00:00'),
(13, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 13:00:00', '2016-02-23 15:00:00'),
(14, 1, 22222222, 'Nina', 'Dosen', 'JL Ganesha', '0823133224333', 'Informatika ITB', 'kuliah', 50, '2016-02-13 14:20:25', '2016-02-23 15:00:00', '2016-02-23 17:00:00'),
(15, 4, 13513002, 'Irene', 'Mahasiswa', 'Tamansari', '0878821372', 'HMIF', 'Demo PPL', 2, '2016-02-16 09:32:00', '2016-02-16 11:00:00', '2016-02-16 12:00:00'),
(16, 1, 13513026, 'William Sentosa', 'Mahasiswa', 'Cisitu Tegalega', '0229485729', 'HMIF', 'Hearing Divisi Manager Proyek', 30, '2016-02-16 16:07:59', '2016-02-16 18:00:00', '2016-02-16 19:00:00'),
(17, 1, 13514083, 'Timothy Julianto', 'Mahasiswa', 'Jl. Tubagus Ismail V No. 10', '08628126001', 'Informatika ITB', 'Temu Alumni Angkatan 1970', 79, '2016-02-16 19:10:06', '2016-02-17 20:00:00', '2016-02-17 21:00:00'),
(20, 1, 15712037, 'Jordhy Silalahi', 'Mahasiswa', 'Cisitu Dalam No. 29', '0812738277', 'HMT', 'Hearing HMT', 40, '2016-02-17 13:10:04', '2016-02-17 14:00:00', '2016-02-17 15:00:00'),
(21, 3, 13512009, 'Gwenyth John', 'Mahasiswa', 'Jl. Cihampelas No. 22', '08577291726', 'Informatika ITB', 'Briefing Asisten', 20, '2016-02-17 22:50:53', '2016-02-18 14:00:00', '2016-02-18 15:00:00'),
(23, 1, 15612822, 'Hendy Kurnia', 'Mahasiswa', 'Cihampelas', '0867163712', 'KM-ITB', 'Hearing TPB Cup', 30, '2016-02-18 08:10:40', '2016-02-18 09:00:00', '2016-02-18 10:00:00'),
(24, 1, 15612822, 'Hendy Kurnia', 'Mahasiswa', 'Cihampelas', '0867163712', 'KM-ITB', 'Hearing TPB Cup', 30, '2016-02-18 08:10:40', '2016-02-25 09:00:00', '2016-02-25 10:00:00'),
(25, 4, 13513002, 'Irene Wiliudarsan', 'Mahasiswa', 'Jl. Tamansari', '0881238822', 'HMIF', 'Hearing Pemilu 1 HMIF', 50, '2016-02-18 08:43:33', '2016-02-19 08:00:00', '2016-02-19 10:00:00');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama`, `kapasitas`, `status`) VALUES
(1, 'R 7602', 150, 'OK'),
(2, 'R 7606', 75, 'Rusak'),
(3, 'R 7609', 50, 'Rusak'),
(4, 'R 7603', 50, 'Rusak'),
(5, 'Laboratorium Dasar I', 50, 'Rusak'),
(6, 'Laboratorium Dasar IV', 50, 'Rusak'),
(7, 'Laboratorium Dasar II', 30, 'Rusak'),
(8, 'R Multimedia', 75, 'Rusak'),
(9, 'R 7610', 50, 'Rusak');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
