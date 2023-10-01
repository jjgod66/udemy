package dal.mu.ti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dalmuti {
	final static int CARD_QUENTITY = 80;
	final static int MAX_RANK = 13;
	final static List<Card> DECK = new ArrayList<Card>(CARD_QUENTITY);
	
	private static List<Card> initailizeGame (int gamers_quantity) {
		if (DECK.isEmpty()) makingDeck();
		Collections.shuffle(DECK);
		return DECK;
	}
	
	private static void makingDeck() {
		for (int i = 1; i <= MAX_RANK - 1; i++) {
			for (int j = 1; j <= i; j++) {
				DECK.add(new Card(i));
			}
		}
		DECK.add(new Card(MAX_RANK));
		DECK.add(new Card(MAX_RANK));
	}



	public static void main(String[] args) {
		initailizeGame(8);
		System.out.println(DECK.size());
	}
	
	
}
