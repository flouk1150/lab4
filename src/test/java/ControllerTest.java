import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ControllerTest {


    public String setUp(){
        return Controller.getTestName();
    }
    @Test

    public  void test(){

        Assertions.assertEquals( setUp(), Controller.test());

    }

}