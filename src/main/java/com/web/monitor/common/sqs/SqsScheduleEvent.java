package com.web.monitor.common.sqs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SqsScheduleEvent {

    private String userId;
    private String scheduleId;
    private String targetUrl;
    private String userPrompt;
    private Integer windowHeight;
    private String selector;
    private Boolean previewOnly;
}
