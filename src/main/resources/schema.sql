/* regions where buildings are located */
DROP TABLE IF EXISTS regions;
CREATE TABLE regions (
  region_id SERIAL PRIMARY KEY,
  name VARCHAR(256) NOT NULL
);

/* all buildings on campus along with its corresponding region */
DROP TABLE IF EXISTS building;
CREATE TABLE building (
  building_id INTEGER NOT NULL,
  proper_name VARCHAR(256) NOT NULL,
  region_id INTEGER NOT NULL,
  PRIMARY KEY (building_id)
);

/* all names for a building; the corresponding building is specified by building_id */
DROP TABLE IF EXISTS building_name;
CREATE TABLE building_name (
  name VARCHAR(256) NOT NULL,
  building_id INTEGER NOT NULL,
  PRIMARY KEY (name, building_id)
);

/* building floors; the corresponding building is specified by building_id */
DROP TABLE IF EXISTS floor;
CREATE TABLE floor (
  number INTEGER NOT NULL,
  building_id INTEGER NOT NULL,
  PRIMARY KEY (number, building_id)
);

/* floor plans for a building; the corresponding floor is specified by building_id and floor_number */
DROP TABLE IF EXISTS floor_plan;
CREATE TABLE floor_plan (
  link VARCHAR(256),
  building_id INTEGER NOT NULL,
  floor_number INTEGER NOT NULL,
  PRIMARY KEY (building_id, floor_number)
);

/* bathrooms for a building with its corresponding floor */
DROP TABLE IF EXISTS bathroom;
CREATE TABLE bathroom (
  bathroom_id SERIAL PRIMARY KEY,
  building_id INTEGER NOT NULL,
  floor_number INTEGER NOT NULL,
  gender_type INTEGER NOT NULL,
  wheelchair_accessible BOOLEAN NOT NULL,
  location_string VARCHAR(256) NOT NULL,
  shelves BOOLEAN NOT NULL,
  hooks BOOLEAN NOT NULL DEFAULT false,
  menstrual_disposal BOOLEAN NOT NULL,
  menstrual_product_type INTEGER,
  num_negative_rating INTEGER NOT NULL DEFAULT 0,
  num_positive_rating INTEGER NOT NULL DEFAULT 0,
  maintenance_issue_num INTEGER NOT NULL DEFAULT 0,
  baby_changing_station BOOLEAN NOT NULL,
  fragrance_free_soap BOOLEAN,
  single_stall BOOLEAN,
  ongoing_bathroom_issue BOOLEAN NOT NULL
);