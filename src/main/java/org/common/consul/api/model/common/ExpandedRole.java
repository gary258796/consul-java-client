
package org.common.consul.api.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.common.consul.api.model.common.PolicyLink;
import org.common.consul.api.model.common.ServiceIdentity;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpandedRole {

    @JsonProperty("ID")
    private String iD;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Policies")
    private List<PolicyLink> policies;

    @JsonProperty("ServiceIdentities")
    private List<ServiceIdentity> serviceIdentities;

    @JsonProperty("Hash")
    private Object hash;

    @JsonProperty("CreateIndex")
    private Long createIndex;

    @JsonProperty("ModifyIndex")
    private Long modifyIndex;

}
