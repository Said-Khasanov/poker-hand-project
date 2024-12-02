package org.example.pokerhandproject;

public record Card(Rank rank, Suit suit) implements Comparable<Card> {

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }

    @Override
    public int compareTo(Card o) {
        return rank.ordinal() - o.rank.ordinal();
    }
}
