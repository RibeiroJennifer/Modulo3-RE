package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Compras;
import modelos.Usuarios;
import modelos.Destinos;

public class ComprasDAO {

    // CREATE
    public void create(Compras compra) {
        String sql = "INSERT INTO Compras (ID_destino, ID_usuario, data_compra, data_ida, data_volta, total) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, compra.getDestino().getID());
            pstm.setInt(2, compra.getUsuario().getID());
            pstm.setString(3, compra.getdata_compra());
            pstm.setString(4, compra.getData_ida());
            pstm.setString(5, compra.getData_volta());
            pstm.setDouble(6, compra.getTotal());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // READ
    public List<Compras> read() {
        List<Compras> compras = new ArrayList<Compras>();
        String sql = "SELECT * FROM Compras";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Compras compra = new Compras();

                compra.setID(rset.getInt("ID_compra"));
                compra.setUsuario(new Usuarios(rset.getInt("ID_usuario"), "", "", "", ""));
                compra.setDestino(new Destinos(rset.getInt("ID_destino"), "", "", "", "", 0.0));
                compra.setData_ida(rset.getString("data_ida"));
                compra.setData_volta(rset.getString("data_volta"));
                compra.setdata_compra(rset.getString("data_compra"));
                compra.setTotal(rset.getDouble("total"));

                compras.add(compra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return compras;
    }

    // UPDATE
    public void update(Compras compra) {
        String sql = "UPDATE Compras SET ID_destino = ?, ID_usuario = ?, data_compra = ?, data_ida = ?, data_volta = ?, total = ? WHERE ID_compra = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, compra.getDestino().getID());
            pstm.setInt(2, compra.getUsuario().getID());
            pstm.setString(3, compra.getdata_compra());
            pstm.setString(4, compra.getData_ida());
            pstm.setString(5, compra.getData_volta());
            pstm.setDouble(6, compra.getTotal());
            pstm.setInt(7, compra.getID());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // DELETE
    public void delete(int ID) {
        String sql = "DELETE FROM Compras WHERE ID_compra = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // READbyID
    public Compras readByID(int ID) {
        Compras compra = new Compras();
        String sql = "SELECT * FROM Compras WHERE ID_compra = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID);
            rset = pstm.executeQuery();

            rset.next();

            compra.setID(rset.getInt("ID_compra"));
            compra.setUsuario(new Usuarios(rset.getInt("ID_usuario"), "", "", "", ""));
            compra.setDestino(new Destinos(rset.getInt("ID_destino"), "", "", "", "", 0.0));
            compra.setData_ida(rset.getString("data_ida"));
            compra.setData_volta(rset.getString("data_volta"));
            compra.setdata_compra(rset.getString("data_compra"));
            compra.setTotal(rset.getDouble("total"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return compra;
    }
}
