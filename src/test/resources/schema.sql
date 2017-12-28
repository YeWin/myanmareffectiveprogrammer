drop table if exists category CASCADE ;
drop table if exists administrator CASCADE ;
drop table if exists post CASCADE ;
drop table if exists archive CASCADE ;

create table category (
category_id serial PRIMARY KEY,
category_name varchar(30),
created_date timestamp without time zone,
updated_date timestamp without time zone
);

create table administrator (
admin_id serial PRIMARY KEY,
admin_name varchar(30),
admin_email varchar(50),
admin_password varchar(30),
created_date timestamp without time zone,
updated_date timestamp without time zone
);

create table post (
post_id serial PRIMARY KEY,
admin_id integer,
category_id integer,
post_title_eng varchar(150),
post_title_mmr varchar(150),
post_title_img_url varchar(150),
post_content text,
created_date timestamp without time zone,
updated_date timestamp without time zone
);

create table archive (
archive_id serial PRIMARY KEY,
post_id integer	,
year varchar(15),
month varchar(15),
created_date timestamp without time zone,
updated_date timestamp without time zone
);

ALTER TABLE ONLY archive
    ADD CONSTRAINT "post_idFK" FOREIGN KEY (post_id) REFERENCES post(post_id);

ALTER TABLE ONLY post
    ADD CONSTRAINT "admin_idFK" FOREIGN KEY (admin_id) REFERENCES administrator(admin_id);

ALTER TABLE ONLY post
    ADD CONSTRAINT "category_idFK" FOREIGN KEY (category_id) REFERENCES category(category_id);

ALTER TABLE administrator ALTER COLUMN admin_password TYPE character varying(200);

ALTER TABLE administrator ADD COLUMN admin_image_url character varying(150);

ALTER TABLE administrator ADD COLUMN about_admin text;

ALTER TABLE post ADD COLUMN content_type integer; -- 1 tutorial, 0 articles

INSERT INTO category(
			category_name, created_date, updated_date)
    VALUES ('Category1', now(), now());
INSERT INTO category(
			category_name, created_date, updated_date)
    VALUES ('Category2', now(), now());
INSERT INTO category(
			category_name, created_date, updated_date)
    VALUES ('Category3', now(), now());

INSERT INTO administrator(
			admin_name, admin_email, admin_password, created_date, 
            updated_date, admin_image_url, about_admin)
    VALUES ('Admin1', 'admin1@gmail.com', 'admin1', now(), 
            now(), 'imageurl', 'admin1 author');
INSERT INTO administrator(
			admin_name, admin_email, admin_password, created_date, 
            updated_date, admin_image_url, about_admin)
    VALUES ('Admin2', 'admin2@gmail.com', 'admin1', now(), 
            now(), 'imageurl', 'admin1 author');
INSERT INTO administrator(
			admin_name, admin_email, admin_password, created_date, 
            updated_date, admin_image_url, about_admin)
    VALUES ('Admin3', 'admin3@gmail.com', 'admin1', now(), 
            now(), 'imageurl', 'admin1 author');
            
INSERT INTO post(
			admin_id, category_id, post_title_eng, post_title_mmr, 
            post_title_img_url, post_content, created_date, updated_date, content_type)
    VALUES (1, 1, 'What kind of developer are you?', 'What kind of developer are you1?', 
            'Imgurl', 'Post content 1', now(), now(), 0);
INSERT INTO post(
			admin_id, category_id, post_title_eng, post_title_mmr, 
            post_title_img_url, post_content, created_date, updated_date, content_type)
    VALUES (1, 1, 'What kind of developer are you?', 'What kind of developer are you2?', 
            'Imgurl', 'Post content 2', now(), now(), 0);
INSERT INTO post(
			admin_id, category_id, post_title_eng, post_title_mmr, 
            post_title_img_url, post_content, created_date, updated_date, content_type)
    VALUES (1, 1, 'What kind of developer are you?', 'What kind of developer are you3?', 
            'Imgurl', 'Post content 3', now(), now(), 1);

INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2016', '02', now(), now());
INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2016', '02', now(), now());
INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2016', '03', now(), now());
INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2016', '03', now(), now());
INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2015', '06', now(), now());
INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2015', '06', now(), now());
INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2015', '03', now(), now());
INSERT INTO archive(
			post_id, year, month, created_date, updated_date)
    VALUES (1, '2015', '03', now(), now());