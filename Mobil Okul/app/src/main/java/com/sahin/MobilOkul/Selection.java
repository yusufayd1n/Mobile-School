package com.sahin.MobilOkul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.sahin.MobilOkul.English.EnglishChoice;
import com.sahin.MobilOkul.Math.Addition;
import com.sahin.MobilOkul.Math.Extraction;
import com.sahin.MobilOkul.Turkish.BookSelection;
import com.sahin.MobilOkul.Turkish.Letters;

import java.util.Locale;

public class Selection extends AppCompatActivity {
    private String name;
    private TextToSpeech speech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        name=sharedPreferences.getString("name","arkadaşım");
        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.getDefault());
                }
            }
        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                welcome();
            }
        }, 300);

    }
    private void welcome(){
        speech.setSpeechRate(0.9f);
        speech.speak("Resimlere tıklayarak ne yapmak istediğini seçebilirsin"+name,TextToSpeech.QUEUE_FLUSH,null);
    }

    public void toaddition(View view){
        Intent intent=new Intent(Selection.this, Addition.class);
        startActivity(intent);
        speech.speak("Toplama",TextToSpeech.QUEUE_FLUSH,null);
    }
    public void tomines(View view){
        Intent intent=new Intent(Selection.this, Extraction.class);
        startActivity(intent);
        speech.speak("Çıkarma",TextToSpeech.QUEUE_FLUSH,null);
    }
    public void toEnglish(View view){
        Intent intent=new Intent(Selection.this, EnglishChoice.class);
        startActivity(intent);
        speech.speak("İngilizce",TextToSpeech.QUEUE_FLUSH,null);
    }
    public void toReading(View view){
        Intent intent=new Intent(Selection.this, BookSelection.class);
        startActivity(intent);
        speech.speak("Okuma",TextToSpeech.QUEUE_FLUSH,null);
    }
    public void toMemoryGame(View view){
        Intent intent=new Intent(Selection.this, MemoryGame.class);
        startActivity(intent);
        speech.speak("Eşleştirme",TextToSpeech.QUEUE_FLUSH,null);
    }
    public void toAlphabetWheel(View view){
        Intent intent=new Intent(Selection.this, Letters.class);
        startActivity(intent);
        speech.speak("Harfler",TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onUserLeaveHint() {
        speech.stop();
        super.onUserLeaveHint();
    }
}
