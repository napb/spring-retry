package com.example.retry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryConfig {

    @Value("${retry.back-off-period}")
    Integer retryBackOffPeriod;

    @Value("${retry.set-max-attempts}")
    Integer retrySetMaxAttempts;


    /**
     *
     * @return
     */
    @Bean
    public RetryTemplate retryTemplate() {

        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(retryBackOffPeriod);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(retrySetMaxAttempts);
        retryTemplate.setRetryPolicy(retryPolicy);

        //retryTemplate.registerListener(new DefaultRetryListener());

        return retryTemplate;
    }
}
