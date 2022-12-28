package lat.pam.pizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String city = intent.getStringExtra("city");
        String pizza = intent.getStringExtra("pizza");
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView textView = (TextView) findViewById(R.id.pizza_title);
        textView.setText(pizza);
        TextView textView2 = (TextView) findViewById(R.id.price);
        textView2.setText(price);
        TextView textView3 = (TextView) findViewById(R.id.description);
        textView3.setText(description);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.pizza_head);
        if ( pizza.equals("Pepperoni") ) {
            relativeLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.pepperoni));
        } else if ( pizza.equals("Spaghetti") ) {
            relativeLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.spaghetti));
        } else if ( pizza.equals("Burger")){
            relativeLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.burger));
        } else if ( pizza.equals("Steak")){
            relativeLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.steak));
        }
        Button order = (Button) findViewById(R.id.order_button);
        order.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, MainActivity5.class);
            intent1.putExtra("userName", userName);
            intent1.putExtra("city", city);
            intent1.putExtra("pizza", pizza);
            intent1.putExtra("price", price);
            startActivity(intent1);
        });
        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity4.this, MainActivity3.class);
            intent1.putExtra("userName", userName);
            intent1.putExtra("city", city);
            startActivity(intent1);
        });
    }
}