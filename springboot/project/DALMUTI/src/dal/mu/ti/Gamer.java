package dal.mu.ti;

import java.util.List;

public class Gamer {
	private List<Card> hand;
	private boolean isMyTurn;
	private int rank;
	
	public Gamer() {}
	
	public Gamer(List<Card> hand) {
		super();
		this.hand = hand;
	}
	
	public List<Card> getHand() {
		return hand;
	}
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	public boolean isMyTurn() {
		return isMyTurn;
	}
	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
