package Fingerprint;

import java.text.DecimalFormat;

public class Position {
    private double x,y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void mult(float value){
        x *=value;
        y *=value;
    }
        public void add(Position value){
        x +=value.getX();
        y +=value.getY();
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

    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        return "x : "+df.format(x)+" y: "+df.format(y);
    }
}
