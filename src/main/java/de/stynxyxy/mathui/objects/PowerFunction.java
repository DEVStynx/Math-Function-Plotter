package de.stynxyxy.mathui.objects;

public class PowerFunction extends Function{
    public double exponent;
    public double factor;

    public PowerFunction(double exponent, double factor) {
        this.exponent = exponent;
        this.factor = factor;
    }

    @Override
    public double calcY(double x) {
        return factor * Math.pow(x,exponent);
    }
}
