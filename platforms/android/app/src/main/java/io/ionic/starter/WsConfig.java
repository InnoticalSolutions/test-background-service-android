package io.ionic.starter;

import org.json.JSONException;
import org.json.JSONObject;

public class WsConfig {



    public String getSendMessageJSON(String message, int receiver_id, int id, int database_id, int consultation_id) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();
            jObj.put("from", id);
            jObj.put("action", "message");
            jObj.put("to", receiver_id);
            jObj.put("message", message);
            jObj.put("time_stamp", database_id);
            jObj.put("consultation_id", consultation_id);
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String getRequestToConnectJson(int doc_id, int patient_id, int consultation_id) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();
            jObj.put("action", "requestToConnect");
            jObj.put("doctor_id", doc_id);
            jObj.put("patient_id", patient_id);
            jObj.put("consultation_id", consultation_id);
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }


    public String getRequestDocListJson(int patient_id, int page) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();
            jObj.put("action", "doctor_list");
            jObj.put("patient_id", patient_id);
            jObj.put("page", page);
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String getConsultationList(int doc_id,int page) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();
            jObj.put("action", "new");
            jObj.put("doctor_id", doc_id);
            jObj.put("page", page);
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
    public String getExpiredConsultationList(int doc_id,int page) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();
            jObj.put("action", "expired");
            jObj.put("doctor_id", doc_id);
            jObj.put("page", page);
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String getConnectRequest(int doc_id,int patient_id,int consultation_id) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();
            jObj.put("action", "connect");
            jObj.put("doctor_id", doc_id);
            jObj.put("patient_id", patient_id);
            jObj.put("consultation_id", consultation_id);

            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }


    public String getPatientToken(int patient_id, int doc_id, int consultation_id) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();
            jObj.put("action", "getPatientToken");
            jObj.put("patient_id", patient_id);
            jObj.put("doctor_id", doc_id);
            jObj.put("consultation_id", consultation_id);
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String getReadStatusRequest(int msg_id, int u_id, int patient_id, int doc_id, int consultation_id, int db_id) {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();

            jObj.put("action", "readMessage");
            jObj.put("id", msg_id);
            jObj.put("u_id", u_id);
            jObj.put("patient_id", patient_id);
            jObj.put("doctor_id", doc_id);
            jObj.put("consultation_id", consultation_id);
            jObj.put("time_stamp", db_id);
            jObj.put("platform", "android");
            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    public String pingServer() {
        String json = null;

        try {
            JSONObject jObj = new JSONObject();

            jObj.put("action", "ping");

            json = jObj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
}