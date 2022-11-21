package com.common.loglib.vo;

import static com.tencent.mars.xlog.Xlog.AppednerModeAsync;
import static com.tencent.mars.xlog.Xlog.LEVEL_INFO;
import static com.tencent.mars.xlog.Xlog.ZLIB_MODE;

public class LogConfig {
		public int level = LEVEL_INFO;
		public int mode = AppednerModeAsync;
		public String logdir;
		public String nameprefix;
		public String pubkey = "";
		public int compressmode = ZLIB_MODE;
		public int compresslevel = 0;
		public String cachedir;
		public int cachedays = 0;
	}