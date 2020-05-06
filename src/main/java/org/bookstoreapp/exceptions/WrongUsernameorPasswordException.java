package org.bookstoreapp.exceptions;

public class WrongUsernameorPasswordException extends Exception {
    public WrongUsernameorPasswordException() {
        super(String.format("Username or password is wrong!Please try again!"));
    }
}
