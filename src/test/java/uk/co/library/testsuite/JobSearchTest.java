package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.pages.Homepage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

public class JobSearchTest extends BaseTest {
    Homepage homepage;
    ResultPage resultPage;

    @BeforeMethod
    public void init() {
        homepage = new Homepage();

        resultPage = new ResultPage();
    }

    @Test(groups = {"regression"}, dataProvider = "criteria", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
                                                           String result) {

        homepage.setAcceptCookies();
        homepage.enterJobTitle(jobTitle);
        homepage.enterLocation(location);
        homepage.selectDistance(distance);
        homepage.clickOnMoreSearchOptionLink();
        homepage.enterMinSalary(salaryMin);
        homepage.enterMaxSalary(salaryMax);
        homepage.selectSalaryType(salaryType);
        homepage.selectJobType(jobType);
        homepage.clickOnFindJobsButton();
        resultPage.verifyTheResults(result);

    }


}



