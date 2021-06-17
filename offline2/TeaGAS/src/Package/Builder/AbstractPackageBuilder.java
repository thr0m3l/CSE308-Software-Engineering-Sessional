package Package.Builder;

import Device.Microcontroller.Microcontroller;

public interface AbstractPackageBuilder {

    Microcontroller buildMicroController();

    void addWeightMeasurement(String weightMeasure);

    Microcontroller buildPackage();


}
