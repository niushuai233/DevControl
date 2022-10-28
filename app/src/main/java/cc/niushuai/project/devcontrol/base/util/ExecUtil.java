package cc.niushuai.project.devcontrol.base.util;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.util.RuntimeUtil;

/**
 * 执行工具类 封装执行结果
 *
 * @author niushuai233
 * @date 2022/10/28 13:43
 */
public class ExecUtil {

    public static class CommandResult<T> {
        private Boolean success;
        private T result;

        public CommandResult(Boolean success, T result) {
            this.success = success;
            this.result = result;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public T getResult() {
            return result;
        }

        public void setResult(T result) {
            this.result = result;
        }
    }

    public static CommandResult<String> exec4Str(String command) {
        try {
            String result = RuntimeUtil.execForStr(Charset.defaultCharset(), command);
            XLog.i(Keys.Tag.EXEC_COMMAND, "执行命令: {}, 结果: {}", command, result);
            return new CommandResult<>(true, result);
        } catch (Exception e) {
            XLog.e(Keys.Tag.EXEC_COMMAND, "执行命令: {}, 异常", command, e);
            return new CommandResult<>(false, e.getMessage());
        }
    }

    public static CommandResult<List<String>> exec4Lines(String... command) {

        try {
            List<String> result = RuntimeUtil.execForLines(Charset.defaultCharset(), command);
            XLog.i(Keys.Tag.EXEC_COMMAND, "执行多命令: {}, 结果: {}", command, result.stream().collect(Collectors.joining(System.lineSeparator())));
            return new CommandResult<>(true, result);
        } catch (Exception e) {
            XLog.e(Keys.Tag.EXEC_COMMAND, "执行多命令: {}, 异常: {}", command, e.getMessage(), e);
            return new CommandResult<>(false, Collections.singletonList(e.getMessage()));
        }
    }

}
