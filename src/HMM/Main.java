package HMM;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Enter number of rooms : ");
        s = scanner.nextLine();
        try {
            Hmm hmm =  new Hmm(Integer.parseInt(s));
            hmm.run();
        }catch (Exception exception){
            System.out.println(exception);
        }

    }
}
