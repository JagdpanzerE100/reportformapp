package com.sp.p2032430assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Form extends AppCompatActivity {


    private Button upload,submit;
    private ImageView preview;
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText address;
    private EditText postal;
    private ImageView image;
    private EditText description;
    private Bitmap bitmap;
    FormHelper DB;

    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeAsUpIndicator(R.drawable.backbtn_2);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#253334"));
        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        upload = findViewById(R.id.upload_img);
        preview = findViewById(R.id.preview_img);
        submit = findViewById(R.id.submit_btn);
        image =  findViewById(R.id.preview_img);

        // handle the Choose Image button to trigger
        // the image chooser function
        upload.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                imageChooser();
                                            }
        });
        name = findViewById(R.id.formName);
        email = findViewById(R.id.formEmail);
        phone = findViewById(R.id.formPhone);
        address = findViewById(R.id.formAddress);
        postal = findViewById(R.id.formPostal);
        description = findViewById(R.id.formDescription);


        DB = new FormHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String emailTXT = email.getText().toString();
                String phoneTXT = phone.getText().toString();
                String addressTXT = address.getText().toString();
                String postalTXT = postal.getText().toString();
                String descriptionTXT = description.getText().toString();

                //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.home_bg);
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] img = byteArray.toByteArray();


                Boolean checkinsertdata = DB.insertuserdata(nameTXT, emailTXT, phoneTXT,addressTXT, postalTXT,descriptionTXT, img);
                if(checkinsertdata==true)
                    Toast.makeText(Form.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Form.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });



    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri imageURI = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageURI);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                if (null != imageURI) {
                    // update the preview image in the layout
                    preview.setImageURI(imageURI);
                }
            }
        }
    }
    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
