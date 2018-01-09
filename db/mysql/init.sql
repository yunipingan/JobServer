drop database zhaopin;

create database zhaopin;

use zhaopin;

create table seeker(
	id varchar(100) not null primary key comment 'openid',
	name varchar(20) comment '真实姓名' not null default '',
	birthday varchar(30) not null default '',
	sex enum('男','女'),
	telephone varchar(11) not null default '',
	email varchar(30) not null default '',
	avatarUrl varchar(500) not null default '',
	city varchar(10) not null default '',
	degree varchar(10) not null default '',
	hope_job varchar(20),
	electronic_resume varchar(100) not null default ''
);

create table company(
	c_id bigint(11) auto_increment primary key not null,
	c_name varchar(50) not null comment '全称',
	c_name_short varchar(20) not null comment '简称',
	scale varchar(20) not null,
	financing_stage varchar(20) not null,
	address varchar(100) not null,
	c_city varchar(10) not null,
	c_district varchar(10) comment '区县',
	field varchar(20)  not null,
	description varchar(500) not null default '',
	longitude varchar(40) not null default '' comment '经度',
	latitude varchar(40) not null default '' comment '纬度',
	logo  varchar(200) comment '小图',
	poster  varchar(200) comment '大图'
);

create table hr(
	id varchar(100) not null primary key comment 'openid',
	name varchar(20) comment '真实姓名',
	birthday varchar(30),
	company_id bigint(11),
	company varchar(20),
	job varchar(20),
	telephone varchar(11),
	email varchar(30),
	avatarUrl varchar(100),
	sex enum('男','女'),
	foreign key(company_id) references company(c_id)
);

create table resume(
	id bigint(11) auto_increment primary key not null,
	name varchar(50),
	seeker_id varchar(100) not null,
	selfAssessment varchar(500),
	report_card_url varchar(100),
	foreign key(seeker_id) references seeker(id)
);

create table hope(
	id bigint(11) auto_increment primary key not null,
	resume_id bigint(11) not null,
	job varchar(20),
	type varchar(20),
	city varchar(10),
	salary varchar(30),
	description varchar(500),
	foreign key(resume_id) references resume(id)
);

create table education(
	id bigint(11) auto_increment primary key not null,
	resume_id bigint(11) not null,
	school varchar(20) not null,
	major varchar(20) not null,
	graduation_year varchar(10) not null,
	degree varchar(6) not null,
	 foreign key(resume_id) references resume(id)
);

create table intership(
	id bigint(11) auto_increment primary key not null,
	resume_id bigint(11) not null,
	company varchar(50) not null,
	job varchar(20) not null,
	start_date varchar(20) not null,
	end_date varchar(20) not null,
	description varchar(500),
	foreign key(resume_id) references resume(id)
);

create table project(
	id bigint(11) auto_increment primary key not null,
	resume_id bigint(11) not null,
	name varchar(50) not null,
	duty varchar(20) not null,
	url varchar(100),
	start_date varchar(20) not null,
	end_date varchar(20) not null,
	description varchar(500),
	foreign key(resume_id) references resume(id)
);

create table honor(
	id bigint(11) auto_increment primary key not null,
	resume_id bigint(11) not null,
	date varchar(20) not null,
	name varchar(50) not null,
	prize varchar(10) not null,
	foreign key(resume_id) references resume(id)
);

create table job(
	j_id bigint(11) auto_increment primary key not null,
	j_name varchar(50) not null,
	salary_lower int not null,
	salary_upper int not null,
	status boolean not null default 1 comment '职位状态',
	workplace varchar(100) not null comment '详细地址',
	j_city varchar(20) not null,
	j_district varchar(20),
	degree_limit varchar(10) not null,
	welfare varchar(100),
	type varchar(20),
	company_id bigint(11),
	hr_id varchar(100),
	release_date varchar(50) not null,
	job_search varchar(2000) not null comment '包含name company job_duty job_skill',
	foreign key(hr_id) references hr(id),
	foreign key(company_id) references company(c_id)
);

create table job_duty(
	id bigint(11) auto_increment primary key not null,
	job_id bigint(11) not null,
	description varchar(100) not null,
	foreign key(job_id) references job(j_id)
);

create table job_skill(
	id bigint(11) auto_increment primary key not null,
	job_id bigint(11) not null,
	description varchar(100) not null,
	foreign key(job_id) references job(j_id)
);

create table campus_talk(
	id bigint(11) auto_increment primary key not null,
	job_id bigint(11) not null,
	school varchar(50) not null,
	date_time varchar(50) not null,
	foreign key(job_id) references job(j_id)
);

create table config(
	seeker_id varchar(100) not null primary key,
	resume_open boolean default 1,
	default_send_open boolean default 0,
	email_accept_open boolean default 1,
	sms_accept_open boolean default 1,
	foreign key(seeker_id) references seeker(id)
);

create table resume_deliver_status(
	rds_id bigint(11) auto_increment primary key not null,
	job_id bigint(11) not null,
	seeker_id varchar(50) not null,
	resume_id bigint(11) not null comment '简历投递的id',
	deliver_date_time varchar(50) not null comment '简历投递的时间',
	reject_date_time varchar(50) comment '企业判定为不合适简历的时间 插入时要将status改为不合适 seeker_read改为未读',
	read_date_time varchar(50) comment '企业查看该简历时的时间，插入值后要将status改为待沟通 seeker_read改为未读',
	interview_date_time varchar(50) comment '企业邀请面试时的时间，插入值后要将status改为面试 seeker_read改为未读 并且在table interview 中插入一条新数据',
	status enum('未查看','待沟通','面试','不合适') not null default '未查看',
	seeker_read boolean not null default 0 comment '投递者是否已读',
	hr_read boolean not null default 0 comment 'hr是否已读 在发出面试邀请后 seeker方可能同意也可能拒绝',
	foreign key(job_id) references job(j_id),
	foreign key(resume_id) references resume(id),
	foreign key(seeker_id) references seeker(id)
);

