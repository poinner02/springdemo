/**
  * Copyright 2022 json.cn 
  */
package com.merchen.activiti_demo.bean;
import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2022-12-29 19:15:31
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@lombok.Data
public class RESULTINFO implements Serializable {

    private String msg;
    private int apiError;
    private List<Data> data;
    private int error;
    private String subMessage;
    private String errorMsg;

}