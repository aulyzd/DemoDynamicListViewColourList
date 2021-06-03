package sg.edu.rp.c346.id20014198.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndex;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;
    CheckBox ck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndex = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAdditem);
        lvColour = findViewById(R.id.listViewColour);
        btnRemove = findViewById(R.id.buttonRemoveitem);
        btnUpdate = findViewById(R.id.buttonUpdateitem);
        ck=findViewById(R.id.checkBox2);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ck.isChecked()) {String colourName = (etElement.getText().toString())+ck.getText().toString();
                }
                String colourName = (etElement.getText().toString())+;
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.add(pos, colourName);
                aaColour.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "The colour has been added", Toast.LENGTH_SHORT).show();

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Log.d("LV click", colour);
                Toast.makeText(MainActivity.this, "You've clicked on the "+colour+" colour", Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "The colour has been removed", Toast.LENGTH_SHORT).show();

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourName = etElement.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColours.set(pos, colourName);
                aaColour.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "The colour has been updated", Toast.LENGTH_SHORT).show();

            }
        });


    }
}