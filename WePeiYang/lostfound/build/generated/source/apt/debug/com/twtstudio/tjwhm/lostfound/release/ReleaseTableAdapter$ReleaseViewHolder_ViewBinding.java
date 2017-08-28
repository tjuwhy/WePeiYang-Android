// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.release;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReleaseTableAdapter$ReleaseViewHolder_ViewBinding implements Unbinder {
  private ReleaseTableAdapter.ReleaseViewHolder target;

  @UiThread
  public ReleaseTableAdapter$ReleaseViewHolder_ViewBinding(ReleaseTableAdapter.ReleaseViewHolder target,
      View source) {
    this.target = target;

    target.release_item_type = Utils.findRequiredViewAsType(source, R.id.release_item_type, "field 'release_item_type'", TextView.class);
    target.release_item_cardview = Utils.findRequiredViewAsType(source, R.id.release_item_cardview, "field 'release_item_cardview'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReleaseTableAdapter.ReleaseViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.release_item_type = null;
    target.release_item_cardview = null;
  }
}
