package com.mow.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mow.enums.NotationCardinale;
import com.mow.model.Orientation;
import com.mow.model.Tondeuse;
import com.mow.model.Tondeuses;
import com.mow.service.FileService;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FileServiceImpl implements FileService {

    @Override
    public Tondeuses readInstructionsFile(String fileName) {
        FileReader reader;
        int maxX = 0;
        int maxY = 0;
        String positionTondeuse;
        String instructionsTondeuse;
        List<Tondeuse> listTondeuses = new ArrayList<>();

        try {
            reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            try {

                String premiereLigne = bufferedReader.readLine();
                if (Objects.nonNull(premiereLigne)) {
                    String[] coinSuperieur = premiereLigne.split(" ");
                    maxX = Integer.parseInt(coinSuperieur[0]);
                    maxY = Integer.parseInt(coinSuperieur[0]);
                }
                while (true) {

                    positionTondeuse = bufferedReader.readLine();
                    instructionsTondeuse = bufferedReader.readLine();
                    String[] positionInitiale;

                    if (Objects.nonNull(positionTondeuse) && Objects.nonNull(instructionsTondeuse)) {
                        if (positionTondeuse.matches("\\d+\\s\\d+\\s[NESW]{1}")) {
                            positionInitiale = positionTondeuse.split("\\s");

                            if (instructionsTondeuse.matches("[DGA]+")) {
                                Orientation orientationTondeuse = Orientation.builder()
                                        .notationCardinale(NotationCardinale.valueOf(positionInitiale[2]))
                                        .position(getOrientationKey(positionInitiale[2]))
                                        .build();
                                Tondeuse tondeuse = Tondeuse.builder()
                                        .coordonneesX(Integer.parseInt(positionInitiale[0]))
                                        .coordonneesY(Integer.parseInt(positionInitiale[1]))
                                        .instructions(instructionsTondeuse)
                                        .orientation(orientationTondeuse)
                                        .build();

                                listTondeuses.add(tondeuse);
                            }

                        }
                    } else {
                        break;
                    }

                }
                reader.close();
                return Tondeuses.builder()
                        .maxX(maxX)
                        .maxY(maxY)
                        .listTondeuses(listTondeuses)
                        .build();

            } catch (IOException e) {
                System.out.println("Error reading file");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return Tondeuses.builder().build();

    }

    @Override
    public void writeToOutputFile(String filename, Tondeuses tondeuses) {
        // TODO Auto-generated method stub

    }

    private int getOrientationKey(String orientation) {
        int key = 0;
        switch (orientation) {
            case "N":
                key = 0;
                break;
            case "E":
                key = 1;
                break;
            case "S":
                key = 2;
                break;
            case "W":
                key = 3;
                break;

        }
        return key;
    }

}
