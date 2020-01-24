import com.sun.deploy.panel.AbstractRadioPropertyGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void playGame(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Coup!");
        System.out.print("How many human players do you want? ");
        int humans = scanner.nextInt();
        for (int i = 0; i < humans; i++){
            System.out.print("What is the human's name? ");
            Player p = new Human(scanner.next());
        }

        //TODO: Add AIs as well.


        while(Human.getPlayerList().size() > 1){
            System.out.println("PLAYERLIST SIZE: " + Human.getPlayerList().size());
            for(Player p : Human.getPlayerList()){
                System.out.println("CURRENT PLAYER: " + p.getName());
                p.takeTurn();
            }
        }

        System.out.println("Game over!");
        System.out.println(Human.getPlayerList().get(0).getName() + " won the game!");
    }

    public static void main(String[] args) {
        playGame();
    }
}
