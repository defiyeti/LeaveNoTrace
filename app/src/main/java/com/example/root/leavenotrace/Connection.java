package com.example.root.leavenotrace;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ryan on 4/14/15.
 */
public class Connection {

    String CSRVToken;

    protected void logIn(final String email, final String password) {
        new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... params) {
                //Start post to server to subscribe to general stock show pushes
                //authenticity_token=t1Wykm3ctOiukzPYSqQVDfEvk45AjbFCf3aErYGC1QgFYa2nrQYBPJ3aqSHVnBp9SzM4%2BBuPJvX3S3IQDXSzGQ%3D%3D&user%5Bemail%5D=derpy%40test.com&user%5Bpassword%5D=asdf1234

                try {
                    DefaultHttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost("http://45.55.129.205/users/sign_in?user[email]="+email+"&user[password]="+password+"&authenticity_token="+CSRVToken+"");

                    HttpResponse response = client.execute(post);

                    String authToken = response.getFirstHeader("X-Auth-Token").getValue();

                    Log.v("response", authToken);

                } catch (Exception e){e.printStackTrace();}
                return null;
            }
        }.execute();
    }

    protected void getCSRFToken () {
        new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... params) {
                try {
                    URL obj = new URL("http://45.55.129.205/users/sign_in/");
                    URLConnection conn = obj.openConnection();

                    CSRVToken = conn.getHeaderField("X-Csrf-Token");

                } catch (Exception e){ e.printStackTrace();}
                return null;
            }
        }.execute();
    }
}

