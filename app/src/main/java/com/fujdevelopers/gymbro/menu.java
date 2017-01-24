package com.fujdevelopers.gymbro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    public Button cur;
    public Button edt;
    public Button goal;
    public Button stat;

    public void init(){
        cur = (Button)findViewById(R.id.CurrentLift);
        cur.setBackgroundResource(R.drawable.curliftclickclick);
        cur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent CurOpen = new Intent(menu.this, CurLifts.class);
                startActivity(CurOpen);

            }
        });

        edt = (Button)findViewById(R.id.EditCurrent);
        edt.setBackgroundResource(R.drawable.editliftclickclick);
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent EdtOpen = new Intent(menu.this, EdtCurLifts.class);
                startActivity(EdtOpen);

            }
        });

        goal = (Button)findViewById(R.id.GoalLift);
        goal.setBackgroundResource(R.drawable.goalliftclickclick);
        goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent GoalOpen = new Intent(menu.this, GoalLifts.class);
                startActivity(GoalOpen);

            }
        });

        stat = (Button)findViewById(R.id.MyStats);
        stat.setBackgroundResource(R.drawable.mystatsclickclick);
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StatOpen = new Intent(menu.this, MyStats.class);
                startActivity(StatOpen);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        init();
    }
}
