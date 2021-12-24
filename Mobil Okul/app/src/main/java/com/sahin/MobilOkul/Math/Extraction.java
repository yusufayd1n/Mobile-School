package com.sahin.MobilOkul.Math;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sahin.MobilOkul.R;
import com.sahin.MobilOkul.TutorialVideo;

import java.util.Locale;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Extraction extends AppCompatActivity {
    private String name,answer;
    TextView number1, number2, numberA, numberB, numberC, numberD;
    Random random;
    int randomnumber1,randomnumber2,result;
    private TextToSpeech speech;
    private GifImageView hungryrabbit,rabbit,sadrabbit,A,B,C,D;
    private boolean firststart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extraction);
        SharedPreferences sharedPreferencesforVideo=getSharedPreferences("firststartExtraction",MODE_PRIVATE);
        firststart=sharedPreferencesforVideo.getBoolean("firststartExtraction",true);
        number1 =findViewById(R.id.extractionNumber1);
        number2 =findViewById(R.id.extractionNumber2);
        hungryrabbit=findViewById(R.id.hungryRabbit);
        sadrabbit=findViewById(R.id.sadRabbit);
        rabbit=findViewById(R.id.Rabbit);
        numberA =findViewById(R.id.Anumber);numberB =findViewById(R.id.Bnumber);numberC =findViewById(R.id.Cnumber);numberD =findViewById(R.id.Dnumber);
        A=findViewById(R.id.A);B=findViewById(R.id.B);C=findViewById(R.id.C);D=findViewById(R.id.D);
        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        name=sharedPreferences.getString("name","arkadaşım");
        random=new Random();
        setNumbers();
        ConstraintLayout constraintLayout=findViewById(R.id.cikarmalayout);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        number1.setText(String.valueOf(randomnumber1));
        number2.setText(String.valueOf(randomnumber2));
        result=randomnumber1-randomnumber2;
        choice();

        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.getDefault());
                }
            }
        });

        if(firststart){
            showalert();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    speech.speak("Merhaba"+name+"senin için öğretici video açmamı ister misin?",TextToSpeech.QUEUE_FLUSH,null);
                }
            }, 300);
            SharedPreferences sharedPreferencesb=getSharedPreferences("firststartExtraction",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferencesb.edit();
            editor.putBoolean("firststartExtraction",false);
            editor.apply();
        }else{
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    rabbitspeak();
                }
            }, 300);
        }
    }

    public void getAnswer(View view){
        switch (view.getId()){
            case R.id.A:
                answer= numberA.getText().toString();
                if(result==Integer.parseInt(answer)){
                    trueanswerfunction();
                }else{
                    wronganswerfunction();
                }
                break;
            case R.id.B:
                answer= numberB.getText().toString();
                if(result==Integer.parseInt(answer)){
                    trueanswerfunction();
                }else{
                    wronganswerfunction();
                }
                break;
            case R.id.C:
                answer= numberC.getText().toString();
                if(result==Integer.parseInt(answer)){
                    trueanswerfunction();
                }else{
                    wronganswerfunction();
                }
                break;
            case R.id.D:
                answer= numberD.getText().toString();
                if(result==Integer.parseInt(answer)){
                    trueanswerfunction();
                }else{
                    wronganswerfunction();
                }
                break;
        }
    }

    private void choice() {
        int optionSelector=random.nextInt(4);
        if(optionSelector==0){
            numberA.setText((Integer.toString(result)));;
            numberB.setText((Integer.toString(result+1)));;
            numberC.setText((Integer.toString(result-1)));;
            numberD.setText((Integer.toString(result+3)));;
        }else if(optionSelector == 1){
            numberA.setText((Integer.toString(result+1)));
            numberB.setText((Integer.toString(result)));
            numberC.setText((Integer.toString(result-1)));;
            numberD.setText((Integer.toString(result+2)));;
        }else if(optionSelector==2){
            numberA.setText((Integer.toString(result+1)));;
            numberB.setText((Integer.toString(result-1)));;
            numberC.setText((Integer.toString(result)));;
            numberD.setText((Integer.toString(result+2)));;
        }else {
            numberA.setText((Integer.toString(result+1)));;
            numberB.setText((Integer.toString(result-1)));;
            numberC.setText((Integer.toString(result+2)));;
            numberD.setText((Integer.toString(result)));;
        }
    }



    private void rabbitspeak(){
        speech.setSpeechRate(0.8f);
        speech.speak("Merhaba"+name+"bu tavşan momo karnı çok acıkmış ve senden onun için çıkarma işlemlerini doğru yapıp lezettli havuçu bulmanı istiyor " +
                "haydi beraber ona yardım edelim",TextToSpeech.QUEUE_FLUSH,null);
    }

    private void showalert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(Extraction.this,R.style.AlertDialogTheme);
        View view= LayoutInflater.from(Extraction.this).inflate(
                R.layout.choose_dialog,(ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTittle)).setText(getResources().getString(R.string.tittle));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.text));
        ((Button) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.yes));
        ((Button) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.no));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_video);

        AlertDialog alertDialog=builder.create();
        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intenttovideo();
            }
        });

        view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rabbitspeak();
                alertDialog.dismiss();
            }
        });
        if(alertDialog.getWindow()!=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    public void redirecttoExtraction(View view){
        intenttovideo();
    }

    private void intenttovideo(){
        Intent intent=new Intent(Extraction.this, TutorialVideo.class);
        intent.putExtra("classCheck",2);
        startActivity(intent);
        finish();
    }

    private void trueanswerfunction(){
        A.setClickable(false);
        B.setClickable(false);
        C.setClickable(false);
        D.setClickable(false);
        hungryrabbit.setVisibility(View.INVISIBLE);
        rabbit.setVisibility(View.VISIBLE);
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                rabbit.setVisibility(View.INVISIBLE);
                hungryrabbit.setVisibility(View.VISIBLE);
            }
        }, 2700);
        speech.speak("Tebrikler"+name,TextToSpeech.QUEUE_FLUSH,null);
        random=new Random();
        setNumbers();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                number1.setText(String.valueOf(randomnumber1));
                number2.setText(String.valueOf(randomnumber2));
                result=randomnumber1-randomnumber2;
                choice();
                A.setClickable(true);
                B.setClickable(true);
                C.setClickable(true);
                D.setClickable(true);
            }
        }, 1500);
    }

    private void wronganswerfunction(){
        A.setClickable(false);
        B.setClickable(false);
        C.setClickable(false);
        D.setClickable(false);
        hungryrabbit.setVisibility(View.INVISIBLE);
        sadrabbit.setVisibility(View.VISIBLE);
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                sadrabbit.setVisibility(View.INVISIBLE);
                hungryrabbit.setVisibility(View.VISIBLE);
                A.setClickable(true);
                B.setClickable(true);
                C.setClickable(true);
                D.setClickable(true);
            }
        }, 2700);
        speech.speak("Tekrar denemelisin"+name,TextToSpeech.QUEUE_FLUSH,null);
    }

    private void setNumbers(){
        randomnumber1=random.nextInt(10);
        randomnumber2=random.nextInt(10);
        if(randomnumber2>randomnumber1){
            randomnumber1=randomnumber1+9;
        }
    }

    @Override
    protected void onUserLeaveHint() {
        speech.stop();
        super.onUserLeaveHint();
    }
}