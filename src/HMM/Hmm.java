package HMM;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Hmm {
    private int ind = 0;
    private int size;
    private int prev = 0;
    private int current = 0;
    private int[][] mat;
    private float[][] perecntage;
    private ArrayList<States> states = new ArrayList<States>();
    private final DecimalFormat df = new DecimalFormat("#.##");

    public Hmm(int size){
        this.size = size;
        mat = new int[size][size];
        perecntage = new float[size][size];
        states.add(new States("0","/"));
    }

    public int getCurrent() {
        return current;
    }

    public void addDestination(int dest){
        prev = current;
        current= dest;
        states.add(new States(""+current,""+prev));
        ind++;
        mat[prev][dest]++;
        update();
    }

    public void update(){
        for (int line=0;line<size;line++){
            float total = 0;
            for (int i=0;i<size;i++){
                total +=mat[line][i];
            }
            for (int i=0;i<size;i++){
                perecntage[line][i] = ((float)mat[line][i]/total)*100;
                if (Float.isNaN(perecntage[line][i]))
                    perecntage[line][i] = 0;
                else
                    perecntage[line][i] = ((float)mat[line][i]/total)*100;

            }
        }

    }

    public void backward(){
        if (ind == 0){
            System.out.println("backward is not available");

        }
        else {
            mat[prev][current]--;
            states.remove(ind);
            ind--;
            if(states.get(ind).prev == "/")
            {
                current = 0;
                prev = 0;

            }else {
                prev = Integer.parseInt(states.get(ind).prev);
                current = Integer.parseInt(states.get(ind).current);
            }
        }
        update();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void run(){
        boolean exit = false;
        boolean valid = false;
        boolean alert_range = false;
        boolean alert_type = false;
        final Scanner scanner = new Scanner(System.in);

        do{
            valid = false;
            alert_range = false;
            alert_type = false;
            print();
            System.out.println("\nYou came from : "+states.get(ind).prev);
            System.out.println("\nYou are in : "+getCurrent());
            System.out.println("select a destination from 0-"+(size-1)+"  b for backward : / press q to quit");

            while(!valid) {
                String s;
                s = scanner.nextLine();
                if(s.equals("q") || s.equals("Q")){
                    exit = true;
                    valid = true;
                }else {
                    if(s.equals("b") || s.equals("B")){
                        backward();
                        valid = true;
                    }else {
                        try {
                            int input = Integer.parseInt(s);

                            if (0<=input && input<size) {
                                valid = true;
                                addDestination(input);
                                break;
                            }
                            else {
                                if (!alert_range){
                                    alert_range = true;
                                    alert_type = false;
                                    System.out.println("Enter a value between 0-"+(size-1)+"!");
                                }
                            }
                        } catch (Exception exception) {
                            if (!alert_type) {
                                System.out.println("invalid input !");
                                alert_type = true;
                                alert_range = false;
                            }
                        }
                    }

                }

            }

            clearScreen();

        }while(!exit);
    }

    public void print(){
        int count;
        System.out.print("         ");
        for (int i = 0;i<size;i++) {
            System.out.print("     [    " + i + "    ]");
        }
        System.out.println("  [Line Count]");
        for (int i=0;i<size;i++){
            count  = 0;
            System.out.print("[   "+i+"   ]");
            for (int j=0;j<size;j++){
                count += mat[i][j];
                System.out.print("  [   "+mat[i][j]+",  "+df.format(perecntage[i][j])+"%   ]");

            }
            System.out.println("  [   "+count+"   ]");
        }
    }



}
