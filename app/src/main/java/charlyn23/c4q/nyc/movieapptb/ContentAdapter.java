package charlyn23.c4q.nyc.movieapptb;

/**
 * Created by charlynbuchanan on 10/8/15.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by charlynbuchanan on 10/7/15.
 */
public class ContentAdapter extends ArrayAdapter<JSONObject>{

    final ArrayList<JSONObject> movies = DataGetter.getMovieData();
    static JSONObject movie;
    Context context;
    final Context homeContext = new HomeActivity.MyContextWrapper(HomeActivity.context).getHomeContext();

    public ContentAdapter(Context context, int resource, ArrayList<JSONObject> movies) {
        super(context, R.layout.list_row, movies);


    }

    static class ViewHolder {
        TextView title;
        ImageView listImage;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.listImage = (ImageView) view.findViewById(R.id.list_image);
            view.setTag(holder);
        }


        else
            holder = (ViewHolder)view.getTag();

        for (int i = 0; i < movies.size(); i++ ) {
            JSONObject movieItem = getItem(position);

            try {
                String title = movieItem.getString("title");
                holder.title.setText(title);
                String imageLink = movieItem.getString("poster_path");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        return view;

    }



}

