-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: furniture
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `productname` varchar(45) DEFAULT NULL,
  `productprice` int DEFAULT NULL,
  `productdescription` varchar(45) DEFAULT NULL,
  `productimage` varchar(245) DEFAULT NULL,
  `categoryid` int DEFAULT NULL,
  PRIMARY KEY (`productid`),
  KEY `categoryid_idx` (`categoryid`),
  CONSTRAINT `categoryid` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	int productID;\n	String productName;\n	int productPrice;\n	String productDescription;\n	String productImage;\n	int categoryID;\n	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Sofa Sets',6512,'Sofa Sets','https://ii2.pepperfry.com/media/catalog/product/v/a/470x235/valery-3-seater-sofa-in-safari-brown-colour-with-brown-oak-finish-by-casacraft-valery-3-seater-sofa--4swrtd.jpg',1),(2,'Sectional Sofas',2541,'Sectional Sofas','https://ii1.pepperfry.com/media/catalog/product/d/u/470x235/dunford-rhs-sectional-sofa-in-denim-blue-azora-color---woodsworth-by-pepperfry-dunford-rhs-sectional-excy3p.jpg',1),(3,'Sofa Cum Beds',2654,'Sofa Cum Beds','https://ii2.pepperfry.com/media/catalog/product/i/n/470x235/ines-sofa-cum-bed-in-steel-grey-colour---casacraft-by-pepperfry-ines-sofa-cum-bed-in-steel-grey-colo-ozz0be.jpg',1),(4,'Arm Chairs',6482,'Arm Chairs','https://ii2.pepperfry.com/media/catalog/product/a/t/236x260/atmos-solid-wood-armchair-in-provincial-teak-finish-by-amberville-atmos-solid-wood-armchair-in-provi-zimp6y.jpg',2),(5,'Wing Chairs',2541,'Wing Chairs','https://ii3.pepperfry.com/media/catalog/product/c/e/236x260/cecelia-wing-chair-in-lime-green-colour---casacraft-by-pepperfry-cecelia-wing-chair-in-lime-green-co-g4wsd4.jpg',2),(6,'Folding Chairs',5185,'Folding Chairs','https://ii3.pepperfry.com/media/catalog/product/w/m/236x260/wmet-109-wmet-109-qryzky.jpg',2),(7,'Coffee Tables',2584,'Coffee Tables','https://ii2.pepperfry.com/media/catalog/product/o/l/236x260/oleg-vintage-coffee-table-in-large-size-oleg-vintage-coffee-table-in-large-size-zagrzm.jpg',3),(8,'Dressing Tables',1563,'Dressing Tables','https://ii1.pepperfry.com/media/catalog/product/g/l/236x260/glaze-dressing-table-glaze-dressing-table-qawskl.jpg',3),(9,'Study Tables',2658,'Study Tables','https://ii3.pepperfry.com/media/catalog/product/a/p/236x260/apple--flexi-motorized-height-adjustable-table-by-atmosphere-apple--flexi-motorized-height-adjustabl-unyk2y.jpg',3),(10,'Dining Tables',1245,'Dining Tables','https://ii3.pepperfry.com/media/catalog/product/l/i/236x260/lima-solid-wood-6-seater-dining-table-in-honey-oak-finish-by-woodsworth-lima-solid-wood-6-seater-din-uo8oz3.jpg',4),(11,'Dining Chairs',1036,'Dining Chairs','https://ii3.pepperfry.com/media/catalog/product/z/e/236x260/zenith-solid-wood-dining-chair-in---set-of-2---provincial-teak-finish-by-amberville-zenith-solid-woo-6i9dtx.jpg',4),(12,'Dining Sets',1548,'Dining Sets','https://ii1.pepperfry.com/media/catalog/product/l/i/236x260/lima-solid-wood-4-seater-dining-set-in-honey-oak-finish-by-woodsworth-lima-solid-wood-4-seater-dinin-dg8paj.jpg',4),(13,'Shoe Racks',1254,'Shoe Racks','https://ii2.pepperfry.com/media/catalog/product/k/u/236x260/kutsu-2-door-shoe-rack-with-seat-in-natural-teak-finish-by-mintwud-kutsu-2-door-shoe-rack-with-seat--mb4faj.jpg',5),(14,'Book Shelves',3652,'Book Shelves','https://ii3.pepperfry.com/media/catalog/product/a/d/236x260/addison-solid-wood-book-shelf-in-rustic-teak-finish-by-woodsworth-addison-solid-wood-book-shelf-in-r-yijvkl.jpg',5),(15,'Wardrobes',1598,'Wardrobes','https://ii2.pepperfry.com/media/catalog/product/u/j/236x260/ujisato-6-door-wardrobe-with-2-drawers-by-mintwud-ujisato-6-door-wardrobe-with-2-drawers-by-mintwud-iktmg9.jpg',5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-26 17:51:25
