package Fingerprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fingerprint {
    private ArrayList<Cell> dataset = new ArrayList<Cell>();

    private ArrayList<Float> distances;
    Cell result;
    int k;

    public Fingerprint(ArrayList<Cell> dataset,Cell result,int k) {
        this.dataset = dataset;
        this.result =  result;
        this.k=k;

    }

    private void calculateDistances(){
        distances = new ArrayList<Float>();
        float dist;
        for (Cell x:dataset
             ) {
            dist = Math.abs(x.getRssis()[0] - result.getRssis()[0])+
                    Math.abs(x.getRssis()[1] - result.getRssis()[1])+
                    Math.abs(x.getRssis()[2] - result.getRssis()[2])+
                    Math.abs(x.getRssis()[3] - result.getRssis()[3]);
            x.setDistance(dist);
        }
    }

    private Cell[] nearestNeighbors(){



        Collections.sort(dataset, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return Float.compare(o1.getDistance(),o2.getDistance());
            }
        });
        System.out.println(k+" nearest neighbors :\n");

        Cell[] data = new Cell[k];
        for (int i = 0 ;i<k;i++
        ) {
            System.out.println("Position : "+dataset.get(i).getPosition());
            System.out.println("Distance :  "+dataset.get(i).getDistance()+"\n");
            data[i]=dataset.get(i);
        }



        return data;
    }

    private Cell calculateCenter(Cell[] cells){

        /*
        loop cells
             for each cells
                alpha=1
                for each cells   =/= cell[i]
                    alpha= cell[i].getDistance()/ce[x]

                cells[i].getPosition().mult(1+alpha)
         */
        for(Cell cell : cells){
            float alpha=1;
            for(Cell c: cells){
                if(c!=cell){
                    alpha+=(cell.getDistance()/c.getDistance());
                }
            }
            cell.getPosition().mult(1/alpha);

        }
        for(Cell c: cells){
            if(c!=cells[0]){
                cells[0].getPosition().add(c.getPosition());
            }
        }


        /*cells[0].getPosition().mult(1 / (1+cells[0].getDistance()/cells[1].getDistance()+cells[0].getDistance()/cells[2].getDistance()+cells[0].getDistance()/cells[3].getDistance()));
        cells[1].getPosition().mult(1 / (1+cells[1].getDistance()/cells[0].getDistance()+cells[1].getDistance()/cells[2].getDistance()+cells[1].getDistance()/cells[3].getDistance()));
        cells[2].getPosition().mult(1 / (1+cells[2].getDistance()/cells[1].getDistance()+cells[2].getDistance()/cells[0].getDistance()+cells[2].getDistance()/cells[3].getDistance()));
        cells[3].getPosition().mult(1 / (1+cells[3].getDistance()/cells[1].getDistance()+cells[3].getDistance()/cells[2].getDistance()+cells[3].getDistance()/cells[0].getDistance()));
        cells[0].getPosition().add(cells[1].getPosition());
        cells[0].getPosition().add(cells[2].getPosition());
        cells[0].getPosition().add(cells[3].getPosition());*/

        return cells[0];
    }

    public Position run(){
        calculateDistances();
        Cell[] cells  = nearestNeighbors();
        System.out.println("Length :  "+cells.length);
        return  calculateCenter(cells).getPosition();

    }
}
