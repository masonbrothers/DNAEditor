package me.masonbrothers.dnaeditor;

import java.util.ArrayList;

/**
 * Created by mason on 07/12/15.
 */
public class DNAClass {

    public String codonSheetString;

    public ArrayList<Codon> codonSheet = new ArrayList<Codon>();

    public boolean error;

    public String editCodonSheet(String codonSheetString)
    {
        codonSheet.clear();
        String[] lines = codonSheetString.split("\n");

        for (int i = 1; i < lines.length; i++) {
            codonSheet.add(getCodonFromLine(lines[i]));
        }
        return codonSheetString;
    }

    DNAClass()
    {
        codonSheetString = "DNA Codon\tPeptide Letter\tPeptide Name\tPeptide 3L\tSpecial\tStart\tStop\t\"Acidic=1, Basic =2, Polar=3, Non-Polar= 4\"\tBond Length\tBond Angle\n" +
                "TTT\tF\tPhenylalanine\tPhe\t0\t0\t0\t4\t0\t0\n" +
                "TTC\tF\tPhenylalanine\tPhe\t0\t0\t0\t4\t0\t0\n" +
                "TTA\tL\tLecucine\tLeu\t0\t0\t0\t4\t0\t0\n" +
                "TTG\tL\tLecucine\tLeu\t0\t0\t0\t4\t0\t0\n" +
                "CTT\tL\tLecucine\tLeu\t0\t0\t0\t4\t0\t0\n" +
                "CTC\tL\tLecucine\tLeu\t0\t0\t0\t4\t0\t0\n" +
                "CTA\tL\tLecucine\tLeu\t0\t0\t0\t4\t0\t0\n" +
                "CTG\tL\tLecucine\tLeu\t0\t0\t0\t4\t0\t0\n" +
                "ATT\tI\tIsoleucine\tIle\t0\t0\t0\t4\t0\t0\n" +
                "ATC\tI\tIsoleucine\tIle\t0\t0\t0\t4\t0\t0\n" +
                "ATA\tI\tIsoleucine\tIle\t0\t0\t0\t4\t0\t0\n" +
                "ATG\tM\tMethionine\tMet\t0\t1\t0\t4\t0\t0\n" +
                "GTT\tV\tValine\tVal\t0\t0\t0\t4\t0\t0\n" +
                "GTC\tV\tValine\tVal\t0\t0\t0\t4\t0\t0\n" +
                "GTA\tV\tValine\tVal\t0\t0\t0\t4\t0\t0\n" +
                "GTG\tV\tValine\tVal\t0\t0\t0\t4\t0\t0\n" +
                "TCT\tS\tSerine\tSer\t0\t0\t0\t3\t0\t0\n" +
                "TCC\tS\tSerine\tSer\t0\t0\t0\t3\t0\t0\n" +
                "TCA\tS\tSerine\tSer\t0\t0\t0\t3\t0\t0\n" +
                "TCG\tS\tSerine\tSer\t0\t0\t0\t3\t0\t0\n" +
                "CCT\tP\tProline\tPro\t0\t0\t0\t4\t0\t0\n" +
                "CCC\tP\tProline\tPro\t0\t0\t0\t4\t0\t0\n" +
                "CCA\tP\tProline\tPro\t0\t0\t0\t4\t0\t0\n" +
                "CCG\tP\tProline\tPro\t0\t0\t0\t4\t0\t0\n" +
                "ACT\tT\tThreonine\tThr\t0\t0\t0\t3\t0\t0\n" +
                "ACC\tT\tThreonine\tThr\t0\t0\t0\t3\t0\t0\n" +
                "ACA\tT\tThreonine\tThr\t0\t0\t0\t3\t0\t0\n" +
                "ACG\tT\tThreonine\tThr\t0\t0\t0\t3\t0\t0\n" +
                "GCT\tA\tAlanine\tAla\t0\t0\t0\t4\t0\t0\n" +
                "GCC\tA\tAlanine\tAla\t0\t0\t0\t4\t0\t0\n" +
                "GCA\tA\tAlanine\tAla\t0\t0\t0\t4\t0\t0\n" +
                "GCG\tA\tAlanine\tAla\t0\t0\t0\t4\t0\t0\n" +
                "TAT\tY\tTyrosine\tTyr\t0\t0\t0\t3\t0\t0\n" +
                "TAC\tY\tTyrosine\tTyr\t0\t0\t0\t3\t0\t0\n" +
                "TAA\tn\tStop(Ochre)\tNul\t0\t0\t1\t0\t0\t0\n" +
                "TAG\tn\tStop(Amber)\tNul\t0\t0\t1\t0\t0\t0\n" +
                "CAT\tH\tHistidine\tHis\t0\t0\t0\t2\t0\t0\n" +
                "CAC\tH\tHistidine\tHis\t0\t0\t0\t2\t0\t0\n" +
                "CAA\tQ\tGlutamine\tGln\t0\t0\t0\t3\t0\t0\n" +
                "CAG\tQ\tGlutamine\tGln\t0\t0\t0\t3\t0\t0\n" +
                "AAT\tN\tAsparagine\tAsn\t0\t0\t0\t3\t0\t0\n" +
                "AAC\tN\tAsparagine\tAsn\t0\t0\t0\t3\t0\t0\n" +
                "AAA\tK\tLysine\tLys\t0\t0\t0\t2\t0\t0\n" +
                "AAG\tK\tLysine\tLys\t0\t0\t0\t2\t0\t0\n" +
                "GAT\tD\tAspartic_Acid\tAsp\t0\t0\t0\t1\t0\t0\n" +
                "GAC\tD\tAspartic_Acid\tAsp\t0\t0\t0\t1\t0\t0\n" +
                "GAA\tE\tGlutamic_Acid\tGlu\t0\t0\t0\t1\t0\t0\n" +
                "GAG\tE\tGlutamic_Acid\tGlu\t0\t0\t0\t1\t0\t0\n" +
                "TGT\tC\tCysteine\tCys\t0\t0\t0\t3\t0\t0\n" +
                "TGC\tC\tCysteine\tCys\t0\t0\t0\t3\t0\t0\n" +
                "TGA\tn\tStop(Opal)\tNul\t0\t0\t1\t0\t0\t0\n" +
                "TGG\tW\tTryptophan\tTrp\t0\t0\t0\t4\t0\t0\n" +
                "CGT\tR\tArginine\tArg\t0\t0\t0\t2\t0\t0\n" +
                "CGC\tR\tArginine\tArg\t0\t0\t0\t2\t0\t0\n" +
                "CGA\tR\tArginine\tArg\t0\t0\t0\t2\t0\t0\n" +
                "CGG\tR\tArginine\tArg\t0\t0\t0\t2\t0\t0\n" +
                "AGT\tS\tSerine\tSer\t0\t0\t0\t3\t0\t0\n" +
                "AGC\tS\tSerine\tSer\t0\t0\t0\t3\t0\t0\n" +
                "AGA\tR\tArginine\tArg\t0\t0\t0\t2\t0\t0\n" +
                "AGG\tR\tArginine\tArg\t0\t0\t0\t2\t0\t0\n" +
                "GGT\tG\tGlycine\tGly\t0\t0\t0\t1\t0\t0\n" +
                "GGC\tG\tGlycine\tGly\t0\t0\t0\t1\t0\t0\n" +
                "GGA\tG\tGlycine\tGly\t0\t0\t0\t1\t0\t0\n" +
                "GGG\tG\tGlycine\tGly\t0\t0\t0\t1\t0\t0";

        error = false;

        String[] lines = codonSheetString.split("\n");

        for (int i = 1; i < lines.length; i++)
        {
            codonSheet.add(getCodonFromLine(lines[i]));
        }

    }



