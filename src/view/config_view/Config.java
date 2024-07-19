package view.config_view;

import view.simulator_view.View;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<Integer, String> menuAluno;
    private Map<Integer, String> menuAdmin;
    private Map<Integer, String> menuInicial;
    private Map<Integer, String> menuRequest;
    private Map<String, String> menuIndice;
    private Map<String, Map<Integer, String>> allMenu = new HashMap<>();
    private Map<String, String[]> mapAction;


    void inscreveCurso() {
        System.out.println("Escolha uma operação:");
        System.out.println("1. Criar");
        System.out.println("2. Ler");
        System.out.println("3. Atualizar");
        System.out.println("4. Excluir");
        System.out.println("5. Sair");

    }

    public Map<Integer, String> getMenuRequest() {
        return this.menuRequest;
    }

    public void setMenuRequest() {
        this.menuRequest = new HashMap<>();
               this.menuRequest.put(0, "Menu 3 - ");
               this.menuRequest.put(1, "1. Criar");
               this.menuRequest.put(2, "2. Adicionar");
               this.menuRequest.put(3, "3. Procurar");
               this.menuRequest.put(4, "4. Listar");
               this.menuRequest.put(5, "5. Atualizar");
               this.menuRequest.put(6, "6. Deletar");
               this.menuRequest.put(7, "Digite a Opção: ");

    }

    public Map<String, String> getMenuIndice() {
        return this.menuIndice;
    }

    public void setMenuIndice() {
        this.menuIndice = new HashMap<>();
        this.menuIndice.put("indice", "Menu Indice");
        this.menuIndice.put("Criar", "create");
        this.menuIndice.put("Adicionar", "add");
        this.menuIndice.put("Procurar", "getById");
        this.menuIndice.put("Listar", "getAll");
        this.menuIndice.put("Atualizar", "update");
        this.menuIndice.put("Deletar", "delete");
    }

    public Map<Integer, String> getMenuInicial() {
        return this.menuInicial;
    }

    public void setMenuInicial() {
        this.menuInicial = new HashMap<>();
        this.menuInicial.put(0, "Menu 1 - ");
        this.menuInicial.put(1, "1. Aluno");
        this.menuInicial.put(2, "2. Admin");
        this.menuInicial.put(3, "3. Sair");
        this.menuInicial.put(4, "Digite a Opção: ");

    }

    public Map<Integer, String> getMenuAluno() {
        return this.menuAluno;
    }

    public void setMenuAluno() {
        this.menuAluno = new HashMap<>();
        this.menuAluno.put(0, "Menu 2 - ");
        this.menuAluno.put(1, "1. Bootcamp");
        this.menuAluno.put(2, "2. Curso");
        this.menuAluno.put(3, "3. Dev");
        this.menuAluno.put(4, "4. Sair");
        this.menuAluno.put(5, "Digite a Opção: ");

    }

    public Map<Integer, String> getMenuAdmin() {
        return this.menuAdmin;
    }

    public void setMenuAdmin() {
        this.menuAdmin = new HashMap<>();
        this.menuAdmin.put(0, "Menu 2 - ");
        this.menuAdmin.put(1, "1. Bootcamp");
        this.menuAdmin.put(2, "2. Curso");
        this.menuAdmin.put(3, "3. Dev");
        this.menuAdmin.put(4, "4. Conteudo");
        this.menuAdmin.put(5, "5. Mentoria");
        this.menuAdmin.put(6, "6. Sair");
        this.menuAdmin.put(7, "Digite a Opção: ");

    }

    public Map<String, Map<Integer, String>> getAllMenu() {
        return this.allMenu;
    }

    public void setAllMenu() {
        setMenuInicial();
        setMenuAluno();
        setMenuAdmin();
        setMenuRequest();
        this.allMenu = new HashMap<>();
        this.allMenu.put("Inicial", getMenuInicial());
        this.allMenu.put("Aluno", getMenuAluno());
        this.allMenu.put("Admin", getMenuAdmin());
        this.allMenu.put("Request", getMenuRequest());
    }
    public Map<String, String[]> getMapAction() {
        return this.mapAction;
    }

    public void setMapAction(String objectRequest) {
        View view = new View();
        this.mapAction = new HashMap<>();
        mapAction.put("create", view.createRequest(objectRequest));
        mapAction.put("add", view.scanNameDescription(objectRequest));
        mapAction.put("getById", view.scanId(objectRequest));
        mapAction.put("getAll", view.scanGetAll(objectRequest));
        mapAction.put("update", view.scanNameDescription(objectRequest));
        mapAction.put("delete", view.scanId(objectRequest));
    }

    private String actionRequest() {

        return "";
    }

}
