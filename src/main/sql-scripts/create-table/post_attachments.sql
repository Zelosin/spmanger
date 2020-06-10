create table post_attachments (
      `id` int not null auto_increment,
      `assigned_post` int not null ,
      `material_type` varchar(10) not null,
      `material_source` varchar(100) not null,
      foreign key (`assigned_post`) references posts (`id`),
      primary key (`id`)
);