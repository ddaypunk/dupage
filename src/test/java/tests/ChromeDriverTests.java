package tests;

import com.ddaypunk.dupage.aut.models.implementations.web.WebGoogleHome;
import com.ddaypunk.dupage.aut.models.implementations.web.WebGoogleResults;
import com.ddaypunk.dupage.config.DupageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DupageConfig.class)
//@SpringBootTest(classes = DupageApplication.class)
public class ChromeDriverTests extends BaseTest{

        @Autowired
        WebGoogleHome webGoogleHome;

        @Autowired
        WebGoogleResults webGoogleResults;

        @Test
        public void run() {
                webGoogleHome.load();
                webGoogleHome.searchFor("Star Wars");
                webGoogleResults.getFirstResultTitle().contains("Star Wars");
        }
}
