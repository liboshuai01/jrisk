package cn.liboshuai.jrisk.module.risk.controller.admin.cond;

import cn.liboshuai.jrisk.framework.apilog.core.annotation.ApiAccessLog;
import cn.liboshuai.jrisk.framework.common.pojo.CommonResult;
import cn.liboshuai.jrisk.framework.common.pojo.PageParam;
import cn.liboshuai.jrisk.framework.common.pojo.PageResult;
import cn.liboshuai.jrisk.framework.common.util.object.BeanUtils;
import cn.liboshuai.jrisk.framework.excel.core.util.ExcelUtils;
import cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo.CondPageReqVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo.CondRespVO;
import cn.liboshuai.jrisk.module.risk.controller.admin.cond.vo.CondSaveReqVO;
import cn.liboshuai.jrisk.module.risk.dal.dataobject.cond.CondDO;
import cn.liboshuai.jrisk.module.risk.service.cond.CondService;
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

@Tag(name = "管理后台 - 风控条件")
@RestController
@RequestMapping("/risk/cond")
@Validated
public class CondController {

    @Resource
    private CondService condService;

    @PostMapping("/create")
    @Operation(summary = "创建风控条件")
    @PreAuthorize("@ss.hasPermission('risk:cond:create')")
    public CommonResult<Long> createCond(@Valid @RequestBody CondSaveReqVO createReqVO) {
        return success(condService.createCond(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新风控条件")
    @PreAuthorize("@ss.hasPermission('risk:cond:update')")
    public CommonResult<Boolean> updateCond(@Valid @RequestBody CondSaveReqVO updateReqVO) {
        condService.updateCond(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除风控条件")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('risk:cond:delete')")
    public CommonResult<Boolean> deleteCond(@RequestParam("id") Long id) {
        condService.deleteCond(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除风控条件")
                @PreAuthorize("@ss.hasPermission('risk:cond:delete')")
    public CommonResult<Boolean> deleteCondList(@RequestParam("ids") List<Long> ids) {
        condService.deleteCondListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得风控条件")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('risk:cond:query')")
    public CommonResult<CondRespVO> getCond(@RequestParam("id") Long id) {
        CondDO cond = condService.getCond(id);
        return success(BeanUtils.toBean(cond, CondRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得风控条件分页")
    @PreAuthorize("@ss.hasPermission('risk:cond:query')")
    public CommonResult<PageResult<CondRespVO>> getCondPage(@Valid CondPageReqVO pageReqVO) {
        PageResult<CondDO> pageResult = condService.getCondPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CondRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出风控条件 Excel")
    @PreAuthorize("@ss.hasPermission('risk:cond:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCondExcel(@Valid CondPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<CondDO> list = condService.getCondPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "风控条件.xls", "数据", CondRespVO.class,
                        BeanUtils.toBean(list, CondRespVO.class));
    }

}