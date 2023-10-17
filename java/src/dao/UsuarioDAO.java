package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Usuarios;

public class UsuarioDAO {

	//CREATE
	
	public void create (Usuarios usuario) {
		
		String sql= "insert into Usuarios (nome, cpf, email, senha) values (?, ?, ?, ?)";
		
		Connection conn= null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,usuario.getNome());
			pstm.setString(2,usuario.getCpf());
			pstm.setString(3,usuario.getEmail());
			pstm.setString(4,usuario.getSenha());

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
	
	public List<Usuarios> read() {
		List<Usuarios> usuarios= new ArrayList<Usuarios>();
		String sql = "select * from Usuarios";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn= ConnectionMySQL.createConnectionMySQL();
			
			pstm= conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
						
			while(rset.next()) {
				Usuarios usuario  = new Usuarios();
				
				usuario.setID(rset.getInt("ID_usuario"));
				usuario.setNome(rset.getString("nome"));
				usuario.setCpf(rset.getString("cpf"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				
				usuarios.add(usuario);
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
		return usuarios;
	}
	
	//UPDATE
	
	public void update(Usuarios usuario) {
		String sql = "UPDATE Usuarios SET nome = ?, cpf = ?, email = ?, senha = ? WHERE ID_usuario = ?;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			pstm.setInt(5, usuario.getID());
			
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
	String sql = "DELETE FROM Usuarios WHERE ID_usuario = ?";
	
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
	
	public Usuarios readByID (int ID) {
		Usuarios usuario = new Usuarios ();
		String sql = "select * from Usuarios WHERE ID_usuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, ID);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			usuario.setID(rset.getInt("ID_usuario"));
			usuario.setNome(rset.getString("nome"));
			usuario.setCpf(rset.getString("cpf"));
			usuario.setEmail(rset.getString("email"));
			usuario.setSenha(rset.getString("senha"));

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
			  
				return usuario;
			}	
	}
}
