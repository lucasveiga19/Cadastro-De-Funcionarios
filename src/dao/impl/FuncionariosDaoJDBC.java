package dao.impl;

import Model.Funcionarios;
import dao.ConnectionFactory;
import dao.FuncionariosDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionariosDaoJDBC implements FuncionariosDao {
    private final Connection conn;

    public FuncionariosDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Funcionarios func) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO funcionario (Nome, Cpf, DataNascimento, Genero, NomeMae, Efetivo) " +
                    "VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, func.getNome());
            st.setString(2, func.getCpf());
            st.setDate(3, new Date(func.getDataNascimento().getTime()));
            st.setString(4, func.getGenero());
            st.setString(5, func.getNomeMae());
            st.setBoolean(6, func.isEfetivo());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    long id = rs.getInt(1);
                    func.setCodigo(id);
                }
                ConnectionFactory.closeResultSet(rs);
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
        }
    }

    @Override
    public void update(Funcionarios func) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE funcionario " +
                            "SET Nome = ?, Cpf = ?, DataNascimento = ?, Genero = ?, NomeMae = ?, Efetivo = ? " +
                            "WHERE Codigo = ?");

            st.setString(1, func.getNome());
            st.setString(2, func.getCpf());
            st.setDate(3, new Date(func.getDataNascimento().getTime()));
            st.setString(4, func.getGenero());
            st.setString(5, func.getNomeMae());
            st.setBoolean(6, func.isEfetivo());
            st.setLong(7, func.getCodigo());

            st.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM funcionario WHERE Codigo = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
        }
    }

    @Override
    public Funcionarios findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM funcionario WHERE codigo = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                return instantiateFuncionarios(rs);
            }
            return null;
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }

    private Funcionarios instantiateFuncionarios(ResultSet rs)  throws SQLException{
        Funcionarios func = new Funcionarios();
        func.setCodigo(rs.getLong("codigo"));
        func.setNome(rs.getString("nome"));
        func.setCpf(rs.getString("cpf"));
        func.setDataNascimento(rs.getDate("dataNascimento"));
        func.setGenero(rs.getString("genero"));
        func.setNomeMae(rs.getString("nomeMae"));
        func.setEfetivo(rs.getBoolean("efetivo"));
        return func;
    }

    @Override
    public List<Funcionarios> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM funcionario ORDER BY Nome");

            rs = st.executeQuery();

            List<Funcionarios> list = new ArrayList<>();
            Map<Integer, Funcionarios> map = new HashMap<>();

            while (rs.next()) {

                Funcionarios func = map.get(rs.getInt("Codigo"));

                if (func == null) {
                    func = instantiateFuncionarios(rs);
                    map.put(rs.getInt("Codigo"), func);
                }

                list.add(func);
            }
            return list;
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeStatement(st);
            ConnectionFactory.closeResultSet(rs);
        }
    }
}
