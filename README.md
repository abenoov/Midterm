# Midterm
 
This is electricity counting system.

This project represents electricity consumption for user and users can pay bills for electricity.


For the project stucture:

entity -> dao -> service -> controller

Here:

entity -> Bill and User 
dao -> BillDao and UserDao 
service -> BillService and UserService
controller -> MainController

Facade pattern was used in this project.


Bill and User class is a concreate class represents their tables.

in BillDao and UserDao you can use all the queries that is being executed after calling them from service class. 
Connection to the database is made by Database class in the database package.

Since we do not have beans.xml we have to make the through anotations such as : @Component, @AutoWired, @Scope, @PreConstruct, @Value and etc.

Some classes are not beans such as entity.

in UserService after caling DAO makes some function such as listing, input and etc. then returns them in console. 

Controller is the user interaction class.


in the facade we call context and then we call al the functionality from the MainController.



The backup file is in the root called electricity.sql. 
