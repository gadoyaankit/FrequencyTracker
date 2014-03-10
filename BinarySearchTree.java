

import java.util.LinkedList;
import java.util.List;

class Node
{
	private int count;
	private String value;
	private Node left;
	private Node right;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
}
public class BinarySearchTree 
{
	private Node root = null;
	public void insert(String s)
	{	
		if(root==null)
		{
			Node newNode = new Node();
			newNode.setValue(s);
			newNode.setCount(1);
			root=newNode;
		}
		else
		{
			insertNode(root,s);
		}
			
	}
	
	private void insertNode(Node root,String str)
	{
		Node temp = root;
		Node prev = null;
		while(temp!=null)
		{
			prev = temp;
			if(temp.getValue().compareToIgnoreCase(str)<0)
			{
				temp=temp.getRight();
			}
				
			else
			{
				if(temp.getValue().compareToIgnoreCase(str)>0)
					temp=temp.getLeft();
				else
				{
					temp.setCount(temp.getCount()+1);
					return;
				}				
			}		
		}
		if(temp==null & prev.getValue().compareToIgnoreCase(str)<0)
		{
			Node newNode  = new Node();
			newNode.setValue(str);
			newNode.setCount(1);
			prev.setRight(newNode);
			
		}
		else
		{
			Node newNode  = new Node();
			newNode.setValue(str);
			newNode.setCount(1);
			prev.setLeft(newNode);	
		}
		return;
			
	}
	
	public void display()
	{
		if(root==null)
			System.out.println("No elements are present");
		else
		{
			displayTree(root);
		}
	}
	
	private void displayTree(Node temp)
	{
		if(temp==null)
			return;
		else
			displayTree(temp.getLeft());
			System.out.println((temp.getValue()).toLowerCase()+" : "+temp.getCount());
			displayTree(temp.getRight());
	}
	
	private Node getNode(String str)throws Exception
	{
		if(root==null)
			throw new Exception();
		else
			return findNode(root,str);
	}
	
	public boolean contains(String str)
	{
		try
		{
			Node t = getNode(str);
			return (t!=null);
		}
		catch(Exception e)
		{
			
		}

			return false;

	}
	private Node findNode(Node temp,String str)throws Exception
	{
		if(temp==null)
			throw new Exception();
		if(temp.getValue().equalsIgnoreCase(str))
			return temp;
		else
		{
			if(temp.getValue().compareToIgnoreCase(str)<0)
				return findNode(temp.getRight(),str);
			else
				return findNode(temp.getLeft(),str);
		}
	}
	
	public int getFrequency(String str)
	{
		try
		{
			Node myNode  = getNode(str);
			return myNode.getCount();
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public List<String> getNodesList()
	{
		LinkedList<String> valued = new LinkedList<String>();
		
		if(root==null)
			return null;

		else
		{
				getList(root,valued);
				return valued;
		}
	}
	
	private void getList(Node temp, LinkedList<String> values)
	{
		if(temp==null)
			return ;
		else
		{
			getList(temp.getLeft(),values);
			values.add(temp.getValue());
			getList(temp.getRight(),values);
		}
	}
	
	public int size()
	{
		if(root==null)
			return 0;
		else
			return calculateSize(root);
	}
	
	private int calculateSize(Node temp)
	{
		if(temp==null)
			return 0;
		else
		{
			int x = calculateSize(temp.getLeft());
			int y = calculateSize(temp.getRight());
			return x+y+1;
		}

	}
	
	public List<Integer> getFrequencyList()
	{
		LinkedList<Integer> valued = new LinkedList<Integer>();
		
		if(root==null)
			return null;

		else
		{
				getCountList(root,valued);
				return valued;
		}
	}
	
	private void getCountList(Node temp, LinkedList<Integer> values)
	{
		if(temp==null)
			return ;
		else
		{
			getCountList(temp.getLeft(),values);
			values.add(new Integer(temp.getCount()));
			getCountList(temp.getRight(),values);
		}
	}
	

	
}


