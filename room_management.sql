-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2016 at 09:33 AM
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE IF NOT EXISTS `pengguna` (
  `password` varchar(30) NOT NULL DEFAULT 'administrator'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
