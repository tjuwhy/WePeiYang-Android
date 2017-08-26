// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.mylist;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MylistTableAdapter$MylistViewHolder_ViewBinding implements Unbinder {
  private MylistTableAdapter.MylistViewHolder target;

  @UiThread
  public MylistTableAdapter$MylistViewHolder_ViewBinding(MylistTableAdapter.MylistViewHolder target,
      View source) {
    this.target = target;

    target.mylist_item_status = Utils.findRequiredViewAsType(source, R.id.mylist_item_status, "field 'mylist_item_status'", TextView.class);
    target.mylist_item_title = Utils.findRequiredViewAsType(source, R.id.mylist_item_title, "field 'mylist_item_title'", TextView.class);
    target.mylist_item_type = Utils.findRequiredViewAsType(source, R.id.mylist_item_type, "field 'mylist_item_type'", TextView.class);
    target.mylist_item_time = Utils.findRequiredViewAsType(source, R.id.mylist_item_time, "field 'mylist_item_time'", TextView.class);
    target.mylist_item_place = Utils.findRequiredViewAsType(source, R.id.mylist_item_place, "field 'mylist_item_place'", TextView.class);
    target.mylist_item_back_blue = Utils.findRequiredViewAsType(source, R.id.mylist_item_back_blue, "field 'mylist_item_back_blue'", ImageView.class);
    target.mylist_item_back_grey = Utils.findRequiredViewAsType(source, R.id.mylist_item_back_grey, "field 'mylist_item_back_grey'", ImageView.class);
    target.mylist_item_pencil = Utils.findRequiredViewAsType(source, R.id.mylist_item_pencil, "field 'mylist_item_pencil'", ImageView.class);
    target.mylist_item_pic = Utils.findRequiredViewAsType(source, R.id.mylist_item_pic, "field 'mylist_item_pic'", ImageView.class);
    target.mylist_status_linear = Utils.findRequiredViewAsType(source, R.id.mylist_status_linear, "field 'mylist_status_linear'", LinearLayout.class);
    target.mylist_item_pencil_touch = Utils.findRequiredViewAsType(source, R.id.mylist_item_pencil_touch, "field 'mylist_item_pencil_touch'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MylistTableAdapter.MylistViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mylist_item_status = null;
    target.mylist_item_title = null;
    target.mylist_item_type = null;
    target.mylist_item_time = null;
    target.mylist_item_place = null;
    target.mylist_item_back_blue = null;
    target.mylist_item_back_grey = null;
    target.mylist_item_pencil = null;
    target.mylist_item_pic = null;
    target.mylist_status_linear = null;
    target.mylist_item_pencil_touch = null;
  }
}
