package org.common.consul.api.agent;

import feign.*;
import org.common.consul.api.BaseApi;
import org.common.consul.api.enums.TtlCheckStatus;
import org.common.consul.api.model.agent.HealthCheck;
import org.common.consul.api.model.agent.HealthCheckRegistration;
import org.common.consul.api.model.query.QueryParams;

import java.util.Map;

/**
 * Client of /agent/check endpoints
 * @author liaoyushao
 */
public class AgentChecks extends BaseApi {

    /** Api interface */
    private final Api api;

    public AgentChecks(Feign.Builder feignBuilder) {
        this.api = feignBuilder.target(Api.class, DEFAULT_CONSUL_URL);
    }

    /**
     * All health checks that are registered with the local agent.
     * @return all checks
     */
    public Map<String, HealthCheck> getHealthChecks() {
        return this.api.getHealthChecks();
    }

    /**
     * All health checks that are registered with the local agent.
     * @param filter : Filter of result checks
     * @return list of checks
     */
    public Map<String, HealthCheck> getHealthChecks(String filter) {
        QueryParams queryParams = new QueryParams();
        queryParams.setFilter(filter);
        return this.api.getHealthChecks(queryParams);
    }

    /**
     * Adds a new check to the local agent
     * @param registrationInfo : Registration info of check to be registered into Consul
     */
    public void register(HealthCheckRegistration registrationInfo) {
        this.api.register(registrationInfo);
    }

    /**
     * Remove a check from the local agent.
     * @param checkId : The checkId
     */
    public void deregister(String checkId) {
        this.api.deregister(checkId);
    }

    /**
     * Set the status of the check
     * @param status : Updated status
     * @param checkId : The CheckId
     */
    public void changeTtlStatus(TtlCheckStatus status, String checkId) {
        this.api.ttlCheck(status.getCode(), checkId);
    }

    /** Api interface for /agent/check endpoints */
    @Headers("Accept: application/json")
    private interface Api {

        @RequestLine("GET /agent/checks")
        Map<String, HealthCheck> getHealthChecks();

        @RequestLine("GET /agent/checks")
        Map<String, HealthCheck> getHealthChecks(@QueryMap QueryParams queryParams);

        @RequestLine("PUT /agent/check/register")
        void register(HealthCheckRegistration registrationInfo);

        @RequestLine("PUT /agent/check/deregister/{checkId}")
        void deregister(@Param("checkId") String checkId);

        @RequestLine("PUT /agent/check/{checkStatus}/{checkId}")
        void ttlCheck(@Param("checkStatus") String checkStatus, @Param("checkId") String checkId);

    }

}
