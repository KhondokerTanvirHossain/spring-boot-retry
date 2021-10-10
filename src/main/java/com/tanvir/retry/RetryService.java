package com.tanvir.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetryService.class);
    int counter =0;

    @Retryable(value = { Exception.class }, maxAttempts = 3,  backoff = @Backoff(delay = 90000, multiplier = 2, maxDelay = 180000))

    public String simpleRetry() throws Exception {
        counter++;
        LOGGER.info("Retry Service Failed "+ counter);
        throw new Exception();

    }

    @Recover
    public String recover(Exception t){
        LOGGER.info("Service recovering");
        return "Service recovered from retry service failure.";
    }
}
