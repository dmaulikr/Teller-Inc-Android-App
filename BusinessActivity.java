package com.teller.kwill.teller;

/**
 * Created by kwill on 8/9/2017.
 */
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.SearchView;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ScrollView;

public class BusinessActivity extends AppCompatActivity {
    TextView textView21, textView31, textView41, textView51, textView61, textView17, textView18, textView81;
    ScrollView kjkn;
    ListView lopx;
    EditText editTexta;
    ImageView imageView21;
    Button button31, button41, button81, button8;
    boolean isRepo;
    boolean isUnf;
    boolean isBlo;
    boolean isFo;
    boolean isO;
    boolean isAn;
    boolean isA;
    boolean isUnB;
    boolean isAnA;
    private Context mContext;
    static final String KEY_NAME = "name";
    boolean isVerify;
    SearchView jhke;
    int counte = 0;
    int counter = 0;
    private static final String host = null;
    private int port;
    String str = null;
    byte[] send_data = new byte[1024];
    byte[] receiveData = new byte[1024];
    String modifiedSentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        textView21 = (TextView) findViewById(R.id.textView21);
        textView31 = (TextView) findViewById(R.id.textView31);
        textView41 = (TextView) findViewById(R.id.textView41);
        textView51 = (TextView) findViewById(R.id.textView51);
        textView61 = (TextView) findViewById(R.id.textView61);
        textView17 = (TextView) findViewById(R.id.textView17);
        textView18 = (TextView) findViewById(R.id.textView18);
        textView81 = (TextView) findViewById(R.id.textView81);
        imageView21 = (ImageView) findViewById(R.id.imageView21);

        lopx = (ListView) findViewById(R.id.lopx);
        kjkn = (ScrollView) findViewById(R.id.kjkn);
        button31 = (Button) findViewById(R.id.button31);
        button41 = (Button) findViewById(R.id.button41);
        button81 = (Button) findViewById(R.id.button81);
        button8 = (Button) findViewById(R.id.button8);
        editTexta = (EditText) findViewById(R.id.editTexta);

        Intent intent = getIntent();
        String yoh = getIntent().getStringExtra("name");
        String yohu = getIntent().getStringExtra("public_profile");
        String mb = getIntent().getStringExtra("name");
        String ov = getIntent().getStringExtra("public_profile");
        String p = getIntent().getStringExtra("quest");
        String a = getIntent().getStringExtra("answer");

        Bundle b = getIntent().getExtras();
        String uri_Strn = b.getString("uri_Sme");
        Uri uri = Uri.parse(uri_Strn);
        ((ImageView) findViewById(R.id.imageView21)).setImageURI(uri);

