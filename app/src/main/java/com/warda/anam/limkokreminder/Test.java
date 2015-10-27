package com.warda.anam.limkokreminder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.warda.anam.limkokreminder.model.*;
import com.warda.anam.limkokreminder.helper.DatabaseHandler;

import java.util.List;


public class Test extends Activity implements OnClickListener {
	 int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
	 LinearLayout ll;
	 ImageView iv;
	 ImageView iv2;
	 ImageView iv3;
	 ImageView iv4;
	 EditText et;
	 EditText et1;
	 EditText et2;
	 EditText et3;
	 EditText et4;
	 Button bb,bedit,bdelete,ok;
	 DatabaseHandler db ;
	 List<examsm> examsm;
	 examsm  editexam;


	protected void onCreate(Bundle savedInstanceState) {
		Display display = getWindowManager().getDefaultDisplay();
		int height = display.getHeight();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);

		 db = new DatabaseHandler(this);






		ll=(LinearLayout)findViewById(R.id.ll);

		Button back = (Button)findViewById(R.id.back);
		back.setOnClickListener(this);

		Button home = (Button)findViewById(R.id.home);
		home.setOnClickListener(this);

		Button add = (Button)findViewById(R.id.add);
		add.setOnClickListener(this);
		Button edit = (Button)findViewById(R.id.edit);
		edit.setOnClickListener(this);



		iv=new ImageView(this);
		iv.setImageResource(R.drawable.sn);
		iv.setPadding(20, 20, 20, 0);
		iv2=new ImageView(this);
		iv2.setImageResource(R.drawable.time);
		iv2.setPadding(20, 20, 20, 0);
		iv3=new ImageView(this);
		iv3.setImageResource(R.drawable.venue);
		iv3.setPadding(20, 20, 20, 0);
		iv4=new ImageView(this);
		iv4.setImageResource(R.drawable.date);
		iv4.setPadding(20, 20, 20, 0);
		et=new EditText(this);
		et.setPadding(20, 20, 20, 0);
		et.setTextColor(Color.parseColor("#FFFFFF"));
		et.setTextSize(height/77);
		et.setId(1);
		et1=new EditText(this);
		et1.setPadding(20, 20, 20, 0);
		et1.setTextColor(Color.parseColor("#FFFFFF"));
		et1.setTextSize(height/77);
		et1.setId(2);
		et2=new EditText(this);
		et2.setPadding(20, 20, 20, 0);
		et2.setTextColor(Color.parseColor("#FFFFFF"));
		et2.setTextSize(height/77);
		et2.setId(3);
		et2.setInputType(InputType.TYPE_CLASS_DATETIME);
		et2.setHint("dd/mm/yy");
		et3=new EditText(this);
		et3.setPadding(20, 20, 20, 0);
		et3.setTextColor(Color.parseColor("#FFFFFF"));
		et3.setTextSize(height/77);
		et3.setId(4);
		et3.setInputType(InputType.TYPE_CLASS_DATETIME);
		et3.setHint("hh:mm");
		et4=new EditText(this);
		et4.setTextColor(Color.parseColor("#FFFFFF"));
		et4.setTextSize(height/77);
		et4.setId(6);
		et4.setInputType(InputType.TYPE_CLASS_NUMBER);
		et4.setHint("Enter ID of element to UPDATE/DELETE");
		bb=new Button(this);
		bb.setId(5);
		bb.setText("ADD");
		bb.setOnClickListener(this);
		bedit=new Button(this);
		bedit.setId(7);
		bedit.setText("EDIT");
		bedit.setOnClickListener(this);
		bdelete=new Button(this);
		bdelete.setId(8);
		bdelete.setText("DELETE");
		bdelete.setOnClickListener(this);
		ok=new Button(this);
		ok.setId(9);
		ok.setText("OK");
		ok.setOnClickListener(this);

		// Reading all contacts
        examsm = db.getAllexams();

        for (examsm cn : examsm) {
            String log = "ID:"+cn.getId()+"\n" + cn.getName() + "\n"
        + cn.getVenue()+ "\n " + cn.getDate()+ "\t " + cn.getTime();
                // Writing Contacts to log
            TextView tt= new TextView(this);
            ImageView line=new ImageView(this);
            line.setBackgroundColor(Color.parseColor("#000000"));
    		LinearLayout.LayoutParams gg = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

            tt.setText(log);
            tt.setTextSize(height/77);
            tt.setTextColor(Color.parseColor("#FFFFFF"));
            ll.addView(tt,gg);
            ll.addView(line, LayoutParams.MATCH_PARENT,2);

    }

	}

	public void onClick(View v) {
		LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,0,1);
		LinearLayout.LayoutParams lParams2 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,0,1);
		
		switch(v.getId())
		{
		case R.id.home:
		case R.id.back:
			Intent myIntent = new Intent(Test.this, MainActivity.class);
		    startActivity(myIntent);
			break;
		case R.id.edit:
			ll.removeAllViews();
			ll.addView(et4,lParams2);
			ll.addView(bedit,lParams2);
			ll.addView(bdelete,lParams2);
			break;
		case 7:
			ll.removeAllViews();
			editexam=db.getExam(Integer.parseInt(et4.getText().toString()));
			et.setText(editexam.getName());
			et1.setText(editexam.getVenue());
			et2.setText(editexam.getDate());
			et3.setText(editexam.getTime());
			ll.addView(et,lParams2);
			ll.addView(et1,lParams2);
			ll.addView(et2,lParams2);
			ll.addView(et3,lParams2);
			ll.addView(ok,lParams2);
			break;
		case 8:
			db.deleteExam(db.getExam(Integer.parseInt(et4.getText().toString())));
			Intent myIntent3 = new Intent(Test.this, Test.class);
		    startActivity(myIntent3);
			break;
		case 9:
			editexam.setName(et.getText().toString());
			editexam.setVenue(et1.getText().toString());
			editexam.setDate(et2.getText().toString());
			editexam.setTime(et3.getText().toString());
			
			db.updateExam(editexam);
			Intent myIntent2 = new Intent(Test.this, Test.class);
		    startActivity(myIntent2);

			
			
			break;
		case R.id.add:	
			ll.removeAllViews();
			et.setText("");
			et1.setText("");
			et2.setText("");
			et2.setHint("dd/mm/yy");
			et3.setText("");
			et3.setHint("hh:mm");
			ll.addView(iv,lParams);
			ll.addView(et,lParams2);
			ll.addView(iv3,lParams);
			ll.addView(et1,lParams2);
			ll.addView(iv4,lParams);
			ll.addView(et2,lParams2);
			ll.addView(iv2,lParams);
			ll.addView(et3,lParams2);
			ll.addView(bb,lParams2);			
			break;
		case 5:
			db.addExam(new examsm(et.getText().toString(),et1.getText().toString(),et2.getText().toString(),et3.getText().toString()));
			Intent myIntent1 = new Intent(Test.this, Test.class);
		    startActivity(myIntent1);
			break;
			
			
		}

}
	}
