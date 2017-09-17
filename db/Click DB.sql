
Drop DATABASE IF EXISTS CLICK;
CREATE DATABASE CLICK;
USE CLICK;

create table Customer(
	id int not null AUTO_INCREMENT,
	name varchar(150) not null,
	contact int not null,
	nic varchar(20),
	constraint primary key(id)
);

insert into Customer values(null,"Anonymous",0,"0V");

Create table User(
	id int not null AUTO_INCREMENT,
	username varchar(50) not null,
	password varchar(50) not null,
	type varchar(10) not null,
	constraint primary key(id)
);


insert into User values(null,"superadmin","enter9","admin");

Create table Category(
	id int not null AUTO_INCREMENT,
	name varchar(50) not null,
	Constraint primary key(id)
);

Create table Item(
	code varchar(20) not null,
	serial varchar(40),
	description varchar(150) not null,
	catid int not null,		
	rol int not null default -1,
	Constraint primary key(code),
	Constraint foreign key(catid) references Category(id)
	on update cascade on delete cascade
);

Create table Orders(
	id varchar(20) not null,
	date date not null,
	time time not null,
	uid int not null,
	cid int not null,
	status int not null,
	amount DECIMAL(10,2) not null,
	Constraint primary key(id),
	constraint foreign key(uid) references User(id),
	constraint foreign key(cid) references Customer(id)
);

Create table Orderdetail(
	codid int not null AUTO_INCREMENT,
	code varchar(20) not null,
	oid varchar(20) not null,
	qty int not null,
	soldprice DECIMAL(10,2) not null,
	bid varchar(20) not null,
	Constraint primary key(codid,code,oid),
	constraint foreign key(code) references Item(code)
	on update cascade on delete cascade,
	Constraint foreign key(oid) references Orders(id)
	on update cascade on delete cascade
);

Create table Cserial(
	id int not null AUTO_INCREMENT,
	serial varchar(50) not null,
	tag1 int,
	tag2 int,
	codid int not null,
	period int,
	Constraint primary key(id),
	constraint foreign key(codid) references Orderdetail(codid)
	on update cascade on delete cascade
);

Create table JobCategory(
	id int not null AUTO_INCREMENT,
	title varchar(50) not null,
	Constraint primary key(id)
);

Create table Job(
	id varchar(20) not null,
	description  varchar(500) not null,
	time time not null,
	date date not null,
	status varchar(3) not null,
	totAmount double(10,2),
	cid int not null,
	jcid int not null,
	Constraint primary key(id),
	constraint foreign key(cid) references Customer(id),
	constraint foreign key(jcid) references JobCategory(id)
);

-- -------------Edit By Dilhan For Take Job Serials---------------------
	Create table JobSerial (
		id int not null AUTO_INCREMENT,
		serial varchar(40),
		jid varchar(20) not null,
		Constraint primary key(id),
		constraint foreign key(jid) references Job(id)
	);
	
	
--  --------------------------------------------------------------------

Create table Jpayment(
	id varchar(20) not null,
	date date not null,
	amount double(10,2) not null,
	jid varchar(20) not null,
	Constraint primary key(id),
	constraint foreign key(jid) references Job(id)
	on update cascade on delete cascade
);

Create table Jcheque(
	chqno varchar(20) not null ,
	chqdate date not null,
	bank varchar(50) not null,
	jpid varchar(20) not null,
	Constraint primary key(jpid,chqno),
	constraint foreign key(jpid) references Jpayment(id)
	on update cascade on delete cascade
);

Create table Cpayment(
	id varchar(20) not null,
	date date not null,
	amount double(10,2) not null,
	oid varchar(20) not null,
	Constraint primary key(id),
	Constraint foreign key(oid) references Orders(id)
	on update cascade on delete cascade
);

Create table Ccheque(
	chqno varchar(20) not null,
	chqdate date not null,
	bank varchar(50) not null,
	cpid VARCHAR(20) not null,
	Constraint primary key(chqno),
	constraint foreign key(cpid) references Cpayment(id)
	on update cascade on delete cascade
);

Create table Batch(
	id int not null AUTO_INCREMENT,
	qty int not null,
	date date not null,
	unitprice Decimal(10,2) not null,
	listprice Decimal(10,2),
	costprice Decimal(10,2) not null,
	code varchar(15) not null,
	constraint primary key(id),
	constraint foreign key(code) references Item(code)
	on update cascade on delete cascade
);
	
Create table Creturn(
	id varchar(20) not null,
	codid int not null,
	qty  int not null,
	date date,
	constraint primary key(id),
	constraint foreign key(codid) references Orderdetail(codid)
	on delete cascade
);
	
Create table Mreturn(
	id varchar(20) not null,
	bid int not null,
	qty  int,
	date date,
	constraint primary key(id),
	constraint foreign key(bid) references Batch(id)
	on delete cascade
);

create table Damage(
	id int not null AUTO_INCREMENT,
	qty int not null,
	reason varchar(1000),
	bid int not null,
	date date,
	constraint primary key(id),
	constraint foreign key(bid) references Batch(id)
	on update cascade on delete cascade
);
-- serial varchar(40),
-- Check this manually

