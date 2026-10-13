create database ABCHospitalDatabase;

--Create person table
CREATE TABLE Person(
	PersonID int identity(1,1) primary key,
	FirstName NVARCHAR(100) NOT NULL,
	LastName NVARCHAR(100) not null,
	Gender char(1) not null,
	DateOfBirth DATE not null,
	Phone NVARCHAR(30),
	Email NVARCHAR(150),
	Street NVARCHAR(200),
	City NVARCHAR(100),
	Country NVARCHAR(100)
);

select * from Person;

--Insert into Person table(Start insert 100 records)
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Matthew', 'Griffin', 'M', '1986-06-21', '+33 6 12 34 56 01', 'matthew.griffin81@outlook.com', '8181 Pinewood Rd', 'Yonkers', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Benjamin', 'Lewis', 'M', '1985-01-08', '+1 202 555 0113', 'benjamin.lewis13@icloud.com', '1313 Chestnut St', 'Sacramento', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Ella', 'Brooks', 'F', '1994-10-18', '+234 801 234 5616', 'ella.brooks56@hotmail.com', '5656 Teak St', 'Hialeah', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Paisley', 'Flores', 'F', '1996-04-26', '+229 90 11 01 12', 'paisley.flores72@hotmail.com', '7272 Manzanita Rd', 'Jacksonville', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Aiden', 'Edwards', 'M', '1985-07-14', '+44 20 7946 0113', 'aiden.edwards33@outlook.com', '3333 Ivy Ct', 'Detroit', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Andrew', 'Coleman', 'M', '1997-11-23', '+229 90 11 01 05', 'andrew.coleman65@outlook.com', '6565 Fig St', 'Fort Lauderdale', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Emma', 'Carter', 'F', '1992-07-22', '+1 202 555 0102', 'emma.carter2@yahoo.com', '202 Oak St', 'Denver', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Grayson', 'Ward', 'M', '1987-04-28', '+234 801 234 5609', 'grayson.ward49@outlook.com', '4949 Rosewood Ave', 'Jersey City', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Noah', 'Bennett', 'M', '1988-11-05', '+1 202 555 0103', 'noah.bennett3@outlook.com', '303 Pine Rd', 'Seattle', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Julian', 'Cox', 'M', '1993-03-03', '+234 801 234 5607', 'julian.cox47@gmail.com', '4747 Quince Dr', 'Wichita', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Elizabeth', 'Perez', 'F', '1991-11-28', '+44 20 7946 0106', 'elizabeth.perez26@gmail.com', '2626 Elm Ct', 'Salt Lake City', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Bella', 'Foster', 'F', '1991-08-16', '+229 90 11 01 16', 'bella.foster76@yahoo.com', '7676 Neem Dr', 'Norfolk', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('William', 'Thompson', 'M', '1979-12-25', '+1 202 555 0107', 'william.thompson7@hotmail.com', '707 Spruce St', 'Phoenix', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Emily', 'Carter', 'F', '1994-06-30', '+44 20 7946 0104', 'emily.carter24@hotmail.com', '2424 Cypress St', 'Pittsburgh', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Olivia', 'Mitchell', 'F', '1995-01-30', '+1 202 555 0104', 'olivia.mitchell4@gmail.com', '404 Elm Blvd', 'Chicago', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Samuel', 'Rogers', 'M', '1988-01-13', '+44 20 7946 0117', 'samuel.rogers37@gmail.com', '3737 Locust Blvd', 'Albuquerque', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Owen', 'Parker', 'M', '1992-02-20', '+44 20 7946 0111', 'owen.parker31@gmail.com', '3131 Holly Ave', 'Cincinnati', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Avery', 'James', 'F', '1997-03-06', '+234 801 234 5614', 'avery.james54@icloud.com', '5454 Sycamore Blvd', 'Garland', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Elijah', 'Mitchell', 'M', '1987-09-16', '+44 20 7946 0105', 'elijah.mitchell25@outlook.com', '2525 Dogwood Rd', 'San Antonio', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Aurora', 'Gray', 'F', '1992-05-11', '+234 801 234 5612', 'aurora.gray52@yahoo.com', '5252 Silver Birch Ln', 'Durham', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Leo', 'Ramirez', 'M', '1989-06-30', '+234 801 234 5613', 'leo.ramirez53@gmail.com', '5353 Spruce Ct', 'Scottsdale', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Alexander', 'Scott', 'M', '1986-04-04', '+1 202 555 0119', 'alexander.scott19@gmail.com', '1919 Mesquite Blvd', 'Kansas City', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Luna', 'Russell', 'F', '1992-12-03', '+229 90 11 01 20', 'luna.russell80@hotmail.com', '8080 Palm Ct', 'Lubbock', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Isabella', 'Lopez', 'F', '1987-04-19', '+1 202 555 0110', 'isabella.lopez10@outlook.com', '1010 Redwood Way', 'Las Vegas', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Evelyn', 'Green', 'F', '1990-10-31', '+1 202 555 0120', 'evelyn.green20@icloud.com', '2020 Mulberry Ct', 'Columbus', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Isaac', 'Peterson', 'M', '1995-01-07', '+234 801 234 5611', 'isaac.peterson51@gmail.com', '5151 Sequoia Pl', 'Plano', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lily', 'Collins', 'F', '1990-04-25', '+44 20 7946 0114', 'lily.collins34@gmail.com', '3434 Jade Pl', 'Buffalo', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Kayla', 'West', 'F', '1990-06-14', '+33 6 12 34 56 12', 'kayla.west92@yahoo.com', '9292 Citrus Blvd', 'Reno', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Mason', 'Harris', 'M', '1994-06-27', '+1 202 555 0111', 'mason.harris11@gmail.com', '1111 Sycamore Pl', 'Portland', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Anthony', 'Watson', 'M', '1982-11-11', '+234 801 234 5615', 'anthony.watson55@gmail.com', '5555 Tamarack Ave', 'Glendale', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Madison', 'Bennett', 'F', '1993-12-15', '+234 801 234 5620', 'madison.bennett60@yahoo.com', '6060 Willow Way', 'Providence', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jameson', 'Ford', 'M', '1983-07-20', '+33 6 12 34 56 05', 'jameson.ford85@gmail.com', '8585 Alder Ct', 'Winston-Salem', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Nova', 'Myers', 'F', '1990-10-22', '+33 6 12 34 56 04', 'nova.myers84@yahoo.com', '8484 Acacia Blvd', 'Irving', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Cameron', 'Craig', 'M', '1982-08-12', '+33 6 12 34 56 15', 'cameron.craig95@gmail.com', '9595 Cypress Ct', 'Cary', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ethan', 'Martinez', 'M', '1996-08-03', '+1 202 555 0109', 'ethan.martinez9@yahoo.com', '909 Poplar Ct', 'Atlanta', 'USA');

INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('James', 'Robinson', 'M', '1984-09-17', '+1 202 555 0105', 'james.robinson5@icloud.com', '505 Cedar Ln', 'Boston', 'USA');


INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Logan', 'Roberts', 'M', '1998-04-12', '+44 20 7946 0107', 'logan.roberts27@gmail.com', '2727 Fern Ave', 'Baltimore', 'UK');

INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Connor', 'Graham', 'M', '1991-04-20', '+33 6 12 34 56 07', 'connor.graham87@gmail.com', '8787 Aspen Ct', 'Modesto', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Jocelyn', 'Hicks', 'F', '1995-12-07', '+33 6 12 34 56 14', 'jocelyn.hicks94@icloud.com', '9494 Cocoa Ave', 'Orange', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Joshua', 'Perry', 'M', '1988-01-09', '+229 90 11 01 07', 'joshua.perry67@gmail.com', '6767 Hawthorn Blvd', 'Louisville', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country)
VALUES ('Joseph', 'Hayes', 'M', '1994-04-13', '+33 6 12 34 56 03', 'joseph.hayes83@gmail.com', '8383 Redbud Ave', 'Paterson', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Hazel', 'Patterson', 'F', '1994-02-17', '+229 90 11 01 10', 'hazel.patterson70@icloud.com', '7070 Larch Ave', 'Anchorage', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ryan', 'Washington', 'M', '1984-02-22', '+229 90 11 01 13', 'ryan.washington73@outlook.com', '7373 Juniper Ct', 'Lincoln', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Sophia', 'Garcia', 'F', '1991-02-14', '+1 202 555 0108', 'sophia.garcia8@gmail.com', '808 Willow Dr', 'Dallas', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Penelope', 'Murphy', 'F', '1995-05-31', '+234 801 234 5602', 'penelope.murphy42@gmail.com', '4242 Olive Ln', 'Fresno', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Abigail', 'Adams', 'F', '1996-08-24', '+44 20 7946 0102', 'abigail.adams22@gmail.com', '2222 Alder Way', 'Indianapolis', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Mia', 'Clark', 'F', '1998-10-11', '+1 202 555 0112', 'mia.clark12@gmail.com', '1212 Aspen Ave', 'San Diego', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Sofia', 'Turner', 'F', '1995-12-01', '+44 20 7946 0108', 'sofia.turner28@icloud.com', '2828 Fir Ln', 'New Orleans', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Liam', 'Anderson', 'M', '1990-03-14', '+1 202 555 0101', 'liam.anderson1@gmail.com', '101 Maple Ave', 'Austin', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Carter', 'Bell', 'M', '1991-07-18', '+234 801 234 5601', 'carter.bell41@outlook.com', '4141 Oakdale St', 'Richmond', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Michael', 'Nelson', 'M', '1983-03-11', '+44 20 7946 0103', 'michael.nelson23@gmail.com', '2323 Beech Ave', 'St. Louis', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Charles', 'Wood', 'M', '1998-06-01', '+229 90 11 01 01', 'charles.wood61@gmail.com', '6161 Yew Rd', 'Corpus Christi', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Grace', 'Campbell', 'F', '1993-06-08', '+44 20 7946 0110', 'grace.campbell30@gmail.com', '3030 Hazel Dr', 'Raleigh', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Wyatt', 'Cooper', 'M', '1984-10-07', '+234 801 234 5605', 'wyatt.cooper45@gmail.com', '4545 Pine Cone Rd', 'Arlington', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Maya', 'Bryant', 'F', '1995-09-08', '+229 90 11 01 18', 'maya.bryant78@icloud.com', '7878 Oleander Ave', 'Springfield', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Daniel', 'Baker', 'M', '1993-02-18', '+44 20 7946 0101', 'daniel.baker21@yahoo.com', '2121 Palm Dr', 'Charlotte', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Nora', 'Butler', 'F', '1993-07-25', '+229 90 11 01 14', 'nora.butler74@gmail.com', '7474 Mesquite Ave', 'Greensboro', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Luke', 'Bailey', 'M', '1997-12-23', '+234 801 234 5603', 'luke.bailey43@gmail.com', '4343 Palm Ct', 'Anaheim', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Aria', 'Morris', 'F', '1994-09-09', '+44 20 7946 0116', 'aria.morris36@yahoo.com', '3636 Linden Ave', 'Oklahoma City', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Chloe', 'Evans', 'F', '1997-10-05', '+44 20 7946 0112', 'chloe.evans32@hotmail.com', '3232 Ironwood St', 'Milwaukee', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Christopher', 'Ross', 'M', '1983-10-27', '+229 90 11 01 03', 'christopher.ross63@gmail.com', '6363 Cedar Ct', 'Akron', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Nathan', 'Hughes', 'M', '1990-05-03', '+229 90 11 01 11', 'nathan.hughes71@gmail.com', '7171 Magnolia Blvd', 'Honolulu', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ellie', 'Diaz', 'F', '1997-01-28', '+33 6 12 34 56 02', 'ellie.diaz82@gmail.com', '8282 Quaker Ct', 'Des Moines', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Audrey', 'Torres', 'F', '1991-09-21', '+234 801 234 5610', 'audrey.torres50@gmail.com', '5050 Sage Ct', 'Chandler', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Gabriel', 'Cook', 'M', '1986-08-15', '+44 20 7946 0119', 'gabriel.cook39@gmail.com', '3939 Mimosa Dr', 'Tulsa', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lincoln', 'Kelly', 'M', '1996-02-29', '+234 801 234 5617', 'lincoln.kelly57@outlook.com', '5757 Tulip Dr', 'Fort Wayne', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lydia', 'Nichols', 'F', '1992-09-30', '+33 6 12 34 56 18', 'lydia.nichols98@gmail.com', '9898 Eucalyptus Dr', 'Spokane', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('David', 'Alexander', 'M', '1989-11-14', '+229 90 11 01 19', 'david.alexander79@gmail.com', '7979 Orchid St', 'Madison', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Violet', 'Richard', 'F', '1994-01-27', '+33 6 12 34 56 16', 'violet.richard96@hotmail.com', '9696 Ebony St', 'Tallahassee', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Amelia', 'Young', 'F', '1992-12-13', '+1 202 555 0116', 'amelia.young16@gmail.com', '1616 Juniper Rd', 'Cleveland', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Savannah', 'Jenkins', 'F', '1992-03-17', '+229 90 11 01 06', 'savannah.jenkins66@gmail.com', '6666 Gum Ave', 'Chesapeake', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Zoey', 'Morgan', 'F', '1993-11-02', '+44 20 7946 0120', 'zoey.morgan40@hotmail.com', '4040 Myrtle Ave', 'Hartford', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Victoria', 'Barnes', 'F', '1991-04-07', '+229 90 11 01 02', 'victoria.barnes62@icloud.com', '6262 Birch Ln', 'Lexington', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Naomi', 'Fields', 'F', '1996-07-19', '+33 6 12 34 56 20', 'naomi.fields100@yahoo.com', '10000 Hickory Pl', 'Gilbert', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Charlotte', 'Walker', 'F', '1997-03-21', '+1 202 555 0114', 'charlotte.walker14@gmail.com', '1414 Cottonwood Dr', 'Orlando', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Layla', 'Reed', 'F', '1999-03-27', '+44 20 7946 0118', 'layla.reed38@icloud.com', '3838 Maple Ct', 'Omaha', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Natalie', 'Howard', 'F', '1998-08-29', '+234 801 234 5608', 'natalie.howard48@hotmail.com', '4848 Redwood St', 'Newark', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Isaac', 'Reyes', 'M', '1988-03-16', '+33 6 12 34 56 13', 'isaac.reyes93@gmail.com', '9393 Clover Ct', 'Bridgeport', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ariana', 'Powell', 'F', '1999-09-14', '+229 90 11 01 08', 'ariana.powell68@yahoo.com', '6868 Heather Ct', 'New Haven', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Ava', 'Davis', 'F', '1993-05-09', '+1 202 555 0106', 'ava.davis6@gmail.com', '606 Birch Ave', 'Miami', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Adam', 'Simmons', 'M', '1998-10-06', '+229 90 11 01 15', 'adam.simmons75@gmail.com', '7575 Myrtle Blvd', 'Shreveport', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lena', 'Woods', 'F', '1993-05-23', '+33 6 12 34 56 10', 'lena.woods90@gmail.com', '9090 Cactus Dr', 'Birmingham', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Henry', 'King', 'M', '1981-05-29', '+1 202 555 0117', 'henry.king17@outlook.com', '1717 Laurel Ave', 'Minneapolis', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jackson', 'Stewart', 'M', '1996-05-19', '+44 20 7946 0115', 'jackson.stewart35@gmail.com', '3535 Laurel Rd', 'Memphis', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jack', 'Phillips', 'M', '1989-09-03', '+44 20 7946 0109', 'jack.phillips29@yahoo.com', '2929 Ginkgo Blvd', 'Louisville', 'UK');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Jacob', 'Ferguson', 'M', '1999-05-05', '+33 6 12 34 56 17', 'jacob.ferguson97@outlook.com', '9797 Elmwood Ave', 'Mesquite', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Stella', 'Henderson', 'F', '1995-08-20', '+229 90 11 01 04', 'stella.henderson64@hotmail.com', '6464 Dogwood Ave', 'Stockton', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lucas', 'Hall', 'M', '1989-09-02', '+1 202 555 0115', 'lucas.hall15@yahoo.com', '1515 Hickory Ln', 'Nashville', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Eli', 'Gonzales', 'M', '1987-05-18', '+229 90 11 01 17', 'eli.gonzales77@gmail.com', '7777 Oak Ct', 'Grand Rapids', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Leah', 'Sullivan', 'F', '1998-02-05', '+33 6 12 34 56 08', 'leah.sullivan88@hotmail.com', '8888 Bayberry Ave', 'Columbia', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Gabriel', 'Cole', 'M', '1997-08-19', '+33 6 12 34 56 11', 'gabriel.cole91@gmail.com', '9191 Catalpa Ave', 'Grand Prairie', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('George', 'Mccoy', 'M', '1987-12-01', '+33 6 12 34 56 19', 'george.mccoy99@gmail.com', '9999 Fennel Ct', 'Baton Rouge', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Scarlett', 'Sanders', 'F', '1990-07-12', '+234 801 234 5618', 'scarlett.sanders58@gmail.com', '5858 Vine Ave', 'Boise', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Caleb', 'Long', 'M', '1986-12-24', '+229 90 11 01 09', 'caleb.long69@gmail.com', '6969 Koa Dr', 'Bakersfield', 'Benin');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Harper', 'Wright', 'F', '1999-07-07', '+1 202 555 0118', 'harper.wright18@gmail.com', '1818 Magnolia St', 'Tampa', 'USA');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Lillian', 'Richardson', 'F', '1996-06-17', '+234 801 234 5606', 'lillian.richardson46@icloud.com', '4646 Plum Ave', 'Aurora', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Hannah', 'Rivera', 'F', '1990-02-09', '+234 801 234 5604', 'hannah.rivera44@yahoo.com', '4444 Pecan Blvd', 'Toledo', 'Nigeria');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Dylan', 'Wallace', 'M', '1985-09-26', '+33 6 12 34 56 09', 'dylan.wallace89@outlook.com', '8989 Butternut St', 'Santa Clarita', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Elena', 'Hamilton', 'F', '1996-11-11', '+33 6 12 34 56 06', 'elena.hamilton86@icloud.com', '8686 Amaranth Dr', 'Chattanooga', 'France');
INSERT INTO Person (FirstName, LastName, Gender, DateOfBirth, Phone, Email, Street, City, Country) 
VALUES ('Thomas', 'Price', 'M', '1985-08-05', '+234 801 234 5619', 'thomas.price59@gmail.com', '5959 Walnut Ct', 'Virginia Beach', 'Nigeria');
--Insert into Person table(End)

--Create Patient table (insert 85 patients)
CREATE TABLE Patient(
	PatientId INT PRIMARY KEY,
	BloodGroup NVARCHAR(10),
	Genotype NVARCHAR(150),
	Allergies NVARCHAR(500),
	EmergencyContact NVARCHAR(150),
	EmeergencyPhone NVARCHAR(30),
	PersonId int
	Foreign key (PatientId) References Person(PersonId)
);
select * from Patient;

--Create Departments table(insert 20 departments
create table Department(
	DepartmentId int identity(1,1) primary key,
	Name nvarchar(100) not null,
	Description nvarchar(500),
	Location nvarchar(200)
);
select * from Department;

--Create Staff table(insert 15 staff)
create table Staff(
	StaffId int primary key,
	EmploymentDate date,
	Salary decimal(18,2),
	DepartmentId int,
	PersonId int,
	constraint FK_Staff_Persons
		foreign key (StaffId)
		references Person(PersonId),

	constraint FK_Staff_Departments
		foreign key (departmentID)
		references Department(DepartmentId)
);

drop table Department;