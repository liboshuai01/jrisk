package cn.liboshuai.jrisk.module.system.api.logger;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;
import cn.liboshuai.jrisk.framework.common.biz.system.logger.dto.OperateLogCreateReqDTO;
import cn.liboshuai.jrisk.module.system.api.logger.dto.OperateLogPageReqDTO;
import cn.liboshuai.jrisk.module.system.api.logger.dto.OperateLogRespDTO;
import cn.liboshuai.jrisk.module.system.dal.dataobject.logger.OperateLogDO;
import cn.liboshuai.jrisk.module.system.service.logger.OperateLogService;
import com.fhs.core.trans.anno.TransMethodResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 操作日志 API 实现类
 *
 * @author 李博帅
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

    @Override
    @TransMethodResult
    public PageResult<OperateLogRespDTO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqDTO);
        return BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class);
    }

}
