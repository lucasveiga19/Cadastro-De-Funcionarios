import Model.Funcionarios;
import dao.DaoFactory;
import dao.FuncionariosDao;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {

        FuncionariosDao funcionariosDao = DaoFactory.createFuncionarioDao();

        Funcionarios funcionarios = funcionariosDao.findById(2);

        System.out.println(funcionarios);

    }

}