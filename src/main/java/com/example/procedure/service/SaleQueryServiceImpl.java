package com.example.procedure.service;

import com.example.procedure.bean.SaleQuery;
import io.swagger.annotations.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

//@Component
@Service("SaleQueryService")
/**
 * @Controller，@Service，@Repository都有带@Component父注解，
 * 四个注解都可以说成是Component级别的注解；
 * @Service以标记它是一个服务层 Bean
 */
public class SaleQueryServiceImpl implements SaleQueryService {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    /**
     * 调用存储过程时，需要先注入实体管理器EntityManager，
     * 调用其中的 createNamedStoredProcedureQuery方法，传入jpa 的存储过程名称，
     * 然后只需要传入in 参数，执行之后返回StoredProcedureQuery对象。
     */
    @Override
    public List<SaleQuery> findSaleQueryProc(String begin_date, String end_date, String type, String inventoryList) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("spwxxyysalequery");
        storedProcedureQuery.setParameter("begin_date", begin_date);
        storedProcedureQuery.setParameter("end_date", end_date);
        storedProcedureQuery.setParameter("type", type);
        storedProcedureQuery.setParameter("inventoryList", inventoryList);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
    }
}
