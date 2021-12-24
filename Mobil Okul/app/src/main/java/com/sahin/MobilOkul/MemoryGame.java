package com.sahin.MobilOkul;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MemoryGame extends AppCompatActivity {
    ImageView i11,i12,i13,i14,i21,i22,i23,i24,i31,i32,i33,i34,i41,i42,i43,i44;

    Integer[] cardsArray={101,102,103,104,105,106,107,108,201,202,203,204,205,206,207,208};
    int image101,image102,image103,image104, image105, image106,image107,image108, image201, image202,
            image203, image204, image205, image206,image207,image208;
    int firstCard,secondCard;
    int firstClicked,secondClicked;
    int cardNumber=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);
        i11=findViewById(R.id.questioMark1);i12=findViewById(R.id.questioMark2);
        i13=findViewById(R.id.questioMark3);i14=findViewById(R.id.questioMark4);
        i21=findViewById(R.id.questioMark5);i22=findViewById(R.id.questioMark6);
        i23=findViewById(R.id.questioMark7);i24=findViewById(R.id.questioMark8);
        i31=findViewById(R.id.questioMark9);i32=findViewById(R.id.questioMark10);
        i33=findViewById(R.id.questioMark11);i34=findViewById(R.id.questioMark12);
        i41=findViewById(R.id.questioMark13);i42=findViewById(R.id.questioMark14);
        i43=findViewById(R.id.questioMark15);i44=findViewById(R.id.questioMark16);

        i11.setTag("0"); i12.setTag("1"); i13.setTag("2"); i14.setTag("3");
        i21.setTag("4"); i22.setTag("5"); i23.setTag("6"); i24.setTag("7");
        i31.setTag("8"); i32.setTag("9"); i33.setTag("10"); i34.setTag("11");
        i41.setTag("12"); i42.setTag("13"); i43.setTag("14"); i44.setTag("15");

        frontOfCardsResources();
        Collections.shuffle(Arrays.asList(cardsArray));

        i11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i11,theCard);
            }
        });
        i12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i12,theCard);
            }
        });
        i13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i13,theCard);
            }
        });
        i14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i14,theCard);
            }
        });
        i21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i21,theCard);
            }
        });
        i22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i22,theCard);
            }
        });i23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i23,theCard);
            }
        });
        i24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i24,theCard);
            }
        });
        i31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i31,theCard);
            }
        });
        i32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i32,theCard);
            }
        });
        i33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i33,theCard);
            }
        });
        i34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i34,theCard);
            }
        });
        i41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i41,theCard);
            }
        });
        i42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i42,theCard);
            }
        });
        i43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i43,theCard);
            }
        });
        i44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard=Integer.parseInt((String) view.getTag());
                doStuff(i44,theCard);
            }
        });


    }

    private void doStuff(ImageView iv,int card){
        if(cardsArray[card]==101){
            iv.setImageResource(image101);
        }else if(cardsArray[card]==102){
            iv.setImageResource(image102);
        }else if(cardsArray[card]==103){
            iv.setImageResource(image103);
        }else if(cardsArray[card]==104){
            iv.setImageResource(image104);
        }else if(cardsArray[card]==105){
            iv.setImageResource(image105);
        }else if(cardsArray[card]==106){
            iv.setImageResource(image106);
        }else if(cardsArray[card]==107){
            iv.setImageResource(image107);
        }else if(cardsArray[card]==108){
            iv.setImageResource(image108);
        }else if(cardsArray[card]==201){
            iv.setImageResource(image201);
        }else if(cardsArray[card]==202){
            iv.setImageResource(image202);
        }else if(cardsArray[card]==203){
            iv.setImageResource(image203);
        }else if(cardsArray[card]==204){
            iv.setImageResource(image204);
        }else if(cardsArray[card]==205){
            iv.setImageResource(image205);
        }else if(cardsArray[card]==206){
            iv.setImageResource(image206);
        }else if(cardsArray[card]==207){
            iv.setImageResource(image207);
        }else if(cardsArray[card]==208){
            iv.setImageResource(image208);
        }

        if(cardNumber==1){
            firstCard=cardsArray[card];
            if(firstCard>200){
                firstCard=firstCard-100;
            }
            cardNumber=2;
            firstClicked=card;
            iv.setEnabled(false);
        }else if(cardNumber==2){
            secondCard=cardsArray[card];
            if(secondCard>200){
                secondCard=secondCard-100;
            }
            cardNumber=1;
            secondClicked=card;
            i11.setEnabled(false);
            i12.setEnabled(false);
            i13.setEnabled(false);
            i14.setEnabled(false);
            i21.setEnabled(false);
            i22.setEnabled(false);
            i23.setEnabled(false);
            i24.setEnabled(false);
            i31.setEnabled(false);
            i32.setEnabled(false);
            i33.setEnabled(false);
            i34.setEnabled(false);
            i41.setEnabled(false);
            i42.setEnabled(false);
            i43.setEnabled(false);
            i44.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }
    }

    private void calculate(){
        if(firstCard==secondCard){
            if(firstClicked==0){
                i11.setVisibility(View.INVISIBLE);
            }else if(firstClicked==1){
                i12.setVisibility(View.INVISIBLE);
            }else if(firstClicked==2){
                i13.setVisibility(View.INVISIBLE);
            }else if(firstClicked==3){
                i14.setVisibility(View.INVISIBLE);
            }else if(firstClicked==4){
                i21.setVisibility(View.INVISIBLE);
            }else if(firstClicked==5){
                i22.setVisibility(View.INVISIBLE);
            }else if(firstClicked==6){
                i23.setVisibility(View.INVISIBLE);
            }else if(firstClicked==7){
                i24.setVisibility(View.INVISIBLE);
            }else if(firstClicked==8){
                i31.setVisibility(View.INVISIBLE);
            }else if(firstClicked==9){
                i32.setVisibility(View.INVISIBLE);
            }else if(firstClicked==10){
                i33.setVisibility(View.INVISIBLE);
            }else if(firstClicked==11){
                i34.setVisibility(View.INVISIBLE);
            }else if(firstClicked==12){
                i41.setVisibility(View.INVISIBLE);
            }else if(firstClicked==13){
                i42.setVisibility(View.INVISIBLE);
            }else if(firstClicked==14){
                i43.setVisibility(View.INVISIBLE);
            }else if(firstClicked==15){
                i44.setVisibility(View.INVISIBLE);
            }

            if(secondClicked==0){
                i11.setVisibility(View.INVISIBLE);
            }else if(secondClicked==1){
                i12.setVisibility(View.INVISIBLE);
            }else if(secondClicked==2){
                i13.setVisibility(View.INVISIBLE);
            }else if(secondClicked==3){
                i14.setVisibility(View.INVISIBLE);
            }else if(secondClicked==4){
                i21.setVisibility(View.INVISIBLE);
            }else if(secondClicked==5){
                i22.setVisibility(View.INVISIBLE);
            }else if(secondClicked==6){
                i23.setVisibility(View.INVISIBLE);
            }else if(secondClicked==7){
                i24.setVisibility(View.INVISIBLE);
            }else if(secondClicked==8){
                i31.setVisibility(View.INVISIBLE);
            }else if(secondClicked==9){
                i32.setVisibility(View.INVISIBLE);
            }else if(secondClicked==10){
                i33.setVisibility(View.INVISIBLE);
            }else if(secondClicked==11){
                i34.setVisibility(View.INVISIBLE);
            }else if(secondClicked==12){
                i41.setVisibility(View.INVISIBLE);
            }else if(secondClicked==13){
                i42.setVisibility(View.INVISIBLE);
            }else if(secondClicked==14){
                i43.setVisibility(View.INVISIBLE);
            }else if(secondClicked==15){
                i44.setVisibility(View.INVISIBLE);
            }

        }else{
            i11.setImageResource(R.drawable.question_mark);i12.setImageResource(R.drawable.question_mark);
            i13.setImageResource(R.drawable.question_mark);i14.setImageResource(R.drawable.question_mark);
            i21.setImageResource(R.drawable.question_mark);i22.setImageResource(R.drawable.question_mark);
            i23.setImageResource(R.drawable.question_mark);i24.setImageResource(R.drawable.question_mark);
            i31.setImageResource(R.drawable.question_mark);i32.setImageResource(R.drawable.question_mark);
            i33.setImageResource(R.drawable.question_mark);i34.setImageResource(R.drawable.question_mark);
            i41.setImageResource(R.drawable.question_mark);i42.setImageResource(R.drawable.question_mark);
            i43.setImageResource(R.drawable.question_mark);i44.setImageResource(R.drawable.question_mark);
        }
        i11.setEnabled(true);i12.setEnabled(true);i13.setEnabled(true);i14.setEnabled(true);
        i21.setEnabled(true);i22.setEnabled(true);i23.setEnabled(true);i24.setEnabled(true);
        i31.setEnabled(true);i32.setEnabled(true);i33.setEnabled(true);i34.setEnabled(true);
        i41.setEnabled(true);i42.setEnabled(true);i43.setEnabled(true);i44.setEnabled(true);

        checkEnd();
    }

    private void checkEnd() {
        if(i11.getVisibility()==View.INVISIBLE&&
                i12.getVisibility()==View.INVISIBLE&&
                i13.getVisibility()==View.INVISIBLE&&
                i14.getVisibility()==View.INVISIBLE&&
                i21.getVisibility()==View.INVISIBLE&&
                i22.getVisibility()==View.INVISIBLE&&
                i23.getVisibility()==View.INVISIBLE&&
                i24.getVisibility()==View.INVISIBLE&&
                i31.getVisibility()==View.INVISIBLE&&
                i32.getVisibility()==View.INVISIBLE&&
                i33.getVisibility()==View.INVISIBLE&&
                i34.getVisibility()==View.INVISIBLE&&
                i41.getVisibility()==View.INVISIBLE&&
                i42.getVisibility()==View.INVISIBLE&&
                i43.getVisibility()==View.INVISIBLE&&
                i44.getVisibility()==View.INVISIBLE
        ){
            AlertDialog.Builder builder=new AlertDialog.Builder(MemoryGame.this,R.style.AlertDialogTheme);
            View view= LayoutInflater.from(MemoryGame.this).inflate(
                    R.layout.choose_dialog,(ConstraintLayout) findViewById(R.id.layoutDialogContainer)
            );
            builder.setView(view);
            ((TextView) view.findViewById(R.id.textTittle)).setText(getResources().getString(R.string.tittleMemoryGame));
            ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.textMemoryGame));
            ((Button) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.yesMemoryGame));
            ((Button) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.noMemoryGame));
            ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_celebration);

            AlertDialog alertDialog=builder.create();
            view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MemoryGame.this,MemoryGame.class);
                    startActivity(intent);
                    finish();
                }
            });

            view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MemoryGame.this,Selection.class);
                    startActivity(intent);
                    finish();
                }
            });
            if(alertDialog.getWindow()!=null){
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            alertDialog.show();
        }

    }

    private void frontOfCardsResources() {
        image101=R.drawable.horse_1;
        image102=R.drawable.rat_1;
        image103=R.drawable.turtle_1;
        image104=R.drawable.squirrel_1;
        image105=R.drawable.monkey_1;
        image106=R.drawable.skunk_1;
        image107=R.drawable.duck_1;
        image108=R.drawable.hedgehog_1;
        image201=R.drawable.horse_2;
        image202=R.drawable.rat_2;
        image203=R.drawable.turtle_2;
        image204=R.drawable.squirrel_2;
        image205=R.drawable.monkey_2;
        image206=R.drawable.skunk_2;
        image207=R.drawable.duck_2;
        image208=R.drawable.hedgehog_2;
    }

}