CREATE TABLE `t_user` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `nickname` varchar(20) NOT NULL COMMENT '别名昵称',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `unique_index_phone` (`phone`) COMMENT '电话号码唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_car_name` (
  `id` varchar(50) NOT NULL COMMENT '主键id',
  `name` varchar(50) NOT NULL COMMENT '汽车名称',
  `first_letter` char(1) NOT NULL COMMENT '第一个字母',
  `area` varchar(20) NOT NULL COMMENT '地区',
  `producers` varchar(50) NOT NULL COMMENT '生产商',
  `style` varchar(50) NOT NULL COMMENT '款式',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;