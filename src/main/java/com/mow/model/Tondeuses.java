package com.mow.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Tondeuses {
    private int maxX;
    private int maxY;
    private List<Tondeuse> listTondeuses;
    
}
