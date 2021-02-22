package com.ztt.movie.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztt.movie.service.edu.entity.Subject;
import com.ztt.movie.service.edu.entity.excel.ExcelSubjectData;
import com.ztt.movie.service.edu.entity.vo.SubjectVo;
import com.ztt.movie.service.edu.listener.ExcelSubjectDataListener;
import com.ztt.movie.service.edu.mapper.SubjectMapper;
import com.ztt.movie.service.edu.service.SubjectService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author ztt
 * @since 2021-01-22
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public void batchImport(InputStream inputStream) {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(inputStream, ExcelSubjectData.class, new ExcelSubjectDataListener(baseMapper))
                .excelType(ExcelTypeEnum.XLS).sheet().doRead();
    }

    @Override
    public List<SubjectVo> nestedList() {
        return baseMapper.selectNestedListByParentId("0");
    }
}
