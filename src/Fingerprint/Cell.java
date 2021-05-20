package Fingerprint;

import java.util.ArrayList;

public class Cell {
    private Position position;
    private float[] rssis = new float[4];
    private float distance;

    public Cell( float[] rssis) {
        this.position = new Position(0,0);
        this.rssis = rssis;
    }

    public Cell(Position position, float[] rssis) {
        this.position = position;
        this.rssis = rssis;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public float[] getRssis() {
        return rssis;
    }

    public void setRssis(float[] rssis) {
        this.rssis = rssis;
    }
}
