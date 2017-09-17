

-- Customer Data


insert into Customer values(null,"Dilhan Mendis",0778345524,"942740913V");
insert into Customer values(null,"Arty Sewwandi",0785324869,"941236547V");
insert into Customer values(null,"Vihanga Yasith",0714569874,"941234513V");
insert into Customer values(null,"Harsha Yashoda",0728365524,"945863213V");
insert into Customer values(null,"Polta Amila",0771234524,"943112280V");
insert into Customer values(null,"T B J",0710710917,"941254658V");
insert into Customer values(null,"Sasanga Dodol",0750753886,"941195700V");
insert into Customer values(null,"Kisal Ayya",0777900735,"642236853V");
insert into Customer values(null,"Siripala",0764252994,"942236853V");
insert into Customer values(null,"Bill Gates",0912224412,"790154121V");



-- User Data

insert into User values(null,"User1","1111","user");
insert into User values(null,"User2","2222","user");
insert into User values(null,"manager","3333","manager");
insert into User values(null,"admin","admin","admin");

-- Item Category Data

insert into Category values(null,"Laptop");
insert into Category values(null,"Router");
insert into Category values(null,"Mobile Phone");
insert into Category values(null,"Charger");
insert into Category values(null,"HeadSet");
insert into Category values(null,"Mouse");
insert into Category values(null,"Kayboard");
insert into Category values(null,"Pen Drive");
insert into Category values(null,"Speaker");
insert into Category values(null,"HDD");

-- Item Data

insert into Item values("IT00000001","11111111","Dell I3 4th Gen",1,2);
insert into Item values("IT00000002","22222222","Huawei LAN Router",2,3);
insert into Item values("IT00000003","33333333","Lumia 540",3,1);
insert into Item values("IT00000004","44444444","Dell Charger",4,5);
insert into Item values("IT00000005","55555555","Kasai i9000",5,2);
insert into Item values("IT00000006","66666666","Corsair vengeance M65",6,5);
insert into Item values("IT00000007","77777777","Cherry 45i",7,2);
insert into Item values("IT00000008","88888888","Kingston 32GB",8,5);
insert into Item values("IT00000009","99999999","Sony W553 Stereo",9,2);
insert into Item values("IT00000010","10101010","Kingston 1TB",10,2);

insert into Item values("IT00000011","12121212","HP Pavilion P6",1,2);
insert into Item values("IT00000012","13131313","Huawei 802.11 Wireless Router",2,2);
insert into Item values("IT00000013","14141414","Samsung S6",3,1);
insert into Item values("IT00000014","15151515","19.5V DC Universal charger",4,1);
insert into Item values("IT00000015","16161616","Dell Charger",5,2);
insert into Item values("IT00000016","17171717","Beats (Dr.Dre)",6,2);
insert into Item values("IT00000017","18181818","Logitech Optical mouse",7,8);
insert into Item values("IT00000018","19191919","SOS K95 Gming Keyboard",8,1);
insert into Item values("IT00000019","20202020","Kingston 16GB",9,5);
insert into Item values("IT00000020","21212121","KIngston 80GB",10,2);

-- Orders Data

insert into Orders values("CR1601190001","2016-01-19","10:01:00",1,1,0,29000.00);
insert into Orders values("CR1601190002","2016-01-19","12:02:00",2,2,0,2000.00);
insert into Orders values("CR1601180001","2016-01-18","18:00:00",4,3,0,2950.00);
insert into Orders values("CR1601190015","2016-01-19","10:50:00",1,4,0,15000.00);
insert into Orders values("CR1601190003","2016-01-19","12:03:00",2,5,0,5000.00);
insert into Orders values("CR1601180004","2016-01-18","18:30:00",4,6,0,3000.00);
insert into Orders values("CR1601190005","2016-01-19","10:04:00",1,7,0,1000.00);
insert into Orders values("CR1601190006","2016-01-19","12:05:00",2,8,0,28900.00);
insert into Orders values("CR1601180007","2016-01-18","18:06:00",4,9,0,69000.00);
insert into Orders values("CR1601190008","2016-01-19","10:08:00",1,10,0,1000.00);
insert into Orders values("CR1601190009","2016-01-19","12:09:00",2,1,0,23800.00);
insert into Orders values("CR1601180011","2016-01-18","18:11:00",4,2,0,3000.00);
insert into Orders values("CR1601190012","2016-01-19","10:00:00",1,3,1,10500.00);
insert into Orders values("CR1601190013","2016-01-19","12:19:00",2,1,0,1990.00);
insert into Orders values("CR1601180010","2016-01-18","18:20:00",3,2,1,3000.00);

