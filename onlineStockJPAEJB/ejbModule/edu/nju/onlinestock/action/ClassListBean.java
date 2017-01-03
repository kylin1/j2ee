package edu.nju.onlinestock.action;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kylin on 26/12/2016.
 * All rights reserved.
 */
public class ClassListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ClassInfoBean> classList;

    public List<ClassInfoBean> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassInfoBean> classList) {
        this.classList = classList;
    }

    public ClassInfoBean getClass(int index){
        if(index >= classList.size()){
            return null;
        }
        return this.classList.get(index);
    }
}
