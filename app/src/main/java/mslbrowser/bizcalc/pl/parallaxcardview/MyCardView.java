package mslbrowser.bizcalc.pl.parallaxcardview;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class MyCardView extends CardView {

    private SimpleDraweeView imageView;
    private TextView titleView;
    private float initialMargin;

    public MyCardView(Context context) {
        this(context, null);
    }

    public MyCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.my_card_view, this);
        imageView = (SimpleDraweeView) findViewById(R.id.my_image);
        titleView = (TextView) findViewById(R.id.title);

        initialMargin = getResources().getDimensionPixelSize(R.dimen.test_margin);

        Log.i("TTT", initialMargin + "");
    }

    public void setImage(Uri imageUri) {
        imageView.setImageURI(imageUri);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void parallax(float listHeight) {
        float perc = getTop() / listHeight;

        int topMargin = (int) (initialMargin * (1 - perc));
        int bottomMargin = (int) (initialMargin * perc);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        params.setMargins(0, topMargin, 0, bottomMargin);
        imageView.setLayoutParams(params);

        Log.i("TTT", perc + " " + topMargin + " " + bottomMargin + " " + (topMargin + bottomMargin));
    }

}
