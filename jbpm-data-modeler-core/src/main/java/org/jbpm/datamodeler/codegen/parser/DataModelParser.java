package org.jbpm.datamodeler.codegen.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jbpm.datamodeler.codegen.parser.tokens.DataObjectToken;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class DataModelParser {

    private CharStream charStream;

    private boolean error = false;

    public DataModelParser(CharStream charStream) {
        this.charStream = charStream;
    }

    public DataModelParser(String contents) throws IOException {
        this(new ANTLRInputStream(new StringReader(contents)));
    }

    public DataObjectToken parse() throws Exception {
        return parseDataObject(charStream);
    }

    public boolean hasErros() {
        //TODO implement error handling
        return error;
    }

    public List getErrors() {
        //TODO implement error handling
        return null;
    }

    private DataObjectToken parseDataObject(CharStream charStream) {

        //TODO implement parse error handling

        //read the tokens
        JavaLexer lexer = new JavaLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //parse the tokens to get the AST
        JavaParser parser = new JavaParser(tokens);
        ParserRuleContext tree = parser.compilationUnit();

        //create the tree walker to walk the AST
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker

        //create the listener that are going to read the data object info.
        DataObjectListener extractor = new DataObjectListener(parser);

        //finally walk the structure
        walker.walk(extractor, tree);

        return extractor.getDataObjectToken();
    }
}