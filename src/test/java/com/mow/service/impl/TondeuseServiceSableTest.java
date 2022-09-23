package com.mow.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mow.model.Orientation;
import com.mow.model.Tondeuse;
import com.mow.model.Tondeuses;
import com.mow.service.TondeuseService;

public class TondeuseServiceSableTest {

    public final TondeuseService tondeuseService = new TondeuseServiceSable();

    private Tondeuse tondeuse1;
    private Tondeuse tondeuse2;

    @BeforeEach
    void setTondeuses() {

        Orientation orientation1 = Orientation.builder()
                .notationCardinale("N")
                .position(0)
                .build();

        tondeuse1 = Tondeuse.builder()
                .coordonneesX(1)
                .coordonneesY(2)
                .orientation(orientation1)
                .build();

        Orientation orientation2 = Orientation.builder()
                .notationCardinale("E")
                .position(1)
                .build();

        tondeuse2 = Tondeuse.builder()
                .coordonneesX(3)
                .coordonneesY(3)
                .orientation(orientation2)
                .instructions("AADAADADDA")
                .build();

        

    }

    @Test
    void testDeployerTondeuses() {

        tondeuse1.setInstructions("GAGAGAGAA");
        Tondeuses tondeuses = Tondeuses.builder()
                .listTondeuses(Arrays.asList(tondeuse1, tondeuse2))
                .maxX(5)
                .maxY(5)
                .build();

        tondeuseService.deployerTondeuses(tondeuses);

        tondeuse1 = tondeuses.getListTondeuses().get(0);
        tondeuse2 = tondeuses.getListTondeuses().get(1);

        assertEquals(1, tondeuse1.getCoordonneesX());
        assertEquals(3, tondeuse1.getCoordonneesY());
        assertEquals("N", tondeuse1.getOrientation().getNotationCardinale());

        assertEquals(1, tondeuse2.getCoordonneesX());
        assertEquals(3, tondeuse2.getCoordonneesY());
        assertEquals("E", tondeuse2.getOrientation().getNotationCardinale());

    }

    @Test
    void deployerSingleTondeuse() {

        tondeuseService.deployerSingleTondeuse(tondeuse1, 5, 5, "GAGAGAGAA");
        tondeuseService.deployerSingleTondeuse(tondeuse2, 5, 5);

        assertEquals(1, tondeuse1.getCoordonneesX());
        assertEquals(3, tondeuse1.getCoordonneesY());
        assertEquals("N", tondeuse1.getOrientation().getNotationCardinale());

        assertEquals(5, tondeuse2.getCoordonneesX());
        assertEquals(1, tondeuse2.getCoordonneesY());
        assertEquals("E", tondeuse2.getOrientation().getNotationCardinale());

    }

    @Test
    void testAvancerUneCase() {
        tondeuseService.avancerUneCase(tondeuse2, 5, 5);
        assertEquals(4, tondeuse2.getCoordonneesX());
        assertEquals(3, tondeuse2.getCoordonneesY());

        tondeuse1.setCoordonneesX(5);
        tondeuse1.setCoordonneesY(4);
        tondeuseService.avancerUneCase(tondeuse1, 5, 4);
        assertEquals(5, tondeuse1.getCoordonneesX());
        assertEquals(4, tondeuse1.getCoordonneesY());
    }

    @Test
    void testOrienter() {
        tondeuseService.orienter(tondeuse1, "D");
        assertEquals("E", tondeuse1.getOrientation().getNotationCardinale());

        tondeuseService.orienter(tondeuse2, "G");
        assertEquals("N", tondeuse2.getOrientation().getNotationCardinale());

        tondeuseService.orienter(tondeuse2, "G");
        assertEquals("W", tondeuse2.getOrientation().getNotationCardinale());
    }

}
