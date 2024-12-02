package org.example.pokerhandproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.example.pokerhandproject.HandValue.*;

public class PokerHand implements Comparable<PokerHand> {

    public static final String DELIMITER = " ";
    private final List<Card> cards = new ArrayList<>();
    private HandValue handValue;

    public PokerHand(String hand) {
        parseHand(hand);
        determineHandValue();
    }

    private void parseHand(String hand) {
        for (String symbols : hand.split(DELIMITER)) {
            Rank rank = Rank.of(symbols.charAt(0));
            Suit suit = Suit.of(symbols.charAt(1));
            cards.add(new Card(rank, suit));
        }
    }

    private void determineHandValue() {
        boolean isFlush = true;
        boolean isStraight = true;
        int repeatCount = 1;

        Collections.sort(cards);
        Iterator<Card> iterator = cards.iterator();
        Card firstCard = iterator.next();
        Card prevCard = firstCard;

        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (isFlush && card.suit() != firstCard.suit()) {
                isFlush = false;
            }
            if (isStraight && card.compareTo(prevCard) != 1) {
                isStraight = false;
            }
            if (card.compareTo(prevCard) == 0) {
                repeatCount++;
            } else {
                determineByCount(repeatCount);
                repeatCount = 1;
            }
            prevCard = card;
        }
        if (repeatCount > 1) {
            determineByCount(repeatCount);
        }
        determineByStraightAndFlush(isFlush, isStraight);
    }

    private void determineByStraightAndFlush(boolean isFlush, boolean isStraight) {
        if (isFlush && isStraight && cards.getLast().rank() == Rank.ACE) {
            handValue = ROYAL_FLUSH;
        } else if (isFlush && isStraight) {
            handValue = STRAIGHT_FLUSH;
        } else if (isFlush) {
            handValue = FLUSH;
        } else if (isStraight) {
            handValue = STRAIGHT;
        }
    }

    private void determineByCount(int repeatCount) {
        handValue = switch (repeatCount) {
            case 4 -> FOUR_OF_A_KIND;
            case 3 -> handValue == PAIR ? FULL_HOUSE : THREE_OF_A_KIND;
            case 2 -> {
                if (handValue == THREE_OF_A_KIND) {
                    yield FULL_HOUSE;
                } else if (handValue == PAIR) {
                    yield TWO_PAIRS;
                } else {
                    yield PAIR;
                }
            }
            default -> HIGH_CARD;
        };
    }

    @Override
    public int compareTo(PokerHand o) {
        int result = o.handValue.ordinal() - handValue.ordinal();
        return result == 0 ? o.cards.getLast().compareTo(cards.getLast()) : result;
    }

    public HandValue getHandValue() {
        return handValue;
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + cards +
                ", handValue=" + handValue +
                '}';
    }
}
