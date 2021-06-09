package com.wiryaimd.textmanager.di.auth;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * sebagai scope untuk subcomponent
 *
 * kalo main component scope nya si @singleton
 *
 * sub scope tidak berfungsi untuk singleton pattern
 * karena scope nya berada di activity,
 * ex: screen di rotate (maka subcomponent yang ada pada activity di destroy dan di muat ulang)
 * oleh karena itu hanya @Singleton sebagai parent yang bisa singleton pattern
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthScope {
}
