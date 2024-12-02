package org.example.pokerhandproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PokerHandProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokerHandProjectApplication.class, args);

        List<PokerHand> hands = new ArrayList<>();
        hands.add(new PokerHand("KS 2H 5C JD TD"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));
        Collections.sort(hands);
        hands.forEach(System.out::println);
    }
}
