package com.mow.service;

import com.mow.model.Tondeuse;

public interface PiloterTondeuse {
    
    public Tondeuse explorer(int maxX, int maxY, Tondeuse tondeuseInitiale, char[] instructions);
}
