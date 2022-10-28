package cc.niushuai.project.devcontrol.ui.nav.setup;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.XLog;
import cc.niushuai.project.devcontrol.databinding.LayoutLogKeepDayBinding;
import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.util.DBHelper;

/**
 * 日志保留天数
 *
 * @author niushuai233
 * @date 2022/10/28 11:09
 */
public class KeepDayDialogFragment extends DialogFragment {

    private LayoutLogKeepDayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = LayoutLogKeepDayBinding.inflate(getLayoutInflater());

        this.init();
        this.addListener();

        return binding.getRoot();
    }

    private void init() {

        this.initNumberPicker();
    }

    private void addListener() {
        binding.layoutLogKeepDayConfirm.setOnClickListener(v -> {
            String keepDayPickerValue = binding.keepDayPicker.getValue() + "";
            DBHelper.configDeal(Keys.SETUP_LOG_KEEP_DAY, keepDayPickerValue);
            XLog.v(Keys.Tag.KEEP_DAY_SELECT, "更新日志存储天数为: {}", keepDayPickerValue);

            ((TextView)getActivity().findViewById(R.id.setup_log_keep_day_display)).setText(keepDayPickerValue);
            this.dismiss();
        });

        binding.layoutLogKeepDayCancel.setOnClickListener(v -> this.dismiss());
    }

    private void initNumberPicker() {

        binding.keepDayPicker.setMinValue(1);
        binding.keepDayPicker.setMaxValue(90);
        binding.keepDayPicker.setValue(XLog.LOG_KEEP_DAY);
        binding.keepDayPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        binding.keepDayPicker.setFormatter(value -> value + "");
        binding.keepDayPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            XLog.v(Keys.Tag.KEEP_DAY_SELECT, "保留天数 ==> 旧值: {}, 新值: {}", oldVal, newVal);
        });
        binding.keepDayPicker.setOnScrollListener((_view, scrollState) -> {
            XLog.v(Keys.Tag.KEEP_DAY_SELECT, "保留天数 ==> 滑动状态: {}", scrollState);
        });
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        binding = null;
    }
}
