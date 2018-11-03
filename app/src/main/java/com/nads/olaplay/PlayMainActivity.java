package com.nads.olaplay;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PlayMainActivity extends AppCompatActivity {
List<JSonObj> arra = new ArrayList<>();
private int i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_main);

        RecyclerView bikeRecycler = (RecyclerView)findViewById(R.id.recycle);
        bikeRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        bikeRecycler.setLayoutManager(layoutManager);
        //new Playget().execute();
        String view = "http://starlord.hackerearth.com/studio";
        RequestQueue queue = Volley.newRequestQueue(PlayMainActivity.this);

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, view, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            //

            for(int i = 0;i<=response.length();i++){
                  //JSONArray jsonArray = response.getJSONArray(i);
                  JSONObject jsonObject = response.getJSONObject(i);
                  String Views = jsonObject.getString("song");
                  String Url1 = jsonObject.getString("url");
                  String artists = jsonObject.getString("artists");
                  String image = jsonObject.getString("cover_image");
                  JSonObj jSonObj = new JSonObj(Views,Url1,artists,image);
                  arra.add(jSonObj);
             }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        queue.add(stringRequest);


        PlayAdapter playAdapter = new PlayAdapter(PlayMainActivity.this,arra);
        bikeRecycler.setAdapter(playAdapter);
    }
   /* private class Playget extends AsyncTask<Void, Void, Void> {
        private final String TAG = null ;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(PlayMainActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://starlord.hackerearth.com/studio";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node


                    // looping through All Contacts
                    for (int i = 0; i < jsonObj.length(); i++) {
                        JSONArray contacts = jsonObj.getJSONArray(String.valueOf(i));
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("song");
                        /*String name = c.getString("name");
                        String email = c.getString("email");
                        String address = c.getString("address");
                        String gender = c.getString("gender");

                        // Phone node is JSON Object
                        JSONObject phone = c.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                     JSonObj jSonObj = new JSonObj(id);
                     arra.add(jSonObj);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            RecyclerView bikeRecycler = (RecyclerView)findViewById(R.id.recycle);
            bikeRecycler.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(PlayMainActivity.this);
            bikeRecycler.setLayoutManager(layoutManager);

           if(arra!=null)
            {
             PlayAdapter playAdapter = new PlayAdapter(PlayMainActivity.this,arra);
             bikeRecycler.setAdapter(playAdapter);
            }
        }
    }
    */
}

