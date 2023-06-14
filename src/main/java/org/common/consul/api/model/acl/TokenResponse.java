package org.common.consul.api.model.acl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.common.consul.api.model.common.ExpandedPolicy;
import org.common.consul.api.model.common.ExpandedRole;
import org.common.consul.api.model.common.PolicyLink;

import java.util.Date;
import java.util.List;

/**
 * @author liaoyushao
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponse {

    @JsonProperty("AccessorID")
    private String accessorId;

    @JsonProperty("SecretID")
    private String secretId;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Policies")
    private List<PolicyLink> policies;

    @JsonProperty("Local")
    private boolean local;

    @JsonProperty("CreateTime")
    private Date createTime;

    @JsonProperty("Hash")
    private String hash;

    @JsonProperty("ExpandedPolicies")
    private List<ExpandedPolicy> expandedPolicies;

    @SerializedName("ExpandedRoles")
    private List<ExpandedRole> expandedRoles;

    @JsonProperty("NamespaceDefaultPolicies")
    private Object namespaceDefaultPolicies;

    @JsonProperty("NamespaceDefaultRoles")
    private Object namespaceDefaultRoles;

    @JsonProperty("AgentACLDefaultPolicy")
    private String agentACLDefaultPolicy;

    @JsonProperty("AgentACLDownPolicy")
    private String agentACLDownPolicy;

    @JsonProperty("ResolvedByAgent")
    private String resolvedByAgent;

    @JsonProperty("CreateIndex")
    private int createIndex;

    @JsonProperty("ModifyIndex")
    private int modifyIndex;


}
