package org.common.consul.api.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author liaoyushao
 */
@Getter
@Setter
public class ServiceIdentity {

    @JsonProperty("ServiceName")
    private String name;

    @JsonProperty("Datacenters")
    private List<String> datacenters;

}
