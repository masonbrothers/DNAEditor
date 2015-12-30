package me.masonbrothers.dnaeditor;

import java.util.ArrayList;

/**
 * Created by mason on 08/12/15.
 */
public class Frame {
    public ArrayList<Codon> list;
    public int startCodon;
    public int lastCodon;
    public String codingDNA;
    public boolean error;
    public boolean doesBreak;
    public boolean marker;
}
