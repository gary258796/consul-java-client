package org.common.consul;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.common.consul.api.acl.AclToken;
import org.common.consul.api.agent.AgentChecks;
import org.common.consul.api.agent.AgentServices;
import org.common.consul.interceptor.AclInterceptor;

/**
 * @author liaoyushao
 */
@Getter
public class Consul {

    private AgentServices agentServices;

    private AgentChecks agentChecks;

    private AclToken aclToken;

    public Consul() {
        Feign.Builder feignBuilder = new Feign.Builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ErrorDecoder.Default()) // maybe enable client to customize it in the future
                .logLevel(Logger.Level.FULL);

        initEndpoints(feignBuilder);
    }

    public Consul(Feign.Builder feignBuilder) {
        initEndpoints(feignBuilder);
    }

    /**
     * New Builder class of Consul
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String secretId;

        public Builder() {
        }

        /**
         * Add secretId when ACL is enabled in Consul
         * @param secretId : The Secret Id
         */
        public Builder withAclEnabled(String secretId) {
            this.secretId = secretId;
            return this;
        }

        public Consul build() {

            Feign.Builder feignBuilder = new Feign.Builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new ErrorDecoder.Default()) // maybe enable client to customize it in the future
                    .logLevel(Logger.Level.FULL);

            if (StringUtils.isNotEmpty(secretId)) {
                AclInterceptor aclInterceptor = new AclInterceptor(secretId);
                feignBuilder.requestInterceptor(aclInterceptor);
            }

            return new Consul(feignBuilder);
        }
    }

    private void initEndpoints(Feign.Builder feignBuilder) {
        this.agentServices = new AgentServices(feignBuilder);
        this.agentChecks = new AgentChecks(feignBuilder);
        this.aclToken = new AclToken(feignBuilder);
    }

}
