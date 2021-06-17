package Aesthetics;

public class CAesthetics implements Aesthetics{

    @Override
    public void setFont() {
        System.out.println("Font: " + Font.CourierNew);
    }

    @Override
    public void setStyle() {
        System.out.println("Style: Normal" );
    }

    @Override
    public void setColor() {
        System.out.println("Color: Blue");
    }
}
