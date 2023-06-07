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
public class Definition {

    @JsonProperty("Interval")
    private String interval;

    @JsonProperty("Timeout")
    private String timeout;

    @JsonProperty("DeregisterCriticalServiceAfter")
    private String deregisterCriticalServiceAfter;

    @JsonProperty("HTTP")
    private String http;

    @JsonProperty("Header")
    private String header;

    @JsonProperty("Method")
    private String method;

    @JsonProperty("Body")
    private String body;

    @JsonProperty("TLSServerName")
    private String tlsServerName;

    @JsonProperty("TLSSkipVerify")
    private boolean tlsSkipVerify;

    @JsonProperty("TCP")
    private String tcp;

}
