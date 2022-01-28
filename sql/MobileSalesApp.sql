--------------------Mobile shop----------------------

--insert into description,;

select *from products;
commit;
SELECT *FROM SALESMAN;
select *from users_table;
select *from orders_table;
select * from contactus;
insert into orders_table (fk_user_id,fk_product_id,price,address)values(1,21,987,'aji');
--select *from order_item;
--drop table p cascade constraints;
DROP TABLE USER_TABLE CASCADE CONSTRAINTS;
--drop table users_table;

alter table users_table add address varchar2(80) null;
create table photo (url varchar2(2000));
insert into photo values ('https://rukminim1.flixcart.com/image/312/312/k9loccw0/mobile/p/z/q/apple-iphone-se-mxd02hn-a-original-imafrcpjfehbbqgb.jpeg?q=70',11);
select *from carts_table;
alter table carts_table modify description varchar2(1000);
commit;

select *from photo;
alter table photo add  id number;
select * from photo where id=11;
commit;





---------------USERS_TABLE--------------
drop table users_table;
create  table users_table 
(pk_user_id number generated always as identity (start with 1 increment by 1)primary key
,first_name varchar2(40) not null
 ,email varchar2(50)not null
 ,phone_number number(10)not null,
 password varchar2(50) not null
 ,confirm_password varchar2(50)not null);
 


SELECT *FROM USERS_TABLE;

-------------------Admins_table--------------

create table admins_table
(admin_id number generated always as identity(start with 1 increment by 1 )primary key,
admin_name  varchar2(50) not null,password varchar2(50) not null);
alter table admins_table add email varchar2(50) unique not null;

insert into admins_table (admin_name,password,email)values('Ajithkumar','pass123','ajith123@gmail.com');
select *from admins_table;

--------------SALESMAN_TABLE-----------------

CREATE TABLE SALESMANS_TABLE
(SALESMAN_ID NUMBER generated always as identity(start with 1 increment by 1) PRIMARY KEY,
NAME VARCHAR2(30) not null,PHONE_NUMBER NUMBER(10) unique not null,JOB_TITLE VARCHAR2(50)not null,
admin_id number ,foreign key(admin_id)references admins_table(admin_id)) ;
select *from salesmans_table;
--drop table salesmans_table;
alter table salesmans_table  rename column admin_id to fk_admin_id;




-----------products_table--------------
desc products;
create table products 
(pk_product_id number generated always as identity(start with 1 increment by 1) primary key ,
product_name varchar2(50),description varchar2(80),standard_price number(12,2),
list_price number(12,2)); 

select *from products;
alter table products add admin_id number ;
alter table products modify foreign key(admin_id) references admins_table(admin_id);

alter table products rename column admin_id to fk_admin_id;
--------------ORDER_TABLE-------------
CREATE TABLE ORDERS_TABLE
(ORDER_ID NUMBER generated always as identity start with 1  PRIMARY KEY
,fk_user_id NUMBER ,FOREIGN KEY(fk_USER_ID) REFERENCES USERS_TABLE(pk_user_ID)
,fk_product_id NUMBER,FOREIGN KEY(fk_product_id) REFERENCES products(pk_product_id)
,STATUS VARCHAR2(30) default 'Placed'
,price number(12,2)
,ORDER_DATE timestamp default current_timestamp);
alter table orders_table add address varchar(80); 

select * from orders_table;


 


select trunc(order_date) from orders_table;

select order_id,status,price,trunc(order_date) as orders_date,address from orders_table where fk_user_id=13;
SELECT *FROM ORDER_TABLE;
select *from users_table;
update users_table set password='Surya123@' where pk_user_id=8;
--update users_tables set wallet=(select wallet from users_table where pk_user_id=?)-?"where password=?
/*constraint pk_transid_sal primary key(trans_id),
constraint fk_transid_sal foreign key (trans_id) references emp_grades (trans_id),
constraint fk_empid_sal foreign key (emp_id) references employees (emp_id),
constraint fk_deptid_sal foreign key (emp_dept_id) references departments (dept_id),
constraint fk_emp_gradeid_sal foreign key (emp_grade_id) references grades (grade_id));
commit;*/
-------------------------Carts_table-----------
create table carts_table 
(cart_id number generated always as identity (start with 1) 
,user_id number
,pruduct_id number
,product_name varchar(40)
,description varchar(60)
,price number(12,2) 
);
alter table carts_table  rename column pruduct_id to product_id; 
select * from carts_table;

alter table carts_table add constraint pk_cart_id primary key (cart_id);
alter table carts_table add constraint fk_user_id foreign key(user_id) references users_table(pk_user_id);
alter table carts_table add constraint fk_product_id foreign key(product_id) references products(pk_product_id);




---------------------------------------------------
select *from users_table;


alter table users_table drop column address;
---------------------------------------------

-----------------------------------------
select *from users_table;
desc users_table;
select *from products;
--update products set standard_price=14000,list_price=16000 where pk_product_id=21;
desc products;
select *from admins_table;
select *from carts_table;
insert ()
commit;
--select first_name,email,phone_number from users_table;
desc users_table;

commit;
update products set product_name='POCO C31 (Shadow Gray, 64 GB)' ,standard_price=11000,list_price=13000 where pk_product_id=42;
--update  admins_table set password='Pass1234@' where password='Pass1234';
select *from salesmans_table;
insert into admins_table (admin_name,password,email) values ('Mani','mani12','mani@123gmail.com');
ALTER TABLE products
DROP COLUMN fk_admin_id;
commit;

alter table users_table add wallet number(12,2) default '100000' ; 
update users_table set wallet=(select wallet from users_table where pk_user_id=13)-100 where password='Ajith123@';

desc carts_table;
insert into carts_table(user_id,product_id,product_name,description,price) values(2,22,'oppo','mobile phone',29000);
----------------------------------
alter table products add url varchar2(3000);
select *from admins_table;
select *from carts_table;
commit;

select *from users_table;
desc users_table;
select *from products;
update products set page_link='MobileInfoRedmi9active.jsp' where pk_product_id=48;
alter table products add page_link varchar(200);
select *from orders_table;
delete from orders_table where fk_product_id=21;
delete from carts_table where product_id=22;
commit;
update users_table set wallet=90000 where pk_user_id=13;
select wallet from users_table where pk_user_id=13;
insert into products description,url values ('');
/
update products set description='APPLE iPhone SE (Black, 128 GB)
4.51,35,254 Ratings & 10,960 Reviews
128 GB ROM
11.94 cm (4.7 inch) Retina HD Display
12MP Rear Camera | 7MP Front Camera
A13 Bionic Chip with 3rd Gen Neural Engine Processor
Water and Dust Resistant (1 meter for Upto 30 minutes, IP67)
Fast Charge Capable
Wireless charging (Works with Qi Chargers | Qi Chargers are Sold Separately' ,url='https://rukminim1.flixcart.com/image/312/312/k9loccw0/mobile/p/z/q/apple-iphone-se-mxd02hn-a-original-imafrcpjfehbbqgb.jpeg?q=70'  where pk_product_id=41;
alter table products modify description varchar2(2000);
--------------------------
select * from products;
commit;



-----------------------------------------------------------------------------------------------

-----------------contactUs table-----------
create table contactus(name varchar2(30),email varchar2(30),phone_number number,descriptions varchar2(100));
commit;

select * from contactus;
select * from user_details;




