package com.hepexta.taxiapp.repository;

import com.hepexta.taxiapp.model.Position;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PositionStorage {
    Map<String, List<Position>> cache = new ConcurrentHashMap<>();

    public void upsert(Position position) {
        List<Position> positions = cache.get(position.getCarId());
        if (CollectionUtils.isEmpty(positions)) {
            cache.put(position.getCarId(), Arrays.asList(position));
        }
        else {
            positions.add(position);
        }
    }

    public List<Position> getPositions(String carId) {
        return Optional.ofNullable(cache.get(carId)).orElse(new ArrayList<>());
    }
}
