/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : submit_project

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-05-29 19:10:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` varchar(16) NOT NULL COMMENT '管理员账号',
  `password` varchar(16) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('root', 'nyist');

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classid` bigint(20) NOT NULL COMMENT '班级编号',
  `classname` varchar(30) NOT NULL COMMENT '班级名称',
  `classcount` int(11) NOT NULL COMMENT '班级总人数',
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '软件设计一班', '42');
INSERT INTO `class` VALUES ('2', '软件设计二班', '43');
INSERT INTO `class` VALUES ('3', '软件设计三班', '42');

-- ----------------------------
-- Table structure for `cla_ope`
-- ----------------------------
DROP TABLE IF EXISTS `cla_ope`;
CREATE TABLE `cla_ope` (
  `classid` bigint(20) NOT NULL COMMENT '班级id',
  `opid` varchar(32) NOT NULL COMMENT '题目id',
  PRIMARY KEY (`classid`,`opid`),
  KEY `opid` (`opid`),
  CONSTRAINT `cla_ope_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cla_ope_ibfk_2` FOREIGN KEY (`opid`) REFERENCES `operation` (`opid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cla_ope
-- ----------------------------
INSERT INTO `cla_ope` VALUES ('1', '1');
INSERT INTO `cla_ope` VALUES ('2', '10');
INSERT INTO `cla_ope` VALUES ('2', '11');
INSERT INTO `cla_ope` VALUES ('2', '12');
INSERT INTO `cla_ope` VALUES ('3', '13');
INSERT INTO `cla_ope` VALUES ('3', '14');
INSERT INTO `cla_ope` VALUES ('3', '15');
INSERT INTO `cla_ope` VALUES ('1', '2');
INSERT INTO `cla_ope` VALUES ('1', '3');
INSERT INTO `cla_ope` VALUES ('1', '4');
INSERT INTO `cla_ope` VALUES ('1', '5');
INSERT INTO `cla_ope` VALUES ('3', '5');
INSERT INTO `cla_ope` VALUES ('1', '6');
INSERT INTO `cla_ope` VALUES ('3', '6');
INSERT INTO `cla_ope` VALUES ('2', '7');
INSERT INTO `cla_ope` VALUES ('3', '7');
INSERT INTO `cla_ope` VALUES ('2', '8');
INSERT INTO `cla_ope` VALUES ('2', '9');

-- ----------------------------
-- Table structure for `opeadio`
-- ----------------------------
DROP TABLE IF EXISTS `opeadio`;
CREATE TABLE `opeadio` (
  `opid` varchar(32) NOT NULL,
  `src` varchar(50) NOT NULL,
  PRIMARY KEY (`opid`,`src`),
  CONSTRAINT `adio` FOREIGN KEY (`opid`) REFERENCES `operation` (`opid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opeadio
-- ----------------------------
INSERT INTO `opeadio` VALUES ('13', 'as526324dfgtr14523dd4f1d5wq6e4r9.mp4');

-- ----------------------------
-- Table structure for `operation`
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `opid` varchar(32) NOT NULL COMMENT '题目ID',
  `optop` varchar(100) NOT NULL COMMENT '题目',
  `optext` text NOT NULL COMMENT '内容',
  `opsubid` varchar(32) NOT NULL COMMENT '科目ID',
  `opstoptime` date NOT NULL,
  PRIMARY KEY (`opid`),
  KEY `opration_ibfk_1` (`opsubid`),
  CONSTRAINT `operation_ibfk_1` FOREIGN KEY (`opsubid`) REFERENCES `subject` (`subid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES ('1', '斐波那契数列', '写一个斐波那契数列的Java程序', '2', '2018-12-13');
INSERT INTO `operation` VALUES ('10', 'Java', '实现商城登陆系统', '1', '2018-08-09');
INSERT INTO `operation` VALUES ('11', 'Linux', '掌握linux基本知识点', '5', '2018-08-09');
INSERT INTO `operation` VALUES ('12', 'python', '用python爬取页面数据', '6', '2018-08-23');
INSERT INTO `operation` VALUES ('13', 'python', '用python实现一个小程序', '3', '2018-08-02');
INSERT INTO `operation` VALUES ('14', '贪吃蛇', '使用C#完成程序的使用', '4', '2018-09-18');
INSERT INTO `operation` VALUES ('15', '2048小游戏', '使用C#完成2048小游戏，无具体的作业要求', '4', '2018-09-17');
INSERT INTO `operation` VALUES ('2', '冒泡排序', '用C++语言写出冒泡排序', '2', '2018-10-13');
INSERT INTO `operation` VALUES ('3', '插入排序', '用Java写一个插入排序', '1', '2018-08-26');
INSERT INTO `operation` VALUES ('4', 'mysql', '安装mysql数据库', '3', '2018-08-31');
INSERT INTO `operation` VALUES ('5', '二叉树', '写出二叉树的实现原理', '6', '2018-08-22');
INSERT INTO `operation` VALUES ('6', '写一个前端页面', '必须包括7个以上老师所教知识点', '5', '2018-08-17');
INSERT INTO `operation` VALUES ('7', 'VC++计算器', '用VC++实现一个计算器基本功能', '6', '2018-08-15');
INSERT INTO `operation` VALUES ('8', '表单验证', '用老师所教知识点实现表单验证', '3', '2018-08-23');
INSERT INTO `operation` VALUES ('9', '大数据', '实现爬虫', '2', '2018-08-16');

-- ----------------------------
-- Table structure for `opration`
-- ----------------------------
DROP TABLE IF EXISTS `opration`;
CREATE TABLE `opration` (
  `opid` varchar(32) NOT NULL COMMENT '题目ID',
  `optop` varchar(100) NOT NULL COMMENT '题目',
  `optext` text NOT NULL COMMENT '内容',
  `opsubid` varchar(32) NOT NULL COMMENT '科目ID',
  `opclassid` bigint(20) NOT NULL COMMENT '班级ID',
  `opstarttime` time NOT NULL COMMENT '开始时间',
  `opstoptime` time NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`opid`),
  KEY `opsubid` (`opsubid`),
  KEY `opclassid` (`opclassid`),
  CONSTRAINT `opration_ibfk_1` FOREIGN KEY (`opsubid`) REFERENCES `subject` (`subid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `opration_ibfk_2` FOREIGN KEY (`opclassid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opration
-- ----------------------------

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `reid` varchar(32) NOT NULL COMMENT '学生提交答案的编号',
  `rsno` bigint(20) NOT NULL COMMENT '学生的学号',
  `opid` varchar(32) NOT NULL COMMENT '对应的题目的id',
  `retext` text NOT NULL COMMENT '学生提交的答案的内容',
  `reurl` varchar(50) DEFAULT NULL,
  `rescore` int(11) DEFAULT NULL COMMENT '最终评分',
  PRIMARY KEY (`reid`),
  KEY `rsno` (`rsno`),
  KEY `opid` (`opid`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`rsno`) REFERENCES `student` (`sno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`opid`) REFERENCES `operation` (`opid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '1615925233', '13', '使用Python完成小程序，我是真的一点都不会，你知道吗？放到以前我肯定害怕我什么都不会，但是现在我不怕，你知道为什么吗?因为你现在时测试数据，没什么卵用，怂啥，不怕。', null, '99');
INSERT INTO `result` VALUES ('47538ed8a0c64778817502d0f34607f8', '1615925258', '2', '<div class=\"para\" label-module=\"para\">冒泡排序（Bubble Sort），是一种<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6\">计算机科学</a>领域的较简单的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95/5399605\" data-lemmaid=\"5399605\">排序算法</a>。</div><div class=\"para\" label-module=\"para\">它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来。走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素已经排序完成。</div><div class=\"para\" label-module=\"para\">这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端（升序或降序排列），就如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”。</div>', null, null);
INSERT INTO `result` VALUES ('4a23ac0381b546e2be9d35c5e81a31e9', '1615925258', '3', '<div class=\"para\" label-module=\"para\">有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，但要求插入后此数据序列仍然有序，这个时候就要用到一种新的排序方法——<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F%E6%B3%95/612261\" data-lemmaid=\"612261\">插入排序法</a>,插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%97%B6%E9%97%B4%E5%A4%8D%E6%9D%82%E5%BA%A6/1894057\" data-lemmaid=\"1894057\">时间复杂度</a>为O(n^2)。是稳定的排序方法。插入算法把要排序的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%95%B0%E7%BB%84/3794097\" data-lemmaid=\"3794097\">数组</a>分成两部分：第一部分包含了这个数组的所有元素，但将最后一个元素除外（让数组多一个空间才有插入的位置），而第二部分就只包含这一个元素（即待插入元素）。在第一部分排序完成后，再将这个最后元素插入到已排好序的第一部分中。</div><div class=\"para\" label-module=\"para\">插入排序的基本思想是：每步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。</div>', null, null);
INSERT INTO `result` VALUES ('a345531683b343988ebb6ca3d81fa8e9', '1615925233', '14', '<p>贪吃蛇一款益智类的小游戏，主要适用于儿童青少年的小游戏，已经推广受到广大儿童朋友和青少年朋友的喜爱，更是受到广大母亲的推崇。</p><p>11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111222222222222222222</p><p>33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333</p>', null, null);
INSERT INTO `result` VALUES ('c1fcd5957555435ebd994c2e4804e735', '1615925257', '1', '<div class=\"para\" label-module=\"para\">若文件的初始状态是正序的，一趟扫描即可完成排序。所需的关键字比较次数和记录移动次数均达到最小值：所以，冒泡排序最好的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%97%B6%E9%97%B4%E5%A4%8D%E6%9D%82%E5%BA%A6\">时间复杂度</a>为。若初始文件是反序的，需要进趟排序。每趟排序要进行</div><div class=\"para\" label-module=\"para\">次关键字的比较(1≤i≤n-1)，且每次比较都必须移动记录三次来达到交换记录位置。在这种情况下，比较和移动次数均达到最大值：</div><div class=\"para\" label-module=\"para\">冒泡排序的最坏时间复杂度为。</div><div class=\"para\" label-module=\"para\">综上，因此冒泡排序总的平均时间复杂度为。</div>', null, null);
INSERT INTO `result` VALUES ('c48c2b1a425c4d13a47f087b49775120', '1615925257', '2', '<div class=\"para\" label-module=\"para\">根据排序过程中涉及的存储器不同，可以将排序方法分为两大类：一类是内部排序，指的是待排序的几率存放在计算机随机存储器中进行的排序过程；另一类的外部排序，指的是排序中要对外存储器进行访问的排序过程。</div><div class=\"para\" label-module=\"para\">内部排序是排序的基础，在内部排序中，根据排序过程中所依据的原则可以将它们分为5类：插入排序、交换排序、选择排序、归并排序和基数排序；根据排序过程的时间复杂度来分，可以分为三类：简单排序、先进排序、基数排序。</div><div class=\"para\" label-module=\"para\">评价排序算法优劣的标准主要是两条：一是算法的运算量，这主要是通过记录的比较次数和移动次数来反应；另一个是执行算法所需要的附加存储单元的的多少。</div>', null, null);
INSERT INTO `result` VALUES ('d72a3c896732441aab951e7d3e446b6e', '1615925258', '1', '<div class=\"para\" label-module=\"para\">冒泡排序（Bubble Sort），是一种<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6\">计算机科学</a>领域的较简单的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95/5399605\" data-lemmaid=\"5399605\">排序算法</a>。</div><div class=\"para\" label-module=\"para\">它重复地走访过要排序的元素列，依次比较两个相邻的元素，如果他们的顺序（如从大到小、首字母从A到Z）错误就把他们交换过来。走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素已经排序完成。</div><div class=\"para\" label-module=\"para\">这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端（升序或降序排列），就如同碳酸饮料中二氧化碳的气泡最终会上浮到顶端一样，故名“冒泡排序”。</div>', null, null);

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` bigint(20) NOT NULL COMMENT '学号',
  `sname` varchar(10) NOT NULL COMMENT '学生姓名',
  `sclassid` bigint(20) NOT NULL COMMENT '所在班级',
  `ssex` char(2) NOT NULL COMMENT '学生性别',
  `college` varchar(30) NOT NULL COMMENT '所在学院',
  `profession` varchar(30) NOT NULL COMMENT '专业',
  `stel` varchar(11) NOT NULL COMMENT '联系方式',
  `spic` varchar(50) NOT NULL COMMENT '照片所在路径',
  PRIMARY KEY (`sno`),
  KEY `sclassid` (`sclassid`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`sclassid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('161592522', '小舞', '3', '女', '软件学院', '软件设计', '12365987414', '//');
INSERT INTO `student` VALUES ('1615925210', '柳二龙', '2', '女', '软件学院', '软件设计', '78965412365', '//');
INSERT INTO `student` VALUES ('1615925211', '玉小刚', '2', '男', '软件学院', '软件设计', '14785159641', '//');
INSERT INTO `student` VALUES ('1615925212', '唐昊', '2', '男', '软件学院', '软件设计', '16159252333', '//');
INSERT INTO `student` VALUES ('1615925213', '唐啸', '2', '男', '软件学院', '软件设计', '16159252131', '//');
INSERT INTO `student` VALUES ('1615925214', '独孤羽', '2', '女', '软件学院', '软件设计', '16159252145', '//');
INSERT INTO `student` VALUES ('1615925215', '胡列娜', '2', '女', '软件学院', '软件设计', '16159252156', '//');
INSERT INTO `student` VALUES ('1615925220', '唐三', '3', '男', '软件学院', '软件设计', '12365414785', '//');
INSERT INTO `student` VALUES ('1615925221', '戴沐白', '3', '男', '软件学院', '软件设计', '12365214563', '//');
INSERT INTO `student` VALUES ('1615925223', '朱竹清', '3', '女', '软件学院', '软件设计', '12365478965', '//');
INSERT INTO `student` VALUES ('1615925224', '宁荣荣', '3', '女', '软件学院', '软件设计', '78965412365', '//');
INSERT INTO `student` VALUES ('1615925225', '奥斯卡', '3', '男', '软件学院', '软件设计', '12365478563', '//');
INSERT INTO `student` VALUES ('1615925226', '马红俊', '3', '男', '软件学院', '软件设计', '1236541478', '//');
INSERT INTO `student` VALUES ('1615925227', '白沉香', '3', '女', '软件学院', '软件设计', '12365478965', '//');
INSERT INTO `student` VALUES ('1615925228', '弗兰德', '3', '男', '软件学院', '软件设计', '12365474102', '//');
INSERT INTO `student` VALUES ('1615925229', '赵无极', '3', '男', '软件学院', '软件设计', '12332112332', '//');
INSERT INTO `student` VALUES ('1615925230', '江澄', '3', '男', '软件学院', '软件设计', '12345695124', 'a2828b58b3ef482aa6082ef72bc6da47.png');
INSERT INTO `student` VALUES ('1615925231', '魏无羡', '3', '男', '软件学院', '软件设计', '12345678998', '//');
INSERT INTO `student` VALUES ('1615925232', '江厌离', '3', '男', '软件学院', '软件设计', '12345678998', '9295a4c5d9f34cfcab722d7465ce72c6.jpg');
INSERT INTO `student` VALUES ('1615925233', '刘华龙', '3', '男', '软件学院', '软件设计', '13503874124', '141a6eaeb2ae431d92ca8852e89153af.jpg');
INSERT INTO `student` VALUES ('1615925234', '蓝启仁', '3', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925235', '蓝湛', '3', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925236', '蓝曦臣', '3', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925237', '江枫眠', '3', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925238', '聂怀桑', '3', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925239', '聂明玦', '3', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925240', '蓝思追', '2', '女', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925241', '蓝景仪', '2', '女', '软件学院', '软件设计', '12345665214', '430c582e34c64b4aa6b070b3d9cf665a.jpg');
INSERT INTO `student` VALUES ('1615925242', '蓝愿', '2', '女', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925243', '温宁', '2', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925244', '温情', '2', '女', '软件学院', '软件设计', '12345678914', '//');
INSERT INTO `student` VALUES ('1615925245', '温晁', '2', '男', '软件学院', '软件设计', '12345665214', '//');
INSERT INTO `student` VALUES ('1615925246', '王灵娇', '2', '女', '软件学院', '软件设计', '12345665214', 'c277e860bece4eef9523359850b40012.jpg');
INSERT INTO `student` VALUES ('1615925247', '绵绵', '2', '女', '软件学院', '软件设计', '12345665214', '8437387847c747a189a4c4664950a4d8.jpg');
INSERT INTO `student` VALUES ('1615925248', '阿菁', '2', '女', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925249', '秦愫', '2', '女', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925250', '金凌', '1', '男', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925251', '金光瑶', '1', '男', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925252', '金光善', '1', '男', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925253', '金子轩', '1', '男', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925254', '温若寒', '1', '男', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925255', '温逐流', '1', '男', '软件学院', '软件设计', '14785236987', '//');
INSERT INTO `student` VALUES ('1615925256', '宋岚', '1', '男', '软件学院', '软件设计', '14785236987', 'd6840c7c48b04053914f8005915bddba.jpg');
INSERT INTO `student` VALUES ('1615925257', '晓星尘', '1', '男', '软件学院', '软件设计', '14785236987', '9bda64235f82484faabfbd5354115556.jpg');
INSERT INTO `student` VALUES ('1615925258', '薛洋', '1', '男', '软件学院', '软件设计', '14785236987', 'f7453296da2e4302a496c3bccf64ec8f.jpg');
INSERT INTO `student` VALUES ('1615925259', '王艳豪', '1', '男', '软件学院', '软件设计', '14785236987', '282631e481fc44248c33a43606aa65d0.jpg');

-- ----------------------------
-- Table structure for `student_account`
-- ----------------------------
DROP TABLE IF EXISTS `student_account`;
CREATE TABLE `student_account` (
  `password` varchar(15) NOT NULL,
  `sno` bigint(20) NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_account
-- ----------------------------
INSERT INTO `student_account` VALUES ('1615925230', '1615925230');
INSERT INTO `student_account` VALUES ('1615925231', '1615925231');
INSERT INTO `student_account` VALUES ('1615925232', '1615925232');
INSERT INTO `student_account` VALUES ('1234', '1615925233');
INSERT INTO `student_account` VALUES ('1615925234', '1615925234');
INSERT INTO `student_account` VALUES ('1615925235', '1615925235');
INSERT INTO `student_account` VALUES ('1615925236', '1615925236');
INSERT INTO `student_account` VALUES ('1615925237', '1615925237');
INSERT INTO `student_account` VALUES ('1615925238', '1615925238');
INSERT INTO `student_account` VALUES ('1615925239', '1615925239');
INSERT INTO `student_account` VALUES ('1615925240', '1615925240');
INSERT INTO `student_account` VALUES ('1615925241', '1615925241');
INSERT INTO `student_account` VALUES ('1615925242', '1615925242');
INSERT INTO `student_account` VALUES ('1615925243', '1615925243');
INSERT INTO `student_account` VALUES ('1615925244', '1615925244');
INSERT INTO `student_account` VALUES ('1615925245', '1615925245');
INSERT INTO `student_account` VALUES ('1615925246', '1615925246');
INSERT INTO `student_account` VALUES ('1615925247', '1615925247');
INSERT INTO `student_account` VALUES ('1615925248', '1615925248');
INSERT INTO `student_account` VALUES ('1615925249', '1615925249');
INSERT INTO `student_account` VALUES ('1615925250', '1615925250');
INSERT INTO `student_account` VALUES ('1615925251', '1615925251');
INSERT INTO `student_account` VALUES ('1615925252', '1615925252');
INSERT INTO `student_account` VALUES ('1615925253', '1615925253');
INSERT INTO `student_account` VALUES ('1615925254', '1615925254');
INSERT INTO `student_account` VALUES ('1615925255', '1615925255');
INSERT INTO `student_account` VALUES ('1615925256', '1615925256');
INSERT INTO `student_account` VALUES ('1615925257', '1615925257');
INSERT INTO `student_account` VALUES ('1615925258', '1615925258');
INSERT INTO `student_account` VALUES ('1615925259', '1615925259');

-- ----------------------------
-- Table structure for `stu_class`
-- ----------------------------
DROP TABLE IF EXISTS `stu_class`;
CREATE TABLE `stu_class` (
  `sno` bigint(20) NOT NULL COMMENT '学号',
  `classid` bigint(20) NOT NULL COMMENT '班级',
  PRIMARY KEY (`sno`),
  KEY `classid` (`classid`),
  CONSTRAINT `stu_class_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_class
-- ----------------------------
INSERT INTO `stu_class` VALUES ('1615925250', '1');
INSERT INTO `stu_class` VALUES ('1615925251', '1');
INSERT INTO `stu_class` VALUES ('1615925252', '1');
INSERT INTO `stu_class` VALUES ('1615925253', '1');
INSERT INTO `stu_class` VALUES ('1615925254', '1');
INSERT INTO `stu_class` VALUES ('1615925255', '1');
INSERT INTO `stu_class` VALUES ('1615925256', '1');
INSERT INTO `stu_class` VALUES ('1615925257', '1');
INSERT INTO `stu_class` VALUES ('1615925258', '1');
INSERT INTO `stu_class` VALUES ('1615925259', '1');
INSERT INTO `stu_class` VALUES ('1615925240', '2');
INSERT INTO `stu_class` VALUES ('1615925241', '2');
INSERT INTO `stu_class` VALUES ('1615925242', '2');
INSERT INTO `stu_class` VALUES ('1615925243', '2');
INSERT INTO `stu_class` VALUES ('1615925244', '2');
INSERT INTO `stu_class` VALUES ('1615925245', '2');
INSERT INTO `stu_class` VALUES ('1615925246', '2');
INSERT INTO `stu_class` VALUES ('1615925247', '2');
INSERT INTO `stu_class` VALUES ('1615925248', '2');
INSERT INTO `stu_class` VALUES ('1615925249', '2');
INSERT INTO `stu_class` VALUES ('1615925230', '3');
INSERT INTO `stu_class` VALUES ('1615925231', '3');
INSERT INTO `stu_class` VALUES ('1615925232', '3');
INSERT INTO `stu_class` VALUES ('1615925233', '3');
INSERT INTO `stu_class` VALUES ('1615925234', '3');
INSERT INTO `stu_class` VALUES ('1615925235', '3');
INSERT INTO `stu_class` VALUES ('1615925236', '3');
INSERT INTO `stu_class` VALUES ('1615925237', '3');
INSERT INTO `stu_class` VALUES ('1615925238', '3');
INSERT INTO `stu_class` VALUES ('1615925239', '3');

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subid` varchar(15) NOT NULL COMMENT '科目编号',
  `subname` varchar(30) DEFAULT NULL COMMENT '科目名称',
  PRIMARY KEY (`subid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', 'java');
INSERT INTO `subject` VALUES ('2', 'C++');
INSERT INTO `subject` VALUES ('3', 'python');
INSERT INTO `subject` VALUES ('4', 'C#');
INSERT INTO `subject` VALUES ('5', '前端');
INSERT INTO `subject` VALUES ('6', 'PHP');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `Tno` bigint(20) NOT NULL COMMENT '教师编号',
  `Tname` varchar(10) NOT NULL COMMENT '教师姓名',
  `Tsex` varchar(2) NOT NULL COMMENT '教师性别',
  `Tsubject` varchar(32) NOT NULL COMMENT '所教科目',
  `Ttel` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `Tpic` varchar(50) DEFAULT NULL COMMENT '教师照片所在路径',
  PRIMARY KEY (`Tno`),
  KEY `teacher_ibfk_1` (`Tsubject`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`Tsubject`) REFERENCES `subject` (`subid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '张建', '男', '2', '13123456789', '测试');
INSERT INTO `teacher` VALUES ('2', '李雷', '男', '1', '13112345678', '1a02dce8-3ea1-456c-9d12-d44d4287f5b8.jpg');
INSERT INTO `teacher` VALUES ('3', '张小雅', '女', '4', '13166668888', '486f81a8-b9a3-4246-ad12-5ba20a75c9e6.jpg');
INSERT INTO `teacher` VALUES ('4', '李倩', '女', '5', '13177779999', '测试');
INSERT INTO `teacher` VALUES ('5', '张春雷', '男', '6', '13155554444', '测试');
INSERT INTO `teacher` VALUES ('6', '魏倩雅', '女', '3', '13188887777', '测试');

-- ----------------------------
-- Table structure for `teacher_account`
-- ----------------------------
DROP TABLE IF EXISTS `teacher_account`;
CREATE TABLE `teacher_account` (
  `Tno` bigint(20) NOT NULL COMMENT '编号为教师编号',
  `password` varchar(15) NOT NULL COMMENT '教师登录密码',
  PRIMARY KEY (`Tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_account
-- ----------------------------
INSERT INTO `teacher_account` VALUES ('1', 'root');
INSERT INTO `teacher_account` VALUES ('2', 'root');
INSERT INTO `teacher_account` VALUES ('3', 'root');
INSERT INTO `teacher_account` VALUES ('4', 'root');
INSERT INTO `teacher_account` VALUES ('5', 'root');
INSERT INTO `teacher_account` VALUES ('6', 'root');

-- ----------------------------
-- Table structure for `tea_class`
-- ----------------------------
DROP TABLE IF EXISTS `tea_class`;
CREATE TABLE `tea_class` (
  `classid` bigint(20) NOT NULL,
  `Tid` bigint(20) NOT NULL,
  PRIMARY KEY (`classid`,`Tid`),
  KEY `Tid` (`Tid`),
  CONSTRAINT `tea_class_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tea_class_ibfk_2` FOREIGN KEY (`Tid`) REFERENCES `teacher` (`Tno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tea_class
-- ----------------------------
INSERT INTO `tea_class` VALUES ('1', '1');
INSERT INTO `tea_class` VALUES ('2', '1');
INSERT INTO `tea_class` VALUES ('3', '1');
INSERT INTO `tea_class` VALUES ('1', '2');
INSERT INTO `tea_class` VALUES ('2', '2');
INSERT INTO `tea_class` VALUES ('3', '2');
INSERT INTO `tea_class` VALUES ('1', '3');
INSERT INTO `tea_class` VALUES ('2', '3');
INSERT INTO `tea_class` VALUES ('3', '3');
INSERT INTO `tea_class` VALUES ('1', '4');
INSERT INTO `tea_class` VALUES ('2', '4');
INSERT INTO `tea_class` VALUES ('3', '4');
INSERT INTO `tea_class` VALUES ('1', '5');
INSERT INTO `tea_class` VALUES ('2', '5');
INSERT INTO `tea_class` VALUES ('3', '5');
INSERT INTO `tea_class` VALUES ('1', '6');
INSERT INTO `tea_class` VALUES ('2', '6');
INSERT INTO `tea_class` VALUES ('3', '6');

-- ----------------------------
-- Table structure for `tea_ope`
-- ----------------------------
DROP TABLE IF EXISTS `tea_ope`;
CREATE TABLE `tea_ope` (
  `Tno` bigint(20) NOT NULL COMMENT '教师编号',
  `opid` varchar(32) NOT NULL COMMENT '题目id',
  PRIMARY KEY (`Tno`,`opid`),
  KEY `opid` (`opid`),
  CONSTRAINT `tea_ope_ibfk_1` FOREIGN KEY (`Tno`) REFERENCES `teacher` (`Tno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tea_ope_ibfk_2` FOREIGN KEY (`opid`) REFERENCES `operation` (`opid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tea_ope
-- ----------------------------
INSERT INTO `tea_ope` VALUES ('1', '1');
INSERT INTO `tea_ope` VALUES ('2', '10');
INSERT INTO `tea_ope` VALUES ('4', '11');
INSERT INTO `tea_ope` VALUES ('5', '12');
INSERT INTO `tea_ope` VALUES ('6', '13');
INSERT INTO `tea_ope` VALUES ('3', '14');
INSERT INTO `tea_ope` VALUES ('3', '15');
INSERT INTO `tea_ope` VALUES ('1', '2');
INSERT INTO `tea_ope` VALUES ('2', '3');
INSERT INTO `tea_ope` VALUES ('6', '4');
INSERT INTO `tea_ope` VALUES ('5', '5');
INSERT INTO `tea_ope` VALUES ('4', '6');
INSERT INTO `tea_ope` VALUES ('5', '7');
INSERT INTO `tea_ope` VALUES ('6', '8');
