package ads.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

/**
 *
 * @author QiuJie
 */
fun Dp.sp(density: Density) = with(density) {
    this@sp.toSp()
}

@Composable
fun Dp.sp() = with(LocalDensity.current) {
    this@sp.toSp()
}