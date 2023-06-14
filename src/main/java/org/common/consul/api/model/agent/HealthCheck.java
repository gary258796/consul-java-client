package org.common.consul.api.model.agent;

import lombok.*;
import org.common.consul.api.model.common.Definition;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author liaoyushao
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthCheck {

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

    @JsonProperty("Interval")
    private String interval;

    @JsonProperty("Timeout")
    private String timeout;

    @JsonProperty("ExposedPort")
    private int exposedPort;

    @JsonProperty("Definition")
    private Definition Definition;

    @JsonProperty("CreateIndex")
    private int createIndex;

    @JsonProperty("ModifyIndex")
    private int modifyIndex;

}
