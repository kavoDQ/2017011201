package forfun.good.a2017011201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CL1 (View V)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        final StringRequest request = new StringRequest("http://data.ntpc.gov.tw/od/data/api/BF90FA7E-C358-4CDA-B579-B6C84ADC96A1?$format=json",
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("NETT", response);
                Gson gson =new Gson();
                Anamalhouse[] houses = gson.fromJson(response, Anamalhouse[].class);

                for (Anamalhouse a:houses)
                {
                    Log.d("NETT",a.district+","+a.address);
                }

//                try{
//                    JSONArray array = new JSONArray(response);
//                    int i ;
//                    for(i=0; i<array.length();i++)
//                    {
//                        JSONObject obj = array.getJSONObject(i);
//                        String str = obj.getString("address"); //有這個頭的
//                        Log.d("NET",str);
//
//                    }
//
//
//                }catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
            } //成功了做String response這件事
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }//失敗了做甚麼
        });
        queue.add(request);//加入要求
        queue.start();//執行動作
    }

}

