package com.nads.olaplay;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Admin on 12/21/2017.
 */

public class PlayAdapter extends RecyclerView.Adapter<PlayAdapter.ViewHolder> {
    private Context context;
    private List<JSonObj> arrayList = new ArrayList<>();;

    public PlayAdapter(Context context, List<JSonObj> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }

    @Override
    public PlayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayAdapter.ViewHolder holder, final int position) {
        final int i;
        final CardView cardView = holder.cardView;
        final Context context = cardView.getContext();
        final TextView textView = (TextView)cardView.findViewById(R.id.textView);
        final Button button = (Button)cardView.findViewById(R.id.button);
        final Button button1 = (Button)cardView.findViewById(R.id.button2);
        final TextView textView3 = (TextView)cardView.findViewById(R.id.textView3);
        final ImageView imageView = (ImageView)cardView.findViewById(R.id.imageView);
        /*final String view = "http://starlord.hackerearth.com/studio";
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, view, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                             //
                               // JSONArray jsonArray = response.getJSONArray(i);
                              // JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String Views = jsonObject.getString("song");
                                JSonObj jSonObj = new JSonObj(Views);
                                arrayList.add(jSonObj);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        queue.add(stringRequest);*/
        try{
        if(arrayList!=null){
            //arrayList.toString();
           // Toast toast = Toast.makeText(context,"Failed",Toast.LENGTH_LONG);
            //toast.show();
            textView.setText(arrayList.get(position).getName());
            textView3.setText(arrayList.get(position).getArtists());
            Glide.with(context).load(arrayList.get(position).getImage()).into(imageView);
           button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context.getApplicationContext(),Exoplayer.class);
                    intent.putExtra(String.valueOf(Exoplayer.play_pos),position);
                    intent.putExtra(Exoplayer.play_url,arrayList.get(position).getUrl1());
                    context.startActivity(intent);

                }
            });
        }
        }catch (Exception e){
            e.printStackTrace();
           Toast toast = Toast.makeText(context,"its error",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public int getItemCount() {

        int length = arrayList.size();
        return 10;
    }
}