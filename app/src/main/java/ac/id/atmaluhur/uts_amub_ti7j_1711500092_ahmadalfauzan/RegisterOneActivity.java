package ac.id.atmaluhur.uts_amub_ti7j_1711500092_ahmadalfauzan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterOneActivity extends AppCompatActivity {
    EditText username, password, email;
    ImageButton next;

    DatabaseReference reference;
    String USERNAME_KEY = "usernamekey";
    String username_key = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        username = findViewById(R.id.ed_username);
        password = findViewById(R.id.ed_password);
        email = findViewById(R.id.ed_email);

        next = findViewById(R.id.bt_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(username_key, username.getText().toString());
        editor.apply();
        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username.getText().toString());
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getRef().child("username").setValue(username.getText().toString());
                dataSnapshot.getRef().child("password").setValue(password.getText().toString());
                dataSnapshot.getRef().child("email").setValue(email.getText().toString());
                dataSnapshot.getRef().child("saldo").setValue(50);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Intent gotoregistertwo = new Intent(RegisterOneActivity.this, RegisterTwoActivity.class);
                startActivity(gotoregistertwo);
            }
        });
    }
}