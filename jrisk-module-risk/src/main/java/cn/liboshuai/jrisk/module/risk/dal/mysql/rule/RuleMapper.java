package cn.liboshuai.jrisk.module.risk.dal.mysql.rule;

import java.util.*;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.liboshuai.jrisk.framework.mybatis.core.mapper.BaseMapperX;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.*;

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
                .eqIfPresent(RuleDO::getStatus, reqVO.getStatus())
                .eqIfPresent(RuleDO::getCreator, reqVO.getCreator())
                .betweenIfPresent(RuleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RuleDO::getId));
    }

}