package com.example.mydroid3.contract;

import com.example.mydroid3.model.RoleModel;

import java.util.ArrayList;

public interface RoleListAsyncResponse {
    void processFinished(ArrayList<RoleModel> roleModelArrayList);
}
