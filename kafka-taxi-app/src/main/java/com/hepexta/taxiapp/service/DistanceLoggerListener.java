package com.hepexta.taxiapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DistanceLoggerListener {

    @KafkaListener(id = "logGroup", topics = "taxiTopic")
    public void dltListen(String in) {
        log.info("Received from topic: " + in);
    }

}
