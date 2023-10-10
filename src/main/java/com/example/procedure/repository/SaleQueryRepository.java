package com.example.procedure.repository;

import com.example.procedure.bean.SaleQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

//这种调用存储过程调不通
@NamedStoredProcedureQuery(
        name = "SaleQuery.callMyProcedure_sale_query",
        procedureName = "sp_wxxyy_sale_query",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "begin_date", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "end_date", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "type", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "inventoryList", type = String.class)
//                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = String.class)
        }
)

@Repository
public interface SaleQueryRepository extends JpaRepository<SaleQuery,Long> {
//    @Query(value = "exec sp_wxxyy_sale_query @begin_date=?1,@end_date=?2,@type=?3,@inventoryList=?4",
//            nativeQuery = true)
//    List<Object[]> getTest(String bd, String ed, String type, String inventoryList);

    @Modifying
    @Transactional(timeout = 10)
    @Procedure("sp_wxxyy_sale_query")
    StoredProcedureQuery callMyProcedure_sale_query(@Param("begin_date") String begin_date, @Param("end_date") String end_date,
                                                    @Param("type") String type, @Param("inventoryList") String inventoryList);
}
