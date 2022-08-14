package dao;

import dao.impl.FuncionariosDaoJDBC;

public class DaoFactory {

    public static FuncionariosDao createFuncionarioDao(){
        return new FuncionariosDaoJDBC(ConnectionFactory.getConnection());
    }
}
