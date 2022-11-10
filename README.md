Запрос для создания БД :

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL,
  `date_of_publication` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `books` (`id`, `book_name`, `date_of_publication`, `author`, `publisher`) VALUES
(2,	'English',	'9 December 2019',	'You',	'My friends'),
(3,	'Spring Boot',	'don\'t know, maybe tomorow',	'Brel Ilya Mihailovich',	'You'),
(4,	'Как попасть на курсы в Intervale?',	'13 November 2022',	'Me',	'You'),
(5,	'Как я попал на курсы в Intervale?',	'14 Novemver 2022',	'Me',	'Me'),
(6,	'Biography',	'3 January 2004',	'Ilya Brel',	'Ilya Brel');

DROP TABLE IF EXISTS `magazines`;
CREATE TABLE `magazines` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `magazines_name` varchar(255) NOT NULL,
  `date_of_publication` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `magazines` (`id`, `magazines_name`, `date_of_publication`, `author`, `publisher`) VALUES
(8,	'vxvZ',	'vzxvzxv',	'zxvzxv',	'zxvzx'),
(10,	'333',	'33',	'3',	'2');

DROP TABLE IF EXISTS `newspapers`;
CREATE TABLE `newspapers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `newspaper_name` varchar(255) NOT NULL,
  `date_of_publication` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `newspapers` (`id`, `newspaper_name`, `date_of_publication`, `author`, `publisher`) VALUES
(4,	'ммцц',	'ммм',	'мм',	'мм'),
(5,	'пкп',	'кпап',	'апап',	'апап');