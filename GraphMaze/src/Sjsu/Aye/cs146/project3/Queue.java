package Sjsu.Aye.cs146.project3;


	//Breadth first search Queue
	public class Queue {

		private final int SIZE =4;
		private int [] queArray;
		private int front;
		private int rear;
		
		public Queue (){
			queArray = new int [SIZE];
			front = 0;
			rear = -1;
		}
		
		public void insert (int j)
		{
			if(rear ==(SIZE -1)){
				rear = -1;
			}
			//System.out.println("rear in insert : " + rear);
			queArray [++rear]=j;
			//System.out.println("rear after j insert in insert : " + rear);
		}
		
		public int remove()
		{
			int temp = queArray[front ++];
			//System.out.println("IN remove temp : " + temp);
			//System.out.println("IN remove front : " + front);
			if(front ==SIZE)
				front =0;
			return temp;
				
		}
		
		public boolean isEmpty()
		{
			return (rear+1 ==front || (front +SIZE-1) ==rear);
		}
		
	}


