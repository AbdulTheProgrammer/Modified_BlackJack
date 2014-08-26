import hsa.*;

public class CardType {
    int value;
    String suit;
    //String color;
    public CardType (int value, String suit/*, String color*/){
	this.value = value;
	this.suit = suit;
	//this.color = color;
    }
    public int getValue(){
	return value;
    }
    public String getSuit() {
	return suit;
    }
    /*public String getColor() {
	return color;
    }*/
}
