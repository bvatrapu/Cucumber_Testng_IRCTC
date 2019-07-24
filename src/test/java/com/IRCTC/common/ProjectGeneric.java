package com.IRCTC.common;

import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.utilities.generic.Generic;

public class ProjectGeneric {

    private Generic generic = null;
    public ConfigTestData configTestData=null;

    public ProjectGeneric(ConfigTestData configTestData) {
        this.configTestData = configTestData;
        generic = new Generic(configTestData);

    }


}
