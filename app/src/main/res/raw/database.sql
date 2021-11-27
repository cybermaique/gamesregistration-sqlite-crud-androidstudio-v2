DROP TABLE IF EXISTS `games`;

CREATE TABLE games(
game_id INT UNSIGNED NOT NULL PRIMARY KEY,
name VARCHAR(50)DEFAULT NULL,
genre VARCHAR (30) DEFAULT NULL
);

INSERT INTO games VALUES (1, 'Need For Speed', 'Race');
INSERT INTO games VALUES (2, 'The Last Of Us',    'Action-Adventure');