package com.pontic_studio.tema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pontic_studio.tema2.adapter.Adapter;
import com.pontic_studio.tema2.model.AnimalModel;

import java.util.ArrayList;

public class AnimalPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText editText1;
    private EditText editText2;
    private Button addButton;

    private ArrayList arrayList;

    private TextView errorM;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_page_activity);

        recyclerView = findViewById(R.id.recycler_view);
        editText1 = findViewById(R.id.AddAnimalName);
        editText2 = findViewById(R.id.AddAnimalContinent);
        addButton = findViewById(R.id.addButton);
        errorM = findViewById(R.id.ErrorM);

        arrayList = new ArrayList<AnimalModel>();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new Adapter(arrayList);
        recyclerView.setAdapter(adapter);

        getSupportActionBar().hide();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItem();
            }
        });

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                arrayList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

    }

    public void AddItem()

    {
        String name = editText1.getText().toString();
        String continent = editText2.getText().toString();

        if(name.isBlank())
        {
            errorM.setText("SELECT NAME FOR ANIMAL");
        }else if(continent.isBlank())
        {
            errorM.setText("SELECT CONTINENT FOR ANIMAL");

        }else {

            boolean verifyList = false;

            for(int i = 0; i < arrayList.size();i++)
            {
                AnimalModel animal = (AnimalModel) arrayList.get(i);
                if (animal.getName().equals(name)) {
                    verifyList = true;
                    errorM.setText("ANIMAL IS ALREADY IN LIST");
                    break;
                }

            }


            if(verifyList == false) {

                AnimalModel animalModel = new AnimalModel(name, continent);
                arrayList.add(animalModel);
                int position = arrayList.indexOf(animalModel);
                adapter.notifyItemInserted(position);
                editText2.setText("");
                editText1.setText("");
                errorM.setText("");
            }
        }

    }
}