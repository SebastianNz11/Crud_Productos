package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductosDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion acceso = new Conexion();

    //AGREGA LOS DATOS A LA BASE DE DATOS
    public void crear(int codigo, String nombre, int cantidad, String lugar_fabricacion, String fecha_ingreso) {
        if (cantidad < 0) {
            JOptionPane.showMessageDialog(null, "   NO SE PERMITEN NUMEROS NEGATIVOS");
        } else {
            String sql = "insert into producto (codigo,nombre,cantidad,lugar_de_fabricacion,fecha_de_ingreso) values(?,?,?,?,?);";
            try {
                con = acceso.Conectar();
                ps = con.prepareStatement(sql);

                ps.setInt(1, codigo);
                ps.setString(2, nombre);
                ps.setInt(3, cantidad);
                ps.setString(4, lugar_fabricacion);
                ps.setString(5, fecha_ingreso);
                ps.executeUpdate();

            } catch (SQLException e) {
            }
        }
    }

    //METODO MODIFICAR
    public void modificar(int codigo, String nombre, int cantidad, String lugar_fabricacion, String fecha_ingreso) {
        if ("".equals(nombre) || cantidad < 0 || "".equals(lugar_fabricacion) || "".equals(fecha_ingreso)) {
            JOptionPane.showMessageDialog(null, "   NO SE PERMITEN CAMPOS VACIOS NI NUMEROS NEGATIVOS");

        } else {
            String sql = "update producto set nombre=?,cantidad=?,lugar_de_fabricacion=?,fecha_de_ingreso=? where codigo = ?;";
            try {
                con = acceso.Conectar();
                ps = con.prepareStatement(sql);

                ps.setString(1, nombre);
                ps.setInt(2, cantidad);
                ps.setString(3, lugar_fabricacion);
                ps.setString(4, fecha_ingreso);
                ps.setInt(5, codigo);
                ps.executeUpdate();

            } catch (SQLException e) {
            }

        }
    }

    //LISTAR Productos
    public ArrayList listar() {

        String sql = "select * from producto";
        try {
            //Inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<Producto> datos = new ArrayList<>();

            while (rs.next()) {
                Producto pd = new Producto();
                pd.setCodigo(rs.getInt(1));
                pd.setNombre(rs.getString(2));
                pd.setCantidad(rs.getInt(3));
                pd.setLugar_fabricacion(rs.getString(4));
                pd.setFecha_ingreso(rs.getString(5));
                datos.add(pd);
            }
            return datos;
        } catch (SQLException e) {
        }
        return null;
    }

    //FILTRO BUSCAR 
    public void buscar(int codigo) {
        String sql = "select * from producto where codigo =" + codigo;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Modificar m = new Modificar();
                m.mostrar(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                m.setVisible(true);
            } else {

            }
        } catch (SQLException e) {
        }
    }

    //FILTRO BUSCAR ELIMINAR
    public void buscar_eliminar(int codigo) {
        String sql = "select * from producto where codigo =" + codigo;
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Eliminar el = new Eliminar();
                el.mostrarEliminar(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                el.setVisible(true);
            } else {

            }
        } catch (Exception e) {
        }
    }

    //ELIMINAR DATOS
    public void eliminar(int codigo) {
        String sql = "delete from producto where codigo =?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
