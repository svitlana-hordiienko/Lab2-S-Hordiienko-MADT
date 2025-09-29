package com.example.lab2_hordiienko_madt;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editText1;
    private Button countButton1;
    private Spinner spinner1;

    private final String[] countChoices = {
            "words",
            "characters",
            "sentences",
            "numbers"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.editText1 = findViewById(R.id.editText1);
        this.countButton1 = findViewById(R.id.countButton);
        this.spinner1 = findViewById(R.id.spinner1);

        spinner1.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                countChoices
        );

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        countButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String input = editText1.getText().toString();
                final int charCount = TextCounter.countCharacters(MainActivity.this, input);
                final int wordCount = TextCounter.countWords(MainActivity.this, input);
                final int sentenceCount = TextCounter.countSentences(MainActivity.this, input);
                final int numberCount = TextCounter.countNumbers(MainActivity.this, input);

//                if (spinner1.getSelectedItem().equals("words") && wordCount != 0) {
//                    Toast.makeText(getApplicationContext(), "Words: " + wordCount, Toast.LENGTH_LONG).show();
//                } else if (spinner1.getSelectedItem().equals("characters") && charCount != 0) {
//                    Toast.makeText(getApplicationContext(), "Characters: " + charCount, Toast.LENGTH_LONG).show();
//                }
                String selected = spinner1.getSelectedItem().toString();

                switch (selected) {
                    case "words":
                        if (wordCount != 0) {
                            Toast.makeText(getApplicationContext(), "Words: " + wordCount, Toast.LENGTH_LONG).show();
                        }
                    case "characters":
                        if (charCount != 0) {
                            Toast.makeText(getApplicationContext(), "Characters: " + charCount, Toast.LENGTH_LONG).show();
                        }
                    case "sentences":
                        if (sentenceCount != 0) {
                            Toast.makeText(getApplicationContext(), "Sentences: " + sentenceCount, Toast.LENGTH_LONG).show();
                        }
                    case "numbers":
                        if (numberCount != 0) {
                            Toast.makeText(getApplicationContext(), "Numbers: " + numberCount, Toast.LENGTH_LONG).show();
                        }
                    default:
                        Toast.makeText(getApplicationContext(), "Please select a valid option", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}