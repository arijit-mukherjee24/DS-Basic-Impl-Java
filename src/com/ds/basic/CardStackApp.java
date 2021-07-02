package com.ds.basic;


public class CardStackApp {
	BasicStack<String> stack = new BasicStack<String>();

	public static void main(String[] args) {
		CardStackApp app = new CardStackApp();
		app.stackCards();
		app.unstackCards();
		
		//restack cards
		app.stackCards();
		
		//how many cards are on the deck
		app.desckSize();
		
		//do we have queen of hearts in the deck
		app.containsCard("Queen of Hearts");

		//do we have a joker
		app.containsCard("Joker");

		//go to the king of diamonds
		app.goToCard("King of Diamonds");

		//now how many cards are on the deck
		app.desckSize();
}

	public void stackCards() {		
		//stack the spade suit
		stack.push("Ace of Spades");
		stack.push("2 of Spades");
		stack.push("3 of Spades");
		stack.push("4 of Spades");
		stack.push("5 of Spades");
		stack.push("6 of Spades");
		stack.push("7 of Spades");
		stack.push("8 of Spades");
		stack.push("9 of Spades");
		stack.push("10 of Spades");
		stack.push("Jack of Spades");
		stack.push("Queen of Spades");
		stack.push("King of Spades");

		//stack the diamond suit
		stack.push("Ace of Diamonds");
		stack.push("2 of Diamonds");
		stack.push("3 of Diamonds");
		stack.push("4 of Diamonds");
		stack.push("5 of Diamonds");
		stack.push("6 of Diamonds");
		stack.push("7 of Diamonds");
		stack.push("8 of Diamonds");
		stack.push("9 of Diamonds");
		stack.push("10 of Diamonds");
		stack.push("Jack of Diamonds");
		stack.push("Queen of Diamonds");
		stack.push("King of Diamonds");

		//stack the club suit
		stack.push("Ace of Clubs");
		stack.push("2 of Clubs");
		stack.push("3 of Clubs");
		stack.push("4 of Clubs");
		stack.push("5 of Clubs");
		stack.push("6 of Clubs");
		stack.push("7 of Clubs");
		stack.push("8 of Clubs");
		stack.push("9 of Clubs");
		stack.push("10 of Clubs");
		stack.push("Jack of Clubs");
		stack.push("Queen of Clubs");
		stack.push("King of Clubs");

		//stack the heart suit
		stack.push("Ace of Hearts");
		stack.push("2 of Hearts");
		stack.push("3 of Hearts");
		stack.push("4 of Hearts");
		stack.push("5 of Hearts");
		stack.push("6 of Hearts");
		stack.push("7 of Hearts");
		stack.push("8 of Hearts");
		stack.push("9 of Hearts");
		stack.push("10 of Hearts");
		stack.push("Jack of Hearts");
		stack.push("Queen of Hearts");
		stack.push("King of Hearts");
	}
	
	public void unstackCards() {			
		//now pull the cards off the stack and print them
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	public void containsCard(String card) {			
		System.out.println(stack.contains(card));
	}

	public void goToCard(String card) {			
		System.out.println(stack.access(card));
	}

	public void desckSize() {			
		System.out.println(stack.size());
	}
}

/* Output:
King of Hearts
Queen of Hearts
Jack of Hearts
10 of Hearts
9 of Hearts
8 of Hearts
7 of Hearts
6 of Hearts
5 of Hearts
4 of Hearts
3 of Hearts
2 of Hearts
Ace of Hearts
King of Clubs
Queen of Clubs
Jack of Clubs
10 of Clubs
9 of Clubs
8 of Clubs
7 of Clubs
6 of Clubs
5 of Clubs
4 of Clubs
3 of Clubs
2 of Clubs
Ace of Clubs
King of Diamonds
Queen of Diamonds
Jack of Diamonds
10 of Diamonds
9 of Diamonds
8 of Diamonds
7 of Diamonds
6 of Diamonds
5 of Diamonds
4 of Diamonds
3 of Diamonds
2 of Diamonds
Ace of Diamonds
King of Spades
Queen of Spades
Jack of Spades
10 of Spades
9 of Spades
8 of Spades
7 of Spades
6 of Spades
5 of Spades
4 of Spades
3 of Spades
2 of Spades
Ace of Spades
52
true
false
King of Diamonds
25
*/
