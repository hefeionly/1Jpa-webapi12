package com.example.procedure.service;

import com.example.procedure.bean.InventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Component
public class InventoryDtoService {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<InventoryDto> findInventoryDtoProc(String type, String inventoryList) {
        StoredProcedureQuery storedProcedureQuery = this.entityManager.createNamedStoredProcedureQuery("spwxxyyinventorydto");
        storedProcedureQuery.setParameter("type", type);
        storedProcedureQuery.setParameter("inventoryList", inventoryList);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
    }
}
