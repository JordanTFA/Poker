package poker;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Random;


public class Cards {

	public static ArrayDeque<String> createCards(){
		
		String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
		String[] suits = {"H", "C", "D", "S"};

		ArrayList<String> a = new ArrayList<String>();
		ArrayDeque<String> q;

		
		for( int i = 0; i < rank.length; i++){
			
			for(int j = 0; j < suits.length; j++){
				a.add(rank[i] + suits[j]);
				
			}	
		}
		q = (ArrayDeque<String>) shuffle(a);			// Shuffle

		return q;

	}
	
	public static Queue<String> shuffle(ArrayList<String> a){
	    
		Random r = new Random();
		Collections.shuffle(a, new Random(r.nextInt()));
		
		ArrayDeque<String> q = new ArrayDeque<String>();
		
		for(int i = 0; i < a.size(); i++){
			
			q.offer(a.get(i));
	
		}

		return q;	
	}
	
	public String parseCards(String card){

		String rank = card.substring(0, 1);
		String suit = card.substring(1);
		
		switch(rank)
		{	
		case "T":
			rank = "10";
			break;
		case "J":
			rank = "Jack";
			break;
		case "Q":
			rank = "Queen";
			break;
		case "K":
			rank = "King";
			break;
		case "A":
			rank = "Ace";
			break;
		}
		
		switch(suit)
		{
		case "H":
			suit = "Hearts";
			break;
		case "C":
			suit = "Clubs";
			break;
		case "D":
			suit = "Diamonds";
			break;
		case "S":
			suit = "Spades";
			break;
		}
		
		card = (rank + " of " + suit);
		
		return card;

	}
	
}
