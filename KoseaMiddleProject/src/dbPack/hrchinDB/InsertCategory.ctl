load data
infile 'C:\hrchinDB\Category.csv'
append
into table Category
fields terminated by ','
(pro_type, type_name1, type_name2)