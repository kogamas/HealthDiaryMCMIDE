package com.example.healthdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOpenHelper databaseDAO = new MyOpenHelper(this,"appDb",null,1);
        final SQLiteDatabase writableDatabase = databaseDAO.getWritableDatabase();
        final Button weightButton = (Button) findViewById(R.id.button);
        final Button bloodPressureButton = (Button) findViewById(R.id.button2);

        TextView lastRecording = (TextView) findViewById(R.id.textViewLastRecording);
        //lastRecording.setText(getIntent().getStringExtra("last"));



        //onclick for weight
        weightButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent startWeight = new Intent(MainActivity.this, weightRecorder.class);
                startActivity(startWeight);
            }
        });

        //onclick for BP
        bloodPressureButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent startBP = new Intent(MainActivity.this, bloodPressureRecorder.class);
                startActivity(startBP);
                //do weight
            }
        });
        //if an intent started this activity display the extra "last"
        if(getIntent().hasExtra("weight")) {
            Intent intent = getIntent();
            String message = intent.getStringExtra("weight");
            int weight = Integer.getInteger(message);
            Log.i("Main:", "weight: "+weight);
            }
        else if (getIntent().hasExtra("sys")) {
            Intent intent = getIntent();
            int sys = Integer.getInteger(intent.getStringExtra("sys"));
            int dia = Integer.getInteger(intent.getStringExtra("dia"));
            Log.i("Main:", "BP: "+sys + "/" + dia);
            }

            // TextView textView = findViewById(R.id.textViewLastRecording);
           // textView.setText(message);


    }
}