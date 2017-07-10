package com.example.android.jsonpractice;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progDialog;
    public static final int progress_bar_type = 0;
    // URL to get contacts JSON
    private static String url = "http://api.androidhive.info/contacts/";
    Button B1;

    ListView listView_custom;

    private ArrayList<String> arrayListName;
    private ArrayList<String> arrayListId;
    private ArrayList<String> arrayListEmail;
    private ArrayList<String> arrayListAddress;
    private ArrayList<String> arrayListGender;
    //private ArrayList<String> mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_custom = (ListView) findViewById(R.id.listView_data);
        B1 = (Button) findViewById(R.id.B1);
        arrayListName = new ArrayList<>();
        arrayListId = new ArrayList<>();
        arrayListEmail = new ArrayList<>();
        arrayListAddress = new ArrayList<>();
        arrayListGender = new ArrayList<>();
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadAllASyncTask().execute();
            }
        });
    }

    class DownloadAllASyncTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        @Override
        protected String doInBackground(String... strings) {
            int count = 0;
            Log.v("count", "" + count);
            try {
                downloadDataFromServerUsingWebservice();
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(String file_url) {
            dismissDialog(progress_bar_type);
            CustomAdapter adapter = new CustomAdapter(MainActivity.this, R.layout.activity_customlistview, arrayListId, arrayListName,
                    arrayListEmail, arrayListAddress, arrayListGender);
            listView_custom.setAdapter(adapter);
        }
    }

    private void downloadDataFromServerUsingWebservice() {
        try {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            Log.e("TAG", "Response from url: " + jsonStr);


            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("contacts");
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String address = c.getString("address");
                        String gender = c.getString("gender");

                        // Phone node is JSON Object
                        JSONObject phone = c.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                        arrayListName.add(name);
                        arrayListAddress.add(address);
                        arrayListId.add(id);
                        arrayListEmail.add(email);
                        arrayListGender.add(gender);


                        // tmp hash map for single contact
                        //HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        //contact.put("id", id);
                        //contact.put("name", name);
                        // contact.put("email", email);
                        //contact.put("mobile", mobile);

                        // adding contact to contact list
                        // contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e("TAG", "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e("TAG", "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type:
                progDialog = new ProgressDialog(this);
                progDialog.setMessage("Please Wait...");
                // progDialog.setIndeterminate(false);
                // progDialog.setMax(100);
                // progDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progDialog.setCancelable(false);
                progDialog.show();
                return progDialog;
            default:
                return null;
        }
    }
}
