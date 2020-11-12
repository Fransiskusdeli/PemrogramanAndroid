package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnlogin;
    private Button btnRegister;

    DatabaseHelper dbHelper;


    SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.llogin);
        txtUsername = findViewById(R.id.usernameLogin);
        txtPassword = findViewById(R.id.passwordLogin);
        btnRegister = findViewById(R.id.btnRegisterLogin);
        btnlogin = findViewById(R.id.btnloginLogin);

        dbHelper = new DatabaseHelper(this);
//        TextView tvCreateAccount = (TextView)findViewById(R.id.tvCreateAccount);
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(LoginActivity.this, HomeActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

//        Button btnLogout;







        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
//                if(txtPassword.getText().toString().equals("admin") && txtUsername.getText().toString().equals("admin")){
//
//                    Intent i = new Intent( LoginActivity.this, HomeActivity.class);
//                    Toast.makeText(getApplicationContext(), "Welcome "+ txtUsername.getText(),   Toast.LENGTH_LONG).show();
//                    startActivity(i);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"Tidak ditemukan "+ txtUsername.getText(), Toast.LENGTH_LONG).show();
//                }
                String usernamevalue = txtUsername.getText().toString();
                String passwordvalue = txtPassword.getText().toString();
                Boolean res = dbHelper.checkUser(usernamevalue,passwordvalue);
                if(res == true){
                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    //SEESSION

                    //SESSION
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent= new Intent(LoginActivity.this, RegisterActivity.class);
                 startActivity(intent);
            }
        });




    }
}

