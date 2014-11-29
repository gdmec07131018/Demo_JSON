package cn.edu.gdmec.s07131018.demo_json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			JSONObject person = new JSONObject();
			person.put("name","zhangsan");
			person.put("age", 20);
			JSONArray phones = new JSONArray();
			phones.put("1234").put("122223");
			person.put("phones",phones);
			String jsonDataString = person.toString();
			Log.i("info",jsonDataString);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = null;
		try {
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("name").value("lisi");
			stringer.key("age").value(22);
			stringer.key("phones");
			stringer.array();
			stringer.value("1234").value("5678");
			stringer.endArray();
			stringer.endObject();
			str = stringer.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.i("info",str);
		
		try {
			JSONObject jsonObject = new JSONObject(str);
			String name = jsonObject.getString("name");
			int age = jsonObject.getInt("age");
			JSONArray array = jsonObject.getJSONArray("phones");
			String phone1 = array.getString(0);
			String phone2 = array.getString(1);
			
			List<String> numbers = new ArrayList<String>();
			numbers.add(phone1);
			numbers.add(phone2);
			
			Person p = new Person(name, age, numbers);
			Log.i("info","生成的java对象:"+p.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
