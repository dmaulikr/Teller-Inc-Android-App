package com.teller.kwill.teller;

/**
 * Created by kwill on 8/12/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.SearchView;
import android.app.SearchManager;
import java.util.ArrayList;


public class BlockedActivity extends AppCompatActivity {
        TextView textView277;
        ScrollView kjkh;
        ListView loprr;
        SearchView jhk;
        Button button182;
        boolean isUnB;

        static final String KEY_NAME = "name";

            @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked);

        textView277 = (TextView) findViewById(R.id.textView277);
        jhk = (SearchView) findViewById(R.id.jhk);
        loprr = (ListView) findViewById(R.id.loprr);
         kjkh = (ScrollView) findViewById(R.id.kjkh);
        button182 = (Button) findViewById(R.id.button182);

                ArrayList<String> hjkn = new ArrayList<>();

        Intent intent = getIntent();
        loprr.setTextFilterEnabled(true);


                ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hjkn);
        hjkn.add(textView277.toString());
        hjkn.add("name");
        hjkn.add("public_profile");
          String yoh = textView277.getText().toString();
          String yohu = textView277.getText().toString();
                adapter.notifyDataSetChanged();
                button182.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //or some other task

                        isUnB=true;
                      ; //or some other task
                        ListView loprr;
                        loprr = (ListView) findViewById(R.id.loprr);
                        ArrayList<String> hjkn = new ArrayList<>();
                        hjkn.remove(textView277.toString());
                        hjkn.remove("name");
                        hjkn.remove("public_profile");
                        final int position = loprr.getPositionForView((View) view.getParent());
                        KEY_NAME.toString();

                        Toast.makeText(BlockedActivity.this, "user unblocked",
                                Toast.LENGTH_SHORT).show();


                    }
                });
            }
    SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
    public View getView(final int position, View convertView, View parent) {
        View view = convertView;
        if (view == null) {KEY_NAME.toString();textView277.toString();

            button182= (Button) view.findViewById(R.id. button182);
            ArrayList<String> hjkn = new ArrayList<>();
            textView277.setText(hjkn.get(position));

        }
        return view;
    }
    public boolean onQueryTextChange(String newText)

    {  jhk.setSubmitButtonEnabled(true);
        // this is your adapter that will be filtered
        if (TextUtils.isEmpty(newText))
            jhk.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        {
            loprr.clearTextFilter();
        }

        {
            loprr.setFilterText(newText.toString());
        }

        return true;
    }


    public boolean onQueryTextSubmit(String query) {
        // TODO Auto-generated method stub
        return false;
    }
}
