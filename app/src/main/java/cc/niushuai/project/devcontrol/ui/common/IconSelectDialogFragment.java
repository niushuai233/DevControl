package cc.niushuai.project.devcontrol.ui.common;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.enums.IconEnum;
import cc.niushuai.project.devcontrol.base.util.UiUtil;
import cc.niushuai.project.devcontrol.databinding.LayoutIconSelectBinding;

/**
 * icon选择弹窗
 *
 * @author niushuai233
 * @date 2022/10/25 16:51
 */
public class IconSelectDialogFragment extends DialogFragment {

    private LayoutIconSelectBinding binding;
    private Integer callbackIconResId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = LayoutIconSelectBinding.inflate(getLayoutInflater());

        this.init();

        return binding.getRoot();
    }

    public IconSelectDialogFragment(Integer callbackIconResId) {
        this.callbackIconResId = callbackIconResId;
    }

    /**
     * 初始化入口
     *
     * @author niushuai
     * @date: 2022/10/25 17:21
     */
    private void init() {

        this.initIconList();
    }

    /**
     * 加载icon图标列表
     *
     * @author niushuai
     * @date: 2022/10/25 17:22
     */
    private void initIconList() {

        GridView iconListGridView = binding.iconListGridView;

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), getIconList(), R.layout.layout_icon_select_item,
                new String[]{"icon_select_list_key", "icon_select_list_icon", "icon_select_list_text"},
                new int[]{R.id.icon_select_list_key, R.id.icon_select_list_icon, R.id.icon_select_list_text}
        );

        iconListGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        iconListGridView.setOnItemClickListener(this::iconListClickListener);
        iconListGridView.setAdapter(simpleAdapter);
    }

    private void iconListClickListener(AdapterView<?> parent, View view, int position, long id) {

        // 跳转到相应的activity
        String iconId = ((TextView) view.findViewById(R.id.icon_select_list_key)).getText().toString();

        UiUtil.setAppImageCompatResource(getActivity(), callbackIconResId, Integer.parseInt(iconId));

        // 关闭弹出框
        this.dismiss();
    }

    private List<? extends Map<String, ?>> getIconList() {
        IconEnum[] allIcon = IconEnum.values();

        List<HashMap<String, Object>> gvData = new ArrayList<>(allIcon.length);

        for (IconEnum icon : allIcon) {
            HashMap<String, Object> item = new HashMap<>(3);
            item.put("icon_select_list_key", icon.getIconIdDark());
            item.put("icon_select_list_icon", icon.getIconIdDark());
            item.put("icon_select_list_text", icon.getDesc());
            gvData.add(item);
        }

        return gvData;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        binding = null;
    }

}
