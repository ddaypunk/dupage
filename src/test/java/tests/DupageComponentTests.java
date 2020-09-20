package tests;

import com.ddaypunk.dupage.aut.models.implementations.web.WebPlaygroundHome;
import com.ddaypunk.dupage.config.DupageConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DupageConfig.class)
public class DupageComponentTests extends BaseTest{

    @Autowired
    private WebPlaygroundHome webPlaygroundHome;

    private static final Logger LOGGER = LogManager.getLogger("Component Tests");

    @Test
    public void testSiteWithButtonLoads() {
        // navigate to page
        LOGGER.info("Navigating to test page");
        webPlaygroundHome.load();
        webPlaygroundHome.clickLearnReact();

//        assertTrue(driver.getCurrentUrl().contains("reactjs.org"));
    }
}
