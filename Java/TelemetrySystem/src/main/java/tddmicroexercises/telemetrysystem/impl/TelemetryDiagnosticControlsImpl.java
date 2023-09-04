package tddmicroexercises.telemetrysystem.impl;

import tddmicroexercises.telemetrysystem.bean.Diagnostic;
import tddmicroexercises.telemetrysystem.constants.TelemetryConstants;
import tddmicroexercises.telemetrysystem.intf.TelemetryClient;
import tddmicroexercises.telemetrysystem.intf.TelemetryClientConfig;

public class TelemetryDiagnosticControlsImpl implements tddmicroexercises.telemetrysystem.intf.TelemetryDiagnosticControls {
    private final String DiagnosticChannelConnectionString = "*111#";

    private Diagnostic diagnostic;

    private final TelemetryClientConfig telemetryClientConfig;

    private final TelemetryClient telemetryClient;

    public TelemetryDiagnosticControlsImpl( TelemetryClientConfig telemetryClientConfig, TelemetryClient telemetryClient)
    {
        this.telemetryClientConfig = telemetryClientConfig;
        this.telemetryClient = telemetryClient;
    }

    @Override
    public Diagnostic getDiagnostic() {
        return diagnostic;
    }
 
    @Override
    public void checkTransmission() throws Exception
    {
        diagnostic = new Diagnostic();

        telemetryClientConfig.disconnect();
    
        int retryLeft = 3;
        while (telemetryClientConfig.getOnlineStatus() == false && retryLeft > 0)
        {
            telemetryClientConfig.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }
             
        if(telemetryClientConfig.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }
    
        telemetryClient.send( TelemetryConstants.DIAGNOSTIC_MESSAGE );
        diagnostic.setDiagnosticInfo( telemetryClient.receive(telemetryClientConfig.getConnectionEventsSimulator()) );
    }
}
