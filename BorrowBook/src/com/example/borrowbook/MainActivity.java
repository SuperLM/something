package com.example.borrowbook;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Book book;
	private Person person;
	private List<Book> lists_book;
	private List<Book> lists_get;
	private EditText editText_name, editText_time;
	private RadioGroup sex;
	private CheckBox history, suspense, literature;
	private SeekBar sb_age;
	private Button bt_search, bt_next, bt_final;
	private TextView tv_age, tv_content, tv_name, tv_type, tv_readerAge;
	private ImageView iv;
	private RadioGroupListener radioGroupListener;
	private CheckBoxListener checkBoxListener;
	private SeekBarListener seekBarListener;
	private ButtonListener_search buttonListener_search;
	private ButtonListener_next buttonListener_next;
	private ButtonListener_final buttonListener_final;
	private String book_type = "";
	private int count = -1;
	private int year, month, day;

//想问下老师，如果不按照规则输入借书日期，怎么能让程序报错，而不是让程序直接崩溃呢。
	//想问下老师，如果不按照规则输入借书日期，怎么能让程序报错，而不是让程序直接崩溃呢。
	//想问下老师，如果不按照规则输入借书日期，怎么能让程序报错，而不是让程序直接崩溃呢。
	//想问下老师，如果不按照规则输入借书日期，怎么能让程序报错，而不是让程序直接崩溃呢。
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leanerlayout);
		initView();
		initData();
		setLisener();
	}

	public void setLisener() {
		radioGroupListener = new RadioGroupListener();
		sex.setOnCheckedChangeListener(radioGroupListener);
		checkBoxListener = new CheckBoxListener();
		history.setOnCheckedChangeListener(checkBoxListener);
		suspense.setOnCheckedChangeListener(checkBoxListener);
		literature.setOnCheckedChangeListener(checkBoxListener);
		seekBarListener = new SeekBarListener();
		sb_age.setOnSeekBarChangeListener(seekBarListener);
		buttonListener_search = new ButtonListener_search();
		bt_search.setOnClickListener(buttonListener_search);
		buttonListener_next = new ButtonListener_next();
		bt_next.setOnClickListener(buttonListener_next);
		buttonListener_final = new ButtonListener_final();
		bt_final.setOnClickListener(buttonListener_final);
	}

	public void initView() {
		editText_name = (EditText) findViewById(R.id.ed_name);
		editText_time = (EditText) findViewById(R.id.ed_time);
		sex = (RadioGroup) findViewById(R.id.rg);
		history = (CheckBox) findViewById(R.id.cb_01);
		suspense = (CheckBox) findViewById(R.id.cb_02);
		literature = (CheckBox) findViewById(R.id.cb_03);
		sb_age = (SeekBar) findViewById(R.id.sb);
		bt_search = (Button) findViewById(R.id.btn_search);
		bt_next = (Button) findViewById(R.id.btn_next);
		bt_final = (Button) findViewById(R.id.btn_final);
		tv_age = (TextView) findViewById(R.id.tv_age);
		tv_content = (TextView) findViewById(R.id.tv_mention);
		tv_name = (TextView) findViewById(R.id.tv_name);
		tv_type = (TextView) findViewById(R.id.tv_type);
		tv_readerAge = (TextView) findViewById(R.id.tv_readerAge);
		iv = (ImageView) findViewById(R.id.iv);
	}

	public void initData() {
		person = new Person();
		lists_get = new ArrayList<Book>();
		lists_book = new ArrayList<Book>();
		lists_book.add(new Book("人生感悟", "郑志国", "文艺", 25, R.drawable.aa));
		lists_book.add(new Book("边城", "沈从文", "文艺", 18, R.drawable.bb));
		lists_book.add(new Book("sapir", "无", "悬疑", 0, R.drawable.cc));
		lists_book.add(new Book("光辉岁月", "党生辉", "历史", 45, R.drawable.dd));
		lists_book.add(new Book("宋词三百首", "张欣", "文艺", 15, R.drawable.ee));
		lists_book.add(new Book("中国古代文学", "刘负伟", "历史", 40, R.drawable.ff));
		lists_book.add(new Book("无花果", "张婉丽", "文艺", 22, R.drawable.gg));
		lists_book.add(new Book("古镇记忆", "南方", "文艺", 18, R.drawable.hh));
	}

	public void searchBook() {
		for (int i = 0; i < lists_book.size(); i++) {
			book = lists_book.get(i);
			if (book.getReaderage() < person.getAge()
					&& book_type.contains(book.getType())) {
				lists_get.add(book);
				count++;
			}

		}

	}

	public void showInformation(Book book) {
		iv.setImageResource(book.getPic());
		tv_name.setText(book.getName());
		tv_type.setText(book.getType());
		tv_readerAge.setText(Integer.toString(book.getReaderage()));
	}

	public void cutString() {
		year = Integer.parseInt((String) (editText_time.getText().toString())
				.subSequence(0, 4));
		month = Integer.parseInt((String) (editText_time.getText().toString())
				.subSequence(5, 7));
		day = Integer.parseInt((String) (editText_time.getText().toString())
				.subSequence(8, 10));
		System.out.println(year + "  " + month + "   " + day);
	}

	public boolean isLegal() {
		boolean flag = false;
		cutString();
		if (year < 2017 && month < 12 && month > 0 && day < 32 && day > 0)
			flag = true;
		if (year == 2017) {
			if (month < 6 && day < 32 && day > 0)
				flag = true;
			if (month == 6)
				if (day < 30 && day > 0)
					flag = true;
		}
		return flag;

	}

	public class RadioGroupListener implements OnCheckedChangeListener {

		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.rb_01:
				person.setSex("男");
				break;
			case R.id.rb_02:
				person.setSex("女");
				break;
			}
		}

	}

	public class CheckBoxListener implements
			android.widget.CompoundButton.OnCheckedChangeListener {

		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			CheckBox cb_box = (CheckBox) buttonView;
			switch (cb_box.getId()) {
			case R.id.cb_01:
				if (isChecked)
					book_type = book_type.concat("历史");
				else
					book_type = book_type.replace("历史", "");
				break;
			case R.id.cb_02:
				if (isChecked)
					book_type = book_type.concat("悬疑");
				else
					book_type = book_type.replace("悬疑", "");
				break;
			case R.id.cb_03:
				if (isChecked)
					book_type = book_type.concat("文艺");
				else
					book_type = book_type.replace("文艺", "");
				break;
			}
			System.out.println(book_type);

		}

	}

	public class SeekBarListener implements OnSeekBarChangeListener {

		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {

		}

		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		public void onStopTrackingTouch(SeekBar seekBar) {
			person.setAge(sb_age.getProgress());
			tv_age.setText(Integer.toString(person.getAge()));

		}

	}

	public class ButtonListener_search implements OnClickListener {

		public void onClick(View v) {
			lists_get.clear();
			count = -1;
			cutString();
			if (isLegal() == false) {
				Toast.makeText(MainActivity.this,
						"查找失败！借出时间不符合规范，请重新輸入（例:2016-07-06）", 300).show();
				return;
			}
			searchBook();
			tv_content.setText("符合条件的书还有" + (count + 1) + "本");
			if (count != -1) {
				showInformation(lists_get.get(count--));
				tv_content.setText("符合条件的书还有" + (count + 1) + "本");
			}
		}

	}

	public class ButtonListener_next implements OnClickListener {

		public void onClick(View v) {
			Book book = new Book();
			book = lists_get.get(count--);
			showInformation(book);
			tv_content.setText("符合条件的书还有" + (count + 1) + "本");
			System.out.println("1");
			if (count == -1) {
				count = lists_get.size() - 1;
				Toast.makeText(MainActivity.this, "已经浏览到最后一本，即将从头开始", 300)
						.show();
			}
		}

	}

	public class ButtonListener_final implements OnClickListener {

		public void onClick(View v) {
			 person.setName(editText_name.getText().toString());
			 person.setBorrowTime(editText_time.getText().toString());
			 Toast.makeText(MainActivity.this,"借书成功！借书信息："+person.toString() , 500).show();

		}
	}

}
