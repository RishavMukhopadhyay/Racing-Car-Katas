package tddmicroexercises.telemetrysystem.intf;

import java.util.Random;

public interface TelemetryClient {

    public void send( String message );

    public String receive( Random connectionEventsSimulator );

}
