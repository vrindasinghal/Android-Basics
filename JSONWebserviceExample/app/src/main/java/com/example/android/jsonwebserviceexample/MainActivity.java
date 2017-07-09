package com.example.android.jsonwebserviceexample;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    /**
     * Progress Dialog Object
     **/
    private ProgressDialog prgDialog;

    /**
     * Progress Dialog type (0 - for Horizontal progress bar)
     **/
    public static final int progress_bar_type = 0;

    Button B1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1 = (Button) findViewById(R.id.B1);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadAllNotificationsASyncTask().execute();
            }
        });
    }

    /***** Async Task Class For Download Notification From Server *********/
    class DownloadAllNotificationsASyncTask extends AsyncTask<String, String, String> {
        // Show Progress bar before downloading Music
        @SuppressWarnings("deprecation")
        protected void onPreExecute() {
            super.onPreExecute();
            // Shows Progress Bar Dialog and then call doInBackground method
            showDialog(progress_bar_type);
        }

        // Download Music File from Internet
        protected String doInBackground(String... f_url) {
            int count = 0;
            Log.v("count", "" + count);
            try {
                downloadDataFromServerUsingWebservice();
            }
            catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
            return null;
        }
        @SuppressWarnings("deprecation")
        protected void onPostExecute(String file_url) {
            // Dismiss the dialog after the Music file was downloaded
            dismissDialog(progress_bar_type);
            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
        }
    }

    /*** Show Dialog Box with Progress bar *****/
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case progress_bar_type:
                prgDialog = new ProgressDialog(this);
                prgDialog.setMessage("Please Wait...");
                // prgDialog.setIndeterminate(false);
                // prgDialog.setMax(100);
                // prgDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                prgDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                prgDialog.setCancelable(false);
                prgDialog.show();
                return prgDialog;
            default:
                return null;
        }
    }

    public void downloadDataFromServerUsingWebservice() {

        try {
            URL json = new URL("http://androidexample.com/media/webservice/JsonReturn.php");

            Log.v("PRINT JSON", "" + json);

            URLConnection jc = json.openConnection();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(jc.getInputStream()));

            String line = reader.readLine();

            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse
                    .getJSONArray("Android");

            if (jsonArray.length() >= 1) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jObject = (JSONObject) jsonArray.get(i);
                    String Name = jObject.getString("name");
                    String MobileNumber = jObject.getString("number");
                    String Date = jObject.getString("date_added");
                    Log.v("TAG", Name);
                    Log.v("TAG", MobileNumber);
                    Log.v("TAG", Date);
                    reader.close();

                }

            } else {

                Log.v("TAG", "No Records Found");

            }

        } catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();

        }

    }
}
