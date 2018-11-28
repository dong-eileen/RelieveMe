/*---------------*/
/* BATHROOM DATA */
/*---------------*/
/* gender_type: male = 0, female = 1, gender-neutral = 2 */
/* menstrual product type: tampon = 0, pad = 1 */

/*-----------*/
/* RPI Union */
/*-----------*/
/* 2 true and 3 false for ongoing_bathroom_issue */
/* added in random numbers for num_negative_rating and num_positive_rating */

/* Floor 1 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (6, 1, 0, true, 'Next to Rathskeller and Game Room', false, false, null, false, false, 1, 2);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (6, 1, 1, true, 'Next to Ben and Jerry''s and Rathskeller''s', true, true, 1, false, true, 3, 4);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (6, 1, 2, false, 'In Mother''s', false, false, null, false, false, 3, 42);
/* Floor 2 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (6, 2, 0, false, 'Next to McNeil room and in corner facing Public Safety', false, false, null, false, true, 100, 99);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (6, 2, 1, false, 'Next to McNeil room and in corner facing Public Safety', true, true, 0, true, false, 12, 34);
/* Floor 3 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (6, 3, 0, false, 'Next to Clubhouse Pub', false, false, null, false, true, 100, 99);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, hooks, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (6, 3, 1, false, 'Next to Clubhouse Pub', true, true, true, 1, false, false, 12, 34);


/*----------------------*/
/* Amos Eaton bathrooms */
/*----------------------*/
/* Floor 1 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (9, 1, 0, false, 'Down right-hand stairway and next to AE123', false, false, null, false, false);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (9, 1, 2, true, 'Down right-hand stairway and next to AE123', false, false, null, false, false);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (9, 1, 1, false, 'Next to AE103', true, true, null, false, false);
/* Floor 2 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (9, 2, 0, false, 'Next to AE204', false, false, null, false, false);
/* Floor 3 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (9, 3, 1, false, 'Next to housekeeping', true, true, null, false, false);
/* Floor 4 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (9, 4, 0, false, 'In dead end corridor to right of lounge', false, false, null, false, false);

/*-----------------*/
/* JRowl bathrooms */
/*-----------------*/
/* Roof and penthouse omitted because students cannot go there */
/* Floor 0 (Basement) */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (17, 0, 0, true, 'across from elevator next to  custodial closet', false, false, null, false, false);
/* Floor 1 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (17, 1, 1, true, 'Room 1C43, near Physics Lounge', false, true, null, false, false);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (17, 1, 0, true, 'Room 1C47, next to custodial closet', false, false, null, false, false);
/* Floor 2 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (17, 2, 0, true, 'Room 2C47, next to custodial closet', false, false, null, false, false);
/* Floor 3 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (17, 3, 1, true, 'Room 3C43, across from electrical room', false, true, null, false, false);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (17, 3, 0, true, 'Room 3C47, next to custodial closet', false, false, null, false, false);

/*-----------------*/
/* Lally bathrooms */
/*-----------------*/
/* Floor 0 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (18, 0, 0, false, 'Left from stairs, next to environmental specialist door', false, false, null, false, false);

/* Floor 2 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (18, 2, 1, false, 'In corridor next to Lally 210 and environmentalist specialist door', false, true, null, false, false);

/*---------*/
/* VCC  	 */
/*---------*/
/* default 0 for num_positive_rating and num_negative_rating  */
/* made some assumptions for men's bathroom data */

/* Floor 1 (basement level)*/
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (26, 1, 2, false, 'basement Room 111A', false, false, null, false, false, 0, 0);

/* Floor 2  (main level) */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (26, 2, 1, true, 'Across from help desk (Rm. 203)', true, true, null, false, false, 0, 0);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (26, 2, 0, true, 'Across from help desk (Rm. 204)', true, false, null, false, false, 0, 0);

/* Floor 3 (upper level) */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (26, 3, 1, true, 'Next to elevator (Rm. 302)', true, true, null, false, false, 0, 0);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (26, 3, 0, true, 'Next to front staircase (Rm. 324)', true, false, null, false, false, 0, 0);

/*-------==--*/
/* Sage Labs */
/*------==---*/
/* Floor 2 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (24, 2, 0, true, 'Next to vending machine, door on LEFT', true, false, null, false, false, 0, 0);
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (24, 2, 1,
        true,
        'Next to vending machine, door on RIGHT',
        true,
        true,
        null,
        false,
        false,
        0,
        0
           );

/* Floor 3 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (24, 3, 0, false, 'Next to 3510', false, false, null, false, false, 0, 0);

/* Floor 4 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (24, 4, 1, false, 'Across from 4410', true, true, null, false, false, 0, 0);
/* Floor 5 */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue, num_negative_rating, num_positive_rating)
VALUES
       (24, 5, 0, false, 'Next to 5510', false, false, null, false, false, 0, 0);


/*--------------------*/
/* BELOW IS MOCK DATA */
/*--------------------*/
/* Houston Field House */
/* 1 true */
/* default 0 for num_negative_rating and num_positive_rating */
INSERT INTO bathroom
    (building_id, floor_number, gender_type, wheelchair_accessible, location_string, shelves, menstrual_disposal, menstrual_product_type, baby_changing_station, ongoing_bathroom_issue)
VALUES
       (1, 3, 1, true, 'Mock wheelchair accessible only bathroom', false, false, null, false, true);