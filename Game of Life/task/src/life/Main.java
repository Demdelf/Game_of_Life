package life;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int n = 20;
    static int g = 10;
    public static void main(String[] args) {


       // Scanner scanner = new Scanner(System.in);
         //scanner.nextInt();
        //int seed = scanner.nextInt();
         //scanner.nextInt();


        /*Universe universe = new Universe(n);
        UniverseUtil util = new UniverseUtil(universe);*/
        new GameOfLife();
        /*if (g > 0){
            for (int i = 1; i <= g; i++){
                //clearScreen();

                *//*try {
                    if (System.getProperty("os.name").contains("Windows"))
                        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                    else
                        Runtime.getRuntime().exec("clear");
                }
                catch (IOException | InterruptedException e) {}*//*
                System.out.println("Generation #" + i);
                System.out.println("Alive: " + util.newGeneration());
                //universe.printUni();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/



    }


}
