package cs.upi.edu.mobdevkel2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityWelcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView family = (ImageView) findViewById(R.id.welcomeFamily);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeFamily();
            }
        });
    }
    public void openHomeFamily(){
        Intent intent = new Intent(this, ActivityLogin.class);
        startActivity(intent);
    }

}