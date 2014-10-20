package com.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Controller{
	public Result compile(String code) throws IOException{
		Compiler com=new JavaCompiler();
		System.out.println("compiling .....");
		Result result=com.doCompile(code);
		System.out.println("###########################################");
		System.out.println(result.getResultStatus());
		System.out.println("###########################################");
		if(result.getExitValue()==0){
			Executer jvm=new JavaExecuter();
			System.out.println("Executing .....");
			Result executeResult=jvm.doExecute("Main");
			System.out.println("###########################################");
			System.out.println(executeResult);
			System.out.println("###########################################");
			result.setExitValue(executeResult.getExitValue());
			result.setOutput(result.getOutput()+executeResult.getOutput());
			result.setResultStatus(result.getResultStatus()+"\n"+executeResult.getResultStatus());
		}
		return result;
	}
	public static void main(String...args) throws IOException{
		/*
		 * code will be received as form parameter.
		 */
			Controller ctrl=new Controller();
			char sc=File.separatorChar;
			File codeFile=new File("compiler"+sc+"sample.java");
			byte[] codeBuffer=new byte[(int) codeFile.length()];
			FileInputStream inputFile=new FileInputStream(codeFile);
			inputFile.read(codeBuffer);
			String code=new String(codeBuffer);
			//System.out.println("@@@@"+code+"@@@@");
			Result result=ctrl.compile(code);
			System.out.println("!!!!!!!!!!!\n"+result);
		}
	public void generateInputFile(String input){
		FileSystem fs=new FileSystem();
		fs.generateFile(input, "input");
	}
}