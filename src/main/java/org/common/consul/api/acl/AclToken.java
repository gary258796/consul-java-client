package org.common.consul.api.acl;

import feign.*;
import org.common.consul.api.BaseApi;
import org.common.consul.api.model.acl.Token;
import org.common.consul.api.model.acl.TokenResponse;
import org.common.consul.api.model.query.QueryParams;

/**
 * Client of /acl/token endpoints
 * @author liaoyushao
 */
public class AclToken extends BaseApi {

    /** Api interface */
    private final Api api;

    public AclToken(Feign.Builder feignBuilder) {
        this.api = feignBuilder.target(Api.class, DEFAULT_CONSUL_URL);
    }

    /**
     * Create a new ACL Token
     */
    public TokenResponse create(Token token) {
        return this.api.create(token);
    }

    /**
     * Reads an ACL token with the given Accessor ID.
     * @param accessorId : The accessorId
     */
    public TokenResponse get(String accessorId) {
        return this.api.get(accessorId);
    }

    /**
     * Reads an ACL token with the given Accessor ID.
     * @param accessorId : The accessorId
     * @param expanded : If this field is set, the contents of all policies and roles affecting the token will also be returned.
     */
    public TokenResponse get(String accessorId, boolean expanded) {
        QueryParams queryParams = new QueryParams();
        queryParams.setExpanded(expanded);
        return this.api.get(accessorId, queryParams);
    }

    /** Api interface for /acl/token endpoints */
    @Headers("Accept: application/json")
    private interface Api {

        @RequestLine("PUT /acl/token")
        TokenResponse create(Token token);

        @RequestLine("GET /acl/token/{accessorId}")
        TokenResponse get(@Param("accessorId") String accessorId);

        @RequestLine("GET /acl/token/{accessorId}")
        TokenResponse get(@Param("accessorId") String accessorId, @QueryMap QueryParams queryParams);

    }
}
