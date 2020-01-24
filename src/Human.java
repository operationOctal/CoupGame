import java.util.ArrayList;
import java.util.Scanner;

public class Human implements Player {

    private Scanner scanner = new Scanner(System.in);
    private int coins;
    private boolean actionStatus;
    private String name;
    private ArrayList<Player>playerList;

    public Human (String playerName, ArrayList<Player>playerList){
        this.name = playerName;
        this.playerList = playerList;
    }

    public void takeTurn() {
        actionStatus = true;
        System.out.println(name + ", it is your turn");
        System.out.println("You currently have " + coins + " coins");

        while (actionStatus) {
            System.out.println("Which action would you like to take? ");
            String action = scanner.next();
            takeAction(action);
        }
    }

    public void income() {
        coins++;
    }

    public void foreignAid() {
        coins += 2;
    }

    public void coup(Player other) {
        if (coins >= 7){
            coins -= 7;
            other.loseCard();
            actionStatus = false;
        } else{
            System.out.println("You don't have enough money to coup.");
        }
    }

    public void tax() {

        coins += 3;
        actionStatus = false;
    }

    public void assassinate(Player other) {
        if (coins >= 3){
            coins -= 3;
            other.loseCard();
            actionStatus = false;
        } else{
            System.out.println("You don't have enough money to assassinate.");
        }

    }

    public void exchange() {
        actionStatus = false;
    }

    public void steal(Player other) {
        if (other.getCoins() > 0){
            coins += other.stolenFrom();
            actionStatus = false;
        }
    }


    public void challenge() {

    }

    public int getCoins() {
        return coins;
    }

    public String getName(){
        return this.name;
    }

    public void loseCard() {

    }

    public int stolenFrom() {
        if (coins >= 2){
            coins -= 2;
            return 2;
        } else if (coins == 1){
            coins -= 1;
            return 1;
        } else {
            return 0;
        }
    }

    //TODO: fix this function
    private Player findTarget(){
        System.out.println("Name a target player: ");
        String target = scanner.next();
        for (Player player : playerList) {
            if (player.getName().equals(target)) {
                return player;
            }
        }
        System.out.println("Not a valid player. Try again.");
        return null;
    }




    private void takeAction(String action){
        switch (action) {
            case "income":
                income();
                break;
            case "foreign aid":
                foreignAid();
            case "coup":
                coup(findTarget());
            case "tax":
                tax();
                break;
                //TODO: write these functions
            case "assassinate":
                break;
            case "exchange":
                break;
            case "steal":
                break;
            default:
                System.out.println("Not a valid action. Try again.");
                System.out.println("Which action would you like to take? ");
                takeAction(scanner.next());


        }
    }
}
