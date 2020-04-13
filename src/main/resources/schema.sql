CREATE TABLE IF NOT EXISTS `car` ( `id` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(255) NOT NULL,`manufacturerName` varchar(255) NOT NULL,`model` varchar(255) NOT NULL,`manufacturingYear` varchar(255) NOT NULL,`color` varchar(255) NOT NULL, PRIMARY KEY (`id`));
CREATE TABLE IF NOT EXISTS `user` ( `id` int(11) NOT NULL, `emailId` varchar(255) NOT NULL, `password` varchar(255) NOT NULL, PRIMARY KEY (`id`));


