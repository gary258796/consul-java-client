package org.common.consul.api.model.acl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.common.consul.api.model.common.NodeIdentity;
import org.common.consul.api.model.common.PolicyLink;
import org.common.consul.api.model.common.RoleLink;
import org.common.consul.api.model.common.ServiceIdentity;

import java.util.List;

/**
 * @author liaoyushao
 */
@Getter
@Setter
@Builder
public class Token {

    @JsonProperty("AccessorID")
    private String accessorId;

    @JsonProperty("SecretID")
    private String secretId;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Policies")
    private List<PolicyLink> policies;

    @JsonProperty("Roles")
    private List<RoleLink> roles;

    @JsonProperty("ServiceIdentities")
    private List<ServiceIdentity> serviceIdentities;

    @JsonProperty("NodeIdentities")
    private List<NodeIdentity> nodeIdentities;

    @JsonProperty("Local")
    private boolean local;

    @JsonProperty("AuthMethod")
    private String authMethod;

    @JsonProperty("ExpirationTime")
    private String expirationTime;

    @JsonProperty("ExpirationTTL")
    private String expirationTTL;

}
