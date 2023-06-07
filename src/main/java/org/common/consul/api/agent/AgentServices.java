package org.common.consul.api.agent;

import feign.*;
import org.apache.commons.lang3.StringUtils;
import org.common.consul.api.BaseApi;
import org.common.consul.api.model.agent.Service;
import org.common.consul.api.model.agent.ServiceDefinition;
import org.common.consul.api.model.agent.ServiceRegistrationInfo;
import org.common.consul.api.model.agent.ServiceState;
import org.common.consul.api.model.query.QueryParams;
import org.common.consul.util.UrlEncodeUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Client of /agent/service endpoints
 * @author liaoyushao
 */
public class AgentServices extends BaseApi {

    /** Api interface */
    private final Api api;

    public AgentServices(Feign.Builder feignBuilder) {
        this.api = feignBuilder.target(Api.class, DEFAULT_CONSUL_URL);
    }

    /**
     * Full service definition for a single service instance registered with the local agent
     * @param serviceId : ID of the service
     * @return Service full info
     */
    public ServiceDefinition getService(String serviceId) {
        return this.api.getService(serviceId);
    }

    /**
     * All services that are registered with the local agent.
     * You can know a service id is registered in consul by checking if the id contains in the result of this Api
     * @param queryParams : Filter of result services
     * @return list of registered services
     */
    public Map<String, Service> getServices(QueryParams queryParams) {

        if (queryParams == null) {
            queryParams = new QueryParams(); // Init a new empty QueryParams
        }

        return this.api.getServices(queryParams);
    }

    /**
     * TODO: Not able to be called yet since we didnt handle status code 400, 404, 429 , 503 for this api.
     * Retrieve an aggregated state of service(s) on the local agent by name
     * @param serviceName : Name of the service
     * @return All Service's state with name
     */
    @Deprecated
    private List<ServiceState> getServiceHealthStateByName(String serviceName) {
        return this.api.getServiceHealthStateByName(serviceName);
    }

    /**
     * TODO: Not able to be called yet since we didnt handle status code 400, 404, 429 , 503 for this api.
     * Retrieve an aggregated state of service on the local agent by ID
     * @param serviceId : ID of the service
     * @return Service state with ID
     */
    @Deprecated
    private ServiceState getServiceHealthStateById(String serviceId) {
        return this.api.getServiceHealthStateById(serviceId);
    }

    /**
     * Adds a new service, with optional health checks, to the local agent.
     * @param registrationInfo : Registration info of service to be registered into Consul
     */
    public void register(ServiceRegistrationInfo registrationInfo) {
        this.api.register(registrationInfo);
    }

    /**
     * Removes a service from the local agent
     * @param serviceId : Service ID Of to be removed service
     */
    public void deRegister(String serviceId) {
        this.api.deRegister(serviceId);
    }

    /**
     * Config service into maintenance mode or not.
     * During maintenance mode, the service will be marked as unavailable and will not be present in DNS or API queries.
     * @param serviceId : Service ID of service to do the configuration
     * @param enable : Enable maintenance mode
     * @param reason : Reason to enable or disable maintenance mode
     */
    public void configMaintenance(String serviceId, boolean enable, String reason) throws UnsupportedEncodingException {
        this.api.configMaintenance(serviceId, enable, StringUtils.isEmpty(reason) ? "" : UrlEncodeUtils.encode(reason));
    }

    /** Api interface for /agent/service endpoints */
    @Headers("Accept: application/json")
    private interface Api {

        @RequestLine("GET /agent/services")
        Map<String, Service> getServices(@QueryMap QueryParams queryParams);

        @RequestLine("GET /agent/service/{serviceId}")
        ServiceDefinition getService(@Param("serviceId") String serviceId);

        @RequestLine("GET /agent/health/service/name/{serviceName}")
        List<ServiceState> getServiceHealthStateByName(@Param("serviceName") String serviceName);

        @RequestLine("GET /agent/health/service/id/{serviceId}")
        ServiceState getServiceHealthStateById(@Param("serviceId") String serviceId);

        @RequestLine("PUT /agent/service/register")
        void register(ServiceRegistrationInfo registrationInfo);

        @RequestLine("PUT /agent/service/deregister/{serviceId}")
        void deRegister(@Param("serviceId") String serviceId);

        @RequestLine("PUT /agent/service/maintenance/{serviceId}?enable={enable}&reason={reason}")
        void configMaintenance(@Param("serviceId") String serviceId, @Param("enable") boolean enable, @Param("reason") String reason);

    }
}
