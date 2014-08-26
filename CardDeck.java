import hsa.*;
import java.awt.*;

public class CardDeck
{
    CardType[] cards = new CardType [53];
    String[] suit = {"spade", "heart", "dimaond", "club"};
    public CardDeck ()
    {
	int number = 1;
	for (int suit1 = 0 ; suit1 < suit.length ; suit1++)
	{
	    for (int card1 = 1 ; card1 <= 13 ; card1++)
	    {
		cards [number] = new CardType (card1, suit [suit1]);
		number++;
	    }
	}
    }
    public void printDeck (Console c)
    {
	for (int i = 1 ; i <= 52 ; i++)
	{
	    c.println (cards [i].getValue () + " " + cards [i].getSuit ());
	}
    }
    public void swap(int i, int j){
	CardType temp = cards[i];
	cards[i] = cards[j];
	cards[j] = temp;
    }
    public void Shuffle(){
	for (int i = 1; i <= 52; i++){
	    int random = (int)(Math.random() * 52)+1;
	    swap(i,random);
	}
    }
    public void draw(Graphics g){
	g.drawRect(20,20,20,20);
    }
}
