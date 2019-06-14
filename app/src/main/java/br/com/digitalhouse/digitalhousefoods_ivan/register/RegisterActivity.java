package br.com.digitalhouse.digitalhousefoods_ivan.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.view.RestauranteActivity;

public class RegisterActivity extends AppCompatActivity {
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    TextInputLayout textInputLayoutName;
    TextInputLayout textInputLayoutRepeatPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final SharedPreferences preferences = getSharedPreferences("APP_REGISTER", MODE_PRIVATE);
        initViews();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(preferences);
            }
        });


    }


    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmailR);
        textInputLayoutName = findViewById(R.id.textInputLayoutNomeR);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPasswordR);
        textInputLayoutRepeatPassword = findViewById(R.id.textInputLayoutPasswordRepeatR);
        btnRegister = findViewById(R.id.btnRegisterR);
    }


    private void validar(SharedPreferences preferences) {
        String name = textInputLayoutName.getEditText().getText().toString();
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();
        String rePassword = textInputLayoutRepeatPassword.getEditText().getText().toString();


        if (name.isEmpty()) {
            textInputLayoutName.setError("Nome não informado");
            return;
        }else {
            textInputLayoutName.setError(null);
        }

        if (!formatEmailValidation(email)) {
            textInputLayoutEmail.setError("E-mail não válido");
            return;
        }else {
            textInputLayoutEmail.setError(null);
        }

        if(!password.equals(rePassword)){
            textInputLayoutRepeatPassword.setError("A senha não está igual");
            return;
        }

        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Informar uma senha");
            return;
        }else {
            textInputLayoutPassword.setError(null);
        }

        if (rePassword.isEmpty()) {
            textInputLayoutRepeatPassword.setError("Password not informed :(");
            return;
        }else {
            textInputLayoutRepeatPassword.setError(null);
        }

        Intent intent = new Intent(RegisterActivity.this, RestauranteActivity.class);

        preferences.edit().putString("NOME",name).commit();
        preferences.edit().putString("EMAIL",email).commit();
        preferences.edit().putString("PASSWORD",passencrypted(password)).commit();

        startActivity(intent);
        finish();
    }

    private boolean formatEmailValidation(final String email) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    public String passencrypted(String input) {
        return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
    }
}