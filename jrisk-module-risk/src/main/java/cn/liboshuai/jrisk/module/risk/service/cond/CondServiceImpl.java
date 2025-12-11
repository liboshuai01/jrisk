package cn.liboshuai.jrisk.module.risk.service.cond;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;
import cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo.CondPageReqVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo.CondSaveReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.cond.CondDO;
import cn.liboshuai.jrisk.module.risk.dal.mysql.cond.CondMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

import static cn.liboshuai.jrisk.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.liboshuai.jrisk.module.risk.enums.ErrorCodeConstants.COND_NOT_EXISTS;


/**
 * 风控条件 Service 实现类
 *
 * @author 李博帅
 */
@Service
@Validated
public class CondServiceImpl implements CondService {

    @Resource
    private CondMapper condMapper;

    @Override
    public Long createCond(CondSaveReqVO createReqVO) {
        // 插入
        CondDO cond = BeanUtils.toBean(createReqVO, CondDO.class);
        condMapper.insert(cond);

        // 返回
        return cond.getId();
    }

    @Override
    public void updateCond(CondSaveReqVO updateReqVO) {
        // 校验存在
        validateCondExists(updateReqVO.getId());
        // 更新
        CondDO updateObj = BeanUtils.toBean(updateReqVO, CondDO.class);
        condMapper.updateById(updateObj);
    }

    @Override
    public void deleteCond(Long id) {
        // 校验存在
        validateCondExists(id);
        // 删除
        condMapper.deleteById(id);
    }

    @Override
        public void deleteCondListByIds(List<Long> ids) {
        // 删除
        condMapper.deleteByIds(ids);
        }


    private void validateCondExists(Long id) {
        if (condMapper.selectById(id) == null) {
            throw exception(COND_NOT_EXISTS);
        }
    }

    @Override
    public CondDO getCond(Long id) {
        return condMapper.selectById(id);
    }

    @Override
    public PageResult<CondDO> getCondPage(CondPageReqVO pageReqVO) {
        return condMapper.selectPage(pageReqVO);
    }

}