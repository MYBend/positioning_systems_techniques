package MultiLateration;

import java.text.DecimalFormat;

public class Position {

    private double x,y,z;

    public Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        return "x : "+df.format(x)+" y: "+df.format(y)+" z: "+df.format(z);
    }
}
