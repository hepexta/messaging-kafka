package com.hepexta.taxiapp.service;

import com.hepexta.taxiapp.model.Position;
import com.hepexta.taxiapp.repository.PositionStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DistanceCalculator {

    private final PositionStorage positionStorage;

    public BigDecimal calculateDistance(String carId) {
        BigDecimal result = BigDecimal.ZERO;
        List<Position> positionsList = positionStorage.getPositions(carId);
        for (int i = 0; i+1 < positionsList.size(); i++) {
            Position position1 = positionsList.get(i);
            Position position2 = positionsList.get(i+1);
            result = result.add(calculateDistanceBetweenPoints(position1.getXCoord(), position1.getYCoord(), position2.getXCoord(), position2.getYCoord()));
        }
        return result;
    }

    private BigDecimal calculateDistanceBetweenPoints(BigDecimal x1, BigDecimal y1, BigDecimal x2, BigDecimal y2) {

        BigDecimal ac = y2.subtract(y1).abs();
        BigDecimal cb = x2.subtract(x1).abs();

        return ac.pow(2).add(cb.pow(2)).sqrt(MathContext.DECIMAL64);
    }
}
