package Sonolnikov.gr303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.lstFrom);
        spTo = findViewById(R.id.lstTo);
        etFrom = findViewById(R.id.txtFrom);
        tvTo = findViewById(R.id.labTo);

        ArrayAdapter<String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");
        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }
    public void on_convert(View v)
    {
        float from = Float.parseFloat(etFrom.getText().toString());

        String sFrom = (String) spFrom.getSelectedItem();
        String sTo = (String) spTo.getSelectedItem();

        float to = 0.0f;

        if (sFrom.equals("mm"))
        {
            if (sTo.equals("mm")) to = from * 1.0f;
            if (sTo.equals("cm")) to = from * 0.1f;
            if (sTo.equals("m")) to = from * 0.001f;
            if (sTo.equals("km")) to = from * 0.000001f;
        }

        if (sFrom.equals("cm"))
        {
            if (sTo.equals("mm")) to = from * 10.0f;
            if (sTo.equals("cm")) to = from * 1.0f;
            if (sTo.equals("m")) to = from * 0.01f;
            if (sTo.equals("km")) to = from * 0.00001f;
        }

        if (sFrom.equals("m"))
        {
            if (sTo.equals("mm")) to = from * 1000.0f;
            if (sTo.equals("cm")) to = from * 100.0f;
            if (sTo.equals("m")) to = from * 1.0f;
            if (sTo.equals("km")) to = from * 0.001f;
        }

        if (sFrom.equals("km"))
        {
            if (sTo.equals("mm")) to = from * 1000000.0f;
            if (sTo.equals("cm")) to = from * 100000.0f;
            if (sTo.equals("m")) to = from * 1000.0f;
            if (sTo.equals("km")) to = from * 1.0f;
        }

        tvTo.setText(String.valueOf(to));

    }


}



















