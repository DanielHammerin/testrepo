package Testfolder;

import junit.framework.TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Daniel on 2015-11-11.
 */
public class TestRunner {
    public static void main(String[] args) {
        Result res = JUnitCore.runClasses(TestSuite.class);
        for (Failure fail : res.getFailures()) {
            System.out.println(fail.toString());
        }
        System.out.println(res.wasSuccessful());
    }

}
