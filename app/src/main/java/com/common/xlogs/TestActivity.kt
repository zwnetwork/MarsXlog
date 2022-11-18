package com.common.xlogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.common.loglib.PPLog

/**
 *
 * @description
 * @author : create by zhanwei
 * @time 2022/11/18 13:58
 */
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PPLog.init("", true)
        PPLog.e(TestActivity::class.java.simpleName, "begin")
    }
}
