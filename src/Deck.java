import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
  // Implement the rest of this class yourself
  //Instance variables must be cards and nextCardIndex for the provided constructor to work.
  ArrayList <Card> cards;
  int nextCardIndex;
  
  public Deck() {
    //Creates a deck with all standard 81 set cards, shuffled.
    //Usage (in test code, and in later code):
    //Deck d = new Deck();
    nextCardIndex = 0;
    cards = new ArrayList<Card>(81);
    for (int var1 = 1; var1 <= 3; var1++) {
      for (int var2 = 1; var2 <= 3; var2++) {
        for (int var3 = 1; var3 <= 3; var3++) {
          for (int var4 = 1; var4 <= 3; var4++) {
            cards.add(new Card(var1, var2, var3, var4));
          }
        }
      }
    }
   Collections.shuffle(cards);
  }
            
  public Deck(String filename) {
    //Creates a pre-defined deck from a file named filename,
    //and does not shuffle it.
    //Usage (in test code, and in later code):
    // Deck d = new Deck("example.dat");
    cards = new ArrayList<Card>(81);
    
    try {
      String line;
      BufferedReader infile = new BufferedReader(new FileReader(filename));
      int position = 0;
  
      while((line = infile.readLine()) != null) {
        // Blank lines might contain white space, so trim it off
        line = line.trim();
        
        // ignore blank lines
        if(line.length() == 0)
          continue;
        
        // ignore comments
        if(line.startsWith("#"))
          continue;
            
        // a valid line contains 4 integers
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        int quantity = Integer.parseInt(tokenizer.nextToken());
        int color = Integer.parseInt(tokenizer.nextToken());
        int shading = Integer.parseInt(tokenizer.nextToken());
        int shape = Integer.parseInt(tokenizer.nextToken());
        
        cards.add(new Card(quantity, color, shading, shape));
        nextCardIndex = 0;
      }
    }
   catch(Exception e) {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
  }
    public boolean hasNext() {
      //returns true if any cards are left, false otherwise
      if (nextCardIndex == cards.size()) {
        return false;
      }
      else {
        return true;
      }
    }
 
    public Card getNext() {
      //returns the next card in the deck
      if (hasNext()) {
        nextCardIndex++;
        return cards.get(nextCardIndex-1);
      }
      else {
        return null;
        
      }
    }
}