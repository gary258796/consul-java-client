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
public class TaggedAddress {

    @JsonProperty("address")
    private String address;

    @JsonProperty("port")
    private int port;

}
