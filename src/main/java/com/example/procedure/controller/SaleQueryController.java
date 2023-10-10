package com.example.procedure.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.procedure.bean.SaleQuery;
import com.example.procedure.repository.SaleQueryRepository;
//import io.swagger.annotations.Contact;
import com.example.procedure.service.SaleQueryService;
import com.example.procedure.service.SaleQueryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.persistence.StoredProcedureQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j   // @SLF4J 注解代替原始步骤的第一步 private static Logger log = LoggerFactory.getLogger(SaleQueryController.class);
@Api
public class SaleQueryController {
    // 1. 得到日志对象
//    private static Logger log = LoggerFactory.getLogger(SaleQueryController.class);

    /**日志有 6 个级别, 级别从低到高如下所示:
     * trace:  微量, 少许的意思, 级别最低.
     * debug：需要调试时候的关键信息打印.
     * info：普通的打印信息 (默认日志级别).
     * warn：警告，不影响使用，但需要注意的问题.
     * error：错误信息，级别较高的错误日志信息.
     * fatal：致命的，因为代码异常导致程序退出执行的事件.(不能在程序中调用它, 但是它存在)
     */
    @Autowired
    private SaleQueryRepository saleQueryRepository;
    @Autowired
//    @Qualifier("SaleQueryService")
    private SaleQueryService saleQueryService;

    @ResponseBody
    @RequestMapping("/4002")  //4002：销售信息查询
    @ApiOperation(value = "验证 @ApiOperation 注解",
            notes = "验证 @ApiOperation 注解 value 和 notes 属性的用法",
            httpMethod = "POST")
    public Map<String, Object> findSaleQueryController(@RequestBody JSONObject json) {
//        String nameWhere = org.apache.commons.lang.StringUtils.join(new String[]{"%", name, "%"}, "");
        try{
            String begin_date = json.getString("begin_date");//"2018.01.01";
            String end_date = json.getString("end_date");//"2020.01.01";
            String type = json.getString("type");//"1";
            String inventoryList = json.getString("inventoryList");//"";
            List<SaleQuery> contacts = saleQueryService.findSaleQueryProc(begin_date, end_date, type,
                    inventoryList);

            int i= contacts.size();

            System.out.println(String.valueOf(i));
//            int a = 10 / 0;
//            JSONArray jsonArray = (JSONArray) JSONArray.toJSON(contacts);
//            JSONObject obj1 = new JSONObject();
//            obj1.put("inventoryList",jsonArray);
//            obj1.put("message","【4002-销售信息查询】请求成功");
//            obj1.put("code", "0");
//            System.out.println(obj1);
//            return obj1;

            Map<String, Object> param = new HashMap<>();
            param.put("inventoryList", contacts);
            param.put("message", "【4002-销售信息查询】请求成功");
            param.put("code", "0");
//            System.out.println(param);
//            log.info(String.valueOf(param));
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
            obj1.put("message","【4002-销售信息查询】请求失败："+String.valueOf(e));
            obj1.put("code", "-1");
            System.out.println(obj1);
            //依据配置文件application.yml中的logging，可以控制系统级日志级别；也可以具体到设置文件夹的日志级别
            //由于配置中的具体到设置文件夹的级别屏蔽了，所以下面的debug无法打印出日志
            log.debug(String.valueOf(obj1));
            log.error(String.valueOf(obj1));
            return obj1;
    }


//        if(contacts == null) {
//            return new ArrayList<SaleQuery>();
//        } else {
//            return contacts;
//        }
    }

    @ResponseBody
    @RequestMapping("/4001")  //4002：销售信息查询
    public JSONObject callProcedure() {
        String begin_date = "2018.01.01";
        String end_date = "2020.01.01";
        String type = "1";
        String inventoryList = "";
        StoredProcedureQuery storedProcedureQuery= saleQueryRepository.callMyProcedure_sale_query(begin_date, end_date, type,
                inventoryList);
        List<SaleQuery> contacts =storedProcedureQuery.getResultList();
//        ResultInfo<List> resultInfo = new ResultInfo<List>();


//        int i= list1.size();
//        System.out.println(String.valueOf(i));
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(contacts);
        JSONObject obj1 = new JSONObject();
        obj1.put("inventoryList",jsonArray);
        obj1.put("message","请求成功");
        obj1.put("code", "0");
        System.out.println(obj1);
        return obj1;

    }
}
