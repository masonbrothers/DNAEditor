package me.masonbrothers.dnaeditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DNAClass dna;

    Spinner selectSpinner;
    EditText input;
    EditText output;
    Button goButton;
    String selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dna = new DNAClass();
        input = (EditText)findViewById(R.id.inputText);
        output = (EditText)findViewById(R.id.outputText);
        selectSpinner = (Spinner)findViewById(R.id.spinner);
        goButton = (Button)findViewById(R.id.goButton);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        selectSpinner.setAdapter(adapter);

        selectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();





            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                doStuff(selectedItem);
            }
        });

    }

    boolean updateSheet = false;

    public void doStuff(String item)
    {
        if (new String("editCodonSheet").equals(item)) {
            input.setText(dna.codonSheetString);
            updateSheet = true;
        } else if (updateSheet) {
            output.setText(dna.editCodonSheet(input.getText().toString()));
            input.setText("");
            updateSheet = false;
        }
        if (new String("toPeptide").equals(item)) {
            ArrayList<Codon> test = dna.getCodonSequence(0, input.getText().toString());
            char tempChar[] = new char[test.size()];
            //ArrayList<char> tempArray = new ArrayList<char>();

            for (int j = 0; j < test.size(); j++) {
                tempChar[j] = test.get(j).peptide;
            }
            output.setText(new String(tempChar));

        } else if (new String("flipString").equals(item)) {
            output.setText(dna.flipString(input.getText().toString()));
        } else if (new String("RNAtoDNA").equals(item)) {
            output.setText(dna.RNAtoDNA(input.getText().toString()));
        } else if (new String("DNAtoRNA").equals(item)) {
            output.setText(dna.DNAtoRNA(input.getText().toString()));
        } else if (new String("isDNA").equals(item)) {
            if (dna.isDNA(input.getText().toString()))
                output.setText("Yes");
            else
                output.setText("No");
        } else if (new String("isRNA").equals(item)) {
            if (dna.isRNA(input.getText().toString()))
                output.setText("Yes");
            else
                output.setText("No");
        } else if (new String("isPalindrome").equals(item)) {
            if (dna.isPalindrome(input.getText().toString().replaceAll("\\s+", "")))
                output.setText("Yes");
            else
                output.setText("No");
        } else if (new String("DNAantiCodon").equals(item)) {
            output.setText(dna.DNAantiCodon(input.getText().toString().replaceAll("\\s+", "")));
        } else if (new String("RNAantiCodon").equals(item)) {
            output.setText(dna.RNAantiCodon(input.getText().toString().replaceAll("\\s+", "")));
        } else if (new String("getFrames").equals(item)) {
            ArrayList<Frame> Frames = dna.getFrames(dna.RNAtoDNA(input.getText().toString().replaceAll("\\s+","")));
            output.setText("");
            for (int i = 0; i < Frames.size(); i++)
            {
                char charArray[] = new char[Frames.get(i).list.size()-1];
                for (int j = 0; j < Frames.get(i).list.size(); j++)
                {
                    if (!Frames.get(i).list.get(j).stop)
                        charArray[j] = Frames.get(i).list.get(j).peptide;
                }
                if (new String(output.getText().toString()).equals(""))
                    output.setText(new String(charArray) + " (" + Frames.get(i).startCodon + ", " + Frames.get(i).lastCodon +")");
                else
                    output.setText(output.getText().toString() + "\n" + new String(charArray) + " (" + Frames.get(i).startCodon + ", " + Frames.get(i).lastCodon +")");
            }
        } else if (new String("getReadingFrames").equals(item)) {
            ArrayList<Frame> Frames = dna.getReadingFrames(dna.RNAtoDNA(input.getText().toString().replaceAll("\\s+","")));
            output.setText("");
            for (int i = 0; i < Frames.size(); i++)
            {
                char charArray[] = new char[Frames.get(i).list.size()-1];
                for (int j = 0; j < Frames.get(i).list.size(); j++)
                {
                    if (!Frames.get(i).list.get(j).stop)
                        charArray[j] = Frames.get(i).list.get(j).peptide;
                }
                if (new String(output.getText().toString()).equals(""))
                    output.setText(new String(charArray) + " (" + Frames.get(i).startCodon + ", " + Frames.get(i).lastCodon +")");
                else
                    output.setText(output.getText().toString() + "\n" + new String(charArray) + " (" + Frames.get(i).startCodon + ", " + Frames.get(i).lastCodon +")");
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
