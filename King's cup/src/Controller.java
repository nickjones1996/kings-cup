import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Controller {

	private int round = 0;
	private int numberOfPlayers;
	private static List<Card> deck;
	private static int cardsLeft = 51;
	private static String message = "";
	private static boolean gameOver = false;
	private int crackNumber;
	private Random rand;
	public Controller()
	{
		rand = new Random();
		deck = initializeDeck();
		crackNumber = rand.nextInt(17)+10;
	}
	private List<Card> initializeDeck() {
		String[] suits = {"Spades", "Diamonds", "Hearts", "Clubs"};
		String [] face = {"King", "Queen", "Jack", "10", "9", "8", "7", "6","5", "4", "3", "2", "Ace"};
		int[] values = {10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 11}; 
		String[] categories = {"K", "Q", "J","10", "9","8","7", "6","5", "4", "3", "2", "A"};
		List<Card> returnable = new ArrayList<Card>();
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 13; j++)
			{
				Card temp = new Card( values[j], face[j] + " of " + suits[i], categories[i]);
				returnable.add(temp);
			}
		return returnable;
	}
	public void resetRandomNumber()
	{
		crackNumber = rand.nextInt(17)+10;
	}
	public Card getNextCard()
	{
		if(cardsLeft >= 0)
			return deck.get(cardsLeft--);
		else
			shuffleDeck();
		return deck.get(cardsLeft--);
	}
	public void shuffleDeck()
	{
		Collections.shuffle(deck);
		cardsLeft = 51;
	}
	
	public String getCardMessage(Card c) {
		String msg = "";
		String cat = c.getCategory();
		switch(cat) {
		case "K":
			msg = "King, Make a Rule";
			break;
		case "Q":
			msg = "Queen, Questions";
			break;
		case "J":
			msg = "Jack, Make a Rule";
			break;
		case "A":
			msg = "Ace, Waterfall Time!";
			break;
		case "10":
			msg = "Ten, Never have I ever";
			break;
		case "9":
			msg = "Nine, Rhyme";
			break;
		case "8":
			msg = "Eight, Mate";
			break;
		case "7":
			msg = "Seven, Heaven";
			break;
		case "6":
			msg = "Six, chicks";
			break;
		case "5":
			msg = "Five, guys";
			break;
		case "4":
			msg = "Four, Floor";
			break;
		case "3":
			msg = "Three, me";
			break;
		case "2":
			msg = "Two...YOU!";
			break;
		default: 
			msg = "Unknown card type";
			break;
		}
		return msg;
		
	}
		
	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public static List<Card> getDeck() {
		return deck;
	}

	public static void setDeck(List<Card> deck) {
		Controller.deck = deck;
	}

	public static int getCardsLeft() {
		return cardsLeft;
	}

	public static void setCardsLeft(int cardsLeft) {
		Controller.cardsLeft = cardsLeft;
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		Controller.message = message;
	}

	public static boolean isGameOver() {
		return gameOver;
	}

	public static void setGameOver(boolean gameOver) {
		Controller.gameOver = gameOver;
	}
}
