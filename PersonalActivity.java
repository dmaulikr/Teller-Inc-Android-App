package com.teller.kwill.teller;

/**
 * Created by kwill on 8/1/2017.
 */


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import android.graphics.Color;
import java.util.List;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.VideoView;
import android.widget.ScrollView;




public class PersonalActivity extends AppCompatActivity {
    TextView textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    VideoView videoView;
    ScrollView kjk;
    ListView lop;
    EditText editText3;
    ImageView imageView2, imageView3;
    Button button3, button4, button5, button6, button17, button16;
    private Context mContext;
    boolean isRepo;
    boolean isUnf;
    boolean isBlo;
    boolean isFo;
    boolean isO;
    boolean isAn;
    boolean isA;
    boolean isUnB;
    boolean isAnA;
    boolean isVerify;
    SearchView jhker;
    static final String KEY_NAME = "name";
    int counte = 0;
    int counted = 0;
    private static final String host = null;
    private int port;
    String str=null;
    byte[] send_data = new byte[1024];
    byte[] receiveData = new byte[1024];
    String modifiedSentence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        videoView = (VideoView) findViewById(R.id.videoView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        lop = (ListView) findViewById(R.id.lop);
        kjk = (ScrollView) findViewById(R.id.kjk);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button17 = (Button) findViewById(R.id.button17);
        button16 = (Button) findViewById(R.id.button16);
        editText3 = (EditText) findViewById(R.id.editText3);

        Intent intent = getIntent();
        String yoh = getIntent().getStringExtra("name");
        String yohu = getIntent().getStringExtra("public_profile");
        String m = getIntent().getStringExtra("name");
        String o = getIntent().getStringExtra("public_profile");
        String p = getIntent().getStringExtra("quest");
        String a = getIntent().getStringExtra("answer");

        textView7.setText(yoh);
        textView7.setText(yohu);
        textView6.setText(p);
        textView6.setText(m);
        textView6.setText(o);
        textView8.setText(a);
        ArrayAdapter<String> adapter;
        ArrayList<String> nkj = new ArrayList<>();
        ArrayList<String> okb = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nkj);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, okb);
        nkj.add(textView6.toString());
        nkj.add(textView8.toString());
        Bundle b = getIntent().getExtras();
        String uri_Strn = b.getString("uri_Sme");
        Uri uri = Uri.parse(uri_Strn);
        ((ImageView) findViewById(R.id.imageView3)).setImageURI(uri);

        String uri_Strb = b.getString("uri_Smo");
        Uri uiri = Uri.parse(uri_Strb);
        ((ImageView) findViewById(R.id.imageView2)).setImageURI(uiri);
        adapter.notifyDataSetChanged();

        Bundle bn = getIntent().getExtras();
        String uri_Strke = bn.getString("uri_Strke");
        Uri urin = Uri.parse(uri_Strke);
        ((VideoView) findViewById(R.id.videoViewm)).setVideoURI(urin);
        Intent itntent = new Intent(Intent.ACTION_VIEW, urin);
        intent.setDataAndType(uri, "uri_Strke");
        startActivity(itntent);
        nkj.add("quest");
        nkj.add("name");
        nkj.add("public_profile");
        nkj.add("uri_Sm");
        nkj.add("uri_Strk");
        nkj.add("answer");
        if(isO=true) {
            textView7.equals(yoh);
            textView7.equals(yohu);
            textView7.equals("name");
            textView7.equals("public_profile");
            button6.setVisibility(View.VISIBLE);
            button16.setVisibility(View.VISIBLE);
            button17.setVisibility(View.VISIBLE);
        }}

    public void showNotification() {
        Intent intentSetDefault = new Intent(mContext, PersonalActivity.class);
        PendingIntent piSetDeafult = PendingIntent.getActivity(mContext, 0, intentSetDefault,
                PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, PersonalActivity.class), 0);
        Resources r = getResources();

        Notification noti = new Notification.Builder(mContext)
                .setContentTitle("New question from " + KEY_NAME.toString())
                .setSmallIcon(R.drawable.how)
                .build();


        notifyAll();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);}



    public boolean onQueryTextChange(String newText)

    {  jhker.setSubmitButtonEnabled(true);
        // this is your adapter that will be filtered
        if (TextUtils.isEmpty(newText))


        {
            lop.clearTextFilter();
        }

        {
            lop.setFilterText(newText.toString());
        }


        return true;}





    public boolean onQueryTextSubmit(String query){
            // TODO Auto-generated method stub



            button4.setOnClickListener(new View.OnClickListener()

            {


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


        button16.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        // Remove / Delete all items from List
                        // Clear ListView Items


                        AlertDialog.Builder alert = new AlertDialog.Builder(
                                PersonalActivity.this);

                        alert.setTitle("Delete");
                        alert.setMessage("Do you want delete this item?");
                        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TOD O Auto-generated method stub

                                // main code on after clicking yes
                                ArrayList<String> nkj = new ArrayList<>();
                                nkj.remove("uri_Sm");
                                nkj.remove("name");
                                nkj.remove("public_profile");
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
                        button17.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                                // Remove / Delete all items from List
                                // Clear ListView Items


                                AlertDialog.Builder alert = new AlertDialog.Builder(
                                        PersonalActivity.this);

                                alert.setTitle("Delete");
                                alert.setMessage("Do you want delete this item?");
                                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TOD O Auto-generated method stub

                                        // main code on after clicking yes
                                        ArrayList<String> nkj = new ArrayList<>();
                                        nkj.remove("uri_Strk");
                                        nkj.remove("name");
                                        nkj.remove("public_profile");
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


        button6.setOnClickListener(new View.OnClickListener() {

                                       public void onClick(View v) {
                                           // Remove / Delete all items from List
                                           // Clear ListView Items


                                           AlertDialog.Builder alert = new AlertDialog.Builder(
                                                   PersonalActivity.this);

                                           alert.setTitle("Delete");
                                           alert.setMessage("Do you want delete this item?");
                                           alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   // TOD O Auto-generated method stub

                                                   // main code on after clicking yes
                                                   ArrayList<String> nkj = new ArrayList<>();
                                                   nkj.remove("name");
                                                   nkj.remove("answer");
                                                   nkj.remove("quest");
                                                   nkj.remove("public_profile");
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
                                       }

                                   });

                                button3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                         public void onClick(View v){
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

                ArrayList<String> nkj = new ArrayList<>();
                nkj.remove("name");
                nkj.remove("quest");
                nkj.remove("answer");
                nkj.remove("public_profile");

                Toast.makeText(PersonalActivity.this, "question reported",
                        Toast.LENGTH_SHORT).show();
            }


        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
                jhker.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
                lop = (ListView) findViewById(R.id.lop);
                ArrayList<String> okb = new ArrayList<>();
                Intent intent = new Intent();
                {     intent.putExtra("name",okb.getClass());
                    intent.putExtra("public_profile",okb.getClass());
                    getIntent();
                    jhker.setSubmitButtonEnabled(true);

                }
            }});
        if(isBlo = true) {
            counte--;
            textView5.setText(counte--);

            imageView2.setVisibility(View.INVISIBLE);
            videoView.setVisibility(View.INVISIBLE);
            textView6.setVisibility(View.INVISIBLE);
            textView8.setVisibility(View.INVISIBLE);
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
        if (isO = false)

        {
            button16.setVisibility(View.INVISIBLE);
            button17.setVisibility(View.INVISIBLE);
            button6.setVisibility(View.INVISIBLE);
                    }
        if (isA = true)

        {
            counted++;
            textView4.setText(counted + "");
        }
                                        if (isAnA = false)

                                        {

                                            intent.putExtra("name", yoh);
                                            intent.putExtra("public_profile", yohu);

                                            setResult(RESULT_OK, intent);

                                            getIntent();
                                            button5.setVisibility(View.INVISIBLE);
                                        }

        if (isAn = true)

        {
            KEY_NAME.equals("");
        }
                                        if (isVerify = true) {

                                            textView7.setTextColor(Color.parseColor("#ffaa66cc"));
                                        }

        if (isFo = true) {
            counte++;
            textView5.setText(counte + "");
            ArrayList<String> okb = new ArrayList<>();
            okb.add(KEY_NAME.toString());
            okb.add("name");
            okb.add("public_profile");

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

        if(isUnB=true){



            imageView2.setVisibility(View.VISIBLE);
            textView6.setVisibility(View.VISIBLE);
            textView8.setVisibility(View.VISIBLE);
            editText3.setVisibility(View.VISIBLE);
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

            getIntent();
            imageView2.setVisibility(View.GONE);
            videoView.setVisibility(View.GONE);
            textView6.setVisibility(View.GONE);
            textView8.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);
            textView5.setVisibility(View.GONE);
            textView7.setVisibility(View.GONE);
            lop.setVisibility(View.GONE);
            imageView3.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button4.setVisibility(View.GONE);
            button5.setVisibility(View.GONE);
            button6.setVisibility(View.GONE);
        }

        if (isUnf = true) {
            counte--;
            textView5.setText(counte--);

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



 button5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = getIntent();
                                            String p = editText3.toString();
                                            String m = editText3.toString();
                                            String o = editText3.toString();
                                            intent.putExtra("quest", p);
                                            intent.putExtra("name", m);
                                            intent.putExtra("public_profile", o);
                                            // 3. show message on textView
                                            ((EditText) findViewById(R.id.editText3)).setText(p);
                                            ((EditText) findViewById(R.id.editText3)).setText(m);
                                            ((EditText) findViewById(R.id.editText3)).setText(o);
                                            setResult(RESULT_OK, intent);

                                            String yoe = getIntent().getStringExtra("public_profile");
                                            String yol = getIntent().getStringExtra("name");
                                            getIntent();
                                            Intent ikntent = new Intent(PersonalActivity.this, NotificationActivity.class);
                                            setResult(RESULT_OK, ikntent);
                                            str = "quest";
                                            str = "public_profile";
                                            str = "name";
                                            try {showNotification();
                                                intent.putExtra("name", m);
                                                intent.putExtra("public_profile", o);
                                                intent.putExtra("quest", p);
                                                client();
                                                //txt1.setText(modifiedSentence);
                                            } catch (IOException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                            }


                                            Toast.makeText(PersonalActivity.this, "Sent Successfully", Toast.LENGTH_LONG).show();

                                        }
                                    });}



                            public View getView(final int position, View convertView, View parent) {
                                View view = convertView;
                                if (view == null) { button6 = (Button) view.findViewById(R.id.button6);
                                    button17 = (Button) view.findViewById(R.id.button17);
                                    button16 = (Button) view.findViewById(R.id.button16);
                                    button3 = (Button) view.findViewById(R.id.button3);
                                    button4 = (Button) view.findViewById(R.id.button4);


                                }
                                return view;
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
                                client_socket.close();

                                // }

                            }});return true;}}