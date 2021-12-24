package com.sahin.MobilOkul.English;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sahin.MobilOkul.R;

public class EnglishChoice extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_choice);

    }

    public void signtoAnimal(View view){
        Intent intent=new Intent(EnglishChoice.this, EnglishTeaching.class);
        intent.putExtra("classCode",1);
        startActivity(intent);
    }
    public void signtoNumbers(View view){
        Intent intent=new Intent(EnglishChoice.this, EnglishTeaching.class);
        intent.putExtra("classCode",2);
        startActivity(intent);
    }
    public void signtoFruits(View view){
        Intent intent=new Intent(EnglishChoice.this, EnglishTeaching.class);
        intent.putExtra("classCode",3);
        startActivity(intent);
    }
    public void signtoBodyParts(View view){
        Intent intent=new Intent(EnglishChoice.this, EnglishTeaching.class);
        intent.putExtra("classCode",4);
        startActivity(intent);
    }
    public void signtoColors(View view){
        Intent intent=new Intent(EnglishChoice.this, EnglishTeaching.class);
        intent.putExtra("classCode",5);
        startActivity(intent);
    }
    public void signtoThings(View view){
        Intent intent=new Intent(EnglishChoice.this, EnglishTeaching.class);
        intent.putExtra("classCode",6);
        startActivity(intent);
    }
}