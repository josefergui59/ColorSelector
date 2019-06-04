package ec.aj.com.colorselector.Funciones;

public class Validaciones {
    public Validaciones() {

    }

    public String validarColor(String strColor) {
        String strRetorno = "#FFFFFF";

        String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        if (strColor.matches(regex)) {
            if(strColor.length()==4){
                strRetorno = "#" + strColor.toCharArray()[1] + strColor.toCharArray()[1]
                        + strColor.toCharArray()[2] + strColor.toCharArray()[2]
                        + strColor.toCharArray()[3] + strColor.toCharArray()[3];
            }
            else {
                strRetorno = strColor;
            }
        }

        return strRetorno;
    }
}
