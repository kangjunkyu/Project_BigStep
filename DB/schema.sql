DROP DATABASE IF EXISTS bigstep;
CREATE DATABASE bigstep;
use bigstep;

CREATE TABLE `users` (
	`id` varchar(40) NOT NULL PRIMARY KEY,
    `pw` varchar(40) NOT NULL,
    `name` varchar(40) NOT NULL,
    `nickname` varchar(40) NOT NULL,
    `email` varchar(100) NOT NULL,
    `phone` varchar(40) NOT NULL,
    `address` varchar(100) NOT NULL,
    
    `uid` varchar(80),
    
    `height` INT,
    `weight` INT,
    `age` INT,
    `gender` INT,
    
    `isPublic` boolean NOT NULL default TRUE
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `diarys` (
	`diaryid` INT AUTO_INCREMENT PRIMARY KEY,
    `userid` varchar(40) NOT NULL,
	`title` varchar(80) NOT NULL,
    `content` TEXT NOT NULL,
    
    `date` TIMESTAMP default current_timestamp,
    `img` varchar(50),
    `orgimg` varchar(50),
    
    `likeCnt` INT default 0,
    
    CONSTRAINT `diary_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `todos` (
	`todoid` INT AUTO_INCREMENT PRIMARY KEY,
	`diaryid` INT NOT NULL,
    `userid` varchar(40) NOT NULL,
    
    `date` TIMESTAMP NOT NULL,
    `workout` varchar(80) NOT NULL,
    `start_hour` INT NOT NULL,
    `start_minute` INT NOT NULL,
    `end_hour` INT NOT NULL,
    `end_minute` INT NOT NULL,
    
    `is_complete` boolean default false,
	
    CONSTRAINT `todo_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
    CONSTRAINT `todo_ibfk_2` FOREIGN KEY (`diaryid`) REFERENCES `diarys` (`diaryid`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;


CREATE TABLE `comments` (
	`commentid` INT AUTO_INCREMENT PRIMARY KEY,
	`diaryid` INT NOT NULL,
    `userid` varchar(40) NOT NULL,
    `nickname` varchar(40) NOT NULL,
    `content` TEXT NOT NULL,
    
    `reg_date` TIMESTAMP default current_timestamp,
	CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
    CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`diaryid`) REFERENCES `diarys` (`diaryid`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `likes` (
	`diaryid` INT NOT NULL,
	`userid` varchar(40) NOT NULL,
    
    PRIMARY KEY(`diaryid`, `userid`),
	CONSTRAINT `like_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
    CONSTRAINT `like_ibfk_2` FOREIGN KEY (`diaryid`) REFERENCES `diarys` (`diaryid`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `follows` (
	`followerid` varchar(40) NOT NULL,
    `followingid` varchar(40) NOT NULL,

    PRIMARY KEY(`followerid`, `followingid`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;


INSERT INTO users (id, pw, name, nickname, email, phone, address)
VALUES ("ssafy", "1234", "강준규", "강준규", "ssafy@ssafy.com", "010-1111-1111", "123");

INSERT INTO diarys (userid, title, content, date)
VALUES ("ssafy", "테스트 제목", "테스트 content", "20231117");

INSERT INTO todos (diaryid, userid, date, workout, start_hour, start_minute, end_hour, end_minute)
VALUES (1, "ssafy", "20231117", "workout test", 9, 30, 10, 45);

INSERT INTO comments (diaryid, userid, nickname, content)
VALUES (1, "ssafy", "닉네임 test", "content test");


