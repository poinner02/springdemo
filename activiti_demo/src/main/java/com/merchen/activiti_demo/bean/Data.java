/**
  * Copyright 2022 json.cn 
  */
package com.merchen.activiti_demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2022-12-29 19:15:31
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@lombok.Data
public class Data implements Serializable {

    private String districtCode;
    private String code;
    private String reportName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifytime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date decisionTime;
    private String cityCode;
    private List<String> accidentPropertyList;
    private List<String> accidentInadvanceList;
    private String policyNo;
    private String industry;
    private String accidentTypeItem;
    private String accidentLevel;
    private String safe_status;
    private List<AccidentSurveyList> accidentSurveyList;
    private List<AccidentPaymentCostList> accidentPaymentCostList;
    private int appraisal;
    private String reportMobile;
    private int id;
    private String evalStar;
    private String reportNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String accidentCause;
    private String mgsId;
    private String accidentAddress;
    private String provinceCode;
    private List<AccidentPersonList> accidentPersonList;
    private String accidentType;
    private String commonAccidentType;
    private String recordNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;
    private String accidentDesc;
    private int status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reportTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date accidentTime;

}