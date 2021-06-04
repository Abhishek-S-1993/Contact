package com.example.saddays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked
{

    TextView tvName, tvTel;
    EditText etName, etTel;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvNam);
        tvTel = findViewById(R.id.tvTel);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);

        btnAdd = findViewById(R.id.btnAdd);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.ListFrag);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (etName.getText().toString().isEmpty() || etTel.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Plz enter all gthe fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(), etTel.getText().toString().trim()));
                    Toast.makeText(MainActivity.this,"Person Successfully Added", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etTel.setText(null);
                    listFrag.notifyDataChanged();
                }

            }
        });

        onItemClicked(0);

    }

    @Override
    public void onItemClicked(int index) {

        tvName.setText(ApplicationClass.people.get(index).getName());
        tvTel.setText(ApplicationClass.people.get(index).getTelNr());
    }
}