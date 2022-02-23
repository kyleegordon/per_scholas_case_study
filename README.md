# per_scholas_case_study

## Description

This application allows users to enroll in services offered by a cyber security company. Users will be able to create an account that captures information about their organization and industry. They will then fill out an assessment with questions based on the 18 CIS Critical Security Controls. This data will used to create a report that assigns them an overall security score and highlights areas that need improvement. It will use this information to recommend services that align with the areas that need improvement. The users will then have the option to enroll or unenroll in any of the recommended services. 



## User Stories By Page

Index 
* As a user, I would like to view the index page so that I can access and navigate this application. 
  
 About 
* As a user, I would like to view the about page so that I can learn more about this application.
 
Sign Up
* As a user, I would like to create an account so that I can use this application.

Login
* As a user, I would like to login so that I can access my account.

Account
* As a user, I would like to update my account information so that it will be accurate if anything changes.
* As a user, I would like to delete my account if I no longer need to use this application.
* As a user, I would like to view my assessment results so that I understand where my business is lacking in cyber security.
* As a user, I would like to retake the assessment so that it will be accurate if anything changes.
* As a user, I would like to view the services that I am enrolled in so that I am aware of the services that this business is providing for me.
* As a user, I would like to unenroll from any services in case I no longer need them.

Services
* As a user, I would like to view services that are recommended to me so that I know what my options are.
* As a user, I would like to enroll in services so that I can benefit from them.
    
    
## Technical Challenges

I initially had difficulty planning the structure of the database. Originally, I had one table for the assessment results that included a column for each question. This didn't offer flexibility or scalability should the number of assessment questions need to change in the future. It also made it difficult to create a relationship between the assessment question and the related service. To fix this, I restructured my database so that each question was represented by a row instead of a column. 
  
