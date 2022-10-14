package ads.compose.ui

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * @author QiuJie
 */
@Composable
fun CharSlider(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.then(
            Modifier.scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { delta ->
                    delta
                })
        ),
        userScrollEnabled = false
    ) {
        item {

        }
    }
}