//Daniel Pineda Ortega
//package Daniel;

public class AplicacionCursos {

    //Llenado de cursos
    cursos=new ArrayList<Curso>();

    Curso cursoTmp=new Curso(101, 100, "Programacion 1");
    cursos.add(cursoTmp);
    
    private Integer posicionAlumnoActual;

    //Constructor con todos lo parametros -----------------

    public AplicacionCursos(Integer posicionAlumnoActual) {
        this.posicionAlumnoActual = posicionAlumnoActual;
    }

    //Getter y Setter -----------------------
    public Integer getPosicionAlumnoActual() {
        return posicionAlumnoActual;
    }

    public void setPosicionAlumnoActual(Integer posicionAlumnoActual) {
        this.posicionAlumnoActual = posicionAlumnoActual;
    }

    //------- Metodos -----------------------------------------------------
    Alumno AlumnoAnterior = new Alumno(null, null, null, null, null, null, null, null);
    public Alumno getAlumnoAnterior(){
        return AlumnoAnterior;
    }

    Alumno AlumnoSig = new Alumno(null, null, null, null, null, null, null, null);
    public Alumno getAlumnoSiguiente(){
        return AlumnoSig;
    }

    Alumno AlumnoActual = new Alumno(null, null, null, null, null, null, null, null);
    public Alumno getAlumnoActual(){
        return AlumnoActual;
    }
    
}
