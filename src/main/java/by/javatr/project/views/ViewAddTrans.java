package by.javatr.project.views;

import by.javatr.project.entities.TransCategory;

import java.util.Scanner;

public class ViewAddTrans {
    private float sum;

    private int category;

    public void show() {
        System.out.println( "Выберите категорию:\n1.Доход.\n2.Оплата питания\n3.Оплата дома\n4.Оплата услуг\n5.Оплата одежды\n6.Оплата машины\n7.Другое" );
        Scanner scanner = new Scanner( System.in );
        category = scanner.nextInt();
        System.out.println( "Введите сумму:" );
        sum = scanner.nextFloat();
    }

    public float getSum(){
        return sum;
    }

    public TransCategory getCategory(){
        TransCategory cat = null;
        switch (category){
            case 1:{
                cat = TransCategory.INCOME; break;
            }
            case 2:{
                cat = TransCategory.EXPENSE_NUTRITION; break;
            }
            case 3:{
                cat = TransCategory.EXPENSE_HOUSE; break;
            }
            case 4: {
                cat = TransCategory.EXPENSE_SERVICES; break;
            }
            case 5:{
                cat = TransCategory.EXPENSE_CLOTHES; break;
            }
            case 6:{
                cat = TransCategory.EXPENSE_CAR; break;
            }
            case 7:{
                cat  = TransCategory.EXPENSE_OTHER; break;
            }

        }
        return cat;
    }

}
