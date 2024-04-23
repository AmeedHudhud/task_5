package org.test.com;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class dataProvider {
    @DataProvider
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
            default:
                return null;
        }

    }
}
