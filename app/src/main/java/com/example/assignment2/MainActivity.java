package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button addButton;
    private ListView listView;
    private ArrayList<String> todoList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);
        listView = findViewById(R.id.listView);
        todoList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editText.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    todoList.add(newItem);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a task!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            todoList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Task removed", Toast.LENGTH_SHORT).show();
        });
    }
}