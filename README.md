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

AND here there is an ERD Image that explain all relationships

![alt text](<My Smart AgriTech ERD.drawio.png>)

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

<img width="535" height="464" alt="Image" src="https://github.com/user-attachments/assets/e08c6fb4-1453-40a3-9f06-8dc0a3ee43e3" />

* POST | http://localhost:8080/api/locations/save?parentId=UUID

<img width="523" height="444" alt="Image" src="https://github.com/user-attachments/assets/423cd408-2646-419f-b512-ecf1bd677565" />

<img width="535" height="464" alt="Image" src="https://github.com/user-attachments/assets/fb78f672-47f3-4797-b184-214e26e787fd" />

<img width="542" height="386" alt="Image" src="https://github.com/user-attachments/assets/5e93d59f-4094-403f-ad43-cf199d45554a" />

* GET  | http://localhost:8080/api/locations/all

<img width="720" height="468" alt="Image" src="https://github.com/user-attachments/assets/653bbd97-d289-419e-b667-a7a407b3faae" />

<img width="704" height="456" alt="Image" src="https://github.com/user-attachments/assets/bd433b38-601e-4c69-be4f-ac0943f7b647" />

<img width="629" height="455" alt="Image" src="https://github.com/user-attachments/assets/ee17925d-a63f-44a4-89a6-315e115a24b4" />

* GET  | http://localhost:8080/api/locations/code

<img width="554" height="445" alt="Image" src="https://github.com/user-attachments/assets/f5a342f1-8b83-4ad3-9b0f-21f1eafdfc90" />

## FARMER
* POST | http://localhost:8080/api/farmers/save?locationId=UUID

<img width="719" height="442" alt="Image" src="https://github.com/user-attachments/assets/d71a59b1-d719-4db4-bd9d-31cd7dc74d48" />

* GET  | http://localhost:8080/api/farmers/paginated?page=0&size=5&sortBy=firstName

<img width="617" height="447" alt="Image" src="https://github.com/user-attachments/assets/c42996ab-26a6-4718-87ea-4e0af5c93393" />

* GET  | http://localhost:8080/api/farmers/by-province?code=KGL

<img width="554" height="445" alt="Image" src="https://github.com/user-attachments/assets/945feabb-c6cb-4da8-895f-23c967f28038" />

## FARM
* POST | http://localhost:8080/api/farms/save?farmerId=1

<img width="719" height="442" alt="Image" src="https://github.com/user-attachments/assets/d71a59b1-d719-4db4-bd9d-31cd7dc74d48" />

## PESTICIDE
* POST  | http://localhost:8080/api/pesticides/save

<img width="721" height="394" alt="Image" src="https://github.com/user-attachments/assets/5640df76-b8a3-4e20-8de2-e8433b45815b" />

## CROP
* POST | http://localhost:8080/api/crops/save?farmId=1

<img width="727" height="455" alt="Image" src="https://github.com/user-attachments/assets/7be9f4af-3cac-4091-a59c-9e06a7c8663c" />

* PUT  | http://localhost:8080/api/crops/1/assign-pesticides 

<img width="607" height="404" alt="Image" src="https://github.com/user-attachments/assets/7f95d86e-3310-40d4-a66e-eba492468ee5" />

* GET  | http://localhost:8080/api/crops/paginated?page=0&size=5&sortBy=cropName&direction=asc

<img width="611" height="446" alt="Image" src="https://github.com/user-attachments/assets/2ff6d636-b625-4774-b7c7-1d7ef66bc7ab" />

<img width="611" height="445" alt="Image" src="https://github.com/user-attachments/assets/3479ca7c-e913-458b-9d17-8b1299314e4e" />

<img width="614" height="468" alt="Image" src="https://github.com/user-attachments/assets/34fbce32-95ee-4a78-be40-d693ff1c10a3" />

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
