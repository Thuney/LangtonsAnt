package com.loki.langton;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Square {

	private Vector2 pos;
	private int length;
	private String color;
	private Rectangle bounds;
	
	Square(Vector2 pos, int length, String color)
	{
		this.pos = pos;
		this.length = length;
		this.color = color;
		bounds = new Rectangle(pos.x, pos.y, length, length);
	}
	
	public void changeColor()
	{
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
