package com.sahin.MobilOkul.Turkish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.sahin.MobilOkul.R;

import java.util.Locale;

public class BookSelection extends AppCompatActivity {
    private TextToSpeech speech;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_selection);
        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.getDefault());
                }
            }
        });
        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        name=sharedPreferences.getString("name","arkadaşım");
        speech.setSpeechRate(0.7f);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Buradan istediğin kitabı seçebilirsin"+name,TextToSpeech.QUEUE_FLUSH,null);
            }
        }, 300);

    }

    public void birds(View view){
        Intent intent=new Intent(BookSelection.this, Reading.class);
        speech.speak("Ahmetin Kuşları",TextToSpeech.QUEUE_FLUSH,null);
        intent.putExtra("bookCode",11);
        startActivity(intent);

    }

    public void dreams(View view){
        Intent intent=new Intent(BookSelection.this,Reading.class);
        speech.speak("Sevgi'nin Hayal Halkaları",TextToSpeech.QUEUE_FLUSH,null);
        intent.putExtra("bookCode",12);
        startActivity(intent);

    }

    public void forest(View view){
        Intent intent=new Intent(BookSelection.this,Reading.class);
        speech.speak("Daireler Ormanının Kralı",TextToSpeech.QUEUE_FLUSH,null);
        intent.putExtra("bookCode",13);
        startActivity(intent);

    }

    public void friend(View view){
        Intent intent=new Intent(BookSelection.this,Reading.class);
        speech.speak("Elma ile Gelen Arkadaşlık",TextToSpeech.QUEUE_FLUSH,null);
        intent.putExtra("bookCode",14);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        speech.stop();
        super.onBackPressed();
    }
}