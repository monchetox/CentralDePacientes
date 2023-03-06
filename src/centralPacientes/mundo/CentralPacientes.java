/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
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
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        pacientes.add(0, pac);
        // TODO: Realiar el método que agrega al principio
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        pacientes.add(pac);
        // TODO: Agragar un paciente al final de la lista
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        int index = pacientes.indexOf(localizar(cod));
        pacientes.add(index,pac);
        // TODO: Agrega un paciente después del paciente con el código dado
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        int index = pacientes.indexOf(localizar(cod));
        pacientes.add(index+1,pac);
        // TODO: Agrega un paciente después del paciente con el código cod
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
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
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        int index = pacientes.indexOf(localizar(cod));
        pacientes.remove(index);
        // TODO: Si no existe el paciente con el código dado, genera la excepción
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
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
    // Puntos de Extensión
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
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0;
        for (int i = 0; i < darLongitud(); ++i){
            if (pacientes.get(i).darClinica().equals("Clínica del Country")){
                c1++;
            } else if (pacientes.get(i).darClinica().equals("Clínica Palermo")) {
                c2++;
            } else if (pacientes.get(i).darClinica().equals("Clínica Reina Sofía")) {
                c3++;
            } else if (pacientes.get(i).darClinica().equals("Clínica El Bosque")) {
                c4++;
            } else if (pacientes.get(i).darClinica().equals("Clínica San Ignacio")) {
                c5++;
            } else if (pacientes.get(i).darClinica().equals("Otra")) {
                c6++;
            }
        }
        if (c1>c2 && c1>c3 && c1>c4 && c1>c5 && c1>c6){
            return "Clínica del Country";
        } else if (c2>c1 && c2>c3 && c2>c4 && c2>c5 && c2>c6) {
            return "Clínica Palermo";
        } else if (c3>c1 && c3>c2 && c3>c4 && c3>c5 && c3>c6) {
            return "Clínica Reina Sofía";
        } else if (c4>c1 && c4>c2 && c4>c3 && c4>c5 && c4>c6) {
            return "Clínica El Bosque";
        } else if (c5>c1 && c5>c2 && c5>c3 && c5>c4 && c5>c6) {
            return "Clínica San Ignacio";
        } else if (c6>c1 && c6>c2 && c6>c3 && c6>c4 && c6>c5) {
            return "Otra";
        }
        return "";
    }


}
