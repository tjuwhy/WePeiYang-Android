// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.release;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReleaseActivity_ViewBinding implements Unbinder {
  private ReleaseActivity target;

  @UiThread
  public ReleaseActivity_ViewBinding(ReleaseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReleaseActivity_ViewBinding(ReleaseActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.release_choose_pic = Utils.findRequiredViewAsType(source, R.id.release_choose_pic, "field 'release_choose_pic'", ImageView.class);
    target.release_title = Utils.findRequiredViewAsType(source, R.id.release_title, "field 'release_title'", EditText.class);
    target.release_time = Utils.findRequiredViewAsType(source, R.id.release_time, "field 'release_time'", EditText.class);
    target.release_place = Utils.findRequiredViewAsType(source, R.id.release_place, "field 'release_place'", EditText.class);
    target.release_contact_name = Utils.findRequiredViewAsType(source, R.id.release_contact_name, "field 'release_contact_name'", EditText.class);
    target.release_phone = Utils.findRequiredViewAsType(source, R.id.release_phone, "field 'release_phone'", EditText.class);
    target.release_remark = Utils.findRequiredViewAsType(source, R.id.release_remark, "field 'release_remark'", EditText.class);
    target.release_publish_spinner = Utils.findRequiredViewAsType(source, R.id.release_publish_spinner, "field 'release_publish_spinner'", Spinner.class);
    target.release_publish_res = Utils.findRequiredViewAsType(source, R.id.release_publish_res, "field 'release_publish_res'", TextView.class);
    target.release_confirm = Utils.findRequiredViewAsType(source, R.id.release_confirm, "field 'release_confirm'", CardView.class);
    target.release_delete = Utils.findRequiredViewAsType(source, R.id.release_delete, "field 'release_delete'", CardView.class);
    target.release_type_recyclerview = Utils.findRequiredViewAsType(source, R.id.release_type_recycleriew, "field 'release_type_recyclerview'", RecyclerView.class);
    target.release_cardinfo = Utils.findRequiredViewAsType(source, R.id.release_cardinfo, "field 'release_cardinfo'", CardView.class);
    target.release_cardinfo_noname = Utils.findRequiredViewAsType(source, R.id.release_cardinfo_noname, "field 'release_cardinfo_noname'", CardView.class);
    target.release_card_num = Utils.findRequiredViewAsType(source, R.id.release_card_num, "field 'release_card_num'", EditText.class);
    target.release_card_name = Utils.findRequiredViewAsType(source, R.id.release_card_name, "field 'release_card_name'", EditText.class);
    target.release_card_num_noname = Utils.findRequiredViewAsType(source, R.id.release_card_num_noname, "field 'release_card_num_noname'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReleaseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.release_choose_pic = null;
    target.release_title = null;
    target.release_time = null;
    target.release_place = null;
    target.release_contact_name = null;
    target.release_phone = null;
    target.release_remark = null;
    target.release_publish_spinner = null;
    target.release_publish_res = null;
    target.release_confirm = null;
    target.release_delete = null;
    target.release_type_recyclerview = null;
    target.release_cardinfo = null;
    target.release_cardinfo_noname = null;
    target.release_card_num = null;
    target.release_card_name = null;
    target.release_card_num_noname = null;
  }
}
