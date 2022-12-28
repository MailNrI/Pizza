package lat.pam.pizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String city = intent.getStringExtra("city");
        String pizza = intent.getStringExtra("pizza");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        TextView textView = (TextView) findViewById(R.id.user_name);
        textView.setText(userName);
        TextView textView2 = (TextView) findViewById(R.id.store);
        textView2.setText(city);
        TextView textView3 = (TextView) findViewById(R.id.ordered_item);
        textView3.setText(pizza);

        Button confirmButton = (Button) findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(v -> {
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.delivery_radio_group);
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please select a delivery option", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String delivery = radioButton.getText().toString();
                Toast.makeText(this, "Terima kasih " + userName + " sudah memesan ditoko kami, pesanan "+ pizza +" anda dikirim menggunakan " + delivery, Toast.LENGTH_LONG).show();
            }

        });
    }
}