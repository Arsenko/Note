package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button commitBut;
    EditText noteET;
    private SharedPreferences noteSharedPref;
    private static String noteKey="note";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getInfoFromSharedPreferences();
    }
    public void init(){
        commitBut=findViewById(R.id.commitBut);
        noteET=findViewById(R.id.noteET);

        noteSharedPref=getSharedPreferences("NOTE",MODE_PRIVATE);


        commitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor myNoteEditor= noteSharedPref.edit();
                myNoteEditor.putString(noteKey,noteET.getText().toString());
                if(myNoteEditor.commit()) {
                    Toast.makeText(MainActivity.this, "Данные сохранены", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Данные не сохранены", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void getInfoFromSharedPreferences(){
        noteET.setText(noteSharedPref.getString(noteKey,""));
    }
}
