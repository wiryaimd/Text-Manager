package com.wiryaimd.textmanager.model;

import android.util.Log;

import com.wiryaimd.textmanager.model.playeritem.Shield;
import com.wiryaimd.textmanager.model.playeritem.Sword;

import javax.inject.Inject;

public class Player {

    private static final String TAG = "Player";

    private String username;
    private int level;

    private Sword sword;

    @Inject
    Shield shield;

    @Inject
    public Player(Sword sword) {
        this.sword = sword;
    }

    @Inject
    public void stand(){
        Log.d(TAG, "stand: prepare for the warrrr huwaaaa...");
    }

    public void attack(){
        Log.d(TAG, "attack: Atacking.. boss");
        sword.use();
    }

    public void defend(){
        shield.defend();;
    }
}
