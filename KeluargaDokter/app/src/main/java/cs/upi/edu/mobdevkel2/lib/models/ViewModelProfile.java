package cs.upi.edu.mobdevkel2.lib.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelProfile extends ViewModel {
    public MutableLiveData<String> dataNama;

    public void setNama(String nama) {
        dataNama.setValue(nama);
    }

    public ViewModelProfile() {
        this.dataNama = new MutableLiveData<String>();
        this.dataNama.setValue("default");
    }
}

