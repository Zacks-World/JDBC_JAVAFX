# JavaFX and JDBC: Professors and Departments Management

This project is a JavaFX application that integrates with a MySQL database to manage professors and departments. It enables users to perform CRUD (Create, Read, Update, Delete) operations and associate professors with departments.

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Database Configuration](#database-configuration)
5. [Folder Structure](#folder-structure)
6. [Class Diagram](#class-diagram)
7. [MDL](#mdl)

---

## Overview

This application manages professors and their departments. Each professor belongs to a single department, and departments can have one or more professors.

### Data Structure
- **Professor**:
  - `id_prof` (int)
  - `nom` (string)
  - `prenom` (string)
  - `cin` (string)
  - `adresse` (string)
  - `telephone` (string)
  - `email` (string)
  - `date_recrutement` (date)
- **Department**:
  - `id_depart` (int)
  - `nom` (string)

---

## Features

### Professors Management:
- Display the list of professors.
- Search professors by keywords.
- Add, delete, and update professors.
- Assign a professor to a department.

### Departments Management:
- Add, delete, and update departments.
- Display the list of departments.
- Show the list of professors in a department.

---

## Prerequisites

To run this project, ensure you have:
- **Java Development Kit (JDK)** 17 or later.
- **MySQL Server**.
- **JavaFX SDK**.
- A code editor like IntelliJ IDEA or Eclipse.
- A MySQL client (e.g., phpMyAdmin, MySQL Workbench).

---

## Database Configuration

1. Create a MySQL database named `gestion_professeurs`:
   ```sql
   CREATE DATABASE gestion_professeurs;
   CREATE TABLE professors (
    id_prof INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    cin VARCHAR(20),
    adresse VARCHAR(255),
    telephone VARCHAR(20),
    email VARCHAR(255),
    date_recrutement DATE);
   CREATE TABLE departments (
    id_depart INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255));
##Folder Structure

src/main/java
└── com
    └── example
        └── myapp
            ├── App.java
            ├── controllers
            │   ├── ProfController.java
            │   ├── DepartmentController.java
            ├── models
            │   ├── Professor.java
            │   ├── Department.java
            ├── services
            │   ├── ProfessorService.java
            │   ├── DepartmentService.java
            ├── utils
            │   └── SingletonConnexionDB.java
            └── views
                ├── MainView.java
                └── AddProfessorView.java
                
##Class Diagram

![Classe](https://github.com/user-attachments/assets/eb90d737-4119-46c9-9b54-055c271bdac8)

##MDL


