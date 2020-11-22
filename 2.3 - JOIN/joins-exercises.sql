-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT film.title AS "Films starring Nick Stallone"
FROM film
JOIN film_actor fa USING(film_id)
JOIN actor a USING(actor_id)
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE';

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT film.title AS "Films starring Rita Reynolds"
FROM film
JOIN film_actor fa USING(film_id)
JOIN actor a USING(actor_id)
WHERE a.first_name = 'RITA' AND a.last_name = 'REYNOLDS';

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT film.title AS "Films starring Judy Dean or River Dean"
FROM film
JOIN film_actor fa USING(film_id)
JOIN actor a USING(actor_id)
WHERE (a.first_name = 'JUDY' OR a.first_name = 'RIVER') AND a.last_name = 'DEAN';

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT film.title AS "Documentary films"
FROM film
JOIN film_category fc USING(film_id)
JOIN category c USING(category_id)
WHERE c.name = 'Documentary';

-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT film.title AS "Comedy films"
FROM film
JOIN film_category fc USING(film_id)
JOIN category c USING(category_id)
WHERE c.name = 'Comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT film.title AS "G-rated children's films"
FROM film
JOIN film_category fc USING(film_id)
JOIN category c USING(category_id)
WHERE c.name = 'Children' AND film.rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT film.title AS "G-rated family films shorter than 2 hours"
FROM film
JOIN film_category fc USING(film_id)
JOIN category c USING(category_id)
WHERE c.name = 'Family' AND film.rating = 'G' AND film.length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT film.title AS "G-rated films starring Matthew Leigh"
FROM film
JOIN film_actor fa USING(film_id)
JOIN actor a USING(actor_id)
WHERE a.first_name = 'MATTHEW' AND a.last_name = 'LEIGH' AND film.rating = 'G';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT film.title AS "Sci-Fi films released in 2006"
FROM film
JOIN film_category fc USING(film_id)
JOIN category c USING(category_id)
WHERE c.name = 'Sci-Fi' AND film.release_year = '2006';

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT film.title AS "Action films starring Nick Stallone"
FROM film
JOIN film_actor fa USING(film_id)
JOIN actor a USING(actor_id)
JOIN film_category fc USING(film_id)
JOIN category c USING(category_id)
WHERE a.first_name = 'NICK' AND a.last_name = 'STALLONE' AND c.name = 'Action';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT address.address, address.address2, city.city, address.district, country.country
FROM store
JOIN address USING(address_id)
JOIN city USING(city_id)
JOIN country USING(country_id);

-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT store.store_id, address.address, (staff.first_name || ' ' || staff.last_name) AS "Store Manager"
FROM store
JOIN address USING(address_id)
JOIN staff ON store.manager_staff_id = staff.staff_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
SELECT (customer.first_name || ' ' || customer.last_name) AS "Top ten customers by rentals", COUNT(rental_id) AS "Number of rentals"
FROM customer
JOIN rental USING(customer_id)
GROUP BY customer_id
ORDER BY "Number of rentals" DESC
LIMIT 10;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
SELECT (customer.first_name || ' ' || customer.last_name) AS "Top ten customers by dollars spent", SUM(payment.amount) AS "Dollars spent"
FROM customer
JOIN payment USING(customer_id)
GROUP BY customer_id
ORDER BY "Dollars spent" DESC
LIMIT 10;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT store.store_id, address.address, COUNT(rental.rental_id) AS "Total number of rentals", COUNT(payment.payment_id) AS "Total sales", AVG(payment.amount) AS "Average sale at store"
FROM store
JOIN address USING(address_id)
JOIN inventory USING(store_id)
JOIN rental USING(inventory_id)
JOIN payment USING(rental_id)
GROUP BY store.store_id, address.address;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT film.title AS "Top films by rentals", COUNT(rental_id) AS "Number of rentals"
FROM film
JOIN inventory USING(film_id)
JOIN rental USING(inventory_id)
GROUP BY film.title
ORDER BY "Number of rentals" DESC
LIMIT 10;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT category.name AS "Top film categories by rentals", COUNT(rental_id) AS "Number of rentals"
FROM category
JOIN film_category USING(category_id)
JOIN film USING(film_id)
JOIN inventory USING(film_id)
JOIN rental USING(inventory_id)
GROUP BY category.name
ORDER BY "Number of rentals" DESC
LIMIT 5;

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT film.title AS "Top action films by rentals", COUNT(rental_id) AS "Number of rentals"
FROM film
JOIN inventory USING(film_id)
JOIN rental USING(inventory_id)
JOIN film_category USING(film_id)
JOIN category USING (category_id)
WHERE category.name = 'Action'
GROUP BY film.title
ORDER BY "Number of rentals" DESC
LIMIT 5;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT (actor.first_name || ' ' || actor.last_name) AS "Top actors by film rentals", COUNT(rental.rental_id) AS "Number of rentals"
FROM actor
JOIN film_actor USING(actor_id)
JOIN film USING(film_id)
JOIN inventory USING(film_id)
JOIN rental USING(inventory_id)
GROUP BY "Top actors by film rentals", actor.actor_id
ORDER BY "Number of rentals" DESC
LIMIT 10;

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT (actor.first_name || ' ' || actor.last_name) AS "Top actors by comedy film rentals", COUNT(rental.rental_id) AS "Number of rentals"
FROM actor
JOIN film_actor USING(actor_id)
JOIN film USING(film_id)
JOIN inventory USING(film_id)
JOIN rental USING(inventory_id)
JOIN film_category USING(film_id)
JOIN category USING(category_id)
WHERE category.name = 'Comedy'
GROUP BY "Top actors by comedy film rentals", actor.actor_id
ORDER BY "Number of rentals" DESC
LIMIT 5;