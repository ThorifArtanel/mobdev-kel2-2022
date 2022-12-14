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

public class ActivityLoginDokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dokter);

        Button login = (Button) findViewById(R.id.btnLoginDokter);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeDoctor();
            }
        });

        TextView register = (TextView) findViewById(R.id.registerDokter);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });
    }

    public void openHomeDoctor(){
        Intent intent = new Intent(this, ActivityDokter.class);
        startActivity(intent);
    }

    public void openRegister(){
        Intent intent = new Intent(this, ActivityRegister.class);
        startActivity(intent);
    }
}