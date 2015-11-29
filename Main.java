////////////////////////////////////////////////////////////////////////////////
//////////////////////////program  Algorithms Text Matching/////////////////////
package AlgorithmsTextMatching;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main {
	
	public static void main(String[] args) {  
        System.out.print("Product Search - Input your keyword (s):");
        String input = JOptionPane.showInputDialog("Product Search - Input your keyword (s)");
                        BoyerMo b = new BoyerMo(input);
			b.PrintOutput(); 
        }
}
