package com.fujdevelopers.gymbro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Application;

public class EdtCurLifts extends AppCompatActivity {

    public Button plusbp;
    public Button plusbc;
    public Button plussp;
    public Button pluswcu;

    public Button cancbtn;
    public Button savebtn;

    public Button minusbp;
    public Button minusbc;
    public Button minussp;
    public Button minuswcu;

    public EditText CurrentBp;
    public EditText CurrentBc;
    public EditText CurrentSp;
    public EditText CurrentWcu;

    public String stringCurBp;
    public String stringCurBc;
    public String stringCurSp;
    public String stringCurWcu;

    public int intCurBp;
    public int intCurBc;
    public int intCurSp;
    public int intCurWcu;

    public Button kgbp;
    public Button kgbc;
    public Button kgsp;
    public Button kgwcu;

    public Button lbsbp;
    public Button lbsbc;
    public Button lbssp;
    public Button lbswcu;

    public String kgconv;
    public String lbsconv;
    public int intkgconv;
    public int intlbsconv;
    public double doublekgconv;
    public double doublelbsconv;

    public int unitbp = 2;
    public int unitwcu = 2;
    public int unitsp = 2;
    public int unitbc = 2;

    public double temp;

    public void liveupdate(){

        stringCurBp = CurrentBp.getText().toString();
        intCurBp = Integer.parseInt(stringCurBp);

        stringCurBc = CurrentBc.getText().toString();
        intCurBc = Integer.parseInt(stringCurBc);

        stringCurSp = CurrentSp.getText().toString();
        intCurSp = Integer.parseInt(stringCurSp);

        stringCurWcu = CurrentWcu.getText().toString();
        intCurWcu = Integer.parseInt(stringCurWcu);
    }

