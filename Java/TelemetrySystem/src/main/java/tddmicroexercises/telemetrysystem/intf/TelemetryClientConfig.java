package tddmicroexercises.telemetrysystem.intf;

import java.util.Random;

public interface TelemetryClientConfig {

    public Random getConnectionEventsSimulator();
    public boolean getOnlineStatus();

    public void connect( String telemetryServerConnectionString );

    public void disconnect();

}
