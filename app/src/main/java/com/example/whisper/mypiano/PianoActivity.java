package com.example.whisper.mypiano;



import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.IOException;
import java.util.HashMap;

public class PianoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDo,btnRe,btnMi,btnFa,btnSo,btnLa,btnXi;
   // private AssetManager assetManager;
    private SoundPool soundPool=null;
    private HashMap<String,Integer> soundId=new HashMap<String,Integer>();
    //private MediaPlayer mediaPlayer;


    private void initSP() throws Exception{
        //设置最多可容纳5个音频流，音频的品质为5
       soundPool = new SoundPool(7,AudioManager.STREAM_MUSIC,5);
        soundId.put("Do",soundPool.load(this,R.raw.c_1,1));
        soundId.put("Re",soundPool.load(this,R.raw.d_2,1));
        soundId.put("Mi",soundPool.load(this,R.raw.e_3,1));
        soundId.put("Fa",soundPool.load(this,R.raw.f_4,1));
        soundId.put("So",soundPool.load(this,R.raw.g_5,1));
        soundId.put("La",soundPool.load(this,R.raw.a_6,1));
        soundId.put("Xi",soundPool.load(this,R.raw.b_7,1));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_piano);
        try{
            initSP();
        }catch (Exception e){
            e.printStackTrace();
        }
        bindViews();
    }

    private void bindViews() {
        btnDo = (Button) findViewById(R.id.btn_Do);
        btnRe = (Button) findViewById(R.id.btn_Re);
        btnMi = (Button) findViewById(R.id.btn_Mi);
        btnFa = (Button) findViewById(R.id.btn_Fa);
        btnSo = (Button) findViewById(R.id.btn_So);
        btnLa = (Button) findViewById(R.id.btn_La);
        btnXi = (Button) findViewById(R.id.btn_Xi);



        btnDo.setOnClickListener(this);
        btnRe.setOnClickListener(this);
        btnMi.setOnClickListener(this);
        btnFa.setOnClickListener(this);
        btnSo.setOnClickListener(this);
        btnLa.setOnClickListener(this);
        btnXi.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_Do:
                soundPool.play(soundId.get("Do"), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_Re:
                soundPool.play(soundId.get("Re"), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_Mi:
                soundPool.play(soundId.get("Mi"), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_Fa:
                soundPool.play(soundId.get("Fa"), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_So:
                soundPool.play(soundId.get("So"), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_La:
                soundPool.play(soundId.get("La"), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_Xi:
                soundPool.play(soundId.get("Xi"), 1, 1, 0, 0, 1);
                break;
        }
    }





}
