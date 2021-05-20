package MultiLateration;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();
        spheres.add(new Sphere(new Position(0.5f,0.5f,0.5f),3.0f));
        spheres.add(new Sphere(new Position(4.0f,0.0f,0.0f),2.0f));
        spheres.add(new Sphere(new Position(4.0f,5.0f,5.0f),4.2f));
        spheres.add(new Sphere(new Position(3.0f,3.0f,3.0f),2.5f));


        long startTime = System.nanoTime();
        Nlateration nlateration = new Nlateration(spheres,0.1,4);
        Position result = nlateration.run();
        System.out.println("result spheres (4) : " + result.toString());
        long endTime   = System.nanoTime();
        float totalTime = endTime - startTime;
        System.out.println("time : " + totalTime / 1000000 +" ms");

    }
}
