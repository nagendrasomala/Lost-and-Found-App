package com.example.lostfound;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    Button b1, b2;
    RecyclerView rv1;
    int lost[] = {R.drawable.bud1,R.drawable.spects,R.drawable.keys,R.drawable.mouse,R.drawable.pendrive,R.drawable.watch1,R.drawable.bud2};
    String num[] = {"21bce9129","21bce7484","22bce8458","20bce9224","22bce4884","21bce9541","21bce7785"};
    String phone[] = {"+919392487179","+916304372784","+919391112410","+918790515520","+919392487179","+916304372784","+919391112410"};
    String desc[] = {"I lost my earbuds CB 111.If anyone find call for this number.","I lost my spects. If anyone find call for this number.","I lost my Room keys CB 131. If anyone find call for this number.","I lost my Mouse AB2 231. If anyone find call for this number.",
            "I lost my pendrive in AB1 lab. If anyone find call for this number.","I lost my Watch.If anyone find call for this number. ","I lost my Buds.If anyone find call for this number."};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b1 = findViewById(R.id.button52);
        b2 = findViewById(R.id.button53);
        rv1 = findViewById(R.id.rv);
        rv1.setAdapter(new myAdapter(this));
        rv1.setLayoutManager(new LinearLayoutManager(this));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(intent);
            }
        });

    }

    private class myAdapter extends RecyclerView.Adapter<myAdapter.MyHolder> {
        Context c;
        public myAdapter(MainActivity5 mainActivity5) {
            c = mainActivity5;
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

        private class MyHolder extends RecyclerView.ViewHolder {
            TextView t1, t2, t3;
            ImageView im1;

            public MyHolder(@NonNull View itemView) {
                super(itemView);

                t1 = itemView.findViewById(R.id.textView);
                t2 = itemView.findViewById(R.id.textView2);
                t3 = itemView.findViewById(R.id.textView3);
                im1 = itemView.findViewById(R.id.imageView);
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
}