package org.bookstoreapp.controllers;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;
import org.bookstoreapp.exceptions.UsernameAlreadyExistsException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.bookstoreapp.services.FileSystemService;
import org.bookstoreapp.model.User;
import org.bookstoreapp.services.UserService;
import org.testfx.framework.junit.ApplicationTest;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class RegistrationControllerTest extends ApplicationTest {
    public static final String TEST_USER = "testUser";
    public static final String TEST_PASSWORD = "testPassword";
    private RegistrationController controller;

    @BeforeClass
    public static void setupClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initApplicationHomeDirIfNeeded();
        UserService.loadUsersFromFile();
    }

    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getPathToFile().toFile());
        UserService.loadUsersFromFile();

        controller = new RegistrationController();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.role = new ChoiceBox();
        controller.registrationMessage = new Text();

        controller.passwordField.setText(TEST_PASSWORD);
        controller.usernameField.setText(TEST_USER);
    }

    @Test
    public void testHandleAddUserActionCode() throws Exception {
        controller.handleRegisterAction();
        assertEquals(1, UserService.getUsers().size());
        assertEquals("Account created successfully!", controller.registrationMessage.getText());
    }

    @Test
    public void testAddSameUserTwice() throws Exception {
        controller.handleRegisterAction();
        controller.handleRegisterAction();
        assertEquals("An account with the username " + TEST_USER + " already exists!", controller.registrationMessage.getText());
    }
}