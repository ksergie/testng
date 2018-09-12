package com.ksergie;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    private LoginPage loginPage;

    @DataProvider
    public Object [][] getLoginData(){
        return new String [][]{
                {"ksergie@gmail.com", "Ckfdfnhele_1"}
        };
    }

    @Test(dataProvider = "getLoginData")
    public void testLogin(String userName, String userPasswd){
        loginPage = new LoginPage(driver);
        loginPage.login(userName, userPasswd);
    }
}
