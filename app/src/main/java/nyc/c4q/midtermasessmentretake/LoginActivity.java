package nyc.c4q.midtermasessmentretake;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by c4q on 1/16/18.
 */

public class LoginActivity extends AppCompatActivity {
    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";

    private EditText username;
    private EditText password;
    private CheckBox remember;
    private Button login;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username_editText);
        password = (EditText) findViewById(R.id.password_editText);
        remember = (CheckBox) findViewById(R.id.remember_checkbox);
        login = (Button) findViewById(R.id.login_button);

        sharedPref = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                String user = username.getText().toString();
                String passcode = password.getText().toString();
                boolean saved = remember.isChecked();

                if (remember.isChecked()) {
                    editor.putString("user", username.getText().toString());
                    editor.putString("passcode", password.getText().toString());
                    editor.putBoolean("isChecked", remember.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", remember.isChecked());
                    editor.commit();
                }

                if (user.equals("user@aol.com") && passcode.equals("password1234")) {
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("email", user);
                    startActivity(intent);
                }

            }
        });
    }
}