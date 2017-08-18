package com.teller.kwill.teller;

/**
 * Created by kwill on 7/29/2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.LoginResult;
import com.facebook.login.LoginManager;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

 public class LoginActivity extends AppCompatActivity {
     private LoginButton FBloginButton;

    Button login, login_button,passres ;
    ProgressDialog progressDialog;
    EditText email, password ;
    String EmailHolder, PasswordHolder ;
     ImageView imageViewy;
    boolean CheckEditText ;
    String ServerLoginURL = "http://telleri.ultimatefreehost.in/android-login.php";
    public static final String UserEmail = "";
    String finalResult ;
    HashMap<String,String> hashMap = new HashMap<>();
    URL url;
    String FinalHttpData = "";
    BufferedWriter bufferedWriter ;
     boolean isLog;
    LoginParseClass loginParseClass;
    BufferedReader bufferedReader ;
    OutputStream outputStream ;
    StringBuilder stringBuilder = new StringBuilder();
    String Result ;
      CallbackManager callbackManager;
     String yoh = getIntent().getStringExtra("name");
     String yohu = getIntent().getStringExtra("public_profile");
     LoginResult loginResult;
     static final String KEY_NAME = "name";
     static final String pass = "e5199866598a11e2d8685b4788cb7d2cd3a6013d";
     boolean isVerify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setResult(RESULT_OK);
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.button);
        passres = (Button) findViewById(R.id.passres);
        login_button = (Button) findViewById(R.id.login_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        imageViewy = (ImageView) findViewById(R.id.imageViewy);
        if (isVerify = true) {
            if(password.getText().toString().equals("e5199866598a11e2d8685b4788cb7d2cd3a6013d")){
                Intent intent = getIntent();
                String yoh = KEY_NAME.toString();
                intent.putExtra("name", yoh);
                intent.putExtra("e5199866598a11e2d8685b4788cb7d2cd3a6013d", pass);
                Intent iwntent = new Intent(LoginActivity.this, ProfileActivity.class);
                setResult(RESULT_OK, intent);
                setResult(RESULT_OK, iwntent);
            }
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View paramView) {
                FBloginButton.setReadPermissions("email");

                LoginManager.getInstance().registerCallback(callbackManager,
                        new FacebookCallback<LoginResult>() {
                            @Override
                            public void onSuccess(LoginResult loginResult) {
                                String yohu = callbackManager.toString();
                                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                                intent.putExtra("public_profile", yohu);
                                isLog=true;
                                startActivity(intent);


                            }

                            @Override
                            public void onCancel() {
                                System.out.println("onCancel");
                            }

                            @Override
                            public void onError(FacebookException exception) {
                                System.out.println("onError");

                            }
                        });

                passres.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View arg0){

                        startActivity(new Intent(LoginActivity.this, ChangeActivity.class));
                    }

                });
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        GetCheckEditTextIsEmptyOrNot();

                        if (CheckEditText) {

                            LoginFunction(EmailHolder, PasswordHolder);

                        } else {

                            Toast.makeText(LoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                        }


                    }
                });
            }


            public void GetCheckEditTextIsEmptyOrNot() {

                EmailHolder = email.getText().toString();
                PasswordHolder = password.getText().toString();

                if (TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)) {

                    CheckEditText = false;

                } else {

                    CheckEditText = true;
                }

            }

            public void LoginFunction(final String email, final String password) {

                class LoginFunctionClass extends AsyncTask<String, Void, String> {

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                        progressDialog = ProgressDialog.show(LoginActivity.this, "Loading Data", null, true, true);
                    }



                    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

                        callbackManager.onActivityResult(requestCode, resultCode, data);
                    }


                    @Override
                    protected void onPostExecute(String httpResponseMsg) {

                        super.onPostExecute(httpResponseMsg);

                        progressDialog.dismiss();

                        if (httpResponseMsg.equalsIgnoreCase("Data Matched")) {

                            finish();
                            isLog=true;
                            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                            intent.putExtra(UserEmail, email);
                            String yoh = getIntent().getStringExtra("name");
                            intent.putExtra("name", yoh);
                            startActivity(intent);

                        } else {

                            Toast.makeText(LoginActivity.this, httpResponseMsg, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    protected String doInBackground(String... params) {

                        hashMap.put("email", params[0]);

                        hashMap.put("password", params[1]);
                        hashMap.put("public_profile", params[2]);
                        finalResult = loginParseClass.postRequest(hashMap);

                        return finalResult;
                    }
                }

                LoginFunctionClass loginFunctionClass = new LoginFunctionClass();
                loginFunctionClass.execute(email, password);
            }

            class LoginParseClass {

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
                        } else {
                            FinalHttpData = "Something Went Wrong";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return FinalHttpData;
                }

                public String FinalDataParse(HashMap<String, String> hashMap2) throws UnsupportedEncodingException {

                    for (Map.Entry<String, String> map_entry : hashMap2.entrySet()) {

                        stringBuilder.append("&");

                        stringBuilder.append(URLEncoder.encode(map_entry.getKey(), "UTF-8"));

                        stringBuilder.append("=");

                        stringBuilder.append(URLEncoder.encode(map_entry.getValue(), "UTF-8"));

                    }

                    Result = stringBuilder.toString();

                    return Result;
                }
            }


        });
    }}}
