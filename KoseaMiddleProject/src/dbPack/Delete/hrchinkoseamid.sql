DROP USER hrchin CASCADE;

CREATE USER hrchin IDENTIFIED BY kosea;

GRANT CONNECT, RESOURCE TO hrchin;

GRANT CREATE SESSION TO hrchin;

GRANT DBA TO hrchin;

ALTER USER hrchin ACCOUNT UNLOCK;

conn hrchin/kosea;

CREATE TABLE Rank (
	user_type		CHAR(1),
	rank_name	VARCHAR2(10)	not null,
	CONSTRAINT PK_Rank	PRIMARY KEY(user_type)
);

CREATE TABLE Shop (
	shop_id		CHAR(4),
	shop_name	VARCHAR2(50)	not null,
	shop_location	VARCHAR2(50),
	CONSTRAINT PK_Shop	PRIMARY KEY(shop_id)
);

CREATE TABLE UserK (
	user_name	VARCHAR2(30)	not null,
	user_id		VARCHAR2(30),
	user_pw		VARCHAR2(30)	not null,
	e_mail		VARCHAR2(50),
	phone		VARCHAR2(13)	not null,
	hint		VARCHAR2(50)	not null,
	hint_answer	VARCHAR2(50)	not null,
	shop_id		CHAR(4),
	user_type		CHAR(1),
	owner_code	VARCHAR2(6),
	CONSTRAINT PK_UserK	PRIMARY KEY(user_id),
	CONSTRAINT FK_UserK1	FOREIGN KEY(shop_id)	REFERENCES Shop(shop_id) ON DELETE CASCADE,
	CONSTRAINT FK_UserK2	FOREIGN KEY(user_type)	REFERENCES Rank(user_type) ON DELETE SET NULL
);

CREATE TABLE Category (
	pro_type		CHAR(2),
	type_name1	VARCHAR2(30)	not null,
	type_name2	VARCHAR2(30)	not null,
	CONSTRAINT PK_Category	PRIMARY KEY(pro_type)
);

CREATE TABLE Product (
	pro_id		VARCHAR2(50),
	pro_name	VARCHAR2(50)	not null,
	pro_price		NUMBER		DEFAULT 0 CHECK(pro_price >= 0),
	pro_type		CHAR(2),
	comp		VARCHAR2(50),
	type_exp		CHAR(10)		not null,
	CONSTRAINT PK_Product	PRIMARY KEY(pro_id),
	CONSTRAINT FK_Product	FOREIGN KEY(pro_type)	REFERENCES Category(pro_type) ON DELETE SET NULL
);

CREATE TABLE Stock (
	serial_num	NUMBER,
	shop_id		CHAR(4),
	pro_id		VARCHAR2(50),
	location		VARCHAR2(50),
	stock_num	NUMBER		DEFAULT 0 CHECK(stock_num >= 0),
	exp_date		DATE,
	exp_check1	CHAR(1),
	exp_check2	CHAR(1),
	dissuse_count	NUMBER		DEFAULT 0 CHECK(dissuse_count >= 0),
	count_month	CHAR(2),
	CONSTRAINT PK_Stock	PRIMARY KEY(serial_num),
	CONSTRAINT FK_Stock1	FOREIGN KEY(shop_id)	REFERENCES Shop(shop_id) ON DELETE CASCADE,
	CONSTRAINT FK_Stock2	FOREIGN KEY(pro_id)	REFERENCES Product(pro_id) ON DELETE CASCADE,
	CONSTRAINT CK_Stock_exp_check1	CHECK(exp_check1 = '0' OR exp_check1 = '1'),
	CONSTRAINT CK_Stock_exp_check2	CHECK(exp_check2 = '0' OR exp_check2 = '1')
);

$ sqlldr userid = hrchin/kosea control = "C:\hrchinDB\InsertRank.ctl" log ="C:\hrchinDB\logtest.log"
$ sqlldr userid = hrchin/kosea control = "C:\hrchinDB\InsertShop.ctl" log ="C:\hrchinDB\logtest.log"
$ sqlldr userid = hrchin/kosea control = "C:\hrchinDB\InsertUser.ctl" log ="C:\hrchinDB\logtest.log"
$ sqlldr userid = hrchin/kosea control = "C:\hrchinDB\InsertCategory.ctl" log ="C:\hrchinDB\logtest.log"
$ sqlldr userid = hrchin/kosea control = "C:\hrchinDB\InsertProduct.ctl" log ="C:\hrchinDB\logtest.log"
$ sqlldr userid = hrchin/kosea control = "C:\hrchinDB\InsertStock.ctl" log ="C:\hrchinDB\logtest.log"

COMMIT;