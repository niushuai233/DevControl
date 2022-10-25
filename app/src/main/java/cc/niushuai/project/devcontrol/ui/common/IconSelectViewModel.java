package cc.niushuai.project.devcontrol.ui.common;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * TODO
 *
 * @author niushuai233
 * @date 2022/10/25 17:11
 */
public class IconSelectViewModel extends ViewModel {

    private final MutableLiveData<Integer> iconResId = new MutableLiveData<>();

    public MutableLiveData<Integer> getIconResId() {
        return iconResId;
    }

    public void setIconResId(Integer val) {
        iconResId.setValue(val);
    }
}
