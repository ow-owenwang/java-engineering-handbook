CREATE TABLE `user`
(
    `id`       INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(128),
    `password` VARCHAR(128)
);

INSERT INTO `user`
VALUES (null, 'Doe', '111');
INSERT INTO `user`
VALUES (null, 'Tom', '222');
INSERT INTO `user`
VALUES (null, 'Owen', '333');