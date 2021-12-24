package com.sahin.MobilOkul.Math;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sahin.MobilOkul.R;
import com.sahin.MobilOkul.TutorialVideo;
import com.sahin.MobilOkul.Inheritance.AddList;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Addition extends AppCompatActivity {
    private String name;
    private ImageView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24;
    Random random;
    int randomnumber1,randomnumber2,result;
    private TextToSpeech speech;
    private EditText userResult;
    ArrayList<ImageView> strawberryList1;
    ArrayList<ImageView> strawberryList2;
    private boolean firststart;
    AddList addList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        SharedPreferences sharedPreferencesforVideo=getSharedPreferences("firststartaddition",MODE_PRIVATE);
        firststart=sharedPreferencesforVideo.getBoolean("firststartaddition",true);

        c1=findViewById(R.id.strawberry1);c10=findViewById(R.id.strawberry10);
        c2=findViewById(R.id.strawberry2);c11=findViewById(R.id.strawberry11);
        c3=findViewById(R.id.strawberry3);c12=findViewById(R.id.strawberry12);
        c4=findViewById(R.id.strawberry4);c13=findViewById(R.id.strawberry13);
        c5=findViewById(R.id.strawberry5);c14=findViewById(R.id.strawberry14);
        c6=findViewById(R.id.strawberry6);c15=findViewById(R.id.strawberry15);
        c7=findViewById(R.id.strawberry7);c16=findViewById(R.id.strawberry16);
        c8=findViewById(R.id.strawberry8);c17=findViewById(R.id.strawberry17);
        c9=findViewById(R.id.strawberry9);c18=findViewById(R.id.strawberry18);
        c19=findViewById(R.id.strawberry19);c20=findViewById(R.id.strawberry20);
        c21=findViewById(R.id.strawberry21);c22=findViewById(R.id.strawberry22);
        c23=findViewById(R.id.strawberry23);c24=findViewById(R.id.strawberry24);
        userResult=findViewById(R.id.resultText);
        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        name=sharedPreferences.getString("name","arkadaşım");
        random=new Random();
        strawberryList1 =new ArrayList<>();
        strawberryList2 =new ArrayList<>();
        addList =new AddList();
        addList.addStrawberrytoList(strawberryList1,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
        addList.addStrawberrytoList(strawberryList2,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24);
        setNumbers();

        for (int i = 0; i <randomnumber1; i++){
            strawberryList1.get(i).setVisibility(View.VISIBLE);
        }
        for (int i = 0; i <randomnumber2; i++){
            strawberryList2.get(i).setVisibility(View.VISIBLE);
        }

        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.getDefault());
                }
            }
        });
        if(firststart){
            alertCheck();
        }
    }
    private void setNumbers(){
        randomnumber1=random.nextInt(12);
        randomnumber2=random.nextInt(12);
        if(randomnumber1==0||randomnumber2==0){
            setNumbers();
        }
        result=randomnumber1+randomnumber2;

    }

    public void cevapver(View view){
        String answer= userResult.getText().toString();
        if(answer.equals("")){
            Toast.makeText(this, "Lütfen Cevap Giriniz", Toast.LENGTH_SHORT).show();
        }else{
            if(Integer.parseInt(answer)==result){
                speech.speak("Tebrikler"+name,TextToSpeech.QUEUE_FLUSH,null);
                userResult.setText(null);
                for (int i = 0; i <12; i++){
                    strawberryList1.get(i).setVisibility(View.INVISIBLE);
                }
                for (int i = 0; i <12; i++){
                    strawberryList2.get(i).setVisibility(View.INVISIBLE);
                }
                setNumbers();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <randomnumber1; i++){
                            strawberryList1.get(i).setVisibility(View.VISIBLE);
                        }
                        for (int i = 0; i <randomnumber2; i++){
                            strawberryList2.get(i).setVisibility(View.VISIBLE);
                        }
                    }
                }, 500);

            }else{
                speech.speak("Tekrar Denemelisin"+name,TextToSpeech.QUEUE_FLUSH,null);
            }
        }

    }

    private void showalert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(Addition.this,R.style.AlertDialogTheme);
        View view= LayoutInflater.from(Addition.this).inflate(
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
                alertDialog.dismiss();
            }
        });
        if(alertDialog.getWindow()!=null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

    }

    public void redirecttoaddition(View view){
        intenttovideo();
    }

    private void intenttovideo(){
        Intent intent=new Intent(Addition.this, TutorialVideo.class);
        intent.putExtra("classCheck",1);
        startActivity(intent);
        finish();
    }

    private void alertCheck(){
        showalert();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                speech.speak("Merhaba"+name+"senin için öğretici video açmamı ister misin?",TextToSpeech.QUEUE_FLUSH,null);
            }
        }, 300);
        SharedPreferences sharedPreferencesAddition=getSharedPreferences("firststartaddition",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferencesAddition.edit();
        editor.putBoolean("firststartaddition",false);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        speech.stop();
        super.onBackPressed();
    }
}