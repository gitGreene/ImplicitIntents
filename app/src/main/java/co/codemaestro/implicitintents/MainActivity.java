package co.codemaestro.implicitintents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;
//    private static final int REQUEST_IMAGE_CAPTURE = 1;
//    private ImageView mImageView;
//    private String mCurrentPhotoPath;
//    private File photoFile;
//    public String photoFileName = "photo.jpg";
//    public final String APP_TAG = "ImplicitIntents";
//    public ImageView ivPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
//        ivPreview = findViewById(R.id.ivPreview);

    }

    public void openWebsite(View view) {

        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }

    }

    public void openLocation(View view) {

        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void shareText(View view) {

        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooserTitle)
                .setText(txt)
                .startChooser();
    }

//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                Log.d("PHOTO CAPTURE ERROR", "PHOTO CAPTURE FAILED");
//            }
//            if (photoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(this, "co.codemaestro.implicitintents.fileprovider", photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//            }
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            mImageView.setImageBitmap(imageBitmap);
//        }
//    }
//
//    private File createImageFile() throws IOException {
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,
//                ".jpg",
//                storageDir
//        );
//        mCurrentPhotoPath = image.getAbsolutePath();
//        return image;
//    }

//    public void onLaunchCamera(View view) {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        photoFile = getPhotoFileUri(photoFileName);
//        Uri fileProvider = FileProvider.getUriForFile(this, "co.codemaestro.implicitintents", photoFile);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);
//
//        if(intent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
//        }
//
//    }
//
//    public File getPhotoFileUri(String fileName) {
//        File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),APP_TAG);
//
//        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
//            Log.d(APP_TAG, "FAILED TO CREATE DIRECTORY");
//        }
//
//        File file = new File(mediaStorageDir.getPath() + File.separator + fileName);
//        return file;
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE) {
//            if(resultCode == RESULT_OK){
//                Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
//
//                ImageView ivPreview = (ImageView) findViewById(R.id.ivPreview);
//                ivPreview.setImageBitmap(takenImage);
//            } else {
//                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
