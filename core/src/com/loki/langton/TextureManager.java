package com.loki.langton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	//Some textures are unused, and are just bigger or smaller versions of other textures

	Texture whiteSquare_8 = new Texture(Gdx.files.internal("whitesquare3.png"));
	Texture blackSquare_8 = new Texture(Gdx.files.internal("blacksquare3.png"));
	Texture blackSquare_16 = new Texture(Gdx.files.internal("blacksquare2.png"));
	Texture whiteSquare_16 = new Texture(Gdx.files.internal("whitesquare2.png"));
	Texture blackSquare_32 = new Texture(Gdx.files.internal("blacksquare.png"));
	Texture whiteSquare_32 = new Texture(Gdx.files.internal("whitesquare.png"));
	Texture ant_16 = new Texture(Gdx.files.internal("ant.png"));
	Texture ant_8 = new Texture(Gdx.files.internal("ant2.png"));

	public Texture menubackground = new Texture(Gdx.files.internal("mainmenu_backsplash.png"));
	public Texture menubutton = new Texture(Gdx.files.internal("menubuttonblank.png"));
	public Texture runAntButton = new Texture(Gdx.files.internal("activeantbutton.png"));
	public Texture editGridButton = new Texture(Gdx.files.internal("editgridbutton.png"));
	public Texture editAntButton = new Texture(Gdx.files.internal("editantbutton.png"));
	public Texture aboutButton = new Texture(Gdx.files.internal("aboutprogrambutton.png"));
	
}
