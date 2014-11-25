
drop table User;
drop table Task;
drop table Stage;
drop table Profile;
drop table Job;
drop table Company;
drop table Activity;
drop table Application;

create table User(userId long, name varchar(50), email varchar(50) UNIQUE, phone varchar(20), password varchar(50));
create table Task(taskId integer, date date, description varchar(50), applicationId integer);
--create table Stage(stageId integer, description varchar(50), stageType varchar(30), applicationId integer);
create table Profile(profileId long, profileType varchar(50), userId long, primary key(profiletype,userid));
create table Job(jobId integer, companyId integer, position varchar(50), Location varchar(50));
create table Company(companyId integer, name varchar(50), headQuarters varchar(50), userId integer);
create table Activity(activityId integer, description varchar(50), title varchar(50), date date, companyId integer);
create table Application(applicationId integer, jobId integer, profileId integer, status varchar(50));

select * from activity;
select * from application;
select * from company;
select * from job;
select * from profile;
select * from stage;
select * from task;
select * from user;