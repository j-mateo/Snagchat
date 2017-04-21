package com.mateoj.snagchat.mvp.signup;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mateoj.snagchat.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupNameFragment extends Fragment  {
    @BindView(R.id.signup_btn)
    Button signupBtn;

    @BindView(R.id.signup_first_name)
    EditText firstName;

    @BindView(R.id.signup_last_name)
    EditText lastName;

    @BindView(R.id.signup_email)
    EditText email;

    @BindView(R.id.signup_password)
    EditText password;


    private Callbacks callbacks;

    public SignupNameFragment() {
        // Required empty public constructor
    }

    public static SignupNameFragment newInstance() {
        return new SignupNameFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup_name, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        signupBtn.setEnabled(false);
    }

    @OnTextChanged({R.id.signup_first_name, R.id.signup_last_name})
    public void onInputChanged() {
        boolean valid = true;
        if (firstName.getText().toString().equals(""))
            valid = false;

        if (lastName.getText().toString().equals(""))
            valid = false;

        signupBtn.setEnabled(valid);
    }

    @OnClick(R.id.signup_btn)
    public void onSignupClicked() {
        this.callbacks.onNameEntered(firstName.getText().toString(),
                lastName.getText().toString(),
                email.getText().toString(),
                password.getText().toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.callbacks = (Callbacks) context;
    }

    interface Callbacks {
        void onNameEntered(String firstName, String lastName, String email, String password);
    }
}
