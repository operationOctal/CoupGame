import java.util.ArrayList;
import java.util.Scanner;

public class Human implements Player {

    private static ArrayList<Player> playerList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private int coins;
    private boolean actionStatus;
    private String name;
    private int influence;

    public Human (String playerName){
        this.name = playerName;
        this.coins = 2;
        this.influence = 2;
        this.playerList.add(this);
    }

    public static ArrayList<Player> getPlayerList(){
        return playerList;
    }

    public boolean isAlive() {
        return influence != 0;
    }

    public void takeTurn() {
        actionStatus = true;
        System.out.println(name + ", it is your turn.");
        System.out.println("You currently have " + coins + " coins and " + influence + " influence.");

        takeAction();
    }

    public void income() {
        coins++;
        actionStatus = false;
    }

    public void foreignAid() {
        coins += 2;
        actionStatus = false;
    }

    public void coup(Player other) {
        if (coins >= 7){
            coins -= 7;
            other.loseInfluence();
            actionStatus = false;
        } else{
            System.out.println("You don't have enough coins to coup.");
        }
    }

    public void tax() {
        coins += 3;
        actionStatus = false;
    }

    public void assassinate(Player other) {
        if (coins >= 3){
            coins -= 3;
            other.loseInfluence();
            actionStatus = false;
        } else{
            System.out.println("You don't have enough coins to assassinate.");
        }

    }

    public void exchange() {
        actionStatus = false;
    }

    public void steal(Player other) {
        if (other.getCoins() > 0){
            coins += other.stolenFrom();
            actionStatus = false;
        } else if (other.getCoins() == 0){
            System.out.println("Player, " + other.getName() + ", has no coins. Choose another action");
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

    public void loseInfluence() {
        influence--;
        if (influence == 0){
            System.out.println(name + " is dead.");
            playerList.remove(this);
        }
        System.out.println(name + " has " + influence + " influence.");
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

    private Player findTarget(){
        //TODO: Default to the other player if it is a 2-player game.

        System.out.print("Name a target player: ");
        String target = scanner.next();
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(target) &&
                player != this) {
                return player;
            }
        }
        System.out.println("Not a valid player. Try again.");
        return findTarget();
    }




    private void takeAction(){
        while (actionStatus) {
            String action;
            if (coins >= 10){
                System.out.println("Since you have more than 10 coins, you must coup.");
                action = "coup";
            }
            else{
                System.out.print("Which action would you like to take? (Type help for a list of options) ");
                action = scanner.next();
            }

            switch (action.toLowerCase()) {
                case "quit":
                    System.exit(0);
                case "help":
                    System.out.println("Your options are: ");
                    System.out.println("income, foreign-aid, coup, tax, assassinate, (exchange), steal");
                    break;
                case "income":
                    income();
                    break;
                case "foreign-aid":
                    foreignAid();
                    break;
                case "coup":
                    coup(findTarget());
                     break;
                case "tax":
                    tax();
                    break;
                case "assassinate":
                    assassinate(findTarget());
                    break;
                case "exchange":
                    //TODO
                    break;
                case "steal":
                    steal(findTarget());
                    break;
                default:
                    System.out.println("Not a valid action. Try again.");
                    System.out.print("Which action would you like to take? ");
            }

        }
        System.out.println("You now have " + coins + " coins.");

        System.out.println();

    }
}
