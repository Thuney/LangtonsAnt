package com.loki.langton;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Grid {

	private int width;
	private int height;
	private Texture blackTex;
	private Texture whiteTex;
	private Array<Square> squares;
	
	Grid(int window_width, int window_height, Texture blackSquare, Texture whiteSquare)
	{
		this.width = window_width;
		this.height = window_height;
		this.blackTex = blackSquare;
		this.whiteTex = whiteSquare;
		this.squares = new Array<Square>();
		
		for(int i=0; i < height/whiteTex.getHeight(); i++)
		{
			for(int e=0; e < width/whiteTex.getWidth(); e++)
			{
				squares.add(new Square(new Vector2(e*whiteTex.getHeight(), i*whiteTex.getHeight()), whiteTex.getHeight(), "white"));
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
				sb.draw(blackTex, s.getPos().x, s.getPos().y);
			}
			else
			{
				sb.draw(whiteTex, s.getPos().x, s.getPos().y);
			}
		}
	}
	
	public void update()
	{
		
	}

	public int getSquareHeight() { return whiteTex.getHeight(); }

	public int getSquareWidth() { return whiteTex.getWidth(); }

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}
}
