package oscarf.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loadButton = (Button)findViewById(R.id.loadButton);
        Button saveButton = (Button)findViewById(R.id.saveButton);
        Button escuelaButton = (Button)findViewById(R.id.escuelaButton);
        Button alucheButton = (Button)findViewById(R.id.alucheButton);
        final EditText textDisplay = (EditText)findViewById(R.id.textDisplay);

        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Saves the text in textDisplay
                editor.putString("SAVED_TEXT",textDisplay.getText().toString());
                editor.apply();
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loads saved text in textDisplay
                String savedText = sharedPref.getString("SAVED_TEXT", "");
                textDisplay.setText(savedText);
            }
        });

        escuelaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open new activity
                Intent intent = new Intent(MainActivity.this, BusSchedules.class);
                intent.putExtra("destination","escuela");
                startActivity(intent);
            }
        });

        alucheButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open new activity
                Intent intent = new Intent(MainActivity.this, BusSchedules.class);
                intent.putExtra("destination","aluche");
                startActivity(intent);
            }
        });
    }
}