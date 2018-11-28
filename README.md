# RelieveMe

A project for SD&D Fall 2018. Project members: Katie Burkhardt, Michelle Hu, Eileen Dong, Rachel Rabideau

## Project Description

An interactive map of bathrooms on RPI's campus. Tentative attributes:

- Gender (Men's, Women's, Gender Neutral)
- Accessibility
- Menstrual products available (pads, tampons, free or coin dispenser)
- Menstrual product disposal
- Baby changing stations
- Fragrance-free soaps

## Coding Standards

Frontend: Follow the [Vue.js style guide](https://vuejs.org/v2/style-guide/).
TODO: add link to backend coding standards

## Running the Application

### Full Build (frontend and backend, "production" build)

Cd into `frontend` and run `npm run build` to build the frontend.
Cd back into the main directory (where you cloned this repository).
Run `mvn clean install` if this is the first time running the app or dependencies have changed.
Run `java -jar target/relieveme-0.0.1-SNAPSHOT.jar`.
Open your browser to http://localhost:8080.

### Frontend Development Build

This build updates every time you change the frontend.

Cd into `frontend` from terminal.
Run `npm run dev`.
Open your browser to http://localhost:8081 (assuming you are already running the backend server).

## Configuring the PostgreSQL Database

1. Install [PostgreSQL](https://www.postgresql.org/download/) or start the PostgreSQL server.
2. Enter PostgreSQL (or use a PostgreSQL GUI) as user `postgres`.
   - `psql -U postgres`
3. Assure that PostgreSQL is running on port `5432` (should be default port in installation).
   - `\conninfo` inside PostgreSQL
4. Create superuser `admin` with password `admin`.
   - `CREATE USER admin PASSWORD 'admin' LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;`
5. Create database `RelieveMe`.

   - `CREATE DATABASE "RelieveMe" WITH OWNER postgres ENCODING 'UTF8' LC_COLLATE 'English_United States.1252' LC_CTYPE 'English_United States.1252' TABLESPACE pg_default CONNECTION_LIMIT -1;`

   On Linux, replace `'English_United States.1252'` with `'en_US.UTF-8'`.

6. Run our application.
   - Test the database connection by going to:
     http://localhost:8080/api/buildings
     - Should see various buildings in JSON

### Editing Dummy Data

`src/main/java/resources/sqldata/*.sql` and `src/main/java/resources/schema.sql` contain SQL queries that are run by Spring
on boot and populate the database.

## Production Environment

A live demo of this product is in progress. Our Docker repository can be found at https://hub.docker.com/r/kburk1997/relieveme.
