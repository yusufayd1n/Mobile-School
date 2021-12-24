package com.sahin.MobilOkul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.sahin.MobilOkul.English.EnglishChoice;
import com.sahin.MobilOkul.Math.Addition;
import com.sahin.MobilOkul.Math.Extraction;
import com.sahin.MobilOkul.Turkish.BookSelection;
import com.sahin.MobilOkul.Turkish.Letters;

import java.util.ArrayList;
import java.util.Locale;

public class Meet extends AppCompatActivity {
    private SpeechRecognizer speechRecognizer;

    ImageButton microphone;
    private TextToSpeech speech;
    private Intent recognizerIntent;
    public String name;
    String meating="Merhaba benim adım ela bana ismini söylersen tanışıp beraber oynayabiliriz" +
            " hazır olduğun zaman mikrofona tıklayıp iki saniye bekledikten sonra ismini söylersen tanışabiliriz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet);
        microphone=findViewById(R.id.mic);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},61);
        }

        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        name=sharedPreferences.getString("name","arkadaşım");

        speechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
        recognizerIntent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {
                Toast.makeText(Meet.this, "Seni Dinliyorum", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {
                microphone.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> bilgi=bundle.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                speech.setSpeechRate(0.8f);
                speech.speak("Tanıştığımıza memnun oldum"+bilgi.get(0)+"Haydi beraber öğrenmeye başlayalım",TextToSpeech.QUEUE_FLUSH,null);
                Intent intent=new Intent(Meet.this, Selection.class);
                SharedPreferences sharedPreferencesb=getSharedPreferences("name",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferencesb.edit();
                editor.putString("name",bilgi.get(0));
                editor.apply();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                }, 6000);
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });
        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.getDefault());
                }
            }
        });

        if(name.equals("arkadaşım")){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    speech.setSpeechRate(0.6f);
                    //speech.speak(meating,TextToSpeech.QUEUE_FLUSH,null);
                }
            }, 300);
        }else{
            Intent intent=new Intent(Meet.this, Selection.class);
            startActivity(intent);
            finish();
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==61){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "İzin Verildi!", Toast.LENGTH_SHORT).show();
                getname();
            }
            else{
                Toast.makeText(this, "İzin Verilmedi!", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onBackPressed() {
        speech.stop();
        super.onBackPressed();
    }

    public void record(View view){
        speechRecognizer.startListening(recognizerIntent);
        microphone.setVisibility(View.INVISIBLE);
    }

    private void getname(){
        speech.setSpeechRate(0.7f);
        speech.speak(meating,TextToSpeech.QUEUE_FLUSH,null);
    }

    public void gowithoutname(View view){
        Intent intent=new Intent(Meet.this,Selection.class);
        startActivity(intent);
    }
}