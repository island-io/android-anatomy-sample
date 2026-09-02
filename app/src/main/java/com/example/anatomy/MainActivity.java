package com.example.anatomy;

import android.app.Activity;
import android.os.Bundle;

/** Minimal, dependency-free activity that shows the @string/screen_title label. */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
