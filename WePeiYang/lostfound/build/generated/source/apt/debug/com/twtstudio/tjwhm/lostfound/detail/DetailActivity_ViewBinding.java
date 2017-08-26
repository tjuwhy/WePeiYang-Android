// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.detail;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailActivity_ViewBinding implements Unbinder {
  private DetailActivity target;

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.detail_pic = Utils.findRequiredViewAsType(source, R.id.detail_pic, "field 'detail_pic'", ImageView.class);
    target.detail_title = Utils.findRequiredViewAsType(source, R.id.detail_title, "field 'detail_title'", TextView.class);
    target.detail_time = Utils.findRequiredViewAsType(source, R.id.detail_time, "field 'detail_time'", TextView.class);
    target.detail_place = Utils.findRequiredViewAsType(source, R.id.detail_place, "field 'detail_place'", TextView.class);
    target.detail_type = Utils.findRequiredViewAsType(source, R.id.detail_type, "field 'detail_type'", TextView.class);
    target.detail_name = Utils.findRequiredViewAsType(source, R.id.detail_name, "field 'detail_name'", TextView.class);
    target.detail_phone = Utils.findRequiredViewAsType(source, R.id.detail_phone, "field 'detail_phone'", TextView.class);
    target.detail_remarks = Utils.findRequiredViewAsType(source, R.id.detail_rematks, "field 'detail_remarks'", TextView.class);
    target.detail_layout_without_pic = Utils.findRequiredViewAsType(source, R.id.detail_layout_without_pic, "field 'detail_layout_without_pic'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.detail_pic = null;
    target.detail_title = null;
    target.detail_time = null;
    target.detail_place = null;
    target.detail_type = null;
    target.detail_name = null;
    target.detail_phone = null;
    target.detail_remarks = null;
    target.detail_layout_without_pic = null;
  }
}
