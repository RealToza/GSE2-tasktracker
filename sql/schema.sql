CREATE DATABASE TaskTrackerDB;
GO
USE TaskTrackerDB;
GO

CREATE TABLE Tasks (
    id INT IDENTITY(1,1) PRIMARY KEY,
    description NVARCHAR(255) NOT NULL,
    status NVARCHAR(50) NOT NULL
);
