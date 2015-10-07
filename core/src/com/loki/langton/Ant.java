package com.loki.langton;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Ant {

		Texture tex;
		Vector2 pos;
		Rectangle bounds;
		String facing;
		int rotation;
	
		public Ant(Texture tex, Vector2 pos, int rotation)
		{
			this.tex = tex;
			this.pos = pos;
			this.facing = facing;
			this.rotation = rotation;
			System.out.println(rotation);
			
		}
		
		public Rectangle getBounds()
		{
			bounds = new Rectangle(pos.x, pos.y, tex.getWidth(), tex.getHeight());
			return bounds;
		}
		
		public void move(String direction)
		{
			if(direction == "left")
			{
				rotation -= 90;
				
				calcMovement();
			}
			else if(direction == "right")
			{
				rotation += 90;
				
				calcMovement();
			}
		}
		
		public void calcFacing()
		{
			if(rotation == 0 || rotation == 360 || rotation == -360)
			{
				facing = "north";
			}
			else if(rotation == 90 || rotation == -270)
			{
				facing = "east";
			}
			else if(rotation == 180 || rotation == -180)
			{
				facing = "south";
			}
			else if(rotation == 270 || rotation == -90)
			{
				facing = "west";
			}
		}
		
		public void calcMovement()
		{
			calcFacing();
			
			if(facing == "north")
			{
				pos.y += tex.getHeight();
			}
			else if(facing == "south")
			{
				pos.y -= tex.getHeight();
			}
			else if(facing == "east")
			{
				pos.x += tex.getWidth();
			}
			else if(facing == "west")
			{
				pos.x -= tex.getWidth();
			}
		}
}
