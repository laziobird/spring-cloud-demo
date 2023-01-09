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
