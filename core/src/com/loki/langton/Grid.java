package com.loki.langton;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Grid {

	int width;
	int height;
	Texture blackTex;
	Texture whiteTex;
	Array<Square> squares;
	
	public Grid(int window_width, int window_height, Texture tex1, Texture tex2)
	{
		this.width = window_width;
		this.height = window_height;
		this.blackTex = tex1;
		this.whiteTex = tex2;
		this.squares = new Array<Square>();
		
		for(int i=0; i < height/blackTex.getHeight(); i++)
		{
			for(int e=0; e < width/blackTex.getWidth(); e++)
			{
				squares.add(new Square(new Vector2(e*blackTex.getHeight(), i*blackTex.getHeight()), blackTex.getHeight(), "white"));
			}
		}
	}
	
	public Array<Square> getSquares()
	{
		return squares;
	}
	
	public void render(SpriteBatch sb)
	{
		for(Square s: squares)
		{
			if(s.getColor().equals("black"))
			{
				sb.draw(blackTex, s.pos.x, s.pos.y);
			}
			else
			{
				sb.draw(whiteTex, s.pos.x, s.pos.y);
			}
		}
	}
	
	public void update()
	{
		
	}
}
