package com.wiryaimd.textmanager.di;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.wiryaimd.textmanager.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    /**
     * anotasi Provides berguna untuk mendeklarasikan dependencies atau apapun(String, int, class2)
     * ketika dependensi tersebut di inject (@Inject)
     */

    /**
     * menggunakan static pada method yang di anotasi provides karena
     * dari dokumentasi nya merekomendasikan menggunakan static
     */
//    @Provides
//    static String writeString(){
//        return "thats string brohh wuhuu yea";
//    }


    /**
     * pada parameter application, class application
     * akan mengambil dari AppComponent yang ada di anotasi BindInstance, interface builder
     *
     * jadi semua yang ber parameter akan diambil nya ke class yang dianotasi BindInstance
     */
//    @Provides
//    static boolean isApp(Application application){
//        return application == null;
//    }

    /**
     * di method ini terdapat anotasi singleton
     * yang berarti method ini ber scope antara/dengan appcomponent
     *
     * jika appcomponent mati maka modul juga ikut mati karena scope singletodnya
     */

    @Singleton
    @Provides
    static RequestOptions requestOptions(){
        return RequestOptions.placeholderOf(R.color.black).error(R.color.purple_200);
    }

    /**
     * method requestOptions juga bisa dipanggil di dalam modul
     * karena sudah di deklarasikan lebih dulu
     */
    @Singleton
    @Provides
    static RequestManager requestManager(Application application){
        return Glide.with(application).setDefaultRequestOptions(requestOptions());
    }

    @Singleton
    @Provides
    static Drawable providesDrawables(Application application){
        return ContextCompat.getDrawable(application, R.drawable.heheboi);
    }

}
