package cc.niushuai.project.devcontrol.base.util;

import android.util.Log;

import java.util.Date;

import cc.niushuai.project.devcontrol.BuildConfig;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 记录日志工具
 *
 * @author niushuai233
 * @date 2022/10/26 15:34
 */
public class XLog {

    public static final String _Symbol1 = "#";
    /**
     * 日志总开关
     */
    public static boolean LOG_SWITCH = true;

    /**
     * 是否写入到文件
     */
    public static boolean LOG_SWITCH_TO_FILE = true;

    /**
     * 日志级别 默认info
     */
    public static int SET_ROOT_LEVEL = Level.INFO;

    /**
     * 日志保存最长时间
     */
    public static int LOG_SAVE_DAYS = 7;

    /**
     * <pre>
     *  输出日志格式
     *  2022-10-26 11:11:11:111 - [DEBUG] - packageName#methodName:lineNumber: message
     * </pre>
     */
    public static final String LOG_TEMPLATE = "{} - [{}] - {}: {}";

    static class Level {

        /**
         * 详细
         */
        public static final int VERBOSE = 2;

        /**
         * 调试
         */
        public static final int DEBUG = 3;

        /**
         * 一般
         */
        public static final int INFO = 4;

        /**
         * 警告
         */
        public static final int WARN = 5;

        /**
         * 错误
         */
        public static final int ERROR = 6;

        public static String transform(int level) {
            String str = "VERBOSE";
            if (VERBOSE == level) {
                str = "VERBOSE";
            } else if (DEBUG == level) {
                str = "DEBUG";
            } else if (INFO == level) {
                str = "INFO";
            } else if (WARN == level) {
                str = "WARN";
            } else if (ERROR == level) {
                str = "ERROR";
            }
            return StrUtil.format("%0.7s", str);
        }
    }

    public static void v(String tag, String message, Object... params) {
        log(tag, filterThr(message, params), Level.VERBOSE);
    }

    public static void d(String tag, String message, Object... params) {
        log(tag, filterThr(message, params), Level.DEBUG);
    }

    public static void i(String tag, String message, Object... params) {
        log(tag, filterThr(message, params), Level.INFO);
    }

    public static void w(String tag, String message, Object... params) {
        log(tag, filterThr(message, params), Level.WARN);
    }

    public static void e(String tag, String message, Object... params) {
        log(tag, filterThr(message, params), Level.ERROR);
    }

    /**
     * 过滤查询条件为异常信息
     *
     * @param message
     * @param params
     * @author niushuai
     * @date: 2022/10/26 17:31
     * @return: {@link String}
     */
    private static String filterThr(String message, Object[] params) {

        String format = StrUtil.format(message, params);
        if (ArrayUtil.isNotEmpty(params)) {
            Object lastParam = params[params.length - 1];
            if (lastParam instanceof Throwable) {
                // 最后一个元素如果为异常对象
                return new StringBuffer()
                        .append(format)
                        .append(System.lineSeparator())
                        .append(Log.getStackTraceString((Throwable) lastParam))
                        .toString();
            }
        }
        return format;
    }

    private static void log(String tag, String message, int level) {
        if (!LOG_SWITCH) {
            // 不输出日志 直接返回
            return;
        }

        // 设置级别为 info 4  打印级别为 error 6 可打印
        // 设置级别为 info 4  打印级别为 debug 3 可打印

        // 要求当前输出的级别大于等于设置的级别
        if (level >= SET_ROOT_LEVEL) {
            if (Level.ERROR == level) {

                Log.e(tag, message);
                write(tag, message, level);
            } else if (Level.WARN == level) {

                Log.w(tag, message);
                write(tag, message, level);
            } else if (Level.INFO == level) {

                Log.i(tag, message);
                write(tag, message, level);
            } else if (Level.DEBUG == level) {

                Log.d(tag, message);
                write(tag, message, level);
            } else if (Level.VERBOSE == level) {

                Log.v(tag, message);
                write(tag, message, level);
            } else {
                XLog.w(XLog.class.getSimpleName(), "Unknown XLog Level: {}", level);
                write(tag, message, level);
            }
        }
    }

    public static void write(String tag, String message, int level) {

        String logContent = concatFinalLog(tag, level, message);
        FileUtil.appendUtf8String(logContent + System.lineSeparator(), currentAbsoluteLogPath());
    }

    /**
     * 拼凑出完整的日志信息
     * <br/>
     *
     * @param tag
     * @param level
     * @param message
     * @author niushuai
     * @date: 2022/10/26 17:33
     * @return: {@link String}
     */
    private static String concatFinalLog(String tag, int level, String message) {

        // 时间 级别 线程信息 | 日志内容
        // 2022-10-26 11:11:11:111 - [DEBUG] - packageName#methodName:lineNumber: message
        return StrUtil.format(LOG_TEMPLATE,
                DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MS_FORMAT),
                Level.transform(level),
                threadInfo(),
                message
        );
    }

    /**
     * 当前日志文件的绝对路径
     *
     * @author niushuai
     * @date: 2022/10/26 15:33
     * @return: {@link String}
     */
    private static String currentAbsoluteLogPath() {
        return Global.LOG_ROOT_PATH + DateUtil.formatDate(new Date()) + Keys.LOG_SUFFIX;
    }

    /**
     * 组装需打印的线程信息
     *
     * @author niushuai
     * @date: 2022/10/26 17:54
     * @return: {@link String}
     */
    private static String threadInfo() {

        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            // 找到非本类调用的上一层级
            String threadClassName = stackTraceElement.getClassName();
            if (!threadClassName.startsWith(BuildConfig.APPLICATION_ID) || XLog.class.getName().equals(threadClassName)) {
                continue;
            }

            return threadClassName + _Symbol1 + stackTraceElement.getMethodName() + StrPool.COLON + stackTraceElement.getLineNumber();
        }
        return null;
    }
}
