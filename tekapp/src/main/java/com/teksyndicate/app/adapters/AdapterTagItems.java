package com.teksyndicate.app.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.teksyndicate.app.R;
import com.teksyndicate.app.models.Node;
import com.teksyndicate.app.webservice.TekVolley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 27/03/2014.
 */
public class AdapterTagItems extends BaseAdapter {

    private List<Node> nodeList = new ArrayList<Node>();
    private LayoutInflater inflater;
    private Typeface typeface;
    private ImageLoader imageLoader;

    public AdapterTagItems(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        typeface = Typeface.createFromAsset(context.getAssets(), "UbuntuCondensed-Regular.ttf");
        imageLoader = TekVolley.getImageLoader(context);
    }

    @Override
    public int getCount() {
        return nodeList.size();
    }

    @Override
    public Node getItem(int position) {
        return nodeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Node node = nodeList.get(position);
        ViewHolder holder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_node, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            holder.poster = (TextView) convertView.findViewById(R.id.posterInfo);
            holder.comments = (TextView) convertView.findViewById(R.id.comments);
            holder.thumbnail = (NetworkImageView) convertView.findViewById(R.id.thumbnail);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(node.title);
        holder.poster.setText(node.created);
        holder.thumbnail.setImageUrl(node.thumbnailUrl, imageLoader);
        holder.comments.setText(node.commentCount);

        return convertView;
    }

    public void swapData(List<Node> nodeList) {
        this.nodeList = nodeList;
        notifyDataSetChanged();
    }

    public void addData(List<Node> nodeList) {
        this.nodeList.addAll(nodeList);
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        TextView title;
        TextView description;
        TextView poster;
        TextView comments;
        NetworkImageView thumbnail;
    }
}
