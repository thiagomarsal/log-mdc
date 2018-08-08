Mapped Diagnostic Context - MDC Demo
---------------------------------------------------

Log Configuarion:

    logging.pattern.console=%d{ISO8601} [%-5level] [%thread] [%c{-1}] %message - MDC[transactionId=%X{transactionId}, dateTime=%X{dateTime}] %n

Code Example:

    public void send(String payload) {
        MDC.clear();
        MDC.put("transactionId", UUID.randomUUID().toString());
        MDC.put("dateTime", LocalDateTime.now().toString());
        LOGGER.info("sending payload='{}'", payload);
    }

Log Example:

    2018-08-08 16:59:40,629 [INFO ] [main] [com.example.logmdc.LogMDCApplication] No active profile set, falling back to default profiles: default - MDC[transactionId=, dateTime=] 
    2018-08-08 16:59:41,378 [INFO ] [main] [com.example.logmdc.service.SendMessageService] sending payload='hello-9' - MDC[transactionId=a9c7f38f-a84d-488c-89af-2ea2da26e2c0, dateTime=2018-08-08T16:59:41.378] 