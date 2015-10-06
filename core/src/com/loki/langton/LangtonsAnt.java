package com.loki.langton;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

public class LangtonsAnt extends ApplicationAdapter {
	
	SpriteBatch sb;
	Grid grid;
	long referenceTime = System.currentTimeMillis();
	
	@Override
	public void create () {
		sb = new SpriteBatch();
		grid = new Grid(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render () {
		
			Gdx.gl.glClearColor(1, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			//SpriteBatch
			sb.begin();
				grid.render(sb);
			sb.end();
			
			grid.update();
	}
}
