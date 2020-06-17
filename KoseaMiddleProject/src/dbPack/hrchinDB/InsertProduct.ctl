load data
infile 'C:\hrchinDB\Product.csv'
append
into table Product
fields terminated by ','
(pro_id, pro_name, pro_price, pro_type, comp, type_exp)