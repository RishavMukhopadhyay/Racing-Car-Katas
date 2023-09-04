package tddmicroexercises.telemetrysystem.impl;

import tddmicroexercises.telemetrysystem.intf.TelemetryClientConfig;

import java.util.Random;

public class TelemetryClientConfigImpl implements TelemetryClientConfig {

    private boolean onlineStatus;

    private Random connectionEventsSimulator;

    public TelemetryClientConfigImpl() {
        connectionEventsSimulator = new Random( 42);
    }

    @Override
    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }

    @Override
    public Random getConnectionEventsSimulator()
    {
        return connectionEventsSimulator;
    }

    @Override
    public void connect( String telemetryServerConnectionString )
    {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        onlineStatus = success;
    }

    @Override
    public void disconnect()
    {
        onlineStatus = false;
    }

}
