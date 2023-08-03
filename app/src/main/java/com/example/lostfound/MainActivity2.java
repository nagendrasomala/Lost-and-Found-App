package com.example.lostfound;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView t1;
    Button lostb,foundb;
    SharedPreferences sharedPreferences;
    String regn[]={"21bce9403","21bce9424","21bce9445","21bce9233","21bce9384"};
    String names[] = {"Nagendra","Prabhu","Revanth","Kiran","Shareef"};
    int lost[] = {R.drawable.buds1,R.drawable.charger,R.drawable.calc,R.drawable.earphones,R.drawable.id1,R.drawable.watch,R.drawable.buds2};
    RecyclerView rv;
    String num[] = {"21bce9999","21bce6584","22mis5648","20bce9874","22mic6584","21bce9542","21bce7895"};
    String phone[] = {"+919392487179","+916304372784","+919391112410","+918790515520","+919392487179","+916304372784","+919391112410"};
    String desc[] = {"I found this buds in Ab2 321","I found this Adapter in Ab1 G06","I found this Calculator in Ab1 212","I found this Earphones in CB 125",
            "I found this ID card in Ab2 135","I found this Watch AB2 footpath","I found this buds in CB 214"};
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lostb = findViewById(R.id.button52);
        foundb = findViewById(R.id.button53);
        rv = findViewById(R.id.rvvvv);
        rv.setAdapter(new myAdapter(this));
        rv.setLayoutManager(new LinearLayoutManager(this));


        t1 = findViewById(R.id.textView2);
        sharedPreferences = getSharedPreferences("nage", MODE_PRIVATE);
        for(int i=0;i<regn.length;i++){
            if(sharedPreferences.getString("reg","").equals(regn[i])){
                String n = "Welcome "+names[i];
               t1.setText(n);
            }
        }

        lostb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent);
            }
        });

        foundb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(intent);
            }
        });




    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.logout) {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(MainActivity2.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            this.finishAffinity();

        }
        if (item.getItemId() == R.id.lost) {
            Intent intent = new Intent(getApplicationContext(),MainActivity5.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }




    private class myAdapter extends RecyclerView.Adapter<MyHolder> {
        Context c;
        public myAdapter(MainActivity2 mainActivity2) {
            c = mainActivity2;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view1 = LayoutInflater.from(c).inflate(R.layout.item,parent,false);
            return new MyHolder(view1);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.t1.setText(num[position]);
            holder.t2.setText(" "+desc[position]);
            holder.t3.setText(phone[position]);
            holder.im1.setImageResource(lost[position]);
        }

        @Override
        public int getItemCount() {
            return lost.length;
        }
    }
    class MyHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        ImageView im1;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
            t3=itemView.findViewById(R.id.textView3);
            im1=itemView.findViewById(R.id.imageView);
            t3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + t3.getText().toString()));
                    startActivity(intent);
                }
            });
        }
    }
}

