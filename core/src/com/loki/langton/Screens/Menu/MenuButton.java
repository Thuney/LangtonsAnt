package com.loki.langton.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Loki on 8/2/2016.
 */

//Class represents the prototype for a button on the main menu
//I mostly set the menu buttons up this way so that I could add more and scale them
//more easily
abstract class MenuButton {

    private int x;
    private int y;

    private Texture tex;

    private int width;
    private int height;

    MenuButton(int x, int y, Texture tex)
    {
        this.x = x;
        this.y = y;
        this.tex = tex;
        width = tex.getWidth();
        height = tex.getHeight();
    }

    public abstract void update();

    void render(SpriteBatch sb)
    {
        sb.draw(tex, x, y);
        update();
    }

    private Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }

    boolean hoveringOver()
    {
        return getBounds().contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }
}
