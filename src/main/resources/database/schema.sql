create table ww_order (
    id int not null auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100),
    email varchar(250),
    phone varchar(15),
    order_details text,
    cookie_quantity smallint,
    status_code char(2) not null,
    status_details varchar(500),
    paid boolean not null,
    due_date datetime,
    last_updated_date datetime,
    created_date datetime not null,
    complete_date datetime,
    cancel_date datetime,

    primary key (id)
);

create table ww_order_logistics (
    id int auto_increment not null,
    order_id int not null,
    type_code char(1) not null,
    details varchar(1000),
    address varchar(250),
    address_2 varchar(250),
    city varchar(250),
    state char(2),
    zip varchar(15),
    delivery_date datetime,
    shipped_date datetime,

    primary key (id),
    foreign key (order_id) references ww_order (id)
);

create table ww_order_image (
    id int auto_increment not null,
    order_id int not null,
    file_path varchar(1000) not null,
    file_name varchar(200) not null,
    comments varchar(1000),

    primary key (id),
    foreign key (order_id) references ww_order (id)
);