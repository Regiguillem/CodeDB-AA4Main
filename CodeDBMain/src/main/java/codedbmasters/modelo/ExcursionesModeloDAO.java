package codedbmasters.modelo;

import codedbmasters.vista.ExcursionesVista;

import org.hibernate.Session;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class ExcursionesModeloDAO {
    //private Connection connection;
    private Session session;

    private ExcursionesVista vistaEx;

    public ExcursionesModeloDAO(Session session) {
        //this.connection = connection;
        this.session = session;
        this.vistaEx = new ExcursionesVista();
    }
    //Query con Hibernate
    public void agregarExcursion(ExcursionesModelo excursion){
        try {
            session.beginTransaction();
            session.save(excursion);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    /*public void agregarExcursion(ExcursionesModelo excursion) throws SQLException {
        String sql = "INSERT INTO Excursiones (codigo, descripcion, fecha, n_dias, precio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, excursion.getCodigo());
            statement.setString(2, excursion.getDescripcion());
            statement.setDate(3, java.sql.Date.valueOf(excursion.getFecha()));
            statement.setInt(4, excursion.getN_dias());
            statement.setDouble(5, excursion.getPrecio());
            statement.executeUpdate();
        }
    }*/
    //Query con Hibernate
    public void filtrarExcursion(LocalDate fechaIni, LocalDate fechaFin){
        try{
            session.beginTransaction();
            String hql = "FROM ExcursionesModelo WHERE fecha BETWEEN :fechaIni AND :fechaFin";
            List <ExcursionesModelo>excursiones = session.createQuery(hql)
                    .setParameter("fechaIni", fechaIni)
                    .setParameter("fechaFin", fechaFin)
                    .list();
            session.getTransaction().commit();
            for (ExcursionesModelo excursion : excursiones){
                vistaEx.mostrarExcursion(excursion);
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    /*public void filtrarExcursion(LocalDate fechaIni, LocalDate fechaFin) throws SQLException {
        String sql = "SELECT * FROM Excursiones WHERE fecha BETWEEN ? AND ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, java.sql.Date.valueOf(fechaIni));
            statement.setDate(2, java.sql.Date.valueOf(fechaFin));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String codigo = resultSet.getString("codigo");
                    String descripcion = resultSet.getString("descripcion");
                    LocalDate fecha = resultSet.getDate("fecha").toLocalDate();
                    int n_dias = resultSet.getInt("n_dias");
                    double precio = resultSet.getDouble("precio");
                    ExcursionesModelo excursion = new ExcursionesModelo(codigo, descripcion, fecha, n_dias, precio);
                    vistaEx.mostrarExcursion(excursion);
                }
            }
        }
    }*/
}
