INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 1,'KWID','Renault','RXT','2005','White'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=1);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 2,'KWID','Renault','RXT','2005','Blue'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=2);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 3,'KWID','Renault','STD','2010','Grey'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=3);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 4,'KWID','Renault','RXL','2010','White'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=4);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 5,'KWID','Renault','Climber','2015','Grey'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=5);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 6,'i20','Hyundai','Magna','2016','Grey'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=6);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 7,'i20','Hyundai','Magna','2016','White'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=7);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 8,'i20','Hyundai','Sportz','2017','Black'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=8);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 9,'i20','Hyundai','Sportz','2017','White'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=9);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 10,'i20','Hyundai','Asta','2018','Black'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=10);

INSERT INTO car (id, name, manufacturerName,model,manufacturingYear,color)
SELECT 11,'i20','Hyundai','Asta','2018','Black'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM car WHERE id=11);

INSERT INTO user (id, emailId,password)
SELECT 1,'developer@fincity.com','password'
FROM DUAL
WHERE NOT EXISTS
          (SELECT id FROM user WHERE id=1);