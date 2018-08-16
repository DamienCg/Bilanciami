package com.damiencgprotonmail.bilanciami;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SettigActivity extends AppCompatActivity {
    private EditText var_Edit_risparmi;
    private EditText var_Edit_spesefisse;
    private EditText var_Edit_obiettivi;
    public static final String FILE_NAME_RISPARMI = "percrisparmi.txt";
    public static final String FILE_NAME_SF = "constsSF.txt";
    public static final String FILE_NAME_OBIETTIVI = "percobiettivi.txt";

/** E' presente molta ripetizione di codice sul salvare e leggere i vari file!!*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        Intent intent = getIntent();

        var_Edit_risparmi = findViewById(R.id.edit_percrisp);
        var_Edit_spesefisse = findViewById(R.id.editTextspesefisse);
        var_Edit_obiettivi = findViewById(R.id.editTextobiettivi);
        load(null);
        }

    public void save(View v){
        String text_risparmi = var_Edit_risparmi.getText().toString();
        String text_spesefisse = var_Edit_spesefisse.getText().toString();
        String text_obiettivi = var_Edit_obiettivi.getText().toString();
        FileOutputStream FOSRISPARMI = null;
        FileOutputStream FOSSPESEFISSE = null;
        FileOutputStream FOSOBIETTIVI = null;

        try {
            FOSRISPARMI = openFileOutput(FILE_NAME_RISPARMI, MODE_PRIVATE);
            FOSRISPARMI.write(text_risparmi.getBytes());

            FOSSPESEFISSE = openFileOutput(FILE_NAME_SF, MODE_PRIVATE);
            FOSSPESEFISSE.write(text_spesefisse.getBytes());

            FOSOBIETTIVI = openFileOutput(FILE_NAME_OBIETTIVI, MODE_PRIVATE);
            FOSOBIETTIVI.write(text_obiettivi.getBytes());


            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(FOSRISPARMI != null && FOSSPESEFISSE != null && FOSOBIETTIVI != null ){ /** non sicuro sulle && forse sono OR*/
                try{
                    FOSRISPARMI.close();
                    FOSSPESEFISSE.close();
                    FOSOBIETTIVI.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(View v){
        FileInputStream FISRISPARMI = null;
        FileInputStream FISSF = null;
        FileInputStream FISOBIETTIVI = null;

        try {
            FISRISPARMI = openFileInput(FILE_NAME_RISPARMI);
            InputStreamReader ISRISP = new InputStreamReader(FISRISPARMI);
            BufferedReader RISP = new BufferedReader(ISRISP);

            FISSF = openFileInput(FILE_NAME_SF);
            InputStreamReader ISSF = new InputStreamReader(FISSF);
            BufferedReader SF = new BufferedReader(ISSF);

            FISOBIETTIVI = openFileInput(FILE_NAME_OBIETTIVI);
            InputStreamReader ISOB = new InputStreamReader(FISOBIETTIVI);
            BufferedReader OB = new BufferedReader(ISOB);


            StringBuilder sbR = new StringBuilder();
            String textR;

            StringBuilder sbSF = new StringBuilder();
            String textSF;

            StringBuilder sbO = new StringBuilder();
            String textO;

            while((textR = RISP.readLine()) != null && (textSF = SF.readLine()) != null && (textO = OB.readLine()) != null){
                sbR.append(textR).append("\n");
                sbSF.append(textSF).append("\n");
                sbO.append(textO).append("\n");
            }

            var_Edit_risparmi.setText(sbR.toString());
            var_Edit_spesefisse.setText(sbSF.toString());
            var_Edit_obiettivi.setText(sbO.toString());

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            if(FISRISPARMI != null){
                try {
                    FISRISPARMI.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void reset(View v){
        var_Edit_risparmi.setText("");
        var_Edit_spesefisse.setText("");
        var_Edit_obiettivi.setText("");
        save(null);
    }
}
