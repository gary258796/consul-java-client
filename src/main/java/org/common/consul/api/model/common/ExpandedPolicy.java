
package org.common.consul.api.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpandedPolicy {

    @JsonProperty("ID")
    private String iD;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Rules")
    private String rules;

    @JsonProperty("Datacenters")
    private Object datacenters;

    @JsonProperty("Hash")
    private Object hash;

    @JsonProperty("CreateIndex")
    private Long createIndex;

    @JsonProperty("ModifyIndex")
    private Long modifyIndex;

}
