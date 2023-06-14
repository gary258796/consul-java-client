package org.common.consul.api.model.query;

import feign.Param;
import lombok.*;

/**
 * Query params of consul api
 * @author liaoyushao
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryParams {

    /** If api support filter, set if need filter api result */
    @Param("filter")
    private String filter;

    @Param("enable")
    private boolean enable;

    @Param("reason")
    private String reason;

    @Param("expanded")
    private boolean expanded;

}
