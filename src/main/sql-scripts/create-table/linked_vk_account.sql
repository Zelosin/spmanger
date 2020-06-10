create table linked_vk_accounts (
    `spuserd_id` int,
    `access_token` varchar(100) not null,
    `user_id` varchar(30) not null,
    foreign key (`spuserd_id`) references spusers (`id`)
);