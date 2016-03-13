package workshop;

import org.junit.Before;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewAbstract {

    @Before
    public void setUp() throws Exception {

        open("http://10.211.55.3:9090/gst2016/gstool/targetObject.jsf");


    }
}
