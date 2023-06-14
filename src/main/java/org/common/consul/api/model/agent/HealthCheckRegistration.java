package org.common.consul.api.model.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Info class of a health check to be registered to Consul
 * @author liaoyushao
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthCheckRegistration {

    @NonNull
    @JsonProperty("Name")
    private String name;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Interval")
    private String interval;

    @JsonProperty("Notes")
    private String notes;

    @JsonProperty("DeregisterCriticalServiceAfter")
    private String deregisterCriticalServiceAfter;

    @JsonProperty("Args")
    private List<String> args;

    @JsonProperty("AliasNode")
    private String aliasNode;

    @JsonProperty("AliasService")
    private String aliasService;

    @JsonProperty("DockerContainerID")
    private String dockerContainerId;

    @JsonProperty("GRPC")
    private String grpc;

    @JsonProperty("GRPCUseTLS")
    private boolean grpcUseTls;

    @JsonProperty("H2PING")
    private String h2Ping;

    @JsonProperty("H2PingUseTLS")
    private String h2PingUseTls;

    @JsonProperty("HTTP")
    private String http;

    @JsonProperty("Method")
    private String method;

    @JsonProperty("Body")
    private String body;

    @JsonProperty("DisableRedirects")
    private boolean disableRedirects;

    @JsonProperty("Header")
    private Map<String, List<String>> header;

    @JsonProperty("Timeout")
    private String timeout;

    @JsonProperty("OutputMaxSize")
    private int outputMaxSize;

    @JsonProperty("TLSServerName")
    private String tlsServerName;

    @JsonProperty("TLSSkipVerify")
    private boolean tlsSkipVerify;

    @JsonProperty("TCP")
    private String tcp;

    @JsonProperty("UDP")
    private String udp;

    @JsonProperty("OSService")
    private String osService;

    @JsonProperty("TTL")
    private String ttl;

    @JsonProperty("ServiceID")
    private String serviceId;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("SuccessBeforePassing")
    private int successBeforePassing;

    @JsonProperty("FailuresBeforeWarning")
    private int failuresBeforeWarning;

    @JsonProperty("FailuresBeforeCritical")
    private int failuresBeforeCritical;

}
