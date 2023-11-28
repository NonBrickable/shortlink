package com.lv.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lv.shortlink.project.dao.entity.LinkStatsTodayDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


/**
 * 短链接今日访问统计表持久层
 */
public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {
    @Insert("insert into t_link_stats_today (full_short_url, gid, date, today_pv, today_uv, today_uip,create_time, update_time, del_flag)" +
            "VALUES( #{linkTodayStats.fullShortUrl}, #{linkTodayStats.gid}, #{linkTodayStats.date},#{linkTodayStats.todayPv}, #{linkTodayStats.todayUv}, #{linkTodayStats.todayUip},NOW(), NOW(), 0)" +
            "ON DUPLICATE KEY UPDATE today_pv = today_pv + #{linkTodayStats.todayPv}," +
            "today_uv = today_uv + #{linkTodayStats.todayUv}," +
            "today_uip = today_uip + #{linkTodayStats.todayUip};")
    void shortLinkTodayState(@Param("linkTodayStats") LinkStatsTodayDO linkStatsTodayDO);
}
