package com.example.mydroid3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydroid3.model.ApiResponseModel;
import com.example.mydroid3.model.RoleModel;
import com.example.mydroid3.service.RoleService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RolesSectionGetAllRolesActivity extends AppCompatActivity {

    private final Activity activity = this;
    private Button apiGetAllRoles;
    private TextView apiGetAllRolesResponse;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles_section_get_all_roles);
        activity.setTitle("Get All Roles");

        apiGetAllRoles = findViewById(R.id.api_get_all_roles_call);
        apiGetAllRolesResponse = findViewById(R.id.api_get_all_roles_call_response);

        /**
         * Fetching List of All Roles
         */
        try {
            apiGetAllRoles.setOnClickListener(view -> {
                RoleService.getInstance().getRoles(roleModelArrayList -> {
                    for( int i = 0 ; i < roleModelArrayList.size() ; i++ ) {
                        RoleModel roleModel = roleModelArrayList.get(i);
                        String text = roleModel.get_id() + " " + roleModel.getTitle() + " " + roleModel.isActiveStatus();
                        apiGetAllRolesResponse.setText(apiGetAllRolesResponse.getText().toString() + text + "\n\n");
                    }
                    if(!ApiResponseModel.getInstance().getMessageText().isEmpty())
                        Toast.makeText(RolesSectionGetAllRolesActivity.this, ApiResponseModel.getInstance().getMessageText(), Toast.LENGTH_SHORT).show();
                });
            });
        } catch(Exception err) {
            Toast.makeText(RolesSectionGetAllRolesActivity.this, "API Role Service Exception: " + err.toString(), Toast.LENGTH_SHORT).show();
        } catch(Error err) {
            Toast.makeText(RolesSectionGetAllRolesActivity.this, "API Role Service Error: " + err.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}