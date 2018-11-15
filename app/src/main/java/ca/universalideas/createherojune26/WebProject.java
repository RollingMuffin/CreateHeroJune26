package ca.universalideas.createherojune26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class WebProject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_progect);
    }

    //Portrayal button
    public void onBackClick(View view)
    {
        if(view.getId() == R.id.btnBack){
            Intent i = new Intent(WebProject.this, ListdataActivity.class);
            startActivity(i);
        }
    }


}
