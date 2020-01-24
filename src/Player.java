public interface Player {

    // General Actions
    void takeTurn();

    // Character actions
    void income();
    void foreignAid();
    void coup(Player other);
    void tax();
    void assassinate(Player other);
    void exchange();
    void steal(Player other);
    void challenge();

    // Reaction actions
    int stolenFrom();
    void loseCard();

    // Info actions
    int getCoins();
    String getName();

}
