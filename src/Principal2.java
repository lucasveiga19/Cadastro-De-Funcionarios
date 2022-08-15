import Model.Funcionarios;
import dao.DaoFactory;
import dao.FuncionariosDao;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Principal2 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        FuncionariosDao funcionariosDao = DaoFactory.createFuncionarioDao();

        System.out.println("Sistema de Cadastro de Funcionarios");
        System.out.println("Escolha uma funcionalidade (Insert, Delete, Update, findByEfetivo, findById, findAll):");
        String escolha = input.nextLine();

        if(Objects.equals(escolha, "findById")){
            System.out.println("=== findById ===");

            System.out.print("Digite o Id a ser buscado: ");
            Funcionarios funcionarios = funcionariosDao.findById(input.nextInt());
            System.out.println(funcionarios);

        } else if (Objects.equals(escolha, "findAll")) {
            System.out.println("=== findAll ===");

            List<Funcionarios> list = funcionariosDao.findAll();
            for(Funcionarios func : list){
                System.out.println(func);
            }

        } else if (Objects.equals(escolha, "Insert")){
            System.out.println("=== Insert ===");

            Long codigo = null;
            System.out.print("Digite o Nome: ");
            String nome = input.nextLine();
            System.out.print("Digite o CPF: ");
            String cpf = input.nextLine();
            System.out.print("Digite a Data de Nascimento: ");
            String data = input.nextLine();
            System.out.print("Digite o Gênero: ");
            String genero = input.nextLine();
            System.out.print("Digite o Nome da Mãe: ");
            String nomeMae = input.nextLine();
            System.out.print("Digite true ou false caso seja Ativo: ");
            Boolean efetivo = input.nextBoolean();
            Funcionarios novoFuncionario = new Funcionarios(codigo, nome, cpf, new Date(data), genero, nomeMae, efetivo);
            funcionariosDao.insert(novoFuncionario);
            System.out.println("Novo funcionario cadastrado! Seu código é = "+novoFuncionario.getCodigo());

        } else if (Objects.equals(escolha, "Update")) {
            System.out.println("=== Update === (Caso não preencha a data, é possivel obter um erro)");

            System.out.print("Digite o Código de quem deseja alterar: ");
            Funcionarios funcionarios = funcionariosDao.findById(input.nextInt());
            input.nextLine();
            System.out.print("Digite o Nome: ");
            funcionarios.setNome(input.nextLine());
            System.out.print("Digite o CPF: ");
            funcionarios.setCpf(input.nextLine());
            System.out.print("Digite a Data de Nascimento: ");
            funcionarios.setDataNascimento(new Date(input.nextLine()));
            System.out.print("Digite o Gênero: ");
            funcionarios.setGenero(input.nextLine());
            System.out.print("Digite o Nome da Mãe: ");
            funcionarios.setNomeMae(input.nextLine());
            System.out.print("Digite true ou false caso seja Efetivo: ");
            funcionarios.setEfetivo(input.nextBoolean());
            funcionariosDao.update(funcionarios);
            System.out.println("Update concluido");

        } else if (Objects.equals(escolha, "Delete")) {
            System.out.println("=== Delete ===");

            System.out.print("Digite o Código de quem deseja deletar: ");
            funcionariosDao.deleteById(input.nextInt());
            System.out.println("Delete concluido");

        } else if (Objects.equals(escolha, "findByEfetivo")) {
            System.out.println("=== findByEfetivo ===");

            System.out.print("Digite true ou false para listar os Efetivos: ");
            List<Funcionarios> list = funcionariosDao.findByEfetivo(input.nextBoolean());
            for(Funcionarios func : list){
                System.out.println(func);
            }
        }
    }
}
