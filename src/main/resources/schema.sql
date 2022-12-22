
create table IF NOT EXISTS credit_details(
    transaction_id varchar(50) primary key,
    customer_name varchar(200) not null,
    invoice varchar(50) not null,
    credit_date date not null,
    credit_ammount int not null
);


create table IF NOT EXISTS customer_details(
    invoice varchar(50) primary key,
    customer_name varchar(200) not null,
    sellDate date not null,
    ammount int not null,
    left_ammount int not null
);