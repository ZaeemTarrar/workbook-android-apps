package com.example.mydroid3.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RoleModel {
    private String _id;
    private String title;
    private boolean activeStatus;
    private String SubRole;

    public RoleModel() {
    }

    public RoleModel(String id, String title, boolean activeStatus) {
        _id = id;
        this.title = title;
        this.activeStatus = activeStatus;
        SubRole = "";
    }

    public static ArrayList<RoleModel> extractJsonList(JSONObject data) {
        ArrayList<RoleModel> roleModelArrayList = new ArrayList<>();
        try{
            if(data != null) {
                Log.d("API_Role_Service_Response_Data: ",data.toString());
                if(data.getString("roles") == null) {
                    Log.d("API_Role_Service_Success: ","No Roles List Found in Response Data");
                    throw new Exception("Roles Array Object is Empty");
                }
                else {
                    JSONArray RolesList = new JSONArray(data.getString("roles"));
                    for (int i = 0; i < RolesList.length(); i++) {
                        try {
                            RoleModel roleModel = new RoleModel(
                                    RolesList.getJSONObject(i).getString("_id"),
                                    RolesList.getJSONObject(i).getString("title"),
                                    RolesList.getJSONObject(i).getBoolean("activeStatus"));
                            roleModelArrayList.add(roleModel);
                        } catch (Exception fe) {
                            Log.d("API_Roles_Service_List_Loop_Exception: ", String.valueOf(i) + ": " + fe.toString());
                        } catch (Error fe) {
                            Log.d("API_Roles_Service_List_Loop_Error: ", String.valueOf(i) + ": " + fe.toString());
                        }
                    }
                }
            }
        }
        catch(JSONException err) {
            Log.d("API_Role_Service_Error: Json Exception ",err.toString());
        } catch(Exception err) {
            Log.d("API_Role_Service_Error: Exception ",err.toString());
        } catch(Error err) {
            Log.d("API_Role_Service_Error: ",err.toString());
        }
        return roleModelArrayList;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getSubRole() {
        return SubRole;
    }

    public void setSubRole(String subRole) {
        SubRole = subRole;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", activeStatus=" + activeStatus +
                ", SubRole='" + SubRole + '\'' +
                '}';
    }
}
