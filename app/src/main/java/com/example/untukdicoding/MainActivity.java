package com.example.untukdicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Film> list = new ArrayList<>();
    ListFilmAdapter adapter;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_ab:
                Intent intent = new Intent(MainActivity.this, move.class);
                startActivity(intent);
                break;


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);



        list.addAll((FilmData.getListData()));
        showRecyclerList();
    }



    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListFilmAdapter(list);
        rvHeroes.setAdapter(adapter);
        adapter.setOnItemClickCallback(new ListFilmAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Film data) {
                showSelectedHero(data);
            }
        });

    }

    private void showSelectedHero(Film data) {
        Intent intent = new Intent(MainActivity.this, detail.class);
        intent.putExtra("nama",data.getName());
        intent.putExtra("foto",data.getPhoto());
        intent.putExtra("email",data.getFrom());
        startActivity(intent);
    }
}
