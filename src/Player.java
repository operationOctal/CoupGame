public interface Player {
    void income();
    void foreignAid();
    void coup(Player other);
    void tax();
    void assassinate(Player other);
    void exchange();
    void steal(Player other);
    void challenge();
    int stolenFrom();

    int getCoins();

    void loseCard();
}
