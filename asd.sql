USE [master]
GO
/****** Object:  Database [OnlineQuiz]    Script Date: 17-Jun-21 2:44:47 PM ******/
CREATE DATABASE [OnlineQuiz]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OnlineQuiz', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.THSQLSERVER\MSSQL\DATA\OnlineQuiz.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'OnlineQuiz_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.THSQLSERVER\MSSQL\DATA\OnlineQuiz_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [OnlineQuiz] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnlineQuiz].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ARITHABORT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OnlineQuiz] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OnlineQuiz] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OnlineQuiz] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OnlineQuiz] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OnlineQuiz] SET  ENABLE_BROKER 
GO
ALTER DATABASE [OnlineQuiz] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OnlineQuiz] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OnlineQuiz] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OnlineQuiz] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OnlineQuiz] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OnlineQuiz] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OnlineQuiz] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OnlineQuiz] SET RECOVERY FULL 
GO
ALTER DATABASE [OnlineQuiz] SET  MULTI_USER 
GO
ALTER DATABASE [OnlineQuiz] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OnlineQuiz] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OnlineQuiz] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OnlineQuiz] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [OnlineQuiz] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'OnlineQuiz', N'ON'
GO
USE [OnlineQuiz]
GO
/****** Object:  Table [dbo].[FEATURE]    Script Date: 17-Jun-21 2:44:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FEATURE](
	[fid] [int] IDENTITY(1,1) NOT NULL,
	[fname] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[fid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[QUESTION]    Script Date: 17-Jun-21 2:44:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QUESTION](
	[question] [nvarchar](250) NULL,
	[option1] [nvarchar](250) NULL,
	[option2] [nvarchar](250) NULL,
	[option3] [nvarchar](250) NULL,
	[option4] [nvarchar](250) NULL,
	[correctAns] [nvarchar](150) NULL,
	[createdDate] [date] NULL,
	[owner] [nvarchar](150) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ROLE]    Script Date: 17-Jun-21 2:44:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ROLE](
	[rid] [int] IDENTITY(1,1) NOT NULL,
	[rname] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[rid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ROLE_FEATURE]    Script Date: 17-Jun-21 2:44:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ROLE_FEATURE](
	[rid] [int] NOT NULL,
	[fid] [int] NOT NULL,
 CONSTRAINT [PK_RF] PRIMARY KEY CLUSTERED 
(
	[rid] ASC,
	[fid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USER_ROLE]    Script Date: 17-Jun-21 2:44:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USER_ROLE](
	[username] [nvarchar](150) NOT NULL,
	[rid] [int] NOT NULL,
 CONSTRAINT [PK_UR] PRIMARY KEY CLUSTERED 
(
	[username] ASC,
	[rid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[USERS]    Script Date: 17-Jun-21 2:44:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERS](
	[userid] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](150) NULL,
	[pass] [nvarchar](150) NOT NULL,
	[email] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[FEATURE] ON 

INSERT [dbo].[FEATURE] ([fid], [fname]) VALUES (1, N'/takequiz')
INSERT [dbo].[FEATURE] ([fid], [fname]) VALUES (2, N'/manage')
INSERT [dbo].[FEATURE] ([fid], [fname]) VALUES (3, N'/makequiz')
INSERT [dbo].[FEATURE] ([fid], [fname]) VALUES (4, N'/welcome')
INSERT [dbo].[FEATURE] ([fid], [fname]) VALUES (5, N'/result')
INSERT [dbo].[FEATURE] ([fid], [fname]) VALUES (6, N'/doquiz')
SET IDENTITY_INSERT [dbo].[FEATURE] OFF
INSERT [dbo].[QUESTION] ([question], [option1], [option2], [option3], [option4], [correctAns], [createdDate], [owner]) VALUES (N'asd', N'asd', N'asd', N'asd', N'asd', N'2', CAST(N'2021-06-01' AS Date), N'tieuhoa')
INSERT [dbo].[QUESTION] ([question], [option1], [option2], [option3], [option4], [correctAns], [createdDate], [owner]) VALUES (N'1 + 1 = ? ', N'1 ', N'2 ', N'3 ', N'4 ', N'2', CAST(N'2021-06-01' AS Date), N'tieuhoa')
INSERT [dbo].[QUESTION] ([question], [option1], [option2], [option3], [option4], [correctAns], [createdDate], [owner]) VALUES (N'zxcv', N'qwezxcv', N'qwezxcv', N'zxcv', N'zxcv', N'3', CAST(N'2021-06-01' AS Date), N'tieuhoa')
SET IDENTITY_INSERT [dbo].[ROLE] ON 

INSERT [dbo].[ROLE] ([rid], [rname]) VALUES (1, N'Teacher')
INSERT [dbo].[ROLE] ([rid], [rname]) VALUES (2, N'Student')
SET IDENTITY_INSERT [dbo].[ROLE] OFF
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (1, 1)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (1, 2)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (1, 3)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (1, 4)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (1, 5)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (1, 6)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (2, 1)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (2, 4)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (2, 5)
INSERT [dbo].[ROLE_FEATURE] ([rid], [fid]) VALUES (2, 6)
INSERT [dbo].[USER_ROLE] ([username], [rid]) VALUES (N'test', 2)
INSERT [dbo].[USER_ROLE] ([username], [rid]) VALUES (N'tieuhoa', 1)
INSERT [dbo].[USER_ROLE] ([username], [rid]) VALUES (N'tieuhoa456', 2)
INSERT [dbo].[USER_ROLE] ([username], [rid]) VALUES (N'tieuhoaqwe', 2)
INSERT [dbo].[USER_ROLE] ([username], [rid]) VALUES (N'trunghoa2', 1)
INSERT [dbo].[USER_ROLE] ([username], [rid]) VALUES (N'vph', 2)
INSERT [dbo].[USER_ROLE] ([username], [rid]) VALUES (N'zxczxc', 2)
SET IDENTITY_INSERT [dbo].[USERS] ON 

INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (1, N'tieuhoa', N'tieuhoa', N'')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (2, N'Ã¡d', N'Ã¡d', N'Ã¡dasd')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (6, N'tieuhoa2', N'tieuhoa2', N'tieuhoa2')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (7, N'', N'', N'')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (14, N'tieuhoa3', N'tieuhoa3', N'tieuhoa3')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (15, N'tieuhoa4', N'tieuhoa4', N'tieuhoa4')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (16, N'asdt', N'asdt', N'asdt')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (18, N'tieuhoa5', N'tieuhoa5', N'tieuhoa5')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (22, N'tieuhoa123', N'tieuhoa123', N'tieuhoa123')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (23, N'tieuhoa456', N'tieuhoa456', N'tieuhoa456')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (24, N'zxczxc', N'zxczxc', N'zxczxc')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (25, N'tieuhoaqwe', N'tieuhoaqwe', N'tieuhoaqwe')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (26, N'trunghoa', N'trunghoa', N'trunghoa')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (27, N'trunghoa2', N'trunghoa2', N'trunghoa2')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (28, N'vph', N'vph', N'vph')
INSERT [dbo].[USERS] ([userid], [username], [pass], [email]) VALUES (29, N'test', N'test', N'test')
SET IDENTITY_INSERT [dbo].[USERS] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__QUESTION__9AA2C3BE0CD0DCF3]    Script Date: 17-Jun-21 2:44:47 PM ******/
ALTER TABLE [dbo].[QUESTION] ADD UNIQUE NONCLUSTERED 
(
	[question] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__USERS__F3DBC57242415612]    Script Date: 17-Jun-21 2:44:47 PM ******/
ALTER TABLE [dbo].[USERS] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[QUESTION]  WITH CHECK ADD  CONSTRAINT [FK_OWNER] FOREIGN KEY([owner])
REFERENCES [dbo].[USERS] ([username])
GO
ALTER TABLE [dbo].[QUESTION] CHECK CONSTRAINT [FK_OWNER]
GO
ALTER TABLE [dbo].[ROLE_FEATURE]  WITH CHECK ADD FOREIGN KEY([fid])
REFERENCES [dbo].[FEATURE] ([fid])
GO
ALTER TABLE [dbo].[ROLE_FEATURE]  WITH CHECK ADD FOREIGN KEY([rid])
REFERENCES [dbo].[ROLE] ([rid])
GO
ALTER TABLE [dbo].[USER_ROLE]  WITH CHECK ADD FOREIGN KEY([rid])
REFERENCES [dbo].[ROLE] ([rid])
GO
ALTER TABLE [dbo].[USER_ROLE]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[USERS] ([username])
GO
USE [master]
GO
ALTER DATABASE [OnlineQuiz] SET  READ_WRITE 
GO
