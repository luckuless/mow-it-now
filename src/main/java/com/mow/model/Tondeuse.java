package com.mow.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Tondeuse {
    private int coordonneesX;
    private int coordonneesY;
    private Orientation orientation;   
}
