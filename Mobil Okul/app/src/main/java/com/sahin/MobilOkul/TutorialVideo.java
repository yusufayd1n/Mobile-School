package com.sahin.MobilOkul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.sahin.MobilOkul.Math.Addition;
import com.sahin.MobilOkul.Math.Extraction;

public class TutorialVideo extends AppCompatActivity   {
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorialvideo);
        Intent intent=getIntent();
        control=intent.getIntExtra("classCheck",0);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        if(control==1){
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = "vLGae3qvdwk";
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        }else if(control==2){
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    String videoId = "HC-B27erqgE";
                    youTubePlayer.loadVideo(videoId, 0);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if(control==1){
            Intent intent=new Intent(TutorialVideo.this, Addition.class);
            startActivity(intent);
            finish();
        }else if(control==2){
            Intent intent=new Intent(TutorialVideo.this, Extraction.class);
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }
}