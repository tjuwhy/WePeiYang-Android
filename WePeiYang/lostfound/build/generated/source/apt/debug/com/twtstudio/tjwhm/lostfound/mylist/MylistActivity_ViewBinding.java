// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.mylist;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MylistActivity_ViewBinding implements Unbinder {
  private MylistActivity target;

  @UiThread
  public MylistActivity_ViewBinding(MylistActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MylistActivity_ViewBinding(MylistActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.mylist_pager = Utils.findRequiredViewAsType(source, R.id.mylist_pager, "field 'mylist_pager'", ViewPager.class);
    target.mylist_tabLayout = Utils.findRequiredViewAsType(source, R.id.mylist_tabLayout, "field 'mylist_tabLayout'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MylistActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.mylist_pager = null;
    target.mylist_tabLayout = null;
  }
}
