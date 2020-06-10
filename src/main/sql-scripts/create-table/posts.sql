create table posts (
    `id` int not null auto_increment,
    `assigned_group_id` int,
    `post_date` varchar(50) not null,
    `plain_text` varchar(200) not null,
    `tags` varchar(100) not null,
    `source_link` varchar(100) not null,
    foreign key (`assigned_group_id`) references linked_vk_accounts (`id`),
    primary key (`id`)
);