    ArrayList<Frame> getFrames(String DNA)
    {
        ArrayList<Frame> Frames = new ArrayList<Frame>();
        for (int j = 0; j < DNA.length();)
        {
            int startCodon = findStartCodon(DNA, j);
            if (startCodon == -1)
            {
                break;
            }

            //String codingDNA;
            boolean doesBreak = false;
            int lastCodon;
            ArrayList<Codon> list = getCodonSequence(startCodon, DNA);



            // ToDo: Make the Stop codon part of the termination.
            //

            if (list.get(list.size()-1).stop != true)
                break;




            Frame tmpFrame = new Frame();
            //tmpFrame.codingDNA = codingDNA;
            tmpFrame.startCodon = startCodon;
            tmpFrame.lastCodon = list.size()*3+startCodon-1;
            tmpFrame.error = error;
            tmpFrame.doesBreak = doesBreak;
            tmpFrame.list = list;
            Frames.add(tmpFrame);
            j = startCodon + 1;
        }
        return Frames;
    }


    public int findStartCodon(String DNA, int start)
    {
        if (DNA.length() < 2)
        {
            return -1;
        }
        for (int i = start; i < DNA.length() - 2; i++)
        {
            char tmp [] = new char[3];
            tmp[0] = DNA.charAt(i);
            tmp[1] = DNA.charAt(i + 1);
            tmp[2] = DNA.charAt(i + 2);
            for (int j = 0; j < codonSheet.size(); j++)
            {
                if ((new String(tmp).equals(codonSheet.get(j).bases)) && codonSheet.get(j).start)
                {
                    return i;
                }
            }
        }
        return -1;
    }


