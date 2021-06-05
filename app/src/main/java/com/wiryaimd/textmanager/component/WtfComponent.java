package com.wiryaimd.textmanager.component;

import com.wiryaimd.textmanager.MainActivity;
import com.wiryaimd.textmanager.component.module.ShieldModule;
import com.wiryaimd.textmanager.model.Player;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = ShieldModule.class)
public interface WtfComponent {

    void mainActivity(MainActivity mainActivity);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder ongkeh(@Named("role") String role);

        @BindsInstance
        Builder hahay(@Named("cord") String cord);

        WtfComponent build();

    }

}
