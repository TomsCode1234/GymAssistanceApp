package com.fujdevelopers.gymbro;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyStats extends AppCompatActivity {

    public EditText myweight;
    public EditText myheight;
    public EditText mywaistsize;

    public Button plusweight;
    public Button plusheight;
    public Button pluswaistsize;

    public Button minusweight;
    public Button minusheight;
    public Button minuswaistsize;

    public Button kgweight;
    public Button mheight;
    public Button cmwaist;

    public Button lbsweight;
    public Button feetheight;
    public Button inchwaist;

    public Button cancel;
    public Button save;

    public int unitheight = 1;
    public int unitweight = 1;
    public int unitwaistsize = 1;

    public double temp;

    public int intweight;
    public int intheight;
    public int intwaistsize;

    public String Stringweight;
    public String Stringheight;
    public String Stringwaistsize;
    public String SAVESTATE;

    public void commit(){
        SharedPreferences BPerfs = getSharedPreferences("Stats", MODE_PRIVATE);
        SharedPreferences.Editor BEditor = BPerfs.edit();
        Stringweight = (Double.toString(Globals.bodyweight));
        BEditor.putString("bw", Stringweight).commit();

        SharedPreferences HPerfs = getSharedPreferences("Stats", MODE_PRIVATE);
        SharedPreferences.Editor HEditor = HPerfs.edit();
        Stringheight = (Double.toString(Globals.height));
        BEditor.putString("h", Stringheight).commit();

        SharedPreferences WPerfs = getSharedPreferences("Stats", MODE_PRIVATE);
        SharedPreferences.Editor WEditor = WPerfs.edit();
        Stringwaistsize = (Double.toString(Globals.curwaist));
        BEditor.putString("w", Stringwaistsize).commit();
    }


    public void setButtons(){
        cancel = (Button)findViewById(R.id.cancel4);
        cancel.setBackgroundResource(R.drawable.newclickbutton);
        save = (Button)findViewById(R.id.button18);
        save.setBackgroundResource(R.drawable.newclickbutton);

        kgweight = (Button)findViewById(R.id.button);
        kgweight.setBackgroundResource(R.drawable.buttonbackground);
        lbsweight = (Button)findViewById(R.id.button2);
        lbsweight.setBackgroundResource(R.drawable.buttondark);

        mheight = (Button)findViewById(R.id.button7A);
        mheight.setBackgroundResource(R.drawable.buttonbackground);
        feetheight = (Button)findViewById(R.id.button8A);
        feetheight.setBackgroundResource(R.drawable.buttondark);

        cmwaist = (Button)findViewById(R.id.button3);
        cmwaist.setBackgroundResource(R.drawable.buttonbackground);
        inchwaist = (Button)findViewById(R.id.button5);
        inchwaist.setBackgroundResource(R.drawable.buttondark);

        minusheight = (Button)findViewById(R.id.button10A);
        minusheight.setBackgroundResource(R.drawable.minusclick);
        minusweight = (Button)findViewById(R.id.button6);
        minusweight.setBackgroundResource(R.drawable.minusclick);
        minuswaistsize = (Button)findViewById(R.id.button10B);
        minuswaistsize.setBackgroundResource(R.drawable.minusclick);

        plusheight = (Button)findViewById(R.id.button11A);
        plusheight.setBackgroundResource(R.drawable.plusclick);
        plusweight = (Button)findViewById(R.id.WCUPlus);
        plusweight.setBackgroundResource(R.drawable.plusclick);
        pluswaistsize = (Button)findViewById(R.id.button11B);
        pluswaistsize.setBackgroundResource(R.drawable.plusclick);

        myheight = (EditText)findViewById(R.id.editTextA);
        myweight = (EditText)findViewById(R.id.editText3);
        mywaistsize = (EditText)findViewById(R.id.editTextB);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitweight % 2!=0){
                    Globals.bodyweight = (Double.parseDouble(myweight.getText().toString()));
                }else{
                    temp = ((Double.parseDouble(myweight.getText().toString())/2.2));
                }
                if (unitheight % 2!=0){
                    Globals.height = (Double.parseDouble(myheight.getText().toString()));
                }else{
                    Globals.height = ((Double.parseDouble(myheight.getText().toString()))*0.3048);
                }
                if (unitwaistsize % 2!=0){
                    Globals.curwaist = (Double.parseDouble(mywaistsize.getText().toString()));
                }else{
                    Globals.curwaist = (Double.parseDouble(mywaistsize.getText().toString())*2.54);
                }
                commit();
                finish();
            }
        });
    }


    public void setMetric(){

        Stringheight = String.format("%.2f", Globals.height);
        myheight.setText(Stringheight);

        intweight = (int) Math.round(Globals.bodyweight);
        Stringweight = Integer.toString(intweight);
        myweight.setText(Stringweight);

        intwaistsize = (int) Math.round(Globals.curwaist);
        Stringwaistsize = Integer.toString(intwaistsize);
        mywaistsize.setText(Stringwaistsize);
    }

    public void setImperial(){

        Stringheight = String.format("%.2f", Globals.height);
        myheight.setText(Stringheight);

        temp = ((Globals.bodyweight)*2);
        intweight = (int)(Math.round((temp)+(temp/10)));
        Stringweight = Integer.toString(intweight);
        myweight.setText(Stringweight);

        intwaistsize = (int) (Math.round(Globals.curwaist)*2.2);
        Stringwaistsize = Integer.toString(intwaistsize);
        mywaistsize.setText(Stringwaistsize);

    }

    public void liveupdates(){
        //set units
        kgweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitweight % 2==0){
                    unitweight = (unitweight+1);
                    if (myweight.getText().toString().equals("")){

                    }else {
                        Stringweight = (myweight.getText().toString());
                        temp = (Double.parseDouble(Stringweight));
                        temp = (temp / 2.2);
                        intweight = (int) Math.round(temp);
                        //MAKE KGS
                        Stringweight = Integer.toString(intweight);
                        myweight.setText(Stringweight);
                    }
                        kgweight.setBackgroundResource(R.drawable.buttonbackground);
                        lbsweight.setBackgroundResource(R.drawable.buttondark);
                        kgweight.setTypeface(null, Typeface.BOLD);
                        lbsweight.setTypeface(null, Typeface.NORMAL);

                }
            }
        });

        lbsweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitweight % 2!=0){
                    unitweight = (unitweight + 1);
                    if (myweight.getText().toString().equals("")){

                    }else {
                        temp = ((Double.parseDouble(myweight.getText().toString())) * 2);
                        intweight = (int) (Math.round((temp) + (temp / 10)));
                        Stringweight = Integer.toString(intweight);
                        myweight.setText(Stringweight);
                    }
                    kgweight.setBackgroundResource(R.drawable.buttondark);
                    lbsweight.setBackgroundResource(R.drawable.buttonbackground);
                    kgweight.setTypeface(null, Typeface.NORMAL);
                    lbsweight.setTypeface(null, Typeface.BOLD);
                }
            }
        });

        cmwaist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitwaistsize % 2==0){
                    unitwaistsize = (unitwaistsize + 1);
                    if (mywaistsize.getText().toString().equals("")){

                    }else {
                        temp = (Double.parseDouble(mywaistsize.getText().toString()));
                        intwaistsize = (int) (Math.round((temp) * 2.54));
                        Stringwaistsize = Integer.toString(intwaistsize);
                        mywaistsize.setText(Stringwaistsize);
                    }
                    cmwaist.setBackgroundResource(R.drawable.buttonbackground);
                    inchwaist.setBackgroundResource(R.drawable.buttondark);
                    cmwaist.setTypeface(null, Typeface.BOLD);
                    inchwaist.setTypeface(null, Typeface.NORMAL);
                }
            }
        });

        inchwaist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitwaistsize % 2!=0){
                    unitwaistsize = (unitwaistsize+1);
                    if (mywaistsize.getText().toString().equals("")){

                    }else {
                        intwaistsize = (int) (Math.round((Double.parseDouble(mywaistsize.getText().toString())) * 0.39));
                        Stringwaistsize = Integer.toString(intwaistsize);
                        mywaistsize.setText(Stringwaistsize);
                    }
                    cmwaist.setBackgroundResource(R.drawable.buttondark);
                    inchwaist.setBackgroundResource(R.drawable.buttonbackground);
                    cmwaist.setTypeface(null, Typeface.NORMAL);
                    inchwaist.setTypeface(null, Typeface.BOLD);
                }
            }
        });

        mheight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitheight % 2==0){
                    unitheight = (unitheight + 1);
                    if (myheight.getText().toString().equals("")){

                    }else {
                        temp = ((Double.parseDouble(myheight.getText().toString())) * 0.3048);
                        myheight.setText(String.format("%.2f", temp));
                    }
                    mheight.setBackgroundResource(R.drawable.buttonbackground);
                    feetheight.setBackgroundResource(R.drawable.buttondark);
                    mheight.setTypeface(null, Typeface.BOLD);
                    feetheight.setTypeface(null, Typeface.NORMAL);
                }
            }
        });

        feetheight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (unitheight % 2!=0){
                    unitheight = (unitheight + 1);
                    if (myheight.getText().toString().equals("")){

                    }else {
                        temp = ((Double.parseDouble(myheight.getText().toString())) * 3.280839895);
                        myheight.setText(String.format("%.2f", temp));
                    }
                    mheight.setBackgroundResource(R.drawable.buttondark);
                    feetheight.setBackgroundResource(R.drawable.buttonbackground);
                    mheight.setTypeface(null, Typeface.NORMAL);
                    feetheight.setTypeface(null, Typeface.BOLD);
                }

            }
        });

        plusweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stringweight = myweight.getText().toString();
                intweight = Integer.parseInt(Stringweight);
                intweight = intweight + 1;
                Stringweight = (Integer.toString(intweight));
                myweight.setText(Stringweight);

            }
        });

        plusheight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (Double.parseDouble(myheight.getText().toString())+0.01);
                myheight.setText(String.format("%.2f", temp));
            }
        });

        pluswaistsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stringwaistsize = mywaistsize.getText().toString();
                intwaistsize = Integer.parseInt(Stringwaistsize);
                intwaistsize = intwaistsize + 1;
                Stringwaistsize = (Integer.toString(intwaistsize));
                mywaistsize.setText(Stringwaistsize);
            }
        });

        minusweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stringweight = myweight.getText().toString();
                intweight = Integer.parseInt(Stringweight);
                intweight = intweight - 1;
                Stringweight = (Integer.toString(intweight));
                myweight.setText(Stringweight);
            }
        });

        minusheight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (Double.parseDouble(myheight.getText().toString())-0.01);
                myheight.setText(String.format("%.2f", temp));
            }
        });

        minuswaistsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stringwaistsize = mywaistsize.getText().toString();
                intwaistsize = Integer.parseInt(Stringwaistsize);
                intwaistsize = intwaistsize - 1;
                Stringwaistsize = (Integer.toString(intwaistsize));
                mywaistsize.setText(Stringwaistsize);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stats);
        setButtons();
        setMetric();
        liveupdates();
    }
}
