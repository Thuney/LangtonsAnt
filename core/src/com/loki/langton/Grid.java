package com.loki.langton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Grid {

	int width;
	int height;
	Array<Square> squares;
	Ant ant;
	long referenceTime = System.currentTimeMillis();
	
	Texture anttex = new Texture(Gdx.files.internal("ant.png"));
	Texture tex = new Texture(Gdx.files.internal("blacksquare2.png"));
	Texture tex2 = new Texture(Gdx.files.internal("whitesquare2.png"));
	
	double millisecondsBetweenUpdates = 500;
	
	public Grid(int window_width, int window_height)
	{
		this.width = window_width;
		this.height = window_height;
		this.squares = new Array<Square>();
		
		for(int i=0; i < height/tex.getHeight(); i++)
		{
			for(int e=0; e < width/tex.getWidth(); e++)
			{
				squares.add(new Square(new Vector2(e*tex.getHeight(), i*tex.getHeight()), tex.getHeight(), "white"));
			}
		}
		
		ant = new Ant(anttex, new Vector2(((width/2)-((width/tex.getWidth())%2)*tex.getWidth()),((height/2)-(((height/tex.getWidth())%2)*tex.getWidth()))), 0);
	}
	
	public void render(SpriteBatch sb)
	{
		for(Square s: squares)
		{
			if(s.getColor() == "black")
			{
				sb.draw(tex, s.pos.x, s.pos.y);
			}
			else
			{
				sb.draw(tex2, s.pos.x, s.pos.y);
			}
			ant.calcFacing();
		}
		
		sb.draw(ant.tex, ant.pos.x, ant.pos.y);
	}
	
	public void update()
	{
		if(((System.currentTimeMillis() - referenceTime)) > millisecondsBetweenUpdates)
		{		
			for(Square s: squares)
			{
				if(ant.getBounds().overlaps(s.getBounds()))
				{
					if(s.getColor() == "white")
					{
						s.changeColor();
						ant.move("right");
					}
					else if(s.getColor() == "black")
					{
						s.changeColor();
						ant.move("left");
					}
				}
				System.out.println("Facing: " + ant.facing + " Rotation: " + ant.rotation + " Color: " + s.getColor());
			}
			
			
			referenceTime = System.currentTimeMillis();
		}
	}
}
