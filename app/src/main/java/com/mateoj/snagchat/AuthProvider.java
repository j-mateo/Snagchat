package com.mateoj.snagchat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * Created by jose.mateoacosta on 4/14/17.
 */

public class AuthProvider {
    private static AuthProvider INSTANCE;
    private FirebaseAuth firebaseAuth;
    private AuthProvider() {
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    public static AuthProvider getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AuthProvider();

        return INSTANCE;
    }

    public boolean isLoggedIn() {
        return firebaseAuth.getCurrentUser() != null;
    }

    public Task<AuthResult> SignUp(String email, String password) {
        return firebaseAuth.createUserWithEmailAndPassword(email, password);
    }
}
