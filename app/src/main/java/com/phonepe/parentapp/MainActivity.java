package com.phonepe.parentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        editText.setText(DataStorage.getText());
    }

    public void saveText(View view) {
        String text = editText.getText().toString();
        DataStorage.saveText(text);
        Toast.makeText(this, "Saved: "+text, Toast.LENGTH_SHORT).show();
    }
}
