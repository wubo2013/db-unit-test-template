drop table if exists `t_student`;
CREATE TABLE `t_student` (
	`tname` varchar (600),
	`cname` varchar (600),
	`id` int(10) auto_increment
);

drop table if exists `t_teacher`;
CREATE TABLE IF NOT EXISTS `t_teacher` (
	`tname` varchar (600),
	`cname` varchar (600),
	`edu` varchar (600),
	`id` int(10) auto_increment
);

