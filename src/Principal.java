import Model.Funcionarios;
import dao.DaoFactory;
import dao.FuncionariosDao;

import java.io.IOException;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws IOException {

        FuncionariosDao funcionariosDao = DaoFactory.createFuncionarioDao();

        System.out.println("=== Test 1: findById ===");
        Funcionarios funcionarios = funcionariosDao.findById(2);
        System.out.println(funcionarios);

        System.out.println("\n=== Test 2: findAll ===");
        List<Funcionarios> list = funcionariosDao.findAll();
        for(Funcionarios func : list){
            System.out.println(func);
        }

    }

}