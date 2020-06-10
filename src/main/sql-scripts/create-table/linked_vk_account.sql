create table linked_vk_accounts (
    `id` int not null auto_increment,
    `spuser_id` int,
    `access_token` varchar(100) not null,
    `user_id` varchar(30) not null,
    foreign key (`spuser_id`) references spusers (`id`),
    primary key (`id`)
);