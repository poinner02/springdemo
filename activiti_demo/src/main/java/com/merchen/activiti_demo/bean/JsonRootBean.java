/**
 * Copyright 2022 json.cn
 */
package com.merchen.activiti_demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Auto-generated: 2022-12-29 19:15:31
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class JsonRootBean implements Serializable {

    @JsonProperty("TOTAl")
    private int TOTAl;
    @JsonProperty("BATCHID")
    private String BATCHID;
    @JsonProperty("MESSAGE")
    private String MESSAGE;
    @JsonProperty("RESULTINFO")
    private RESULTINFO RESULTINFO;
    @JsonProperty("FLAG")
    private boolean FLAG;
}