package Fingerprint;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        ArrayList<Cell> cells = new ArrayList<Cell>();

        cells.add(new Cell(new Position(2,2),new float[] {-38,-27,-54,-13}));
        cells.add(new Cell(new Position(6,2),new float[] {-74,-62,-48,-33}));
        cells.add(new Cell(new Position(10,2),new float[] {-13,-28,-12,-40}));
        cells.add(new Cell(new Position(2,6),new float[] {-34,-27,-38,-41}));
        cells.add(new Cell(new Position(6,6),new float[] {-64,-48,-72,-35}));
        cells.add(new Cell(new Position(10,6),new float[] {-45,-37,-20,-15}));
        cells.add(new Cell(new Position(2,10),new float[] {-17,-50,-44,-33}));
        cells.add(new Cell(new Position(6,10),new float[] {-27,-28,-32,-45}));
        cells.add(new Cell(new Position(10,10),new float[] {-30,-20,-60,-40}));

        Cell mobile = new Cell(new float[]{-26, -42, -13, -46});
        Fingerprint fingerprint = new Fingerprint(cells,mobile,4);
        Position result = fingerprint.run();
        System.out.println("result location:\nx : "+result);
        long endTime   = System.nanoTime();
        float totalTime = endTime - startTime;
        System.out.println("\ntime : " + totalTime / 1000000 +" ms");


        /*
        Fingerprint fingerprint2 = new Fingerprint(cells,mobile,5);
        Position result2 = fingerprint.run();
        System.out.println("result 2 location:\nx : "+result2);
        long endTime2   = System.nanoTime();
        float totalTime2 = endTime - startTime;
        */
    }
}
