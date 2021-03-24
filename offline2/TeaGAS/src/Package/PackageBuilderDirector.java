package Package;

import Device.Microcontroller.Microcontroller;
import Package.Builder.*;
import Package.Enumerations.Packages;

public class PackageBuilderDirector {

    private AbstractPackageBuilder packageBuilder;
    public PackageBuilderDirector(Packages pkg) {
        if (pkg == Packages.Diamond){
            this.packageBuilder = new DiamondPackageBuilder();
        } else if (pkg == Packages.Gold){
            this.packageBuilder = new GoldPackageBuilder();
        } else if (pkg == Packages.Platinum){
            this.packageBuilder = new PlatinumPackageBuilder();
        } else if (pkg == Packages.Silver){
            this.packageBuilder = new SilverPackageBuilder();
        }
    }

    public Microcontroller buildPackage(){
        return packageBuilder.buildPackage();
    }
}
