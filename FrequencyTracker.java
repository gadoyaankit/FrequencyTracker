import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FrequencyTracker
{
	public static void main(String args[])
	{
		System.out.println("Enter you text. When finish entering press Ctrl+z followed by Enter.\n");
		
		CountWords c = new CountWords();
		
		// Create a buffer to read the input from the user.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer s = new StringBuffer();
		
		// read the input from the user until user breaks by doing ctrl+z
		try 
		{
			String currentLine;
			do
			{				
				currentLine = br.readLine();
				if(currentLine!=null)
					s.append(" "+currentLine);
			}
			while(currentLine!=null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\nWord Frequencies: \n");
		
		// Get the frequency of the word
		c.getWordFrequency(s.toString());
		
		/*
		 * Mean specifies on average how many times a word occurs in text
		 */
		System.out.println("\nMean: "+c.getAverage());
		/*
		 * Get the standard deviation.
		 * I used the standard deviation formula from this site:
		 * http://www.mathsisfun.com/data/standard-deviation-formulas.html
		 */
		System.out.println("\nStandard deviation is: "+c.getStandardDeviation());
		
		
	}
}

