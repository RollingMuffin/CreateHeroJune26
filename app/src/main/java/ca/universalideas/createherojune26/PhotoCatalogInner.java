package ca.universalideas.createherojune26;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PhotoCatalogInner extends AppCompatActivity {
    ListView listView;

    String[] fruitNames = {"Man in Action", "Woman in Action", "Brutal man", "Brutal woman", "Man in Charge",
            "Woman in Charge", "Caregiver-Man", "Caregiver-Woman", "Center of influence - Man", "Center of influence - Woman",
            "Companion - Man", "Companion - Woman", "Conformist - Man", "Conformist - Woman", "Distracted - Man",
            "Distracted - Woman", "Evil Genius - Man", "Evil Genius - Woman", "Evil King", "Evil Genius Queen",
            "Expert - Man", "Expert - Woman", "Fatal Man", "Fatal Woman", "Fighter Man", "Fighter Woman", "Insider Man",
            "Insider Woman", "Know-it-all Man", "Know-it-all Woman", "Lostcause - Man", "Lostcause - Woman", "Misguided visionary - Man",
            "Misguided visionary - Woman", "Opportunist - Man", "Opportunist - Woman", "Outsider - Man", "Outsider - Woman", "Playboy",
            "Player - Man", "Player - Woman", "Ray of sunshine - Man", "Ray of sunshine - Woman", "Rebel - Man", "Rebel - Woman",
            "Man in Red", "Woman in Red", "Saboteur - Man", "Saboteur - Woman", "Standard bearer - Man", "Standard bearer - Woman",
            "Table for one - Man", "Table for one - Woman", "Teammate - Man", "Teammate - Woman", "Tyrant - Man", "Tyrant - Woman",
            "Valedictorian - Man", "Valedictorian - Woman"};
    int[] fruitImages = {R.drawable.actionfigure_m, R.drawable.actionfigure_w,  R.drawable.brute_m, R.drawable.brute_w,
            R.drawable.charge_m, R.drawable.charge_w, R.drawable.caregiver_m, R.drawable.caregiver_w, R.drawable.centerofinfluence_m,
            R.drawable.centerofinfluence_w, R.drawable.companion_m, R.drawable.companion_w, R.drawable.conformist_m,
            R.drawable.conformist_w, R.drawable.distracted_m, R.drawable.distracted_w, R.drawable.evilgenius_m,
            R.drawable.evilgenius_w, R.drawable.evilking_m, R.drawable.evilqueens_w, R.drawable.expert_m, R.drawable.expert_w,
            R.drawable.fatale_m, R.drawable.fatale_w, R.drawable.fighter_m, R.drawable.fighter_w, R.drawable.insider_m, R.drawable.insider_w,
            R.drawable.knowitall_m, R.drawable.knowitall_w, R.drawable.lostcause_m, R.drawable.lostcause_w, R.drawable.misquidedvisionary_m,
            R.drawable.misquidedvisionary_w, R.drawable.opportunist_m, R.drawable.opportunist_w, R.drawable.outsier_m, R.drawable.outsider_w,
            R.drawable.playboy, R.drawable.player_m, R.drawable.player_w, R.drawable.rayofsunshine_m, R.drawable.rayofsunshine_w,
            R.drawable.rebel_m, R.drawable.rebel_w, R.drawable.red_m, R.drawable.red_w, R.drawable.saboteur_m, R.drawable.saboteur_w,
            R.drawable.standardbearer_m, R.drawable.standardbearer_w, R.drawable.tableforone_m, R.drawable.tableforone_w,
            R.drawable.teammate_m, R.drawable.teammate_w, R.drawable.tyrant_m, R.drawable.tyrant_w, R.drawable.valedictorian_m,
            R.drawable.valedictorian_w};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photocataloginner);

        //finding listview
        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),ListdataActivity.class);
                intent.putExtra("name",fruitNames[i]);
                intent.putExtra("image",fruitImages[i]);
                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return fruitImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
            image.setImageResource(fruitImages[i]);
            return view1;



        }
    }
}


