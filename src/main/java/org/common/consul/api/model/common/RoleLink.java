package org.common.consul.api.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liaoyushao
 */
@Getter
@Setter
public class RoleLink {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Name")
    private String name;
}
