/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        pacientes.add(0, pac);
        // TODO: Realiar el m�todo que agrega al principio
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        pacientes.add(pac);
        // TODO: Agragar un paciente al final de la lista
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        int index = pacientes.indexOf(localizar(cod));
        pacientes.add(index,pac);
        // TODO: Agrega un paciente despu�s del paciente con el c�digo dado
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        int index = pacientes.indexOf(localizar(cod));
        pacientes.add(index+1,pac);
        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        for (int i = 0; i < darLongitud(); ++i){
            if (pacientes.get(i).darCodigo() == codigo) {
                return pacientes.get(i);
            }
        }
        return null;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        int index = pacientes.indexOf(localizar(cod));
        pacientes.remove(index);
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int m = 0;
        for (int i = 0; i<darLongitud(); ++i){
            if (pacientes.get(i).darSexo()==1){
                m++;
            }
        }
        return m;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int f = 0;

        for (int i = 0; i<darLongitud(); ++i){
            if (pacientes.get(i).darSexo()==2){
                f++;
            }
        }
        return f;
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0;
        for (int i = 0; i < darLongitud(); ++i){
            if (pacientes.get(i).darClinica().equals("Cl�nica del Country")){
                c1++;
            } else if (pacientes.get(i).darClinica().equals("Cl�nica Palermo")) {
                c2++;
            } else if (pacientes.get(i).darClinica().equals("Cl�nica Reina Sof�a")) {
                c3++;
            } else if (pacientes.get(i).darClinica().equals("Cl�nica El Bosque")) {
                c4++;
            } else if (pacientes.get(i).darClinica().equals("Cl�nica San Ignacio")) {
                c5++;
            } else if (pacientes.get(i).darClinica().equals("Otra")) {
                c6++;
            }
        }
        if (c1>c2 && c1>c3 && c1>c4 && c1>c5 && c1>c6){
            return "Cl�nica del Country";
        } else if (c2>c1 && c2>c3 && c2>c4 && c2>c5 && c2>c6) {
            return "Cl�nica Palermo";
        } else if (c3>c1 && c3>c2 && c3>c4 && c3>c5 && c3>c6) {
            return "Cl�nica Reina Sof�a";
        } else if (c4>c1 && c4>c2 && c4>c3 && c4>c5 && c4>c6) {
            return "Cl�nica El Bosque";
        } else if (c5>c1 && c5>c2 && c5>c3 && c5>c4 && c5>c6) {
            return "Cl�nica San Ignacio";
        } else if (c6>c1 && c6>c2 && c6>c3 && c6>c4 && c6>c5) {
            return "Otra";
        }
        return "";
    }


}
