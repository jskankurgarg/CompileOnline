package com.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaCompiler implements Compiler{
	public static final String fileName="Main.java";
	@Override
	public Result doCompile(String code){
		FileSystem fs=new FileSystem();
		String error="";
		//System.out.println("code received inside JavaCompiler : "+code);
		String fileName=fs.generateFile(code,JavaCompiler.fileName);
		/*
		@tomcat root folder
		javac -d . webapps\test\WEB-INF\classes\OsValidator.java
		*/
		String command="javac webapps"+FileSystem.sp+"test"+FileSystem.sp+"compiler"+FileSystem.sp+fileName;
		Result result=new Result();
		Process pro = null;
		try {
			
			pro = Runtime.getRuntime().exec(command);
			lineBreak();
			error = printLines("Error :", pro.getErrorStream());
			//output = printLines("Output :", pro.getInputStream());
			error=(error.length()==0)?"":"Error : "+error;
			//output=(output.length()==0)?"":"Output : "+output+"\n";
		    result.setExitValue(pro.waitFor());
		    if(result.getExitValue()==0){
		    	result.setResultStatus("Compilation status : success\n");
		    }
		    else{
		    	result.setResultStatus("Compilation status : failed\n");
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			result.setOutput(error);
		}
	    System.out.println(command + "------exitValue() " + pro.exitValue()+"-------");
		return result;
	}

	private String printLines(String messageType, InputStream ins) throws IOException {
	    String line = null;
	    String buffer="";
	    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
	    while ((line = in.readLine()) != null){
	        System.out.println(messageType+ " " + line);
	        buffer+=line+"\n";
	    }
	    String result=buffer.trim().length()==0?"No errors...\n":"errors found....\n";
	    System.out.print(result);
	    lineBreak();
		return buffer;
	}
	private void lineBreak(){
		System.out.println("cccccccccccccccccccccccccccccccccccccccccccc");
	}
}