-- Order Details Data

insert into Orderdetail values(null,"IT00000001","CR1601190001",1,1000.00,1);
insert into Orderdetail values(null,"IT00000011","CR1601190001",2,11000.00,11);
insert into Orderdetail values(null,"IT00000017","CR1601190001",1,17000.00,15);

insert into Orderdetail values(null,"IT00000002","CR1601190009",3,2000.00,2);
insert into Orderdetail values(null,"IT00000010","CR1601190009",1,9800.00,10);
insert into Orderdetail values(null,"IT00000012","CR1601190009",2,12000.00,12);

insert into Orderdetail values(null,"IT00000002","CR1601190002",2,2000.00,2);

insert into Orderdetail values(null,"IT00000003","CR1601180007",1,3000.00,3);
insert into Orderdetail values(null,"IT00000016","CR1601180007",2,15500.00,15);
insert into Orderdetail values(null,"IT00000014","CR1601180007",4,13850.00,14);
insert into Orderdetail values(null,"IT00000010","CR1601180007",4,9900.00,10);
insert into Orderdetail values(null,"IT00000005","CR1601180007",3,5000.00,5);
insert into Orderdetail values(null,"IT00000015","CR1601180007",10,14750.00,15);
insert into Orderdetail values(null,"IT00000007","CR1601180007",10,7000.00,7);

insert into Orderdetail values(null,"IT00000003","CR1601180004",1,3000.00,3);

insert into Orderdetail values(null,"IT00000001","CR1601190005",1,1000.00,1);

insert into Orderdetail values(null,"IT00000002","CR1601190006",2,2000.00,2);
insert into Orderdetail values(null,"IT00000005","CR1601190006",1,5000.00,5);
insert into Orderdetail values(null,"IT00000009","CR1601190006",1,8900.00,9);
insert into Orderdetail values(null,"IT00000013","CR1601190006",1,13000.00,13);

insert into Orderdetail values(null,"IT00000003","CR1601180007",4,3000.00,3);

insert into Orderdetail values(null,"IT00000001","CR1601190008",1,1000.00,1);

insert into Orderdetail values(null,"IT00000004","CR1601190015",1,4000.00,4);
insert into Orderdetail values(null,"IT00000011","CR1601190015",1,11000.00,11);

insert into Orderdetail values(null,"IT00000005","CR1601190003",1,5000.00,5);

insert into Orderdetail values(null,"IT00000003","CR1601180011",4,3000.00,3);

insert into Orderdetail values(null,"IT00000001","CR1601190012",1,1000.00,1);
insert into Orderdetail values(null,"IT00000004","CR1601190012",1,4000.00,4);
insert into Orderdetail values(null,"IT00000006","CR1601190012",1,5900.00,6);

insert into Orderdetail values(null,"IT00000003","CR1601180001",4,2950.00,3);

insert into Orderdetail values(null,"IT00000002","CR1601190013",2,1990.00,2);

insert into Orderdetail values(null,"IT00000003","CR1601180010",4,3000.00,3);

-- Customer Serials Data

insert into Cserial values(null,"11111111",null,null,1,30);
insert into Cserial values(null,"22222222",5450,5454,2,300);
insert into Cserial values(null,"33333333",525,256,3,365);
insert into Cserial values(null,"44444444",null,null,4,10);
insert into Cserial values(null,"55555555",252,259,5,60);
insert into Cserial values(null,"66666666",888,889,6,365);
insert into Cserial values(null,"77777777",101,102,7,30);
insert into Cserial values(null,"88888888",null,null,8,300);
insert into Cserial values(null,"99999999",203,208,9,365);

-- Job Category Data

insert into JobCategory values(null,"Mount CCTV");
insert into JobCategory values(null,"Repairing");
insert into JobCategory values(null,"Warranty Claimes");
insert into JobCategory values(null,"Phone Repair");
insert into JobCategory values(null,"Install O/S");
insert into JobCategory values(null,"OTHER");

-- Job Data

