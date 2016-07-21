Synopsis

The purpose of this project is to create a standalone password validation service which should do the following

check a text string for compliance to any number of password validation rules.
The rules currently known are:
1. Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
2. Must be between 5 and 12 characters in length.
3. Must not contain any sequence of characters immediately followed by the same sequence.
4. The password may not be the same as any of the users three most recent passwords.


Project Tech stack

The project has been developed using the following stack trace and tools.

1. Java
2. Spring Boot
3. Spring Data JPA
4. In Memory DB - H2
5. Junit
6. Maven


Project Components (with classes)

The major components of the project includes

1. A REST controller (PasswordController) :  for any external system to call the service via REST standards to validate a given password and also to save the password
2. Services (PasswordService and ValidatorService): The services act a service layer between the controller and the repository layer
3. Repository (PasswordRepository) : a repository component meant to work on the actual saving of the password to the DB. This has been configured to work with in memory DB as of now which can easily be configured with any RDBMS database
4. Validators : There are a set of validators for each validation rule which implement the common interface PasswordValidator. If in future any new validation logic is needed , a new validator just needs to be added
5. Spring boot config files.    


Installation

1. Build from code.

a. Import the project in any IDE like Eclipse or IntelliJ
b. run the maven command 
	mvn package
c. This will create the executable jar and also the source code and the java doc

2. Run the executable

Either from the earlier step create the executable or run the attached executable  	

java -jar passwordvalidator-1.0.0-SNAPSHOT.jar

This will start the Spring boot application which also has a built in tomcat web server and an in memory H2 database

Tests

There are Junit testcases in the project i.e PasswordValidationTest. It has all the possible test cases associated


API Reference

Attaching the REST api POSTMAN collection to execute the rest services

a) validate password

GET /passwords/validate?password=<<password>>

This is used to validate a given password. The execution would validate a password against the set of given rules

b) save password

POST /passwords/validate

param : password
value: <<password>>

This first validates the password and then saves the password in the in-memory db 

Contributors

Tathagata Roy