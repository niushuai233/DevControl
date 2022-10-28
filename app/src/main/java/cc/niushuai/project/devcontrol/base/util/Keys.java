package cc.niushuai.project.devcontrol.base.util;

public interface Keys {

    String ID = "id";

    String DB_FILE_NAME = "dev_control.db";

    String LOG_ROOT_FILE_PATH = "/data/data";

    String LOG_LOG_FOLDER = "log/";

    String LOG_SUFFIX = ".log";

    String SETUP_LOG_SWITCH = "setup_log_switch";
    String SETUP_LOG_LEVEL = "setup_log_level";
    String SETUP_LOG_KEEP_DAY = "setup_log_keep_day";

    interface Tag {
        String MY_OPEN_HELPER = "MyOpenHelper";

        String APP_INIT = "AppInit";
        String KEEP_DAY_SELECT = "KeepDaySelect";
    }
}
