package com.example.procedure.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
//@Table(name = "DrugInfo")
@Data //@Data注解的主要作用是提高代码的简洁，使用这个注解可以省去实体类中大量的get()、 set()、 toString()等方法。
@AllArgsConstructor
@NoArgsConstructor
//@EntityListeners(DrugInfo.class)
/**
 * 在实体类上增加了@EntityListeners(EntityListener.class)的注解后，
 * 在保存或更新该实体时，会自动调用注册的实体监听器对创建/更新时间进行赋值。
 */
//@ApiModel(value = "4004-采购药品清单查询")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "spwxxyydruginfo",
                procedureName = "sp_wxxyy_drug_info",
                resultClasses = { DrugInfo.class },
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "currentpage", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pagesize", type = Integer.class),
//                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "num", type = Integer.class)  // 记录满足条件的总条数
                }
        )
})
public class DrugInfo implements Serializable {
    @Id
    private String drug_info_id;
    private String drug_code;
    private String drug_name;
    private String drug_name_eng;
    private String drug_name_pinyin;
    private String drug_prodname;
    private String genname_code;
    private String genname;
    private String dosform_code;
    private String dosform_name;
    private String rute_code;
    private String rute_name;
    private String acdbas_code;
    private String acdbas_name;
    private String otc_attr_code;
    private String otc_attr_name;
    private String pham_type_code_1;
    private String pham_type_code_2;
    private String pham_type_code_3;
    private String pham_type_code_4;
    private String pham_type_name_1;
    private BigDecimal purc_pric;
    private String vol_type;
    private String attribute;
    @JsonProperty("COLL_TYPE")
    private Integer COLL_TYPE;
    @JsonProperty("COLL_TIME")
    private Integer COLL_TIME;
    private String notes;
    private String prodentp_name;
    private String prxy_entp_code;
    private String prxy_entp_name;
    private String subpck_entp_code;
    private String subpck_entp_name;
    private String pac;
    private Integer convrat;
    private String minunt_code;
    private String minunt_name;
    private String minpacunt_code;
    private String minpacunt_name;
    private String min_sel_emp_code;
    private String min_sel_emp_name;
    private String pacmatl_code;
    private String pacmatl_name;
    private String prod_type;
    private String prod_souc_name;
    private String drugstdcode;
    private String nat_drug_no;
    private String aprvno;
    private String aprvno_expy_begntime;
    private String aprvno_expy_endtime;
    private String regno;
    private String regcert_expy_begntime;
    private String regcert_expy_endtime;
    private String regstd;
    private String drug_expy;
    private String dayuse;
    private String bas_medn_flag;
    private String hi_nego_drug_flag;
    private String prod_type_name;
    private String prod_souc_code;
    private String lstd_druglist_drug;
    private String wubi;
    private String genname_codg;
    private String nat_hi_druglist_chrgitm_lv;
    private String nat_hi_druglist_dosform;
    private String nat_hi_druglist_memo;
    private String delventp_code;
    private String delventp_name;
    private String his_bidprcu_item_id;
    private String save_prop;
    private String serial_code;
    private String retn_attribute;
    private String xmmc;
    private String jysx;
    private String his_attribute;
    private String purc_type;
}
