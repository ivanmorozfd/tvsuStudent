CREATE SCHEMA 'vkurse';

CREATE USER vkursant IDENTIFIED BY 'aboba';
GRANT USAGE ON *.* TO vkusant IDENTIFIED BY 'aboba';
GRANT ALL PRIVILEGES ON vkurse.* TO vkursant;

INSERT INTO
`vkurse`.`user`(`id`,`username`,`password`,`role`,`enabled`)
VALUES (0, 'admin', '$2a$12$x/HjadvQ2uyu5u2hk2p9bOvSFDvJGDV/FgBR9VxmwfBQmoqNg5h7i', 'admin', 1);
