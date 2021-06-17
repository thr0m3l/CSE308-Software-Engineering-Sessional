package Package.Builder;

import Device.DeviceBuilderDirector;
import Device.Enumerations.WeightMeasure;
import Device.Microcontroller.Microcontroller;

public class GoldPackageBuilder implements AbstractPackageBuilder {
    private Microcontroller microcontroller;
    @Override
    public Microcontroller buildMicroController() {
        DeviceBuilderDirector builderDirector = new DeviceBuilderDirector("Arduino");
        return builderDirector.buildAll();
    }

    @Override
    public void addWeightMeasurement(String weightMeasure) {
        WeightMeasure wm = null;
        if (weightMeasure.equalsIgnoreCase("LoadSensor")){
            wm = WeightMeasure.LoadSensor;
        } else {
            wm = WeightMeasure.WeightModule;
        }
        this.microcontroller.setWeightMeasure(wm);
    }

    @Override
    public Microcontroller buildPackage() {
        this.microcontroller = buildMicroController();
        addWeightMeasurement("WeightModule");
        return this.microcontroller;
    }
}
