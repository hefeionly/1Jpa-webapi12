package com.example.procedure.service;

import com.example.procedure.bean.McsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Component
public class McsInfoService {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<McsInfo> findMcsInfoProc(Integer currentpage, Integer pagesize) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("spwxxyymcsinfo");
        storedProcedureQuery.setParameter("currentpage", currentpage);
        storedProcedureQuery.setParameter("pagesize", pagesize);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
    }
}
