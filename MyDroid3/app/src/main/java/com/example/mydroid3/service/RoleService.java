package com.example.mydroid3.service;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.mydroid3.configuration.ServiceConfigs;
import com.example.mydroid3.contract.RoleListAsyncResponse;
import com.example.mydroid3.controller.UniversalRequestHandler;
import com.example.mydroid3.model.RoleModel;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class RoleService {
    ArrayList<RoleModel> roleModelArrayList = new ArrayList<>();

    public List<RoleModel> getQuestions(final RoleListAsyncResponse callBack) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                ServiceConfigs.API_GET_ALL_ROLES, null, response -> {
            Log.d("Role API Response: ", String.valueOf(response));
//            for (int i = 0; i < response.length(); i++) {
//
//                try {
//                    int _id = response.getJSONArray(i).getInt(0);
//                    String title = response.getJSONArray(i).getInt(0);
//                    RoleModel role = new RoleModel();
//                    roleModelArrayList.add(role);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != callBack) callBack.processFinished(roleModelArrayList);



        }, error -> {

        });

        UniversalRequestHandler.getInstance().addToRequestQueue(jsonArrayRequest);

        return roleModelArrayList;
    }
}