insert into Job values("JB1601150001","Mount 2CCTV to abc company","10:00:00","2016-01-17",0,300000,1,1);
insert into Job values("JB1601160001","Dell I3 Laptop Repair","11:00:00","2016-01-18",1,0.0,2,2);
insert into Job values("JB1601170001","lumia 540 with charger set","10:00:00","2016-01-17",0,500,3,3);
insert into Job values("JB1601180001","Lumia 920 Display","10:00:00","2016-01-17",0,14000,4,4);
insert into Job values("JB1601190001","Dual core - Windows 8.1","11:00:00","2016-01-18",1,500,2,5);
insert into Job values("JB1601200001","Mount DVR to XXX company","10:00:00","2016-01-17",0,15000,3,1);
insert into Job values("JB1601220001","HP Repair","10:00:00","2016-01-17",0,2000,4,2);
insert into Job values("JB1601220002","AZUS I3 Laptop Repair","11:00:00","2016-01-18",1,2500,5,3);
insert into Job values("JB1601220003","HP i7 laptop","10:00:00","2016-01-17",0,46252,6,3);
insert into Job values("JB1601220004","Huawei Dongle drivers - W72","10:00:00","2016-01-17",0,2535,1,6);

-- Job Payment data

insert into Jpayment values("JP1601150001","2016-01-17","15000.00","JB1601160001");
insert into Jpayment values("JP1601190001","2016-01-18","2000.00","JB1601190001");
insert into Jpayment values("JP1601220002","2016-01-17","500.00","JB1601220002");
insert into Jpayment values("JP1601220004","2016-01-17","850.50","JB1601220004");
insert into Jpayment values("JP1601210001","2016-01-17","500.00","JB1601150001");


-- Customer Payment Data

insert into Cpayment values("CP000001","2016-01-19",23000.00,"CR1601190001");
insert into Cpayment values("CP000002","2016-01-19",2000.00,"CR1601190002");
insert into Cpayment values("CP000003","2016-01-18",62800.00,"CR1601190009");
insert into Cpayment values("CP000004","2016-01-19",271700.00,"CR1601180007");
insert into Cpayment values("CP000005","2016-01-19",3000.00,"CR1601180004");
insert into Cpayment values("CP000006","2016-01-18",1000.00,"CR1601190005");
insert into Cpayment values("CP000007","2016-01-19",15000.00,"CR1601190015");
insert into Cpayment values("CP000008","2016-01-19",5000.00,"CR1601190003");
insert into Cpayment values("CP000009","2016-01-18",3000.00,"CR1601180011");
insert into Cpayment values("CP000010","2016-01-19",10900.00,"CR1601190012");
insert into Cpayment values("CP000011","2016-01-19",12000.00,"CR1601180010");
insert into Cpayment values("CP000012","2016-01-18",8850.00,"CR1601180001");
insert into Cpayment values("CP000013","2016-01-19",12000.00,"CR1601190013");

-- Customer Cheque data

insert into Ccheque values("CCH000001","2016-02-18","Bank Of Ceylon","CP000004");
insert into Ccheque values("CCH000002","2016-01-20","Sampath Bank","CP000002");
insert into Ccheque values("CCH000003","2016-02-20","Peoples Bank","CP000005");
insert into Ccheque values("CCH000004","2016-01-20","N/T Bank","CP000010");
insert into Ccheque values("CCH000005","2016-02-20","BOC","CP000011");

-- Batch Data

insert into Batch values(null,25,"2016-01-13",1000.00,950.00,900.00,"IT00000001");
insert into Batch values(null,35,"2016-01-13",2000.00,1900.00,1800.00,"IT00000002");
insert into Batch values(null,40,"2016-01-13",21000.00,20000.00,17000.00,"IT00000003");
insert into Batch values(null,25,"2016-01-13",41000.00,4950.00,4900.00,"IT00000004");
insert into Batch values(null,35,"2016-01-13",5200.00,5900.00,5800.00,"IT00000005");
insert into Batch values(null,40,"2016-01-13",6300.00,5950.00,5800.00,"IT00000006");
insert into Batch values(null,25,"2016-01-13",7100.00,6900.00,6800.00,"IT00000007");
insert into Batch values(null,35,"2016-01-13",8000.00,7900.00,7800.00,"IT00000008");
insert into Batch values(null,40,"2016-01-13",9100.00,9000.00,8700.00,"IT00000009");
insert into Batch values(null,25,"2016-01-13",10000.00,9950.00,9000.00,"IT00000010");
insert into Batch values(null,35,"2016-01-13",11000.00,10900.00,10800.00,"IT00000011");
insert into Batch values(null,40,"2016-01-13",12000.00,11800.00,11000.00,"IT00000012");
insert into Batch values(null,25,"2016-01-13",13000.00,12750.00,10900.00,"IT00000013");
insert into Batch values(null,35,"2016-01-13",14000.00,12900.00,12000.00,"IT00000014");
insert into Batch values(null,40,"2016-01-13",15000.00,14000.00,12200.00,"IT00000015");
insert into Batch values(null,25,"2016-01-13",2200.00,1950.00,1900.00,"IT00000002");
insert into Batch values(null,35,"2016-01-13",3200.00,2900.00,2800.00,"IT00000003");
insert into Batch values(null,40,"2016-01-13",4200.00,3900.00,3700.00,"IT00000004");

