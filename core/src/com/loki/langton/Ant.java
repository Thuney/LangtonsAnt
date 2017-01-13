package com.loki.langton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Ant {

		private Texture tex;
		private Vector2 pos;
		private String facing;
		
		private int rotation;

		//The ant has a texture, a position vector, and an integer that represents which way the ant is facing
		public Ant(Texture tex, Vector2 pos, int rotation)
		{
			this.pos = pos;
			this.rotation = rotation;
			this.tex = tex;
//			System.out.println(rotation);
		}
		
		public Rectangle getBounds()
		{
			return new Rectangle(pos.x, pos.y, tex.getWidth(), tex.getHeight());
		}
		
		public void render(SpriteBatch sb)
		{
			//I'll be honest I really don't know what I was trying to do with the line directly below this one, but I'm leaving it in the case of a stroke of insight
			//LATER-Oh yeah, I was trying to get the ant's texture to rotate to match the direction it was facing. Didn't work; something to add to the fix list
//			sb.draw(tex, pos.x, pos.y, (pos.x + tex.getWidth()), (pos.y + tex.getHeight()), tex.getWidth(), tex.getHeight(), 0, 0, 90*rotation, 0, 0, 0, 0, false, false);
			sb.draw(tex, pos.x, pos.y);
		}
		
		public void update(Array<Square> squares)
		{
			//Get the rectangle representing the ant's grid position
			Rectangle bounds = getBounds();
			//Iterate through the squares array
			for(Square s : squares)
			{
				//If we found the square that the ant is on
				if(bounds.overlaps(s.getBounds()))
				{
					//Check color:
					//If the color is white
					if(s.getColor().equals("white"))
					{
						//Move right
						move("right");
					}
					//If the color is black
					else if(s.getColor().equals("black"))
					{
						//Move left
						move("left");
					}
					s.changeColor();
				}
			}
		}
		
		private void move(String direction)
		{
			//Update rotation based on movement direction
			rotation = (direction.equals("left")) ? rotation - 1 : (direction.equals("right")) ? rotation + 1 : rotation;
			calcMovement();
		}
		
		private void calcMovement()
		{
			//Modulus arithmetic to determine the direction we are facing, assuming that 0 is our 'north' direction
			//'Facing' string is mostly for debug, and doesn't control anything
			//TODO: Change these stupid comparisons and make them use ints instead of strings. What the heck was I thinking?
			if(rotation % 4 == 0)
			{
				facing = "north";
				pos.y += tex.getHeight();
			}
			else if(rotation % 4 == 1)
			{
				facing = "east";
				pos.x += tex.getWidth();
			}
			else if(rotation % 4 == 2)
			{
				facing = "south";
				pos.y -= tex.getHeight();
			}
			else if(rotation % 4 == 3)
			{
				facing = "west";
				pos.x -= tex.getWidth();
			}

			//Moves the ant to the other side of the grid if it goes off the edge
			if(pos.x < 0)
			{
				//Expressions avoid using hardcoded values so that we can scale the grid easily
				pos.x = Gdx.graphics.getWidth() - tex.getWidth();
			}
			else if(pos.x == Gdx.graphics.getWidth())
			{
				pos.x = 0;
			}

			if(pos.y < 0)
			{
				pos.y = Gdx.graphics.getHeight() - tex.getHeight();
			}
			else if(pos.y == Gdx.graphics.getHeight())
			{
				pos.y = 0;
			}
		}

		//Return the position vector
		public Vector2 getPos()
		{
			return pos;
		}

		//Update the position vector with new variables
		public void updatePos(int x, int y)
		{
			pos.x = x;
			pos.y = y;
		}
}