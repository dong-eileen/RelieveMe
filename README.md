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

