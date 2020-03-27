package com.logistics.manage.service.api;

import com.github.pagehelper.PageInfo;
import com.logistics.manage.service.ResultApi;
import com.logistics.manage.service.result.FrontendResult;
import com.logistics.manage.factory.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @Create 2020-03-18 19:42
 */
@RestController
public class DataApi {

    @Autowired
    private ServiceFactory serviceFactory;

    @RequestMapping("/get/data")
    public FrontendResult getData(@RequestParam(value = "type", required = false)String type,
                                  @RequestParam(value = "pageNumber", required = false)Integer pageNumber,
                                  @RequestParam(value = "searchName", required = false)String searchName){

        if(StringUtils.isEmpty(type)){
            return FrontendResult.failed(500, "未传入查询类型");
        }

        if(pageNumber == null && pageNumber <= 0){
            return FrontendResult.failed(500, "未传入pageNumber");
        }

        ResultApi resultApi = serviceFactory.get(type);

        if(resultApi == null){
            return FrontendResult.failed(500, "传入的typeName不在范围之内，请输入合理的typename");
        }

        PageInfo pageInfo = resultApi.getInfo(pageNumber, searchName);

        List dataList = pageInfo.getList();

        return new FrontendResult(200, "查询成功", pageNumber, pageInfo.getPages(), pageInfo.getTotal(),
                resultApi.getTableField(), dataList);

    }

}
