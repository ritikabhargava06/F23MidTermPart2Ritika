package com.example.f23midtermpart2ritika;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText productEditText;
    Button bTakePhoto;
    Button bSave;

    ImageView productImage;
    ActivityResultLauncher<Intent> productPhotoActivityLauncher;
    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productEditText = findViewById(R.id.productNameEditText);
        bTakePhoto = findViewById(R.id.takePhotoButton);
        bSave = findViewById(R.id.saveButton);
        productImage = findViewById(R.id.productImageView);

        productPhotoActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            imageBitmap = result.getData().getParcelableExtra("data");
                            productImage.setImageBitmap(imageBitmap);
                        }
                    }
                });

        bTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    productPhotoActivityLauncher.launch(cameraIntent);
                }else {
                    requestPermissions(new String []{Manifest.permission.CAMERA},100);
                }
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allFieldsEntered()){
                    Product p = new Product(productEditText.getText().toString(),imageBitmap);
                    ((MyApp)getApplication()).addToProductArrayList(p);
                    Intent productsListIntent = new Intent(MainActivity.this,ProductsListActivity.class);
                    startActivity(productsListIntent);
                }else{
                    Toast.makeText(MainActivity.this,R.string.all_fields_required_error_msg,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean allFieldsEntered() {
        return !productEditText.getText().toString().isEmpty() && imageBitmap!=null;
    }
}