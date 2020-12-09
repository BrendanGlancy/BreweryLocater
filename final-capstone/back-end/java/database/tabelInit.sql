 BEGIN;

 DROP TABLE IF EXISTS reviews;
 DROP TABLE IF EXISTS beers;
 DROP TABLE IF EXISTS breweries;
 DROP TABLE IF EXISTS roles;
 DROP TABLE IF EXISTS brewery_beer;


CREATE TABLE breweries (
    brewery_id serial,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    city varchar(50) NOT NULL,
    zipcode varchar(15) NOT NULL,
    phone_number varchar(15),
    description text NOT NULL,
    brewery_logo_url varchar(255),
    website_url varchar(255),
    user_id bigint,
    hours  varchar(255),
    lat varchar(20),
    lng varchar(20),
    CONSTRAINT pk_breweries_brewery_id PRIMARY KEY (brewery_id),
    CONSTRAINT fk_users_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE beers (
    beer_id serial,
    name varchar(500) NOT NULL,
    abv decimal,
    ibu integer,
    type varchar(255) NOT NULL,
    info text NOT NULL,
    img_url varchar NOT NULL,
    is_active boolean,
    brewery_id integer,
    CONSTRAINT pk_beers_beer_id PRIMARY KEY (beer_id),
    CONSTRAINT fk_breweries_brewery_id FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);

CREATE TABLE brewery_beer (
    beer_id integer,
    brewery_id integer,
    CONSTRAINT pk_brewery_beer_brewery_id_beer_id PRIMARY KEY (beer_id, brewery_id)
);

CREATE TABLE reviews (
    reviews_id serial,
    name varchar(255) NOT NULL,
    description text NOT NULL,
    user_id integer,
    beer_id integer,
    rating int NOT NULL,
    create_date timestamp NOT NULL DEFAULT NOW(),
    CONSTRAINT pk_reviews_review_id PRIMARY KEY (reviews_id),
    CONSTRAINT fk_users_user_id FOREIGN KEY (user_id) REFERENCES users(user_id), 
    CONSTRAINT fk_beers_beer_id FOREIGN KEY (beer_id) REFERENCES beers(beer_id)
);

COMMIT;