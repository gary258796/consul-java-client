package org.common.consul.api.model.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.common.consul.api.model.common.Proxy;
import org.common.consul.api.model.common.TaggedAddress;
import org.common.consul.api.model.common.Weights;

import java.util.List;
import java.util.Map;

/**
 * Response object of /agent/service/:service_id
 *
 * @author liaoyushao
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceDefinition {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Service")
    private String service;

    @JsonProperty("Tags")
    private List<String> tags;

    @JsonProperty("TaggedAddresses")
    private Map<String, TaggedAddress> taggedAddresses;

    @JsonProperty("Meta")
    private Map<String,String> meta;

    @JsonProperty("Namespace")
    private String nameSpace;

    @JsonProperty("Port")
    private int port;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("EnableTagOverride")
    private boolean enableTagOverride;

    @JsonProperty("Datacenter")
    private String dataCenter;

    @JsonProperty("Weights")
    private Weights weights;

    @JsonProperty("ContentHash")
    private String contentHash;

    @JsonProperty("Proxy")
    private Proxy proxy;

}
