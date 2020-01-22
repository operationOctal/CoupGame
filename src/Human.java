public class Human implements Player {

    private int coins;


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
        } else{
            //TODO: Give player an extra turn.
            System.out.println("You don't have enough money to coup.");
        }
    }

    public void tax() {
        coins += 3;
    }

    public void assassinate(Player other) {
        if (coins >= 3){
            coins -= 3;
            other.loseCard();
        } else{
            //TODO: Give player an extra turn.
            System.out.println("You don't have enough money to assassinate.");
        }

    }

    public void exchange() {

    }

    public void steal(Player other) {
        if (other.getCoins() >= 2){
            coins += other.stolenFrom();
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
