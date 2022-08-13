package dao;

import Model.Funcionarios;

import java.util.List;

public interface FuncionariosDao {

    void insert(Funcionarios func);
    void update(Funcionarios func);
    void deleteById(Integer id);
    Funcionarios findById(Integer id);
    List<Funcionarios> findAll();
}
