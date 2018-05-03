
/*用户表*/
DROP TABLE IF EXISTS th_user;
CREATE TABLE th_user(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  username varchar(50) NOT NULL COMMENT '用户昵称',
  account varchar(50) NOT NULL COMMENT '用户账号',
  password varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  email varchar(50) DEFAULT NULL COMMENT '邮箱',
  img varchar(50) DEFAULT NULL COMMENT '头像',
  area varchar(20) DEFAULT NULL COMMENT '地区',
  create_time datetime NOT NULL COMMENT '创建时间',
  update_time datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY user_account_unique (account) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


/*动态表*/
DROP TABLE IF EXISTS th_share;
CREATE TABLE th_share(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '动态表ID',
  account varchar(50) NOT NULL COMMENT '用户账号',
  content varchar(250) DEFAULT NULL COMMENT '分享内容',
  img_url VARCHAR(500) DEFAULT NULL COMMENT '分享图片',
  create_time datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


/*评论表*/
DROP TABLE IF EXISTS th_comment;
CREATE TABLE th_comment(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '评论表ID',
  share_id int(11) NOT NULL COMMENT '动态表ID',
  commentor_id varchar(50) NOT NULL COMMENT '评论者账号',
  content varchar(150) NOT NULL COMMENT '评论内容',
  create_time datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*群组表*/
DROP TABLE IF EXISTS th_chat_group;
CREATE TABLE th_chat_group(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '群组表ID',
  sum int(3) DEFAULT 0 COMMENT '群组人数',
  create_time datetime NOT NULL COMMENT '创建时间',
  update_time datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*群组用户中间表*/
DROP TABLE IF EXISTS th_chat_user_ship;
CREATE TABLE th_chat_user_ship(
  user_id varchar(50) NOT NULL COMMENT '用户账号',
  chat_group_id int(11) NOT NULL  COMMENT '群组表ID',
  create_time datetime NOT NULL COMMENT '创建时间',
  CONSTRAINT th_chat_user_ship_key PRIMARY KEY (user_id,chat_group_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*群聊表*/
DROP TABLE IF EXISTS th_chat_public;
CREATE TABLE th_chat_public(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '群聊表ID',
  chat_group_id int(11) NOT NULL  COMMENT '群组表ID',
  user_id varchar(50) NOT NULL COMMENT '消息发送用户账号',
  content VARCHAR(150) NOT NULL COMMENT '消息内容',
  create_time datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*私聊表*/
DROP TABLE IF EXISTS th_chat_private;
CREATE TABLE th_chat_private(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '私聊表ID',
  target_user_id varchar(50) NOT NULL  COMMENT '消息接收用户账号',
  send_user_id varchar(50) NOT NULL COMMENT '消息发送用户账号',
  content VARCHAR(150) NOT NULL COMMENT '消息内容',
  create_time datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


/*好友表*/
DROP TABLE IF EXISTS th_friend;
CREATE TABLE th_friend(
  user_account_1 varchar(50) NOT NULL COMMENT '用户账号',
  user_account_2 varchar(50) NOT NULL  COMMENT '用户账号',
  create_time datetime NOT NULL COMMENT '创建时间',
  CONSTRAINT th_friend_ship_key PRIMARY KEY (user_account_1,user_account_2)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


/*消息队列表*/
DROP TABLE IF EXISTS th_msg_queue;
CREATE TABLE th_msg_queue(
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '消息表ID',
  account varchar(50) NOT NULL COMMENT '用户账号',
  type int(2) NOT NULL COMMENT '消息类型',
  val varchar(50) NOT NULL COMMENT '消息值',
  description varchar(50)  COMMENT '消息描述',
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;


