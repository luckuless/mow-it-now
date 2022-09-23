package com.mow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.mow.enums.NotationCardinale;

public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    public static final int SIZE_NOTATIONS_CARDINALES = 4;
   

    public static final Map<Integer, NotationCardinale> NOTATIONS_CARDINALES = initMap();

    private static Map<Integer, NotationCardinale> initMap() {
        Map<Integer, NotationCardinale> map = new HashMap<>();
        map.put(0, NotationCardinale.N);
        map.put(1, NotationCardinale.E);
        map.put(2, NotationCardinale.S);
        map.put(3, NotationCardinale.W);
        return Collections.unmodifiableMap(map);
    }
}
