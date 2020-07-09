package org.wordpress.android.ui.reader.models;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReaderSimplePostList extends ArrayList<ReaderSimplePost> {
public static ReaderSimplePostList
fromJsonPosts(@NonNull JSONArray jsonPosts) {
	ReaderSimplePostList posts = new ReaderSimplePostList();
	for (int i = 0; i < jsonPosts.length(); i++) {
		JSONObject jsonRelatedPost = jsonPosts.optJSONObject(i);
		if (jsonRelatedPost != null) {
			ReaderSimplePost relatedPost =
				ReaderSimplePost.fromJson(jsonRelatedPost);
			if (relatedPost != null) {
				posts.add(relatedPost);
			}
		}
	}
	return posts;
}
}
