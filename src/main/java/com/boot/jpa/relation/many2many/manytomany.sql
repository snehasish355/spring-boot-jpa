
CREATE TABLE PROGRAMMER(
ID SERIAL PRIMARY KEY,
NAME VARCHAR(20),
SALARY INT
);

CREATE TABLE PROJECT(
ID SERIAL PRIMARY KEY,
NAME VARCHAR(20)
);

CREATE TABLE PROGRAMMERS_PROJECTS(
PROGRAMMER_ID INT,
PROJECT_ID INT,
FOREIGN KEY (PROGRAMMER_ID)
REFERENCES PROGRAMMER(ID),
FOREIGN KEY (PROJECT_ID)
REFERENCES PROJECT(ID)
);

SELECT * FROM PROGRAMMER;
SELECT * FROM PROJECT;
SELECT * FROM PROGRAMMERS_PROJECTS;