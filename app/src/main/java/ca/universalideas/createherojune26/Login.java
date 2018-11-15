package ca.universalideas.createherojune26;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Login extends AppCompatActivity {
    // codes for Login start
        EditText UsernameET, PasswordET; //define variables
    // codes for Login end
    String result=""; //new additional var for "login success! Welcome" transfer
     @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
// codes for Login start
        UsernameET = (EditText)findViewById(R.id.etUserName);  //transfer data from Name field to var UsernameET
        PasswordET = (EditText)findViewById(R.id.etPassword);
// codes for Login end
    }

    //Codes for LOGIN and REGISTRATION START
    public void OnLogin(View view) {

        String username = UsernameET.getText().toString();
        String password = PasswordET.getText().toString(); // then create a new class to validate these strings
        String type = "login";                                    //define type variable
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);// create an instance of BackgroundWorker class
        backgroundWorker.execute(type, username, password);  //  we will extract user name and password later from here;   here is showing error because these 3 var are strings,
                                                                // but in BackgroundWorker.java they are Void...  create a method to execute it;  we can pass multiple arguments here:
                                                                // execute(...): user name, passwors and type of operation we want tto execute
        UsernameET.setText(""); //clear the input after sending data
        PasswordET.setText("");//clear the input after sending data
     }

    public void OpenReg(View view){

         if (result == "login success! Welcome"){
         startActivity(new Intent(this, PhotoCatalog.class));
        }
        else {
         startActivity(new Intent(this, PhotoCatalog.class));

        startActivity(new Intent(this,Register.class));   // preparation for button Registration,  to OPEN NEW WINDOW Register_Activity
    }
     }
//Codes for LOGIN and REGISTRATION END


}
