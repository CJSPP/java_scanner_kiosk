package org.example;

public class Product extends Menu {



    private double price;

    /*burger의 이름, 가격, 설명을 파라미터로 갖는 생성자 Product가
     *호출 되었고 부모 객체인 Menu를 호출하는 클래스
     * 조건에서 가격만 Product 클래스이고 Menu클래스의 name, comment를 부모
     * 클래스에서 받아와서 사용한다.*/
    public Product(String name, double price, String comment) {
        super(name, comment);
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

}
