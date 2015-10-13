package com.loki.langton;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class Ant {

		Texture tex;
		Vector2 pos;
		Rectangle bounds;
		String facing;
		
		int rotation;
	
		public Ant(Texture tex, Vector2 pos, int rotation)
		{
			this.pos = pos;
			this.rotation = rotation;
			this.tex = tex;
			System.out.println(rotation);
			
		}
		
		public Rectangle getBounds()
		{
			bounds = new Rectangle(pos.x, pos.y, tex.getWidth(), tex.getHeight());
			return bounds;
		}
		
		public void render(SpriteBatch sb)
		{
//			sb.draw(tex, pos.x, pos.y, (pos.x + tex.getWidth()), (pos.y + tex.getHeight()), tex.getWidth(), tex.getHeight(), 0, 0, 90*rotation, 0, 0, 0, 0, false, false);
			sb.draw(tex, pos.x, pos.y);
			calcFacing();
		}
		
		public void update(Array<Square> squares)
		{
			Rectangle bounds = getBounds();
			for(Square s : squares)
			{
				if(bounds.overlaps(s.getBounds()))
				{
					if(s.getColor().equals("white"))
					{
						s.changeColor();
						move("right");
					}
					else if(s.getColor().equals("black"))
					{
						s.changeColor();
						move("left");
					}
				}
			}
		}
		
		public void move(String direction)
		{
			if(direction.equals("left"))
			{
				if(rotation == -3)
				{
					rotation = 0;
				}
				else
				{
					rotation -= 1;
				}
					
				calcMovement();
			}
			else if(direction.equals("right"))
			{
				if(rotation == 3)
				{
					rotation = 0;
				}
				else
				{
					rotation += 1;
				}
				
				calcMovement();
			}
		}
		
		public void calcFacing()
		{
			if(rotation == 0)
			{
				facing = "north";
			}
			else if(rotation == 1 || rotation == -3)
			{
				facing = "east";
			}
			else if(Math.abs(rotation) == 2)
			{
				facing = "south";
			}
			else if(rotation == 3 || rotation == -1)
			{
				facing = "west";
			}
		}
		
		public void calcMovement()
		{
			calcFacing();
			
//			if(pos.y > Gdx.graphics.getHeight())
//			{
//				pos.y = 0;
//			}
//			else if(pos.y < Gdx.graphics.getHeight())
//			{
//				pos.y = Gdx.graphics.getHeight() - tex.getHeight();
//			}
//			
//			if(pos.x > Gdx.graphics.getWidth())
//			{
//				pos.y = 0;
//			}
//			else if(pos.x < Gdx.graphics.getWidth())
//			{
//				pos.y = Gdx.graphics.getWidth() - tex.getWidth();
//			}
			
			if(facing.equals("north"))
			{
				pos.y += tex.getHeight();
			}
			else if(facing.equals("south"))
			{
				pos.y -= tex.getHeight();
			}
			else if(facing.equals("east"))
			{
				pos.x += tex.getWidth();
			}
			else if(facing.equals("west"))
			{
				pos.x -= tex.getWidth();
			}
		}
}
