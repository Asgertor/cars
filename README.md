<<<<<<< HEAD
How I covered the learning goals

- The idea with, and reasons for why to use, a ORM-mapper

  Speeds up development, makes it easier to change database

- The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected

   ??

- How to create simple Java entities and map them to a database via the Spring Data API

   See how I implemented the Car and Member Entities
- How to control the mapping between individual fields in an Entity class and their matching columns in the database

   See my use of the @Column annotation in the Car entity class
  
- How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it (Auto Increment in our case for  MySQL)

   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

- How to use and define repositories and relevant query methods using Spring Data JPAs repository pattern
   See the two repositories in the repository package
  
- How to write simple "integration" tests, using H2 as a mock-database instead of MySQL
  
   I did not have time for that
- How to add (dev) connection details for you local MySQL database

  I added the values in a configuratioin setup (values for this)

spring.datasource.url=${JDBC_DATABASE_URL}

spring.datasource.username=${JDBC_USERNAME}

spring.datasource.password=${JDBC_PASSWORD}
  
   How you did that
=======
The idea with, and reasons for why to use, a ORM-mapper
-  ORM is used to map Java objects to our database.

The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected
-  JPA(Java persistence API) is an ORM(Object-releational mapping) for java, that uses Hibernate and Spring Data JPA.

How to create simple Java entities and map them to a database via the Spring Data API
- To map a java class, you need the @Entity notation. 

How to control the mapping between individual fields in an Entity class and their matching columns in the database
- You can use notations like @Table and @Column to modify the properties

How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it (Auto Increment in our case for  MySQL)
- By using this annotation:  @GeneratedValue, and for mySQL (strategy = GenerationType.IDENTITY)

How to use and define repositories and relevant query methods using Spring Data JPAs repository pattern
- You can extend the JPARepository to gain access to perfom CRUD operation on our entities. You can also define your own methods

How to write simple "integration" tests, using H2 as a mock-database instead of MySQL
- The H2 dependancy must be implemented. If you have no database connection, it will default to the H2.

How to add (dev) connection details for you local MySQL database
- You  add URL, username and password to a valid connection in application.properties.
>>>>>>> origin/master
