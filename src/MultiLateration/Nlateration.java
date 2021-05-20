package MultiLateration;

import java.util.ArrayList;
import static java.lang.Math.*;

public class Nlateration {
    private Position pos0 = new Position(0f,0f,0f);
    private double step,x_min=Integer.MAX_VALUE,y_min=Integer.MAX_VALUE,z_min=Integer.MAX_VALUE,x_max=0,y_max=0,z_max=0,dmin=Integer.MAX_VALUE,dmax=0,d=0;
    private ArrayList<Sphere> spheres = new ArrayList<Sphere>();
    private boolean dataset = false;
    String msg;
    private int ks;

    public Nlateration(ArrayList<Sphere> spheres,double step,int ks) {
        this.ks=ks;
        if (step<=0){
            msg = "the step size is =< 0";
        }else {
            if (spheres.size() != 0) {
                this.step = step;
                this.spheres = spheres;
                dataset = true;
            } else msg = "the dataset is empty";
        }
    }

    public void updateDataSet(ArrayList<Sphere> spheres) {
        if (spheres.size() != 0) {
            this.spheres = spheres;
            dataset = true;
        } else {
            msg = "the dataset is empty";
            dataset = false;
        }
    }

    public Nlateration() {
        msg = "please insert a dataset";
    }

    public Position run(){

        Sphere[] spheres_s= new Sphere[ks];
        for (int i=0;i<ks;i++){
            spheres_s[i]=spheres.get(i);
        }

        if (dataset){
            double x=0,y=0,z=0;
            calculateMax();
            for (double i=x_min;i<x_max;i+=step){
                for (double j=y_min;j<y_max;j+=step){
                    for (double k=z_min;k<z_max;k+=step){
                        d = 0;
                        for (Sphere s:spheres_s) {
                            d += abs(s.distanceTo(new Position(i,j,k))-s.getDistance());
                        }
                        if(d<dmin){
                            dmin = d;
                            x=i;y=j;z=k;
                        }
                        if (d>dmax){
                            dmax = d;
                        }
                    }
                }
            }
            return new Position(x,y,z);
        }else {
            System.out.println(msg);
            return pos0;
        }

    }

    private void calculateMax(){

        for (Sphere s:spheres) {

            double tmp;
            tmp = s.getPosition().getX() - s.getDistance();
            if (tmp < x_min) {
                x_min = tmp;
            }
            tmp = s.getPosition().getX() + s.getDistance();
            if (tmp > x_max) {
                x_max = tmp;
            }
            tmp = s.getPosition().getY() - s.getDistance();
            if (tmp < y_min) {
                y_min = tmp;
            }
            tmp = s.getPosition().getY() + s.getDistance();
            if (tmp > y_max) {
                y_max = tmp;
            }
            tmp = s.getPosition().getZ() - s.getDistance();
            if (tmp < z_min) {
                z_min = tmp;
            }
            tmp = s.getPosition().getZ() + s.getDistance();
            if (tmp > z_max) {
                z_max = tmp;
            }
        }
    }

}
