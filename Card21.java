import hsa.*;
import java.awt.*;


public class Card21
{
    static Console c;
    static Console d;
    public static void main (String[] args)
    {
	d = new Console ();
	c = new Console ();
	String choice1 = "";
	int money = 0; // variable for the amount of money
	c.println ("--------------------------------------------------------------------------------");
	c.println ("Do you want to play Black Jack?? Y or N");
	c.println ("--------------------------------------------------------------------------------");
	choice1 = c.readLine (); //ask if you want to play
	String option = "";
	if (choice1.equalsIgnoreCase ("y"))
	{
	    c.println ("How much money do you want to play with? The game ends when you have $0.");
	    money = c.readInt (); // input the amount of money you want to play with, store inside variable money
	    while (!option.equalsIgnoreCase ("n")) // when you do not want to play, press n
	    {
		if (money != 0) // if your balance is equal to 0, the game ends, you have lost
		{
		    money = Game (money); //method for playing game activates
		    c.println ("Do you want to continue playing? Y or N"); // if balance is not equal to 0, then you have the option to continue
		    option = c.readLine ();
		    d.clear (); // clears the input screen
		}
		else if (money == 0)
		{
		    break;
		}
	    }
	}
	c.clear (); // once game is done, clear both screens
	d.clear ();
	c.println ("The game has ended.");
	c.println ("Your balance is " + "$" + money);
	d.println ("The game has ended.");
	d.println ("Your balance is " + "$" + money);
    }


