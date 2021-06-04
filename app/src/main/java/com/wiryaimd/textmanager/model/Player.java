package com.wiryaimd.textmanager.model;

import android.util.Log;

import com.wiryaimd.textmanager.model.playeritem.Shield;
import com.wiryaimd.textmanager.model.playeritem.Sword;
import com.wiryaimd.textmanager.model.playeritem.materials.Material;

import javax.inject.Inject;

public class Player {

    private static final String TAG = "Player";

    private String username;
    private int level;

    private Sword sword;
    private Material material;

    @Inject
    Shield shield;

    @Inject
    public Player(Sword sword, Material material) {
        this.sword = sword;
        this.material = material;
    }

    @Inject
    public void stand(){
        Log.d(TAG, "stand: prepare for the warrrr huwaaaa...");
        material.toolToTake();
    }

    public void attack(){
        Log.d(TAG, "attack: Atacking.. boss");
        sword.use();
    }

    public void defend(){
        shield.defend();;
    }
}
