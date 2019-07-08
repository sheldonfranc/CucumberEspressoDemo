package com.emmasuzuki.cucumberespressodemo.test;


import com.emmasuzuki.cucumberespressodemo.BuildConfig;

public final class Config {

     private Config(){}
     public static final  String TAG = Config.class.getSimpleName();

     public static final String TAGS = BuildConfig.TEST_TAGS;
     public static final String FEATURE_DIR = BuildConfig.FEATURE_DIR;


}
