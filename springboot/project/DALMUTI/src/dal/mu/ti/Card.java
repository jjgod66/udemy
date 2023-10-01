package dal.mu.ti;

public class Card {
	private int rank;

	public Card() {};
	
	public Card(int rank) {
		super();
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "[rank=" + rank + "]";
	}
	
}
