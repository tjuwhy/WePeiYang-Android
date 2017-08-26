// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.mylist;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MylistFragment_ViewBinding implements Unbinder {
  private MylistFragment target;

  @UiThread
  public MylistFragment_ViewBinding(MylistFragment target, View source) {
    this.target = target;

    target.mylist_recyclerView = Utils.findRequiredViewAsType(source, R.id.mylist_recyclerView, "field 'mylist_recyclerView'", RecyclerView.class);
    target.mylist_progress = Utils.findRequiredViewAsType(source, R.id.mylist_progress, "field 'mylist_progress'", ProgressBar.class);
    target.mylist_nodata = Utils.findRequiredViewAsType(source, R.id.mylist_nodata, "field 'mylist_nodata'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MylistFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mylist_recyclerView = null;
    target.mylist_progress = null;
    target.mylist_nodata = null;
  }
}
