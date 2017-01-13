package com.loki.langton;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Square {

	private Vector2 pos;
	private String color;
	private Rectangle bounds;

	//Each square has a position vector, a length, and a color
	Square(Vector2 pos, int length, String color)
	{
		this.pos = pos;
		this.color = color;
		bounds = new Rectangle(pos.x, pos.y, length, length);
	}


	public void changeColor()
	{

		//TODO: Change these stupid comparisons and make them use ints instead of strings. So inefficient.
		if(color.equals("black"))
		{
			color = "white";
		}
		else if(color.equals("white"))
		{
			color = "black";
		}
	}
	
	String getColor()
	{
		return color;
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}

	public Vector2 getPos() { return pos; }
}
