package ec.aj.com.colorselector.ui.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ec.aj.com.colorselector.Funciones.Validaciones;
import ec.aj.com.colorselector.R;
import ec.aj.com.colorselector.adapter.ContactAdapter;
import ec.aj.com.colorselector.clases.ColoresCatalogo;
import ec.aj.com.colorselector.clases.ContactInfo;
import ec.aj.com.colorselector.service.MensajePopUp;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root;
        if (pageViewModel.getIndex() != 0) {
            root = inflater.inflate(R.layout.activity_crear_color, container, false);
            final EditText txtColor;
            final LinearLayout linearLayout;
            Button btnVer;
            txtColor = (EditText) root.findViewById(R.id.lblColor);
            linearLayout = (LinearLayout) root.findViewById(R.id.llPrincipal);
            btnVer = (Button) root.findViewById(R.id.btnVer);
            btnVer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String strColor = "#" + txtColor.getText().toString();
                    Validaciones validaciones = new Validaciones();
                    strColor = validaciones.validarColor(strColor);
                    linearLayout.setBackgroundColor(Color.parseColor(strColor));
                }
            });
        } else {
            root = inflater.inflate(R.layout.content_catalogo_color, container, false);
            ProgressDialog progressDialog;
            RecyclerView recList;
            SharedPreferences prefs;
            recList = (RecyclerView) root.findViewById(R.id.cardList);
            recList.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(root.getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recList.setLayoutManager(llm);

            prefs = PreferenceManager.getDefaultSharedPreferences(root.getContext());

            MensajePopUp mensaje = new MensajePopUp(root.getContext());

            List<ContactInfo> result = ColoresCatalogo.llenarLista();


            ContactAdapter ca = new ContactAdapter(result, mensaje, root.getContext());
            recList.setAdapter(ca);
        }
        return root;
    }
}