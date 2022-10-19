package Conexion;

public class Producto {

    private int codigo;
    private String nombre;
    private int cantidad;
    private String lugar_fabricacion;
    private String fecha_ingreso;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getLugar_fabricacion() {
        return lugar_fabricacion;
    }

    public void setLugar_fabricacion(String lugar_fabricacion) {
        this.lugar_fabricacion = lugar_fabricacion;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

}