create table interview(
	id bigint(11) auto_increment primary key not null,
	job_id bigint(11) not null,
	seeker_id varchar(50) not null,
	interview_date_time varchar(50) not null comment '面试时间',
	set_interview_end_date_time varchar(50) comment '面试结束后，hr设置面试者已经来面试了或者没有来参加面试的时间',
	interview_flag enum('面试结束','没有参加') comment 'hr设置的结果,设置后要将seeker_read设置为false',
	seeker_read boolean not null default 0 comment 'seeker是否已读',
	set_result_date_time varchar(20) comment 'hr判定面试结果的时间',
	result enum('通过','不通过') comment '面试结果 通过和不通过 都要修改seeker_read为false',
	i_address varchar(50) comment '面试地点',
	other varchar(200) comment '其他特殊说明,如邀请面试的场面话等',
	had_commented boolean not null default 0 comment '是否已经评价',
	foreign key(job_id) references job(j_id),
	foreign key(seeker_id) references seeker(id)
);

create table comment(
	id bigint(11) auto_increment primary key not null,
	job_id bigint(11) not null,
	seeker_id varchar(50) not null,
	interview_id bigint(11) not null,
	comment_date_time varchar(50) not null,
	content varchar(200) not null,
	hr_comment int not null default 3,
	detail_conform_comment int not null default 3,
	company_comment int not null default 3,
	anonymity boolean not null default 0,
	foreign key(job_id) references job(j_id),
	foreign key(interview_id) references interview(id),
	foreign key(seeker_id) references seeker(id)
);

create table job_invication(
	id bigint(11) auto_increment primary key not null,
	job_id bigint(11) not null,
	seeker_id varchar(50) not null,
	hr_id varchar(50) not null,
	invicate_date_time varchar(50) not null comment '企业发出邀请时的时间',
	result boolean comment '被邀请者处理后 同意或者拒绝 如果同意，企业可以进一步在intreview表中插入一条新数据',
	description varchar(500) not null,
	status enum('未处理','已处理') not null default '未处理',
	set_result_date_time varchar(30) comment '被邀请者处理的时间',
	seeker_read boolean not null default 0,
	hr_read boolean not null default 0,
	foreign key(job_id) references job(j_id),
	foreign key(seeker_id) references seeker(id),
	foreign key(hr_id) references hr(id)
);

create table resume_seen(
	id bigint(11) auto_increment primary key not null,
	seeker_id varchar(50) not null,
	hr_id varchar(50) not null,
	date_time varchar(50) not null,
	_read enum('true','false') not null default 'false',
	foreign key(seeker_id) references seeker(id),
	foreign key(hr_id) references hr(id)
);

create table collection(
	id bigint(11) auto_increment primary key not null,
	seeker_id varchar(50) not null,
	job_id bigint(11) not null,
	foreign key(seeker_id) references seeker(id),
	foreign key(job_id) references job(j_id)
);


-- insert into hr(id,name,birthday,company_id,job,telephone,avatarUrl,sex)
--  	values('openidhr','hr','',1,'','','','男');


-- INSERT INTO company(c_name_short,c_name,scale,financing_stage,address,province,c_city,c_district,FIELD,logo)
--   VALUES ('小赢理财','小赢理财','500-2000人','B轮','深圳南山区深湾一路3号红树西岸','广东省','深圳','南山区','金融','/resources/xiaoyinglicai.jpg');

-- INSERT INTO job(j_name,salary_lower,salary_upper,STATUS,workplace,j_city,j_district,degree_limit,TYPE,welfare,hr_id,company_id,job_search,release_date)
--  VALUES('前端开发工程师',10,15,1,'深圳南山区深湾一路3号红树西岸','深圳','南山区','本科','全职','双休，上升空间大','openidhr',8,'前端开发工程师','2017-03-30');

-- INSERT INTO resume_deliver_status(job_id,seeker_id,deliver_date_time)
-- VALUES (10,'oUE_60BwG0F_Dna5NIsSvFz_YlRQ','2017-03-25 10:10:00')

-- INSERT INTO job_invication(seeker_id,job_id,hr_id,invicate_date_time,description)
-- VALUES('oUE_60BwG0F_Dna5NIsSvFz_YlRQ',10,'openidhr','2017-03-25 10:10','asdas')

-- INSERT INTO interview (job_id,seeker_id,other,interview_date_time,i_address,interview_flag,set_interview_end_date_time)
--  VALUES (4,'oUE_60BwG0F_Dna5NIsSvFz_YlRQ','现场面试','2017-04-22 10:10:10','广东省深圳市南山区软件基地A栋0899号','面试结束','2017-04-02 10:10:10')



# insert into campus_talk(job_id ,school,date_time )values
# 	(27,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(28,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(29,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(30,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(31,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(32,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(33,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(34,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(35,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(36,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(37,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(38,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(39,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(40,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(41,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(42,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(43,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(44,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(45,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(46,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(47,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(48,'兰州大学','2017-05-28 14:20');
# insert into campus_talk(job_id ,school,date_time )values
# 	(49,'兰州大学','2017-05-28 14:20');












--  INSERT INTO job_skill(job_id,description)VALUES
-- (49,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (48,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (47,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (46,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (45,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (44,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (43,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (42,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (41,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (40,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (39,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (38,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (37,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (36,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (35,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (34,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (33,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (32,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (31,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (30,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (29,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (28,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');
-- INSERT INTO job_duty(job_id,description)VALUES
-- (27,'熟悉git、svn等版本控制工具，熟悉团队协作开发，有良好的沟通能力');


