/*
"L" displays current inventory
"Q" quits the program
"BUY i" buys car number i
"RET" returns last bought car
"ADD" adds the inventory of cars to current inventory
"SPR" sorts by price
"SSR" sorts by safety rating
"SMR" sorts by max range
"FPR x y" filters by price where x <= price <= y
"FEL" filters by electric
"FAW" filters by AWD
"FCL" clears filters
"SALES" prints all transactions for the year
"SALES TEAM" prints the names of all sales persons
"SALES TOPSP" prints sale person(s) with the most sold cars
"SALES m" prints transactions for month number m
"SALES STATS" prints stats of sales for the year
*/

.shell cls

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
/*
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

SELECT Genmodel_ID, Genmodel, COUNT(*)
FROM sales
GROUP BY Genmodel_ID, Genmodel
HAVING COUNT(*) > 1;

SELECT Image_name, COUNT(*)
FROM image
GROUP BY Image_name
HAVING COUNT(*) > 1;
*/

-- Display used car listings
SELECT maker, genmodel, genmodel_id, adv_id, adv_year, adv_month, color, reg_year, bodytype, runned_miles, engin_size, gearbox, fuel_type, price, seat_num, door_num
FROM ad
ORDER BY price
LIMIT 50 OFFSET 250000;




