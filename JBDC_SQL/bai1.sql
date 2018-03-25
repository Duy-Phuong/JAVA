create database QLSV1
go
use QLSV1
go
create table HocSinh(
MaHS int identity not null primary key,
TenHS nvarchar(50),
NgaySinh datetime,
GhiChu nvarchar(100), 
ExtInfo image
)
select * from HocSinh where MaHS = 2 and GhiChu = N'khá' and NgaySinh = '2018-03-19'
--insert into HocSinh values (
-- N'Nguyễn Văn Nam', '02/15/1997', N'Học sinh giỏi', null
--)

--insert into HocSinh values (
--'2', N'Nguyễn Văn Binh', '04/25/1997', 'Học sinh khá'
--)

--insert into HocSinh values (
--'3', N'Nguyễn Thị Hoa', '02/13/1997', 'Học sinh giỏi'
--)

--insert into HocSinh values (
--'4', N'Nguyễn Văn Chinh', '02/11/1997', 'Học sinh khá'
--)