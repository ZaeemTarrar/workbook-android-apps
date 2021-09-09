package com.example.mydroid3.service;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mydroid3.MainActivity;
import com.example.mydroid3.R;
import com.example.mydroid3.RolesSectionGetAllRolesActivity;
import com.example.mydroid3.configuration.ServiceConfigs;
import com.example.mydroid3.contract.RoleListAsyncResponse;
import com.example.mydroid3.controller.UniversalRequestHandler;
import com.example.mydroid3.model.ApiResponseModel;
import com.example.mydroid3.model.RoleModel;
import com.example.mydroid3.utils.HttpStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoleService {
    ArrayList<RoleModel> roleModelArrayList = new ArrayList<>();
    UniversalRequestHandler requestHandle;

    private static RoleService instance;

    private RoleService() {}

    public static RoleService getInstance() {
        if(instance == null) {
            instance = new RoleService();
        }
        return instance;
    }

    public List<RoleModel> getRoles(final RoleListAsyncResponse callBack) {
        try {
            roleModelArrayList.clear();
            ApiResponseModel.getInstance().resetResponse();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,ServiceConfigs.API_GET_ALL_ROLES,null,
                    response -> {
                        ApiResponseModel.getInstance().setResponse("Role",response);
                        roleModelArrayList = RoleModel.extractJsonList(ApiResponseModel.getInstance().getData());
                        if (callBack != null) callBack.processFinished(roleModelArrayList);
                    },
                    error -> {
                        try {
                            Log.d("OFF: ", "Error: " + error
                                    + "\nStatus Code " + error.networkResponse.statusCode
                                    + "\nResponse Data " + error.networkResponse.data.toString()
                                    + "\nCause " + error.getCause()
                                    + "\nmessage" + error.getMessage());
                            if( error == null || error.networkResponse == null || error.networkResponse.data == null ) {
                                Log.d("API_Role_Service_Error Error: ","No Error Response Data Found: "+error.toString());
                            }
                            else {
                                JSONObject jsonObject = new JSONObject(String.valueOf(error.networkResponse.data));
                                ApiResponseModel.getInstance().setResponse("Role",jsonObject);
                                roleModelArrayList = RoleModel.extractJsonList(ApiResponseModel.getInstance().getData());
                                if (callBack != null) callBack.processFinished(roleModelArrayList);
                            }
                        } catch(JSONException e) {
                            Log.d("API_Role_Service_JSON_Exception: ",error.toString());
                        } catch (Exception e) {
                            Log.d("API_Role_Service_Exception: ",error.toString());
                        }
                    });
            UniversalRequestHandler.getInstance().addToRequestQueue(jsonObjectRequest);
        } catch(Exception err) {
            Log.d("API_Role_Service_TryCatch_Error: ",err.toString());
        }
        return roleModelArrayList;
    }
}
