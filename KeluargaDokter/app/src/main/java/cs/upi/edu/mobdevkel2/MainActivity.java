package cs.upi.edu.mobdevkel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView family = (ImageView) findViewById(R.id.welcomeFamily);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeFamily();
            }
        });

        ImageView doctor = (ImageView) findViewById(R.id.welcomeDokter);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeDokter();
            }
        });
    }
    public void openHomeFamily(){
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

    public void openHomeDokter(){
        Intent intent = new Intent(this, ActivityLoginDokter.class);
        startActivity(intent);
    }
}