// Generated code from Butter Knife. Do not modify!
package com.twtstudio.tjwhm.lostfound.success;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.twtstudio.tjwhm.lostfound.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SuccessActivity_ViewBinding implements Unbinder {
  private SuccessActivity target;

  @UiThread
  public SuccessActivity_ViewBinding(SuccessActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SuccessActivity_ViewBinding(SuccessActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.success_cardView = Utils.findRequiredViewAsType(source, R.id.success_cardView, "field 'success_cardView'", CardView.class);
    target.share_wechatfriends = Utils.findRequiredViewAsType(source, R.id.share_wechatfriends, "field 'share_wechatfriends'", ImageView.class);
    target.share_wechatzone = Utils.findRequiredViewAsType(source, R.id.share_wechatzone, "field 'share_wechatzone'", ImageView.class);
    target.share_qqfriends = Utils.findRequiredViewAsType(source, R.id.share_qqfriends, "field 'share_qqfriends'", ImageView.class);
    target.share_qzone = Utils.findRequiredViewAsType(source, R.id.share_qzone, "field 'share_qzone'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SuccessActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.success_cardView = null;
    target.share_wechatfriends = null;
    target.share_wechatzone = null;
    target.share_qqfriends = null;
    target.share_qzone = null;
  }
}
