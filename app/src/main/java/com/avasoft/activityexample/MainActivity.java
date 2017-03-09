package com.avasoft.activityexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    String msg = "State";
    String getMsg="";
    Button newButton;
    EditText msgText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newButton = (Button) findViewById(R.id.button3);
        msgText = (EditText) findViewById(R.id.editText);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting the input message
                getMsg = msgText.getText().toString();
                Intent newIntent = new Intent(getApplicationContext(), NewActivity.class);
               //passing the message to next Activity
                newIntent.putExtra("Message", getMsg);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //start next Activity
                startActivity(newIntent);
            }
        });
        Log.d(msg, "The onCreate() event");
        System.out.println("The onCreate() event handled");
    }

    public void selectFrag(View view) {
        Fragment fr;

        if (view == findViewById(R.id.button1)) {
            fr = new Fragment1();

        } else {
            fr = new Fragment2();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}
