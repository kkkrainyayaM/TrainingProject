package by.javatr.project.views;

import static by.javatr.project.validations.Validator.isNull;

public class ViewUsers {

    public void show(String users) {
        if( !isNull( users ) ) {
            System.out.println( "Зарегистрированные пользователи:" );
            System.out.println( users );
        }
    }
}
