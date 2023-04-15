package TDA;

public class asistente {
    private String nombre;
    private byte edad;
    private String sexo;
    private String eCivil;

    public asistente(String nombre, byte edad, String sexo, String eCivil) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.eCivil = eCivil;
    }

    public asistente() {
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String geteCivil() {
        return eCivil;
    }

    public void seteCivil(String eCivil) {
        this.eCivil = eCivil;
    }
    
    
}
