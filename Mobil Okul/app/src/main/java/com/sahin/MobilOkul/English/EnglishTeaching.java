package com.sahin.MobilOkul.English;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sahin.MobilOkul.R;
import com.sahin.MobilOkul.Inheritance.AddList;

import java.util.ArrayList;
import java.util.Locale;

public class EnglishTeaching extends AppCompatActivity {
    private int classCode;
    private ArrayList<Integer> viewList;
    private ArrayList<String> nameList;
    private ArrayList<Integer>  animalVoiceList;
    ImageView englishView;
    TextView englishText;
    private int counter;
    private MediaPlayer animalsong;
    private TextToSpeech speech;
    AddList addList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_teaching);
        Intent intent=getIntent();
        classCode=intent.getIntExtra("classCode",0);
        englishView=findViewById(R.id.englishView);
        englishText=findViewById(R.id.englishText);
        addList =new AddList();
        viewList=new ArrayList<>();nameList=new ArrayList<>();animalVoiceList=new ArrayList<>();
        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.ENGLISH);
                }
            }
        });
        speech.setSpeechRate(0.5f);
        counter=0;
        if(classCode==1){
            animalClass();
        }else if(classCode==2){
            numberClass();
        }else if(classCode==3){
            fruitClass();
        }else if(classCode==4){
            bodyPartClass();
        }else if(classCode==5){
            colorClass();
        }else if(classCode==6){
            thingClass();
        }
    }


    public void forward(View view){
        counter++;
        if(counter==10){
            counter=0;
        }
        if(classCode==1) {
            animalsong.reset();
            animalsong = MediaPlayer.create(EnglishTeaching.this, animalVoiceList.get(counter));
            animalsong.start();
            speech.stop();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    speech.speak(nameList.get(counter), TextToSpeech.QUEUE_FLUSH, null);
                }
            }, 2000);
        }else{
            speech.stop();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    speech.speak(nameList.get(counter), TextToSpeech.QUEUE_FLUSH, null);
                }
            }, 100);
        }
        englishView.setImageResource(viewList.get(counter));
        englishText.setText(nameList.get(counter));
    }

    public void back(View view){
        if(counter==0){
            counter=10;
        }
        counter--;
        if(classCode==1) {
            animalsong.reset();
            animalsong = MediaPlayer.create(EnglishTeaching.this, animalVoiceList.get(counter));
            animalsong.start();
            speech.stop();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    speech.speak(nameList.get(counter), TextToSpeech.QUEUE_FLUSH, null);
                }
            }, 2000);
        }else{
            speech.stop();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    speech.speak(nameList.get(counter), TextToSpeech.QUEUE_FLUSH, null);
                }
            }, 200);
        }
        englishView.setImageResource(viewList.get(counter));
        englishText.setText(nameList.get(counter));
    }


    private void animalClass(){
        englishView.setImageResource(R.drawable.cat);
        englishText.setText("Cat");
        addList.addtoVoiceList(animalVoiceList,R.raw.catvoice,R.raw.dogvoice,R.raw.birdvoice, R.raw.lionvoice,
                R.raw.cowvoice,R.raw.beevoice,R.raw.chickenvoice,R.raw.elephantvoice,R.raw.giraffevoice, R.raw.molevoice);
        animalsong=MediaPlayer.create(EnglishTeaching.this,animalVoiceList.get(0));
        animalsong.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Cat",TextToSpeech.QUEUE_FLUSH,null);
            }
        },2000);
        addList.addtoNameList(nameList,"Cat","Dog","Bird","Lion","Cow","Bee",
                "Chicken","Elephant","Giraffe","Mole");
        addList.addtoViewList(viewList,R.drawable.cat,R.drawable.dog,
                R.drawable.bird,R.drawable.lion,R.drawable.cow,R.drawable.bee,R.drawable.chicken,R.drawable.elephant,
                R.drawable.giraffe,R.drawable.mole);
    }

    private void numberClass(){
        englishView.setImageResource(R.drawable.zero);
        englishText.setText("Zero");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Zero",TextToSpeech.QUEUE_FLUSH,null);
            }
        },100);
        counter=0;
        addList.addtoNameList(nameList,"Zero","One","Two","Three","Four","Five",
                "Six","Seven","Eight","Nine");
        addList.addtoViewList(viewList,R.drawable.zero,R.drawable.one,R.drawable.two,R.drawable.three
                ,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine);
    }

    private void fruitClass(){
        englishView.setImageResource(R.drawable.apple);
        englishText.setText("Apple");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Apple",TextToSpeech.QUEUE_FLUSH,null);
            }
        },100);
        addList.addtoNameList(nameList,"Apple","Cucumber","Watermelon","Leek","Grape","Orange",
                "Pumpkin","Pepper","Potato","Onion");
        addList.addtoViewList(viewList,R.drawable.apple,R.drawable.cucumber,R.drawable.watermelon,R.drawable.leek
                ,R.drawable.grape,R.drawable.orange,R.drawable.pumpkin,R.drawable.pepper,R.drawable.potato,R.drawable.onion);
    }

    private void bodyPartClass(){
        englishView.setImageResource(R.drawable.hair);
        englishText.setText("Hair");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Hair",TextToSpeech.QUEUE_FLUSH,null);
            }
        },100);
        addList.addtoNameList(nameList,"Hair","Eye","Nose","Lips","Teeth","Ear",
                "Leg","Arm","Hand","Head");
        addList.addtoViewList(viewList,R.drawable.hair,R.drawable.eye,R.drawable.nose,R.drawable.lips
                ,R.drawable.teeth,R.drawable.ear,R.drawable.leg,R.drawable.arm,R.drawable.hand,R.drawable.head);
    }

    private void colorClass(){
        englishView.setImageResource(R.drawable.red);
        englishText.setText("Red");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Red",TextToSpeech.QUEUE_FLUSH,null);
            }
        },100);
        addList.addtoNameList(nameList,"Red","Yellow","Blue","White","Black","Orange",
                "Green","Pink","Brown","Purple");
        addList.addtoViewList(viewList,R.drawable.red,R.drawable.yellow,R.drawable.blue,R.drawable.white
                ,R.drawable.black,R.drawable.orangecolor,R.drawable.green,R.drawable.pink,R.drawable.brown,R.drawable.purple);
    }

    private void thingClass() {
        englishView.setImageResource(R.drawable.pencil);
        englishText.setText("Pencil");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Pencil",TextToSpeech.QUEUE_FLUSH,null);
            }
        },100);
        addList.addtoNameList(nameList,"Pencil","Glass","Table","Book","Phone","Car",
                "Bed","Clock","Chair","Door");
        addList.addtoViewList(viewList,R.drawable.pencil,R.drawable.glass,R.drawable.table,R.drawable.book
                ,R.drawable.phone,R.drawable.car,R.drawable.bed,R.drawable.clock,R.drawable.chair,R.drawable.door);
    }

    @Override
    protected void onUserLeaveHint() {
        speech.stop();
        super.onUserLeaveHint();
    }
}