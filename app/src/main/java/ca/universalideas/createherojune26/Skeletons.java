package ca.universalideas.createherojune26;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
//START import for MySQL
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

//END import for MySQL

public class Skeletons extends AppCompatActivity {
    //START MySQL code
    ListView listView;
    ArrayAdapter<String> adapter;
    //END MySQL code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skeleton);

        //START MySQL code
        listView = (ListView)findViewById(R.id.listView60ImagesValuesSkelet);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        new ConnectionSkelet().execute();
        //END MySQL code
    }

    //Start MySQL code

    class ConnectionSkelet extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            String result ="";

            String host = "http://depotof.universalideas.ca/cars.php";
            try{


                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(host));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer stringBuffer = new StringBuffer("");

                String line ="";
                while ((line = reader.readLine()) !=null){
                    stringBuffer.append(line);
                    break;
                }
                reader.close();
                result = stringBuffer.toString();
            }
            catch (Exception e){
                return new String("There exception: " + e.getMessage());
            }


            return result;
        }
        @Override
        protected void onPostExecute(String result){
            //parsing json data here
            try {
                JSONObject jsonResult = new JSONObject(result);
                int success = jsonResult.getInt("success");
                if(success ==1) {
                    JSONArray cars = jsonResult.getJSONArray("cars");         // from MySQL     change "cars" - table name
                    for(int i=0; i<cars.length(); i++){   // change "cars" - table name
                        JSONObject car = cars.getJSONObject(i);     // from MySQL     change "car, cars"
                        int ID = car.getInt("id");          // from MySQL
                        String name = car.getString("name");  // from MySQL
                        String nationality = car.getString("nationality");  // from MySQL
                        String age = car.getString("age");  // from MySQL
                        String bodytype = car.getString("bodytype");  // from MySQL
                        //added
                        String colorHaer = car.getString("colorHaer");  // from MySQL
                        String colorEye = car.getString("colorEye");  // from MySQL
                        String faceShape = car.getString("faceShape");  // from MySQL
                        //end added

                        String line = ID + "   " + name + " " + nationality + " If you ask him about his age, he will answer that   " + age + "    " + bodytype + "   " + colorHaer +  "   " +  colorEye + "   " + faceShape ;  // from MySQL
                        //String line = name;

                        adapter.add(line);
                        //adapter.add("   ");
                    }

                    Toast.makeText(getApplicationContext(), "OK there are records", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "There are not records yet", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                //e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    //END MySQL code
    //Back button
    public void onBackClick(View view)
    {
        if(view.getId() == R.id.btnBack){
            Intent i = new Intent(Skeletons.this, ListdataActivity.class);
            startActivity(i);
        }
    }

    //Get New Pattern button
    public void onNewPatternClick(View view)
    {
        if(view.getId() == R.id.btnNewPattern){
            Intent i = new Intent(Skeletons.this, Skeletons.class); // create new SELECT
            startActivity(i);
        }
    }

    //Save in your project button

    public void onSaveWebPageClick(View view)
    {
        if(view.getId() == R.id.btnSaveWebPage){
            Intent i = new Intent(Skeletons.this, WebProject.class); // create new SELECT
            startActivity(i);
        }
    }


    //Buy button
    public void onBuyPortrayalClick(View view)
    {
        if(view.getId() == R.id.btnBuyPortRayal){
            Intent i = new Intent(Skeletons.this, Cart.class);
            startActivity(i);
        }
    }

}