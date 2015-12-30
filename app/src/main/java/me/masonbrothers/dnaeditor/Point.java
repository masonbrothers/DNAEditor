package me.masonbrothers.dnaeditor;

/**
 * Created by mason on 08/12/15.
 */
public class Point {
    public double x;
    public double y;
    public double z;
    public Codon type;
    public double magnitudeFromOrgin()
    {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }
}
