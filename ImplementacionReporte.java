package reporte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImplementacionReporte implements ReporteProductos{
	
    // Variables para la conexión a la base de datos
	 private static final String url = "jdbc:mysql://localhost:3306/minimarket";
	 private static final String user = "root";
	 private static final String pass = "";

	    @Override
		//Método para entregar reporte de sucursales con mayor stock de determinado producto
	    public void reporteMayorStock(int idProducto) {
	        // Consulta SQL para obtener la cantidad de ventas por sucursal
	        String ConsultaSQL = "SELECT sucursal.nombreSucursal, stock.stock "
	        		+ "FROM stock JOIN sucursal ON stock.FK_idSucursal = sucursal.idSucursal "
	        		+ "WHERE stock.FK_idProducto = ? ORDER BY stock.stock DESC LIMIT 3";

	        try (Connection conn = DriverManager.getConnection(url, user, pass);
	             PreparedStatement stmt = conn.prepareStatement(ConsultaSQL)) {
	            
	            stmt.setInt(1, idProducto);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                String nombreSucursal = rs.getString("nombreSucursal");
	                int stock = rs.getInt("stock");
	                System.out.println(" - " + nombreSucursal + " con " + stock + " unidades.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}
