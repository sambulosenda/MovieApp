package charlyn23.c4q.nyc.movieapptb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends Activity {
    public static ListView list;
    ContentAdapter adapter;
    public  static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        TextView label = (TextView)findViewById(R.id.label);
        DataGetter dataGetter = new DataGetter();
        ArrayList<JSONObject> movies = new ArrayList<>();
        list = (ListView)findViewById(R.id.list);
        DataGetter.getMovieData();

        adapter = new ContentAdapter(this, R.layout.list_row, movies);
        list.setAdapter(adapter);
        Log.i("adapter: ", String.valueOf(adapter));
        Log.i("new movie list: ", String.valueOf(movies));
        Log.i("getter: ", String.valueOf(DataGetter.getMovieData()));






    }

//    public static void setContentAdapter() {
//        ContentAdapter adapter = new ContentAdapter(ContentAdapter.context, R.layout.list_row, DataGetter.getMovieData());
//        list.setAdapter(adapter);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public static class MyContextWrapper extends ContextWrapper {

        public MyContextWrapper(Context base) {
            super(base);
        }

        public Context getHomeContext(){
            context = this;
            return context;
        }

    }
}

