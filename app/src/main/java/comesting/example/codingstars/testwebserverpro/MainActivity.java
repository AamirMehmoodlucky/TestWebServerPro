package comesting.example.codingstars.testwebserverpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String URL_PRODUCTS = "https://jobpakistandaily.000webhostapp.com/webserver/webServerTask.php";
    List<model> dataList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
        loadProducts();
    }

    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = null;
                            try {
                                array = new JSONArray(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            for (int i = 0; i < array.length(); i++) {


                                JSONObject product = array.getJSONObject(i);


                                dataList.add(new model(
                                        product.getInt("id"),
                                        product.getString("name"),
                                        product.getString("shortdes"),
                                        product.getDouble("cgpa"),
                                        product.getString("mobilenum"),
                                        product.getString("image")
                                ));
                            }


                            ProfileAdapter adapter = new ProfileAdapter(MainActivity.this, dataList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
