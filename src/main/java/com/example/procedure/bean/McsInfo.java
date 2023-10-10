package com.example.procedure.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
//@Table(name = "McsInfo")
@Data //@Data注解的主要作用是提高代码的简洁，使用这个注解可以省去实体类中大量的get()、 set()、 toString()等方法。
@AllArgsConstructor
@NoArgsConstructor
//@EntityListeners(McsInfo.class)
/**
 * 在实体类上增加了@EntityListeners(EntityListener.class)的注解后，
 * 在保存或更新该实体时，会自动调用注册的实体监听器对创建/更新时间进行赋值。
 */
//@ApiModel(value = "4004-采购药品清单查询")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "spwxxyymcsinfo",
                procedureName = "sp_wxxyy_mcs_info",
                resultClasses = { McsInfo.class },
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "currentpage", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pagesize", type = Integer.class),
//                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "num", type = Integer.class)  // 记录满足条件的总条数
                }
        )
})
public class McsInfo implements Serializable {
    @Id
    private String mcs_prod_id; //耗材产品 id	字符型	40
    private String mcs_code; //耗材代码	字符型	100
    private String mcs_name; //耗材名称	字符型	500
    private String mcs_regno; //耗材注册证编号	字符型	100
    private String mcs_regcert_name; //耗材注册证名称	字符型	200
    private Integer convrat; //转换比	int
    private String mcs_matl; //耗材材质	字符型	500		数据字典，详见字典 【pacmatl】
    private String pacmatl; //包装材质	字符型	500
    private String minunt_code; //最小使用单位代码	字符型	10
    private String minunt_name; //最小使用单位名称	字符型	10
    private String minpacunt_code; //最小包装单位代码	字符型	10
    private String minpacunt_name; //最小包装单位名称	字符型	50
    private String min_sel_emp_code; //最小销售单位代码	字符型	10
    private String min_sel_emp_name; //最小销售单位名称	字符型	30	数据字典，详见字典【mcs_spec】
    private String mcs_spec; //耗材规格	字符型	500
    private String mcs_mol; //耗材型号	字符型	500
    private String mcs_genname_code; //耗材通用名代码	字符型	50
    private String mcs_genname; //耗材通用名	字符型	100
    private String med_mcs_type_code; //医用耗材分类代码	字符型	50
    private String mcs_type_lv1_code; //耗材分类一级代码	字符型	20
    private String mcs_type_lv1_name; //耗材分类一级名称	字符型	100
    private String mcs_type_lv2_code; //耗材分类二级代码	字符型	20
    private String mcs_type_lv2_name; //耗材分类二级名称	字符型	100
    private String mcs_type_lv3_code; //耗材分类三级代码	字符型	20
    private String mcs_type_lv3_name; //耗材分类三级名称	字符型	100
    private String prodstrd; //产品标准	字符型	100
    private String manu_addr; //生产地址	字符型	2048
    private String expy; //有效期	字符型	40
    private String apb_scp; //适用范围	longtext
    private String perf_comp; //性能组成	text
    private String img_file_id; //图片文件 id	字符型	500
    private String manl_file_id; //说明书文件 id	字符型	500
    private String prod_qlt_std; //产品质量标准	字符型	200
    private String prod_istr; //产品使用方法	字符型	100
    private String sped_name; //专机名称	字符型	20
    private String comb_name; //组套名称	字符型	20		数据字典，详见字典【mcs_prod_souc】
    private String mcs_prod_souc_code; //耗材产品来源代码	字符型	10 数据字典，详见字典【highval_mcs_flag】
    private String highval_mcs_flag; //高值耗材标志	字符型	3	数据字典，详见字典【stlz_flag】
    private String stlz_flag; //灭菌标志	字符型	3
    private String itvt_clss_flag; //介入类标志	字符型	3数据字典，详见字典【dspo_used_flag】
    private String dspo_used_flag; //一次性使用标志	字符型	3
    private String mcs_type_genname_code; //耗材分类通用名代码	字符型	20
    private String mcs_type_genname_name; //耗材分类通用名名称	字符型	100
    private String mcs_type_matl_code; //耗材分类材质代码	字符型	20
    private String mcs_type_matl_name; //耗材分类材质名称	字符型	100
    private String mcs_type_spec_code; //耗材分类规格代码	字符型	20
    private String mcs_type_spec_name; //耗材分类规格名称	字符型	100
    private String sin_id; //单件 id	字符型	40
    private String mcs_regcert_id; //耗材注册证 id	字符型	40
    private String spec_mol_id; //规格型号 id	字符型	40
    private String udi; //医疗器械唯一标识码	字符型	500
    private BigDecimal purc_pric; //采购价格	数字型	10;4	是
    private String vol_type; //带量标志	字符型	3	是
    private String attribute; //属性	字符型	3	是
    @JsonProperty("COLL_TYPE")
    private Integer COLL_TYPE; //回款周期类型	int	1	否	2、按月	1、按天
    @JsonProperty("COLL_TIME")
    private Integer COLL_TIME; //回款周期	int	4	否
    private String delventp_code; //配送企业编码	字符型	 64
    private String delventp_name; //配送企业名称	字符型	 64
    private String his_bidprcu_item_id; //his端项目编码	字符型	40	是
}
