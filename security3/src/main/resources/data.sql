-- insert into users values ("admin","$2a$10$x80RwfonoAgew5/HfX6AfeR8hqKFpCa.jWakiTS4w7AWszubUmrK6",1),("user","$2a$10$x80RwfonoAgew5/HfX6AfeR8hqKFpCa.jWakiTS4w7AWszubUmrK6",1);
--
-- insert into authorities values ("admin","ROLE_ADMIN"),("user","ROLE_USER");

insert into role (name,description,rid) values ("ROLE_ADMIN","管理员",1),("ROLE_USER","普通用户",2);

insert into user_info (username,password,uid) values ("admin","$2a$10$XvoGOCm4E0iRRMKNJeGvxeRjMWOoUfJVX679doV05HI128N1lUqjS",1),("user","$2a$10$XvoGOCm4E0iRRMKNJeGvxeRjMWOoUfJVX679doV05HI128N1lUqjS",2);

insert into user_role (uid, role_id) values (1,1),(1,2),(2,2);

insert into permission (pid,url) values (1,"/user"),(2,"/admin"),(3,"/a"),(4,"/b");

insert into role_permission (pid,rid) values (1,1),(1,2),(2,1),(3,1),(4,1);


