
package com.teller.kwill.teller;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;
import java.io.File;
import android.widget.ImageView;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;


public class BillyActivity extends Activity {
	// SAMPLE APP CONSTANTS
	private static final String LOG_TAG = "iabv3";

    // PRODUCT & SUBSCRIPTION IDS
    private static final String PRODUCT_ID = "";
    private static final String SUBSCRIPTION_ID = "com.anjlab.test.iab.subs1";
    private static final String LICENSE_KEY = ""; // PUT YOUR MERCHANT KEY HERE;
    // put your Google merchant id here (as stated in public profile of your Payments Merchant Center)
    // if filled library will provide protection against Freedom alike Play Market simulators
    private static final String MERCHANT_ID="";
    Button productDetailsButton,button21,subscribeButton,purchaseButton,consumeButton;
    ImageButton imageButton;
    ImageView imageView4,imageView6,imageView7,imageView8,imageView5,imageView9b;
    EditText editText2u;
	private BillingProcessor bp;
	private boolean readyToPurchase = false;
    private Uri fileUri;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    public static BillyActivity ActivityContext =null;
    static final String KEY_NAME = "name";
    private Context mContext;
    boolean isAn;
    boolean isBlo;
    boolean isUnB;
    boolean isAnA;
    boolean isSent;
    boolean isG;
    int countes = 0;
    int countesd = 0;
    String str=null;
    byte[] send_data = new byte[1024];
    byte[] receiveData = new byte[1024];
    String modifiedSentence;
    public static TextView output;
    static int TAKE_PICTURE = 1;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billy);


        ActivityContext = this;

        productDetailsButton= (Button) findViewById(R.id.productDetailsButton);
        output = (TextView)findViewById(R.id.kkb);
        button21= (Button) findViewById(R.id.button21);
        purchaseButton= (Button) findViewById(R.id.purchaseButton);
        consumeButton= (Button) findViewById(R.id.consumeButton);
        imageButton= (ImageButton) findViewById(R.id.imageButton);
        imageView4= (ImageView) findViewById(R.id.imageView4);
        imageView5= (ImageView) findViewById(R.id.imageView5);
        imageView6= (ImageView) findViewById(R.id.imageView6);
        imageView7= (ImageView) findViewById(R.id.imageView7);
        imageView8= (ImageView) findViewById(R.id.imageView8);
        imageView9b= (ImageView) findViewById(R.id.imageView9b);
        editText2u= (EditText) findViewById(R.id.editText2u);
        subscribeButton= (Button) findViewById(R.id.subscribeButton);
        output = (TextView)findViewById(R.id.kkb);}
    public void showNotification() {Intent intentSetDefault = new Intent(mContext, BillyActivity.class);
        PendingIntent piSetDeafult = PendingIntent.getActivity(mContext, 0, intentSetDefault,
                PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent (this, BillyActivity.class), 0);
        Resources r = getResources();

        Notification noti = new Notification.Builder(mContext)
                .setContentTitle("New content from " + KEY_NAME.toString())
                .setSmallIcon(R.drawable.how)
                .build();




        notifyAll();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, noti);

    subscribeButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {


                // create new Intentwith with Standard Intent action that can be
                // sent to have the camera application capture an video and return it.
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PICTURE);
                Bundle bn = getIntent().getExtras();
                String uri_Strb = bn.getString("uri_Smo");

                cameraIntent.putExtra("uri_Smo", uri_Strb);
            }});

        imageButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                Bundle bn = getIntent().getExtras();
                Intent intent = getIntent();
                String uri_Strke = bn.getString("uri_Strke");
                intent.putExtra("uri_Strke", uri_Strke);
                String uri_Strb = bn.getString("uri_Smo");
                intent.putExtra("uri_Smo", uri_Strb);
                Intent iantent = new Intent(BillyActivity.this,ProfileActivity.class);
                setResult(RESULT_OK, iantent);
                startActivity(iantent);
            }});

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {isSent=true;countesd--;
                String yoh = editText2u.toString();
                String yohu = editText2u.toString();
                Intent intent = getIntent();
                intent.putExtra("name", yoh);
                intent.putExtra("public_profile", yohu);
                Bundle bn = getIntent().getExtras();
                String uri_Strke = bn.getString("uri_Strke");
                intent.putExtra("uri_Strke", uri_Strke);
                String uri_Strb = bn.getString("uri_Smo");
                intent.putExtra("uri_Smo", uri_Strb);
                String yoe = getIntent().getStringExtra("public_profile");
                String yol = getIntent().getStringExtra("name");
                intent.putExtra("name", "sent you a video");
                intent.putExtra("public_profile", "sent you a video");
                intent.putExtra("message", "sent you a video");
                intent.putExtra("messagen", "sent you a video");
                intent.putExtra("name", "sent you a picture");
                intent.putExtra("public_profile", "sent you a picture");
                intent.putExtra("message", "sent you a picture");
                intent.putExtra("messagen", "sent you a picture");
                Intent ilkntent = new Intent(BillyActivity.this,NotificationActivity.class);
                setResult(RESULT_OK, ilkntent);
                setResult(RESULT_OK, intent);
                getIntent();
                str="uri_Strke";
                str="uri_Smo";
                str="public_profile";
                str="name";
                try {intent.putExtra("name", yoh); intent.putExtra("public_profile", yohu);intent.putExtra("uri_Strke", uri_Strke);intent.putExtra("uri_Smo", uri_Strb);
                    client(); showNotification();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                countes++;
                if (countes == 10) {

                    imageView8.setVisibility(View.VISIBLE);

                    Toast.makeText(BillyActivity.this, "Congrats you've sent 10 posts!",
                            Toast.LENGTH_SHORT).show();
                }
                if (countes == 20) {

                    imageView7.setVisibility(View.VISIBLE);

                    Toast.makeText(BillyActivity.this, "Congrats you've sent 20 posts",
                            Toast.LENGTH_SHORT).show();
                }
                if (countes == 30) {

                    imageView7.setVisibility(View.VISIBLE);

                    Toast.makeText(BillyActivity.this, "Congrats you've sent 30 posts",
                            Toast.LENGTH_SHORT).show();
                }
                if (countes == 40) {

                    imageView6.setVisibility(View.VISIBLE);

                    Toast.makeText(BillyActivity.this, "Congrats you've sent 40 posts",
                            Toast.LENGTH_SHORT).show();
                }
                if (countes == 100) {
                    isG=true;
                    imageView9b.setVisibility(View.VISIBLE);

                    Toast.makeText(BillyActivity.this, "Congrats you've sent 100 posts",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        if (isBlo = true) {

            String yoe = getIntent().getStringExtra("public_profile");
            String yol = getIntent().getStringExtra("name");
            Intent intent = getIntent();
            Bundle bn = getIntent().getExtras();
            String uri_Strke = bn.getString("uri_Strke");
            intent.putExtra("uri_Strke", uri_Strke);
            String uri_Strb = bn.getString("uri_Smo");
            intent.putExtra("uri_Smo", uri_Strb);


            getIntent();
            str = "name";
            str = "public_profile";
            str = "uri_Strke";
            str = "uri_Smo";
            try {isDestroyed();
                client();
                //txt1.setText(modifiedSentence);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if(countesd == 0);

        {
            productDetailsButton.setVisibility(View.INVISIBLE);
            editText2u.setVisibility(View.INVISIBLE);
            imageButton.setVisibility(View.INVISIBLE);
            button21.setVisibility(View.INVISIBLE);
            imageView4.setVisibility(View.INVISIBLE);
            subscribeButton.setVisibility(View.INVISIBLE);
            imageView5.setVisibility(View.VISIBLE);
        }
        if(isG = true);

        {
            productDetailsButton.setVisibility(View.VISIBLE);
            editText2u.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.VISIBLE);
            button21.setVisibility(View.VISIBLE);
            imageView4.setVisibility(View.VISIBLE);
            subscribeButton.setVisibility(View.VISIBLE);
            imageView5.setVisibility(View.INVISIBLE);
            purchaseButton.setVisibility(View.INVISIBLE);
            consumeButton.setVisibility(View.INVISIBLE);
        }
        if (isAnA = true) {

            String yoe = getIntent().getStringExtra("public_profile");
            String yol = getIntent().getStringExtra("name");
            Intent intent = getIntent();
            Bundle bn = getIntent().getExtras();
            String uri_Strke = bn.getString("uri_Strke");
            intent.putExtra("uri_Strke", uri_Strke);
            String uri_Strb = bn.getString("uri_Smo");
            intent.putExtra("uri_Smo", uri_Strb);

            getIntent();
            str = "name";
            str = "public_profile";
            str = "uri_Strke";
            str = "uri_Smo";
            try {isDestroyed();
                client();
                //txt1.setText(modifiedSentence);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        if (isAn = true)

        {
            KEY_NAME.equals("");
        }
        if (isSent = true)

        {
            countesd--;
        }
        if(isUnB=true){


            String yoe = getIntent().getStringExtra("public_profile");
            String yol = getIntent().getStringExtra("name");
            Intent intent = getIntent();
            Bundle bn = getIntent().getExtras();
            String uri_Strke = bn.getString("uri_Strke");
            intent.putExtra("uri_Strke", uri_Strke);
            String uri_Strb = bn.getString("uri_Smo");
            intent.putExtra("uri_Smo", uri_Strb);

            getIntent();
            str = "name";
            str = "public_profile";
            str = "uri_Strke";
            str = "uri_Smo";
            try {
                client();
                //txt1.setText(modifiedSentence);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        productDetailsButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {


                // create new Intentwith with Standard Intent action that can be
                // sent to have the camera application capture an video and return it.
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

                // create a file to save the video
                fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
                Bundle bn = getIntent().getExtras();
                String uri_Strke = bn.getString("uri_Strke");

                intent.putExtra("uri_Strke", uri_Strke);
                // set the image file name
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                Intent ibntent = getIntent();
                String yoh = KEY_NAME.toString();
                String yohu = KEY_NAME.toString();
                String yoe = getIntent().getStringExtra("public_profile");
                String yol = getIntent().getStringExtra("name");
                ibntent.putExtra("name", yoh);
                ibntent.putExtra("public_profile", yohu);
                setResult(RESULT_OK, intent);
                setResult(RESULT_OK, ibntent);
                getIntent();
                // set the video image quality to high
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                Uri urin = Uri.parse(uri_Strke);


                // start the Video Capture Intent
                startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);

            }});}

    private static Uri getOutputMediaFileUri(int type){

        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){

        // Check that the SDCard is mounted
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraVideo");


        // Create the storage directory(MyCameraVideo) if it does not exist
        if (! mediaStorageDir.exists()){

            if (! mediaStorageDir.mkdirs()){

                output.setText("Failed to create directory MyCameraVideo.");

                Toast.makeText(ActivityContext, "Failed to create directory MyCameraVideo.",
                        Toast.LENGTH_LONG).show();

                Log.d("MyCameraVideo", "Failed to create directory MyCameraVideo.");
                return null;
            }
        }


        // Create a media file name

        // For unique file name appending current timeStamp with file name
        java.util.Date date= new java.util.Date();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(date.getTime());

        File mediaFile;

        if(type == MEDIA_TYPE_VIDEO) {

            // For unique video file name appending current timeStamp with file name
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");

        } else {
            return null;
        }

        return mediaFile;
    }

    public void client() throws IOException{


        DatagramSocket client_socket = new DatagramSocket(2362);
        InetAddress IPAddress =  InetAddress.getByName("10.80.1.95");

        //while (true)
        // {
        send_data = str.getBytes();
        //System.out.println("Type Something (q or Q to quit): ");

        DatagramPacket send_packet = new DatagramPacket(send_data,str.length(), IPAddress, 2362);
        client_socket.send(send_packet);
        //chandra
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        client_socket.receive(receivePacket);
        modifiedSentence = new String(receivePacket.getData());
        //System.out.println("FROM SERVER:" + modifiedSentence);

        modifiedSentence=null;
        client_socket.close();

        // }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // After camera screen this code will excuted

        if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                output.setText("Video File : " +data.getData());

                // Video captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Video saved to "
                         +
                        data.getData(), Toast.LENGTH_LONG).show();

            } else if (resultCode == RESULT_CANCELED) {

                output.setText("User cancelled the video capture.");

                // User cancelled the video capture
                Toast.makeText(this, "User cancelled the video capture.",
                        Toast.LENGTH_LONG).show();

            } else {

                output.setText("Video capture failed.");

                // Video capture failed, advise user
                Toast.makeText(this, "Video capture failed.",
                        Toast.LENGTH_LONG).show();
            }
        }


        {


            if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PICTURE);
                Bundle bn = getIntent().getExtras();
                String uri_Strb = bn.getString("uri_Smo");
                Bitmap photo = (Bitmap)cameraIntent.getExtras().get("uri_Smo");
                cameraIntent.putExtra("uri_Smo", uri_Strb);
                cameraIntent.getExtras().get("uri_Smo");
                imageView4.setImageBitmap(photo);
                imageView4.setVisibility(View.INVISIBLE);


            }
        }



        if(!BillingProcessor.isIabServiceAvailable(this)) {
            showToast("In-app billing service is unavailable, please upgrade Android Market/Play to version >= 3.9.16");
        }

        bp = new BillingProcessor(this, LICENSE_KEY, MERCHANT_ID, new BillingProcessor.IBillingHandler() {
            @Override
            public void onProductPurchased(String productId, TransactionDetails details) {
				showToast("onProductPurchased: " + productId);
                updateTextViews();
                unlockImage();
            }
            @Override
            public void onBillingError(int errorCode, Throwable error) {
                showToast("onBillingError: " + Integer.toString(errorCode));
            }
            @Override
            public void onBillingInitialized() {
				showToast("onBillingInitialized");
                readyToPurchase = true;
                updateTextViews();
                unlockImage();
            }
            @Override
            public void onPurchaseHistoryRestored() {
                showToast("onPurchaseHistoryRestored");
                for(String sku : bp.listOwnedProducts())
                    Log.d(LOG_TAG, "Owned Managed Product: " + sku);
                for(String sku : bp.listOwnedSubscriptions())
                    Log.d(LOG_TAG, "Owned Subscription: " + sku);
                updateTextViews();
            }
        });
    }
    public void unlockImage()
    {
        productDetailsButton.setVisibility(View.VISIBLE);
        editText2u.setVisibility(View.VISIBLE);
        imageButton.setVisibility(View.VISIBLE);
        button21.setVisibility(View.VISIBLE);
        imageView4.setVisibility(View.VISIBLE);
        imageView5.setVisibility(View.INVISIBLE);
        subscribeButton.setVisibility(View.VISIBLE);
    }

	@Override
	protected void onResume() {
		super.onResume();
        unlockImage();
		updateTextViews();
	}

	@Override
    public void onDestroy() {
        if (bp != null)
            bp.release();
        super.onDestroy();
    }


    protected void onActivityResultt(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data);
    }

    private void updateTextViews() {
        TextView text = (TextView)findViewById(R.id.productIdTextView);
        text.setText(countesd--);
        text.setText(String.format("5 is%s purchased", PRODUCT_ID, bp.isPurchased(PRODUCT_ID) ? "" : " not"));


        text = (TextView)findViewById(R.id.subscriptionIdTextView);
        text.setText(String.format("%s is%s subscribed", SUBSCRIPTION_ID, bp.isSubscribed(SUBSCRIPTION_ID) ? "" : " not"));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void onClick(View v) {
        if (!readyToPurchase) {
            showToast("Billing not initialized.");
            return;
        }
        switch (v.getId()) {
            case R.id.purchaseButton:
                bp.purchase(this,PRODUCT_ID);
                break;
            case R.id.consumeButton:
                Boolean consumed = bp.consumePurchase(PRODUCT_ID);
                updateTextViews();
                unlockImage();
                if (consumed)
                    showToast("Successfully consumed");
                break;

            default:
                break;
        }
    }

}
