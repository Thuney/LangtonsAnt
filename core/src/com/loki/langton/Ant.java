package com.loki.langton;

import com.badlogic.gdx.Gdx;
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
		
		long referenceTime = System.currentTimeMillis();
		double millisecondsBetweenUpdates = 500;
		int rotation;
	
		public Ant(Texture tex, Vector2 pos, int rotation)
		{
			tex = new Texture(Gdx.files.internal("ant.png"));
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
			sb.draw(tex, pos.x, pos.y);
		}
		
		public void update(Array<Square> squares)
		{
			if(((System.currentTimeMillis() - referenceTime)) > millisecondsBetweenUpdates)
			{	
				for(Square s : squares)
				{
					if(getBounds().overlaps(s.getBounds()))
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
				referenceTime = System.currentTimeMillis();
			}
		}
		
		public void move(String direction)
		{
			if(direction.equals("left"))
			{
				rotation -= 1;
				
				calcMovement();
			}
			else if(direction.equals("right"))
			{
				rotation += 1;
				
				calcMovement();
			}
		}
		
		public void calcFacing()
		{
			if(rotation == 0 || rotation == 4 || rotation == -4)
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
