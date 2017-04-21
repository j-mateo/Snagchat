package com.mateoj.snagchat;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flurgle.camerakit.CameraListener;
import com.flurgle.camerakit.CameraView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {
    @BindView(R.id.camera)
    CameraView cameraView;

    private CameraListener cameraListener = new CameraListener() {
        @Override
        public void onPictureTaken(byte[] jpeg) {
            super.onPictureTaken(jpeg);
            final long startTime = System.currentTimeMillis();

            long callbackTime = System.currentTimeMillis();
            Bitmap bitmap = BitmapFactory.decodeByteArray(jpeg, 0, jpeg.length);
            ResultHolder.dispose();
            ResultHolder.setImage(bitmap);
            ResultHolder.setNativeCaptureSize(

                            cameraView.getCaptureSize()
            );

            ResultHolder.setTimeToCallback(callbackTime - startTime);
            Intent intent = new Intent(CameraFragment.this.getContext(), PictureActivity.class);
            startActivity(intent);
        }

    };


    public CameraFragment() {
        // Required empty public constructor
    }

    public static CameraFragment newInstance() {
        return new CameraFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        cameraView.setCameraListener(cameraListener);
    }

    @Override
    public void onPause() {
        cameraView.stop();

        super.onPause();
    }

    @Override
    public void onResume() {
        cameraView.start();

        super.onResume();
    }

    @OnClick(R.id.button)
    public void onClickCameraButton() {
        cameraView.captureImage();
    }
}
