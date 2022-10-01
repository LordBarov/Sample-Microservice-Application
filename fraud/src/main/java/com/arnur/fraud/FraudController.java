package com.arnur.fraud;

import com.arnur.clients.fraud.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@RequiredArgsConstructor
@Log4j2
public class FraudController {

    private final FraudCheckHistoryService fraudCheckHistoryService;


    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster (@PathVariable("customerId") Integer customerId) {
        boolean isFraud = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer: {}", customerId);
        return new FraudCheckResponse(isFraud);
    }
}
