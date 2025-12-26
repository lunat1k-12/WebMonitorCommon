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
public class SchedulePageKey {
    @JsonProperty("id")
    private String id;
    @JsonProperty("scheduleId")
    private String scheduleId;
    @JsonProperty("timestampUtc")
    private String timestampUtc;
}
