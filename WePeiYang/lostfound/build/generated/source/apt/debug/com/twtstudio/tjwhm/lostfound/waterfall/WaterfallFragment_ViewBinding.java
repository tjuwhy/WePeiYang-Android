// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.waterfall;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WaterfallFragment_ViewBinding implements Unbinder {
  private WaterfallFragment target;

  @UiThread
  public WaterfallFragment_ViewBinding(WaterfallFragment target, View source) {
    this.target = target;

    target.water_refresh = Utils.findRequiredViewAsType(source, R.id.waterfall_refresh, "field 'water_refresh'", SwipeRefreshLayout.class);
    target.waterfall_recyclerView = Utils.findRequiredViewAsType(source, R.id.waterfall_recyclerView, "field 'waterfall_recyclerView'", RecyclerView.class);
    target.waterfall_no_res = Utils.findRequiredViewAsType(source, R.id.waterfall_no_res, "field 'waterfall_no_res'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WaterfallFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.water_refresh = null;
    target.waterfall_recyclerView = null;
    target.waterfall_no_res = null;
  }
}
