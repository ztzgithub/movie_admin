package com.ztt.movie.service.statistics.service;

import com.ztt.movie.service.statistics.entity.Daily;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author ztt
 * @since 2021-02-20
 */
public interface DailyService extends IService<Daily> {

    void createStatisticsByDay(String day);
}
