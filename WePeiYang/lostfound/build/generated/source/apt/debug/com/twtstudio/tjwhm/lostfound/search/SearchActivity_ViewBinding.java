// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.search_toolbar, "field 'toolbar'", Toolbar.class);
    target.searchView = Utils.findRequiredViewAsType(source, R.id.search_searview, "field 'searchView'", SearchView.class);
    target.search_recyclerView = Utils.findRequiredViewAsType(source, R.id.search_recyclerView, "field 'search_recyclerView'", RecyclerView.class);
    target.search_progress = Utils.findRequiredViewAsType(source, R.id.search_progress, "field 'search_progress'", ProgressBar.class);
    target.search_no_res = Utils.findRequiredViewAsType(source, R.id.search_no_res, "field 'search_no_res'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.searchView = null;
    target.search_recyclerView = null;
    target.search_progress = null;
    target.search_no_res = null;
  }
}
