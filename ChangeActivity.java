package com.teller.kwill.teller;

/**
 * Created by kwill on 7/30/2017.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
public class ChangeActivity extends AppCompatActivity {

    Button buttonpl;
    ProgressDialog progressDialog;
    EditText newpass, cpassword;
    String NewHolder, CHolder;
    boolean CheckEditText;
    String ServerLoginURL = "http://telleri.ultimatefreehost.in/forgot.php";
    public static final String CPass = "";
    String finalResult;
    HashMap<String, String> hashMap = new HashMap<>();
    URL url;
    String FinalHttpData = "";
    BufferedWriter bufferedWriter;
    LoginParseClass loginParseClass = new LoginParseClass();
    BufferedReader bufferedReader;
    OutputStream outputStream;
    StringBuilder stringBuilder = new StringBuilder();
    String Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        buttonpl = (Button) findViewById(R.id.buttonpl);

        newpass = (EditText) findViewById(R.id.newpass);

        cpassword = (EditText) findViewById(R.id.cpassword);

        buttonpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetCheckEditTextIsEmptyOrNot();

                if (CheckEditText) {

                    LoginFunction(NewHolder, CHolder);

                } else {

                    Toast.makeText(ChangeActivity.this, "Password doesn't match.", Toast.LENGTH_LONG).show();

                }


            }
        });
    }

    public void GetCheckEditTextIsEmptyOrNot(){

        NewHolder = newpass.getText().toString();
        CHolder = cpassword.getText().toString();


        if( newpass.equals( cpassword ) )
            Toast.makeText(getApplicationContext(), "Matches", Toast.LENGTH_SHORT).show();
        {

            CheckEditText = false;

        }
          {

              Toast.makeText(getApplicationContext(), newpass.getText()+"Password doesn't match"+cpassword.getText(), Toast.LENGTH_SHORT).show();
            CheckEditText = true ;
        }

    }
    public void LoginFunction(final String newpass, final String cpassword){

        class LoginFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(ChangeActivity.this,"Loading Data",null,true,true);
            }
            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Your pass has been changed")){

                    finish();

                    Intent intent = new Intent(ChangeActivity.this, LoginActivity.class);

                    intent.putExtra(CPass,cpassword);

                    startActivity(intent);
                }else{

                    Toast.makeText(ChangeActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("newpass",params[0]);

                hashMap.put("cpassword",params[1]);

                hashMap.put("name",params[2]);

                finalResult = loginParseClass.postRequest(hashMap);

                return finalResult;
            }
        }
        LoginFunctionClass loginFunctionClass = new LoginFunctionClass();
        loginFunctionClass.execute(newpass,cpassword);
    }
    public class LoginParseClass {

        public String postRequest(HashMap<String, String> Data) {

            try {
                url = new URL(ServerLoginURL);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(12000);

                httpURLConnection.setConnectTimeout(12000);

                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoInput(true);

                httpURLConnection.setDoOutput(true);

                outputStream = httpURLConnection.getOutputStream();

                bufferedWriter = new BufferedWriter(

                        new OutputStreamWriter(outputStream, "UTF-8"));

                bufferedWriter.write(FinalDataParse(Data));

                bufferedWriter.flush();

                bufferedWriter.close();

                outputStream.close();

                if (httpURLConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {

                    bufferedReader = new BufferedReader(
                            new InputStreamReader(
                                    httpURLConnection.getInputStream()
                            )
                    );
                    FinalHttpData = bufferedReader.readLine();
                }
                else {
                    FinalHttpData = "Old Pass doesn't match";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return FinalHttpData;
        }

        public String FinalDataParse(HashMap<String, String> hashMap3) throws UnsupportedEncodingException {

            for(Map.Entry<String, String> map_entry : hashMap3.entrySet()){

                stringBuilder.append("&");

                stringBuilder.append(URLEncoder.encode(map_entry.getKey(), "UTF-8"));

                stringBuilder.append("=");

                stringBuilder.append(URLEncoder.encode(map_entry.getValue(), "UTF-8"));

            }

            Result = stringBuilder.toString();

            return Result ;
        }
    }

}