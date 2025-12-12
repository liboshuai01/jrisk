package cn.liboshuai.jrisk.module.risk.service.cond;

import java.util.*;
import javax.validation.*;
import cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo.*;
import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.cond.CondDO;

/**
 * 风控条件 Service 接口
 *
 * @author 李博帅
 */
public interface CondService {

    /**
     * 创建风控条件
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCond(@Valid CondSaveReqVO createReqVO);

    /**
     * 更新风控条件
     *
     * @param updateReqVO 更新信息
     */
    void updateCond(@Valid CondSaveReqVO updateReqVO);

    /**
     * 删除风控条件
     *
     * @param id 编号
     */
    void deleteCond(Long id);

    /**
    * 批量删除风控条件
    *
    * @param ids 编号
    */
    void deleteCondListByIds(List<Long> ids);

    /**
     * 获得风控条件
     *
     * @param id 编号
     * @return 风控条件
     */
    CondDO getCond(Long id);

    /**
     * 获得风控条件分页
     *
     * @param pageReqVO 分页查询
     * @return 风控条件分页
     */
    PageResult<CondDO> getCondPage(CondPageReqVO pageReqVO);

}