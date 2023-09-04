package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;
import tddmicroexercises.telemetrysystem.impl.TelemetryClientConfigImpl;
import tddmicroexercises.telemetrysystem.impl.TelemetryClientImpl;
import tddmicroexercises.telemetrysystem.impl.TelemetryDiagnosticControlsImpl;
import tddmicroexercises.telemetrysystem.intf.TelemetryDiagnosticControls;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TelemetryDiagnosticControlsTest
{
    private TelemetryDiagnosticControls telemetryDiagnosticControls;
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        telemetryDiagnosticControls = new TelemetryDiagnosticControlsImpl( new TelemetryClientConfigImpl(), new TelemetryClientImpl());
        telemetryDiagnosticControls.checkTransmission();
        assertFalse(telemetryDiagnosticControls.getDiagnostic().getDiagnosticInfo().isEmpty());
    }
}
