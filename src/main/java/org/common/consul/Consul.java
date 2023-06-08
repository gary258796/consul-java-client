package org.common.consul;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Getter;
import org.common.consul.api.agent.AgentChecks;
import org.common.consul.api.agent.AgentServices;

/**
 * @author liaoyushao
 */
@Getter
public class Consul {

    private AgentServices agentServices;

    private AgentChecks agentChecks;

    public Consul() {
        Feign.Builder feignBuilder = new Feign.Builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ErrorDecoder.Default()) // maybe enable client to customize it in the future
                .logLevel(Logger.Level.FULL);

        initEndpoints(feignBuilder);
    }

    private void initEndpoints(Feign.Builder feignBuilder) {
        this.agentServices = new AgentServices(feignBuilder);
        this.agentChecks = new AgentChecks(feignBuilder);
    }
}
