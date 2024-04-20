package dao.fornecedor;

import dao.Conexao;
import dao.DadosBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;

public class FornecedorDAOMySQL implements FornecedorDAO {

    public boolean salvar(Fornecedor fornecedor) {
        boolean resultado = false;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = null;
            if (fornecedor.getFornecedorId() != -1) {
                sql = "update fornecedor set NOMEFANTASIA=?, RAZAOSOCIAL=?, CNPJ=?, CIDADE=?, REGIAO=? where FORNECEDORID = ?";
            } else {
                sql = "insert into fornecedor (NOMEFANTASIA, RAZAOSOCIAL, CNPJ, CIDADE, REGIAO)  values  (?,?,?,?,?)";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fornecedor.getNomeFantasia());
            pstmt.setString(2, fornecedor.getRazaoSocial());
            pstmt.setString(3, fornecedor.getCnpj());
            pstmt.setString(4, fornecedor.getCidade());
            pstmt.setString(5, fornecedor.getRegiao());
            if (fornecedor.getFornecedorId() != -1) {
                pstmt.setInt(6, fornecedor.getFornecedorId());
            }
            pstmt.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public boolean apagarPK(int fornecedorId) {
        boolean resultado = false;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from fornecedor where fornecedorId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, fornecedorId);
            pstmt.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public Fornecedor consultarPK(String fornecedorId) {
        Fornecedor fornecedor = null;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select fornecedorId, nomefantasia, razaosocial, cnpj, cidade, regiao from fornecedor where fornecedorId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(fornecedorId));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setFornecedorId(rs.getInt("fornecedorId"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRazaoSocial(rs.getString("razaosocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setRegiao(rs.getString("regiao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return fornecedor;
    }

    public List consultarTudo() {
        Fornecedor fornecedor = null;
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        MinhaConexao.conectar();
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
        try {
            String sql = "select * from fornecedor";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setFornecedorId(rs.getInt("fornecedorId"));
                fornecedor.setNomeFantasia(rs.getString("nomeFantasia"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setRegiao(rs.getString("regiao"));
                lista.add(fornecedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }
}
