package com.teksyndicate.app.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Patrick on 25/03/2014.
 */
public class Node extends Model {

    public String title;

    @SerializedName("comment_count")
    public String commentCount;

    public String name;

    @SerializedName("view_node")
    public String viewNode;

    @SerializedName("field__news_thumb")
    public String thumbnailUrl;

    @SerializedName("Topic Key")
    public String topicKey;

    @SerializedName("term_node_tid")
    public String temNodeId;

}
