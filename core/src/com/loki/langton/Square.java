package com.loki.langton;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Square {

	//Boolean color: True = black, False = white
	Vector2 pos;
	int length;
	String color;
	Rectangle bounds;
	
	public Square(Vector2 pos, int length, String color)
	{
		this.pos = pos;
		this.length = length;
		this.color = color;
		bounds = new Rectangle(pos.x, pos.y, length, length);
	}
	
	public void changeColor()
	{
		if(color == "black")
		{
			color = "white";
		}
		else if(color == "white")
		{
			color = "black";
		}
	}
	
	public String getColor()
	{
		return color;
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}
}