-- Customer Return Data

insert into Creturn values("CR000001",1,1,"2015-02-20");
insert into Creturn values("CR000002",3,1,"2015-02-21");
insert into Creturn values("CR000003",5,1,"2015-02-22");

-- Owner Return Data

insert into Mreturn values("MR000001",2,1,"2015-02-10");
insert into Mreturn values("MR000002",4,1,"2015-02-20");
insert into Mreturn values("MR000003",6,1,"2015-02-25");

-- Damage Item Data

insert into Damage values(null,1,"burnt",2,"2016-01-02");
insert into Damage values(null,1,"broken due to some reasons !!! lol",4,"2016-01-05");
insert into Damage values(null,2,"burnt down",8,"2016-01-05");

-- SupplierData

insert into Supplier values(null,"Singer Pvt ltd","A.C.Dilhan Mendis",0778345524,0912244356,0912244357,"dilhan.ms@gmail.com");
insert into Supplier values(null,"Abans Pvt ltd","Amila Nuwan Thilina",0778345524,0912244356,0912244357,"polta@gmail.com");
insert into Supplier values(null,"Mars Pvt ltd","Supun Attygala",0778345524,0912244356,0912244357,"arty@gmail.com");
insert into Supplier values(null,"Browns company pvt ltd","A.C.Dilhan Mendis",0778345524,0912244356,0912244357,"dilhan.ms@gmail.com");
insert into Supplier values(null,"Softlogic plc","Amila Nuwan Thilina",0778345524,0912244356,0912244357,"polta@gmail.com");
insert into Supplier values(null,"Andromedia pvt ltd","Supun Attygala",0778345524,0912244356,0912244357,"arty@gmail.com");

-- Grn Data

insert into Grn values("GR000001","2016-01-13",1,12000.00);
insert into Grn values("GR000002","2016-01-14",2,27000.00);
insert into Grn values("GR000003","2016-01-14",3,50000.00);
insert into Grn values("GR000010","2016-01-15",4,45000.00);
insert into Grn values("GR000004","2016-01-16",5,25000.00);
insert into Grn values("GR000005","2016-01-17",6,18000.00);
insert into Grn values("GR000006","2016-01-17",1,15500.00);
insert into Grn values("GR000007","2016-01-19",2,36000.00);
insert into Grn values("GR000008","2016-01-22",2,24000.00);
insert into Grn values("GR000009","2016-01-30",3,47000.00);

-- Grn Item Data

insert into Grndetail values(null,"GR000001",1,20);
insert into Grndetail values(null,"GR000001",2,30);
insert into Grndetail values(null,"GR000001",5,10);
insert into Grndetail values(null,"GR000001",4,20);

insert into Grndetail values(null,"GR000002",3,30);

insert into Grndetail values(null,"GR000003",6,10);

insert into Grndetail values(null,"GR000004",9,20);
insert into Grndetail values(null,"GR000004",7,30);

insert into Grndetail values(null,"GR000005",10,10);

insert into Grndetail values(null,"GR000006",11,20);

insert into Grndetail values(null,"GR000007",12,30);

insert into Grndetail values(null,"GR000008",8,10);
insert into Grndetail values(null,"GR000008",13,20);

insert into Grndetail values(null,"GR000010",14,30);

insert into Grndetail values(null,"GR000009",15,10);
insert into Grndetail values(null,"GR000009",16,20);

-- Dealer Sereial Data

insert into Dserial values(null,"11111111",1,30);
insert into Dserial values(null,"22222222",1,30);
insert into Dserial values(null,"33333333",1,30);
insert into Dserial values(null,"44444444",2,30);
insert into Dserial values(null,"55555555",2,60);
insert into Dserial values(null,"66666666",4,350);
insert into Dserial values(null,"77777777",5,120);
insert into Dserial values(null,"88888888",6,60);
insert into Dserial values(null,"99999999",7,300);
insert into Dserial values(null,"10101010",1,3);

-- Owner Payment Data

