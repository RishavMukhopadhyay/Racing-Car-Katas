package tddmicroexercises.telemetrysystem.intf;

import tddmicroexercises.telemetrysystem.bean.Diagnostic;

public interface TelemetryDiagnosticControls {

    public Diagnostic getDiagnostic();

    public void checkTransmission() throws Exception;

}
