load data
infile 'C:\hrchinDB\User.csv'
append
into table UserK
fields terminated by ','
(user_name, user_id, user_pw, e_mail, phone, hint, hint_answer, shop_id, user_type, owner_code)