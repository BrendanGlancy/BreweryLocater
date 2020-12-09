--
-- This SQL will create the tables needed for the Final Capstone 
-- Authentication and logon starter code
-- 
-- It will also create two users with passwords:  username: user 
--                                                password: password
--
--                                                username: admin 
--                                                password: password
--                                               
--
--	Be sure you have created a database called: 'final_capstone'
--
-- To create a database:  1. Open a WINDOWS command prompt (NOT GitBash)
--                        2. Enter the command: createdb -U postgres final_capstone
--                        3. Enter the password: postgres1
--
BEGIN TRANSACTION;

DROP TABLE IF EXISTS users cascade;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;


