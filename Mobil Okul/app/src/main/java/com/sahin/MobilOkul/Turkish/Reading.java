package com.sahin.MobilOkul.Turkish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.sahin.MobilOkul.R;
import com.sahin.MobilOkul.Inheritance.Storys;

import java.util.ArrayList;
import java.util.Locale;

public class Reading extends AppCompatActivity implements OnPageChangeListener {
    PDFView pdfView;
    private TextToSpeech speech;
    private int pageNumber,bookCode;
    Storys storys;
    ArrayList<String> storyList;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        Intent intent=getIntent();
        bookCode=intent.getIntExtra("bookCode",10);
        storys=new Storys();
        storyList=new ArrayList<>();
        setBook();

        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.getDefault());
                }
            }
        });
        speech.setSpeechRate(0.6f);
        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        name=sharedPreferences.getString("name","arkadaşım");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Sayfayı benim senin için okumamı istersen sol üstteki simgeye tıklaman yeterli"+name,TextToSpeech.QUEUE_FLUSH,null);
            }
        }, 300);


    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber=page;
    }

    public void readStory(View view){
        speech.speak(storyList.get(pageNumber),TextToSpeech.QUEUE_FLUSH,null);
    }

    private void getStory(String bookName){
        pdfView= (PDFView) findViewById(R.id.pdfbook);
        pdfView.fromAsset(bookName+".pdf")
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

    private void setBook(){
        if(bookCode==11){
            getStory("Birds");
            storys.setBirdStoryList(storyList);
        }else if(bookCode==12){
            getStory("Dreams");
            storys.setDreamStoryList(storyList);
        }else if(bookCode==13){
            getStory("Forest");
            storys.setForestStoryList(storyList);
        }else if(bookCode==14){
            getStory("Friend");
            storys.setFriendStoryList(storyList);
        }
    }

    @Override
    public void onBackPressed() {
        speech.stop();
        super.onBackPressed();
    }
}