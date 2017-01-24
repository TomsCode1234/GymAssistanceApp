package com.fujdevelopers.gymbro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GoalLifts extends AppCompatActivity {

    public int intgoalbp;
    public int intgoalbc;
    public int intgoalsp;
    public int intgoalwcu;
    public int intgoalwaist;

    public String stringgoalbp;
    public String stringgoalbc;
    public String stringgoalsp;
    public String stringgoalwcu;
    public String stringgoalwaist;

    public Button goalbp;
    public Button goalbc;
    public Button goalsp;
    public Button goalwcu;
    public Button goalWaist;

    public double temp;
    public Button kg;
    public Button lbs;
    public Button unit;
    public Button Waist;
    public String StringTemp;
    public int mes = 1;

    public void setform(){
        goalbc = (Button)findViewById(R.id.CurArms);
        goalbp = (Button)findViewById(R.id.GolChest);
        goalsp = (Button)findViewById(R.id.GolShoulder);
        goalwcu = (Button)findViewById(R.id.GolBack);
        goalWaist = (Button)findViewById(R.id.CurWaistValTxt);
        kg =(Button)findViewById(R.id.WeightKg);
        lbs = (Button)findViewById(R.id.button9);
        unit = (Button)findViewById(R.id.GolWaistUnitTxt);
    }

    public void setkgs(){

        kg.setBackgroundResource(R.drawable.buttonbackground);
        lbs.setBackgroundResource(R.drawable.buttondark);

        intgoalbc = (int) Math.round((Globals.bodyweight)*0.65);
        stringgoalbc = Integer.toString(intgoalbc);
        goalbc.setText(stringgoalbc + " Kgs");

        intgoalbp = (int) Math.round((Globals.bodyweight)*1.25);
        stringgoalbp = Integer.toString(intgoalbp);
        goalbp.setText(stringgoalbp + " Kgs");

        intgoalsp = (int) Math.round((Globals.bodyweight)*0.85);
        stringgoalsp = Integer.toString(intgoalsp);
        goalsp.setText(stringgoalsp + " Kgs");

        intgoalwcu = (int) Math.round((Globals.bodyweight)/2);
        stringgoalwcu = Integer.toString(intgoalwcu);
        goalwcu.setText(stringgoalwcu + " Kgs");
    }

    public void setlbs(){

        lbs.setBackgroundResource(R.drawable.buttonbackground);
        kg.setBackgroundResource(R.drawable.buttondark);

        temp = (((Globals.bodyweight)*0.65)*2);
        intgoalbc = (int) Math.round(temp);
        temp = (temp / 10);
        intgoalbc= intgoalbc + ((int) Math.round(temp));
        goalbc.setText(Integer.toString(intgoalbc)+" lbs");

        temp = (((Globals.bodyweight)*1.25)*2);
        intgoalbp = (int) Math.round(temp);
        temp = (temp / 10);
        intgoalbp= intgoalbp + ((int) Math.round(temp));
        goalbp.setText(Integer.toString(intgoalbp)+" lbs");

        temp = (((Globals.bodyweight)*0.85)*2);
        intgoalsp = (int) Math.round(temp);
        temp = (temp / 10);
        intgoalsp= intgoalsp + ((int) Math.round(temp));
        goalsp.setText(Integer.toString(intgoalsp)+" lbs");

        temp = (((Globals.bodyweight)/2)*2);
        intgoalwcu = (int) Math.round(temp);
        temp = (temp / 10);
        intgoalwcu= intgoalwcu + ((int) Math.round(temp));
        goalwcu.setText(Integer.toString(intgoalwcu)+" lbs");

    }
    public void clickListener(){

        lbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringgoalbc  = (goalbc.getText().toString());
                if (stringgoalbc.equals(Globals.curbc)){

                }else{

                    setlbs();

                }
            }
        });

        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (stringgoalbc.equals(Globals.curbc)){

                }else{
                    setkgs();
                }

            }
        });

        unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mes % 2==0){
                    mes = (mes+1);
                    unit.setText("CM");
                    intgoalwaist  = (int) Math.round(((Globals.height)*100)*0.43);
                    stringgoalwaist = Integer.toString(intgoalwaist);
                    intgoalwaist = (int) Math.round(((Globals.height)*100)*0.46);
                    stringgoalwaist = ((stringgoalwaist) + " - " + (Integer.toString(intgoalwaist)));
                    goalWaist.setText(stringgoalwaist);

                }else{
                    unit.setText("Inch");
                    mes = (mes+1);
                    intgoalwaist  = (int) Math.round((((Globals.height)*100)*0.43)*0.394);
                    stringgoalwaist = Integer.toString(intgoalwaist);
                    intgoalwaist = (int) Math.round((((Globals.height)*100)*0.46)*0.394);
                    stringgoalwaist = ((stringgoalwaist) + " - " + (Integer.toString(intgoalwaist)));
                    goalWaist.setText(stringgoalwaist);

                }
            }
        });

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_lifts);
        setform();
        setkgs();
        //
        unit.setText("CM");
        intgoalwaist  = (int) Math.round(((Globals.height)*100)*0.43);
        stringgoalwaist = Integer.toString(intgoalwaist);
        intgoalwaist = (int) Math.round(((Globals.height)*100)*0.46);
        stringgoalwaist = ((stringgoalwaist) + " - " + (Integer.toString(intgoalwaist)));
        goalWaist.setText(stringgoalwaist);
        //
        clickListener();

    }
}
