package com.teller.kwill.teller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.SearchView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.res.Resources;




public class ProfileActivity extends AppCompatActivity {

    TextView textView;
    int counte = 0;
    boolean isRepo;
    boolean isUnf;
    boolean isBlo;
    boolean isFo;
    ImageView noDataImg, noNetworkImg;
    SearchView nnl;
    ListView lkl;
    boolean isLog;
    boolean isChooP;
    boolean isChooB;
    boolean isVerify;
    private Context mContext;
    Button button, button7, button11, button10, button12,button22, button23, button24,button25;
    RadioButton radioButton, radioButton2;
    String urlAddress = "http://telleri.ultimatefreehost.in/searcher.php";
    private final String USER_AGENT = "Mozilla/5.0";
    static final String KEY_NAME = "name";
    private static final String host = null;
    private int port;
    String str = null;
    byte[] send_data = new byte[1024];
    byte[] receiveData = new byte[1024];
    String modifiedSentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_profile);

        textView = (TextView) findViewById(R.id.textviewprofile);

        button = (Button) findViewById(R.id.button);
        nnl = (SearchView) findViewById(R.id.nnl);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        noDataImg = (ImageView) findViewById(R.id.noDataImg);
        noNetworkImg = (ImageView) findViewById(R.id.noNetworkImg);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        button22 = (Button) findViewById(R.id.button22);
        button23 = (Button) findViewById(R.id.button23);
        button24 = (Button) findViewById(R.id.button24);
        button25 = (Button) findViewById(R.id.button25);
        Intent intent = getIntent();

        String yoh = getIntent().getStringExtra("name");
        String yohu = getIntent().getStringExtra("public_profile");
        textView.setText(yoh);
        textView.setText(yohu);
        lkl = (ListView) findViewById(R.id.lkl);
        nnl = (SearchView) findViewById(R.id.nnl);
        ArrayAdapter<String> adapter;
        nnl.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SenderReceiver sr = new SenderReceiver(ProfileActivity.this, urlAddress, query, lkl, noDataImg, noNetworkImg);
                sr.execute();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                SenderReceiver sr = new SenderReceiver(ProfileActivity.this, urlAddress, query, lkl, noDataImg, noNetworkImg);
                sr.execute();
                return false;
            }
        });
    }

    public View getView(final int position, View convertView, View parent) {
        View view = convertView;
        if (view == null) {
            button7 = (Button) view.findViewById(R.id.button7);
            button11 = (Button) view.findViewById(R.id.button11);
            button10 = (Button) view.findViewById(R.id.button10);
            button12 = (Button) view.findViewById(R.id.button12);
        }
        lkl.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                button7 = (Button) findViewById(R.id.button7);
                button11 = (Button) findViewById(R.id.button11);
                button10 = (Button) findViewById(R.id.button10);
                button12 = (Button) findViewById(R.id.button12);
                // getting values from selected ListItem
                String yoh = ((TextView) view.findViewById(R.id.name))
                        .getText().toString();
                String yohu = ((TextView) view.findViewById(R.id.name))
                        .getText().toString();
                // Starting new intent
                Intent in = new Intent(getApplicationContext(),
                        PersonalActivity.class);
                Intent ikn = new Intent(getApplicationContext(),
                        BusinessActivity.class);
                in.putExtra(KEY_NAME, yoh);
                in.putExtra(KEY_NAME, yohu);
                startActivity(in);
                ikn.putExtra(KEY_NAME, yoh);
                ikn.putExtra(KEY_NAME, yohu);
                startActivity(ikn);
                str = "name";
                str = "public_profile";
                try {
                    client();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String yoh = KEY_NAME.toString();
                String yohu = KEY_NAME.toString();
                intent.putExtra("name", yoh);
                intent.putExtra("public_profile", yohu);
                intent.putExtra("name", "Followed you");
                intent.putExtra("public_profile", "Followed you");
                intent.putExtra("message", "Followed you");
                intent.putExtra("messagen", "Followed you");
                setResult(RESULT_OK, intent);
                String yoe = getIntent().getStringExtra("public_profile");
                String yol = getIntent().getStringExtra("name");
                Intent ikntent = new Intent(ProfileActivity.this, PersonalActivity.class);
                Intent iokntent = new Intent(ProfileActivity.this, BusinessActivity.class);
                Intent ilkntent = new Intent(ProfileActivity.this, NotificationActivity.class);
                setResult(RESULT_OK, ikntent);
                setResult(RESULT_OK, ilkntent);
                setResult(RESULT_OK, iokntent);
                getIntent();
                isFo = true;
                str = "name";
                str = "public_profile";
                try {showNotification();
                    client();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLog = true) {String yoh = getIntent().getStringExtra("name");
                    String yohu = getIntent().getStringExtra("public_profile");
                    startActivity(new Intent(ProfileActivity.this, BusinessActivity.class));
                    startActivity(new Intent(ProfileActivity.this, PersonalActivity.class));
                }
                if (isChooB = true) {String yoh = getIntent().getStringExtra("name");
                    String yohu = getIntent().getStringExtra("public_profile");
                    startActivity(new Intent(ProfileActivity.this, BusinessActivity.class));
                }
                if (isChooP = true) {String yoh = getIntent().getStringExtra("name");
                    String yohu = getIntent().getStringExtra("public_profile");
                    startActivity(new Intent(ProfileActivity.this, PersonalActivity.class));
                }


            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //or some other task
                if (isLog = true){startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));}


            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //or some other task
                if (isLog = true){startActivity(new Intent(ProfileActivity.this, NotificationActivity.class));}



            }
        });

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //or some other task
                if (isLog = true) {startActivity(new Intent(ProfileActivity.this, BillyActivity.class));

                }


            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String yoh = KEY_NAME.toString();
                String yohu = KEY_NAME.toString();
                intent.putExtra("name", yoh);
                intent.putExtra("public_profile", yohu);

                setResult(RESULT_OK, intent);
                String yoe = getIntent().getStringExtra("public_profile");
                String yol = getIntent().getStringExtra("name");
                Intent ikntent = new Intent(ProfileActivity.this, PersonalActivity.class);
                Intent ipkntent = new Intent(ProfileActivity.this, BusinessActivity.class);
                Intent iokntent = new Intent(ProfileActivity.this, BlockedActivity.class);
                setResult(RESULT_OK, ikntent);
                setResult(RESULT_OK, ipkntent);
                setResult(RESULT_OK, iokntent);
                getIntent();
                isBlo = true;
                Toast.makeText(ProfileActivity.this, "user blocked",
                        Toast.LENGTH_SHORT).show();
                str = "name";
                str = "public_profile";
                try {
                    client();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String yoh = KEY_NAME.toString();
                String yohu = KEY_NAME.toString();
                intent.putExtra("name", yoh);
                intent.putExtra("public_profile", yohu);

                setResult(RESULT_OK, intent);
                String yoe = getIntent().getStringExtra("public_profile");
                String yol = getIntent().getStringExtra("name");
                Intent ikntent = new Intent(ProfileActivity.this, PersonalActivity.class);
                Intent ipkntent = new Intent(ProfileActivity.this, BusinessActivity.class);
                setResult(RESULT_OK, ipkntent);
                setResult(RESULT_OK, ikntent);
                getIntent();
                isUnf = true;
                if (isFo = true) {
                    button11.setVisibility(View.INVISIBLE);
                }
                if (isBlo = true) {
                    button11.setVisibility(View.INVISIBLE);
                }
                if (isUnf = true) {
                    button11.setVisibility(View.VISIBLE);
                }
                str = "name";
                str = "public_profile";
                try {
                    client();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        radioButton.isChecked();
        {
            Intent intent = new Intent(ProfileActivity.this, PersonalActivity.class);
            String yohu = textView.toString();
            intent.putExtra("public_profile", yohu);
            Intent intenbt = new Intent(ProfileActivity.this, PersonalActivity.class);
            String yoh = textView.toString();
            intent.putExtra("name", yoh);
            startActivity(intent);
            startActivity(intenbt);
            isChooP=true;
            startActivity(new Intent(ProfileActivity.this, PersonalActivity.class));

        }


        radioButton2.isChecked();
        {
            Intent intent = new Intent(ProfileActivity.this, BusinessActivity.class);
            String yohu = textView.toString();
            intent.putExtra("public_profile", yohu);
            Intent intenbt = new Intent(ProfileActivity.this, BusinessActivity.class);
            String yoh = textView.toString();
            intent.putExtra("name", yoh);
            startActivity(intent);
            startActivity(intenbt);
            isChooB=true;
            startActivity(new Intent(ProfileActivity.this, BusinessActivity.class));

        }
        ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);

                startActivity(intent);

                Toast.makeText(ProfileActivity.this, "Log Out Successfully", Toast.LENGTH_LONG).show();

            }
        });return view;}

    public void showNotification() {Intent intentSetDefault = new Intent(mContext, ProfileActivity.class);
        PendingIntent piSetDeafult = PendingIntent.getActivity(mContext, 0, intentSetDefault,
                PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent (this, ProfileActivity.class), 0);
        Resources r = getResources();

        Notification noti = new Notification.Builder(mContext)
                .setContentTitle("New follow from " + KEY_NAME.toString())
                .setSmallIcon(R.drawable.how)
                .build();




        notifyAll();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);




        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                counte++;

                Intent intent = getIntent();
                String yoh = KEY_NAME.toString();
                String yohu = KEY_NAME.toString();
                intent.putExtra("name", yoh);
                intent.putExtra("public_profile", yohu);

                setResult(RESULT_OK, intent);

                String yoe = getIntent().getStringExtra("public_profile");
                String yol = getIntent().getStringExtra("name");
                Intent ikntent = new Intent(ProfileActivity.this, PersonalActivity.class);
                Intent ipkntent = new Intent(ProfileActivity.this, BusinessActivity.class);
                setResult(RESULT_OK, ipkntent);
                setResult(RESULT_OK, ikntent);
                getIntent();
                databaseList();
                if (counte == 50) {
                    Intent ilntent = getIntent();
                    isRepo = true;


                    String url = "http://telleri.ultimatefreehost.in/delete.php";

                    HttpClient client = new DefaultHttpClient();
                    HttpGet request = new HttpGet(url);

                    // add request header
                    request.addHeader("User-Agent", USER_AGENT);

                    HttpPost httpPost = new HttpPost(url);
                    System.out.println("\nSending 'GET' request to URL : " + url);


                    Toast.makeText(ProfileActivity.this, "user reported",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });
        return ;}

    public void client() throws IOException {


        DatagramSocket client_socket = new DatagramSocket(2362);
        InetAddress IPAddress = InetAddress.getByName("10.80.1.95");

        //while (true)
        // {
        send_data = str.getBytes();
        //System.out.println("Type Something (q or Q to quit): ");

        DatagramPacket send_packet = new DatagramPacket(send_data, str.length(), IPAddress, 2362);
        client_socket.send(send_packet);
        //chandra
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        client_socket.receive(receivePacket);
        modifiedSentence = new String(receivePacket.getData());
        //System.out.println("FROM SERVER:" + modifiedSentence);

        modifiedSentence = null;
        client_socket.close();

        // }

    }
}


