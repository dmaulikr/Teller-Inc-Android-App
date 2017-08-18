package com.teller.kwill.teller;

/**
 * Created by kwill on 8/2/2017.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Created by Oclemmy on 4/1/2016 for ProgrammingWizards Channel.
 */
public class Parser extends AsyncTask<Void,Void,Integer> {
    Context c;
    String data;
    ListView lkl;
    ArrayList<String> names=new ArrayList<>();
    public Parser(Context c, String data, ListView lkl) {
        this.c = c;
        this.data = data;
        this.lkl = lkl;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }
    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if(integer==1)
        {
            //BIND TO LISTVIEW
            ArrayAdapter adapter=new ArrayAdapter(c,android.R.layout.simple_list_item_1,names);
            lkl.setAdapter(adapter);
        }else {
            Toast.makeText(c,"Unable to Parse",Toast.LENGTH_SHORT).show();
        }
    }
    private int parse()
    {
        try
        {
            JSONArray ja=new JSONArray(data);
            JSONObject jo=null;
            names.clear();
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                String name=jo.getString("name");
                String named=jo.getString("public_profile");
                names.add(name);
                names.add(named);
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}