package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Destinos;

public class DestinosDAO {

	//CREATE
	
		public void create (Destinos destino) {
			
			String sql= "INSERT INTO Destinos (nome, pais, estado, cidade, preco) values (?, ?, ?, ?, ?)";
			
			Connection conn= null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				
				
				pstm.setString(1,destino.getNome());
				pstm.setString(2,destino.getPais());
				pstm.setString(3,destino.getEstado());
				pstm.setString(4,destino.getCidade());
				pstm.setDouble(5,destino.getPreco());


				pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm !=null) {
						pstm.close();
					}
					if (pstm !=null) {
						conn.close();
					}
					}
					catch (Exception e) {
					e.printStackTrace();	
					}
				}
			
			
			}
		//READ
		
		public List<Destinos> read() {
			List<Destinos> Destinos = new ArrayList<Destinos>();
			String sql = "select * from Destinos";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn= ConnectionMySQL.createConnectionMySQL();
				
				pstm= conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
							
				while(rset.next()) {
					Destinos destino  = new Destinos();
					
					destino.setID(rset.getInt("ID_destino"));
					destino.setNome(rset.getString("nome"));
					destino.setPais(rset.getString("pais"));
					destino.setEstado(rset.getString("estado"));
					destino.setCidade(rset.getString("cidade"));
					destino.setPreco(rset.getDouble("preco"));

					
					
					Destinos.add(destino);
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
			return Destinos;
		}
		
		//UPDATE
		
		public void update(Destinos destino) {
			String sql = "UPDATE Destinos SET nome = ?, pais = ?, estado = ?, cidade = ?, preco = ? WHERE ID_destino = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, destino.getNome());
				pstm.setString(2, destino.getPais());
				pstm.setString(3, destino.getEstado());
				pstm.setString(4, destino.getCidade());
				pstm.setDouble(5, destino.getPreco());

				pstm.setInt(6, destino.getID());
				
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
		
		//DELETE
		
		public void delete(int ID) {
		String sql = "DELETE FROM Destinos WHERE ID_destino = ?";
		
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
		
		//READbyID
		
		public Destinos readByID (int ID) {
			Destinos destino = new Destinos ();
			String sql = "select * from destinos WHERE ID_destino = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, ID);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				destino.setID(rset.getInt("ID_destino"));
				destino.setNome(rset.getString("nome"));
				destino.setPais(rset.getString("pais"));
				destino.setEstado(rset.getString("estado"));
				destino.setCidade(rset.getString("cidade"));
				destino.setPreco(rset.getDouble("preco"));


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
				  
					return destino;
				}	
		}
}

