package com.fujdevelopers.gymbro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public Button start;
    public Button How;


    public void initglobalvars(){
        SharedPreferences BPerfs = getSharedPreferences("Stats", MODE_PRIVATE);
        String stringbodyweight = BPerfs.getString("bw", "0");
        Globals.bodyweight = (Double.parseDouble(stringbodyweight));

        SharedPreferences HPerfs = getSharedPreferences("Stats", MODE_PRIVATE);
        String stringheight = BPerfs.getString("h", "0");
        Globals.height = (Double.parseDouble(stringheight));

        SharedPreferences WPerfs = getSharedPreferences("Stats", MODE_PRIVATE);
        String stringwaist = BPerfs.getString("w", "0");
        Globals.curwaist = (Double.parseDouble(stringwaist));

        //curlifts
        SharedPreferences CBPPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        String curbp = CBPPerfs.getString("CBP", "0");
        Globals.curbp = (Double.parseDouble(curbp));

        SharedPreferences CBCPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        String curbc = CBCPerfs.getString("CBC", "0");
        Globals.curbc = (Double.parseDouble(curbc));

        SharedPreferences CSPPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        String cursp = CSPPerfs.getString("CSP", "0");
        Globals.cursp = (Double.parseDouble(cursp));

        SharedPreferences WCUPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        String curwcu = WCUPerfs.getString("CWCU", "0");
        Globals.curwcu = (Double.parseDouble(curwcu));
    }


    public void initMenu(){
        //cliclable start button
        start = (Button)findViewById(R.id.start);
        start.setBackgroundResource(R.drawable.clickclick);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MenuDo = new Intent(MainActivity.this, menu.class);
                startActivity(MenuDo);

            }
        });
        //clickable how button
        How = (Button)findViewById(R.id.How);
        How.setBackgroundResource(R.drawable.clickclick2);
        How.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO create Info page Link

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //animation spinning logo
        final ImageView Logo = (ImageView)findViewById(R.id.imageView3);
        final Animation Spin = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        //start animation
        Logo.startAnimation(Spin);
        initMenu();
        initglobalvars();


    }
}
