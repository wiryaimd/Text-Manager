package com.wiryaimd.textmanager.component;

import com.wiryaimd.textmanager.MainActivity;
import com.wiryaimd.textmanager.component.module.ShieldModule;
import com.wiryaimd.textmanager.model.Player;

import dagger.Component;

@Component(modules = ShieldModule.class)
public interface WtfComponent {

    void mainActivity(MainActivity mainActivity);

}
