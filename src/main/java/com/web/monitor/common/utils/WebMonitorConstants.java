package com.web.monitor.common.utils;

import java.util.Map;

public class WebMonitorConstants {
    private WebMonitorConstants() {}

    public static final String USER_ID_KEY = "userId";
    public static final String STRIPE_CUSTOMER_SUBSCRIPTION_CREATED = "customer.subscription.created";
    public static final String INVOICE_PAYMENT_SUCCEEDED_EVENT = "invoice.payment_succeeded";

    public static final String SUBSCRIPTION_PLAN_KEY = "subscriptionPlan";
    public static final String BASIC_SUBSCRIPTION_PLAN = "basic";
    public static final String PRO_SUBSCRIPTION_PLAN = "pro";
    public static final String FREE_SUBSCRIPTION_PLAN = "free";

    public final static String DEFAULT_STATE = "ORANGE";
    public final static String DAILY_SCHEDULE = "DAILY";
    public final static String WEEKLY_SCHEDULE = "WEEKLY";
    public final static String SIX_HOURS_SCHEDULE = "6HOURS";

    public final static String PAUSED_STATE = "PAUSED";
    public final static String GREEN_STATE = "GREEN";
    public final static String LINK_PROCESSOR_QUEUE_URL = "https://sqs.us-east-1.amazonaws.com/918068445959/LinkProcessQueue";

    public static final String SECRET = "dsaAS{#@d}safWEF23-ewq@$RFS";

    public final static Map<String, UsageLimits> USAGE_LIMITS = Map.of(
            BASIC_SUBSCRIPTION_PLAN, new UsageLimits(0, 3, 2),
            PRO_SUBSCRIPTION_PLAN, new UsageLimits(1, 4, 3),
            FREE_SUBSCRIPTION_PLAN, new UsageLimits(0, 1, 0));
}
