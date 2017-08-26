// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.waterfall;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WaterfallTableAdapter$WaterfallViewHolder_ViewBinding implements Unbinder {
  private WaterfallTableAdapter.WaterfallViewHolder target;

  @UiThread
  public WaterfallTableAdapter$WaterfallViewHolder_ViewBinding(WaterfallTableAdapter.WaterfallViewHolder target,
      View source) {
    this.target = target;

    target.waterfall_item_pic = Utils.findRequiredViewAsType(source, R.id.waterfall_item_pic, "field 'waterfall_item_pic'", ImageView.class);
    target.waterfall_item_title = Utils.findRequiredViewAsType(source, R.id.waterfall_item_title, "field 'waterfall_item_title'", TextView.class);
    target.waterfall_item_type = Utils.findRequiredViewAsType(source, R.id.waterfall_item_type, "field 'waterfall_item_type'", TextView.class);
    target.waterfall_item_time = Utils.findRequiredViewAsType(source, R.id.waterfall_item_time, "field 'waterfall_item_time'", TextView.class);
    target.waterfall_item_place = Utils.findRequiredViewAsType(source, R.id.waterfall_item_place, "field 'waterfall_item_place'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WaterfallTableAdapter.WaterfallViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.waterfall_item_pic = null;
    target.waterfall_item_title = null;
    target.waterfall_item_type = null;
    target.waterfall_item_time = null;
    target.waterfall_item_place = null;
  }
}
