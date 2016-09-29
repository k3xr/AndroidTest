package oscarf.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button)findViewById(R.id.my_button);
        final TextView myText = (TextView)findViewById(R.id.textView);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                myText.setText(R.string.message);
            }
        });

        Button saveButton = (Button)findViewById(R.id.saveButton);
        final EditText textDisplay = (EditText)findViewById(R.id.textDisplay);

        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save text in textDisplay

                editor.putString("SAVED_TEXT",textDisplay.getText().toString());
                editor.commit();

            }
        });

        Button loadButton = (Button)findViewById(R.id.loadButton);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load saved text in textDisplay
                String savedText = sharedPref.getString("SAVED_TEXT", "");
                textDisplay.setText(savedText);

            }
        });

    }

    public void goTo2Button(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}