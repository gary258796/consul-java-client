package org.common.consul;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Getter;
import org.common.consul.api.agent.AgentServices;

/**
 * @author liaoyushao
 */
@Getter
public class Consul {

    private final AgentServices agentServices;

    public Consul() {
        Feign.Builder feignBuilder = new Feign.Builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new ErrorDecoder.Default()) // maybe enable client to customize it in the future
                .logLevel(Logger.Level.FULL);

        this.agentServices = new AgentServices(feignBuilder);
    }

}
