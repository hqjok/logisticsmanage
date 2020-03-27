package com.logistics.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.ArrayUtils;
import org.thymeleaf.util.ListUtils;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Create 2020-02-29 15:48
 */
@Controller
public class TestController {

    @GetMapping("/hi")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @PostMapping("/batchdel")
    @ResponseBody
    public List batchDel(@RequestParam("ids") String ids){

        List<String> stringList = Arrays.asList(ids.split(","));
        List<Integer> integerList = stringList.stream().map(Integer::valueOf).collect(Collectors.toList());

        return integerList;
    }
}
