package cs.upi.edu.mobdevkel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setNavigationIcon(null);
        tb.setTitle("Register");
    }
    public void openLogin() {
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

}