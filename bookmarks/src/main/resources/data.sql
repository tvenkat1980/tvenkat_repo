DROP TABLE IF EXISTS BOOK_MARKS;
 
CREATE TABLE BOOK_MARKS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  BKMRK_NAME VARCHAR(250) NOT NULL,
  BKMRK_URL VARCHAR(250) NOT NULL,
  BKMRK_CATEGORY VARCHAR(250) DEFAULT NULL,
  BKMRK_NOTES VARCHAR(1000) DEFAULT NULL
);