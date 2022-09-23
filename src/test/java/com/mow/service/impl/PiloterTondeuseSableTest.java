package com.mow.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mow.model.Orientation;
import com.mow.model.Tondeuse;

public class PiloterTondeuseSableTest {

    public final PiloterTondeuseSable piloterTondeuse = new PiloterTondeuseSable();

    @Test
    void testAvancerUneCase() {

    }

    @Test
    void testExplorer() {
        Orientation orientation1 = Orientation.builder().notationCardinale("N").position(0).build();
        Tondeuse tondeuse1 = Tondeuse.builder().coordonneesX(1).coordonneesY(2).orientation(orientation1).build();

        Orientation orientation2 = Orientation.builder().notationCardinale("E").position(1).build();
        Tondeuse tondeuse2 = Tondeuse.builder().coordonneesX(3).coordonneesY(3).orientation(orientation2).build();

        piloterTondeuse.explorer(5, 5, tondeuse1, "GAGAGAGAA");
        piloterTondeuse.explorer(5, 5, tondeuse2, "AADAADADDA");

        assertEquals(1, tondeuse1.getCoordonneesX());
        assertEquals(3, tondeuse1.getCoordonneesY());
        assertEquals("N", tondeuse1.getOrientation().getNotationCardinale());

        assertEquals(5, tondeuse2.getCoordonneesX());
        assertEquals(1, tondeuse2.getCoordonneesY());
        assertEquals("E", tondeuse2.getOrientation().getNotationCardinale());

    }

    @Test
    void testOrienter() {

    }
}
