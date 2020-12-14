package effectivejava.chapter9.item58;

import java.util.*;

public class Card {
    private final Suit suit;
    private final Rank rank;

    // Can you spot the bug?
    enum Suit { CLUB, DIAMOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    Card(Suit suit, Rank rank ) {
        this.suit = suit;
        this.rank = rank;
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        //错误的方式
        /**
         * Don’t feel bad if you didn’t spot the bug. Many expert programmers have made this mistake at one time or another.
         * The problem is that the next method is called too many times on the iterator for the outer collection (suits).
         * It should be called from the outer loop so that it is called once per suit,but instead it is called from the inner loop,
         * so it is called once per card. After you run out of suits, the loop throws a NoSuchElementException.
         */
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                deck.add(new Card(i.next(), j.next()));
            }
        }

        System.out.println("***************************"+deck);

        // Fixed, but ugly - you can do better!
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            Suit suit = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                Card card=new Card(suit, j.next());
                deck.add(card);
                System.out.println(card.toString());
            }
        }

        System.out.println("***************************");
        // Preferred idiom for nested iteration on collections and arrays
//        for (Suit suit : suits) {
//            for (Rank rank : ranks) {
//                Card card=new Card(suit, rank);
//                deck.add(card);
//                System.out.println(card.toString());
//            }
//        }

    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}
