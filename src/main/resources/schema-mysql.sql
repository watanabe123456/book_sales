CREATE TABLE IF NOT EXISTS `bookinventory` (
  `bookTitle` varchar(255) NOT NULL,
  `isbn` int NOT NULL,
  `author` varchar(45) NOT NULL,
  `price` int NOT NULL,
  `purchaseQuantity` int NOT NULL,
  `salesVolume` int NOT NULL,
  `classification` varchar(45) NOT NULL,
  PRIMARY KEY (`isbn`)
);