public class AI implements Player {
    private int coins;
    private boolean actionStatus;
    private String name;

    public String getName(){
        return name;
    }

    public void takeTurn(){

    }

    @Override
    public boolean isAlive() {
        return false;
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
            //TODO: Give player an extra turn.
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
            //TODO: Give player an extra turn.
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
}
