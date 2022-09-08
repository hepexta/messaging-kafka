package com.hepexta.taxiapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    private String carId;
    private BigDecimal xCoord;
    private BigDecimal yCoord;
    private boolean active;
}
