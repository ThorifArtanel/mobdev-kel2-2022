package cs.upi.edu.mobdevkel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityRegisterDokter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_dokter);

        TextView login = (TextView) findViewById(R.id.loginDokter);
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
    public void openLogin(){
        Intent intent = new Intent(this, ActivityLoginDokter.class);
        startActivity(intent);
    }
}