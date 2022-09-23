package com.mow.service;

import com.mow.model.Tondeuse;
import com.mow.model.Tondeuses;

public interface TondeuseService {
    
    public void deployerTondeuses(Tondeuses tondeuses);

    public void deployerSingleTondeuse(Tondeuse tondeuse, int maxX, int maxY);

    public void deployerSingleTondeuse(Tondeuse tondeuse, int maxX, int maxY, String instructions);

    public void orienter(Tondeuse tondeuse, String orientation);

    public void avancerUneCase(Tondeuse tondeuse, int maxX, int maxY);
}
