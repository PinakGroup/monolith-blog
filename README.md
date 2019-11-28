# monolith-blog
Monolith Blog project with Spring Boot

## Installation

  ### Backend 
    Step 1: Install java 8 and maven first.
    Step 2: Navigate to /blog directory
    Step 3: Run the command `mvn spring-boot:run`. Project should be run at port 8090
    
    (Or you can run the project by Intellij Idea.
    
  ### Frontend
    Step 1: Install node (recommended version 10.15.3)
    Step 2: navigate to /blog/ui directory
    Step 3: Run the commands `npm install` and `npm start`. Frontend project should be run at port 8080
            Navigation url is http://localhost:8080/login
    
## Features
    1. Two types of user. Admin & Blogger.
    2. One Admin type user’s account is system generated when the application bootstrap
       for the first time.
    3. Admin has following functionalities:
        a. Log in with username/password
        b. Create other Admin account
        c. Approve/Deactivate Blogger type user’s account
        d. Approve and publish Blog post
        e. Delete any blog post
    4. Blogger has following functionality before his account is approved by Admin:
       a. Create own account and send for Admin’s approval.
    5. Blogger has following functionalities after his account is approved by Admin:
        a. Log in with username/password
        b. Create blog post and send for admin’s approval
        c. Delete own blog post
        d. View other blogger’s approved blog post
        e. Comment on other blogger’s approved blog post
        f. Like/Dislike other blogger’s approved blog
           post
           
## Technology Used
     1. Spring Boot, Spring Security, Maven
     2. H2 database
     3. Angular 7 and web-pack
