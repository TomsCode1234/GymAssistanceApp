package com.fujdevelopers.gymbro;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CurLifts extends AppCompatActivity {

    public Button currBP;
    public Button currBC;
    public Button currSP;
    public Button currWCU;
    public Button currwaist;

    public String stringcurrBP;
    public String stringcurrBC;
    public String stringcurrSP;
    public String stringcurrWCU;
    public String stringcurrwaist;

    public int intcurrBP;
    public int intcurrBC;
    public int intcurrSP;
    public int intcurrWCU;
    public int intcurrwaist;

    public Button kgs;
    public Button lbs;
    public Button waistunit;

    public String metric = " Kgs";
    public String imperial = " lbs";
    public int inch = 1;
    public int temp;

    public void settext(){
        currBP = (Button)findViewById(R.id.Curchest);
        currBC = (Button)findViewById(R.id.CurArms);
        currSP = (Button)findViewById(R.id.CurShoulder);
        currWCU = (Button)findViewById(R.id.CurBack);
        currwaist = (Button)findViewById(R.id.CurWaistValTxt);
        waistunit = (Button)findViewById(R.id.CurWaistUnitTxt);
    }

    public void setcm(){
        intcurrwaist = (int) Math.round(Globals.curwaist);
        stringcurrwaist = (Integer.toString(intcurrwaist));
        currwaist.setText(stringcurrwaist);
        waistunit.setText("CM");
    }

    public void setinch(){
        intcurrwaist = (int) Math.round((Globals.curwaist)/2.54);
        stringcurrwaist = (Integer.toString(intcurrwaist));
        currwaist.setText(stringcurrwaist);
        waistunit.setText("INCH");

    }

    public void setkg(){
        intcurrBC = (int) Math.round(Globals.curbc);
        intcurrBP = (int) Math.round(Globals.curbp);
        intcurrSP = (int) Math.round(Globals.cursp);
        intcurrWCU = (int) Math.round(Globals.curwcu);


        stringcurrBC = (Integer.toString(intcurrBC)+ metric);
        stringcurrBP = (Integer.toString(intcurrBP)+ metric);
        stringcurrWCU = (Integer.toString(intcurrWCU)+ metric);
        stringcurrSP = (Integer.toString(intcurrSP)+ metric);

        currBP.setText(stringcurrBP);
        currBC.setText(stringcurrBC);
        currSP.setText(stringcurrSP);
        currWCU.setText(stringcurrWCU);
    }

    public void setlb(){
        temp=((intcurrBC * 2)/10);
        intcurrBC = (int) Math.round(((Globals.curbc)*2)+temp);
        temp=((intcurrBP * 2)/10);
        intcurrBP = (int) Math.round(((Globals.curbp)*2)+temp);
        temp= ((intcurrSP * 2)/10);
        intcurrSP = (int) Math.round(((Globals.cursp)*2)+temp);
        temp= ((intcurrWCU * 2)/10);
        intcurrWCU = (int) Math.round(((Globals.curwcu)*2)+temp);


        stringcurrBC = (Integer.toString(intcurrBC)+ imperial);
        stringcurrBP = (Integer.toString(intcurrBP)+ imperial);
        stringcurrWCU = (Integer.toString(intcurrWCU)+ imperial);
        stringcurrSP = (Integer.toString(intcurrSP)+ imperial);

        currBP.setText(stringcurrBP);
        currBC.setText(stringcurrBC);
        currSP.setText(stringcurrSP);
        currWCU.setText(stringcurrWCU);
    }

    public void setButtons(){
        kgs = (Button)findViewById(R.id.WeightKg);
        kgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    kgs.setTextSize(18);
                    kgs.setTypeface(null, Typeface.BOLD);
                    kgs.setBackgroundResource(R.drawable.newclickbutton);
                    lbs.setBackgroundResource(R.drawable.buttondark);
                    lbs.setTextSize(14);
                    lbs.setTypeface(null, Typeface.NORMAL);
                    setkg();
            }
        });


        lbs = (Button)findViewById(R.id.button9);
        lbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    kgs.setTextSize(14);
                    kgs.setTypeface(null, Typeface.NORMAL);
                    kgs.setBackgroundResource(R.drawable.buttondark);
                    lbs.setTextSize(18);
                    lbs.setTypeface(null, Typeface.BOLD);
                    lbs.setBackgroundResource(R.drawable.newclickbutton);
                    setlb();

            }
        });
    }

    public void setunits(){
        waistunit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inch = inch+1;
                if (inch % 2==0){
                    setcm();
                }
                if (inch % 2!=0){
                    setinch();
                }

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cur_lifts);
        settext();
        setkg();
        setButtons();
        kgs.setBackgroundResource(R.drawable.newclickbutton);
        lbs.setBackgroundResource(R.drawable.buttondark);
        waistunit.setBackgroundResource(R.drawable.newclickbutton);
        setinch();
        setunits();

    }
}
