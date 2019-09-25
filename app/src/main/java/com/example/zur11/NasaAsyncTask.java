package com.example.zur11;

import android.os.AsyncTask;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class NasaAsyncTask extends AsyncTask<Void , Void, List<EpicNasa>> {
   private  WeakReference<RecyclerView> rv;
   private  Exception e;

    public NasaAsyncTask(RecyclerView rv) {
        this.rv = new WeakReference<>(rv);
    }
    private static final String  API="https://api.nasa.gov/EPIC/api/natural?api_key=rrtkLBM2oNEmqhZ0W21SMvruX8xV7H1KTqyaOP2a";




    @Override
    protected List<EpicNasa> doInBackground(Void... voids) {
        List<EpicNasa> nasaList=new ArrayList<>();

        try {
            String json =IO.get(API);
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i <jsonArray.length() ; i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                String date=item.getString("date");
                String image=item.getString("image");
                String caption=item.getString("caption");
                String identifier=item.getString("identifier");
                nasaList.add(new EpicNasa(identifier,caption,image,date));
                
                JSONObject latlan =item.getJSONObject("centroid_coordinates");
                long lat =latlan.getLong("lat");
                long  lon  =latlan.getLong("lon") ;
            }

            System.out.println("done parsing json");
        } catch (Exception e) {
           this.e=e;
        }
        return nasaList;
    }

    @Override
    protected void onPostExecute(List<EpicNasa> epicNasas) {


        NasaAdapter adapter =new NasaAdapter(epicNasas);

        RecyclerView rvRef = rv.get();

        if(rvRef==null) return;
        if (e==null) {
            Toast.makeText(rvRef.getContext(), "Error" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        rvRef.setAdapter(adapter);
        rvRef.setLayoutManager(new LinearLayoutManager(rvRef.getContext()));
    }
}
