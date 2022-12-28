package lat.pam.pizzarestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import lat.pam.pizzarestaurant.models.Menu;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String city = intent.getStringExtra("city");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView peperoniTitle = (TextView) findViewById(R.id.peperoni_title);
        TextView peperoniDetails = (TextView) findViewById(R.id.peperoni_description);

        TextView spaghettiTitle = (TextView) findViewById(R.id.spaghetti_title);
        TextView spaghettiDetails = (TextView) findViewById(R.id.spaghetti_description);

        TextView burgerTitle = (TextView) findViewById(R.id.burger_title);
        TextView burgerDetails = (TextView) findViewById(R.id.burger_description);

        TextView steakTitle = (TextView) findViewById(R.id.steak_title);
        TextView steakDetails = (TextView) findViewById(R.id.steak_description);

        View pepperoni = findViewById(R.id.pepperoni);
        View spaghetti = findViewById(R.id.spaghetti);
        View burger = findViewById(R.id.burger);
        View steak = findViewById(R.id.steak);


        Call<List<Menu>> call = RetrofitClient.getInstance().getMyApi().getMenu();
        call.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                List<Menu> menus = response.body();
                peperoniTitle.setText(menus.get(0).getFoodName());
                peperoniDetails.setText(menus.get(0).getDetails());

                pepperoni.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("userName", userName);
                        intent.putExtra("city", city);
                        intent.putExtra("pizza", menus.get(0).getFoodName());
                        intent.putExtra("price", "Rp. "+menus.get(0).getPrice());
                        intent.putExtra("description", menus.get(0).getDetails());
                        startActivity(intent);
                    }
                });

                spaghettiTitle.setText(menus.get(1).getFoodName());
                spaghettiDetails.setText(menus.get(1).getDetails());

                spaghetti.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("userName", userName);
                        intent.putExtra("city", city);
                        intent.putExtra("pizza", menus.get(1).getFoodName());
                        intent.putExtra("price", "Rp. "+menus.get(1).getPrice());
                        intent.putExtra("description", menus.get(1).getDetails());
                        startActivity(intent);
                    }
                });

                burgerTitle.setText(menus.get(2).getFoodName());
                burgerDetails.setText(menus.get(2).getDetails());

                burger.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("userName", userName);
                        intent.putExtra("city", city);
                        intent.putExtra("pizza", menus.get(2).getFoodName());
                        intent.putExtra("price", "Rp. "+menus.get(2).getPrice());
                        intent.putExtra("description", menus.get(2).getDetails());
                        startActivity(intent);
                    }
                });

                steakTitle.setText(menus.get(3).getFoodName());
                steakDetails.setText(menus.get(3).getDetails());

                steak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        intent.putExtra("userName", userName);
                        intent.putExtra("city", city);
                        intent.putExtra("pizza", menus.get(3).getFoodName());
                        intent.putExtra("price", "Rp. "+menus.get(3).getPrice());
                        intent.putExtra("description", menus.get(3).getDetails());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });


        TextView textView = (TextView) findViewById(R.id.user_name);
        textView.setText(userName);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}