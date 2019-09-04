CREATE DATABASE buptspider;

use buptspider;

CREATE TABLE `websites_info` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `url` VARCHAR(255) NOT NULL，
    `title` VARCHAR(255),
    `content` TEXT,
    `published_time` DATE,
    `click_times` int,
    `crawled` TINYINT DEFAULT 0,

    PRIMARY KEY (`url`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;