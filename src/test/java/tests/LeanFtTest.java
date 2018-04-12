package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

    Browser browser;

    @BeforeClass
    public void beforeClass() throws Exception {
    }

    @AfterClass
    public void afterClass() throws Exception {
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.navigate("https://www.edgewordstraining.co.uk/training-site");
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        browser.closeAllTabs();
    }

    @Test
    public void simple_test() throws GeneralLeanFtException {

        Link homeLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Home ")
                .tagName("A").build());
        homeLink.click();

        Link basicHTMLLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Basic HTML ")
                .tagName("A").build());
        basicHTMLLink.click();

        Link cSSXPathLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("CSS/XPath ")
                .tagName("A").build());
        cSSXPathLink.click();

        homeLink.click();
    }

}