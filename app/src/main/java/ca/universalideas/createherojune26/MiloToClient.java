package ca.universalideas.createherojune26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MiloToClient extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_milo_to_client);

            final EditText name = (EditText) findViewById(R.id.editNameMilo);
            final EditText addy = (EditText) findViewById(R.id.editAddrMilo);
            final EditText cell = (EditText) findViewById(R.id.editCellMilo);
            final EditText questions = (EditText) findViewById(R.id.editQuestions);

            Button email = (Button) findViewById(R.id.button30);
            email.setOnClickListener(new View.OnClickListener()  {

                @Override
                public void onClick(View v){
                    //TODO Auto-generated method stub
                    Intent email = new Intent(android.content.Intent.ACTION_SEND);

                    /* Fill it with Data */
                    email.setType("plain/text");
                    email.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"ladsoffice@lads-to-leaders.org"});
                    email.putExtra(android.content.Intent.EXTRA_SUBJECT, "Lads to Leaders/Leaderettes Questions and/or Comments");
                    email.putExtra(android.content.Intent.EXTRA_TEXT,
                            "name:"+name.getText().toString()+'\n'+"address:"+addy.getText().toString()+'\n'+"phone:"+cell.getText().toString()+'\n'+'\n'+questions.getText().toString()+'\n'+'\n'+"Sent from the Lads to Leaders/Leaderettes Android App.");

                    /* Send it off to the Activity-Chooser */
                    startActivity(Intent.createChooser(email, "Send mail..."));
                }
            });
        }

    //Back button
    public void onBackClick(View view)
    {
        if(view.getId() == R.id.btnBack){
            Intent i = new Intent(MiloToClient.this, Portrayal.class);
            startActivity(i);
        }
    }
}
