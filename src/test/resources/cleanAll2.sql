delete from test_concertPlanner.Composer;
DELETE FROM test_concertPlanner.Nationality;
INSERT INTO `test_concertPlanner`.`Nationality` (`Id`, `nationality`) VALUES (1, 'American');
INSERT INTO `test_concertPlanner`.`Nationality` (`Id`, `nationality`) VALUES (2, 'Muldovian');
INSERT INTO `test_concertPlanner`.`Nationality` (`Id`, `nationality`) VALUES (3, 'French');
INSERT INTO `test_concertPlanner`.`Composer` (`Id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_Id`) VALUES (1, 'Mark', 'Mellits', 1966, NULL, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`Id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_Id`) VALUES (2, 'John', 'Jeffery-Gibbens', 1959, NULL, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`Id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_Id`) VALUES (3, 'John', 'Cage', 1912, 1992, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`Id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_Id`) VALUES (4, 'Valeria', 'Luta', NULL, NULL, 2);
INSERT INTO `test_concertPlanner`.`Composer` (`Id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_Id`) VALUES (5, 'John', 'Luther Adams', NULL, NULL, 1);
INSERT INTO `test_concertPlanner`.`Composer` (`Id`, `first_name`, `last_name`, `birth_year`, `death_year`, `Nationality_Id`) VALUES (6, 'Steve', 'Reich', 1936, NULL, 1);