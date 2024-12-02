package org.example.pokerhandproject;

public enum Suit {
    SPADES('S'),
    HEARTS('H'),
    DIAMONDS('D'),
    CLUBS('C'),
    EMPTY(' ');

    private final char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }

    public static Suit of(char symbol) {
        for (Suit suit : Suit.values()) {
            if (suit.symbol == symbol) {
                return suit;
            }
        }
        return EMPTY;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
