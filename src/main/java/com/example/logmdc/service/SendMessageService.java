package com.example.logmdc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SendMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMessageService.class);

    public void send(String payload) {
        MDC.clear();
        MDC.put("transactionId", UUID.randomUUID().toString());
        MDC.put("dateTime", LocalDateTime.now().toString());
        LOGGER.info("sending payload='{}'", payload);
    }
}
