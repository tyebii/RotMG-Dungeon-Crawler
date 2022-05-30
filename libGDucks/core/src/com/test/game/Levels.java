package com.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Color;
import javafx.scene.layout.Background;

import java.awt.*;

public class Levels {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    private Image[] backgrounds;
    private Music[] bgMusics;


    private int level;
    private int amtDrops = 0;

    //private texture here;




    public Image getBackground(int level){
        return backgrounds[level];
    }

    public Music getBackgroundMusic(int level) {
        return bgMusics[level];
    }


//    public Level(int levelNumber, String levelName, int levelBackground){

//    }
}
