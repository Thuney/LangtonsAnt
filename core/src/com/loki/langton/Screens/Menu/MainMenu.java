package com.loki.langton.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.loki.langton.Ant;
import com.loki.langton.Grid;
import com.loki.langton.Screens.Screen;
import com.loki.langton.TextureManager;

/**
 * Created by Loki on 8/1/2016.
 */
public class MainMenu extends Screen {

    private Grid grid;
    private Ant ant;
    private TextureManager tm;

    private Array<MenuButton> buttons;

    private int numButtons = 4;

    private int spaceBetweenButtons;
    private int x_margin;
    private int y_margin = 20;

    public MainMenu(Grid grid, Ant ant, TextureManager tm)
    {
        this.grid = grid;
        this.ant = ant;
        this.tm = tm;
    }

    @Override
    public void create() {

        int menuWidth_px = tm.menubackground.getWidth();
        int menuHeight_px = tm.menubackground.getHeight();

        Gdx.graphics.setDisplayMode(menuWidth_px, menuHeight_px, false);

        spaceBetweenButtons = (275/numButtons);
        x_margin = (menuWidth_px - tm.menubutton.getWidth()) / 2;

        buttons = new Array<MenuButton>();
        buttons.add(new ActiveAntButton(x_margin, 3*spaceBetweenButtons + y_margin, tm.runAntButton, grid, ant));
        buttons.add(new GridEditButton(x_margin, 2*spaceBetweenButtons + y_margin, tm.editGridButton, grid));
        buttons.add(new EditAntButton(x_margin, 1*spaceBetweenButtons + y_margin, tm.editAntButton, grid, ant));
        buttons.add(new AboutButton(x_margin, 0*spaceBetweenButtons + y_margin, tm.aboutButton));
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
            sb.draw(tm.menubackground, 0, 0);
            for(MenuButton m : buttons)
            {
                m.render(sb);
            }
        sb.end();
    }

    @Override
    public void resize(int width, int height) {

    }

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
