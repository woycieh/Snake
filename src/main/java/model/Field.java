package main.java.model;

public class Field {
	private boolean empty;
	private int value;
	private int x;
	private int y;
	public Field(int x,int y)
	{
		this.x=x;
		this.y=y;
		this.value=0;
		this.empty=true;
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public boolean isEmpty()
	{
		if(this.empty)
			return true;
		else
			return false;
	}
	public void setValue(int value)
	{
		//0-default,1-snake,2-bonus,3-break/edge
		this.value=value;
		if (this.value!=0)
			this.empty=false;
		else
			this.empty=true;
	}
	public int getValue()
	{
		return this.value;
	}
}