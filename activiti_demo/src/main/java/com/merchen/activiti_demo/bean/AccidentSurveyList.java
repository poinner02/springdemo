/**
  * Copyright 2022 json.cn 
  */
package com.merchen.activiti_demo.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * Auto-generated: 2022-12-29 19:15:31
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class AccidentSurveyList implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String surveyPersonName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date surveyTime;
    private String mgsId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifytime;
    private String surveyDesc;
    private int prod_claims_id;
    private String surveyPersonPhone;
    private String prod_state;
    private int id;
    private int status;

}