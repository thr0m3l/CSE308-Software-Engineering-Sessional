package Package;

import Device.Microcontroller.Microcontroller;
import Package.Builder.*;

public class PackageBuilderDirector {

    private AbstractPackageBuilder packageBuilder;
    public PackageBuilderDirector(String pkg) {
        setBuilder(pkg);
    }

    public void setBuilder(String pkg){
        if (pkg.equalsIgnoreCase("Diamond")){
            this.packageBuilder = new DiamondPackageBuilder();
        } else if (pkg.equalsIgnoreCase("Gold")){
            this.packageBuilder = new GoldPackageBuilder();
        } else if (pkg.equalsIgnoreCase("Platinum")){
            this.packageBuilder = new PlatinumPackageBuilder();
        } else if (pkg.equalsIgnoreCase("Silver")){
            this.packageBuilder = new SilverPackageBuilder();
        }
    }

    public Microcontroller buildPackage(){
        return packageBuilder.buildPackage();
    }


}
