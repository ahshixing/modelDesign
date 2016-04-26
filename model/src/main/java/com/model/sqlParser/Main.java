package com.model.sqlParser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;

import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by shixing on 2016/4/11.
 */
public class Main {
    public static void main(String args[]){
//        CCJSqlParserManager spm = new CCJSqlParserManager();
//        try {
//            Select select = (Select) spm.parse(new StringReader("select * from abc where name='test'"));
//            SelectBody selectBody = select.getSelectBody();
//            System.out.println(selectBody.toString());
//        } catch (JSQLParserException e) {
//            e.printStackTrace();
//        }
        double x, z;
        double lamda;

        System.out.println("请输入lamda的值：");
        Scanner scanner = new Scanner(System.in);
        lamda = scanner.nextDouble();

        for(int i=0; i<10; i++) {
            z = Math.random();
            x = -(1 / lamda) * Math.log(z);
            System.out.println(x);
        }
    }
}
