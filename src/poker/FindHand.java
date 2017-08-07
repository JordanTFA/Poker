package poker;

import java.util.Stack;

public class FindHand {

	public String findHand(Stack<String> comCards,Stack<String> hand){
		
		Stack<String> totalHand = new Stack<String>();
		
		for(int i = 0; i < hand.size(); i++){
			totalHand.push(hand.get(i));
		}
		for(int i = 0; i < comCards.size(); i++){
			totalHand.push(comCards.get(i));
		}
		
		System.out.println(totalHand);
		
		String finalHand = "Nothing";
		Boolean isHand = null;
		Boolean isHandTrue = false;

		isHand = checkPair(totalHand, isHandTrue);
		if(isHand)
			finalHand = "Pair";
		isHand = checkTwoPair(totalHand, isHandTrue);
		if(isHand)
			finalHand = "Two Pair";
		isHand = check3OAK(totalHand, isHandTrue);
		if(isHand)
			finalHand = "3 Of a Kind";
		isHand = checkStraight(totalHand, isHandTrue);
		if(isHand)
			finalHand = "Straight";
		isHand = checkFlush(totalHand, isHandTrue);
		if(isHand)
			finalHand = "Flush";
		isHand = checkFullHouse(totalHand, isHandTrue);
		if(isHand)
			finalHand = "Full House";
		isHand = check4OAK(totalHand, isHandTrue);
		if(isHand)
			finalHand = "4 Of a Kind";
		isHand = checkRoyalFlush(totalHand, isHandTrue);
		if(isHand)
			finalHand = "Royal Flush!";
		
		System.out.println(finalHand);
		
		return finalHand;
	}
	public Boolean checkPair(Stack<String> totalHand, Boolean isHandTrue){
		
		int[] rankArray = getRanks(totalHand);
		
		for(int i = 0; i < rankArray.length; i++){
			
			for(int j = i + 1; j < rankArray.length; j++){
				
				if(rankArray[j] == rankArray[i]){
					isHandTrue = true;
				}	
			}
		}
		
		return isHandTrue;
	}
	
	public Boolean checkTwoPair(Stack<String> totalHand, Boolean isHandTrue){
		
		int[] rankArray = getRanks(totalHand);
		int pairCount = 0;
		int token = 0;
		
		for(int i = 0; i < rankArray.length; i++){
			
			for(int j = i + 1; j < rankArray.length; j++){
				
				if(rankArray[j] == rankArray[i] &&  rankArray[j] != token){
					pairCount++;
					token = rankArray[j];
				}	
			}
		}
		
		if (pairCount > 1){
			isHandTrue = true;
		}
		return isHandTrue;
	}
	
	public Boolean check3OAK(Stack<String> totalHand, Boolean isHandTrue){
		
		int[] rankArray = getRanks(totalHand);
		int count = 0;
		
		for(int i = 0; i < rankArray.length; i++){
			
			for(int j = i + 1; j < rankArray.length; j++){
				
				if(rankArray[j] == rankArray[i]){
					count++;
					if (count > 1){
						isHandTrue = true;
					}
				}	
			}
			count = 0;
		}
		return isHandTrue;
	}
		
	public Boolean checkStraight(Stack<String> totalHand, Boolean isHandTrue){
		
		int[] rankArray = getRanks(totalHand);
		int count = 0;
		int token = 0;
		
		for(int i = 0; i < rankArray.length; i++){
			token = rankArray[i];
			for(int j = i + 1; j < rankArray.length; j++){
				rankArray[j]--;
				if(token == rankArray[j]){
					count++;
					token = rankArray[j];
				}
				rankArray[j]++;
			}
		}
		
		if(count > 3){
			isHandTrue = true;
		}
		
		return isHandTrue;
	}
	
	public Boolean checkFlush(Stack<String> totalHand, Boolean isHandTrue){
		
		String[] suitArray = getSuits(totalHand);
		int count = 1;
		
		for(int i = 0; i < suitArray.length; i++){
			
			for(int j = i + 1; j < suitArray.length; j++){
				if(suitArray[j].equals(suitArray[i])){
					count++;
					if (count > 4){
						isHandTrue = true;
					}
				}	
			}
			count = 0;
		}
		return isHandTrue;
	}
		
	public Boolean checkFullHouse(Stack<String> totalHand, Boolean isHandTrue){
		
		return isHandTrue;
	}
	
	public Boolean check4OAK(Stack<String> totalHand, Boolean isHandTrue){
		
		int[] rankArray = getRanks(totalHand);
		int count = 0;
		
		for(int i = 0; i < rankArray.length; i++){
			
			for(int j = i + 1; j < rankArray.length; j++){
				
				if(rankArray[j] == rankArray[i]){
					count++;
					if (count > 2){
						isHandTrue = true;
					}
				}	
			}
			count = 0;
		}
		return isHandTrue;
	}
	
	public Boolean checkRoyalFlush(Stack<String> totalHand, Boolean isHandTrue){
		
		return isHandTrue;
		
	}
	
	public int[] getRanks(Stack<String> fullHand){
		
		String[] cardArray = {};
		int[] rankArray = {};
		cardArray = new String[fullHand.size()];
		rankArray = new int[fullHand.size()];
		
		for(int i = 0; i < fullHand.size(); i++){			
			cardArray[i] = fullHand.get(i);	
			cardArray[i] = cardArray[i].substring(0, 1);
			
			switch(cardArray[i])
			{
			case "A":
				rankArray[i] = 14;
				break;
			case "K":
				rankArray[i] = 13;
				break;
			case "Q":
				rankArray[i] = 12;
				break;
			case "J":
				rankArray[i] = 11;
				break;
			case "T":
				rankArray[i] = 10;
				break;
			default:
				rankArray[i] = Integer.parseInt(cardArray[i]);
			}
		}
		
		
		return rankArray;
		
	}
	
	public String[] getSuits(Stack<String> fullHand){

		String[] cardArray = {};
		String[] suitArray = {};
		cardArray = new String[fullHand.size()];
		suitArray = new String[fullHand.size()];
		
		for(int i = 0; i < fullHand.size(); i++){			
			cardArray[i] = fullHand.get(i);	
			suitArray[i] = cardArray[i].substring(1,2);
		}		
		return suitArray;
		
	}
}
