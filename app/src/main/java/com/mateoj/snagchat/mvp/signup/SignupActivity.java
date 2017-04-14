package com.mateoj.snagchat.mvp.signup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mateoj.snagchat.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity implements SignupContract.SignupView,
        SignupNameFragment.Callbacks, SignupBirthdayFragment.Callbacks  {
    private SignupContract.SignupPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        presenter = new SignupPresenterImp(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, SignupNameFragment.newInstance())
                    .commit();
        }
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, SignupActivity.class));
    }

    @Override
    public void onNameEntered(String firstName, String lastName) {
        this.presenter.nameEntered(firstName, lastName);
    }

    @Override
    public void showBirthdayFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, SignupBirthdayFragment.newInstance())
                .commit();
    }

    @Override
    public void onBirthday(int month, int day, int year) {

    }
}
