package utilites;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RunFailedTestCase implements IAnnotationTransformer {
        @Override
        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            annotation.setRetryAnalyzer(RetryListener.class);
        }

}
class RetryListener implements IRetryAnalyzer {
    int failCount = 0;
    int limit = 4;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (failCount < limit) {
            failCount++;
            return true;
        }
        return false;
    }
}