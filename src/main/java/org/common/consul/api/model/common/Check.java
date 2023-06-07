package org.common.consul.api.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author liaoyushao
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Check {

    @JsonProperty("Node")
    private String node;

    @JsonProperty("CheckID")
    private String checkId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("Output")
    private String output;

    @JsonProperty("ServiceID")
    private String serviceId;

    @JsonProperty("ServiceName")
    private String serviceName;

    @JsonProperty("ServiceTags")
    private List<String> serviceTags;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Namespace")
    private String namespace;

    @JsonProperty("Definition")
    private Definition definition;

    @JsonProperty("CreateIndex")
    private int createIndex;

    @JsonProperty("ModifyIndex")
    private int modifyIndex;

}
