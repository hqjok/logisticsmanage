package com.logistics.manage.factory;

import com.logistics.manage.service.RoleAndMenuApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Create 2020-03-18 8:49
 */
@Component
public class RoleFactory {


    @Autowired
    private Map<String, RoleAndMenuApi> map = new HashMap<>();

    public RoleAndMenuApi get(String roleId){
        return this.map.get(roleId);
    }

}
