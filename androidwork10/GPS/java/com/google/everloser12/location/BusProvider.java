package com.google.everloser12.location;

import com.squareup.otto.Bus;

/**
 * Created by al-ev on 17.04.2016.
 */
public final class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances.
    }
}