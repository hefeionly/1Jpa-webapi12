package com.example.procedure.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
//@Table(name = "InventoryDto")
@Data //@Data注解的主要作用是提高代码的简洁，使用这个注解可以省去实体类中大量的get()、 set()、 toString()等方法。
@AllArgsConstructor
@NoArgsConstructor
//@EntityListeners(InventoryDto.class)
/**
 * 在实体类上增加了@EntityListeners(EntityListener.class)的注解后，
 * 在保存或更新该实体时，会自动调用注册的实体监听器对创建/更新时间进行赋值。
 */
//@ApiModel(value = "4003-库存信息查询")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "spwxxyyinventorydto",
                procedureName = "sp_wxxyy_inventory_dto",
                resultClasses = { InventoryDto.class },
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "type", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inventoryList", type = String.class),
//                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "num", type = Integer.class)  // 记录满足条件的总条数
                }
        )
})
public class InventoryDto implements Serializable {
    @Id
    private String his_bidprcu_item_id;
    private String info_id;
    private String serial_code;
    private String info_type;
    private String prod_name;
    private String prodentp_code;
    private BigDecimal sales_num;
    private BigDecimal inventory_num;
    private BigDecimal hosp_purc_pric;
}
