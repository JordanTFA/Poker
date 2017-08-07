package poker;

import java.util.ArrayDeque;
import java.util.Stack;

public class Deal {

	Bets b = new Bets();
	Cards c = new Cards();
	Stack<String> comCards = new Stack<String>();
	Stack<String> cardsToAdd = new Stack<String>();

	
	public Stack<String> deal(int numberToDeal, ArrayDeque<String> cards){
		
		String addedCard, cardText;
		
		Stack<String> dealtCards = new Stack<String>();
	
		for(int i = 0; i < numberToDeal; i ++){
			
			dealtCards.add(addedCard = cards.poll());
			cardText = c.parseCards(addedCard);
			System.out.println(cardText);
		}
		
		return dealtCards;
		
	}

	
	public Stack<String> dealHand(ArrayDeque<String> cards){
			
		int numberToDeal = 2;
		
		System.out.println("Starting Hand:");
		Stack<String> hand = deal(numberToDeal, cards);
		System.out.println(hand); 	
		
		return hand;
	}
	
	public Stack<String> dealFlop(ArrayDeque<String> cards){
	
		int numberToDeal = 3;
		
		System.out.println("\nFlop:");


		cardsToAdd = deal(numberToDeal, cards);
		
		for( int i = 0; i < 3; i++)
		{
			comCards.push(cardsToAdd.pop());
		}
		
		System.out.println(comCards);
		
		return comCards;
		
		
	}
	
	public Stack<String> dealTurn(ArrayDeque<String> cards, Stack<String> comCards){
	
		int numberToDeal = 1;
		
		System.out.println("\nTurn:");
		cardsToAdd = deal(numberToDeal, cards);
		
		System.out.println(cardsToAdd);
		
		for( int i = 0; i < 1; i++)
		{
			comCards.push(cardsToAdd.pop());
		}

		
		System.out.println(comCards);
		
		return comCards;
		
	}
	
	public Stack<String> dealRiver(ArrayDeque<String> cards, Stack<String> comCards){
		
		int numberToDeal = 1;
		
		System.out.println("\nRiver:");
		cardsToAdd = deal(numberToDeal, cards);
		
		System.out.println(cardsToAdd);
		
		for( int i = 0; i < 1; i++)
		{
			comCards.push(cardsToAdd.pop());
		}

		
		System.out.println(comCards);
		
		return comCards;
		
	}
}
