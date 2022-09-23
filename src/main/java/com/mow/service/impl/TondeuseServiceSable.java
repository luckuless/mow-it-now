package com.mow.service.impl;

import java.util.Arrays;
import java.util.Objects;

import com.mow.Constants;
import com.mow.model.Tondeuse;
import com.mow.model.Tondeuses;
import com.mow.service.TondeuseService;


public class TondeuseServiceSable implements TondeuseService {

    public TondeuseServiceSable() {
    }

    @Override
    public void deployerTondeuses(Tondeuses tondeuses) {

        tondeuses.getListTondeuses().forEach(
            tondeuse -> deployerSingleTondeuse(tondeuse, tondeuses.getMaxX(), tondeuses.getMaxY())
        );
    }

    @Override
    public void deployerSingleTondeuse(Tondeuse tondeuse, int maxX, int maxY){
        Arrays.asList(tondeuse.getInstructions().split("")).forEach(
                    i -> {
                        switch(i){
                            case "A": avancerUneCase(tondeuse, maxX, maxY);
                                        break;
                            case "D": orienter(tondeuse, i);
                                        break;  
                            case "G": orienter(tondeuse, i);
                                        break;

                            default: break;
                        }
                            
                    }
                );
    }

    @Override
    public void deployerSingleTondeuse(Tondeuse tondeuse, int maxX, int maxY, String instructions){
        Arrays.asList(instructions.split("")).forEach(
                    i -> {
                        switch(i){
                            case "A": avancerUneCase(tondeuse, maxX, maxY);
                                        break;
                            case "D": orienter(tondeuse, i);
                                        break;  
                            case "G": orienter(tondeuse, i);
                                        break;

                            default: break;
                        }
                            
                    }
                );
    }

    @Override
    public void avancerUneCase(Tondeuse tondeuse, int maxX, int maxY) {
        int nouvelleCoordonnee = -1;
        boolean isX = true;

        switch(tondeuse.getOrientation().getNotationCardinale()){
            case "N": nouvelleCoordonnee = tondeuse.getCoordonneesY() + 1;
                        isX = false;
                        break;
            case "E": nouvelleCoordonnee = tondeuse.getCoordonneesX() + 1;
                        isX = true;
                        break;
            case "S": nouvelleCoordonnee = tondeuse.getCoordonneesY() - 1;
                        isX = false;
                        break;
            case "W": nouvelleCoordonnee = tondeuse.getCoordonneesX() - 1;
                        isX = true;
                        break;
        }

        if (nouvelleCoordonnee >= 0){
            if (isX && nouvelleCoordonnee <= maxX){
                tondeuse.setCoordonneesX(nouvelleCoordonnee);
            }

            if (!isX && nouvelleCoordonnee <= maxY){
                tondeuse.setCoordonneesY(nouvelleCoordonnee);
            }
        }
    }

    @Override
    public void orienter(Tondeuse tondeuse, String orientation) {
        if (Objects.equals(orientation, "D")){
            int nouvelleOrientation = (tondeuse.getOrientation().getPosition() + 1) % 4; 
            tondeuse.getOrientation().setPosition(nouvelleOrientation);
            tondeuse.getOrientation().setNotationCardinale(Constants.ORIENTATIONS_POSSIBLES.get(nouvelleOrientation));
        }
        else{
            if (Objects.equals(orientation, "G")){
                int nouvelleOrientation = (tondeuse.getOrientation().getPosition() + 4 - 1) % 4; 
                tondeuse.getOrientation().setPosition(nouvelleOrientation);
                tondeuse.getOrientation().setNotationCardinale(Constants.ORIENTATIONS_POSSIBLES.get(nouvelleOrientation));
            }
        }
        
    }
    
}
