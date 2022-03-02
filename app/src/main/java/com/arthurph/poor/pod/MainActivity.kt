package com.arthurph.poor.pod

import android.net.wifi.WifiManager
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.getSystemService
import com.arthurph.poor.pod.fonts.Poppins

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Main(
                applicationContext.getSystemService<BatteryManager>()
                    ?.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY) ?: 50,
                applicationContext.getSystemService()
                //, applicationContext.getSystemService()
            )
        }
    }

    //@Preview
    @Composable
    fun Main(
        batteryPercentage: Int, wifi: WifiManager?, // bluetooth: BluetoothManager?
    ) {
        Image(
            painter = painterResource(
                when {
                    wifi!!.isWifiEnabled -> R.drawable.wifi_icon
                    else -> R.drawable.wifi_off
                }
            ),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .absolutePadding(
                    top = 4.dp,
                    left = 287.dp,
                    bottom = 3.dp,
                    right = 10.dp
                )
                .width(18.dp)
                .height(14.dp)
        )

        Text(
            "$batteryPercentage%",
            color = Color.White,
            modifier = Modifier
                .absolutePadding(
                    left = 310.dp, top = 1.8.dp
                ),
            fontFamily = Poppins.SEMI_BOLD,
        )

        Image(
            painter = painterResource(R.drawable.battery_icon),
            contentDescription = null,
            modifier = Modifier
                .absolutePadding(
                    top = 6.dp,
                    left = 343.dp,
                    bottom = 3.dp,
                    right = 3.dp
                )
                .width(12.dp)
        )
    }
}