package poker;

import java.util.ArrayDeque;

public class Main {
	static ArrayDeque<String> cards = new ArrayDeque<String>();

	public static void main(String[] args) {
		
		//Board.createBoard();
		cards = Cards.createCards();
		Play.play(cards);

	}

}
