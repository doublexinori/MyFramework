import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by DoubleXInori on 2017/5/18.
 */
public class FirstTest {
    @BeforeClass
    public void a(){
        System.out.println("A");
    }
    @Test
    public void b(){
        System.out.println("B");
    }
    @AfterClass
    public void c(){
        System.out.println("C");
    }
}
