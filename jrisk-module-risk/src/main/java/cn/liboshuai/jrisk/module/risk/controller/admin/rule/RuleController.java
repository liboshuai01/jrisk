package cn.liboshuai.jrisk.module.risk.controller.admin.rule;

import cn.liboshuai.jrisk.framework.apilog.core.annotation.ApiAccessLog;
import cn.liboshuai.jrisk.framework.common.pojo.CommonResult;
import cn.liboshuai.jrisk.framework.common.pojo.PageParam;
import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;
import cn.liboshuai.jrisk.framework.excel.core.util.ExcelUtils;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageReqVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RuleRespVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RuleSaveReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.cond.CondDO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import cn.liboshuai.jrisk.module.risk.service.rule.RuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static cn.liboshuai.jrisk.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.liboshuai.jrisk.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 风控规则")
@RestController
@RequestMapping("/risk/rule")
@Validated
public class RuleController {

    @Resource
    private RuleService ruleService;

    @PostMapping("/create")
    @Operation(summary = "创建风控规则")
    @PreAuthorize("@ss.hasPermission('risk:rule:create')")
    public CommonResult<Long> createRule(@Valid @RequestBody RuleSaveReqVO createReqVO) {
        return success(ruleService.createRule(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新风控规则")
    @PreAuthorize("@ss.hasPermission('risk:rule:update')")
    public CommonResult<Boolean> updateRule(@Valid @RequestBody RuleSaveReqVO updateReqVO) {
        ruleService.updateRule(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除风控规则")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('risk:rule:delete')")
    public CommonResult<Boolean> deleteRule(@RequestParam("id") Long id) {
        ruleService.deleteRule(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除风控规则")
                @PreAuthorize("@ss.hasPermission('risk:rule:delete')")
    public CommonResult<Boolean> deleteRuleList(@RequestParam("ids") List<Long> ids) {
        ruleService.deleteRuleListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得风控规则")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('risk:rule:query')")
    public CommonResult<RuleRespVO> getRule(@RequestParam("id") Long id) {
        RuleDO rule = ruleService.getRule(id);
        return success(BeanUtils.toBean(rule, RuleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得风控规则分页")
    @PreAuthorize("@ss.hasPermission('risk:rule:query')")
    public CommonResult<PageResult<RuleRespVO>> getRulePage(@Valid RulePageReqVO pageReqVO) {
        PageResult<RuleDO> pageResult = ruleService.getRulePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, RuleRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出风控规则 Excel")
    @PreAuthorize("@ss.hasPermission('risk:rule:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRuleExcel(@Valid RulePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<RuleDO> list = ruleService.getRulePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "风控规则.xls", "数据", RuleRespVO.class,
                        BeanUtils.toBean(list, RuleRespVO.class));
    }

    // ==================== 子表（风控条件） ====================

    @GetMapping("/cond/list-by-rule-id")
    @Operation(summary = "获得风控条件列表")
    @Parameter(name = "ruleId", description = "规则编号")
    @PreAuthorize("@ss.hasPermission('risk:rule:query')")
    public CommonResult<List<CondDO>> getCondListByRuleId(@RequestParam("ruleId") Long ruleId) {
        return success(ruleService.getCondListByRuleId(ruleId));
    }

}