-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 10, 2016 at 04:31 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `healthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `familydetails`
--

CREATE TABLE IF NOT EXISTS `familydetails` (
  `date_of_survey` varchar(50) NOT NULL,
  `family_folder_no` varchar(50) NOT NULL,
  `employee_no` varchar(50) NOT NULL,
  `door_no` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  `taluk` varchar(50) NOT NULL,
  `pincode` varchar(50) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `total_no_family` varchar(50) NOT NULL,
  `family_type` varchar(50) NOT NULL,
  `religion` varchar(50) NOT NULL,
  `family_inc` varchar(50) NOT NULL,
  `house` varchar(50) NOT NULL,
  `house_type` varchar(50) NOT NULL,
  `source_of_water` varchar(50) NOT NULL,
  `type_of_toilet` varchar(50) NOT NULL,
  `infant` varchar(50) NOT NULL,
  `under5` varchar(50) NOT NULL,
  `adolescent` varchar(50) NOT NULL,
  `antenatal` varchar(50) NOT NULL,
  `postnatal` varchar(50) NOT NULL,
  `geriatric` varchar(50) NOT NULL,
  `rice` varchar(50) NOT NULL,
  `wheat` varchar(50) NOT NULL,
  `sugar` varchar(50) NOT NULL,
  `salt` varchar(50) NOT NULL,
  `oil` varchar(50) NOT NULL,
  `family_planing` varchar(50) NOT NULL,
  `under5_immunization` varchar(50) NOT NULL,
  `rcrd_crct_dt` varchar(50) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `site_clinic` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `familydetails`
--

INSERT INTO `familydetails` (`date_of_survey`, `family_folder_no`, `employee_no`, `door_no`, `area`, `taluk`, `pincode`, `latitude`, `longitude`, `total_no_family`, `family_type`, `religion`, `family_inc`, `house`, `house_type`, `source_of_water`, `type_of_toilet`, `infant`, `under5`, `adolescent`, `antenatal`, `postnatal`, `geriatric`, `rice`, `wheat`, `sugar`, `salt`, `oil`, `family_planing`, `under5_immunization`, `rcrd_crct_dt`, `created_by`, `site_clinic`) VALUES
('sdfd', 'dfdsf', 'ddf', 'sdf', 'sd', 'RR', 'rr', 'rr', 'sd', 'sa', 'aa', 'xx', 'xcv', 'xc', 'df', 'gf', 'sdf', 'sd', 'dfd', 'dfgd', 'fg', 'sd', 'er', 'dfg', 'def', 'fdf', 'sdf', 'sd', 'dsfd', 'sd', 'sdf', 'sd', 'dfdf'),
('rff', 'jkj', 'hj', 'hhj', 'hj', 'hjk', 'hjk', 'hj', 'hjk', 'khh', 'j', 'hjk', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
('', '', '46', '', '', '', '46', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('', '', '46', '', '', '', '46', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('lasy', '', '46', '', '', '', '46', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('last in cls', '', '44', '', '', '', '44', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('ee', '', '1', '', '', '', '1', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('ff', '', '1', '', '', '', '3226', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('fast', '', '3', '', '', '', '43', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('intent', '', '2', '', '', '', '2', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', ''),
('yes', '', '32', '', '', '', '654', '', '', '1', 'select', 'select', '', 'select', 'select', 'select', 'select', 'no', 'no', 'no', 'no', 'no', 'no', '', '', '', '', '', 'select', 'select', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `familymember`
--

CREATE TABLE IF NOT EXISTS `familymember` (
  `familyfolder_no` varchar(50) NOT NULL,
  `sl_no` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `relation_to_head` varchar(50) NOT NULL,
  `date_of_birth` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `marital_status` varchar(50) NOT NULL,
  `education` varchar(50) NOT NULL,
  `weight` varchar(50) NOT NULL,
  `height` varchar(50) NOT NULL,
  `bmi` varchar(50) NOT NULL,
  `sys_bp` varchar(50) NOT NULL,
  `diast_bp` varchar(50) NOT NULL,
  `chronic_illness` varchar(50) NOT NULL,
  `smoking` varchar(50) NOT NULL,
  `alcohol` varchar(50) NOT NULL,
  `aadhar_no` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `familymember`
--

INSERT INTO `familymember` (`familyfolder_no`, `sl_no`, `name`, `relation_to_head`, `date_of_birth`, `gender`, `marital_status`, `education`, `weight`, `height`, `bmi`, `sys_bp`, `diast_bp`, `chronic_illness`, `smoking`, `alcohol`, `aadhar_no`) VALUES
('12', '23', '34', '45', '45', '43', '345', '34', '24', '54', '34v', 'sd', '34d', '32sd', '32s', '32ssd', 'd2s'),
('12', '23', '34', '45', '45', '43', '345', '34', '24', '54', '34v', 'sd', '34d', '32sd', '32s', '32ssd', 'd2s'),
('12', '23', '34', '45', '45', '43', '345', '34', '24', '54', '34v', 'sd', '34d', '32sd', '32s', '32ssd', 'd2s'),
('g', 'f', 'fv', 'fgg', 'gg', 'MALE', 'single', 'tt', '', '', 'null', '', '', '', 'select', 'select', ''),
('vv', 'hh', 'hhh', 'hhu', 'hh', 'MALE', 'single', 'yuu', 'hh', 'uh', 'null', 'hu', 'hh', 'hugyy', 'yes', 'yes', 'yu'),
('123456', 'bb', 'cc', 'dd', 'ee', 'MALE', 'single', 'ff', '40', '160', 'null', 'gg', 'hh', 'ii', 'yes', 'yes', 'qwerty'),
('123456', 'fgy', 'fgh', 'tfy', 'dghjgf', 'MALE', 'single', 'tttt', '34', '134', 'null', 'dhhh', 'qqqq', 'wwww', 'yes', 'yes', 'rty'),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('628052', '1', '', '', '', 'select', 'select', '', '40', '150', 'null', '', '', '', 'select', 'select', ''),
('2', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('12', '23', '34', '45', '45', '43', '345', '34', '24', '54', '34v', 'sd', '34d', '32sd', '32s', '32ssd', 'd2s'),
('12', '23', '34', '45', '45', '43', '345', '34', '24', '54', '34v', 'sd', '34d', '32sd', '32s', '32ssd', 'd2s'),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', ''),
('', '', '', '', '', 'select', 'select', '', '', '', 'null', '', '', '', 'select', 'select', '');

-- --------------------------------------------------------

--
-- Table structure for table `uid`
--

CREATE TABLE IF NOT EXISTS `uid` (
  `uid` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uid`
--

INSERT INTO `uid` (`uid`) VALUES
('f'),
('1663023013130'),
('16637207022018885'),
('16637207035016753'),
('16637207032011541'),
('16628052024029829'),
('16628052024028886'),
('1646046016923'),
('1644044018197'),
('1644044019488'),
('161001012202'),
('161001019908'),
('163226001017920'),
('163226001019873'),
('1643003017599'),
('162002019369'),
('16654032013018');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
