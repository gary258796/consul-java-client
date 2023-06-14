package org.common.consul.api.model.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.common.consul.api.model.common.Proxy;
import org.common.consul.api.model.common.TaggedAddress;
import org.common.consul.api.model.common.Weights;

import java.util.List;
import java.util.Map;

/**
 * Info class of a service to be registered to Consul
 * @author liaoyushao
 */
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRegistrationInfo {

    @NonNull
    @JsonProperty("Name")
    private String name;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Tags")
    private List<String> tags;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("TaggedAddresses")
    private Map<String, TaggedAddress> taggedAddresses;

    @JsonProperty("Meta")
    private Map<String, String> meta;

    @JsonProperty("Port")
    private int port;

    @JsonProperty("Kind")
    private String kind;

    @JsonProperty("Proxy")
    private Proxy proxy;

    @JsonProperty("EnableTagOverride")
    private boolean enableTagOverride;

    @JsonProperty("Weights")
    private Weights weights;

}
