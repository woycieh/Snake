package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private int gameScreenHeight;
	private int gameScreenWidth;
	//1 - up, -1 - down, 2 - right, -2 - left
	
	private int snakeDirection;
	private List <Field> snake;
	private boolean snakeIncrease;
	Field [][] fields;
	
	public Model(int x,int y)
	{
		gameScreenHeight=y;
		gameScreenWidth=x;		
		fields = new Field [gameScreenWidth][gameScreenHeight];
		setEdge();
		snake= new ArrayList<Field>();
		snakeDirection=2;
		snake.add(fields[1][1]);
		snakeIncrease=false;
	}
	private void setEdge()
	{
		for (int i=0;i<gameScreenWidth;i++)
		{
			fields[i][0].setValue(3);
			fields[i][gameScreenHeight-1].setValue(3);
		}
		for (int i=1;i<gameScreenHeight-1;i++)
		{
			fields[0][i].setValue(3);
			fields[gameScreenWidth-1][i].setValue(3);
		}
	}
	public boolean moveSnake(int direction)
	{
		//1 - up, -1 - down, 2 - right, -2 - left	
		
		//current head
		Field head=snake.get(snake.size()-1);
		int x=head.getX();
		int y=head.getY();
		if(direction==snakeDirection||direction==-snakeDirection)		
		{
			//moving the same way
			switch(snakeDirection)
			{
			case 1:
				snake.add(fields[x][y+1]);
				break;
			case -1:
				snake.add(fields[x][y-1]);
				break;
			case 2:
				snake.add(fields[x+1][y]);
				break;
			case -2:
				snake.add(fields[x-1][y]);
				break;
			}
		}
		else			
		{
			//changing direction
			switch(direction)
			{
			case 1:
				snake.add(fields[x][y+1]);
				break;
			case -1:
				snake.add(fields[x][y-1]);
				break;
			case 2:
				snake.add(fields[x+1][y]);
				break;
			case -2:
				snake.add(fields[x-1][y]);
				break;
			}
			snakeDirection=direction;
		}
		
		//remove tail if snake not increase
		if(snakeIncrease)		
			snakeIncrease=false;		
		else
		{
			snake.get(0).setValue(0);
			snake.remove(0);
		}
		
		
		if(snake.get(snake.size()-1).getValue()==3||snake.get(snake.size()-1).getValue()==1)
		{
			//end game if snake eat himself or break
			return false;
		}
		else
		{
			if(snake.get(snake.size()-1).getValue()==2)
			{
				//bonus
				snakeIncrease=true;
				return true;
			}
			else
			{
				//normal move
				return true;
			}
		}
	}	
	public int [][]getValuesTable()
	{
		int [][] tab =new int [gameScreenWidth][gameScreenHeight];
		for (int i=0;i<gameScreenWidth;i++)
			for(int j=0;j<gameScreenHeight;j++)
				tab[i][j]=fields[i][j].getValue();
		return tab;
	}
}
