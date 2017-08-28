// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.waterfall;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WaterfallTypeTableAdapter$WaterfallTypesViewHolder_ViewBinding implements Unbinder {
  private WaterfallTypeTableAdapter.WaterfallTypesViewHolder target;

  @UiThread
  public WaterfallTypeTableAdapter$WaterfallTypesViewHolder_ViewBinding(WaterfallTypeTableAdapter.WaterfallTypesViewHolder target,
      View source) {
    this.target = target;

    target.waterfall_type_item = Utils.findRequiredViewAsType(source, R.id.waterfall_type_item, "field 'waterfall_type_item'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WaterfallTypeTableAdapter.WaterfallTypesViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.waterfall_type_item = null;
  }
}
