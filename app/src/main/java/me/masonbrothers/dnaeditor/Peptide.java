package me.masonbrothers.dnaeditor;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mason on 08/12/15.
 */
public class Peptide {
    public Codon codon;
    public ArrayList<ThreeLettersCount> bases;
    public int countBases()
    {
        int number = 0;
        for (int i = 0; i < bases.size(); i++)
        {
            number += bases.get(i).number;
        }
        return number;
    }

    public ArrayList<ThreeLettersCount> IUPACBases;
    public int countIUPACBases()
    {
        int number = 0;
        for (int i = 0; i < bases.size(); i++)
        {
            number += IUPACBases.get(i).number;
        }
        return number;
    }

}


