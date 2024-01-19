create table hibernate_sequence
(
    next_val bigint null
);

create table studios
(
    studio_id   int          not null
        primary key,
    address     varchar(255) null,
    category    int          null,
    description varchar(255) null,
    studio_name varchar(255) null
);

create table courses
(
    course_id   int          not null
        primary key,
    capacity    int          not null,
    course_name varchar(255) null,
    studio_id   int          null,
    constraint FKclra5p5jap66qrrxuhr2qs5vh
        foreign key (studio_id) references studios (studio_id)
);

create table trainers
(
    trainer_id    int          not null
        primary key,
    mobile_number varchar(255) null,
    name          varchar(255) null
);

create table courses_trainers
(
    trainer_id int not null,
    course_id  int not null,
    constraint FKdl77ttnjt9k8r0k7mrextxg8q
        foreign key (course_id) references courses (course_id),
    constraint FKg78fy6uuh5sfn9bott1qxwt4p
        foreign key (trainer_id) references trainers (trainer_id)
);

