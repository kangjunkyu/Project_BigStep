DROP DATABASE IF EXISTS bigstep;
CREATE DATABASE bigstep;
use bigstep;

CREATE TABLE `users` (
	`id` varchar(40) NOT NULL PRIMARY KEY,
    `pw` varchar(40) NOT NULL,
    `name` varchar(40) NOT NULL,
    
    `address` varchar(100) NOT NULL,
    
    `uid` varchar(80),
    
    `height` INT,
    `weight` INT,
    `age` INT
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `diarys` (
	`diaryid` INT AUTO_INCREMENT PRIMARY KEY,
    `userid` varchar(40) NOT NULL,
	`title` varchar(80) NOT NULL,
    `content` TEXT NOT NULL,
    
    `date` TIMESTAMP default current_timestamp,
    `img` varchar(50),
    `orgimg` varchar(50)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
