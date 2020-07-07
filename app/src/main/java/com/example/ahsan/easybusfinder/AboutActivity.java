package com.example.ahsan.easybusfinder;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class AboutActivity extends AppCompatActivity {

    String arrayName[]={"Facebook","Twitter","Youtube","Windows","Apple","Google"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        CircleMenu circleMenu=findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#208cff"),R.drawable.ahsan,R.drawable.ic_menu_camera)
        .addSubMenu(Color.parseColor("#cdcdcd"),R.drawable.ic_menu_gallery)
                .addSubMenu(Color.parseColor("#fff000"),R.drawable.ic_menu_manage)
                .addSubMenu(Color.parseColor("#FF04E739"),R.drawable.ic_menu_send)
                .addSubMenu(Color.parseColor("#FF0936CE"),R.drawable.ic_menu_share)
                .addSubMenu(Color.parseColor("#FFF2E600"),R.drawable.ic_menu_slideshow)
                .addSubMenu(Color.parseColor("#FFD203ED"),R.drawable.common_full_open_on_phone)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {
                        Toast.makeText(AboutActivity.this,"You selected "+arrayName[i],Toast.LENGTH_SHORT).show();
                }
        });
    }
}
