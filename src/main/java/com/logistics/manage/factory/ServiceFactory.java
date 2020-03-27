package com.logistics.manage.factory;

import com.logistics.manage.service.ResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Create 2020-03-18 8:49
 */
@Component
public class ServiceFactory {


    @Autowired
    private Map<String, ResultApi> map = new HashMap<>();

    public ResultApi get(String type){
        return this.map.get(type);
    }

}
