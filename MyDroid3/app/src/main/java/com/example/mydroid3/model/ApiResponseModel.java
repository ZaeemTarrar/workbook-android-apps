package com.example.mydroid3.model;

import android.util.Log;

import com.example.mydroid3.utils.HttpStatus;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiResponseModel {
    private String name;
    private int code;
    private String status;
    private String messageType;
    private String messageText;
    private JSONObject data;

    private static ApiResponseModel instance;

    private ApiResponseModel() {}

    public static ApiResponseModel getInstance() {
        if(instance == null) {
            instance = new ApiResponseModel();
        }
        return instance;
    }

    public void resetResponse() {
        this.name = "Anonymous";
        this.code =  HttpStatus.OK;
        this.status = "OK";
        this.messageText = "";
        this.messageType = "SUCCESS";
        this.data = null;
    }

    public void responseTree() {
            switch (this.code) {
                case HttpStatus.OK: {
                    Log.d("API_"+name.toUpperCase()+"_Service_Response_Success: OK", this.messageType + ": " + this.messageText);
                }
                break;
                case HttpStatus.CREATED: {
                    Log.d("API_"+name.toUpperCase()+"_Service_Response_Success: CREATED", this.messageType + ": " + this.messageText);
                }
                break;
                case HttpStatus.BAD_REQUEST: {
                    Log.d("API_"+name.toUpperCase()+"_Service_Response_Success: BAD_REQUEST", this.messageType + ": " + this.messageText);
                }
                break;
                case HttpStatus.NOT_FOUND: {
                    Log.d("API_"+name.toUpperCase()+"_Service_Response_Success: NOT_FOUND", this.messageType + ": " + this.messageText);
                }
                break;
                case HttpStatus.INTERNAL_SERVER_ERROR: {
                    Log.d("API_"+name.toUpperCase()+"_Service_Response_Success: INTERNAL_SERVER_ERROR", this.messageType + ": " + this.messageText);
                }
                break;
                default: {
                    Log.d("API_"+name.toUpperCase()+"_Service_Response_Success: ", this.messageType + ": " + this.messageText);
                }
            }
    }

    public void setResponse(String name,JSONObject response) {
        try {
            if( response == null ) Log.d("API_"+name.toUpperCase()+"_Service: ","No Response Data Found");
            else {
                int code = response.getInt("code");
                String status = response.getString("status");
                String messageText = "";
                String messageType = "";
                JSONObject data = null;
                if (response.getString("message") == null)
                    Log.d("API_" + name.toUpperCase() + "_Service_Success: ", "No Response Message Found");
                else {
                    JSONObject message = new JSONObject(response.getString("message"));
                    messageText = message.getString("text");
                    messageType = message.getString("type");
                }
                if (response.getString("data") == null)
                    Log.d("API_" + name.toUpperCase() + "_Service_Success: ", "No Response Data Found");
                else data = new JSONObject(response.getString("data"));
                if (!name.isEmpty()) this.name = name;
                else name = "Anonymous";
                this.code = code;
                this.status = status;
                this.messageType = messageType;
                this.messageText = messageText;
                this.data = data;
                if(data == null) Log.d("API_"+name.toUpperCase()+"_Service: ","Data Not Found");
                responseTree();
            }
        } catch( JSONException e) {
            Log.d("API "+name.toUpperCase()+" Response Json Exception: ",e.toString());
        } catch(Exception e) {
            Log.d("API "+name.toUpperCase()+" Response Exception: ",e.toString());
        } catch(Error e) {
            Log.d("API "+name.toUpperCase()+" Response Error: ",e.toString());
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponseModel{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageText='" + messageText + '\'' +
                ", data=" + data +
                '}';
    }
}
