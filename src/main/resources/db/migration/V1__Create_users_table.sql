CREATE TABLE USERS (
    ID INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    USERNAME VARCHAR(50) UNIQUE NOT NULL,
    NAME VARCHAR(100),
    PASSWORD VARCHAR(100) NOT NULL,
    MAIL VARCHAR(100),
    STATUS SMALLINT DEFAULT 0
);