package com.example.suggestbarmej;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";

    private Random mRandom;
    private Button show;
    private View hello;
    private int toastcounter;
    private Button next;
    private Button back;
    int toastcounter2;
    int toastcounter3;





    int[] placespics = {
            R.drawable.run,
            R.drawable.eatfood,
            R.drawable.picnicesomethinglikethat,
            R.drawable.rollercoaster,
            R.drawable.friendship,
    };

    int index = -1;

    ImageView images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = findViewById(R.id.pictureofactivity);
        mRandom = new Random();
        Log.i(TAG,"Created");
        display(images);
        show = findViewById(R.id.sugg);
        toastcounter = 0;
        toastcounter2 = 0;



        next = findViewById(R.id.next);
        hello = findViewById(R.id.hello);
        back = findViewById(R.id.back);



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayrandom(hello);
                toastcounter++;

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(hello);
                toastcounter2++;
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display2(hello);
                toastcounter3++;
            }
        });



    }

   public void displayrandom(View view){
        if (index < 5 && toastcounter < 5){
            Log.d(TAG,"display =" + index);
            index = mRandom.nextInt(5);
            showimage();
        }else if(toastcounter >  4) {
            Toast.makeText(this,"no more activites ",Toast.LENGTH_SHORT).show();
        }


   }
    public void display(View view){
        if (index < 4){
            Log.d(TAG,"display =" + index);
            index++;
            showimage();
        }else {
            Toast.makeText(this,"no more activites ",Toast.LENGTH_SHORT).show();
        }


    }
    public void display2(View view){
        if (index > 0 && index < 5){
            Log.d(TAG,"display =" + index);
            index = index - 1;
            showimage();
        }else  {
            Toast.makeText(this,"no more activites ",Toast.LENGTH_SHORT).show();
        }


    }




    private void showimage(){

       Drawable visitdrawable = ContextCompat.getDrawable(this,placespics[index]);
       images.setImageDrawable(visitdrawable);

   }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Started");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Started");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Resumed");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Paused");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Stopped");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Destroyed");

    }
}