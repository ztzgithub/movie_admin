package com.ztt.movie.service.cms.feign.fallback;

import com.ztt.movie.common.base.result.R;
import com.ztt.movie.service.cms.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ztt
 * @since 2020/4/17
 */

@Service
@Slf4j
public class OssFileServiceFallBack implements OssFileService {

    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error().message("调用超时");
    }
}
