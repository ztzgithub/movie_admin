package com.ztt.movie.service.vod.controller.api;

import com.ztt.movie.common.base.result.R;
import com.ztt.movie.common.base.result.ResultCodeEnum;
import com.ztt.movie.common.base.utils.ExceptionUtils;
import com.ztt.movie.service.base.exception.MovieException;
import com.ztt.movie.service.vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="阿里云视频点播")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/vod/media")
@Slf4j
public class ApiMediaController {

    @Autowired
    private VideoService videoService;

    @GetMapping("get-play-auth/{videoSourceId}")
    public R getPlayAuth(
            @ApiParam(value = "阿里云视频文件的id", required = true)
            @PathVariable String videoSourceId){

        try{
            String playAuth = videoService.getPlayAuth(videoSourceId);
            return  R.ok().message("获取播放凭证成功").data("playAuth", playAuth);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new MovieException(ResultCodeEnum.FETCH_PLAYAUTH_ERROR);
        }
    }
}