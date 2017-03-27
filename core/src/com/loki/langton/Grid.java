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
	private Square[][] squares;
	
	Grid(int window_width, int window_height, Texture blackSquare, Texture whiteSquare)
	{
		this.width = window_width;
		this.height = window_height;
		this.blackTex = blackSquare;
		this.whiteTex = whiteSquare;
		this.squares = new Square[height/blackTex.getHeight()][width/blackTex.getWidth()];

		//Create our grid out of square objects, spaced our texture width apart for the height and width of the screen
		for(int i=0; i < height/whiteTex.getHeight(); i++)
		{
			for(int e=0; e < width/whiteTex.getWidth(); e++)
			{
				//squares object Array keeps our grid ordered
				squares[i][e] = (new Square(new Vector2(e*whiteTex.getHeight(), i*whiteTex.getHeight()), whiteTex.getHeight(), "white"));
			}
		}
	}

	//Return our object array of squares
	public Square[][] getSquares()
	{
		return squares;
	}
	
	public void render(SpriteBatch sb) {
		//For every square in the grid
		for (Square[] square : squares)
		{
			for (Square s : square) {
				//If the square is black
				if (s.getColor().equals("black")) {
					//Draw the black texture at the position vector
					sb.draw(blackTex, s.getPos().x, s.getPos().y);
				}
				//If the square is white
				else {
					//Draw the white texture at the positon vector
					sb.draw(whiteTex, s.getPos().x, s.getPos().y);
				}
			}
		}
	}
	
	public void update()
	{
		
	}

	//Self explanatory methods

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