Create table Supplier(
	id int not null AUTO_INCREMENT,
	company varchar(150) not null,
	name varchar(150) not null,
	mobile int,
	office int,
	fax int,
	email varchar(70),
	constraint primary key(id)
);

Create table Grn(
	id varchar(20) not null,
	date date not null,
	sid int not null,
	amount DECIMAL(10,2) not null,
	constraint primary key(id),
	constraint foreign key(sid) references Supplier(id)
);

Create table Grndetail(
	grndid int not null AUTO_INCREMENT,
	grnid varchar(20) not null,
	bid int not null,
	qty int not null,
	constraint primary key(grndid,bid,grnid),
	constraint foreign key(bid) references Batch(id)
	on update cascade on delete cascade,
	constraint foreign key(grnid) references Grn(id)
	on update cascade on delete cascade
);

Create table Dserial(
	id int not null AUTO_INCREMENT,
	serial varchar(50) not null,
	grndid int not null,
	period int,
	Constraint primary key(id),
	constraint foreign key(grndid) references Grndetail(grndid)
	on update cascade on delete cascade
);


Create table Mpayment(
	id varchar(20) not null,
	date date not null,
	amount double(10,2) not null,
	grnid varchar(20) not null,
	Constraint primary key(id),
	constraint foreign key(grnid) references Grn(id)
	on update cascade on delete cascade
);

Create table Mcheque(
	chqno varchar(20) not null ,
	chqdate date not null,
	pid varchar(20) not null,
	bank varchar(50) not null,
	Constraint primary key(pid,chqno),
	constraint foreign key(pid) references Mpayment(id)
	on update cascade on delete cascade
);

Create table Account(
	id int not null AUTO_INCREMENT,
	uid int not null,
	date DATE not null,
	time time not null,
	type int not null,
	description VARCHAR(250) not null,
	amount DECIMAL(10,2) not null,
	Constraint primary key(id),
	constraint foreign key(uid) references User(id)
);

Create table userloger(
	userlogerId int not null AUTO_INCREMENT,
	username varchar(35) not null,
	loginDate DATE not null,
	logintime time not null,
	logouttime time,
	logoutDate DATE,
	Constraint primary key(userlogerId)
);


  --
  -- --------------------------------------------------------- VIEWS ------------------------------------------------------------------
  --




CREATE OR REPLACE VIEW CustomerPayment AS
select c.id, sum(cpd.amount) as AllPayment
from Customer c , Orders o , CPayment cpd 
where c.id=o.cid && o.id=cpd.oid 
group by c.id ;


CREATE OR REPLACE VIEW CustomerOrderTotal AS
select c.id, sum(o.amount)as totalamount
from Customer c , Orders o 
where c.id=o.cid 
group by c.id ;

CREATE OR REPLACE VIEW CustomerTable AS
select c.id, c.name, c.contact, c.nic, totalamount-AllPayment as DuePayment
from Customer c , CustomerPayment cps, CustomerOrderTotal co
where cps.id=c.id && co.id=c.id
group by c.id ;

CREATE OR REPLACE VIEW ItemBatch AS
select b.id as bid, i.code as code, b.unitprice as unitPrice, b.listprice as minPrice, b.costprice as costPrice, b.qty as qty
from Batch b, Item i 
where b.code=i.code && b.qty > 0
order by date ;


CREATE OR REPLACE VIEW BatchRest AS
select b.id, b.qty, b.costPrice, b.unitprice, i.code
from Batch b , Item i 
where b.code=i.code && b.qty>0;


CREATE OR REPLACE VIEW MyPayments AS
select s.id, sum(mp.amount) as allPayment
from MPayment mp, GRN g, Supplier s
where g.id=mp.grnid && s.id=g.sid
group by s.id;


CREATE OR REPLACE VIEW MyGrnTotal AS
select s.id, sum(g.amount) as totalamount
from  GRN g, Supplier s
where s.id=g.sid
group by s.id;


CREATE OR REPLACE VIEW SupplierTable AS
select s.id, s.company, s.name, s.mobile, s.office, s.fax, s.email, mgt.totalamount - p.allPayment as duePayment
from MyGrnTotal mgt, Supplier s, MyPayments p
where s.id=p.id && mgt.id=s.id
group by s.id;

CREATE OR REPLACE VIEW AllOrders AS
select c.id as CusId, c.name, u.username, o.date, o.id as OrderId, o.status, o.amount
from Orders o, User u, Customer c
where o.uid=u.id && o.cid=c.id 
Order by o.date;

CREATE OR REPLACE VIEW QOH AS 
select sum(qty) as qty, i.code as code 
from item i, batch b 
where  i.code=b.code  
group by i.code;
   


  --
  -- --------------------------------------------------------- TEST QUERY ------------------------------------------------------------------
  --

