# Dataset

- paper: https://arxiv.org/pdf/2109.00881.pdf
- site: https://deepvisualmarketing.github.io/
- download: https://figshare.com/articles/figure/DVM-CAR_Dataset/19586296/1?file=34792483

# Rebuild dataset

```
sqlite3 database.db
.read create.sql
```

# Schema

## Basic (1011 records)

- Automaker / Automaker_ID
- Genmodel / Genmodel_ID
- **PRIMARY KEY (Genmodel_ID)**

## Price (6333 records)

- Maker
- Genmodel / Genmodel_ID
- Year
- Entry_price (cheapest trim price)
- **PRIMARY KEY (Genmodel_ID, Year)**

## Ad (268255 records)

- Maker
- Genmodel
- Genmodel_ID
- Adv_ID
- Adv_year
- Adv_month
- Color
- Reg_year
- Bodytype
- Runned_Miles
- Engin_size
- Gearbox
- Fuel_type
- Price
- Seat_num
- Door_num
- **PRIMARY KEY (Adv_ID)**

## Trim (335562 records)

- Genmodel_ID
- Maker
- Genmodel
- Trim
- Year
- Price
- Gas_emission
- Fuel_type
- Engine_size
- NO PRIMARY KEY

## Sales (772 records)

- Maker
- Genmodel
- Genmodel_ID
- 2001 up to 2020
- **PRIMARY KEY (Genmodel_ID, Genmodel)**

## Image (240502 records)

- Genmodel_ID
- Image_ID
- Image_name
- Predicted_viewpoint
- Quality_check
- **PRIMARY KEY (Image_name)**
