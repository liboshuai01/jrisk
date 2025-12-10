package cn.liboshuai.jrisk.module.risk.controller.admin.rule;

import cn.liboshuai.jrisk.framework.common.pojo.CommonResult;
import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageReqVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RulePageRespVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RuleRespVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.rule.vo.RuleSaveReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.rule.RuleDO;
import cn.liboshuai.jrisk.module.risk.service.rule.RuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.liboshuai.jrisk.framework.common.pojo.CommonResult.success;

@Tag(name = "风控管理 - 规则管理")
@RestController
@RequestMapping("/risk/rule")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @GetMapping("/page")
    @Operation(summary = "查询规则分页列表")
    @PreAuthorize("@ss.hasPermission('risk:rule:query')")
    public CommonResult<PageResult<RulePageRespVO>> getRulePage(@Valid RulePageReqVO pageReqVO) {
        PageResult<RuleDO> pageResult = ruleService.getRulePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, RulePageRespVO.class));
    }

    @GetMapping("/get")
    @Operation(summary = "查询规则详情")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('risk:rule:detail')")
    public CommonResult<RuleRespVO> getRule(@RequestParam("id") Long id) {
        RuleDO account = ruleService.getRule(id);
        return success(BeanUtils.toBean(account, RuleRespVO.class));
    }

    @PostMapping("/create")
    @Operation(summary = "新增规则")
    @PreAuthorize("@ss.hasPermission('risk:rule:create')")
    public CommonResult<Long> createRule(@Valid @RequestBody RuleSaveReqVO createReqVO) {
        return success(ruleService.createRule(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "修改规则")
    @PreAuthorize("@ss.hasPermission('risk:rule:update')")
    public CommonResult<Boolean> updateRule(@Valid @RequestBody RuleSaveReqVO updateReqVO) {
        ruleService.updateRule(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除规则")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('risk:rule:delete')")
    public CommonResult<Boolean> deleteRule(@RequestParam Long id) {
        ruleService.deleteRule(id);
        return success(true);
    }

    @DeleteMapping("/update-status")
    @Operation(summary = "修改状态 (启停)")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('risk:rule:enable')")
    public CommonResult<Boolean> updateRuleStatus(@RequestParam Long id, @RequestParam Integer status) {
        ruleService.updateRuleStatus(id, status);
        return success(true);
    }

}