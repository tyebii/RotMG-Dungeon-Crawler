package com.test.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.Iterator;

public class MyGdxGame extends ApplicationAdapter {

	private Texture bagImage;
	//make customizable characters, maybe use SpriteBatch?
	private Texture characterImage;
	private Sound bagSound;
	private Music bgMusic;


	private OrthographicCamera camera;
	private SpriteBatch batch;

	private Rectangle character;

	private Array<Rectangle> drops;
	private long lastDropTime;

	BitmapFont font;

	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0,800-64);
		raindrop.y = 480;
		raindrop.width = 64; //64
		raindrop.height = 64; //64
		drops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}

	@Override
	public void create () {
		// load images for drops/catcher
		bagImage = new Texture(Gdx.files.internal("whitebag.png"));
		characterImage = new Texture(Gdx.files.internal("knight.png"));

		// load sounds
		bagSound = Gdx.audio.newSound(Gdx.files.internal("loot_appears.mp3"));
		bgMusic = Gdx.audio.newMusic(Gdx.files.internal("maintheme.mp3")); //cool.mp3

		//start music
		bgMusic.setLooping(true);
		bgMusic.play();

		//create camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 400);

		//create drops
		drops = new Array<Rectangle>();
		spawnRaindrop();

		//make text
		font = new BitmapFont();

		batch = new SpriteBatch();

		character = new Rectangle();
		character.x = 800 / 2 - 64 / 2;
		character.y = 20;
		character.width = 64;
		character.height = 	64;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		batch.begin();
		batch.draw(characterImage, character.x, character.y);
		for (Rectangle raindrop: drops) {
			batch.draw(bagImage, raindrop.x, raindrop.y);
		}
		font.draw(batch, String.valueOf(System.currentTimeMillis()), 40, 400);
		batch.end();

		//moves character to cursor
		if(Gdx.input.isTouched()){
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			character.x = touchPos.x - 64 / 2;
		}
		//moves the character left and right with arrow keys
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) character.x -= 250 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) character.x += 250 * Gdx.graphics.getDeltaTime();

		//speeds character up if spacebar/shift key held down
		//left
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && Gdx.input.isKeyPressed(Input.Keys.LEFT)) character.x -= 350 * Gdx.graphics.getDeltaTime();
		//right
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && Gdx.input.isKeyPressed(Input.Keys.RIGHT)) character.x += 350 * Gdx.graphics.getDeltaTime();

        //centers the character within the screen
		if(character.x < 0) {character.x = 0;}
		if(character.x > 800-64) {character.x = 800-64;}

		//spawns drops
		if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();

		//raindrop update loop
		for(Iterator<Rectangle> iter = drops.iterator(); iter.hasNext(); ) {
			Rectangle itemDrop = iter.next();
			itemDrop.y -= 300 * Gdx.graphics.getDeltaTime();
			if(itemDrop.y + 64 < 0) {
				iter.remove();
			}
			if (itemDrop.overlaps(character)) {
				bagSound.play();
				iter.remove();
			}
		}


	}
	
	@Override
	public void dispose () {
		bagImage.dispose();
		characterImage.dispose();
		bgMusic.dispose();
		bagSound.dispose();
		batch.dispose();
	}
}
