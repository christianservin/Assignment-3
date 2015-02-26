DROP TABLE IF EXISTS investment; 

CREATE TABLE investment(
investment_id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
investmentTotal decimal(10,2),
investmentRemainder decimal(10,2),
stock1 varchar(10),
stock2 varchar(10),
stock3 varchar(10),
stock1price decimal(10,2),
stock2price decimal(10,2),
stock3price decimal(10,2),
stock1shares int(6),
stock2shares int(6),
stock3shares int(6),
stock1investment decimal(10,2),
stock2investment decimal(10,2),
stock3investment decimal(10,2));