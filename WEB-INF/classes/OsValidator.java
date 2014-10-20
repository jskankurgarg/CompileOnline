import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OsValidator {
 
	public static void main(String[] args) {
		if (isWindows()) {
			System.out.println("This is Windows");
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
		} else {
			System.out.println("Your OS is not support!!");
		}
		System.out.println(System.getProperty("os.name"));
		String osVersion= System.getProperty("os.version");
		System.out.println("Operating system version =>"+ osVersion);
		String osArch=System.getProperty("os.arch");
		System.out.println("OS architecture = > "+osArch);
//		System.out.println(System.getProperty("os400.runtime.exec"));
		System.out.println(System.getProperty("path.separator"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		String str=baos.toString();
		System.out.println("captured output : \n"+str);
	}
 
	public static boolean isWindows() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// windows
		return (os.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Mac
		return (os.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// linux or unix
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
 
	}
 
	public static boolean isSolaris() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Solaris
		return (os.indexOf("sunos") >= 0);
 
	}
 
}