    public static int Game (int money)  // method for game
    {
	CardDeck deck = new CardDeck (); // refer back to deck
	c.clear (); //clear screen
	deck.Shuffle (); //shuffle deck
	c.clear ();
	int sum = 0; // sum of player
	int dsum = 0; // sum of dealer
	int cardno = 4; // number of cards on the table
	int choose1 = (int) (Math.random () * 40) + 1; // randomizes player's 1st card
	int betmoney; // amount of money in the pot
	c.println ("Money balance: " + money); //display amount of money

	while (true) // loop to check if betmoney is a valid amount
	{
	    c.print ("Enter betting amount: ");
	    betmoney = c.readInt ();
	    if (money >= betmoney && betmoney > 0)
	    {
		break;
	    }
	    else
	    {
		c.println ("Amount entered is invalid");
	    }
	}
	c.clear ();

	CardType card1 = deck.cards [choose1]; // randomizes first card of player
	String value1 = Integer.toString (card1.getValue ()); // store the value pf the first card in value1
	deck.cards [choose1].value = 0; // changes the value of the card choosen to zero in the array of records

	int choose2 = (int) (Math.random () * 40) + 1; //randomizes the player's second card and takes from deck

	while (deck.cards [choose2].getValue () == 0)
	{
	    choose2 = (int) (Math.random () * 40) + 1;
	}

	CardType card2 = deck.cards [choose2];
	String value2 = Integer.toString (card2.getValue ());
	deck.cards [choose2].value = 0;

	int choose3 = (int) (Math.random () * 40) + 1; // randomizes dealer's card and takes from deck
	while (deck.cards [choose3].getValue () == 0)
	{
	    choose3 = (int) (Math.random () * 40) + 1;
	}


	CardType card3 = deck.cards [choose3]; // randomizes dealer's other card and takes from deck
	String value3 = Integer.toString (card3.getValue ());
	deck.cards [choose3].value = 0;

	int choose4 = (int) (Math.random () * 40) + 1;
	while (deck.cards [choose4].getValue () == 0)
	{
	    choose4 = (int) (Math.random () * 40) + 1;
	}

	CardType card4 = deck.cards [choose4];
	String value4 = Integer.toString (card4.getValue ());
	deck.cards [choose4].value = 0;

	String choice = ""; // variable to ask if player wants to stay
	int count = 1; // variable to determine the position to draw the card


	String suit1 = card1.getSuit (); // gets the suit of the first player card
	String suit2 = card2.getSuit (); // gets the suit of the second player card
	String suit3 = card3.getSuit (); // gets the suit of the first dealer card
	String suit4 = card4.getSuit (); // gets the suit fot the second dealer card


	d.drawString ("Player: ", 5, 60); //display whose hand is what
	d.drawString ("House: ", 5, 270);

	d.setColor (Color.black);  //hides the player's first card
	d.fillRect (50, 50, 90, 200);

	//draws out the second card

	if (suit2.equals ("diamond") || suit2.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (150, 50, 90, 200);
	    if (suit2.equals ("diamond"))
	    {
		d.drawString ("\u2666", 153, 60);
		d.drawString (value2, 153, 70);
	    }
	    else
	    {
		d.drawString ("\u2665", 153, 60);
		d.drawString (value2, 153, 70);
	    }
	}

	else
	{
	    d.setColor (Color.black);
	    d.drawRect (150, 50, 90, 200);
	    if (suit2.equals ("spade"))
	    {
		d.drawString ("\u2660", 153, 60);
		d.drawString (value2, 153, 70);
	    }
	    else
	    {
		d.drawString ("\u2663", 153, 60);
		d.drawString (value2, 153, 70);
	    }
	}


	d.setColor (Color.black); // fills in the hidden card of the dealer
	d.fillRect (50, 260, 90, 200);


	// draws out the deals 2nd card
	if (suit4.equals ("diamond") || suit4.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (150, 260, 90, 200);
	    if (suit4.equals ("diamond"))
	    {
		d.drawString ("\u2666", 153, 270);
		d.drawString (value4, 153, 280);
	    }
	    else
	    {
		d.drawString ("\u2665", 153, 270);
		d.drawString (value4, 153, 280);
	    }
	}


	else
	{
	    d.setColor (Color.black);
	    d.drawRect (150, 260, 90, 200);
	    if (suit4.equals ("spade"))
	    {
		d.drawString ("\u2660", 153, 270);
		d.drawString (value4, 153, 280);
	    }
	    else
	    {
		d.drawString ("\u2663", 153, 270);
		d.drawString (value4, 153, 280);
	    }
	}


	sum = Integer.parseInt (value1) + Integer.parseInt (value2); //calculates the sum of the player based on the cards
	dsum = Integer.parseInt (value3) + Integer.parseInt (value4); //calculates the sum of the dealer based on the cards
	probCalc1 (deck.cards, cardno, sum); // method calls for probability
	probCalc2 (deck.cards, cardno, sum);
	probCalc3 (deck.cards, cardno, sum);
	c.println ("Your current sum is " + sum + ", your hidden card is " + value1 + " of " + suit1 + "s"); // display sum and tell player his hidden card


	int choose = (int) (Math.random () * 40) + 1; // randomizes all of the players subsequent cards from the deck
	while (sum < 21 && !choice.equalsIgnoreCase ("N")) // loop runs until player does not want any more cards or has a sum of over 21; bust
	{
	    c.println ("Want another card? Y or N?");  //asks if player wants another card
	    choice = c.readString ();
	    count++;
	    if (choice.equalsIgnoreCase ("n"))
	    {
		break;
	    }
	    while (deck.cards [choose].getValue () == 0)
	    {
		choose = (int) (Math.random () * 40) + 1; // randomizes all of the players subsequent cards from the deck
	    }
	    CardType card = deck.cards [choose];
	    String suit = card.getSuit (); // these variable store the suit and the value of the player's cards
	    String value = Integer.toString (card.getValue ());

	    //draws out each of the player's cards accordingly
	    if (suit.equals ("diamond") || suit.equals ("heart"))
	    {
		d.setColor (Color.red);
		d.drawRect (100 * count + 50, 50, 90, 200);
		cardno++;
		if (suit.equals ("diamond"))
		{
		    d.drawString ("\u2666", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
		else
		{
		    d.drawString ("\u2665", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
	    }
	    else
	    {
		cardno++;
		d.setColor (Color.black);
		d.drawRect (100 * count + 50, 50, 90, 200);
		if (suit.equals ("spade"))
		{
		    d.drawString ("\u2660", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
		else
		{
		    d.drawString ("\u2663", 100 * count + 53, 60);
		    d.drawString (value, 100 * count + 53, 70);
		}
	    }
	    sum = card.getValue () + sum;
	    deck.cards [choose].value = 0;
	    probCalc1 (deck.cards, cardno, sum); // probability display; method calls
	    probCalc2 (deck.cards, cardno, sum);
	    probCalc3 (deck.cards, cardno, sum);
	    c.println ("Your current sum is " + sum + ", your hidden card is " + value1 + " of " + suit1 + "s");

	    if (sum >= 21)
	    {
		break;
	    }

	}


	count = 1;
	int dchoose = (int) (Math.random () * 40) + 1;
	while (dsum < 21)
	{
	    count++; //increment count according to the number of cards, aids in the drawing of the cards on d console
	    if (dsum >= 17)
	    {
		break;
	    }
	    while (deck.cards [dchoose].getValue () == 0) // while loop so that it doesnt choose a card with a value of 0 (one that has already been choosen and replaced in the array of records)
	    {
		dchoose = (int) (Math.random () * 40) + 1;
	    }
	    CardType dcard = deck.cards [dchoose];
	    String dsuit = dcard.getSuit ();
	    String dvalue = Integer.toString (dcard.getValue ());

	    // draws out each of the dealers subsequent cards
	    if (dsuit.equals ("diamond") || dsuit.equals ("heart"))
	    {
		cardno++;
		d.setColor (Color.red);
		d.drawRect (100 * count + 50, 260, 90, 200);
		if (dsuit.equals ("diamond"))
		{
		    d.drawString ("\u2666", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
		else
		{
		    d.drawString ("\u2665", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
	    }
	    else
	    {
		cardno++;
		d.setColor (Color.black);
		d.drawRect (100 * count + 50, 260, 90, 200);
		if (dsuit.equals ("spade"))
		{
		    d.drawString ("\u2660", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
		else
		{
		    d.drawString ("\u2663", 100 * count + 53, 270);
		    d.drawString (dvalue, 100 * count + 53, 280);
		}
	    }
	    dsum = dcard.getValue () + dsum;
	    deck.cards [dchoose].value = 0;
	    if (dsum >= 17 || dsum >= 21)
	    {
		break;
	    }
	}
	
	//displays the player's first hidden card once the game is over

	d.setColor (Color.white);
	d.fillRect (50, 260, 90, 200);
	if (suit1.equals ("diamond") || suit1.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (50, 260, 90, 200);
	    if (suit3.equals ("diamond"))
	    {
		d.drawString ("\u2666", 53, 270);
		d.drawString (value3, 53, 280);
	    }
	    else
	    {
		d.drawString ("\u2665", 53, 270);
		d.drawString (value3, 53, 280);
	    }
	}

	else
	{
	    d.setColor (Color.black);
	    d.drawRect (50, 260, 90, 200);
	    if (suit3.equals ("spade"))
	    {
		d.drawString ("\u2660", 53, 270);
		d.drawString (value3, 53, 280);
	    }
	    else
	    {
		d.drawString ("\u2663", 53, 270);
		d.drawString (value3, 53, 280);
	    }
	}

	//displays the player's first hidden card once the game is over
	d.setColor (Color.white);
	d.fillRect (50, 50, 90, 200);
	if (suit1.equals ("diamond") || suit1.equals ("heart"))
	{
	    d.setColor (Color.red);
	    d.drawRect (50, 50, 90, 200);
	    if (suit1.equals ("diamond"))
	    {
		d.drawString ("\u2666", 53, 60);
		d.drawString (value1, 53, 70);
	    }
	    else
	    {
		d.drawString ("\u2665", 53, 60);
		d.drawString (value1, 53, 70);
	    }
	}


	else
	{
	    d.setColor (Color.black);
	    d.drawRect (50, 50, 90, 200);
	    if (suit1.equals ("spade"))
	    {
		d.drawString ("\u2660", 53, 60);
		d.drawString (value1, 53, 70);
	    }
	    else
	    {
		d.drawString ("\u2663", 53, 60);
		d.drawString (value1, 53, 70);
	    }
	}

	// executes once the game is over; all conditions for end game
	if (sum > 21)
	{
	    money = money - betmoney; // if you lose the money you bet is gone
	    c.println ("Your score is " + sum + " , YOU LOST!");
	    c.println ("Your balance is: " + money);
	    return money;
	}


	else if (dsum > 21)
	{
	    money = money + betmoney * 2; // if you win you get the dealer's money too
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , YOU WIN!");
	    c.println ("Your balance is: " + money);
	    return money;
	}


	else if (sum > dsum)
	{
	    money = money + betmoney * 2;
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , YOU WIN!");
	    c.println ("Your balance is: " + money);
	    return money;
	}

	else if (sum == dsum)
	{
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , DRAW!");
	    c.println ("Your balance is: " + money); // if you lose, then nothing happens to your money
	    return money;
	}
	else
	{
	    c.println ("Dealer's score is " + dsum);
	    c.println ("Your score is " + sum + " , YOU LOST!");
	    c.println ("Your balance is: " + money);
	    c.println ();
	    return money;
	}
    }


    public static void probCalc1 (CardType cards[], int cardno, int sum)  // method to calculate the probabilty of getting a card 5 or higher in the next turn
    {
	int prob1 = 0;
	for (int i = 1 ; i <= cards.length - 1 ; i++)
	{
	    if (cards [i].getValue () >= 5)
	    {
		prob1++;
	    }
	}
	if (sum >= 21)
	{
	}
	else
	{
	    c.println ("the probability of getting a card with a value of 5 or higher is " + Math.round ((prob1) / (40.0 - cardno) * 100) + "%");
	}
    }


    public static void probCalc2 (CardType cards[], int cardno, int sum)  // method to calculate the probabilty of getting 21 in the next turn
    {
	int prob2 = 0;
	for (int i = 1 ; i <= cards.length - 1 ; i++)
	{
	    if (sum + cards [i].getValue () == 21)
	    {
		prob2++;
	    }
	}


	if (sum >= 21)
	{
	}
	else
	{
	    c.println ("the probability of the player getting 21 in the next round is " + Math.round ((prob2) / (40.0 - cardno) * 100) + "%");
	}
    }


    public static void probCalc3 (CardType cards[], int cardno, int sum)  //method to calculate the probabilty of getting over 21
    {
	int prob3 = 0;
	for (int i = 1 ; i <= cards.length - 1 ; i++)
	{
	    if (sum + cards [i].getValue () > 21)
	    {
		prob3++;
	    }
	}
	if (sum >= 21)
	{
	}


	else
	{
	    c.println ("the probability of the player losing in the next round is " + Math.round ((prob3) / (40.0 - cardno) * 100) + "%");
	}
    }
}


