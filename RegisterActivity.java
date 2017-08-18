package com.teller.kwill.teller;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
public class RegisterActivity extends AppCompatActivity {
    Button buttonp , button2 ;
    EditText name, email , password ;
    ImageView imageView;
    boolean isVerify;
    String RegisterURL = "http://telleri.ultimatefreehost.in/insert-registration-data.php" ;
    Boolean CheckEditText ;
    String Response;
    HttpResponse response ;
    static final String KEY_NAME = "name";
    static final String pass = "";
    String NameHolder, EmailHolder, PasswordHolder ;

    Intent intent = getIntent();
    String yoh = name.toString();
    Intent intentk = new Intent(RegisterActivity.this,ProfileActivity.class);
    Intent intentkj = new Intent(RegisterActivity.this,LoginActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonp = (Button)findViewById(R.id.buttonp);
        button2 = (Button)findViewById(R.id.button2);
        imageView = (ImageView) findViewById(R.id.imageView);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        if (isVerify = true) {
            if(password.getText().toString().equals("")){
                Intent intent = getIntent();
                String yoh = KEY_NAME.toString();
                intent.putExtra("name", yoh);
                intent.putExtra("", pass);
                Intent iwntent = new Intent(RegisterActivity.this, LoginActivity.class);
                setResult(RESULT_OK, intent);
                setResult(RESULT_OK, iwntent);
        }
        buttonp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                if(CheckEditText){

                    SendDataToServer(NameHolder, EmailHolder, PasswordHolder);

                }
                else {

                    Toast.makeText(RegisterActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra(yoh, "name");
                String yoh = getIntent().getStringExtra("name");
                intent.putExtra("name", yoh);
                startActivity(intent);
                startActivityForResult(intent, 0);
                finish();

            }
        });
    }}

    public void GetCheckEditTextIsEmptyOrNot(){

        NameHolder = name.getText().toString();
        EmailHolder = email.getText().toString();
        PasswordHolder = password.getText().toString();

        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void SendDataToServer(final String name, final String email, final String password){
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String QuickName = name ;
                String QuickEmail = email ;
                String QuickPassword = password;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("public_profile", QuickName));
                nameValuePairs.add(new BasicNameValuePair("name", QuickName));
                nameValuePairs.add(new BasicNameValuePair("email", QuickEmail));
                nameValuePairs.add(new BasicNameValuePair("password", QuickPassword));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(RegisterURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Submit Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(RegisterActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name, email, password);
    }

}


