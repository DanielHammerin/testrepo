package Testfolder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Daniel on 2015-11-11.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses ({
    TestMemberHandling.class
})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setup.");
    }

    @AfterClass
    public static void takeDownClass() {
        System.out.println("Take down.");
    }
}
