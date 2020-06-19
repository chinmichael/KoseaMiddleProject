load data
infile 'C:\hrchinDB\Stock.csv'
append
into table Stock
fields terminated by ','
(serial_num,
shop_id,
pro_id,
location,
stock_num,
exp_date DATE,
disuse_count,
count_month) 