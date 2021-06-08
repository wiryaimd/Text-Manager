package com.wiryaimd.textmanager.di;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * membuat key untk map yang akan direturn
 * untuk viewmodelfactory
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MapKey
public @interface ViewModelKey {

    // type key nya ini
    Class<? extends ViewModel> value();

}
