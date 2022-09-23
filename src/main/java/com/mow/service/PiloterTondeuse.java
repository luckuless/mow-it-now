package com.mow.service;

import com.mow.model.Tondeuse;

public interface PiloterTondeuse {
    
    public Tondeuse explorer(int maxX, int maxY, Tondeuse tondeuseInitiale, String instructions);

    public void orienter(Tondeuse tondeuse, String orientation);

    public void avancerUneCase(Tondeuse tondeuse, int maxX, int maxY);
}
