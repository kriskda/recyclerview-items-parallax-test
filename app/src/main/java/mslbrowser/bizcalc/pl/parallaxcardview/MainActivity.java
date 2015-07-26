package mslbrowser.bizcalc.pl.parallaxcardview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private MyAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<ItemModel> items = new ArrayList<>();
        items.add(new ItemModel("Title 1", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));
        items.add(new ItemModel("Title 2", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170040104553E01_DXXX.jpg"));
        items.add(new ItemModel("Title 3", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));
        items.add(new ItemModel("Title 4", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));
        items.add(new ItemModel("Title 5", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));
        items.add(new ItemModel("Title 6", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));
        items.add(new ItemModel("Title 7", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));
        items.add(new ItemModel("Title 8", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170040104553E01_DXXX.jpg"));
        items.add(new ItemModel("Title 9", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));
        items.add(new ItemModel("Title 10", "http://mars.jpl.nasa.gov/msl-raw-images/msss/01049/mcam/1049MR0046170160104565E01_DXXX.jpg"));

        adapter.setData(items);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                calculateParallaxForItems();
            }
        });

        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            private boolean isInitialized = false;

            @Override
            public void onGlobalLayout() {
                if (isInitialized) {
                    return;
                }
                calculateParallaxForItems();
                isInitialized = true;
            }
        });

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void calculateParallaxForItems() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstItemIndex = layoutManager.findFirstVisibleItemPosition();
        int lastItemIndex = layoutManager.findLastVisibleItemPosition();

        int listHeight = recyclerView.getHeight();

        for (int i = 0; i <= (lastItemIndex - firstItemIndex); i++) {
            ((MyCardView) recyclerView.getChildAt(i)).parallax(listHeight);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
