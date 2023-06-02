package org.example;

public class Menu {

    /*해당 값을 변수로 접근하면 보안의 문제가 있기 때문에 private으로 설정하고
     오직 메소드를 통해서만 접근하게 해야한다.(캡슐화)*/
    private String name;
    private String comment;

    public Menu(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {

        return name;
    }

    public String getComment() {

        return comment;
    }
}
