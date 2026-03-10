# Smart AgriTech Management System 

## What This Project covered 

* Project Overview
* Technologies used
* System Features
* Entity Relationship Diagram
* Database Relationships
* Project Structure
* API Endpoints
* Setup & Installation
---

# Project Overview
Smart AgriTech Management System is a Spring Boot application designed to manage agricultural data including farmers, farms, crops, pesticides, and locations. The system demonstrates database relationships and functionalities such as One-to-One, One-to-Many, Many-to-Many relationships, pagination, sorting, and existence checking using Spring Data JPA.

# Technologies Used

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL 18.3
* Maven
* Postman for API testing

---

# System Features

The system demonstrates the following database functionalities:

### 1. Location Management

Stores geographical information such as provinces and districts.

### 2. Farmer Management

Allows storing and retrieving farmer information including their contact details and associated location.

### 3. Farm Management

Farmers can register multiple farms with details such as farm size and farm type.

### 4. Crop Management

Different crops grown in farms can be managed.

### 5. Pesticide Management

Pesticides used for crops can be stored and tracked.

---

# Database Relationships

This project demonstrates the following relationships:

### One-to-One Relationship

A farmer has exactly one farmer profile.

Farmer → FarmerProfile

### One-to-Many Relationship

A farmer can own multiple farms.

Farmer → Farms

### Many-to-Many Relationship

A farm can grow multiple crops and a crop can be grown on multiple farms.

Farm ↔ Crop

A join table called **farm_crop** is used to implement this relationship.

---

# Entity Relationship Diagram (ERD)

The system contains the following tables:

* Location
* Farmer
* FarmerProfile
* Farm
* Crop
* Pesticide
* Farm_Crop (Join Table)

These entities demonstrate different relational mappings using JPA annotations.

![alt text](<My Smart AgriTech ERD.drawio-1.png>)

---

## Project Structure

```
SmartAgriTech
│
├── src
│   └── main
│       ├── java
│       │   └── auca
│       │       └── ac
│       │           └── rw
│       │               └── smartAgritech
│       │                   ├── controller
│       │                   │   ├── FarmerController.java
│       │                   │   ├── FarmController.java
│       │                   │   ├── CropController.java
│       │                   │   └── LocationController.java
│       │                   │
│       │                   ├── service
│       │                   │   ├── FarmerService.java
│       │                   │   ├── FarmService.java
│       │                   │   └── CropService.java
│       │                   │
│       │                   ├── repository
│       │                   │   ├── FarmerRepository.java
│       │                   │   ├── FarmRepository.java
│       │                   │   └── CropRepository.java
│       │                   │
│       │                   └── model
│       │                       ├── Farmer.java
│       │                       ├── Farm.java
│       │                       ├── Crop.java
│       │                       └── Location.java
│
├── pom.xml
└── README.md
```

# API Endpoints

## Here are all the endpoints I have used for testing in Postman with it's screen-shoot:

## LOCATION
* POST | http://localhost:8080/api/locations/save

![alt text](<location saved.png>)

* POST | http://localhost:8080/api/locations/save?parentId=UUID

![alt text](<Sector saved-1.png>)
![alt text](<Cell Saved.png>)
![alt text](<Village saved-1.png>)

* GET  | http://localhost:8080/api/locations/all

![alt text](<Get all locations.png>)
![alt text](<get all locations2.png>)
![alt text](<all location.png>)

* GET  | http://localhost:8080/api/locations/code

![alt text](<get location by code.png>)

## FARMER
* POST | http://localhost:8080/api/farmers/save?locationId=UUID

![alt text](<Save Farmer-1.png>)

* GET  | http://localhost:8080/api/farmers/paginated?page=0&size=5&sortBy=firstName

![alt text](<Pagination & Sorting.png>)

* GET  | http://localhost:8080/api/farmers/by-province?code=KGL

![alt text](<get location by code-1.png>)

## FARM
* POST | http://localhost:8080/api/farms/save?farmerId=1

![alt text](<Farm saved-1.png>)

## PESTICIDE
* POST  | http://localhost:8080/api/pesticides/save

![alt text](<pecisticide saved.png>)

## CROP
* POST | http://localhost:8080/api/crops/save?farmId=1

![alt text](<Crop saved.png>)

* PUT  | http://localhost:8080/api/crops/1/assign-pesticides 

![alt text](<pecisticide assigned.png>)

* GET  | http://localhost:8080/api/crops/paginated?page=0&size=5&sortBy=cropName&direction=asc

![alt text](<paginated 1-1.png>)

## Setup & Installation

Before run this project you must have the following installed on your Laptop or DeskTop:

* Java 21+
* Maven
* PostgreSQL

1. Step 1 — Create the database like (craeting a database name)
2. Step 2 — Configure application.properties
3. Step 3 — Run the project by click on run button or by use this commands in terminal mvn clean spring-boot:run

 ## Key Features 
* Pagination:
Uses Spring Data JPA Pageable — fetches only a small page instead of loading all records. Improves performance significantly on large datasets.

* Sorting:
Uses Sort.by() to order results by any field in ascending or descending direction.
* existsBy():
Spring generates an optimized SELECT COUNT(*) > 0 — faster than loading the full object. Used to prevent duplicate farmer emails.
* Farmers by Province (Code OR Name):
Custom JPQL query traverses farmer → location → parent to filter by province code OR name in a single query.
*  Many-to-Many Join Table:
@JoinTable tells Hibernate to auto-create the crop_pesticide table with two foreign keys. No need to create it manually

---

# How to Run the Project

1. Clone the repository
2. Open the project in Visual Studio Code
3. Configure the database connection in **application.properties**
4. Run the Spring Boot application
5. Use Postman to test the REST APIs

---

# Author

Name: FABRICE RUKUNDO

University: Adventist University of Central Africa (AUCA)

Course: Web Technology and Internet

---

# Conclusion

This project demonstrates how Spring Boot and Spring Data JPA can be used to implement relational database systems with advanced features such as pagination, sorting, and entity relationships.
