BEGIN;


INSERT INTO breweries (name, address, city, zipcode, phone_number, description, brewery_logo_url, website_url, hours, lat, lng)
VALUES ('Great Lakes Brewery', '2516 Market Ave.', 'Cleveland', 44113, '(216) 771-4404',
'Iconic microbrewery with house suds, an updated American menu, free tours & a patio.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511722746/gret_lakes_brewery_logo_black_uw5ech.jpg',
'https://www.greatlakesbrewing.com',
'Monday - Thursday: 10:00 AM - 10:00 PM Friday and Saturday: 10:00 AM - 11:00 PM Closed on Sundays', 41.484312, -81.704461);

INSERT INTO breweries (name, address, city, zipcode, phone_number, description, brewery_logo_url, website_url, hours, lat, lng)
VALUES ('Platform Beer Co.', '4125 Lorain Ave.', 'Cleveland', 44113,'(216) 202-1386',
'Opened in 2014, 100+ seat tasting room and patio offers 20+ house beers and food options. 10BBL brewhouse creates constantly changing selection of styles. Head R&D brewer Danny Monnot leads the way at our flagship location.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511302719/brewery_images/pnozkgiqhblcydhtllru.jpg',
'https://platformbeer.co/',
'Monday - Thursday: 03:00 PM - 12:00 AM Friday: 03:00 AM - 02:00 AM Saturday: 10:00 PM - 02:00 AM Sunday: 10:00 PM - 10:00 PM', 41.4795909, -81.7138139);

INSERT INTO breweries (name, address, city, zipcode, phone_number, description, brewery_logo_url, website_url, hours, lat, lng)
VALUES ('Goldhorn Brewery', '1361 E 55th St.', 'Cleveland', 44103,'(216) 465-1352',
'Cool taproom offering seasonal, housemade beer in a vast space with a long bar & tables outside.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511722787/goldhorn_brown_logo_er48xf.png',
'https://www.yelp.com/biz/goldhorn-brewery-cleveland',
'Tuesday - Friday: 11:00 AM - 09:00 PM  Saturday: 12:00 PM - 10:00 PM Sunday: 12:00 PM - 06:00 PM Closed on Mondays', 41.521425, -81.651681);
INSERT INTO breweries (name, address, city, zipcode, phone_number, description, brewery_logo_url, website_url, hours, lat, lng)
VALUES ('Masthead Brewing Co.', '1261 Superior Ave.', 'Cleveland', 44144,'(216) 206-6176',
'Located in a historic building with 300 seats, a 100’ long bar, and an additional 50 seat dog friendly patio with a view of downtown Cleveland. Masthead includes a full bar and kitchen focusing on American and Belgian style beers, Neapolitan wood-fired pizza, and a barrel aged beer program',
'http://res.cloudinary.com/teclebrew/image/upload/v1511363501/brewery_images/oorzznvts0irqao76zqb.jpg',
'http://mastheadbrewingco.com/',
'Tuesday - Friday: 11:00 AM - 10:00 PM  Saturday: 11:00 PM - 01:00 AM Sunday: 11:00 PM - 05:00 PM Closed on Mondays', 41.504100, -81.685403);