insert into Mpayment values("MP00001","2016-01-30",50000.00,"GR000001");
insert into Mpayment values("MP00002","2016-02-01",11700.00,"GR000002");
insert into Mpayment values("MP00003","2016-02-02",80500.00,"GR000003");
insert into Mpayment values("MP00004","2016-01-31",5000.00,"GR000004");
insert into Mpayment values("MP00005","2016-02-12",65000.00,"GR000005");
insert into Mpayment values("MP00006","2016-02-02",44520.00,"GR000006");
insert into Mpayment values("MP00007","2016-01-31",500.00,"GR000007");
insert into Mpayment values("MP00008","2016-02-12",8000.00,"GR000008");

-- Owner Cheque Data

insert into Mcheque values("1595959","2016-02-10","MP00001","BOC");
insert into Mcheque values("1514584","2016-02-10","MP00005","S/B");
insert into Mcheque values("1514554","2016-02-10","MP00007","N/T");

-- owner Account Data

insert into Account values(null,"1","2016-02-1","10:00","2","Withdraw(Customer)","-100");
insert into Account values(null,"1","2016-01-23","12:00","1","Withdraw(Suplier)","-200");
insert into Account values(null,"2","2016-01-15","11:00","2","Add","680");
insert into Account values(null,"1","2016-02-19","9:00","2","Add","700");
insert into Account values(null,"3","2016-01-10","1:00","2","Withdraw(Job)","-270");
insert into Account values(null,"1","2016-02-5","14:00","1","Add","340");
insert into Account values(null,"4","2016-02-10","10:00","1","Withdraw(Customer)","-76");

insert into Account values(null,"1","2016-01-22","10:00","1","Withdraw(Customer)","-100");
insert into Account values(null,"1","2016-01-22","12:00","2","Withdraw(Suplier)","-200");
insert into Account values(null,"2","2016-01-22","11:00","2","Add","680");
insert into Account values(null,"1","2016-01-22","9:00","1","Add","700");
insert into Account values(null,"3","2016-01-22","1:00","2","Withdraw(Job)","-270");
insert into Account values(null,"1","2016-02-22","14:00","1","Add","340");
insert into Account values(null,"4","2016-02-22","10:00","1","Withdraw(Customer)","-76");

INSERT INTO JobCategory VALUES(null,'aaaa');
INSERT INTO JobCategory VALUES(null,'cccc');

INSERT INTO Job values ('JB1602080001','gsdhgdfh','12:20:27','2016-02-08','0',500.00,3,1);
INSERT INTO Job values 
('JB1602080002','bnkmndlkd','12:47:54','2016-02-08','0',500.00,3,1);
INSERT INTO Job values 
('JB1602080003','bjknhi','01:12:32','2016-02-08','0',5000.00,3,1);
INSERT INTO Job values 
('JB1602080004',' nkmnm','01:29:49','2016-02-08','0',50000.00,3,1),('JB1602120001','mnjlknxdbhsdf	50000','10:54:58','2016-02-12','0',500000.00,3,2);
INSERT INTO Job values 
('JB1602120002','bkjmsdkj','12:53:11','2016-02-12','0',500.00,3,1),('JB1602120003','.,bm,;lbg','12:53:54','2016-02-12','0',500.00,3,1);



INSERT INTO JobSerial VALUES (1,'21454','JB1602080002'),(2,'.1231','JB1602080002'),(3,'12541','JB1602080002'),(4,'2136','JB1602080002'),(5,'125','JB1602080002'),(6,'1454156','JB1602080003'),(7,'.21612','JB1602080003'),(8,'121456','JB1602080003'),(9,'515','JB1602080004'),(10,'541564156','JB1602080004'),(11,'1564','JB1602080004'),(12,'kjb,m ,.mkljzxc','JB1602120001'),(13,'jjn,.sd','JB1602120001'),(14,'mlksdf','JB1602120001'),(15,'\',;l','JB1602120001'),(16,',;lkzdx\\','JB1602120001'),(17,';m,kld\\;mlsd\\','JB1602120001'),(18,'145415','JB1602120002'),(19,'454','JB1602120002'),(20,'2152','JB1602120002'),(21,'123','JB1602120002'),(22,'km;','JB1602120003');

INSERT INTO Jpayment VALUES ('JP1602080001','2016-02-08',200.00,'JB1602080002'),('JP1602080002','2016-02-08',3000.00,'JB1602080003'),('JP1602120001','2016-02-12',500000.00,'JB1602120001'),('JP1602120002','2016-02-12',300.00,'JB1602120002'),('JP1602120003','2016-02-12',250.00,'JB1602120003');


INSERT INTO `jcheque` VALUES ('356565','2016-02-15','BOC','JP1602120002'),('4368','2016-02-15','dfasdg','JP1602120002');--

  


