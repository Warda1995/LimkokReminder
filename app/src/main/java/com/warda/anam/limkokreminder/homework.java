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

import com.warda.anam.limkokreminder.helper.*;
import com.warda.anam.limkokreminder.model.*;
import com.warda.anam.limkokreminder.helper.DatabaseHandler;

import java.util.List;


public class homework extends Activity implements OnClickListener {
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
	 List<asm> asm;
	 asm  editasm;


	protected void onCreate(Bundle savedInstanceState) {
		Display display = getWindowManager().getDefaultDisplay();
		int height = display.getHeight();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.homework);

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
		iv2.setImageResource(R.drawable.title);
		iv2.setPadding(20, 20, 20, 0);
		iv3=new ImageView(this);
		iv3.setImageResource(R.drawable.dd);
		iv3.setPadding(20, 20, 20, 0);
		iv4=new ImageView(this);
		iv4.setImageResource(R.drawable.bo);
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
		et2.setHint("week X");
		et3=new EditText(this);
		et3.setPadding(20, 20, 20, 0);
		et3.setTextColor(Color.parseColor("#FFFFFF"));
		et3.setTextSize(height/77);
		et3.setId(4);
		et3.setHint("...");
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
        asm = db.getAllasm();

        for (asm cn : asm) {
            String log = "ID:"+cn.getId()+"\n" + cn.getName() + "\n"
        + cn.getTitle()+ "\n " + cn.getDd()+ "\n " + cn.getBo();
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
			Intent myIntent = new Intent(homework.this, MainActivity.class);
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
			editasm=db.getAsm(Integer.parseInt(et4.getText().toString()));
			et.setText(editasm.getName());
			et1.setText(editasm.getTitle());
			et2.setText(editasm.getDd());
			et3.setText(editasm.getBo());
			ll.addView(et,lParams2);
			ll.addView(et1,lParams2);
			ll.addView(et2,lParams2);
			ll.addView(et3,lParams2);
			ll.addView(ok,lParams2);
			break;
		case 8:
			db.deleteAsm(db.getAsm(Integer.parseInt(et4.getText().toString())));
			Intent myIntent3 = new Intent(homework.this, homework.class);
		    startActivity(myIntent3);
			break;
		case 9:
			editasm.setName(et.getText().toString());
			editasm.setTitle(et1.getText().toString());
			editasm.setDd(et2.getText().toString());
			editasm.setBo(et3.getText().toString());
			
			db.updateAsm(editasm);
			Intent myIntent2 = new Intent(homework.this, homework.class);
		    startActivity(myIntent2);

			
			
			break;
		case R.id.add:	
			ll.removeAllViews();
			et.setText("");
			et1.setText("");
			et2.setText("");
			et2.setHint("week X");
			et3.setText("");
			et3.setHint("...");
			ll.addView(iv,lParams);
			ll.addView(et,lParams2);
			ll.addView(iv2,lParams);
			ll.addView(et1,lParams2);
			ll.addView(iv3,lParams);
			ll.addView(et2,lParams2);
			ll.addView(iv4,lParams);
			ll.addView(et3,lParams2);
			ll.addView(bb,lParams2);			
			break;
		case 5:
			db.addAsm(new asm(et.getText().toString(),et1.getText().toString(),et2.getText().toString(),et3.getText().toString()));
			Intent myIntent1 = new Intent(homework.this, homework.class);
		    startActivity(myIntent1);
			break;
			
			
		}

}
	}
