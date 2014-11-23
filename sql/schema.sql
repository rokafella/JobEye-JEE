
drop table User;
drop table Task;
drop table Stage;
drop table Profile;
drop table Job;
drop table Company;
drop table Activity;
drop table Application;

create table User(userId long, name varchar(50), email varchar(50) UNIQUE, phone varchar(20), password varchar(50)); //Removed Bday
create table Task(taskId integer, timestamp datetime, description varchar(50), stageId integer, isStageDependent bit);
create table Stage(stageId integer, description varchar(50), stageType integer, applicationId integer);
create table Profile(profileId long, profileType varchar(50), userId long);
create table Job(jobId integer, companyId integer, position varchar(50), Location varchar(50));
create table Company(companyId integer, name varchar(50), headQuarters varchar(50), userId integer);
create table Activity(activityId integer, description varchar(50), title varchar(50), timestamp datetime, companyId integer);
create table Application(applicationId integer, jobId integer, profileId integer, status varchar(50));