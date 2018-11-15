package ca.universalideas.createherojune26;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText name, email, password;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.et_name);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);
    }

    public void OnReg(View view) {
        String str_name = name.getText().toString();  // it will take info from fields
        String str_email = email.getText().toString(); // then create a new class to validate these strings
        String str_password = password.getText().toString();
        String type = "register";                                    // how we will open a main activity,   define type variable
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);                                        // create an instance of BackgroundWorker class
        backgroundWorker.execute(type, str_name, str_email,  str_password);
        name.setText(""); //clean the input after sending data
        email.setText(""); //clean the input after sending data
        password.setText(""); //clean the input after sending data
    }


    //public void onSelectTypeCharClick(View v){
        //if(v.getId() == R.id.btnSelectTypeChar)    //button id
       // {
         //   Intent i = new Intent(Register.this, SelectTypeCharacter.class);
          //  startActivity(i);
        //}
    //}

    public void onPhotoCatalogClick(View v){
        if(v.getId() == R.id.btnPhotoCatalog)    //button id
        {
            Intent i = new Intent(Register.this, PhotoCatalog.class);
            startActivity(i);
        }
    }

}
