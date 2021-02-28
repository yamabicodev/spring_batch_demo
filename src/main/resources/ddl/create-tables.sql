create table if not exists `articles` (
`id` INT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(20) NOT NULL,
`text` text NOT NULL,
`created_at` TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
PRIMARY KEY(`id`)
) engine=INNODB DEFAULT CHARSET=utf8

create table if not exists `comments` (
`id` INT NOT NULL AUTO_INCREMENT,
`text` text NOT NULL,
`article_id` INT NOT NULL,
`created_at` TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
PRIMARY KEY(`id`),
FOREIGN KEY fk_article (`article_id`) REFERENCES `articles` (`id`)
) engine=INNODB DEFAULT CHARSET=utf8

create table if not exists `article_summaries` (
`article_id` INT NOT NULL,
`article_title` VARCHAR(20) NOT NULL,
`number_of_comments` INT NOT NULL,
PRIMARY KEY(`article_id`)
) engine=INNODB DEFAULT CHARSET=utf8