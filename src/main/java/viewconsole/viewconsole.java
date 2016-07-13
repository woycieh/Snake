package main.java.viewconsole;

public class viewconsole {
	private String defaultchar=" ";
	private String snakechar="o";
	private String bonuschar="$";
	private String breakchar="X";
	private int gameScreenHeight;
	private int gameScreenWidth;
	private int [][] values;
	public viewconsole(int x,int y) {
		// TODO Auto-generated constructor stub
		gameScreenHeight=y;
		gameScreenWidth=x;
		values = new int [gameScreenWidth][gameScreenHeight];
	}
	public void setValues(int [][] t)
	{
		for(int i=0;i<gameScreenWidth;i++)
			for(int j=0;j<gameScreenHeight;j++)
				values[i][j]=t[i][j];
	}
	public void draw()
	{
		for(int i=0;i<gameScreenWidth;i++)
		{
			for(int j=0;j<gameScreenHeight;j++)
			{
				switch
			}
		}
	}
}
