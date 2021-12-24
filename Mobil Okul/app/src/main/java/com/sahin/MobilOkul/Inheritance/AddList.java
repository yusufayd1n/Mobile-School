package com.sahin.MobilOkul.Inheritance;

import android.widget.ImageView;

import java.util.ArrayList;

public class AddList {

    public void addtoNameList(ArrayList<String> nameList,String a,String b,String c,String d,String e,String f,String g,String h,String i,String j){
        nameList.add(a);nameList.add(b); nameList.add(c);nameList.add(d);
        nameList.add(e);nameList.add(f); nameList.add(g);nameList.add(h);
        nameList.add(i);nameList.add(j);
    }

    public void addtoViewList(ArrayList<Integer> imageList,int image1,int image2,int image3,int image4,int image5,
                              int image6,int image7,int image8,int image9,int image10){
        imageList.add(image1);imageList.add(image2);imageList.add(image3);imageList.add(image4);
        imageList.add(image5);imageList.add(image6);imageList.add(image7);imageList.add(image8);
       imageList.add(image9);imageList.add(image10);

    }

    public void addtoVoiceList(ArrayList<Integer> voiceList,int voice1,int voice2,int voice3,int voice4,int voice5,
                              int voice6,int voice7,int voice8,int voice9,int voice10){
        voiceList.add(voice1);voiceList.add(voice2);voiceList.add(voice3);voiceList.add(voice4);
        voiceList.add(voice5);voiceList.add(voice6);voiceList.add(voice7);voiceList.add(voice8);
        voiceList.add(voice9);voiceList.add(voice10);

    }

    public void addStrawberrytoList(ArrayList<ImageView> strawberryList, ImageView strawberry1, ImageView strawberry2, ImageView strawberry3, ImageView strawberry4,
                                    ImageView strawberry5, ImageView strawberry6, ImageView strawberry7, ImageView strawberry8, ImageView strawberry9,
                                    ImageView strawberry10, ImageView strawberry11, ImageView strawberry12){
        strawberryList.add(strawberry1); strawberryList.add(strawberry2); strawberryList.add(strawberry3); strawberryList.add(strawberry4);
        strawberryList.add(strawberry5); strawberryList.add(strawberry6); strawberryList.add(strawberry7); strawberryList.add(strawberry8);
        strawberryList.add(strawberry9); strawberryList.add(strawberry10); strawberryList.add(strawberry11); strawberryList.add(strawberry12);

    }




}
