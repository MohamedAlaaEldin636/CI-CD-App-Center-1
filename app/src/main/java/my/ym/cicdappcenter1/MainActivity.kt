package my.ym.cicdappcenter1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.ym.cicdappcenter1.ui.theme.CICDAppCenter1Theme
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.Flags
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.EventProperties
import com.microsoft.appcenter.crashes.Crashes;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCenter.start(
            application,
            "1b3e21e4-51fa-47e0-b671-fa7242b16b16",
            Analytics::class.java,
            Crashes::class.java,
        )

        setContent {
            CICDAppCenter1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Android DJASDJALD")

                        Spacer(modifier = Modifier.height(24.dp))

                        var toast: Toast? by remember { mutableStateOf(null) }
                        val context = LocalContext.current
                        val cancelToast: () -> Unit = {
                            toast?.cancel()
                            toast = null
                        }
                        val showToast: (String) -> Unit = {
                            cancelToast()
                            toast = Toast.makeText(context, it, Toast.LENGTH_SHORT)
                            toast?.show()
                        }

                        var counter by rememberSaveable { mutableStateOf(0) }

                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                val properties = EventProperties()
                                    .set("value 1", 10)
                                    .set("value 2", 20)
                                    .set("value 3", 30)

                                Analytics.trackEvent(
                                    "Clicked button of Calculate with props and critical isa",
                                    properties,
                                    Flags.CRITICAL
                                )

                                showToast("Clicked el7")

                                counter++

                                //throw RuntimeException("Trial 1")
                                //Crashes.generateTestCrash()
                            },
                        ) {
                            Text(text = "Calculate Clicked $counter")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FakeScreen2() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var toast: Toast? by remember { mutableStateOf(null) }
        val context = LocalContext.current
        val cancelToast: () -> Unit = {
            toast?.cancel()
            toast = null
        }
        val showToast: (String) -> Unit = {
            cancelToast()
            toast = Toast.makeText(context, it, Toast.LENGTH_SHORT)
            toast?.show()
        }

        var counter by rememberSaveable { mutableStateOf(0) }

        Button(
            onClick = {
                counter++

                showToast("Clicked el7 & isa.")
            }
        ) {
            Text(
                modifier = Modifier.clickable { counter++ },
                text = "Clicked $counter"
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CICDAppCenter1Theme {
        Greeting("Android")
    }
}