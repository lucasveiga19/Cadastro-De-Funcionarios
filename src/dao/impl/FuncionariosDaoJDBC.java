package dao.impl;

import Model.Funcionarios;
import dao.ConnectionFactory;
import dao.FuncionariosDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    }

    @Override
    public void update(Funcionarios func) {

    }

    @Override
    public void deleteById(Integer id) {

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
        func.setDataNascimento(rs.getString("dataNascimento"));
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
