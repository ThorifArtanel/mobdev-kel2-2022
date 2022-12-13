package cs.upi.edu.mobdevkel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cs.upi.edu.mobdevkel2.dokter.ActivityDokter;
import cs.upi.edu.mobdevkel2.keluarga.ActivityKeluarga;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeFamily();
            }
        });

        TextView register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setNavigationIcon(null);
        tb.setTitle("Login");
    }

    public void openHomeFamily(){
        Intent intent = new Intent(this, ActivityKeluarga.class);
        startActivity(intent);
    }

    public void openRegister(){
        Intent intent = new Intent(this, ActivityRegister.class);
        startActivity(intent);
    }
}