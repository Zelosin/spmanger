create table account_groups (
    `id` int not null auto_increment,
    `account_id` int,
    `access_token` varchar(100) not null,
    `group_id` varchar(30) not null,
    foreign key (`account_id`) references linked_vk_accounts (`id`),
    primary key (`id`),
);