package ec.aj.com.colorselector;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CrearColor extends AppCompatActivity {

    EditText txtColor;
    LinearLayout linearLayout;
    Button btnVer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_color);
        cargar();
    }
    public void cargar(){
        txtColor = (EditText) findViewById(R.id.lblColor);
        linearLayout = (LinearLayout) findViewById(R.id.llPrincipal);
        btnVer = (Button) findViewById(R.id.btnVer);
        btnVer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cambiarColor();
            }
        });
    }
    public void cambiarColor(){
        String strColor = txtColor.getText().toString();
        linearLayout.setBackgroundColor(Color.parseColor(strColor));
    }

}