        textView18.setText(yoh);
        textView18.setText(yohu);
        textView61.setText(p);
        textView61.setText(mb);
        textView61.setText(ov);
        textView81.setText(a);
        ArrayAdapter<String> adapter;
        ArrayList<String> okj = new ArrayList<>();
        ArrayList<String> okjk = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, okj);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, okjk);
        okj.add(textView61.toString());
        okj.add(textView81.toString());
        adapter.notifyDataSetChanged();
        okj.add("quest");
        okj.add("name");
        okj.add("public_profile");
        okj.add("answer");
        if (isO = true) {
            textView18.equals(yoh);
            textView18.equals(yohu);
            textView18.equals("name");
            textView18.equals("public_profile");
            button8.setVisibility(View.VISIBLE);

        }
    }

    public void showNotification() {
        Intent intentSetDefault = new Intent(mContext, BusinessActivity.class);
        PendingIntent piSetDeafult = PendingIntent.getActivity(mContext, 0, intentSetDefault,
                PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, BusinessActivity.class), 0);
        Resources r = getResources();

        Notification noti = new Notification.Builder(mContext)
                .setContentTitle("New question from " + KEY_NAME.toString())
                .setSmallIcon(R.drawable.how)
                .build();


        notifyAll();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);
    }



    public void View(final int position, final View convertView, View parent) {
        final View view = convertView;
        if (view == null) {
            button31 = (Button) findViewById(R.id.button31);
            button81 = (Button) view.findViewById(R.id.button81);
            button41 = (Button) view.findViewById(R.id.button41);
            button8 = (Button) view.findViewById(R.id.button8);




        }
        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                String shareQ = "quest";
                String shareA = "answer";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_INTENT, shareQ);
                sharingIntent.putExtra(Intent.EXTRA_INTENT, shareA);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });

        textView51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
                jhke.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                ArrayList<String> okjk = new ArrayList<>();
                 { Intent intent = new Intent();
                     {     intent.putExtra("name",okjk.getClass());
                         intent.putExtra("public_profile",okjk.getClass());
                         getIntent();
                     jhke.setSubmitButtonEnabled(true);

                }
            }
        }
    public boolean onQueryTextChange(String newText)

    {  jhke.setSubmitButtonEnabled(true);
        // this is your adapter that will be filtered
        if (TextUtils.isEmpty(newText))


        {
            lopx.clearTextFilter();
        }

        {
            lopx.setFilterText(newText.toString());
        }


    return true;}


    public boolean onQueryTextSubmit(String query) {
        // TODO Auto-generated method stub
        return false;


    }});

                button31.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        // Remove / Delete all items from List
                        // Clear ListView Items
                        counte++;
                        // TOD O Auto-generated method stub
                        Intent intent = getIntent();
                        String yoh = KEY_NAME.toString();
                        String yohu = KEY_NAME.toString();
                        intent.putExtra("name", yoh);
                        intent.putExtra("public_profile", yohu);

                        setResult(RESULT_OK, intent);

                        String yoe = getIntent().getStringExtra("public_profile");
                        String yol = getIntent().getStringExtra("name");
                        getIntent();
                        if (counte == 50) {

                            ArrayList<String> okj = new ArrayList<>();
                            okj.remove("name");
                            okj.remove("quest");
                            okj.remove("answer");
                            okj.remove("public_profile");

                            Toast.makeText(BusinessActivity.this, "question reported",
                                    Toast.LENGTH_SHORT).show();
                        }
                        AlertDialog.Builder alert = new AlertDialog.Builder(
                                BusinessActivity.this);
                        alert.show();
                    }


                });


        button8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Remove / Delete all items from List
                // Clear ListView Items


                AlertDialog.Builder alert = new AlertDialog.Builder(
                        BusinessActivity.this);

                alert.setTitle("Delete");
                alert.setMessage("Do you want delete this item?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TOD O Auto-generated method stub

                        // main code on after clicking yes
                        ArrayList<String> okj = new ArrayList<>();
                        okj.remove("name");
                        okj.remove("answer");
                        okj.remove("quest");
                        okj.remove("public_profile");
                    }


                /*koj.add("name");
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */

                });

                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                });

                alert.show();
            }});



                button81.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = getIntent();
                        String p = editTexta.toString();

                        String mb = editTexta.toString();
                        String ov = editTexta.toString();
                        // 3. show message on textView

                        intent.putExtra("quest", p);
                        intent.putExtra("name", mb);
                        intent.putExtra("public_profile", ov);
                        // 3. show message on textView
                        ((EditText) findViewById(R.id.editTexta)).setText(p);
                        ((EditText) findViewById(R.id.editTexta)).setText(mb);
                        ((EditText) findViewById(R.id.editTexta)).setText(ov);
                        setResult(RESULT_OK, intent);

                        String yoe = getIntent().getStringExtra("public_profile");
                        String yol = getIntent().getStringExtra("name");
                        Intent ikntent = new Intent(BusinessActivity.this, NotificationActivity.class);
                        getIntent();
                        setResult(RESULT_OK, ikntent);
                        str = "quest";
                        str = "public_profile";
                        str = "name";
                        try {
                            intent.putExtra("name", mb);
                            intent.putExtra("public_profile", ov);
                            intent.putExtra("quest", p);
                            client();
                            showNotification();
                            //txt1.setText(modifiedSentence);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                        Toast.makeText(BusinessActivity.this, "Sent Successfully", Toast.LENGTH_LONG).show();

                    }
                });


                if (isO = false)

                {
                    button8.setVisibility(View.INVISIBLE);
                }
                if (isA = true)

                {
                    counter++;
                    textView17.setText(counter + "");
                }
                if (isAn = true)

                {
                    KEY_NAME.equals("");
                }
        if (isVerify = true) {String yoh = getIntent().getStringExtra("name");

            textView18.setTextColor(Color.parseColor("#ffaa66cc"));
        }
                if (isAnA = false)

                {
                    Intent intent = getIntent();
                    String yoh = KEY_NAME.toString();
                    String yohu = KEY_NAME.toString();
                    intent.putExtra("name", yoh);
                    intent.putExtra("public_profile", yohu);

                    setResult(RESULT_OK, intent);

                    String yoe = getIntent().getStringExtra("public_profile");
                    String yol = getIntent().getStringExtra("name");
                    getIntent();
                    button81.setVisibility(View.INVISIBLE);
                }

                if (isFo = true) {
                    counte++;
                    ArrayList<String> okjk = new ArrayList<>();
                    okjk.add(KEY_NAME.toString());
                    okjk.add("name");
                    okjk.add("public_profile");
                    textView51.setText(counte + "");


                    String yoe = getIntent().getStringExtra("public_profile");
                    String yol = getIntent().getStringExtra("name");
                    getIntent();
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
                if (isBlo = true) {
                    counte--;
                    textView51.setText(counte--);
                    String yoe = getIntent().getStringExtra("public_profile");
                    String yol = getIntent().getStringExtra("name");
                    imageView21.setVisibility(View.INVISIBLE);
                    textView61.setVisibility(View.INVISIBLE);
                    textView81.setVisibility(View.INVISIBLE);
                    editTexta.setVisibility(View.INVISIBLE);
                    getIntent();
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
                if (isUnB = true) {


                    String yoe = getIntent().getStringExtra("public_profile");
                    String yol = getIntent().getStringExtra("name");
                    imageView21.setVisibility(View.VISIBLE);
                    textView61.setVisibility(View.VISIBLE);
                    textView81.setVisibility(View.VISIBLE);
                    editTexta.setVisibility(View.VISIBLE);
                    getIntent();
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

                if (isRepo = true) {
                    if (counte == 50) ;
                    String yoe = getIntent().getStringExtra("public_profile");
                    String yol = getIntent().getStringExtra("name");
                    getIntent();
                    imageView21.setVisibility(View.GONE);

                    textView61.setVisibility(View.GONE);
                    textView81.setVisibility(View.GONE);
                    textView18.setVisibility(View.GONE);
                    textView31.setVisibility(View.GONE);
                    textView21.setVisibility(View.GONE);
                    textView51.setVisibility(View.GONE);
                    textView17.setVisibility(View.GONE);
                    lopx.setVisibility(View.GONE);
                    button31.setVisibility(View.GONE);
                    button41.setVisibility(View.GONE);
                    button8.setVisibility(View.GONE);
                    button81.setVisibility(View.GONE);
                }

                if (isUnf = true) {
                    counte--;
                    textView51.setText(counte--);
                    String yoe = getIntent().getStringExtra("public_profile");
                    String yol = getIntent().getStringExtra("name");
                    getIntent();
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

            }

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
                client_socket.close();}}


