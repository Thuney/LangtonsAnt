package com.loki.langton.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.loki.langton.Grid;
import com.loki.langton.Screens.EditGrid;
import com.loki.langton.Screens.ScreenManager;

/**
 * Created by Loki on 8/2/2016.
 */
class GridEditButton extends MenuButton {

    private Grid grid;

    GridEditButton(int x, int y, Texture tex, Grid grid) {

        super(x, y, tex);
        this.grid = grid;
    }

    @Override
    public void update() {
        if(hoveringOver() && Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            ScreenManager.setScreen(new EditGrid(grid));
        }
    }
}