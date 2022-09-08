package com.hepexta.taxiapp.controller;

import com.hepexta.taxiapp.model.Position;
import com.hepexta.taxiapp.service.DistanceCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class TaxiController {

    private final KafkaTemplate<Object, Object> template;
    private final DistanceCalculator distanceCalculator;

    @PostMapping(path = "/send/taxi/{carId}")
    public void sendCoordinates(@PathVariable String carId, @RequestParam BigDecimal xCoord, @RequestParam BigDecimal yCoord) {
        this.template.send("taxiTopic", Position.builder()
                .carId(carId)
                .xCoord(xCoord)
                .yCoord(yCoord)
                .build());
    }

    @GetMapping(path = "/send/taxi/{carId}")
    public BigDecimal getDistance(@PathVariable String carId) {
        return distanceCalculator.calculateDistance(carId);
    }
}
