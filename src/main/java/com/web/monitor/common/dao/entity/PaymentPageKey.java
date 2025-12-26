package com.web.monitor.common.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPageKey {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("stripeId")
    private String stripeId;
    @JsonProperty("timestampUtc")
    private String timestampUtc;
}