DROP PROCEDURE IF EXISTS AddDamage;
DELIMITER $$
CREATE
PROCEDURE AddDamage(IN bid varchar(6), reason1 varchar(1000), date1 DATE, qty1 int, sn varchar(100))
BEGIN
DECLARE qoh int DEFAULT 0;
DECLARE newQ int DEFAULT 0;
DECLARE EXIT handler FOR SQLEXCEPTION
BEGIN
ROLLBACK;
END;
START TRANSACTION;
SELECT qty FROM Batch WHERE id=bid INTO qoh;
SET newQ=qoh-qty1;
INSERT INTO Damage VALUES(NULL,qty1,reason1,bid,date1);
IF sn IS NOT NULL THEN
DELETE FROM Dserial WHERE serial=sn;
END IF;
UPDATE Batch SET qty=newQ WHERE id=bid;
select '1' as res;
COMMIT;
END$$
DELIMITER ;




DROP PROCEDURE IF EXISTS AddGRNDetail;
DELIMITER $$
CREATE
PROCEDURE AddGRNDetail(IN qty1 INT, costP DECIMAL, unitP DECIMAL, minP DECIMAL, date1 DATE, itemCode VARCHAR(30), grnid VARCHAR(30))
BEGIN
DECLARE grndid VARCHAR(30) DEFAULT NULL;
DECLARE bid VARCHAR(30) DEFAULT NULL;
DECLARE EXIT handler FOR SQLEXCEPTION
BEGIN
ROLLBACK;
END;
START TRANSACTION;
INSERT INTO Batch VALUES(NULL,qty1,date1,unitP,minP,costP,itemCode);
SELECT LAST_INSERT_ID() INTO bid;
INSERT INTO Grndetail VALUES(NULL,grnid,bid,qty1);
SELECT LAST_INSERT_ID() INTO grndid;
SELECT bid,grndid;
COMMIT;
END$$
DELIMITER ;


  
  
DROP PROCEDURE IF EXISTS UpdateGRN;
DELIMITER $$
CREATE
PROCEDURE UpdateGRN(IN batchid INT, qtyu INT, grndid1 INT, cost1 DECIMAL, unit1 DECIMAL, min1 DECIMAL, code1 varchar(2))
BEGIN
DECLARE qtyp INT DEFAULT 0;
DECLARE newQ INT DEFAULT 0;
DECLARE qtyg INT DEFAULT 0;
DECLARE EXIT handler FOR SQLEXCEPTION
BEGIN
ROLLBACK;
END;
START TRANSACTION;
SELECT qty FROM Batch WHERE id=batchid INTO qtyp;
SELECT qty FROM Grndetail WHERE grndid=grndid1 INTO qtyg;
SET newQ = qtyu-(qtyg-qtyp);
UPDATE Grndetail SET qty=qtyu WHERE grndid=grndid1;
UPDATE Batch SET qty=newQ, costprice=cost1,listprice=min1,unitprice=unit1 WHERE id=batchid;
IF code1 IS NOT NULL THEN
DELETE FROM Dserial WHERE grndid=grndid1;
END IF;
select '1';
COMMIT;
END$$
DELIMITER ;




DROP PROCEDURE IF EXISTS AddReturn;
DELIMITER $$
CREATE
PROCEDURE AddReturn(IN batchid INT, rqty INT, odrid VARCHAR(25), serial1 varchar(25), states int, reasons varchar(500), cretid varchar(25), mretid varchar(25),userid int)
BEGIN
DECLARE odid INT DEFAULT 0;
DECLARE sold DECIMAL(10,2) DEFAULT 0.0;
DECLARE tot DECIMAL(10,2) DEFAULT 0.0;
DECLARE amnt DECIMAL(10,2) DEFAULT 0.0;
DECLARE newamount DECIMAL(10,2) DEFAULT 0.0;
DECLARE dis DECIMAL(10,2) DEFAULT 0.0;
DECLARE payid varchar(30) DEFAULT null;
DECLARE EXIT handler FOR SQLEXCEPTION
BEGIN
ROLLBACK;
END;
START TRANSACTION;
select codid from Orderdetail where oid=odrid && bid=batchid into odid;
Insert into Creturn values(cretid,odid,rqty,CurDate());
Update Orderdetail set qty=qty-rqty where codid=odid;
select soldprice from Orderdetail where codid=odid into sold;
select sum(qty*soldprice) from Orderdetail where codid=odid into tot;
select amount from Orders where id=odrid into amnt;
set dis=tot-amnt;
set newamount=(tot-(sold*rqty))-dis;
update orders set amount=newamount where id=odrid;
select id from cpayment where oid=odrid into payid;
IF serial1 IS NOT NULL THEN
delete from Cserial where codid=odid && serial=serial1;
END IF;
IF states=0 THEN
update batch set qty=qty+rqty where id=batchid;
IF payid IS NOT null THEN
Insert into account values(null,userid,curdate(),curtime(),2,'Withdraw(customer returns)', -sold*rqty);
END IF;
END IF;
IF states=1 THEN
Insert into Damage values(null,rqty,reasons,batchid,CurDate());
IF payid IS NOT null THEN
Insert into account values(null,userid,curdate(),curtime(),3,'Damage Item', -sold*rqty);
END IF;
END IF;
IF states=2 THEN
Insert into Mreturn values(mretid,batchid,rqty,CurDate());
END IF;
select '1';
COMMIT;
END$$
DELIMITER ;


  