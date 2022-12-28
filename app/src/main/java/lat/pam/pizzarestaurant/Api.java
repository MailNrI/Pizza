package lat.pam.pizzarestaurant;

import java.util.List;

import lat.pam.pizzarestaurant.models.Menu;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    // GET API
    String BASE_URL = "https://retoolapi.dev/StWODX/";
    @GET("uasresto")
    Call<List<Menu>> getMenu();
}
