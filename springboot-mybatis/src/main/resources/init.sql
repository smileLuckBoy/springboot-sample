-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `age` int(3) NOT NULL COMMENT '年龄',
  `sex` int(1) NOT NULL COMMENT '性别',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`(`name`, `age`, `sex`, `id_card`) VALUES
  ('张三', '10', '1', '111111111111111'),
  ('李四', '10', '0', '111111111111112'),
  ('王五', '10', '0', '111111111111113'),
  ('赵六', '10', '1', '111111111111114'),
  ('哈哈', '12', '1', '111111111111115');
