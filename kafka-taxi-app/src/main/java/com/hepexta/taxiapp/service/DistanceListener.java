package com.hepexta.taxiapp.service;

import com.hepexta.taxiapp.model.Position;
import com.hepexta.taxiapp.repository.PositionStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DistanceListener {

    private final PositionStorage positionStorage;

    @KafkaListener(id = "distanceCalculationGroup", topics = "taxiTopic")
    public void listen(Position position) {
        log.info("Received: " + position);
        positionStorage.upsert(position);
    }

}
