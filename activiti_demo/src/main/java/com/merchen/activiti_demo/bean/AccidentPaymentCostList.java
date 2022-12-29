/**
  * Copyright 2022 json.cn 
  */
package com.merchen.activiti_demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2022-12-29 19:15:31
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class AccidentPaymentCostList implements Serializable {

    private int thirdPartyPropertyLoss;
    private List<CoinsurancesList> coinsurancesList;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private int thirdPartyDeath;
    private int other;
    private int authenticate;
    private String mgsId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifytime;
    private int prod_claims_id;
    private int accidentRescue;
    private int medicalAid;
    private String type;
    private int litigation;
    private long personalCasualty;
    private String files;
    private int id;
    private int status;

}