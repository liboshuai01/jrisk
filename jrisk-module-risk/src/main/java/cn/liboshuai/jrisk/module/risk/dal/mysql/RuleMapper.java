package cn.liboshuai.jrisk.module.risk.dal.mysql;

import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.mybatis.core.mapper.BaseMapperX;
import cn.liboshuai.jrisk.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RuleMapper extends BaseMapperX<RuleDO> {

    default PageResult<RuleDO> selectPage(RulePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RuleDO>()
                .eqIfPresent(RuleDO::getRuleName, reqVO.getRuleName())
                .eqIfPresent(RuleDO::getRuleId, reqVO.getRuleId())
                .eqIfPresent(RuleDO::getStatus, reqVO.getStatus())
                .orderByDesc(RuleDO::getId));
    }

}
