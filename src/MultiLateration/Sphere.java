package MultiLateration;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Sphere {
    private Position position;
    private double distance;

    public Sphere(Position position, double distance) {
        this.position = position;
        this.distance = distance;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double distanceTo(Position pos){
        return(sqrt(pow(position.getX()-pos.getX() ,2)+pow( position.getY()-pos.getY(),2)+pow(position.getZ()-pos.getZ(),2)));
    }
}
