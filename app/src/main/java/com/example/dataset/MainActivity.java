package com.example.dataset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etPaintName;
    EditText etNotes;
    EditText etArtistName;
    EditText etYear;
    EditText etCountry;
    Button btDeleteAll;
    Button btExport;
    Button btNewPaint;
    String name, artist, year ,country, notes;
    private PaintViewModel paintViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPaintName = findViewById(R.id.etPaintName);
        etArtistName = findViewById(R.id.etArtistName);
        etYear = findViewById(R.id.etYear);
        etCountry = findViewById(R.id.etCountry);
        etNotes = findViewById(R.id.etNotes);
        btDeleteAll = findViewById(R.id.btDeleteAll);
        btExport = findViewById(R.id.btExport);
        btNewPaint = findViewById(R.id.btNewPaint);

        btNewPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etPaintName.getText().toString();
                artist = etArtistName.getText().toString();
                year = etYear.getText().toString();
                country = etCountry.getText().toString();
                notes = etNotes.getText().toString();
                Paint newPaint = new Paint(name,artist,year,country,notes);
                paintViewModel.insert(newPaint);
                Toast.makeText(
                        getApplicationContext(),
                        R.string.new_paint_add,
                        Toast.LENGTH_LONG).show();
            }
        });

    }



}