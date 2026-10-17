package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static drivers.DriverFactory.quitDriver;
import static drivers.DriverFactory.startDriver;

public class TestHooks {

    @Before
    public void setUp() {
        startDriver();
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}
