package com.fujdevelopers.gymbro;

import android.app.Application;

/**
 * Created by tomla on 05/01/2017.
 */

public class Globals extends Application{

    //current lifts
    public static double curbp;
    public static double curbc;
    public static double cursp;
    public static double curwcu;

    //stats
    public static double bodyweight;
    public static double height;
    public static double curwaist;

    //target lifts
    public static double targbp = (1.25*bodyweight);
    public static double targbc = (0.65*bodyweight);
    public static double targsp = (0.85*bodyweight);
    public static double targwcu = (bodyweight/2);
}
