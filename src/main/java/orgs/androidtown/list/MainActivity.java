package orgs.androidtown.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;
    EditText editText;
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대", "010-5319-3270", R.drawable.ufc));
        adapter.addItem(new SingerItem("카라", "01019-3270", R.drawable.ufc_2));
        adapter.addItem(new SingerItem("티아라", "0-5319-3270", R.drawable.ufc));
        adapter.addItem(new SingerItem("여자친구", "1-39370", R.drawable.ufc_2));
        adapter.addItem(new SingerItem("애프터스쿨", "010-3937", R.drawable.ufc));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem) adapter.getItem(i);
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingerItem(name, mobile, R.drawable.ufc));
                adapter.notifyDataSetChanged();
            }
        });


    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();


        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            SingerItemView v = null;

            if (convertView == null) {
                v = new SingerItemView(getApplicationContext());
            } else {
                v = (SingerItemView) convertView;
            }

            SingerItem item = items.get(i);
            v.setName(item.getName());
            v.setMobile(item.getMobile());
            v.setImage(item.getResId());

            return v;
        }
    }

}
