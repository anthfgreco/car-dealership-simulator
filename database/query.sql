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

-- Display used car listings
SELECT maker, genmodel, adv_year, adv_month, color, reg_year, bodytype, runned_miles, engin_size, gearbox, fuel_type, price, seat_num, door_num
FROM ad
LIMIT 50 OFFSET 0;