    public ArrayList<Codon> getCodonSequence(int startCodon, String DNA)
    {
        /*
            ToDo:
            make startCodon, lastCodon, codingDNA

         */
        ArrayList<Codon> list = new ArrayList<Codon>();
        char DNAarray[] = new char[DNA.length()];
        for (int i = startCodon; i < DNA.length() - 2; i = i + 3)
        {
            char tmpBases[] = new char[3];
            if (i + 2 >= DNA.length() || error == true)
            {
                error = true;
                break;
            }
            tmpBases[0] = DNA.charAt(i);
            tmpBases[1] = DNA.charAt(i + 1);
            tmpBases[2] = DNA.charAt(i + 2);

            //Log.i("TAGSTER", new String(tmpBases));
            Codon tmpCodon = new Codon();

            for (int j = 0; j < codonSheet.size(); j++)
            {
                if (new String(tmpBases).equals(codonSheet.get(j).bases))
                {
                    tmpCodon = codonSheet.get(j);

                }
                //Log.i("TAGSTER", codonSheet.get(i).bases);
            }

            if (tmpCodon.stop == true)
            {
                //codingDNA.append(tmpCodon.bases);
                list.add(tmpCodon);
                break;
            }
            list.add(tmpCodon);
            //codingDNA.add(tmpBases);
            //lastCodon = i + 5;
        }
	/*
	for (int i = startCodon; i <= lastCodon; i++)
	{
		codingDNA.push_back(DNA.at(i));
	}
	*/
        return list;
    }




