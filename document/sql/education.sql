SET NAMES utf8 ;
--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` bigint unsigned NOT NULL COMMENT '分类ID',
  `category_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `parent_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '父分类id，一级分类默认父分类0',
  `level` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '分类级别',
  `weight_sort` int unsigned NOT NULL DEFAULT '1' COMMENT '排序权重 数越大权重越高',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-正常 1-删除',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态: 0-正常',
  `versions` bigint NOT NULL DEFAULT '0' COMMENT '版本',
  `features` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '扩展属性json',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_id_UNIQUE` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `lesson` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lesson_id` bigint unsigned NOT NULL COMMENT '课程ID',
  `lesson_name` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '课程名称',
  `categroy_id` bigint unsigned NOT NULL COMMENT '一级目录',
  `category_child_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '二级目录',
  `lesson_info` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '课程描述',
  `lesson_cover` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '课程封面',
  `lesson_weight` int unsigned NOT NULL DEFAULT '0' COMMENT '课程排序权重：数越大，权重越高',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-正常 1-删除',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态: 0-正常 ',
  `versions` bigint NOT NULL DEFAULT '0' COMMENT '版本',
  `features` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '扩展属性json',
  `remarks` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `category_name` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '一级分类名',
  `category_child_name` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '二级分类名',
  `video_ids` varchar(1024) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '对于的视频ID，冗余字段，以英文,分隔',
  `video_total` int unsigned DEFAULT '0' COMMENT '冗余字段，课程对应视频数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lesson_id_UNIQUE` (`lesson_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Table structure for table `lesson_category`
--

DROP TABLE IF EXISTS `lesson_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lesson_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` bigint unsigned NOT NULL COMMENT '分类ID',
  `lesson_id` bigint unsigned NOT NULL COMMENT '课程id',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-正常 1-删除',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态: 0-正常',
  `versions` bigint NOT NULL DEFAULT '0' COMMENT '版本',
  `features` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '扩展属性json',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Table structure for table `lesson_video`
--

DROP TABLE IF EXISTS `lesson_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lesson_video` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lesson_id` bigint unsigned NOT NULL COMMENT '课程ID',
  `video_id` bigint unsigned NOT NULL COMMENT '视频ID',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-正常 1-删除',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态: 0-正常、下架 1-上架',
  `versions` bigint NOT NULL DEFAULT '0' COMMENT '版本',
  `features` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '扩展属性json',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `video` (
  `id` int NOT NULL AUTO_INCREMENT,
  `video_id` bigint unsigned NOT NULL COMMENT '视频ID',
  `video_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `teacher_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '导师id',
  `teacher_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '导师名字',
  `video_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '视频地址',
  `txcloud_file_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '腾讯云对应的FileID',
  `txcloud_app_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '腾讯云对应的AppID',
  `txcloud_type` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '视频类型',
  `txcloud_size` bigint unsigned DEFAULT '0' COMMENT '上传的媒体文件大小 字节',
  `txcloud_duration` bigint unsigned NOT NULL DEFAULT '0' COMMENT '视频时长，单位：秒',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-正常 1-删除',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态: 0-正常、下架 1-上架',
  `versions` bigint NOT NULL DEFAULT '0' COMMENT '版本',
  `features` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '扩展属性json',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `txcloud_status` int DEFAULT '0' COMMENT '腾讯云视频转码专题逻辑，必须靠回调通知成功  1表示成功',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


--
-- Table structure for table `video_record`
--

DROP TABLE IF EXISTS `video_record`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `video_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `video_id` bigint unsigned NOT NULL COMMENT '视频ID',
  `video_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `file_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '腾讯云对应的FileID',
  `app_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '腾讯云对应的AppID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `user_department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户部门',
  `view_time` bigint NOT NULL DEFAULT '0' COMMENT '目前观看到的时间，单位是秒',
  `video_time` bigint NOT NULL DEFAULT '0' COMMENT '视频总时长,单位是秒',
  `zuhu_id` bigint NOT NULL DEFAULT '0' COMMENT '租户ID',
  `zuhu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '租户名称',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-正常 1-删除',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态: 0-正常、下架 1-上架',
  `versions` bigint NOT NULL DEFAULT '0' COMMENT '版本',
  `features` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '扩展属性json',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `company_id` bigint DEFAULT '0',
  `lesson_id` bigint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


--
-- Table structure for table `video_summary`
--

DROP TABLE IF EXISTS `video_summary`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `video_summary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `video_id` bigint unsigned NOT NULL COMMENT '视频ID',
  `video_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '名称',
  `txcloud_file_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '腾讯云对应的FileID',
  `txcloud_app_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '腾讯云对应的AppID',
  `view_fist` datetime NOT NULL COMMENT '视频第一次观看的时间',
  `view_end` datetime NOT NULL COMMENT '视频最后一次观看的时间',
  `view_user` bigint NOT NULL COMMENT '累计观看人数',
  `view_finish_user` bigint NOT NULL COMMENT '累计看完人数 95%',
  `view_time_total` bigint NOT NULL COMMENT '总结观看时长，单位为秒',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-正常 1-删除',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态: 0-正常、下架 1-上架',
  `versions` bigint NOT NULL DEFAULT '0' COMMENT '版本',
  `features` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '扩展属性json',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `lesson_id` bigint NOT NULL,
  `lesson_name` varchar(128) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
