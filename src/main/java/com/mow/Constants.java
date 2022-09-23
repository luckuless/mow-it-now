package com.mow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    public static final int POSN_MAX_ORIENTATIONS = 3;
    public static final int PIVOTER_DROITE = 1;
    public static final int PIVOTER_GAUCHE = -1;

    public static final Map<Integer, String> ORIENTATIONS_POSSIBLES = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "N");
        map.put(1, "E");
        map.put(2, "S");
        map.put(3, "W");
        return Collections.unmodifiableMap(map);
    }
}
