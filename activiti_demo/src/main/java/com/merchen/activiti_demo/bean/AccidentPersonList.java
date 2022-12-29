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
public class AccidentPersonList implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String gender;
    private String mgsId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifytime;
    private String gender_trans;
    private String idCode;
    private String injuryType;
    private int prod_claims_id;
    private int type;
    private String type_trans;
    private String name;
    private int id;
    private String injuryType_trans;
    private int status;

}