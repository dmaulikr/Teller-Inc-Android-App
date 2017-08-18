package com.teller.kwill.teller;

/**
 * Created by kwill on 8/9/2017.
 */
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.VideoView;
import android.widget.ScrollView;

public class NotificationActivity extends AppCompatActivity {
    TextView textView90, textView11, textView12;
    ScrollView iee;
    ListView lopm;
    EditText editText27;
    ImageView imageVie;
    VideoView videoViewm;
    Button button9, button14, button13, button15;
    boolean isA;
    boolean isAn;
    boolean isChooP;
    boolean isChooB;
    static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        textView90 = (TextView) findViewById(R.id.textView90);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        videoViewm = (VideoView) findViewById(R.id.videoView);
        imageVie = (ImageView) findViewById(R.id.imageVie);
        lopm = (ListView) findViewById(R.id.lopm);
        iee = (ScrollView) findViewById(R.id.iee);
        button9 = (Button) findViewById(R.id.button9);
        button14 = (Button) findViewById(R.id.button14);
        button13 = (Button) findViewById(R.id.button13);
        button15 = (Button) findViewById(R.id.button15);
        editText27 = (EditText) findViewById(R.id.editText27);

        Intent intent = getIntent();
        String yoh = getIntent().getStringExtra("name");
        String yohu = getIntent().getStringExtra("public_profile");
        String p = getIntent().getStringExtra("quest");
        String m = getIntent().getStringExtra("name");
        String o = getIntent().getStringExtra("public_profile");
        String mb = getIntent().getStringExtra("name");
        String ov = getIntent().getStringExtra("public_profile");
        textView11.setText(yoh);
        textView11.setText(yohu);
        textView90.setText(p);
        textView90.setText(m);
        textView90.setText(o);
        textView90.setText(mb);
        textView90.setText(ov);
        ArrayAdapter<String> adapter;
        ArrayList<String> koj = new ArrayList<>();
        final ArrayList<String> lismte = new ArrayList<String>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lismte);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, koj);
        Bundle intentBundle = intent.getExtras();
        String message = intentBundle.getString("name");
        String messagen = intentBundle.getString("public_profile");
        textView12.setText(message);
        textView12.setText(messagen);
        Bundle b = getIntent().getExtras();
        String uri_Strb = b.getString("uri_Smo");
        Uri uri = Uri.parse(uri_Strb);
        ((ImageView) findViewById(R.id.imageVie)).setImageURI(uri);

        Bundle bn = getIntent().getExtras();
        String uri_Strke = bn.getString("uri_Strke");
        Uri urin = Uri.parse(uri_Strke);
        ((VideoView) findViewById(R.id.videoViewm)).setVideoURI(urin);
        Intent itntent = new Intent(Intent.ACTION_VIEW, urin);
        intent.setDataAndType(uri, "uri_Strke");
        startActivity(itntent);
        koj.add(textView90.toString());
        koj.add(editText27.toString());
        koj.add(button9.toString());
        koj.add("quest");
        koj.add("name");
        koj.add("public_profile");
        koj.add("uri_Smo");
        koj.add("uri_Strke");
        adapter.notifyDataSetChanged();
        lismte.add(textView12.toString());
        lismte.add(textView12.toString());
        lismte.add("name");
        lismte.add("public_profile");
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove / Delete all items from List
                // Clear ListView Items


                AlertDialog.Builder alert = new AlertDialog.Builder(
                        NotificationActivity.this);

                alert.setTitle("Delete");
                alert.setMessage("Do you want delete this item?");
                alert.setPositiveButton("YES", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TOD O Auto-generated method stub

                        // main code on after clicking yes
                        ArrayList<String> koj = new ArrayList<>();
                        koj.remove("name");
                        koj.remove("quest");
                        koj.remove("public_profile");
                    }


                /*koj.add("name");
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */

                });

                alert.setNegativeButton("CANCEL", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                });

                alert.show();
                button13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Remove / Delete all items from List
                        // Clear ListView Items


                        AlertDialog.Builder alert = new AlertDialog.Builder(
                                NotificationActivity.this);

                        alert.setTitle("Delete");
                        alert.setMessage("Do you want delete this item?");
                        alert.setPositiveButton("YES", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TOD O Auto-generated method stub

                                // main code on after clicking yes
                                ArrayList<String> koj = new ArrayList<>();
                                koj.remove("uri_Strk");

                            }


                /*koj.add("name");
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */

                        });

                        alert.setNegativeButton("CANCEL", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dialog.dismiss();
                            }
                        });

                        alert.show();

                        button15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Remove / Delete all items from List
                                // Clear ListView Items


                                AlertDialog.Builder alert = new AlertDialog.Builder(
                                        NotificationActivity.this);

                                alert.setTitle("Delete");
                                alert.setMessage("Do you want delete this item?");
                                alert.setPositiveButton("YES", new OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TOD O Auto-generated method stub

                                        // main code on after clicking yes
                                        ArrayList<String> koj = new ArrayList<>();
                                        koj.remove("uri_Sm");

                                    }


                /*koj.add("name");
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */

                                });

                                alert.setNegativeButton("CANCEL", new OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TODO Auto-generated method stub
                                        dialog.dismiss();
                                    }
                                });

                                alert.show();
                                button9.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = getIntent();
                                        String p = textView90.toString();
                                        String a = editText27.toString();
                                        String m = textView90.toString();
                                        String o = textView90.toString();
                                        String mb = textView90.toString();
                                        String ov = textView90.toString();
                                        intent.putExtra("name", m);
                                        intent.putExtra("public_profile", o);
                                        intent.putExtra("quest", p);
                                        intent.putExtra("answer", a);
                                        intent.putExtra("name", mb);
                                        intent.putExtra("public_profile", ov);
                                        // 3. show message on textView
                                        ((TextView) findViewById(R.id.textView90)).setText(p);
                                        ((TextView) findViewById(R.id.textView90)).setText(m);
                                        ((TextView) findViewById(R.id.textView90)).setText(o);
                                        ((TextView) findViewById(R.id.textView90)).setText(mb);
                                        ((TextView) findViewById(R.id.textView90)).setText(ov);
                                        ((EditText) findViewById(R.id.editText27)).setText(a);
                                        setResult(RESULT_OK, intent);


                                        isA=true;
                                        if (isChooB = true) {Intent inkntent = new Intent(NotificationActivity.this,BusinessActivity.class);
                                            setResult(RESULT_OK, inkntent);
                                        }
                                        if (isChooP = true) {Intent ikntent = new Intent(NotificationActivity.this,ProfileActivity.class);

                                            setResult(RESULT_OK, ikntent);
                                        }

                                        Toast.makeText(NotificationActivity.this, "Answered", Toast.LENGTH_LONG).show();

                                    }
                                });

                if (isAn = true) {

                    KEY_NAME.equals("");

                }
            }

            public View getView(final int position, View convertView, View parent) {
                View view = convertView;
                if (view == null) { button14 = (Button) view.findViewById(R.id.button14);
                    button13 = (Button) view.findViewById(R.id.button13);
                    button15 = (Button) view.findViewById(R.id.button15);

                }
                return view;
            }


            protected void removeItemFromList(int position) {
                final int deletePosition = position;

                AlertDialog.Builder alert = new AlertDialog.Builder(
                        NotificationActivity.this);


            }
        });}});
            };;});;}}