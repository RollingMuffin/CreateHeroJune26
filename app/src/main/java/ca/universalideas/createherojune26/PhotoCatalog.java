package ca.universalideas.createherojune26;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

public class PhotoCatalog extends AppCompatActivity {

    ArrayList<Product> arrayList;
    ListView lv;
    String description = "Select Main Features";
    EditText editText; //input get type
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_images);
        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView60Images);

        editText = (EditText) findViewById(R.id.editTextGetType);

        btn =(Button) findViewById(R.id.btnGetType);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namevalue = editText.getText().toString();

                Intent intent = new Intent(PhotoCatalog.this, SelectMainFeatures02.class);
                intent.putExtra("NAME", namevalue);
                intent.putExtra("DESCRIPTION", description);
                startActivity(intent);
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://depotof.universalideas.ca/product.php"); //product.php - Eng, productR.php - Rus
        }
        });
    }



    //public void onGetTypeClick(View view)
    //{
    //  if(view.getId() == R.id.btnGetType){
    //    Intent i = new Intent(PhotoCatalog.this, SelectMainFeatures02.class); //SelectMainFeatures02
    //  startActivity(i);
    // }
    //}

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

}