INSERT INTO beers (name, abv, type, info, img_url, is_active, brewery_id) VALUES 
('Original Lager', 5.2, 'German Lager',
'A traditional full flavored German Lager with a crisp finish. The bier Hofbrauhaus has been famous for since 1589.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511649200/hofbrau_lager_puc_h8or43.jpg', true, 1);
INSERT INTO beers (name, abv, type, info, img_url, is_active, brewery_id) VALUES 
('Hefeweizen', 5.4, 'Hefeweizen',
'A specialty born in Munich – loved by the world. A fairly sweet old-style Wheat bier brewed to create a wonderful combination banana and clove flavor and aroma.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511649351/hofbrau_heffwiz_pic_uz7nlz.jpg', true, 1);
INSERT INTO beers (name, abv, type, info, img_url, is_active, brewery_id) VALUES 
('Dunkel', 5.5, 'Dunkel',
'For centuries Munich’s favorite bier. Dunkel translates to “Dark�? lager. It is medium bodied, easy to drink, with simple roasted malt flavor and slight caramel undertones.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511649546/Hofbrauhaus_dunkel_pic_w5bxhw.jpg', true, 1);
INSERT INTO beers (name, abv, type, info, img_url, is_active, brewery_id) VALUES 
('CITRAMAX IPA', 6.7, 'IPA',
'A West Coast style IPA dry-hopped with organic Citra hops to impart intense tropical and citrus fruit aromas. This brew has an aggressive, boldly-bright American hop character that will leave you craving another.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511650026/market_citramax_beer_pic_mh7psh.png', true, 1);
INSERT INTO beers (name, abv, type, info, img_url, is_active, brewery_id) VALUES 
('PROSPERITY WHEAT', 6.0, 'Wheat',
'Formerly known as ***** Street Wheat! If you’ve ever spent time in a German Beer Garden, you know how much they love their wheat beer.  Our Bavarian style Hefeweizen is a satisfying blend of sweet wheat and pale malts, clove and banana aromatics, and the zesty tang of wheat beer yeast.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511650039/market_prosperity_ber_pic_efdril.png', true, 1);
INSERT INTO beers (name, abv, type, info, img_url, is_active, brewery_id) VALUES 
('PROGRESS PILSNER', 5.5, 'Pilsner',
'Great American Beer Festival Award Winning Brew! Inspired by the Pilsners of the Rhine region, this lager is a tribute to the spicy, crisp and clean character of German noble hops and has just the right malt body to balance. Named aptly for the Cleveland slogan “Progress&Prosperity�?.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511650338/market_progress_beer_pic_oe4yta.png', true, 1);
INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) VALUES 
('Eliot Ness', 6.1, 27, 'Amber Lager',
'Almost untouchably smooth--armed with lightly toasted malts and noble hops.',
'http://res.cloudinary.com/teclebrew/image/upload/v1511645068/eliotness_beer_yx7iv4.png', true, 1);
INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) VALUES 
('Burning river', 6.0, 35, 'Pale Ale',
'Crisp and bright, with refreshing flickers of citrus and pine that ignite the senses (not our local waterways).',
'http://res.cloudinary.com/teclebrew/image/upload/v1511645196/burningriver_beer_v1vzlz.png', true, 1);

INSERT INTO reviews (name, description, rating, create_date) VALUES
('Greatest Beer Ever',
'This is the best Xmas beer in the world!',
5,now());
INSERT INTO reviews (name, description, rating, create_date) VALUES
('Ho Ho Drunk',
'I had 6 of these already and Im wasted, Merry Christmas to all!!!!!',
4,now());
INSERT INTO reviews (name, description, rating, create_date) VALUES
('Twas the night before Xmas',
'Or maybe it was the night after, I blacked out both so Im not sure',
5,now());
INSERT INTO reviews (name, description, rating, create_date) VALUES
('Still better than Al Capone',
'Im not sure which is cooler the man or the beer! ',
5,now());


INSERT INTO reviews (name, description, rating, create_date)
VALUES ('Christmas magic in a a bottle',
'Just okay',
5,now());




COMMIT;


--- bookhouse brewery
INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Get Yer Oats', 6.5, 30,
'Oatmeal Stout', 'Get yer oats! Our rich, soft oatmeal stout comes across as almost too much, 
too sweet and satisfying, so we dialed it back with a hit of Ceylon cinnamon and piles of toasted
 nuts: black walnuts, pecans, and hazelnuts. Paired together, the whole thing is balanced and soft
 , with gentle wisps of nutty oatmeal, browned toast, and squishy caramel. Settle in for a spell 
 and plunge these roasty black depths.', 'https://bookhouse-brewing-llc.square.site/uploads/1/2/6/2/126287558/s706640680989578270_p357_i1_w1218.jpeg', true, 1);
 
INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Black is Beautiful', 9, 60,
'Oatmeal Stout', 'Our version of Black is Beautiful hews closely to the source material, figuring that 
the time at hand is that of listening. BIPOC-owned breweries are less than 1% of the overall US brewery 
scene, so who are we to dominate the stage when so many others have so much to say? Brewed with 7 types
 of malt for a massive, sticky, high-alcohol imperial stout, deep black in color. Flavor/aroma of burnt
 sugar, dark roast coffee, figs, and a touch of warming alcohol. Proceeds go to Cleveland NAACP to help
 in their efforts towards building a better world.', 
 'https://bookhouse-brewing-llc.square.site/uploads/1/2/6/2/126287558/s706640680989578270_p294_i1_w1650.jpeg',
  true, 1);
  
INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Whoops! Down Under', 9.0, 30,
'NE IPA', 'Cruise down the flavor highway with these bright and bold hops from the Southern Hemisphere.
 Bright orange juice with passionfruit and guava hints in the aroma are followed by rich malt and a soft,
 juicy hop finish. Triple NEIPA-style beer made with Australian Galaxy, New Zealand Nelson Sauvin, and El
 Dorado hops', 'https://bookhouse-brewing-llc.square.site/uploads/1/2/6/2/126287558/s706640680989578270_p367_i1_w1080.jpeg'
 , false, 1);
   
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Fortitude', 6.8, 20,
'Imperial Witbier', 'Our winter seasonal beer, this double/Imperial witbier is designed with the cold months in mind.
 We started with a strong interpretation of the classic Belgian country beer, then smoothed off the edges with a 
 silky-soft body, with just enough residual sweetness to keep the magic hidden. Intense orange peel aromatics, 
 pillowy puffs of wheat and oats, and a refreshing subtle herbal spice in the finish. Build up your Fortitude and
  watch the days fly by.', 
  'https://bookhouse-brewing-llc.square.site/uploads/1/2/6/2/126287558/s706640680989578270_p367_i1_w1080.jpeg'
 , false, 1);
 
 -- Boss Dog Brewing
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Dog Pound Brown', 5.8, 32,
'Brown Ale', 'Nutty biscuit and mild chocolate', 
  'noimg.jpg'
 , true, 1);
 
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Jobu', 6.0, 30,
'Spiced Hazy Juicy IPA', 'Tropical IPA infused with spicy Cerrano peppers', 
  'noimg.jpg'
 , true, 1);
  
  INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Holy Toledo Pilsner', 5.4, 33,
'German Pilsner', 'German style, noble hopped Pilsener. Clean & refreshing', 
  'noimg.jpg'
 , true, 1);
 
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Put-N-Berry', 5.5, 20,
'Fruit Beer', 'Crisp Honey Ale. Touch of cracker with fresh Raspberry tartness', 
  'noimg.jpg'
 , true, 1);
 
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Millennial Hipster', 6.0, 35,
'Hazy Juicy IPA', 'Big juicy sweetness and tropical citrus. This Hazy IPA is tighter
than your skinny jeans and hotter than a wool hat in the summer', 
  'noimg.jpg'
 , true, 1);
 
 -- Brick and Barrel Brewing
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Bitter Chief IPA', 6.9, null,
'IPA', 'For our bitter Tribe fans, we almost got that series win. In the meantime, 
drink some local craft beer and enjoy. Light cooper color. Nice bitterness with 
refreshing citrus and grassy flavors and aromas. Malty finish balancing out the bitterness', 
  'noimg.jpg'
 , true, 1);
 
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Big Chief Imperial IPA', 8.7, null,
'Imperial IPA', 'Big hoppy Imperial IPA. Malt backbone with a robust hop aroma and flavor 
from kettle and fermenter dry-hopping.', 
  'noimg.jpg'
 , true, 1);
  
 INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Rally Possum', 7.4, null,
'Imperial Brown Ale', 'Hoppy imperial brown ale with nice citrus, chocolate hazelnut roast
 aromas and flavors. Just in time for a fantastic Browns season.', 
  'noimg.jpg'
 , true, 1);
 
  INSERT INTO beers (name, abv, ibu, type, info, img_url, is_active, brewery_id) 
VALUES ('Pinot Saison', 6.3, null,
'Farmhouse Saison', 'Classic farmhouse saison ale, phenolic pepper and tropical fruit
 form the Saison yeast strain. Pinot Noir wine must co fermented to give aromas and
 flavors of raspberry, strawberry and red grapes giving a red wine aroma.', 
  'noimg.jpg'
 , true, 1);