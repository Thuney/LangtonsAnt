package com.loki.langton;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class LangtonsAnt extends ApplicationAdapter {
	
	SpriteBatch sb;
	
	TextureManager texMan;
	Grid grid;
	Ant ant;
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		texMan = new TextureManager();
		grid = new Grid(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), texMan.blackSquare_16, texMan.whiteSquare_16);
		ant = new Ant(texMan.ant, new Vector2((Gdx.graphics.getWidth()/2) - texMan.ant.getWidth(),(Gdx.graphics.getHeight()/2) - texMan.ant.getHeight()), 0);
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//SpriteBatch
		sb.begin();
			grid.render(sb);
			ant.render(sb);
		sb.end();
		
		ant.update(grid.getSquares());
	}
}
