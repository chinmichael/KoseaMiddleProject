LOAD DATA
INFILE 'C:\hrchinDB\Rank.csv'
APPEND
INTO TABLE Rank
FIELDS TERMINATED BY ','
(user_type, rank_name)