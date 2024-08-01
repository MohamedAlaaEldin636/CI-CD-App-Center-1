package my.ym.cicdappcenter1

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import my.ym.cicdappcenter1.ui.theme.CICDAppCenter1Theme
import org.junit.Rule
import org.junit.Test

class MainActivityTest1 {

    @get:Rule val composeTestRule = createComposeRule()

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

}
