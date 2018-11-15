package ca.universalideas.createherojune26;

import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;



public class SelectTypeCharacter extends AppCompatActivity implements View.OnClickListener{

    ViewFlipper viewFlipper;
    Button next;
    Button previous;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_character_01);

       // viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper); // define Flipper
        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
     }




    @Override
    public void onClick(View v) {
        if (v == next) {
   //         viewFlipper.showNext();
        }
        else if (v == previous) {
            viewFlipper.showPrevious();
        }
    }

    public void onGetTypeClick(View view)
    {
        if(view.getId() == R.id.btnGetType){
            Intent i = new Intent(SelectTypeCharacter.this, SelectMainFeatures02.class); //SelectMainFeatures02
            startActivity(i);
        }
    }

}


