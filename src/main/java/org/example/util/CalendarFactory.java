package org.example.util;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class CalendarFactory implements FactoryBean<Calendar> {

    // This is a static instance that can be use anywhere inside our application.
    //* The main idea of this is to be able to inject a static object or any object that we cannot change the code, thus, can't do setter or construct injection, but wanted to have just one in the application, like Calendar. This Factory helps to reference the static instance and inject it to anywhere that we want to access, manipulate the static instance.
    private Calendar instance = Calendar.getInstance();
    @Override
    public Calendar getObject() throws Exception {
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    public void addDays(int num){
        instance.add(Calendar.DAY_OF_YEAR, num);
    }
}
