package mslbrowser.bizcalc.pl.parallaxcardview;

import android.net.Uri;

public class ItemModel {

    public final String title;
    public final Uri imageUri;

    public ItemModel(String title, String imageUrl) {
        this.title = title;
        this.imageUri = Uri.parse(imageUrl);
    }

}
