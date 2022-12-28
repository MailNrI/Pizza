package lat.pam.pizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String city = intent.getStringExtra("city");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        TextView textView = (TextView) findViewById(R.id.user_name);
        textView.setText(userName);
        TextView textView2 = (TextView) findViewById(R.id.store_location);
        textView2.setText(city);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void seeMenu(View view) {
        String userName = getIntent().getStringExtra("userName");
        String city = getIntent().getStringExtra("city");
        Log.d("userName", userName);
        Log.d("city", city);
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("userName", userName);
        intent.putExtra("city", city);
        startActivity(intent);
    }
}