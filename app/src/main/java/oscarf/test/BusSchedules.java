package oscarf.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BusSchedules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedules);

        // Create a LinearLayout in which to add the ImageView
        LinearLayout mLinearLayout = new LinearLayout(this);

        // Instantiate an ImageView and define its properties
        ImageView i = new ImageView(this);

        Intent intent = getIntent(); // gets the previously created intent
        String destination = intent.getStringExtra("destination");

        if(destination.equals("aluche") ){
            i.setImageResource(R.drawable.a_aluche);
        }
        else{
            i.setImageResource(R.drawable.a_fi);
        }

        i.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions

        // Add the ImageView to the layout and set the layout as the content view
        mLinearLayout.addView(i);
        setContentView(mLinearLayout);
    }
}
