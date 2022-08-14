import Model.Funcionarios;
import dao.DaoFactory;
import dao.FuncionariosDao;

import java.io.IOException;
import java.util.Date;
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

        System.out.println("\n=== Test 3: insert ===");
        Funcionarios novoFuncionario = new Funcionarios(null, "Roberto", "111.222.333-44", new Date(2/7/2006), "Masculino", "Roberta", true);
        funcionariosDao.insert(novoFuncionario);
        System.out.println("Novo funcionario cadastrado! Seu código é = "+novoFuncionario.getCodigo());

        System.out.println("\n=== Test 4: update ===");
        funcionarios = funcionariosDao.findById(1);
        funcionarios.setNome("Joaquim");
        funcionariosDao.update(funcionarios);
        System.out.println("Update concluido");

        System.out.println("\n=== Test 5: delete ===");
        funcionariosDao.deleteById(4);
        System.out.println("Delete concluido");
    }

}