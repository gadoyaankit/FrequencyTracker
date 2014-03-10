import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FrequencyTracker1
{
	public static void main(String args[])
	{
		System.out.println("Enter you text. When finish entering press Ctrl+z followed by Enter.\n");
		CountWords1 c = new CountWords1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer s = new StringBuffer();
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
		c.getWordFrequency(s.toString());
		
		System.out.println("\nMean: "+c.average());
		System.out.println("\nStandard deviation is: "+c.standardDeviation());
		
		
	}
}