    boolean isSubset(char large, char small)
    {
        boolean subset = false;
        if (large == small)
        {
            subset = true;
        }
        else if ((small == 'T' || small == 'U') && (large == 'T' || large == 'U'))
        {
            subset = true;
        }
        else if (small == 'C' && (large == 'S' || large == 'M' || large == 'Y' || large == 'B' || large == 'H' || large == 'V' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'A' && (large == 'W' || large == 'M' || large == 'R' || large == 'D' || large == 'H' || large == 'V' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'G' && (large == 'S' || large == 'K' || large == 'R' || large == 'B' || large == 'D' || large == 'V' || large == 'N'))
        {
            subset = true;
        }
        else if ((small == 'T' || small == 'U') && (large == 'W' || large == 'K' || large == 'Y' || large == 'B' || large == 'D' || large == 'H' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'W' && (large == 'D' || large == 'H' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'S' && (large == 'B' || large == 'V' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'M' && (large == 'H' || large == 'V' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'K' && (large == 'B' || large == 'D' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'R' && (large == 'D' || large == 'V' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'Y' && (large == 'B' || large == 'H' || large == 'N'))
        {
            subset = true;
        }
        else if (small == 'B' && large == 'N')
        {
            subset = true;
        }
        else if (small == 'D' && large == 'N')
        {
            subset = true;
        }
        else if (small == 'H' && large == 'N')
        {
            subset = true;
        }
        else if (small == 'V' && large == 'N')
        {
            subset = true;
        }
        return subset;
    }








    public boolean isDNA(String DNA)
    {
        for (int i = 0; i < DNA.length(); i++)
        {
            if (!(DNA.charAt(i) == 'A' || DNA.charAt(i) == 'T' || DNA.charAt(i) == 'C' || DNA.charAt(i) == 'G')) {
                return false;
            }
        }
        return true;
    }

    public boolean isRNA(String RNA)
    {
        for (int i = 0; i < RNA.length(); i++)
        {
            if (!(RNA.charAt(i) == 'A' || RNA.charAt(i) == 'U' || RNA.charAt(i) == 'C' || RNA.charAt(i) == 'G')) {
                return false;
            }
        }
        return true;
    }

    public String DNAtoRNA(String DNA)
    {
        char charArray[] = new char[DNA.length()];

        for (int i = 0; i < DNA.length(); i++)
        {
            if (DNA.charAt(i) == 'T')
            {
                charArray[i] = 'U';
            }
            else
            {
                charArray[i] = DNA.charAt(i);
            }

        }
        String temp = new String(charArray);
        return temp;
    }

    public String RNAtoDNA(String RNA)
    {
        char charArray[] = new char[RNA.length()];

        for (int i = 0; i < RNA.length(); i++)
        {
            if (RNA.charAt(i) == 'U')
            {
                charArray[i] = 'T';
            }
            else
            {
                charArray[i] = RNA.charAt(i);
            }

        }
        String temp = new String(charArray);
        return temp;
    }

    public String flipString(String input)
    {
        String output = new StringBuilder(input).reverse().toString();
        return output;
    }

    public boolean isPalindrome(String input)
    {
        if (RNAtoDNA(input).equals(flipString(DNAantiCodon(input))))
            return true;
        return false;

        /*
        for (int i = 0; i < input.length()/2; i++)
        {
            Log.i("TAGSTER", DNAantiCodon(input.charAt(i)+"") + RNAtoDNA(input.charAt(input.length()-1-i)+""));
            if (RNAtoDNA(input.charAt(input.length() - 1 - i) + "").equals(DNAantiCodon(input.charAt(i) + "")))
                return false;
        }
        return true; */
    }

    /*
    public boolean isPalindrome(String input)
    {
        for (int i = 0; i < input.length()/2; i++)
        {
            if (input.charAt(i) != input.charAt(input.length()-1-i))
                return false;
        }
        return true;
    }
    */


    public ArrayList<Frame> getReadingFrames(String DNA, int minimumSize)
    {
        ArrayList<Frame> frames = getFrames(DNA);
        for (int i = 0; i < frames.size(); i++)
        {
            frames.get(i).marker = false;
        }
        ArrayList<Frame> reverse = getFrames(DNAantiCodon(flipString(DNA)));
        for (int i = 0; i < reverse.size(); i++) {
            reverse.get(i).marker = true;
            reverse.get(i).startCodon = DNA.length() - reverse.get(i).startCodon - 1;
            reverse.get(i).lastCodon = DNA.length() - reverse.get(i).lastCodon - 1;
        }
        frames.addAll(reverse);
        if (minimumSize==0)
            return frames;
        for (int i = 0; i < frames.size(); i++)
        {
            if (minimumSize > frames.get(i).list.size())
                frames.remove(i);
        }
        return frames;
    }

    public ArrayList<Frame> getReadingFrames(String DNA)
    {
        return getReadingFrames(DNA, 0);
    }

    public String DNAantiCodon(String DNA)
    {
        boolean IUPAC = false;
        boolean basic = true;
        char output[] = new char[DNA.length()];
        for (int i = 0; i < DNA.length(); i++)
        {
            if (DNA.charAt(i) == 'A' && IUPAC == false)
            {
                output[i] = 'T';
            }
            else if ((DNA.charAt(i) == 'T' || DNA.charAt(i) == 'U') && IUPAC == false)
            {
                output[i] = 'A';
            }
            else if (DNA.charAt(i) == 'C' && IUPAC == false)
            {
                output[i] = 'G';
            }
            else if (DNA.charAt(i) == 'G' && IUPAC == false)
            {
                output[i] = 'C';
            }
            else if (DNA.charAt(i) == 'W')
            {
                output[i] = 'S';
                basic = false;
            }
            else if (DNA.charAt(i) == 'S')
            {
                output[i] = 'W';
                basic = false;
            }
            else if (DNA.charAt(i) == 'M')
            {
                output[i] = 'K';
                basic = false;
            }
            else if (DNA.charAt(i) == 'K')
            {
                output[i] = 'M';
                basic = false;
            }
            else if (DNA.charAt(i) == 'R')
            {
                output[i] = 'Y';
                basic = false;
            }
            else if (DNA.charAt(i) == 'Y')
            {
                output[i] = 'R';
                basic = false;
            }
            else if (DNA.charAt(i) == 'B')
            {
                output[i] = 'A';
                basic = false;
            }
            else if (DNA.charAt(i) == 'D')
            {
                output[i] = 'C';
                basic = false;
            }
            else if (DNA.charAt(i) == 'H')
            {
                output[i] = 'G';
                basic = false;
            }
            else if (DNA.charAt(i) == 'V')
            {
                output[i] = 'T';
                basic = false;
            }
            else if (DNA.charAt(i) == 'A')
            {
                output[i] = 'B';
                basic = false;
            }
            else if (DNA.charAt(i) == 'C')
            {
                output[i] = 'D';
                basic = false;
            }
            else if (DNA.charAt(i) == 'G')
            {
                output[i] = 'H';
                basic = false;
            }
            else if (DNA.charAt(i) == 'T')
            {
                output[i] = 'V';
                basic = false;
            }
        }
        String temp = new String(output);
        return temp;
    }

    public String RNAantiCodon(String RNA)
    {
        boolean IUPAC = false;
        boolean basic = true;
        char output[] = new char[RNA.length()];
        for (int i = 0; i < RNA.length(); i++)
        {
            if (RNA.charAt(i) == 'A' && IUPAC == false)
            {
                output[i] = 'U';
            }
            else if ((RNA.charAt(i) == 'T' || RNA.charAt(i) == 'U') && IUPAC == false)
            {
                output[i] = 'A';
            }
            else if (RNA.charAt(i) == 'C' && IUPAC == false)
            {
                output[i] = 'G';
            }
            else if (RNA.charAt(i) == 'G' && IUPAC == false)
            {
                output[i] = 'C';
            }
            else if (RNA.charAt(i) == 'W')
            {
                output[i] = 'S';
                basic = false;
            }
            else if (RNA.charAt(i) == 'S')
            {
                output[i] = 'W';
                basic = false;
            }
            else if (RNA.charAt(i) == 'M')
            {
                output[i] = 'K';
                basic = false;
            }
            else if (RNA.charAt(i) == 'K')
            {
                output[i] = 'M';
                basic = false;
            }
            else if (RNA.charAt(i) == 'R')
            {
                output[i] = 'Y';
                basic = false;
            }
            else if (RNA.charAt(i) == 'Y')
            {
                output[i] = 'R';
                basic = false;
            }
            else if (RNA.charAt(i) == 'B')
            {
                output[i] = 'A';
                basic = false;
            }
            else if (RNA.charAt(i) == 'D')
            {
                output[i] = 'C';
                basic = false;
            }
            else if (RNA.charAt(i) == 'H')
            {
                output[i] = 'G';
                basic = false;
            }
            else if (RNA.charAt(i) == 'V')
            {
                output[i] = 'T';
                basic = false;
            }
            else if (RNA.charAt(i) == 'A')
            {
                output[i] = 'B';
                basic = false;
            }
            else if (RNA.charAt(i) == 'C')
            {
                output[i] = 'D';
                basic = false;
            }
            else if (RNA.charAt(i) == 'G')
            {
                output[i] = 'H';
                basic = false;
            }
            else if (RNA.charAt(i) == 'T')
            {
                output[i] = 'V';
                basic = false;
            }
        }
        String temp = new String(output);
        return temp;
    }

    //public ArrayList<Codon>

    private Codon getCodonFromLine(String line)
    {
        Codon codon = new Codon();
        String[] parts = line.split("\t");
        if (parts.length >= 0)
            codon.bases = parts[0];
        if (parts.length >= 1)
            codon.peptide = parts[1].charAt(0);
        if (parts.length >= 2)
            codon.peptideName = parts[2];
        if (parts.length >= 3)
            codon.peptide3l = parts[3];
        if (parts.length >= 4)
            codon.special = (parts[4].charAt(0) != '0');
        if (parts.length >= 5)
            codon.start = (parts[5].charAt(0) != '0');
        if (parts.length >= 6)
            codon.stop = (parts[6].charAt(0) != '0');
        if (parts.length >= 7)
            codon.type = Integer.parseInt(parts[7]);
        if (parts.length >= 8)
            codon.bondLength = Double.parseDouble(parts[8]);
        if (parts.length >= 9)
            codon.bondAngle = Double.parseDouble(parts[9]);

        return codon;
    }





    double measureDistance(Point point1, Point point2)
    {
        double distance;
        distance = Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2) + Math.pow(point1.z-point2.z,2));
        return distance;
    }

    Point translate(Point input, double x, double y, double z)
    {
        Point output = new Point();
        output.x=input.x+x;
        output.y=input.y+y;
        output.z=input.z+z;
        return output;
    }

    Point stretch(Point input, double x, double y, double z)
    {
        Point output = new Point();
        output.x=input.x*x;
        output.y=input.y*y;
        output.z=input.z*z;
        return output;
    }

    Point rotate_x(Point input, double angle)
    {
        Point output = new Point();
        output.x=input.x;
        output.y=input.y*Math.cos(angle)-input.z*Math.sin(angle);
        output.z=input.z*Math.cos(angle)+input.y*Math.sin(angle);
        return output;
    }

    Point rotate_y(Point input, double angle)
    {
        Point output = new Point();
        output.x=input.x*Math.cos(angle)+input.z*Math.sin(angle);
        output.y=input.y;
        output.z=input.z*Math.cos(angle)-input.x*Math.sin(angle);
        return output;
    }

    Point rotate_z(Point input, double angle)
    {
        Point output = new Point();
        output.x=input.x*Math.cos(angle)-input.y*Math.sin(angle);
        output.y=input.y*Math.cos(angle)+input.x*Math.sin(angle);
        output.z=input.z;
        return output;
    }

    double measureAngle(Point point1, Point point2, Point point3)
    {
        double distance_A = measureDistance(point1, point2);
        double x_A = point2.x-point1.x;
        double y_A = point2.y-point1.y;
        double z_A = point2.z-point1.z;


        double distance_B = measureDistance(point3, point2);
        double x_B = point2.x-point3.x;
        double y_B = point2.y-point3.y;
        double z_B = point2.z-point3.z;

        double dotProduct;
        dotProduct = x_A*x_B + y_A*y_B + z_A*z_B;

        double cosineOfAngle = dotProduct/(distance_A*distance_B);

        if (cosineOfAngle < -1)
        {
            cosineOfAngle = -1;
        }
        if (cosineOfAngle > 1)
        {
            cosineOfAngle = 1;
        }
        double angle = Math.acos(cosineOfAngle); //In radians
        //angle = angle*180/3.14159265359; //Converts to Degrees
        return angle;
    }


    /*
    private ArrayList<Codon> setupCodonSheet()
    {

    }
    */
}
