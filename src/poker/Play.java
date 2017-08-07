package poker;

import java.util.ArrayDeque;
import java.util.Stack;

public class Play {

	public static void play(ArrayDeque<String> cards){
		Deal d = new Deal();
		Bets b = new Bets();
		FindHand f = new FindHand();
		Stack<String> comCards = new Stack<String>();
		Stack<String> hand = new Stack<String>();
		
		hand = d.dealHand(cards);
			b.initialBet();
		comCards = d.dealFlop(cards);
			b.flopBet();
		comCards = d.dealTurn(cards, comCards);
			b.turnBet();
		comCards = d.dealRiver(cards, comCards);
			b.finalBet();
			
		f.findHand(comCards, hand);
	}
}
