package ec.aj.com.colorselector.service;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

public class MensajePopUp {

    Context context;
    String url;

    public MensajePopUp(Context context){
        this.context = context;
    }

    public void mensajeSimple(String strMensaje){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(strMensaje);
        alertDialogBuilder.show();
    }
    public void mensajeSimpleColor(String strMensaje, String strColor){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(strMensaje);
        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor(strColor)));
        // Initialize a new window manager layout parameters
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();

        // Copy the alert dialog window attributes to new layout parameter instance
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        // Set the width and height for the layout parameters
        // This will bet the width and height of alert dialog
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;

        // Apply the newly created layout parameters to the alert dialog window
        dialog.getWindow().setAttributes(layoutParams);
    }
    public void mensajeTitulo(String strMensaje, String strTitulo){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(strMensaje);
        alertDialogBuilder.setTitle(strTitulo);
        alertDialogBuilder.show();
    }
}
