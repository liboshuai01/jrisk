package cn.liboshuai.jrisk.module.risk.dal.mysql.rule;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.mybatis.core.mapper.BaseMapperX;
import cn.liboshuai.jrisk.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 风控规则 Mapper
 *
 * @author 李博帅
 */
@Mapper
public interface RuleMapper extends BaseMapperX<RuleDO> {

    default PageResult<RuleDO> selectPage(RulePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RuleDO>()
                .eqIfPresent(RuleDO::getRuleId, reqVO.getRuleId())
                .likeIfPresent(RuleDO::getRuleName, reqVO.getRuleName())
                .eqIfPresent(RuleDO::getLevel, reqVO.getLevel())
                .eqIfPresent(RuleDO::getChannel, reqVO.getChannel())
                .eqIfPresent(RuleDO::getTarget, reqVO.getTarget())
                .eqIfPresent(RuleDO::getStatus, reqVO.getStatus())
                .likeIfPresent(RuleDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(RuleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RuleDO::getId));
    }

}