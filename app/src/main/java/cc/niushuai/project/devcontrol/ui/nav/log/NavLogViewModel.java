package cc.niushuai.project.devcontrol.ui.nav.log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NavLogViewModel extends ViewModel {

    private final MutableLiveData<String> vText;

    public NavLogViewModel() {
        this.vText = new MutableLiveData<>();
    }

    public MutableLiveData<String> getText() {
        return this.vText;
    }
}
