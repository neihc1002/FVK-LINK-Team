CREATE DATABASE Store
GO
USE Store
CREATE TABLE tblProduct
(
_id varchar(10) PRIMARY KEY,
_name nvarchar(255) NOT NULL,
_producer nvarchar(255) NOT NULL,
_type varchar(15) NOT NULL,
_memory varchar(10) DEFAULT 'null',
_pricein varchar(15) NOT NULL,
_priceout varchar(15) NOT NULL,
_quantity int NOT NULL,
_guarantee varchar(10) NOT NULL,
_money varchar(5) NOT NULL,
_info nvarchar(max),
_image varbinary(max)
)
CREATE TABlE tblUser
(
UserName varchar(10) PRIMARY KEY,
Pass varchar(10) NOT NULL,
Quyen varchar(10)
)
INSERT INTO tblUser VALUES ('duong', '123','user')
SELECT * FROM tblProduct
SELECT * FROM tblUser WHERE UserName = 'admin'
DROP TABLE tblProduct
DROP DATABASE Store
DROP TABLE tblProducer
	INSERT INTO tblProduct (_id, _name, _producer,_type,_memory,_pricein,_priceout,_quantity,_guarantee,_money,_info,_image) SELECT 'PD5', 'OPPO F1s', 'OPPO', 'Phone', '16 GB', '4990000','5900000', 45, '12 Month', 'VND','Màn hình :5.5 inch ( 3840 x 2160 pixels)
	Camera :Chính: 19.0 MP, Phụ: 13.0 MP
	RAM :4 GB
	Bộ nhớ trong :UFS 64 GB
	Hệ điều hành :Android OS, v7.1 (Nougat)
	Chipset :Qualcomm Snapdragon 835
	Kích thước :156 x 77 x 7.9 mm.',BulkColumn 
	from Openrowset (Bulk 'E:\sonyxperiaXz.jpg', Single_Blob) as Image
SELECT * FROM tblProducer
UPDATE tblProduct SET Gia = '16.990.000' WHERE Masanpham = 'SP002'
CREATE TABLE tblProducer
(
ProducernName nvarchar(255) PRIMARY KEY,
Infor nvarchar(255)
)
INSERT INTO tblProducer VALUES ('OPPO', '')
CREATE TABLE tblInputList
(
_idOrder varchar(10) references tblInputOrder(_id) NOT NULL,
_idProduct varchar(10) references tblProduct(_id) NOT NULL,
_quantity int NOT NULL,
_price varchar(15) NOT NULL,
_producer nvarchar(225),
_memory varchar(10)
)
CREATE TABLE tblInputOrder
(
_id varchar(10) PRIMARY KEY,
__importer nvarchar(255), 
_date varchar(20),
_totalPrice varchar(15),
_quantityProduct int
)
SELECT *FROM tblInputOrder
DROP TABLE tblCustomer
DROP TABLE  tblOutputOrder
SELECT *FROM tblInputList WHERE _idOrder='#IO10002'
CREATE TABLE tblCustomer
(
_id varchar(10) PRIMARY KEY,
_name nvarchar(255) NOT NULL,
_phonenumber varchar(11),
_total varchar(15),
_rank varchar(10)
)
CREATE TABLE tblOutputOrder
(
_id varchar(10) PRIMARY KEY,
_idCus varchar(10) references tblCustomer(_id) NOT NULL,
_date varchar(20) NOT NULL,
_quantity int,
_sale varchar(15),
_totalamount varchar(15) NOT NULL,
_note nvarchar(max)
)
CREATE TABLE tblOutputList
(
_idOP varchar(10) references tblOutputOrder(_id) NOT NULL,
_idPr varchar(10) references tblProduct (_id) NOT NULL,
_quantity int NOT NULL,
_amount varchar(15)
)
DROP TABLE tblcodesale
CREATE TABLE tblcodesale
(
_code varchar(10) PRIMARY KEY,
_price varchar(15) NOT NULL,
_status varchar(10) NOT NULL
)
INSERT INTO tblcodesale VALUES('123455','200000','used')