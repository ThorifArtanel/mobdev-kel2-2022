package cs.upi.edu.mobdevkel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cs.upi.edu.mobdevkel2.dokter.ActivityDokter;
import cs.upi.edu.mobdevkel2.keluarga.ActivityKeluarga;

public class ActivityLoginDokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dokter);

        Button login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeDokter();
            }
        });
    }

    public void openHomeDokter(){
        Intent intent = new Intent(this, ActivityDokter.class);
        startActivity(intent);
    }
}