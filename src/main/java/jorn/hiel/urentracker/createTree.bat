@echo off
@echo .

echo **
echo Creating tree structure
echo **
echo creating service tree
md "service/dto"
md "service/mapper"
md "service/managers"
echo **
echo creating business tree
for %%a in ("%cd%") do set "CurDir1=%%~na"
cd..
for %%a in ("%cd%") do set "CurDir2=%%~na"
cd..
for %%a in ("%cd%") do set "CurDir3=%%~na"
cd  %CurDir2%/%CurDir1%
md "business/entities"
cd business/entities
del BaseEntity.Java /Q
echo **
echo creating BaseEntity.Java

echo. package %CurDir3%.%CurDir2%.%CurDir1%.business.entities;>>BaseEntity.java
echo. >>BaseEntity.java
echo. import lombok.Setter;>>BaseEntity.java
echo. import lombok.Getter;>>BaseEntity.java
echo. import javax.persistence.GeneratedValue;>>BaseEntity.java
echo. import javax.persistence.Id;>>BaseEntity.java
echo. import javax.persistence.MappedSuperclass;>>BaseEntity.java
echo. import javax.persistence.Version;>>BaseEntity.java
echo. >>BaseEntity.java
echo. >>BaseEntity.java
echo. @MappedSuperclass>>BaseEntity.java
echo. @Getter @Setter>>BaseEntity.java
echo. public class BaseEntity {>>BaseEntity.java
echo. >>BaseEntity.java
echo.     @Id>>BaseEntity.java
echo.     @GeneratedValue>>BaseEntity.java
echo.     private Long id;>>BaseEntity.java
echo. >>BaseEntity.java
echo.     @Version>>BaseEntity.java
echo.     private Integer version;>>BaseEntity.java
echo.
echo. }>>BaseEntity.java
cd ..
cd ..
md "business/implementations"
echo **
echo creating general tree
md "general/interfaces"
echo **
echo creating repo tree
md "repository/interfaces"
echo **
echo creating frontend tree
md "frontend/views"
md "frontend/controllers"
