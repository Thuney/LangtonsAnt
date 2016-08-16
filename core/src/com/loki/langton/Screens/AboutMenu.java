package com.loki.langton.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Loki on 8/11/2016.
 */
public class AboutMenu extends Screen {

    private BitmapFont text;
    private java.lang.String aboutProgram = "Langton's ant is a two-dimensional Turing machine with a \n" +
                                            "very simple set of rules but complex emergent behavior. \n" +
                                            "It was invented by Chris Langton in 1986 and runs on a \n" +
                                            "square lattice of black and white cells. The rules to \n" +
                                            "Langton's Ant are simple: If the ant finds itself on a \n" +
                                            "white tile, turn right 90 degrees, change the color of \n" +
                                            "the square, and go forward one tile. If the ant finds \n" +
                                            "itself on a black tile, turn left 90 degrees, change \n" +
                                            "the color of the tile, and go forward one tile. \n\n\n" +
                                            "Controls: \n" +
                                            "Press ESCAPE to go back to the main menu. \n" +
                                            "Use the LEFT and RIGHT arrow keys to change speed of the ant.";

    @Override
    public void create() {
        text = new BitmapFont();
        resize(450,350);
    }

    @Override
    public void update() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            ScreenManager.setScreen(ScreenManager.getLastScreen());
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
            Gdx.gl.glClearColor(0.6f, 0, 0, 1);
            Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
            text.drawMultiLine(sb, aboutProgram, 20,300);
        sb.end();
        update();
    }

    @Override
    public void resize(int width, int height) { Gdx.graphics.setDisplayMode(width, height, false); }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
