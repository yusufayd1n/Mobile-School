package com.sahin.MobilOkul.Turkish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.sahin.MobilOkul.R;
import com.sahin.MobilOkul.Inheritance.AddList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Letters extends AppCompatActivity {
    ImageView wheel;
    Button spinbutton,wheelspin;
    TextToSpeech speech;
    AddList addList;
    private ArrayList letterList;
    String alphabet []={"A","B","C","Ç","D","E","F","G","Ğ","H","İ","I","J","K","L","M","N","O","Ö","Q","P","R","S","Ş","T","U","Ü","V","Y","Z"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        wheel=findViewById(R.id.Wheel);
        spinbutton=findViewById(R.id.spinButton);
        wheelspin=findViewById(R.id.wheelSpin);
        addList=new AddList();
        letterList=new ArrayList<>(Arrays.asList(alphabet));

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
                speech.speak("",TextToSpeech.QUEUE_FLUSH,null);
            }
        }, 300);


    }

    public void spin (View view){
        wheelspin.setVisibility(View.INVISIBLE);
        spinbutton.setVisibility(View.INVISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                wheelspin.setVisibility(View.VISIBLE);
                spinbutton.setVisibility(View.VISIBLE);
            }
        }, 3500);
        Random random = new Random();
        int degree = random.nextInt(360);
        RotateAnimation rotateAnimation = new RotateAnimation(0, degree + 720,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(2500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        number(360 - degree % 360);
                    }
                }, 500);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        wheel.startAnimation(rotateAnimation);
    }

    private String number(int degree) {
        String text = "";
        if (degree <12) {
            speech.speak(letterList.get(0).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<24){
            speech.speak(letterList.get(1).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<36){
            speech.speak(letterList.get(2).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<48){
            speech.speak(letterList.get(3).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<60){
            speech.speak(letterList.get(4).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<72){
            speech.speak(letterList.get(5).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<84){
            speech.speak(letterList.get(6).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<96){
            speech.speak(letterList.get(7).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<108){
            speech.speak(letterList.get(8).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<120){
            speech.speak(letterList.get(9).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<132){
            speech.speak(letterList.get(10).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<144){
            speech.speak(letterList.get(11).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<156){
            speech.speak(letterList.get(12).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<168){
            speech.speak(letterList.get(13).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<180){
            speech.speak(letterList.get(14).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<192){
            speech.speak(letterList.get(15).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<204){
            speech.speak(letterList.get(16).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<216){
            speech.speak(letterList.get(17).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<228){
            speech.speak(letterList.get(18).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<240){
            speech.speak(letterList.get(19).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<252){
            speech.speak(letterList.get(20).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<264){
            speech.speak(letterList.get(21).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<276){
            speech.speak(letterList.get(22).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<288){
            speech.speak(letterList.get(23).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<300){
            speech.speak(letterList.get(24).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<312){
            speech.speak(letterList.get(25).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<324){
            speech.speak(letterList.get(26).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<336){
            speech.speak(letterList.get(27).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<348){
            speech.speak(letterList.get(28).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }else if(degree<360){
            speech.speak(letterList.get(29).toString(),TextToSpeech.QUEUE_FLUSH,null);
        }
        return text;
    }


}
