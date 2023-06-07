package org.common.consul.api.model.query;

import feign.Param;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author liaoyushao
 */
@Getter
@Setter
public class QueryParams {

    /** If api support filter, set if need filter api result */
    @Param("filter")
    private String filter;

}
