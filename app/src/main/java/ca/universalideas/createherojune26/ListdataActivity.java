package ca.universalideas.createherojune26;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListdataActivity extends AppCompatActivity {
    TextView name;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_listdata);
        setContentView(R.layout.activity_listdata);

        name = findViewById(R.id.listdata);
        image = findViewById(R.id.imageView);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
    }

    //Portrayal button
    public void onPortrayalClick(View view)
    {
        if(view.getId() == R.id.btnPortrayal){
            Intent i = new Intent(ListdataActivity.this, Portrayal.class);
            startActivity(i);
        }
    }

    //Biography button
    public void onBiographyClick(View view)
    {
        if(view.getId() == R.id.btnBiography){
            Intent i = new Intent(ListdataActivity.this, Biography.class);
            startActivity(i);
        }
    }

    //Psycological description button
    public void onPsychDClick(View view)
    {
        if(view.getId() == R.id.btnPsyhoD){
            Intent i = new Intent(ListdataActivity.this, PsychologicalDescription.class);
            startActivity(i);
        }
    }

    //Goals button
    public void onGoalsClick(View view)
    {
        if(view.getId() == R.id.btnGoals){
            Intent i = new Intent(ListdataActivity.this, Goals.class);
            startActivity(i);
        }
    }

    //Values button
    public void onValuesClick(View view)
    {
        if(view.getId() == R.id.btnValues){
            Intent i = new Intent(ListdataActivity.this, Values.class);
            startActivity(i);
        }
    }

    //Skeletons in the closet button
    public void onSkeletonsClick(View view)
    {
        if(view.getId() == R.id.btnSkeletons){
            Intent i = new Intent(ListdataActivity.this, Skeletons.class);
            startActivity(i);
        }
    }

    //Select all button
    public void onSelectAllMainFeaturesClick(View view)
    {
        if(view.getId() == R.id.btnSelectAllMainFeatures){
            Intent i = new Intent(ListdataActivity.this, SelectAllMainFeatures.class);
            startActivity(i);
        }
    }
    //Back button
    public void onBackClick(View view)
    {
        if(view.getId() == R.id.btnBack){
            Intent i = new Intent(ListdataActivity.this, PhotoCatalogInner.class);
            startActivity(i);
        }
    }
}
