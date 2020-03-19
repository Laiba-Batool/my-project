package com.example.pizzano_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    dbConnect myDb;
public Button signup;
EditText name,age,number,email,password;

    EditText edtpassowrd;
CheckBox showPwd_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new dbConnect(this);
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted=myDb.insertData(name.getText().toString(),age.getText().toString(),number.getText().toString(),
                        email.getText().toString(),password.getText().toString());
               if(isInserted){
                   Toast.makeText(MainActivity.this,"Data Inserted!",Toast.LENGTH_LONG).show();

                openLoginActivity();
               }
               else
                   Toast.makeText(MainActivity.this,"Data NOT Inserted!!!",Toast.LENGTH_LONG).show();

            }
        });
        edtpassowrd = findViewById(R.id.edtpassowrd);
        showPwd_check = findViewById(R.id.showPwd_check);
        name = (EditText) findViewById(R.id.edtname);
        age = (EditText) findViewById(R.id.edtage);
        number = (EditText) findViewById(R.id.edtcontact);
        email = (EditText) findViewById(R.id.edtemail);
        password = (EditText) findViewById(R.id.edtpassowrd);


        showPwd_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    edtpassowrd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    edtpassowrd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }

        });


    }



    public void openLoginActivity()
    {
            Intent intent=new Intent(this,logIn.class);
        startActivity(intent);

        }
        }
