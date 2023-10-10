package com.example.procedure.service;

import com.example.procedure.bean.DrugInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Component
public class DrugInfoService {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<DrugInfo> findDrugInfoProc(Integer currentpage, Integer pagesize) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("spwxxyydruginfo");
        storedProcedureQuery.setParameter("currentpage", currentpage);
        storedProcedureQuery.setParameter("pagesize", pagesize);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
    }
}
