package org.test.com;
import java.lang.reflect.Method;

public class DataProvider {
    @org.testng.annotations.DataProvider
    public Object[][] getData(Method method){
        switch (method.getName()) {
            case "logInByValidEmailAndPassword":
                return new Object[][] {
                        {"hudhudameed@gmail.com", "ameed0595", true},
                };
            case "logInByValidEmailAndInvalidPassword":
                return new Object[][] {
                        {"hudhudameed@gmail.com", "12345", false},
                };
            case "logInByInValidEmailAndvalidPassword":
                return new Object[][] {
                        {"hudhudameed0@gmail.com", "ameed0595", false},
                };
            case "LoginWithOnlyTheEmailFieldFilled":
                return new Object[][] {
                        {"hudhudameed0@gmail.com", "", false},
                };
            case "LoginWithOnlyThePasswordFieldFilled":
                return new Object[][] {
                        {"", "ameed0595", false},
                };
            case "LoginWithoutEnteringEmailAndPassword":
                return new Object[][] {
                        {"", "", false}
                };
            case "VerifyThatTheUserIsUnableToChangeThePasswordWithAOldMismatchedPassword":
                return new Object[][] {
                        {"ameed059", "123456789", "123456789", "The password you entered is incorrect. Please try again."}
                };
            case "VerifyThatTheUserIsUnableToChangeThePasswordWithANewMismatchedPassword":
                return new Object[][] {
                        {"ameed0595", "123456789", "12345678", "Password Mismatch"}
                };
            case "VerifyThatTheUserIsUnableToChangeThePasswordToTheSameExistingPassword":
                return new Object[][] {
                        {"ameed0595", "ameed0595", "ameed0595", "Old and new passwords cannot be the same"}
                };
            case "VerifyThatTheUserIsUnableToChangeThePasswordWithANewPasswordOfLessThan8Characters":
                return new Object[][] {
                        {"ameed0595", "12345", "12345", "Ensure this field has at least 8 characters."}
                };
            default:
                return null;
        }

    }
}
