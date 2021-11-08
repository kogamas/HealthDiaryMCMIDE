package com.example.healthdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

        MyOpenHelper databaseHelper = new MyOpenHelper(this,"appDb",null,2);
        final SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        final Button weightButton = (Button) findViewById(R.id.button);
        final Button bloodPressureButton = (Button) findViewById(R.id.button2);
     //   String lastRecording;
    //    lastRecording = getIntent().getStringExtra("last");



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
            int weight = Integer.parseInt(message);
            Log.i("Main:", "weight: "+message);
            ContentValues writePair = new ContentValues();
            writePair.put("weight",weight);
            writableDatabase.insert("mytable","null",writePair);
            }
        else if (getIntent().hasExtra("sys")) {
            Intent intent = getIntent();
            String messageSys = intent.getStringExtra("sys");
            String messageDia = intent.getStringExtra("dia");
            int sys = Integer.parseInt(messageSys);
            int dia = Integer.parseInt(messageDia);
            Log.i("Main:", "BP: "+sys + "/" + dia);

            ContentValues writePair = new ContentValues();
            writePair.put("sys",sys);
            writePair.put("dia",dia);
            writableDatabase.insert("mytable","null",writePair);
            }

/*            TextView textView = findViewById(R.id.textViewLastRecording);

        Cursor cursor = writableDatabase.rawQuery("select AVG(weight) from mytable",null);
        if (cursor.moveToFirst()) {
            String message = cursor.getString(cursor.getColumnIndex("weight"));
            Log.i("Main: Database:", "AVG weight: "+message);
            textView.setText("Average: "+message);
        }*/



    }
}