package cc.niushuai.project.devcontrol.base.util;

import java.util.Date;

import cn.hutool.core.date.DateUtil;

/**
 * 对hutool的包装
 *
 * @author niushuai233
 * @date 2022/10/25 14:33
 */
public class DateFormatUtil {

    public static Date parseDateTime(CharSequence dateStr) {
        if (null == dateStr) {
            return null;
        }
        return DateUtil.parseDateTime(dateStr);
    }

    public static String formatDateTime(Date date) {
        if (null == date) {
            return null;
        }
        return DateUtil.formatDateTime(date);
    }

}
