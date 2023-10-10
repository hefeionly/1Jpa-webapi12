package com.example.procedure.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.procedure.bean.InventoryDto;
import com.example.procedure.service.InventoryDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InventoryDtoController {
    @Autowired
    InventoryDtoService inventoryDtoService;

    @ResponseBody
    @RequestMapping("/4003")  //4003：库存信息查询
    public Map<String, Object> findInventoryDtoController(@RequestBody JSONObject json) {
//        String nameWhere = org.apache.commons.lang.StringUtils.join(new String[]{"%", name, "%"}, "");
        try {
            String type = json.getString("type");//"1";
            String inventoryList = json.getString("inventoryList");//"";
            List<InventoryDto> contacts = inventoryDtoService.findInventoryDtoProc(type, inventoryList);

            int i = contacts.size();

            System.out.println(String.valueOf(i));
//            int a = 10 / 0;
//            JSONArray jsonArray = (JSONArray) JSONArray.toJSON(contacts);
////            JSONObject obj1 = new JSONObject();
////            obj1.put("inventoryList", jsonArray);
////            obj1.put("message", "【4003-库存信息查询】请求成功");
////            obj1.put("code", "0");
////            System.out.println(obj1);
////            return obj1;

            Map<String, Object> param = new HashMap<>();
            param.put("inventoryList", contacts);
            param.put("message", "【4003-库存信息查询】请求成功");
            param.put("code", "0");
//            System.out.println(param);
            return param;
        } catch (Exception e) {
            /**
             * 对异常主动事务回滚处理
             * 如果没有下面这条语句，程序前台能捕获到异常，但实际已经删除了数据
             */
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            JSONObject obj1 = new JSONObject();
//            obj1.put("result",String.valueOf(e));
            obj1.put("message", "【4003-库存信息查询】请求失败：" + String.valueOf(e));
            obj1.put("code", "-1");
            System.out.println(obj1);
            return obj1;
        }
    }
}