    public void minusButtonClick(){
            minussp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurSp = intCurSp - 1;
                    setCurBp();
                }
            });
            minusbc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurBc = intCurBc - 1;
                    setCurBp();
                }
            });
            minusbp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurBp = intCurBp - 1;
                    setCurBp();
                }
            });
            minuswcu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurWcu = intCurWcu - 1;
                    setCurBp();
                }
            });
    }

    public void plusButtonClicks(){
            plusbp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurBp = intCurBp + 1;
                    setCurBp();
                }
            });
            plusbc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurBc = intCurBc + 1;
                    setCurBp();
                }
            });
            plussp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurSp = intCurSp + 1;
                    setCurBp();
                }
            });
            pluswcu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liveupdate();
                    intCurWcu = intCurWcu + 1;
                    setCurBp();
                }
            });
    }

    public void setbtns(){

        plusbc = (Button)findViewById(R.id.button11C);
        plusbp = (Button)findViewById(R.id.button11B);
        plussp = (Button)findViewById(R.id.button11A);
        pluswcu = (Button)findViewById(R.id.WCUPlus);

        minusbp = (Button)findViewById(R.id.button10B);
        minusbc = (Button)findViewById(R.id.button10C);
        minussp = (Button)findViewById(R.id.button10A);
        minuswcu = (Button)findViewById(R.id.button6);

        kgbc = (Button)findViewById(R.id.button14);
        kgbp = (Button)findViewById(R.id.button3);
        kgsp = (Button)findViewById(R.id.button7A);
        kgwcu = (Button)findViewById(R.id.button);

        lbsbp = (Button)findViewById(R.id.button5);
        lbsbc = (Button)findViewById(R.id.button17);
        lbssp = (Button)findViewById(R.id.button8A);
        lbswcu = (Button)findViewById(R.id.button2);
    }

    public void setclickanims(){
        plusbc.setBackgroundResource(R.drawable.plusclick);
        plusbp.setBackgroundResource(R.drawable.plusclick);
        plussp.setBackgroundResource(R.drawable.plusclick);
        pluswcu.setBackgroundResource(R.drawable.plusclick);

        minusbc.setBackgroundResource(R.drawable.minusclick);
        minusbp.setBackgroundResource(R.drawable.minusclick);
        minussp.setBackgroundResource(R.drawable.minusclick);
        minuswcu.setBackgroundResource(R.drawable.minusclick);

        cancbtn.setBackgroundResource(R.drawable.newclickbutton);
        savebtn.setBackgroundResource(R.drawable.newclickbutton);

        kgbp.setBackgroundResource(R.drawable.buttonbackground);
        kgbc.setBackgroundResource(R.drawable.buttonbackground);
        kgsp.setBackgroundResource(R.drawable.buttonbackground);
        kgwcu.setBackgroundResource(R.drawable.buttonbackground);
    }

    public void callcurbp(){
        CurrentBp = (EditText)findViewById(R.id.editTextB);
        CurrentBc = (EditText)findViewById(R.id.editTextC);
        CurrentSp = (EditText)findViewById(R.id.editTextA);
        CurrentWcu = (EditText)findViewById(R.id.editText3);

        intCurBc = (int) Math.round(Globals.curbc);
        intCurBp = (int) Math.round(Globals.curbp);
        intCurSp = (int) Math.round(Globals.cursp);
        intCurWcu = (int) Math.round(Globals.curwcu);

    }

    public void setCurBp() {

        stringCurBp = (Integer.toString(intCurBp));
        stringCurBc = (Integer.toString(intCurBc));
        stringCurSp = (Integer.toString(intCurSp));
        stringCurWcu = (Integer.toString(intCurWcu));

        CurrentBp.setText(stringCurBp, TextView.BufferType.EDITABLE);
        CurrentBc.setText(stringCurBc, TextView.BufferType.EDITABLE);
        CurrentSp.setText(stringCurSp, TextView.BufferType.EDITABLE);
        CurrentWcu.setText(stringCurWcu, TextView.BufferType.EDITABLE);

    }


    public void cancelset(){
        cancbtn = (Button)findViewById(R.id.cancel4);
        cancbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void setSavebtn(){
        savebtn = (Button)findViewById(R.id.button18);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save bench press
                    if (unitbp % 2==0){
                        Globals.curbp = (int) Math.round(Integer.parseInt(CurrentBp.getText().toString()));
                    }else{
                        intCurBp = (Integer.parseInt(CurrentBp.getText().toString()));
                        temp = (int) Math.round(intCurBp);
                        temp = (temp/2.2);
                        intCurBp = (int) Math.round(temp);
                        Globals.curbp = (int) Math.round(intCurBp);
                    }
                //save bicep curl
                    if (unitbc % 2==0){
                        Globals.curbc = (int) Math.round(Integer.parseInt(CurrentBc.getText().toString()));
                    }else{
                        intCurBc = (Integer.parseInt(CurrentBc.getText().toString()));
                        temp = (int) Math.round(intCurBc);
                        temp = (temp/2.2);
                        intCurBc = (int) Math.round(temp);
                        Globals.curbc = (int) Math.round(intCurBc);
                    }
                //save shoulder press
                    if (unitsp % 2==0){
                        Globals.cursp = (int) Math.round(Integer.parseInt(CurrentSp.getText().toString()));
                    }else{
                        intCurSp = (Integer.parseInt(CurrentSp.getText().toString()));
                        temp = (int) Math.round(intCurSp);
                        temp = (temp/2.2);
                        intCurSp = (int) Math.round(temp);
                        Globals.cursp = (int) Math.round(intCurSp);
                    }
                //save weighted chin up
                    if (unitwcu % 2==0){
                        Globals.curwcu = (int) Math.round(Integer.parseInt(CurrentWcu.getText().toString()));
                    }else{
                        intCurWcu = (Integer.parseInt(CurrentWcu.getText().toString()));
                        temp = (int) Math.round(intCurWcu);
                        temp = (temp/2.2);
                        intCurWcu = (int) Math.round(temp);
                        Globals.curwcu = (int) Math.round(intCurWcu);
                    }
                    commit();
                    finish();
            }
        });
        
    }

    public void commit(){
        SharedPreferences CBPPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        SharedPreferences.Editor CBPEditor = CBPPerfs.edit();
        stringCurBp = (Double.toString(Globals.curbp));
        CBPEditor.putString("CBP", stringCurBp).commit();

        SharedPreferences CBCPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        SharedPreferences.Editor CBCEditor = CBCPerfs.edit();
        stringCurBc = (Double.toString(Globals.curbc));
        CBCEditor.putString("CBC", stringCurBc).commit();

        SharedPreferences CSPPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        SharedPreferences.Editor CSPEditor = CSPPerfs.edit();
        stringCurSp = (Double.toString(Globals.cursp));
        CSPEditor.putString("CSP", stringCurSp).commit();

        SharedPreferences WCUPerfs = getSharedPreferences("Lifts", MODE_PRIVATE);
        SharedPreferences.Editor WCUEditor = WCUPerfs.edit();
        stringCurWcu = (Double.toString(Globals.curwcu));
        WCUEditor.putString("CWCU", stringCurWcu).commit();
    }

    public void convertKgtoLbs(){
        intkgconv = (Integer.parseInt(kgconv));
        intkgconv = (intkgconv*2);
        temp = (int) Math.round(intkgconv);
        doublelbsconv = temp;
        temp = (temp/10);
        doublelbsconv = (doublelbsconv+temp);
        intlbsconv = (int) Math.round(doublelbsconv);
        lbsconv = (Integer.toString(intlbsconv));

    }

    public void convertlbstokg(){
        intlbsconv = (Integer.parseInt(lbsconv));
        doublelbsconv = (int) Math.round(intlbsconv);
        doublekgconv = (doublelbsconv/2.2);
        intkgconv = (int) Math.round(doublekgconv);
        kgconv = (Integer.toString(intkgconv));
    }

    public void conversion(){
        lbsbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (unitbp % 2==0){
                    if (CurrentBp.getText().toString().equals("")){

                    }else {
                        kgconv = CurrentBp.getText().toString();
                        convertKgtoLbs();
                        CurrentBp.setText(lbsconv);
                    }
                    unitbp = unitbp+1;
                    kgbp.setBackgroundResource(R.drawable.buttondark);
                    lbsbp.setBackgroundResource(R.drawable.buttonbackground);
                    lbsbp.setTypeface(null, Typeface.BOLD);
                    kgbp.setTypeface(null, Typeface.NORMAL);
                }
            }
        });
        kgbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitbp % 2!=0) {
                    if (CurrentBp.getText().toString().equals("")){

                    }else {
                        lbsconv = CurrentBp.getText().toString();
                        convertlbstokg();
                        CurrentBp.setText(kgconv);
                    }
                    lbsbp.setBackgroundResource(R.drawable.buttondark);
                    kgbp.setBackgroundResource(R.drawable.buttonbackground);
                    kgbp.setTypeface(null, Typeface.BOLD);
                    lbsbp.setTypeface(null, Typeface.NORMAL);
                    unitbp = unitbp+1;
                }
            }
        });

        lbsbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitbc % 2==0){
                    if (CurrentBc.getText().toString().equals("")){

                    }else {
                        kgconv = CurrentBc.getText().toString();
                        convertKgtoLbs();
                        CurrentBc.setText(lbsconv);
                    }
                    unitbc = unitbc+1;
                    kgbc.setBackgroundResource(R.drawable.buttondark);
                    lbsbc.setBackgroundResource(R.drawable.buttonbackground);
                    lbsbc.setTypeface(null, Typeface.BOLD);
                    kgbc.setTypeface(null, Typeface.NORMAL);
                }
            }
        });
        kgbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitbc % 2!=0) {
                    if (CurrentBc.getText().toString().equals("")){

                    }else {
                        lbsconv = CurrentBc.getText().toString();
                        convertlbstokg();
                        CurrentBc.setText(kgconv);
                    }
                    lbsbc.setBackgroundResource(R.drawable.buttondark);
                    kgbc.setBackgroundResource(R.drawable.buttonbackground);
                    kgbc.setTypeface(null, Typeface.BOLD);
                    lbsbp.setTypeface(null, Typeface.NORMAL);
                    unitbc = unitbc + 1;
                }
            }
        });

        lbssp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitsp % 2==0){
                    if (CurrentSp.getText().toString().equals("")){

                    }else {
                        kgconv = CurrentSp.getText().toString();
                        convertKgtoLbs();
                        CurrentSp.setText(lbsconv);
                    }
                    unitsp = unitsp+1;
                    kgsp.setBackgroundResource(R.drawable.buttondark);
                    lbssp.setBackgroundResource(R.drawable.buttonbackground);
                    lbssp.setTypeface(null, Typeface.BOLD);
                    kgsp.setTypeface(null, Typeface.NORMAL);
                }
            }
        });
        kgsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitsp % 2!=0) {
                    if (CurrentSp.getText().toString().equals("")){

                    }else {
                        lbsconv = CurrentSp.getText().toString();
                        convertlbstokg();
                        CurrentSp.setText(kgconv);
                    }
                    lbssp.setBackgroundResource(R.drawable.buttondark);
                    kgsp.setBackgroundResource(R.drawable.buttonbackground);
                    kgsp.setTypeface(null, Typeface.BOLD);
                    lbssp.setTypeface(null, Typeface.NORMAL);
                    unitsp = unitsp + 1;
                }
            }
        });

        lbswcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitwcu % 2==0){
                    if (CurrentWcu.getText().toString().equals("")){

                    }else {
                        kgconv = CurrentWcu.getText().toString();
                        convertKgtoLbs();
                        CurrentWcu.setText(lbsconv);
                    }
                    unitwcu = unitwcu+1;
                    kgwcu.setBackgroundResource(R.drawable.buttondark);
                    lbswcu.setBackgroundResource(R.drawable.buttonbackground);
                    lbswcu.setTypeface(null, Typeface.BOLD);
                    kgwcu.setTypeface(null, Typeface.NORMAL);
                }
            }
        });
        kgwcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitwcu % 2!=0) {
                    if (CurrentWcu.getText().toString().equals("")){

                    }else {
                        lbsconv = CurrentWcu.getText().toString();
                        convertlbstokg();
                        CurrentWcu.setText(kgconv);
                    }
                    lbswcu.setBackgroundResource(R.drawable.buttondark);
                    kgwcu.setBackgroundResource(R.drawable.buttonbackground);
                    kgwcu.setTypeface(null, Typeface.BOLD);
                    lbswcu.setTypeface(null, Typeface.NORMAL);
                    unitwcu = unitwcu + 1;
                }
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edt_cur_lifts);
        setbtns();
        cancelset();
        callcurbp();
        setCurBp();
        setSavebtn();
        setclickanims();
        plusButtonClicks();
        minusButtonClick();
        conversion();
    }
}
