package org.common.consul.api.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liaoyushao
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proxy {

    @JsonProperty("DestinationServiceName")
    private String destinationServiceName;

    @JsonProperty("DestinationServiceID")
    private String destinationServiceId;

    @JsonProperty("LocalServiceAddress")
    private String localServiceAddress;

    @JsonProperty("LocalServicePort")
    private int localServicePort;

    @JsonProperty("Mode")
    private String mode;

    @JsonProperty("TransparentProxy")
    private TransparentProxy transparentProxy;
}
