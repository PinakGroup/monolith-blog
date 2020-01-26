# Monolith Blog Application
Monolith Blog project with Spring Boot

## Technologies used
- Java 8
- Maven
- Spring Boot 
- Spring Security
- JJWT
- Lombok
- H2 DB
- Angular 7
- Webpack

## General architecture

<img width="882" alt="Monolith Blog" src="https://user-images.githubusercontent.com/8774751/73134777-3eded980-4043-11ea-8517-c22c9f10d7ad.png">

## Features
- Two types of user. Admin & Blogger.
- One Admin type user’s account is system generated when the application bootstrap for the first time.
- Admin has following functionalities:
  - Log in with username/password
  - Create other Admin account
  - Approve/Deactivate Blogger type user’s account
  - Approve and publish Blog post
  - Delete any blog post
- Blogger has following functionality before his account is approved by Admin:
  - Create own account and send for Admin’s approval.
- Blogger has following functionalities after his account is approved by Admin:
  - Log in with username/password
  - Create blog post and send for admin’s approval
  - Delete own blog post
  - View other blogger’s approved blog post
  - Comment on other blogger’s approved blog post
  - Like/Dislike other blogger’s approved blog post

## How to run all the things?

  ### Backend 
- Install java 8 and maven first.
- Navigate to /blog directory
- Run the command `mvn spring-boot:run`. Project should be run at port 8090

(Or run the project by Intellij Idea)
    
  ### Frontend
- Install node (recommended version 10.15.3)
- Navigate to /blog/ui directory
- Run the commands `npm install` and `npm start`. Frontend project should be run at port 8080. Login page url is http://localhost:8080/login
