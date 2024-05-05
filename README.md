To Run Backend:


Clone the repository to your local machine using Git:



git clone https://github.com/michalarogers/Project3---Back-End.git

cd Project3---Back-End



Before running the application, set up the MySQL database. The database is already made; it just needs to be initialized on the tester’s computer. Make sure you have Docker open


mkdir MySQLTest

cd MySQLTest

git clone https://github.com/liranmatcu/Database.git

cd  MySQLTest/Database/MySQL 

docker-compose up -d mdb

docker exec -it mysql bash

mysql -u root -p (password is password)

SHOW DATABASE;

CREATE DATABASE meteorite;

USE meteorite;




Open database editor from View - Tool Windows - Database

Press + to create new database choose MySQL

username = root

password = password

database name = meteorite

Then press test connection to MySQL




Import the database schema and data from the dump file included in the repository:

mysql -u root -p meteorite < Project3---Back-End-master\Meteorite.sql OR copy and paste already exisitng SQL file into the console
