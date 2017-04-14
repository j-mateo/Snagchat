package com.mateoj.snagchat;

/**
 * Created by jose.mateoacosta on 4/14/17.
 */

public class AuthProvider {

    private AuthProvider() {}

    public static AuthProvider getInstance() {
        return new AuthProvider();
    }

    public boolean isLoggedIn() {
        return false;
    }
}
