package com.example.zhaowenhao.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by zhaowenhao on 16/3/29.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    private boolean isPaused = false;

    public void stop(){
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){

        if (! isPaused) {
            stop();
            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
        }

        mPlayer.start();
    }

    public void pause(){
        if (mPlayer != null){
            isPaused = true;
            mPlayer.pause();
        }
    }
}
