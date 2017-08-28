// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.waterfall;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WaterfallActivity_ViewBinding implements Unbinder {
  private WaterfallActivity target;

  private View view2131624118;

  private View view2131624119;

  private View view2131624124;

  private View view2131624125;

  private View view2131624126;

  private View view2131624226;

  private View view2131624122;

  private View view2131624117;

  @UiThread
  public WaterfallActivity_ViewBinding(WaterfallActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WaterfallActivity_ViewBinding(final WaterfallActivity target, View source) {
    this.target = target;

    View view;
    target.waterfall_type_recyclerview = Utils.findRequiredViewAsType(source, R.id.waterfall_type_recyclerview, "field 'waterfall_type_recyclerview'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.waterfall_type_grey, "field 'waterfall_type_grey' and method 'submit'");
    target.waterfall_type_grey = Utils.castView(view, R.id.waterfall_type_grey, "field 'waterfall_type_grey'", ImageView.class);
    view2131624118 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.waterfall_type_blue, "field 'waterfall_type_blue' and method 'submit'");
    target.waterfall_type_blue = Utils.castView(view, R.id.waterfall_type_blue, "field 'waterfall_type_blue'", ImageView.class);
    view2131624119 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    target.waterfall_cardview_types = Utils.findRequiredViewAsType(source, R.id.waterfall_cardview_types, "field 'waterfall_cardview_types'", CardView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.waterfall_tabLayout = Utils.findRequiredViewAsType(source, R.id.waterfall_tabLayout, "field 'waterfall_tabLayout'", TabLayout.class);
    target.waterfall_pager = Utils.findRequiredViewAsType(source, R.id.waterfall_pager, "field 'waterfall_pager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.waterfall_fab_login, "field 'waterfall_fab_login' and method 'submit'");
    target.waterfall_fab_login = Utils.castView(view, R.id.waterfall_fab_login, "field 'waterfall_fab_login'", FloatingActionButton.class);
    view2131624124 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    target.waterfall_fab_menu = Utils.findRequiredViewAsType(source, R.id.waterfall_fab_menu, "field 'waterfall_fab_menu'", FloatingActionMenu.class);
    view = Utils.findRequiredView(source, R.id.waterfall_fab_lost, "field 'waterfall_fab_lost' and method 'submit'");
    target.waterfall_fab_lost = Utils.castView(view, R.id.waterfall_fab_lost, "field 'waterfall_fab_lost'", FloatingActionButton.class);
    view2131624125 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.waterfall_fab_found, "field 'waterfall_fab_found' and method 'submit'");
    target.waterfall_fab_found = Utils.castView(view, R.id.waterfall_fab_found, "field 'waterfall_fab_found'", FloatingActionButton.class);
    view2131624126 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.waterfall_types_all, "field 'waterfall_types_all' and method 'submit'");
    target.waterfall_types_all = Utils.castView(view, R.id.waterfall_types_all, "field 'waterfall_types_all'", TextView.class);
    view2131624226 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.waterfall_cover, "field 'waterfall_cover' and method 'submit'");
    target.waterfall_cover = Utils.castView(view, R.id.waterfall_cover, "field 'waterfall_cover'", TextView.class);
    view2131624122 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.waterfall_type, "field 'waterfall_type' and method 'submit'");
    target.waterfall_type = Utils.castView(view, R.id.waterfall_type, "field 'waterfall_type'", RelativeLayout.class);
    view2131624117 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.submit(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    WaterfallActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.waterfall_type_recyclerview = null;
    target.waterfall_type_grey = null;
    target.waterfall_type_blue = null;
    target.waterfall_cardview_types = null;
    target.toolbar = null;
    target.waterfall_tabLayout = null;
    target.waterfall_pager = null;
    target.waterfall_fab_login = null;
    target.waterfall_fab_menu = null;
    target.waterfall_fab_lost = null;
    target.waterfall_fab_found = null;
    target.waterfall_types_all = null;
    target.waterfall_cover = null;
    target.waterfall_type = null;

    view2131624118.setOnClickListener(null);
    view2131624118 = null;
    view2131624119.setOnClickListener(null);
    view2131624119 = null;
    view2131624124.setOnClickListener(null);
    view2131624124 = null;
    view2131624125.setOnClickListener(null);
    view2131624125 = null;
    view2131624126.setOnClickListener(null);
    view2131624126 = null;
    view2131624226.setOnClickListener(null);
    view2131624226 = null;
    view2131624122.setOnClickListener(null);
    view2131624122 = null;
    view2131624117.setOnClickListener(null);
    view2131624117 = null;
  }
}
