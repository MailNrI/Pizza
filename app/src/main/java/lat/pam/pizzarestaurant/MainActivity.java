package lat.pam.pizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.city, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.user_name);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String userName = editText.getText().toString();
        String city = spinner.getSelectedItem().toString();
        if (userName.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("userName", userName);
            intent.putExtra("city", city);
            startActivity(intent);
        }
    }
}