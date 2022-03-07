package com.proyecto_selenium_mercury_tours_pom;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
// @SelectPackages("com.proyecto_selenium_mercury_tours_pom") => sin orden de TestCases
@SelectClasses({RegisterTest.class, SignInTest.class}) // => con orden de TestCases

//Es el TestSuite
public class MercuryTests {

}
