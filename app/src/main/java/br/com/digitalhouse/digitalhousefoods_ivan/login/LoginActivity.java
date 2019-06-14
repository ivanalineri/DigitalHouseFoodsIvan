package br.com.digitalhouse.digitalhousefoods_ivan.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import br.com.digitalhouse.digitalhousefoods_ivan.R;
import br.com.digitalhouse.digitalhousefoods_ivan.home.view.RestauranteActivity;
import br.com.digitalhouse.digitalhousefoods_ivan.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    private Button btnLogin;
    private Button btnRegister;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        final SharedPreferences preferences = getSharedPreferences("APP_LOGIN", MODE_PRIVATE);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(preferences);
            }
        });
    }


    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        checkBox = findViewById(R.id.checkBox);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

    }

    private void validar(SharedPreferences preferencesLogin) {
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if (!formatEmailValidation(email)) {
            textInputLayoutEmail.setError("E-mail não informado");
            return;
        } else {
            textInputLayoutEmail.setError(null);
        }

        if (password.isEmpty()) {
            textInputLayoutPassword.setError("Senha não Informada");
            return;
        } else {
            textInputLayoutPassword.setError(null);
        }

        final SharedPreferences preferences = getSharedPreferences("APP_REGISTER", MODE_PRIVATE);

        String emailValid = preferences.getString("EMAIL", "");
        String passwordValid = newPassencrypted(preferences.getString("PASSWORD", ""));


        if (passwordValid != null && !password.equals(passwordValid) ||
                emailValid != null && !email.equals(emailValid)) {

            Snackbar.make(btnLogin, "E-mail ou senha inválidos", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            return;
        } else {
            textInputLayoutEmail.setError(null);
            textInputLayoutPassword.setError(null);
        }

        if (checkBox.isChecked()) {


            preferencesLogin.edit().putString("EMAIL", email).commit();
            preferencesLogin.edit().putString("PASSWORD", passencrypted(password)).commit();
        }

        Intent intent = new Intent(LoginActivity.this, RestauranteActivity.class);
        startActivity(intent);
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

    public String newPassencrypted(String input) {
        return new String(Base64.decode(input, Base64.DEFAULT));
    }
}
