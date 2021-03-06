package com.twtstudio.retrox.bike.read.home;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twtstudio.retrox.bike.R;
import com.twtstudio.retrox.bike.R2;
import com.twtstudio.retrox.bike.common.ui.BaseAdapter;
import com.twtstudio.retrox.bike.common.ui.BaseViewHolder;
import com.twtstudio.retrox.bike.model.read.Review;
import com.twtstudio.retrox.bike.read.bookdetail.BookDetailActivity;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by tjliqy on 2016/10/28.
 */

public class BookReviewAdapter extends BaseAdapter<Review> {


    private BookReviewAdapterInterface mInterface;

    static class BookReviewHolder extends BaseViewHolder {

        @BindView(R2.id.civ_portrait)
        CircleImageView mCivPortrait;
        @BindView(R2.id.tv_name)
        TextView mTvName;
        @BindView(R2.id.tv_content)
        TextView mTvContent;
        @BindView(R2.id.tv_date)
        TextView mTvDate;
        @BindView(R2.id.tv_like)
        TextView mTvLike;
        @BindView(R2.id.divider)
        View mDivider;
        @BindView(R2.id.rb_star)
        RatingBar mRbStar;
        @BindView(R2.id.iv_like)
        ImageView mIvLike;
        public BookReviewHolder(View itemView) {
            super(itemView);
        }
    }

    public BookReviewAdapter(Context context, BookReviewAdapterInterface anInterface) {
        super(context);
        mInterface = anInterface;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new BookReviewHolder(inflater.inflate(R.layout.item_book_review, parent, false));
    }

    public void refreshItems(List<Review> reviews){
        mDataSet.clear();
        mDataSet.addAll(reviews);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        BookReviewHolder reviewHolder = (BookReviewHolder)holder;
        Review review = mDataSet.get(position);

        if (review.avatar != null && !review.avatar.equals("")){
            Glide.with(mContext).load(review.avatar).placeholder(R.mipmap.ic_book_avatar).error(R.mipmap.ic_book_avatar).into(reviewHolder.mCivPortrait);
        }
        reviewHolder.mTvName.setText(review.user_name);
        reviewHolder.mRbStar.setRating(review.score);

        if (review.title != null) {
            SpannableString title = new SpannableString("《" + review.title + "》");
            title.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, BookDetailActivity.class);
                    intent.putExtra("id",review.book_id);
                    mContext.startActivity(intent);
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                    ds.setARGB(255, 220, 78, 78);
                }
            }, 0, title.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            reviewHolder.mTvContent.setText(title);
        }
        
        if (review.liked){
            Glide.with(mContext).load(R.mipmap.ic_book_like).into(reviewHolder.mIvLike);
        }
        reviewHolder.mIvLike.setOnClickListener(view -> {
//                if (review.liked){
//                    review.liked = false;
//                    Glide.with(mContext).load(R.mipmap.ic_book_unlike).into(reviewHolder.mIvLike);
//                    Integer like = Integer.valueOf(reviewHolder.mTvLike.getText().toString())-1;
//                    reviewHolder.mTvLike.setText(like.toString());
//                    mInterface.delLike(review.review_id);
//                }
           if (!review.liked){
                review.liked = true;
                Glide.with(mContext).load(R.mipmap.ic_book_like).into(reviewHolder.mIvLike);
                Integer like = Integer.valueOf(reviewHolder.mTvLike.getText().toString())+1;
                reviewHolder.mTvLike.setText(like.toString());
                mInterface.addLike(review.review_id);
            }
        });
        if (review.content != null) {
            reviewHolder.mTvContent.append(review.content);
            reviewHolder.mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (review.like_count != null) {
            reviewHolder.mTvLike.setText(review.like_count);
        }
        if (review.updated_at != null) {
            reviewHolder.mTvDate.setText(review.updated_at);
        }
        if (position == getItemCount() - 1) {
            reviewHolder.mDivider.setVisibility(View.INVISIBLE);
        }
    }
}
