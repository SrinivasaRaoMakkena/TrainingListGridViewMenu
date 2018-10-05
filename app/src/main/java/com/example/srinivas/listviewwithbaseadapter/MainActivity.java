package com.example.srinivas.listviewwithbaseadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.srinivas.listviewwithbaseadapter.Model.SocialMedia;
import com.example.srinivas.listviewwithbaseadapter.adapter.SocialAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SocialMedia> list = new ArrayList<>();

    String[] array = {"Twitter", "Facebook", "Google+", "LinkedIN", "Orkut"};

    GridView gridView;
    ListView listView;
    SocialAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listOfItems();
        //listOfNumbers();
        setTitle("Numbers");

        listView = (ListView) findViewById(R.id.listOfSocialMedia);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                R.layout.list_item, array);
        adapter = new SocialAdapter(list, getApplicationContext());
        listView.setAdapter(adapter);
//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Integer.toString(position), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("text", list.get(position).getName());
                intent.putExtra("image", list.get(position).getImageId());
                startActivity(intent);
            }
        });

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setVisibility(View.INVISIBLE);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("text",list.get(position).getName());
                intent.putExtra("image",list.get(position).getImageId());
                startActivity(intent);
            }
        });
        gridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.gridV) {
            gridView.setVisibility(View.VISIBLE);
            gridView.setAdapter(adapter);

        } else if (item.getItemId() == R.id.listV) {
            gridView.setVisibility(View.INVISIBLE);
            listView.setAdapter(adapter);
        }
        return super.onOptionsItemSelected(item);


    }

    private ArrayList<SocialMedia> listOfItems() {
        // ArrayList<SocialMedia> list1 = new ArrayList<>();
        list.add(new SocialMedia("Facebook", R.mipmap.facebook));
        list.add(new SocialMedia("LinkedIn", R.mipmap.linkedin));
        list.add(new SocialMedia("Google+", R.mipmap.googleplus));
        list.add(new SocialMedia("Twitter", R.mipmap.twitter));
        return list;
    }

    ArrayList<SocialMedia> listOfNumbers = new ArrayList<>();

//    private ArrayList<SocialMedia> listOfNumbers() {
//        listOfNumbers.add(new SocialMedia("ONE", R.mipmap.icons83));
//        listOfNumbers.add(new SocialMedia("TWO", R.mipmap.icons82));
//        listOfNumbers.add(new SocialMedia("THREE", R.mipmap.icons81));
//        listOfNumbers.add(new SocialMedia("FOUR", R.mipmap.icons86));
//        listOfNumbers.add(new SocialMedia("FIVE", R.mipmap.icons85));
//        listOfNumbers.add(new SocialMedia("SIX", R.mipmap.icons88));
//        listOfNumbers.add(new SocialMedia("SEVEN", R.mipmap.icons87));
//        return listOfNumbers;
//    }

//    public class MainAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//
//            return list.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            View socialMedia = View.inflate(getApplicationContext(),R.layout.list_item,null);
//            ImageView image = (ImageView) socialMedia.findViewById(R.id.socialMedia);
//            TextView text = (TextView) socialMedia.findViewById(R.id.description);
//            image.setImageResource(list.get(position).getImageId());
//            text.setText(list.get(position).getName());
//            return socialMedia;
//        }
//    }
}
