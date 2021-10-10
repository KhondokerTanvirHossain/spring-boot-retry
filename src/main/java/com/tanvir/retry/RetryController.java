package com.tanvir.retry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/retry")
public class RetryController {

    @Autowired
    private RetryService billingService;
    @GetMapping
    public String callRetryService() throws Exception {
        return billingService.simpleRetry();
    }

}
