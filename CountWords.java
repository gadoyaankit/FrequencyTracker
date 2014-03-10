import java.util.Iterator;
import java.util.List;
class CountWords
{
	
	private BinarySearchTree bst;
	
	CountWords()
	{
		 bst = new BinarySearchTree();
	}
	
	/**
	 * @param It calculates the frequency of each word in the string.
	 * It only includes alphanumeric character.
	 */
	public void getWordFrequency(String s)
	{
		getFrequencyHelper(s.split(" "));
	}

	private void getFrequencyHelper(String textArray[])
	{
		
		for(int i=0;i<textArray.length;i++)
		{
			if(!(textArray[i].trim().equals("")))
			{
				String text = textArray[i].replaceAll("[^\\dA-Za-z ]","");
				bst.insert(text);
			}

		}
		if(bst.size()!=0)
			
			bst.display();
		else
			System.out.println("No elements found.\n");
	}

	public double getAverage()
	{
		if(bst.size()==0)
			return 0;
		List<Integer> counts = bst.getFrequencyList();
		int sum = 0;
		Iterator<Integer> countIterator = counts.iterator();
		
		do
		{
			sum =sum + countIterator.next();
		}
		while((countIterator.hasNext()));
		
		int size = counts.size();
		
		double avg = (double)sum/(double)size;
		return avg;
	}
	public double getStandardDeviation()
	{
		if (bst.size()==0)
				return 0;
		return calculateStandardDeviation();
	}
	
	public double calculateStandardDeviation()
	{
		List<Integer> counts = bst.getFrequencyList();
		Iterator<Integer> countIterator = counts.iterator();
		
		int size = counts.size();

		double sumd = 0;
		double avg = getAverage();
		countIterator = counts.iterator();
		do
		{
			double f = (double)countIterator.next();
			
			sumd += Math.pow((f-avg),2);
		}
		while((countIterator.hasNext()));
		
		double avgd = sumd/size;
		return Math.sqrt(avgd);
	}

	/**
	 * @return the bst
	 */
	public BinarySearchTree getbst() {
		return bst;
	}

	/**
	 * @param bst the bst to set
	 */
	public void setbst(BinarySearchTree bst) {
		this.bst = bst;
	}
	
	
}

