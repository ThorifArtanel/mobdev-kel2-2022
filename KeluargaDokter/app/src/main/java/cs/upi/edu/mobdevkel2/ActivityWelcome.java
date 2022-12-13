package cs.upi.edu.mobdevkel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityWelcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView family = (ImageView) findViewById(R.id.welcomeFamily);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFamily();
            }
        });


        ImageView doctor = (ImageView) findViewById(R.id.welcomeDokter);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDokter();
            }
        });

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setNavigationIcon(null);
        tb.setTitle("Welcome");
    }

    public void openFamily(){
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

    public void openDokter(){
        Intent intent = new Intent(this, ActivityLoginDokter.class);
        startActivity(intent);
    }
}