package ac.id.atmaluhur.uts_amub_ti7j_1711500092_ahmadalfauzan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    ImageButton login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.ed_name);
        password = findViewById(R.id.ed_pass);
        login = findViewById(R.id.bt_login);
        register = findViewById(R.id.bt_regis);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoregis = new Intent(MainActivity.this, RegisterOneActivity.class);
                startActivity(gotoregis);
            }
        });
    }
}