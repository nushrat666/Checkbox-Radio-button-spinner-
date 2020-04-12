package com.tuli.checkboxradio_buttonspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String selectedLanguage="";
    private ArrayList<String>languages;
    private Spinner citySp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languages=new ArrayList<>();

        RadioGroup rg =findViewById(R.id.gender);

        RadioButton rb =findViewById(R.id.male);
        rb.setChecked(true);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb =findViewById(checkedId);
                String gender=rb.getText().toString();
            }
        });

        citySp=findViewById(R.id.citySP);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_dropdown_item,getcities()
        );
        citySp.setAdapter(adapter);

        citySp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void selectLanguage(View view) {
        CheckBox cb= (CheckBox) view;
        boolean status=cb.isChecked();

        selectedLanguage=cb.getText().toString();

        switch (view.getId()){
            case R.id.java:
                if(status){
                    languages.add(selectedLanguage);
                }else{
                    languages.remove(selectedLanguage);
                }
                break;
            case R.id.android:
                if(status){
                    languages.add(selectedLanguage);
                }else{
                    languages.remove(selectedLanguage);
                }
                break;
            case R.id.php:
                if(status){
                    languages.add(selectedLanguage);
                }else{
                    languages.remove(selectedLanguage);
                }
                break;
        }
        for (String s : languages){
            Log.e("languages", s );
        }
    }

    public ArrayList<String>getcities(){
        ArrayList<String>cities=new ArrayList<>();
        cities.add("Dhaka");
        cities.add("Chittagong");
        cities.add("Rajshahi");
        cities.add("Khulna");
        cities.add("Sylhet");
        return cities;
    }
}
