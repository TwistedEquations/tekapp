package com.teksyndicate.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.teksyndicate.app.R;
import com.teksyndicate.app.adapters.AdapterTagItems;
import com.teksyndicate.app.models.Node;
import com.teksyndicate.app.webservice.NodeRequest;
import com.teksyndicate.app.webservice.RequestConstants;
import com.teksyndicate.app.webservice.TekVolley;

import java.util.List;

/**
 * Created by Patrick on 27/03/2014.
 */
public class FragmentTagList extends Fragment{

    private RequestQueue queue;
    private View root;
    private ListView listView;
    AdapterTagItems adapterTagItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        queue = TekVolley.getRequestQueue(getActivity());
        root = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) root.findViewById(R.id.listView);
        adapterTagItems = new AdapterTagItems(getActivity());
        listView.setAdapter(adapterTagItems);

        NodeRequest nodeRequest = new NodeRequest(Request.Method.GET, RequestConstants.getUrlForTag("all"), new Response.Listener<List<Node>>() {
            @Override
            public void onResponse(List<Node> response) {
                Log.i("Tek", "response = "+response);
                adapterTagItems.swapData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Volley Error", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(nodeRequest);
        return root;
    }
}
