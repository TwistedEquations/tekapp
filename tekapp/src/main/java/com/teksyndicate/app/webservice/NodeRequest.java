package com.teksyndicate.app.webservice;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.teksyndicate.app.models.Node;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 27/03/2014.
 */
public class NodeRequest extends Request<List<Node>> {

    private Response.Listener<List<Node>> nodeListener;

    public NodeRequest(int method, String url, Response.Listener<List<Node>> nodeListener, Response.ErrorListener listener) {
        super(method, url, listener);
        this.nodeListener = nodeListener;
    }

    @Override
    protected Response<List<Node>> parseNetworkResponse(NetworkResponse response) {

        String body = new String(response.data);
        JsonArray nodes = new JsonParser().parse(body).getAsJsonObject().getAsJsonArray("nodes");
        List<Node> nodesList = new ArrayList<Node>();
        Gson gson = new Gson();

        for(JsonElement jsonNode : nodes) {
            jsonNode = jsonNode.getAsJsonObject().getAsJsonObject("node");
            nodesList.add(gson.fromJson(jsonNode, Node.class));
        }
        return Response.success(nodesList, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(List<Node> response) {
        nodeListener.onResponse(response);
    }
}
