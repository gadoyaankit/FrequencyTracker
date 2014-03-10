import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class CountWords1 {
	TreeMap<String, Integer> tm;
	CountWords1()
	{
		tm = new TreeMap<String, Integer>();
	}
	/**
	 * @param It calculates the frequency of each word in the string.
	 * It only includes alphanumeric character.
	 */
	
	public void getWordFrequency(String s)
	{
		getFrequencyHelper(s.split(" "));
	}

	public void getFrequencyHelper(String textArray[])
	{
		
		for(int i=0;i<textArray.length;i++)
		{
			if(!(textArray[i].trim().equals("")))
			{
				String text = textArray[i].replaceAll("[^\\dA-Za-z ]","");
				text = text.toLowerCase();
				if(text!=null)
					if (tm.containsKey(text))
						tm.put(text, new Integer(tm.get(text).intValue()+1));
					else
						tm.put(text, new Integer(1));
			}

		}
		if(tm.size()!=0)
			display();
		else
			System.out.println("No elements found.");
		
	}
	
	private void display()
	{
		for(Map.Entry<String,Integer> entry : tm.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();
			  System.out.println(key + " => " + value);
			}
	}
	
	public double average()
	{
		if (tm.size()==0)
			return 0;
		double sum =0;
		Collection<Integer> values = tm.values();
		Iterator<Integer> t = values.iterator();
		do
		{
			sum=sum+t.next().intValue();
		}while(t.hasNext());
		
		return sum/tm.size();
	}
	
	public double standardDeviation()
	{
		if(tm.size()==0)
			return 0;
		Collection<Integer> values = tm.values();
		Iterator<Integer> it = values.iterator();
		
		double avg = average();
		
		it=values.iterator();
		double sum = 0;	
		do
		{
			double v = (double)it.next();
			sum+= Math.pow((v-avg),2);
		}
		while((it.hasNext()));
		
		double temp = sum/tm.size();
		
		return Math.sqrt(temp);
		}
}
