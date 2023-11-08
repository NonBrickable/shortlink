package com.lv.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_user_%d` (\n" +
            "  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',\n" +
            "  `password` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',\n" +
            "  `real_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '真实姓名',\n" +
            "  `phone` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',\n" +
            "  `mail` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',\n" +
            "  `deletion_time` bigint DEFAULT NULL COMMENT '注销时间戳',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建时间',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '更新时间',\n" +
            "  `del_flag` tinyint DEFAULT NULL COMMENT '删除标识 0：没有删除 1：删除',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_username` (`username`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1721886382168838148 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";


    public static void main(String[] args) {
        for(int i = 0;i < 16;i++){
            System.out.printf((SQL) + "%n",i);
        }
    }

}