package com.example.lesson8b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String STATE_SCORE_1, STATE_SCORE_2;
    private int _s1, _s2;
    private TextView _gs1, _gs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this._s1 = 0;
        this._s2 = 0;
        STATE_SCORE_1 = "Team 1";
        STATE_SCORE_2 = "Team 2";
        this._gs1 = findViewById(R.id.score1);
        this._gs2 = findViewById(R.id.score2);
        if (savedInstanceState != null) {
            this._s1 = savedInstanceState.getInt(STATE_SCORE_1);
            this._s2 = savedInstanceState.getInt(STATE_SCORE_2);
            //Set the score text views
            this._gs1.setText(String.valueOf(this._s1));
            this._gs2.setText(String.valueOf(this._s2));
        }
    }

    public void increaseScore(View view) {
        if (view.equals(findViewById(R.id.plus1))) {
            this._s1++;
        }
        if (view.equals(findViewById(R.id.plus2))) {
            this._s2++;
        }
        updateScores();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nm = AppCompatDelegate.getDefaultNightMode();
                if (nm == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt(STATE_SCORE_1, this._s1);
        outState.putInt(STATE_SCORE_2, this._s2);
        super.onSaveInstanceState(outState);
    }

    public void decreaseScore(View view) {
        if (view.equals(findViewById(R.id.minus1))) {
            this._s1--;
        }
        if (view.equals(findViewById(R.id.minus2))) {
            this._s2--;
        }
        updateScores();
    }

    public void updateScores() {
        this._gs1.setText(Integer.toString(this._s1));
        this._gs2.setText(Integer.toString(this._s2));
    }
}
