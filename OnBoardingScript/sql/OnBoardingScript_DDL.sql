
/* Drop Foreign Key Constraints */

USE [wizzio]
GO

/* Drop Tables */

IF EXISTS (SELECT * FROM dbo.sysobjects WHERE id = object_id('[SCRIPTS]') AND OBJECTPROPERTY(id, 'IsUserTable') = 1) 
DROP TABLE [SCRIPTS]
GO


/* Create Tables */

CREATE TABLE [SCRIPTS]
(
	[SCRIPT_ID] INT NOT NULL IDENTITY (1, 1),
	[SCRIPT_CODE] nvarchar(100) NOT NULL,
	[SCRIPT_TEMPLATE] varchar(MAX) NOT NULL,
	[ACTIVE] BIT NOT NULL,
	[CREATION_USER] nvarchar(50) NOT NULL,
	[CREATION_DATE] DATETIME,
	[UPDATE_USER] nvarchar(50) NOT NULL,
	[UPDATE_DATE] DATETIME
	
)
GO




/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE [SCRIPTS] 
 ADD CONSTRAINT [PK_SCRIPTS]
	PRIMARY KEY CLUSTERED ([SCRIPT_ID])
GO



