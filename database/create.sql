.headers on

.mode csv

DROP TABLE IF EXISTS "basic";

DROP TABLE IF EXISTS "price";

DROP TABLE IF EXISTS "ad";

DROP TABLE IF EXISTS "image";

DROP TABLE IF EXISTS "sales";

DROP TABLE IF EXISTS "trim";

CREATE TABLE "basic"(
    "Automaker" TEXT,
    "Automaker_ID" TEXT,
    "Genmodel" TEXT,
    "Genmodel_ID" TEXT,
    PRIMARY KEY ("Genmodel_ID")
);

CREATE TABLE "price"(
    "Maker" TEXT,
    "Genmodel" TEXT,
    "Genmodel_ID" TEXT,
    "Year" INT,
    "Entry_price" INT,
    PRIMARY KEY ("Genmodel_ID", "Year")
);

CREATE TABLE "ad"(
    "Maker" TEXT,
    "Genmodel" TEXT,
    "Genmodel_ID" TEXT,
    "Adv_ID" TEXT,
    "Adv_year" INT,
    "Adv_month" INT,
    "Color" TEXT,
    "Reg_year" INT,
    "Bodytype" TEXT,
    "Runned_Miles" INT,
    "Engin_size" TEXT,
    "Gearbox" TEXT,
    "Fuel_type" TEXT,
    "Price" INT,
    "Seat_num" INT,
    "Door_num" INT,
    PRIMARY KEY ("Adv_ID")
);

CREATE TABLE "image"(
    "Genmodel_ID" TEXT,
    "Image_ID" TEXT,
    "Image_name" TEXT,
    "Predicted_viewpoint" TEXT,
    "Quality_check" TEXT,
    PRIMARY KEY ("Image_name")
);

CREATE TABLE "sales"(
    "Maker" TEXT,
    "Genmodel" TEXT,
    "Genmodel_ID" TEXT,
    "2020" INT,
    "2019" INT,
    "2018" INT,
    "2017" INT,
    "2016" INT,
    "2015" INT,
    "2014" INT,
    "2013" INT,
    "2012" INT,
    "2011" INT,
    "2010" INT,
    "2009" INT,
    "2008" INT,
    "2007" INT,
    "2006" INT,
    "2005" INT,
    "2004" INT,
    "2003" INT,
    "2002" INT,
    "2001" INT,
    PRIMARY KEY ("Genmodel_ID", "Genmodel")
);

CREATE TABLE "trim"(
    "Genmodel_ID" TEXT,
    "Maker" TEXT,
    "Genmodel" TEXT,
    "Trim" TEXT,
    "Year" INT,
    "Price" INT,
    "Gas_emission" INT,
    "Fuel_type" TEXT,
    "Engine_size" INT
);

-- If TABLE does not exist, it is created. The first row of input determines the column names.
-- In this case, tables are created above so we must ignore the first line (header line).

.import ./database-csv/ad_table.csv ad -v --skip 1

.import ./database-csv/basic_table.csv basic -v --skip 1

.import ./database-csv/image_table.csv image -v --skip 1

.import ./database-csv/price_table.csv price -v --skip 1

.import ./database-csv/sales_table.csv sales -v --skip 1

.import ./database-csv/trim_table.csv trim -v --skip 1

-- Records where predicted_viewpoint aren't from the front (aren't currently downloaded)
DELETE FROM
    image
WHERE
    predicted_viewpoint != "0";

-- Necessary to reduce size
-- Removes 100MB from previous step
VACUUM;