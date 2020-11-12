package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText TxUsername, TxPassword, TxConPassword;
    Button BtnRegister, BtnCancel;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DatabaseHelper(this);

        TxUsername = (EditText)findViewById(R.id.emailusernameReg);
        TxPassword = (EditText)findViewById(R.id.passwordReg);
        BtnRegister = (Button)findViewById(R.id.btnRegisterReg);
        BtnCancel = (Button)findViewById(R.id.btnCancelReg);

        BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = TxUsername.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();
                ContentValues values = new ContentValues();

                if (password.equals("") || username.equals("")){
                    Toast.makeText(RegisterActivity.this, "Password dan username tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }else {
                    values.put(DatabaseHelper.row_username, username);
                    values.put(DatabaseHelper.row_password, password);
                    dbHelper.insertData(values);
                    //SeSSION



                    //SESSION
                    Toast.makeText(RegisterActivity.this, "Berhasil Register!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }
}