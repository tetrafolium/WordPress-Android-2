package org.wordpress.android.e2e.pages;

import static org.wordpress.android.support.WPSupportUtils.getCurrentActivity;
import static org.wordpress.android.support.WPSupportUtils.scrollToAndClickOnTextInRecyclerView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import org.wordpress.android.R;

public class PostsListPage {
  public PostsListPage() {}

  public static void tapPostWithName(String name) {
    scrollToAndClickOnTextInRecyclerView(name, getRecyclerView());
  }

  private static RecyclerView getRecyclerView() {
    ViewPager pager = getCurrentActivity().findViewById(R.id.postPager);
    return (RecyclerView)pager.getChildAt(pager.getCurrentItem())
        .findViewById(R.id.recycler_view);
  }
}
