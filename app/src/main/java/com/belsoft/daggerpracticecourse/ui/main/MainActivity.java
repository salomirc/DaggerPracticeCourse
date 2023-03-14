package com.belsoft.daggerpracticecourse.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import com.belsoft.daggerpracticecourse.BaseActivity;
import com.belsoft.daggerpracticecourse.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
    }
}