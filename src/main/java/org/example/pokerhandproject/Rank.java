package org.example.pokerhandproject;

public enum Rank {
    EMPTY(' '),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private final char symbol;

    Rank(char symbol) {
        this.symbol = symbol;
    }

    public static Rank of(char symbol) {
        for (Rank rank : Rank.values()) {
            if (rank.symbol == symbol) {
                return rank;
            }
        }
        return EMPTY;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
