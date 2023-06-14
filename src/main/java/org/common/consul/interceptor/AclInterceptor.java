package org.common.consul.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Interceptor for when consul was set as ACL enabled .
 * Will add X-Consul-Token header to all request
 * @author liaoyushao
 */
@Setter
@AllArgsConstructor
public class AclInterceptor implements RequestInterceptor {

    private String secretId;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Consul-Token", secretId);
    }

}
