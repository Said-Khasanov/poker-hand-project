package org.example.pokerhandproject;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.pokerhandproject.HandValue.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandTest {

    @Test
    void determineHighCard() {
        PokerHand pokerHand = new PokerHand("TC 4H 7D KC 2S");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(HIGH_CARD, handValue);
    }

    @Test
    void determinePair() {
        PokerHand pokerHand = new PokerHand("KC KH 7D 2C 5S");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(PAIR, handValue);
    }

    @Test
    void determineTwoPairs() {
        PokerHand pokerHand = new PokerHand("KC KH 7D 7C 5S");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(TWO_PAIRS, handValue);
    }

    @Test
    void determineThreeOfAKind() {
        PokerHand pokerHand = new PokerHand("KC KH KD 7C 5S");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(THREE_OF_A_KIND, handValue);
    }

    @Test
    void determineStraight() {
        PokerHand pokerHand = new PokerHand("3C 4H 5D 6C 7S");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(STRAIGHT, handValue);
    }

    @Test
    void determineFlush() {
        PokerHand pokerHand = new PokerHand("KC QC 9C 8C 2C");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(FLUSH, handValue);
    }

    @Test
    void determineFullHouse() {
        PokerHand pokerHand = new PokerHand("KC KH KD 7C 7S");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(FULL_HOUSE, handValue);
    }

    @Test
    void determineFourOfAKind() {
        PokerHand pokerHand = new PokerHand("6S 6D 6H 6C KS");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(FOUR_OF_A_KIND, handValue);
    }

    @Test
    void determineStraightFlush() {
        PokerHand pokerHand = new PokerHand("2S 3S 4S 5S 6S");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(STRAIGHT_FLUSH, handValue);
    }

    @Test
    void determineRoyalFlush() {
        PokerHand pokerHand = new PokerHand("TH JH QH KH AH");
        HandValue handValue = pokerHand.getHandValue();
        assertEquals(ROYAL_FLUSH, handValue);
    }

    @Test
    void compareTwoHighCards() {
        PokerHand pokerHand1 = new PokerHand("TC 4H 7D 5C 2S");
        PokerHand pokerHand2 = new PokerHand("TC 4H 7D 5C JS");
        List<PokerHand> hands = new ArrayList<>();
        hands.add(pokerHand1);
        hands.add(pokerHand2);
        Collections.sort(hands);
        assertEquals(pokerHand2, hands.getFirst());
    }

    @Test
    void whenCompareHighCardAndPair_thenPairWins() {
        PokerHand highCard = new PokerHand("TC 4H 7D KC 2S");
        PokerHand pair = new PokerHand("KC KH 7D 2C 5S");
        List<PokerHand> hands = new ArrayList<>();
        hands.add(highCard);
        hands.add(pair);
        Collections.sort(hands);
        assertEquals(pair, hands.getFirst());
    }

    @Test
    void whenCompareFullHouseAndFlush_thenFullHouseWins() {
        PokerHand fullHouse = new PokerHand("KC KH KD 7C 7S");
        PokerHand flush = new PokerHand("KC QC 9C 8C 2C");
        List<PokerHand> hands = new ArrayList<>();
        hands.add(fullHouse);
        hands.add(flush);
        Collections.sort(hands);
        assertEquals(fullHouse, hands.getFirst());
    }

    @Test
    void whenCompareStraightAndFlush_thenFlushWins() {
        PokerHand straight = new PokerHand("3C 4H 5D 6C 7S");
        PokerHand flush = new PokerHand("KC QC 9C 8C 2C");
        List<PokerHand> hands = new ArrayList<>();
        hands.add(straight);
        hands.add(flush);
        Collections.sort(hands);
        assertEquals(flush, hands.getFirst());
    }
}