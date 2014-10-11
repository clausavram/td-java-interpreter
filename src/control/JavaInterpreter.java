package control;

import grammar.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Claudiu on 10/10/2014
 */
public class JavaInterpreter {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        org.antlr.v4.runtime.ANTLRInputStream in = null;
        if (args.length == 0) {
            System.err.println("Error: at least the start symbol must be specified (ex: 'start')");
            System.exit(1);
        } else if (args.length == 1) {
            in = new ANTLRInputStream(System.in);
        } else {
            in = new ANTLRInputStream(new FileReader(args[1]));
        }
        String startSymbol = args[0];
        JavaLexer lexer = new JavaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        JavaParser.StartContext parseResult = callStartProduction(parser.getClass(), parser, startSymbol);// parser.start();
//        System.out.println("Result = " + parseResult.value);
        System.out.println("Program ended successfully");
    }

    private static JavaParser.StartContext callStartProduction(Class<? extends Parser> parserClass, Parser parser, String startSymbol) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method startProductionMethod = parserClass.getDeclaredMethod(startSymbol);
        return (JavaParser.StartContext) startProductionMethod.invoke(parser);
    }
}
