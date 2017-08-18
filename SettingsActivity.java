package com.teller.kwill.teller;

/**
 * Created by kwill on 8/12/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SettingsActivity extends AppCompatActivity {
    TextView textView9, textView14, textView105, textView13, njjo, njjob;
    CheckBox checkBox2, checkBox3;
    Button button19, button18, button20;
    private Camera mCamera;
    private Camera.PictureCallback mPicture;
    private Context myContext;
    ImageView camera_preview;
    boolean isAnA;
    boolean isAn;
    boolean isChooP;
    boolean isChooB;
    private boolean cameraFront = false;

    static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textView9 = (TextView) findViewById(R.id.textView9);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView105 = (TextView) findViewById(R.id.textView105);
        textView13 = (TextView) findViewById(R.id.textView13);
        njjo = (TextView) findViewById(R.id.njjo);
        njjob = (TextView) findViewById(R.id.njjob);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        button19 = (Button) findViewById(R.id.button19);
        button18 = (Button) findViewById(R.id.button18);
        button20 = (Button) findViewById(R.id.button20);
        camera_preview = (ImageView) findViewById(R.id.camera_preview);
    }

    private int findFrontFacingCamera() {
        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                cameraId = i;
                cameraFront = true;
                break;
            }
        }
        return cameraId;
    }

    private int findBackFacingCamera() {
        int cameraId = -1;
        //Search for the back facing camera
        //get the number of cameras
        int numberOfCameras = Camera.getNumberOfCameras();
        //for every camera check
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                cameraId = i;
                cameraFront = false;
                break;
            }
        }
        return cameraId;
    }

    public void onResume() {
        super.onResume();
        if (!hasCamera(myContext)) {
            Toast toast = Toast.makeText(myContext, "Sorry, your phone does not have a camera!", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
        if (mCamera == null) {
            //if the front facing camera does not exist
            {
                //release the old camera instance
                //switch camera, from the front and the back and vice versa


                chooseCamera();
            }
            {
                Toast toast = Toast.makeText(myContext, "Sorry, your phone has only one camera!", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    ;

    private static File getOutputMediaFile() {
        //make a new file directory inside the "sdcard" folder
        File mediaStorageDir = new File("/sdcard/", "JCG Camera");

        //if this "JCGCamera folder does not exist
        if (!mediaStorageDir.exists()) {
            //if you cannot make this folder return
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        //take the current timeStamp
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        //and make a media file:
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");

        return mediaFile;
    }

    public void chooseCamera() {
        //if the camera preview is the front
        if (cameraFront) {
            int cameraId = findBackFacingCamera();
            if (cameraId >= 0) {
                //open the backFacingCamera
                //set a picture callback
                //refresh the preview

                mCamera = Camera.open(cameraId);
                mPicture = getPictureCallback();

            }
        } else {
            int cameraId = findFrontFacingCamera();
            if (cameraId >= 0) {
                //open the backFacingCamera
                //set a picture callback
                //refresh the preview

                mCamera = Camera.open(cameraId);
                mPicture = getPictureCallback();

            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //when on Pause, release camera in order to be used from other applications

    }

    private boolean hasCamera(Context context) {
        //check if the device has camera
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    private Camera.PictureCallback getPictureCallback() {
        Camera.PictureCallback picture = new Camera.PictureCallback() {

            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                //make a new picture file
                File pictureFile = getOutputMediaFile();

                if (pictureFile == null) {
                    return;
                }
                try {
                    //write the file
                    FileOutputStream fos = new FileOutputStream(pictureFile);
                    fos.write(data);
                    fos.close();
                    Toast toast = Toast.makeText(myContext, "Picture saved: " + pictureFile.getName(), Toast.LENGTH_LONG);
                    toast.show();

                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }

                //refresh camera to continue preview

            }
        };
        return picture;
    }

    private void saveBitmap(Bitmap bmp, String fileName) {
        try {
            File pictureFile = getOutputMediaFile();
            camera_preview.setImageBitmap(bmp);
            FileOutputStream fos = new FileOutputStream(pictureFile);
            File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + fileName + ".png");
            bmp.compress(Bitmap.CompressFormat.PNG, 90, fos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        checkBox2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    isAnA = false;
                    Toast.makeText(SettingsActivity.this,
                            "Anonymity not allowed", Toast.LENGTH_LONG).show();
                }

            }
        });

        checkBox3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    isAn = true;
                    KEY_NAME.equals("");
                    Toast.makeText(SettingsActivity.this,
                            "Anonymous ", Toast.LENGTH_LONG).show();
                }

            }
        });


        button19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                File pictureFile = getOutputMediaFile();
                String uri_Strn = pictureFile.toString();
                if (isChooP = true) {Intent intent = new Intent(SettingsActivity.this,ProfileActivity.class);

                    setResult(RESULT_OK, intent);
                }
                Intent intent = getIntent();
                mCamera.takePicture(null, null, mPicture);
                intent.putExtra("uri_Sme", uri_Strn);
                setResult(RESULT_OK, intent);
                startActivity(intent);

                if (isChooB = true) {Intent inntent = new Intent(SettingsActivity.this,BusinessActivity.class);inntent.putExtra("uri_Sme", uri_Strn);
                    setResult(RESULT_OK, inntent);
                    startActivity(inntent);
                }

            }

        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //or some other task
                Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                while (phones.moveToNext()) {
                    String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();

                }
                phones.close();


            }
        });
        njjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //or some other task
                String url = "https://telleriblog.wordpress.com/contact/";

                Uri uri = Uri.parse(url);
                Intent intent = new Intent();
                intent.setData(uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //or some other task
                startActivity(new Intent(SettingsActivity.this, BlockedActivity.class));


            }
        });
        njjo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //or some other task
                String url = "https://telleriblog.wordpress.com/2017/08/16/privacy-policy/";

                Uri uri = Uri.parse(url);
                Intent intent = new Intent();
                intent.setData(uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


            }
        });


    }
}