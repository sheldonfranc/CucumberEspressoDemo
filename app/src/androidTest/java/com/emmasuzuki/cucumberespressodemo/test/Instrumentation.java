/*
 * Copyright (C) 2015 emmasuzuki <emma11suzuki@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 * THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.emmasuzuki.cucumberespressodemo.test;

import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;
import android.util.Log;

import com.emmasuzuki.cucumberespressodemo.BuildConfig;


import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.android.CucumberInstrumentationCore;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@CucumberOptions(
        glue = "com.emmasuzuki.cucumberespressodemo.test"
)
public class Instrumentation extends MonitoringInstrumentation {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        System.out.println("onCreate");

        String tags = BuildConfig.TEST_TAGS;
        String features = BuildConfig.FEATURE_DIR;
        //arguments.putString("features", "{'features/com.emmasuzuki.cucumberespressodemo.test.login', 'features/com.emmasuzuki.cucumberespressodemo.test.signup'}");
        arguments.putString("features", features);
        if (!tags.isEmpty()) {
            arguments.putString("tags", tags.replaceAll(",", "--").replaceAll("\\s",""));
        }

        instrumentationCore.create(arguments);
        start();
    }

    @Override
    public void onStart() {
        super.onStart();

        waitForIdleSync();
        instrumentationCore.start();
    }

    @After
    public void clear(Scenario scenario) throws Throwable {
        Log.i("Clear", "after Method");
    }

    @Before
    public void setup(Scenario scenario) throws Throwable {
        Log.i("setup", "before Method");
        System.out.println("getName : "  + scenario.getName());
    }

}
