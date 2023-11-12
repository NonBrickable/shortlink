package com.lv.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_group_%d` (\n" +
            "  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `gid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组标识',\n" +
            "  `name` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组名称',\n" +
            "  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',\n" +
            "  `sort_order` int DEFAULT NULL COMMENT '分组排序',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT '创建时间',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT '更改时间',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识 0：没有删除 1：删除',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `index_unique_username_gid` (`gid`,`username`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1722582993404440581 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";


    public static void main(String[] args) {
        for(int i = 0;i < 16;i++){
            System.out.printf((SQL) + "%n",i);
        }
    }

}