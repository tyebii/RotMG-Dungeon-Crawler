package com.test.game;

import com.badlogic.gdx.graphics.Texture;

public class Character {

    private int characterType;

    private Texture characterImage;

    public Character(int type) {
        characterType = type;
    }

    String[] characterList = new String[18];
    String characterName = "";

    //wizard/assassin/huntress/sorc/summoner are default
    //ninja/warrior/rogue/trickster/archer speed up
    //priest/pally/necro/bard self-heal
    //knight/samurai have more hp
    //kensei dashes
    //mystic freezes time



    public void characterAbility(int characterType){

    }

}
