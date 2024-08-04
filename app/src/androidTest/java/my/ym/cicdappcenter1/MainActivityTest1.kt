package my.ym.cicdappcenter1

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import my.ym.cicdappcenter1.ui.theme.CICDAppCenter1Theme
import org.junit.Rule
import org.junit.Test
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.junit.After

class MainActivityTest1 {

    @get:Rule val composeTestRule = createComposeRule()

    @get:Rule val reportHelper: ReportHelper = Factory.getReportHelper()

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            CICDAppCenter1Theme {
                FakeScreen2()
            }
        }

        composeTestRule.onNodeWithText("Clicked 0").assertIsDisplayed()

        composeTestRule.onNodeWithText("Clicked 0").performClick()

        composeTestRule.onNodeWithText("Clicked 1").assertIsDisplayed()
    }

    @After
    fun tearDown() {
        reportHelper.label("Done isa.")
    }

}
