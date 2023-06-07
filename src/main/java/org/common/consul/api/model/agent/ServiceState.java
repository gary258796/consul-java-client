package org.common.consul.api.model.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.common.consul.api.model.common.Check;

import java.util.List;

/**
 * Response object of /agent/health/service/name/:service_name
 *
 * @author liaoyushao
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceState {

    @JsonProperty("AggregatedStatus")
    private String aggregatedStatus;

    @JsonProperty("Service")
    private Service service;

    @JsonProperty("Checks")
    private List<Check> checks;

}
