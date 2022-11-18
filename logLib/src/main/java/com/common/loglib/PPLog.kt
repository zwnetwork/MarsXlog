package com.common.loglib

import com.tencent.mars.xlog.Log
import com.tencent.mars.xlog.Xlog

object PPLog {
    private const val TAG = "PPLog"
    private const val PUB_KEY =
        "7f2b96e8d7487197e41399ee4b3d82d27670014141272cebb23c5c05b0bd242199aa9d2af889c9030f63c1e606da618fd4cf00dac5b03a93baee9f0a4ec8eb3a"

    init {
        kotlin.runCatching {
            System.loadLibrary("c++_shared")
            System.loadLibrary("marsxlog")
        }
    }

    /**
     * 初始化xlog 默认缓存七天
     */
    fun init(path: String, isDebug: Boolean = true, config: Xlog.XLogConfig? = null) {
        kotlin.runCatching {
            var logConfig = config
            if (logConfig == null) {
                logConfig = Xlog.XLogConfig()
                logConfig.mode = Xlog.AppednerModeAsync
                logConfig.logdir = path
                logConfig.pubkey = ""
                logConfig.compressmode = Xlog.ZLIB_MODE
                logConfig.compresslevel = 0
                logConfig.cachedir = ""
                logConfig.cachedays = 7
                Log.setLogImp(Xlog())
                if (isDebug) {
                    logConfig.level = Xlog.LEVEL_DEBUG
                    Log.setConsoleLogOpen(true)
                } else {
                    logConfig.level = Xlog.LEVEL_INFO
                    Log.setConsoleLogOpen(false)
                }
            }
            Xlog.open(
                false,
                logConfig.level,
                Xlog.AppednerModeAsync,
                "",
                path,
                logConfig.nameprefix,
                PUB_KEY
            )
        }
    }


    //=====================================================================================
    // v
    //=====================================================================================
    fun v(tag: String, format: String?) {
        runCommonCatch {
            Log.v(tag, format)
        }
    }

    fun v(format: Any?) {
        runCommonCatch {
            Log.v(TAG, format.toString())
        }
    }

    //=====================================================================================
    // f
    //=====================================================================================
    fun f(tag: String, format: String?) {
        runCommonCatch {
            Log.f(tag, format)
        }
    }

    fun f(format: Any?) {
        runCommonCatch {
            Log.f(TAG, format.toString())
        }
    }

    //=====================================================================================
    // e
    //=====================================================================================
    fun e(tag: String, format: String?) {
        runCommonCatch {
            Log.e(tag, format)
        }
    }

    fun e(format: Any?) {
        runCommonCatch {
            Log.e(TAG, format.toString())
        }
    }

    //=====================================================================================
    // w
    //=====================================================================================
    fun w(tag: String, format: String?) {
        runCommonCatch {
            Log.w(tag, format)
        }
    }

    fun w(format: Any?) {
        runCommonCatch {
            Log.w(TAG, format.toString())
        }
    }

    //=====================================================================================
    // w
    //=====================================================================================
    fun i(tag: String, format: String?) {
        runCommonCatch {
            Log.i(tag, format)
        }
    }

    fun i(format: Any?) {
        runCommonCatch {
            Log.i(TAG, format.toString())
        }
    }

    //=====================================================================================
    // d
    //=====================================================================================
    fun d(tag: String, format: String?) {
        runCommonCatch {
            Log.d(tag, format)
        }
    }

    fun d(format: Any?) {
        runCommonCatch {
            Log.d(TAG, format.toString())
        }
    }

    //关闭日志，不再写入程序退出时关闭日志：
    fun close() {
        runCommonCatch {
            Log.appenderClose()
        }
    }

    //当日志写入模式为异步时，调用该接口会把内存中的日志写入到文件。
    //isSync : true  为同步 flush，flush 结束后才会返回。
    //isSync : false 为异步 flush，不等待 flush 结束就返回。
    fun flush(isSync: Boolean) {
        runCommonCatch {
            Log.appenderFlushSync(isSync)
        }
    }

    private inline fun runCommonCatch(block: () -> Unit) {
        runCatching {
            block()
        }.onFailure {
            Log.w(TAG, it.toString())
        }
    }
}
