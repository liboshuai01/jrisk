package cn.liboshuai.jrisk.module.risk.dal.mysql.cond;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.mybatis.core.mapper.BaseMapperX;
import cn.liboshuai.jrisk.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo.CondPageReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.cond.CondDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 风控条件 Mapper
 *
 * @author 李博帅
 */
@Mapper
public interface CondMapper extends BaseMapperX<CondDO> {

    default PageResult<CondDO> selectPage(CondPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CondDO>()
                .eqIfPresent(CondDO::getCondId, reqVO.getCondId())
                .eqIfPresent(CondDO::getCondType, reqVO.getCondType())
                .betweenIfPresent(CondDO::getTimeline, reqVO.getTimeline())
                .eqIfPresent(CondDO::getRuleId, reqVO.getRuleId())
                .orderByDesc(CondDO::getId));
    }

    default List<CondDO> selectListByRuleId(Long ruleId) {
        return selectList(CondDO::getRuleId, ruleId);
    }

    default int deleteByRuleId(Long ruleId) {
        return delete(CondDO::getRuleId, ruleId);
    }

    default int deleteByRuleIds(List<Long> ruleIds) {
        return deleteBatch(CondDO::getRuleId, ruleIds);
    }

}