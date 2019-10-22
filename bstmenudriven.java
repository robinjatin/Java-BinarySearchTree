import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int d)
	{
		data = d;
		left = null;
		right = null;
	}
}

public class BinarySearchTree {

	static Node root;
	static int n;
	static int count1,count2=0,count=0;
	
	BinarySearchTree()
	{
		root = null;
	}
	public static void insert(int data)
	{
		root = insertitem(root,data);
	}
	public static Node insertitem(Node root,int data)
	{
		if(root == null)
		{
			root = new Node(data);
		}	
		else
		{
			if(data < root.data)
				root.left = insertitem(root.left,data);
			
				
			else if(data > root.data)	
				root.right = insertitem(root.right,data);	
		}
		return root;
	}
	
	static void inorder(Node root1)
	{
		if(root1 != null)
		{
			inorder(root1.left);
			System.out.println(root1.data);
			inorder(root1.right);
		}
	}
	
	static void preorder(Node root1)
	{
		if(root1 != null)
		{
			System.out.println(root1.data);
			preorder(root1.left);
			preorder(root1.right);
		}
	}
	
	static void postorder(Node root1)
	{
		if(root1 != null)
		{
			postorder(root1.left);
			postorder(root1.right);
			System.out.println(root1.data);
		}
	}
	
	public static void search(int ele)
	{
		searchItem(root,ele);
	}
	
	public static void searchItem(Node root,int ele)
	{
		if(root == null)
		System.out.println("Not Found");
		
		else if(root.data == ele)
		{
			System.out.println("Found");
		}
		else if(ele < root.data)
		{
			searchItem(root.left,ele);
		}
		else if(ele > root.data)
		{
			searchItem(root.right,ele);
		}
	}
	public static void height()
	{
		int h1=Height1(root);
		int h2=Height2(root);
		if(h1==h2)
			System.out.println("Height of this tree:-"+h1);
		else if(h1>h2)
			System.out.println("Height of this tree:-"+h1);
		else if(h1<h2)
			System.out.println("Height of this tree:-"+h2);
	}
	public static int Height1(Node root)
	{
		if(root==null)
			return count1;
		else if(root.left!=null)
			{
				Height1(root.left);
				count1++;
			}
		return count1;
	}
	public static int Height2(Node root)
	{
		if(root==null)
			return count2;
		else if(root.right!=null)
			{
				Height1(root.right);
				count2++;
			}
		return count2;
	}
	public static Node minValue(Node node)
	{
		Node current=node;
		while(current.left!=null)
		{
			current=current.left;
		}
		return current;
	}
	public static Node delete(Node root,int data)
	{
		if(root==null)
		{
			System.out.println("No element to delete");
			return null;
		}
		else if(data<root.data)
		{
			root.left=delete(root.left,data);
		}
		else if(data>root.data)
		{
			root.right=delete(root.right,data);
		}
		else
		{
			Node temp=null;
			if(root.left==null && root.right==null)
			{
				return null;
			}
			else if(root.left==null)
			{
				temp=root.right;
				return temp;
			}
			else if(root.right==null)
			{
				temp=root.left;
				return temp;
			}
			else
			{
				temp=minValue(root.right);
				root.data=temp.data;
				root.right=delete(root.right,temp.data);
			}
		}
		return root;
	}
	public static void findLevel(int data)
	{
		count=0;
		Level(root,data);
	}
	public static void Level(Node root,int data)
	{
		if(root==null)
		{
			System.out.println(data+" not found");
		}
	else if(root.data==data)
	{
		System.out.println("Level of "+data+" is "+count);
	}
	else if(root.data>data)
		{
		    count++;
			Level(root.left,data);
		}
	else if(root.data<data)
		{
			count++;
			Level(root.right,data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		 Scanner S = new Scanner(System.in);
		/* System.out.println("Enter the number of elements you want in the tree");
		 int n=S.nextInt();
		 System.out.println("Enter the elements");
		 for(int i=0;i<n;i++)
		 {
			 int a=S.nextInt();
			 insert(a);
		 }*/
		insert(70);
		insert(65);
		insert(30);
		insert(60);
		insert(100);
		insert(80);
		insert(150);        
       
		int x=0,i,ele,op1;
		String s = new String();
		String str = new String();
		
		
	while(s.equalsIgnoreCase("n")||s.equalsIgnoreCase("no") == false)
	{	
		System.out.println("LINKED LIST");
		System.out.println("PRESS 1 TO INSERT");
		System.out.println("PRESS 2 TO DELETE");
		System.out.println("PRESS 3 TO DISPLAY");
		System.out.println("PRESS 4 TO SEARCH");
		System.out.println("PRESS 5 TO FIND HEIGHT");
		System.out.println("PRESS 6 TO FIND LEVEL");
		
	try
		{
			x = S.nextInt();
		
		switch(x)
		{
			case 1:
			{
					System.out.println("Enter the non duplicate elements");
				try {
					int elee=S.nextInt();
					insert(elee);
				}
				catch(Exception e)
				{
					System.out.println("Invalid input");
				}
				break;
			}
			case 2:
			{
				if(root != null)
				{
						System.out.println("Enter the element to delete");
						ele = S.nextInt();
						delete(root,ele);
				}
				else
					System.out.println("Tree does not exist.");
				break;
			}
			case 3:
			{
				if(root != null)
				{
					System.out.println("Press 1 to display preorder");
					System.out.println("Press 2 to display inorder");
					System.out.println("Press 3 to display postorder");
					
					op1 = S.nextInt();
					
					if(op1 == 1)
					{
						preorder(root);
					}
					else if(op1 == 2)
					{
						inorder(root);
					}
					else if(op1 == 3)
					{
						postorder(root);
					}
					else
						System.out.println("Invalid Input!");
				}
				else
					System.out.println("Tree does not exist.");
				break;
			}
			case 4:
			{
				if(root != null)
				{
						System.out.println("Enter the element to search");
						ele = S.nextInt();
						search(ele);
				}
				else
					System.out.println("Tree does not exist.");
				break;
			}
			case 5:
			{
				if(root != null)	
					height();
				else
					System.out.println("Tree does not exist.");
				break;
			}
			case 6:
			{
				if(root != null)	
				{
					System.out.println("Enter the number of which you want to find the level of: ");
					int lev=S.nextInt();
					findLevel(lev);
				}
					
				else
					System.out.println("Tree does not exist.");
				break;
			}
			default:
			{
				System.out.println("Invalid Input!");
			}
		}
	}
	catch(InputMismatchException e)
	{
		System.out.println("Invalid Input!");
	}
	catch(NullPointerException e)
	{
		System.out.println("List doesn't exist.");
	}
		System.out.println("Do you want to continue? (Enter Y/N)");
		S.nextLine();
		s = S.next();
		if(s.equalsIgnoreCase("no")||s.equalsIgnoreCase("n"))
		{
			break;
		}
		else if(s.equalsIgnoreCase("yes")||s.equalsIgnoreCase("y"))
		{
		continue;
		}
		else
		{
			System.out.println("Invalid datatype");
		}	
	}
}	
}
