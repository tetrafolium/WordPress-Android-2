package org.wordpress.android.e2e.components;

import static org.wordpress.android.support.WPSupportUtils.clickOn;

import org.wordpress.android.R;

public class MasterbarComponent {
public MasterbarComponent() {
}

public MasterbarComponent goToMySitesTab() {
	clickOn(R.id.nav_sites);
	return this;
}

public MasterbarComponent clickBlogPosts() {
	clickOn(R.id.quick_action_posts_button);
	return this;
}
}
