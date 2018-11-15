package ca.universalideas.createherojune26;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class SelectMainFeatures02 extends AppCompatActivity {

    //Get Image with MySQL  START
    ArrayList<Product> arrayList;
    ListView lv;
    //Get Image with MySQL  END

    TextView tv, tv2; //tv1

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_select_main_features);

            //Get Image with MySQL  START
            arrayList = new ArrayList<>();
            lv = (ListView) findViewById(R.id.listViewOnlyImage);
            //Get Image with MySQL  END

            tv = (TextView) findViewById(R.id.textViewGType);
            //tv1 = (TextView) findViewById(R.id.textView3);
            tv2 = (TextView) findViewById(R.id.textView5);

            tv.setText(" "+getIntent().getStringExtra("NAME"));
            //tv1.setText("Try It");
            tv2.setText(getIntent().getStringExtra("DESCRIPTION"));
//Get Image with MySQL  START
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new ReadJSON().execute("http://depotof.universalideas.ca/sqlForSelectAllProperties.php"); //product.php - Eng, productR.php - Rus
                }
            });
            //Get Image with MySQL  END
        }


    //Get Image with MySQL  START
    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray =  jsonObject.getJSONArray("imagesHeroTypes");//"products"

                for(int i =0;i<jsonArray.length(); i++){
                    JSONObject productObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Product(
                            productObject.getString("heroImages"), //"image"
                            productObject.getString("tytleHero"), //"name"
                            productObject.getString("imHeroID") //"price"
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CustomListAdapter adapter = new CustomListAdapter( getApplicationContext(), R.layout.activity_for_images, arrayList );
            lv.setAdapter(adapter);
        }
    }

    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }


    //Get Image with MySQL  END


    //Portrayal button
    public void onPortrayalClick(View view)
    {
        if(view.getId() == R.id.btnPortrayal){
            Intent i = new Intent(SelectMainFeatures02.this, Portrayal.class);
            startActivity(i);
        }
    }

    //Biography button
    public void onBiographyClick(View view)
    {
        if(view.getId() == R.id.btnBiography){
            Intent i = new Intent(SelectMainFeatures02.this, Biography.class);
            startActivity(i);
        }
    }

    //Psycological description button
    public void onPsychDClick(View view)
    {
        if(view.getId() == R.id.btnPsyhoD){
            Intent i = new Intent(SelectMainFeatures02.this, PsychologicalDescription.class);
            startActivity(i);
        }
    }

    //Goals button
    public void onGoalsClick(View view)
    {
        if(view.getId() == R.id.btnGoals){
            Intent i = new Intent(SelectMainFeatures02.this, Goals.class);
            startActivity(i);
        }
    }

    //Values button
    public void onValuesClick(View view)
    {
        if(view.getId() == R.id.btnValues){
            Intent i = new Intent(SelectMainFeatures02.this, Values.class);
            startActivity(i);
        }
    }

    //Skeletons in the closet button
    public void onSkeletonsClick(View view)
    {
        if(view.getId() == R.id.btnSkeletons){
            Intent i = new Intent(SelectMainFeatures02.this, Skeletons.class);
            startActivity(i);
        }
    }

    //Select all button
    public void onSelectAllMainFeaturesClick(View view)
    {
        if(view.getId() == R.id.btnSelectAllMainFeatures){
            Intent i = new Intent(SelectMainFeatures02.this, SelectAllMainFeatures.class);
            startActivity(i);
        }
    }

    //Back button
    public void onBackClick(View view)
    {
        if(view.getId() == R.id.btnBack){
            Intent i = new Intent(SelectMainFeatures02.this, PhotoCatalog.class);
            startActivity(i);
        }
    }

}
