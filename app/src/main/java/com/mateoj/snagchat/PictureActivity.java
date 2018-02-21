package com.mateoj.snagchat;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PictureActivity extends AppCompatActivity {
    public static final String TAG = PictureActivity.class.getSimpleName();

    @BindView(R.id.text_overlay)
    EditText textOverlay;

    @BindView(R.id.imageView)
    ImageView imagePreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ButterKnife.bind(this);
        Bitmap bitmap = ResultHolder.getImage();
        if (bitmap == null) {
            finish();
            return;
        }

        imagePreview.setImageBitmap(bitmap);
    }


    @OnClick(R.id.imageView)
    public void onTapPicture() {
        if (textOverlay.getVisibility() != View.VISIBLE) {
            textOverlay.setVisibility(View.VISIBLE);
            textOverlay.requestFocus();
        } else if (textOverlay.getText().toString().equals("")){
            textOverlay.setVisibility(View.GONE);
        }
    }

}
