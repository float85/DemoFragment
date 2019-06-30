package com.example.demofragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.demofragment.databinding.FragmentView01Binding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Fragment01 extends Fragment {
    private static final String TAG = "Fragment01";
    FragmentView01Binding binding;
    String urlApi = "https://demo5639557.mockable.io/getProductNew";

    String result = "";
    String jsonArray = "[ { \"id\": 300, \"main\": \"Drizzle\", \"description\": \"light intensity drizzle\", \"icon\": \"09d\" }, { \"id\": 200, \"main\": \"Manh\", \"description\": \"light intensity drizzle\", \"icon\": \"09d\" } ]";

    public static Fragment01 newInstance() {
        return new Fragment01();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view01,
                container, false);

        new DoGetJson().execute();

//        getJsonArray();
        return binding.getRoot();
    }

    private void getJsonArray() {
        try {
            JSONArray jArray = new JSONArray(jsonArray);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String main = jsonObject.getString("main");
                String des = jsonObject.getString("description");
                String icon = jsonObject.getString("icon");

                result += "\nid: " + id + " main: " + main + " des: " +
                        des + " icon: " + icon;
            }
            binding.tvDemo.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class DoGetJson extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlApi);
                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = is.read()) != -1) {
                    result += (char) byteCharacter;
                }

                Log.d(TAG, "doInBackground: " + result);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            binding.tvDemo.setText(result);
        }
    }
}
