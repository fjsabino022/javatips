package javatips.fsabino.equals_hashcode;

public class Categoria {

    private String codigo;

    private String descripcion;

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        if(codigo == null)
            hash = hash * 31;
        else
            hash = hash * 31 + codigo.hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Categoria)) return false;

        Categoria other = (Categoria) obj;

        if(codigo == null){
            if(other.codigo != null) return false;
        }
        else return codigo.equals(other.codigo);

        return true;
    }
}
