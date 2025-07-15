# Event-Management-System--using-JPA

# 📅 Java Event Management System (Console-Based)

A *menu-driven console-based Java application* built with Maven, JDBC, JPA (Hibernate 7.0.5), and PostgreSQL. Users can create events, register participants, and assign participants to events

---

## Team Members
1.Riddhi Bhojane

2.Snehal bandgar

3.Shruti Nikam

---

## 💡 Features

- Menu-driven command-line interface
- Create and view events
- Register users (participants)
- Assign users to events (many-to-many relationship)
- View all participants
- View events with assigned users
- Uses JPA & Hibernate (7.0.5) with PostgreSQL
- Follows Object-Oriented Programming principles

---


## 🛠 Technologies Used

- Java 17+
- Maven
- JPA & Hibernate 7.0.5
- PostgreSQL 15+
- Eclipse IDE
- JDBC (for initial DB connection if needed)

---

  ## 📂 Project Structure

src/

├── main/ 

│   ├── java/

│   │   └── com/ 

│   │       └── event/

│   │           ├── EventApp.java        # Main menu class

│   │           ├── Event.java           # Entity class 

│   │           ├── User.java            # Entity class

│   │           └── EventService.java    # Logic class

│   └── resources/

│       └── META-INF/

│           └── persistence.xml          # JPA configuration

---

## Prerequisites

Java 17 or higher
PostgreSQL 15+
pgAdmin (for database management)
Maven
Eclipse / IntelliJ / VS Code IDE

---

## Database Setup
create the neccessary tables in postgreSQL:
CREATE DATABASE eventdb;

\c eventdb

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    date VARCHAR(20),
    location VARCHAR(100)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE registrations (
    id SERIAL PRIMARY KEY,
    event_id INT REFERENCES events(id),
    user_id INT REFERENCES users(id),
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

---

## Output Image
<img width="319" height="163" alt="Screenshot (1)" src="https://github.com/user-attachments/assets/4565f146-3b41-4b09-a7b1-eae4bfa0f61d" />

---

## Contact Details
Name: Riddhi Bhojane

Emails: bhojaneriddhi16@gmail.com
