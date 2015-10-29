
DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `school` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL DEFAULT 'someone@email.com',
  PRIMARY KEY (`id`)
);

INSERT INTO `employee` VALUES (1,'Asiri Gamage','54/2, Old Kottawa Road','Kottawa','Royal College','N/A','asgamage.jpg','someone@email.com'),(2,'Upulsara Meedeniya','264/c, Peradeniya Road','Kandy','Mahamaya College','Test','umeedeniya.jpg','someone@email.com'),(3,'Dhanushka Jayasuriya','21/2, Temple Road','Kelaniya','Musaeus College','N/A','dbjayasuriya.jpg','someone@email.com'),(4,'Buddhika Wathukarage','21/4, Weera Mawatha','Pannipitiya','DS','N/A','bwathukarage.jpg','someone@email.com'),(5,'Isuru Kularathna','20/5, Old Kesbewa Road','Piliyandala','N/A','N/A','ikularathna.jpg','someone@email.com');