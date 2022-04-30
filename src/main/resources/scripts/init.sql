CREATE SCHEMA 'vkurse';

CREATE USER vkursant IDENTIFIED BY 'aboba';
GRANT USAGE ON *.* TO vkusant IDENTIFIED BY 'aboba';
GRANT ALL PRIVILEGES ON vkurse.* TO vkursant;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(80) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO
`vkurse`.`user`(`id`,`username`,`password`,`role`,`enabled`)
VALUES (0, 'user', '$2a$12$x/HjadvQ2uyu5u2hk2p9bOvSFDvJGDV/FgBR9VxmwfBQmoqNg5h7i', 'user', 1);
