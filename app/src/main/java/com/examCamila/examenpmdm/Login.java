package com.examCamila.examenpmdm;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login  extends AppCompatActivity {

    private TextInputLayout loginUsernameTIL, loginPasswordTIL;
    private Button loginButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);

        loginUsernameTIL = findViewById(R.id.loginUsernameTIL);
        loginPasswordTIL = findViewById(R.id.loginPasswordTIL);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            String username = loginUsernameTIL.getEditText().getText().toString().trim();
            String password = loginPasswordTIL.getEditText().getText().toString().trim();

            if (validateFields(username, password) && password.equals("examenpmdm")){
                openMainActivity(username);
            }
        });
    }

    private boolean validateFields(String username, String password) {
        if (username.isEmpty()){
            loginUsernameTIL.setError("El usuario es obligatorio.");
            return false;
        }
        if (password.isEmpty()) {
            loginPasswordTIL.setError("La contraseña es obligatoria.");
            return false;
        }

        loginUsernameTIL.setError(null);
        loginPasswordTIL.setError(null);
        return true;
    }

    private void openMainActivity(String username) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
    }
}
