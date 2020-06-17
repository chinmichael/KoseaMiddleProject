load data
infile 'C:\hrchinDB\Shop.csv'
append
into table Shop
fields terminated by ','
(shop_id, shop_name, shop_location)