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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import org.w3c.dom.css.Rect;

public class Loot {

    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private Texture bagImage;

    private Rectangle bag;

    private int lootTier;
    private int dropRate;
    private Sound bagSound;

    public Loot(int tier, int rate, Texture img) {
        lootTier = tier;
        bagImage = img;
        dropRate = rate;
    }

//    batch = new SpriteBatch();
//    shapeRenderer = new ShapeRenderer();
//        shapeRenderer.setAutoShapeType(true);


}
