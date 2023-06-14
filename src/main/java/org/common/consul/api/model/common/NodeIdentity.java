package org.common.consul.api.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liaoyushao
 */
@Getter
@Setter
public class NodeIdentity {

    @JsonProperty("NodeName")
    private String name;

    @JsonProperty("Datacenter")
    private String datacenters;

}
