create table spusers (
     `id` int(11) auto_increment not null,
     `login` varchar(30) not null,
     `password` varchar(68) not null,
     primary key (`id`)
);