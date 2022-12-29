/**
  * Copyright 2022 json.cn 
  */
package com.merchen.activiti_demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Auto-generated: 2022-12-29 19:15:31
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class CoinsurancesList implements Serializable {

    private int paymentProportion;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private int prod_claims_compensation_id;
    private String mgsId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifytime;
    private String insuranceOrganizationId;
    private String ismain;
    private int id;
    private int status;

}