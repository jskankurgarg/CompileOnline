package com.compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class JavaExecuter implements Executer {

	@SuppressWarnings("finally")
	@Override
	public Result doExecute(String fileName,long timeLimit) {
		Result result=new Result();
		String buffer="";
		String error="";
		String output="";
		char psc=File.pathSeparatorChar;
		timeLimit=timeLimit*1000;
		System.out.println(">>>>>>>------------------time limit ---->"+timeLimit);
		try {
			/*
			*@tomcat root folder
			*java -cp webapps\test\WEB-INF\classes;. OsValidator
			*/
			String command="java -cp webapps"+FileSystem.sp+"test"+FileSystem.sp+"compiler;. "+fileName;
			final TimeLimitProcess pro=new TimeLimitProcess(Runtime.getRuntime().exec(command),timeLimit);
			//error = printLines("Runtime Error :", pro.getErrorStream());
			System.out.println("command-->"+command);
			String line=null;
			OutputStream outputstream = pro.getOutputStream();
			
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
			BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
			String inputLoc=FileSystem.appRoot+FileSystem.sp+"compiler"+FileSystem.sp+"input.txt";
			System.out.println("input file location : "+inputLoc);
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(inputLoc)));//new FileInputStream("compiler/input.txt")
			lineBreak();
			/*
			 * writing to stdin from input.txt
			 */
			System.out.println("standard input from user : ");
			while ( (line = br.readLine()) != null){
				  	bufferedwriter.write(line+"\n");
				  	bufferedwriter.flush();
				  	System.out.println("["+line+"]");
				  	buffer+=line;
			  }
			  lineBreak();
			  bufferedwriter.flush();
			  bufferedwriter.close();
			  final java.util.List<String> list=new java.util.ArrayList<String>();
			  Thread outputThread=new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						list.add(printLines("Output : ", pro.getInputStream()));
					}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			  });
			  outputThread.start();
			  //output = printLines("Output : ", pro.getInputStream());
			  error=printLines("Error : ", pro.getErrorStream());
			  //output = printLines("Output : ", pro.getInputStream());
			  outputThread.join();
			  result.setExitValue(pro.waitFor());
			  System.out.println("exitValue -->"+result.getExitValue());
			  output=list.get(0);
			  FileSystem fs=new FileSystem();
			  fs.removeFiles();
			  lineBreak();
			  output=(output.length()==0)?"":""+output;
			  //System.out.println("after execution buffer : "+buffer);
		    if(result.getExitValue()==0){
		    	result.setResultStatus("run status : success\n");
		    }
		    else{
		    	if(error.length()==0)
		    		result.setResultStatus("run status : execution period exceeded the time-limit\n");
		    	else
		    		result.setResultStatus("run status : runtime error\n");
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			result.setOutput(output+error);
			//System.out.println(result);
			lineBreak();
			return result;
		}		
	}
	private String printLines(String messageType, InputStream ins) throws IOException {
	    String line = null;
	    String buffer="";
	    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
	    while ((line = in.readLine()) != null) {
	        System.out.println(messageType+ " " + line);
	        buffer+=line+"\n";
	    }
	    lineBreak();
	    //System.out.println("buffer-->"+buffer+"\tinside printLine");
		return buffer;
	}
	private void lineBreak(){
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
	public static void main(String...asd){
		long timeLimit=2;//in seconds
		new JavaExecuter().doExecute("Main",timeLimit);
	}
}