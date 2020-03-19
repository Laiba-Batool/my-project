package com.example.pizzano_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class logIn extends AppCompatActivity {
    public Button signIn1_button;
    EditText logInpasswword_text,uEmail;
    CheckBox showPass_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logInpasswword_text = findViewById(R.id.passwrd);
        showPass_check = findViewById(R.id.showPass_check);
        uEmail=findViewById(R.id.mail);
        signIn1_button = (Button) findViewById(R.id.login);

        final dbConnect dbConnect = new dbConnect(this);
        signIn1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean authenticated = dbConnect.Authentication(uEmail.getText().toString(), logInpasswword_text.getText().toString());
                if (authenticated) {
                    OpenMenu();
                    Toast.makeText(logIn.this, "Login successful!", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(logIn.this, "No record mathes this data! You need to Signup first", Toast.LENGTH_LONG).show();
                }
            }

        });


                showPass_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    logInpasswword_text.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    logInpasswword_text.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        }



    public void OpenMenu() {
        Intent intent1 = new Intent(this, MenuDisplay.class);
        {

            startActivity(intent1);
        }
    }
}