CREATE DATABASE buptspider;

use buptspider;

CREATE TABLE `websites_info` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `url` VARCHAR(255) NOT NULL，
    `title` VARCHAR(255),
    `content` TEXT,
    `published_time` DATE,
    `click_times` INT,
    `crawled` TINYINT DEFAULT 0,
    `being_crawled` TINYINT DEFAULT 0,
    PRIMARY KEY (`url`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;