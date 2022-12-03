-- average price of hondas
/*
SELECT AVG(entry_price) AS "Average Price"
FROM price
WHERE maker LIKE "honda";
*/

-- get path of images of bugattis
/*
SELECT Image_name
FROM basic
JOIN image
ON basic.Genmodel_ID = image.Genmodel_ID
WHERE basic.automaker LIKE "bugatti"
AND image.Predicted_viewpoint = "0";
*/

-- order all cars by price
/*
SELECT *
FROM price
WHERE entry_price > 200000
ORDER BY entry_price;
*/ 

-- check that primary keys are unique

SELECT Genmodel_ID, COUNT(*)
FROM basic
GROUP BY Genmodel_ID
HAVING COUNT(*) > 1;

SELECT Genmodel_ID, Year, COUNT(*)
FROM price
GROUP BY Genmodel_ID, Year
HAVING COUNT(*) > 1;

SELECT Adv_ID, COUNT(*)
FROM ad
GROUP BY Adv_ID
HAVING COUNT(*) > 1;

/*
SELECT Genmodel_ID, Genmodel, Year, COUNT(*)
FROM trim
GROUP BY Genmodel_ID, Genmodel, Year
HAVING COUNT(*) > 1;
*/

SELECT Genmodel_ID, Genmodel, COUNT(*)
FROM sales
GROUP BY Genmodel_ID, Genmodel
HAVING COUNT(*) > 1;

SELECT Image_name, COUNT(*)
FROM image
GROUP BY Image_name
HAVING COUNT(*) > 1;